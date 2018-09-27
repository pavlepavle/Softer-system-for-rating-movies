/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Film;
import domen.Korisnik;
import domen.Ocena;
import domen.OpstiDomenskiObjekat;
import domen.Zanr;
import dto.KlijentTransferObjekat;
import dto.ServerTransferObjekat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import model_tabele.TblModelKorisnici;
import so.OpstaSO;
import so.SOIzmeniKorisnika;
import so.SOObrisiFilm;
import so.SONadjiKorisnika;
import so.SOZapamtiFilm;
import so.SORegistrujKorisnika;
import so.SOZapamtiOcenu;
import so.SOUnaprediKorisnika;
import so.SOVratiListuFilmova;
import so.SOVratiListuKorisnika;
import so.SOVratiListuOcena;
import so.SOVratiListuZanrova;
import util.Util;

/**
 *
 * @author pavlepavle
 */
public class NitKlijent extends Thread {

    private Socket ks;

    public NitKlijent(Socket ks) {
        this.ks = ks;
    }

    @Override
    public void run() {
        while (true) {
            ServerTransferObjekat sto = new ServerTransferObjekat();
            try {

                ObjectInputStream in = new ObjectInputStream(ks.getInputStream());
                KlijentTransferObjekat kto = (KlijentTransferObjekat) in.readObject();
                int operacija = kto.getOperacija();
                switch (operacija) {
                    case Util.SACUVAJ_KORISNIKA: {
                        try {
                            Korisnik k = (Korisnik) kto.getParametar();
                            OpstaSO so = new SORegistrujKorisnika();
                            so.izvrsi(k);
                            sto.setRezultat("Uspesna registracija");
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                            TblModelKorisnici.vratiInstancu().dodajKorisnika(k);
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    break;
                    case Util.SACUVAJ_FILM: {
                        try {
                            Film f = (Film) kto.getParametar();
                            OpstaSO so = new SOZapamtiFilm();
                            so.izvrsi(f);
                            sto.setRezultat("Sistem je uspesno sacuvao film");
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    break;
                    case Util.PRONADJI_KORISNIKA: {
                        try {
                            Korisnik k = (Korisnik) kto.getParametar();
                            OpstaSO so = new SONadjiKorisnika();
                            so.izvrsi(k);
                            OpstiDomenskiObjekat odo = ((SONadjiKorisnika) so).getOpstiDomenskiObjekat();
                            if (!k.equals(odo)) {
                                throw new Exception("Sistem ne moze da nadje korisnika na osnovu unetih vrednosti.");
                            }
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                            sto.setRezultat(odo);
                            TblModelKorisnici.vratiInstancu().postaviDaJeOnline(k);
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    break;
                    case Util.IZMENI_KORISNIKA: {
                        try {
                            Korisnik k = (Korisnik) kto.getParametar();
                            int id = k.getKorisnikID();
                            String staroKorisnickoIme = kto.getUsername();
                            OpstaSO so = new SOIzmeniKorisnika();
                            so.izvrsi(k, staroKorisnickoIme);
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                            sto.setRezultat("Uspesno promenjeni podaci!");
                            TblModelKorisnici.vratiInstancu().editKorisnika(k, id);
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    break;
                    case Util.UNAPREDI_KORISNIKA: {
                        try {
                            Korisnik k = (Korisnik) kto.getParametar();
                            int id = k.getKorisnikID();
                            String staroKorisnickoIme = kto.getUsername();
                            OpstaSO so = new SOUnaprediKorisnika();
                            so.izvrsi(k, staroKorisnickoIme);
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                            sto.setRezultat("Korisnik uspesno unapredjen!");
                            TblModelKorisnici.vratiInstancu().editKorisnika(k, id);
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    break;
                    case Util.ODJAVI_KORISNIKA: {
                        TblModelKorisnici.vratiInstancu().odjaviKorisnika((Korisnik) kto.getParametar());
                        sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                        sto.setRezultat(((Korisnik) kto.getParametar()).getKorisnickoIme() + " uspesno izlogovan.");
                    }
                    break;
                    case Util.VRATI_LISTU_KORISNIKA: {
                        OpstaSO so = new SOVratiListuKorisnika();
                        so.izvrsi(new Korisnik());
                        List<OpstiDomenskiObjekat> korisnici = ((SOVratiListuKorisnika) so).getLista();
                        sto.setRezultat(korisnici);
                        sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                    }
                    break;
                    case Util.VRATI_LISTU_FILMOVA: {
                        OpstaSO so = new SOVratiListuFilmova();
                        so.izvrsi(new Film());
                        List<OpstiDomenskiObjekat> filmovi = ((SOVratiListuFilmova) so).getLista();
                        sto.setRezultat(filmovi);
                        sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                    }
                    break;
                    case Util.VRATI_LISTU_OCENA: {
                        OpstaSO so = new SOVratiListuOcena();
                        so.izvrsi(new Ocena());
                        List<OpstiDomenskiObjekat> ocene = ((SOVratiListuOcena) so).getLista();
                        sto.setRezultat(ocene);
                        sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                    }
                    break;
                    case Util.SACUVAJ_OCENU: {
                        try {
                            Ocena o = (Ocena) kto.getParametar();
                            OpstaSO so = new SOZapamtiOcenu();
                            so.izvrsi(o);
                            sto.setRezultat("Uspesno ocenjivanje!");
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    break;
                    case Util.OBRISI_FILM: {
                        try {
                            Film f = (Film) kto.getParametar();
                            OpstaSO so = new SOObrisiFilm();
                            so.izvrsi(f);
                            sto.setRezultat("Sistem je obrisao film!");
                            sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception e) {
                            throw new Exception("Sistem ne moze da obrise film! " + e.getMessage());
                        }
                    }
                    break;
                    case Util.VRATI_LISTU_ZANROVA: {
                        OpstaSO so = new SOVratiListuZanrova();
                        so.izvrsi(new Zanr());
                        List<OpstiDomenskiObjekat> zanrovi = ((SOVratiListuZanrova) so).getLista();
                        sto.setRezultat(zanrovi);
                        sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OK);
                    }
                    break;
                }
            } catch (Exception e) {
                sto.setGreska(e.getMessage());
                sto.setStatus(Util.SERVER_STATUS_OPERACIJA_NOT_OK);
            }
            try {
                ObjectOutputStream out = new ObjectOutputStream(ks.getOutputStream());
                out.writeObject(sto);
            } catch (IOException ex) {
                System.out.println("Greska pri obradi zahteva " + ex.getMessage());
                break;
            }

        }
    }

}
