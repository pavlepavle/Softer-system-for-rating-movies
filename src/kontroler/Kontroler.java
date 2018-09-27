/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Film;
import domen.Korisnik;
import domen.Ocena;
import domen.Zanr;
import dto.KlijentTransferObjekat;
import dto.ServerTransferObjekat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import util.Util;

/**
 *
 * @author pavlepavle
 */
public class Kontroler {

    private static Kontroler instanca;
    private Map<String, Object> mapa;

    private Kontroler() throws IOException {
        mapa = new HashMap();
    }

    public Map getMapa() {
        return mapa;
    }

    public void setMapa(Map mapa) {
        this.mapa = mapa;
    }

    public static Kontroler vratiInstancu() throws IOException {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public void zapamti(Korisnik k) throws Exception {
        try {
            Socket s = (Socket) mapa.get(Util.MAP_KEY_SOKET);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.SACUVAJ_KORISNIKA);
            kto.setParametar(k);
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            if (sto.getStatus() == Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
                throw new Exception(sto.getGreska());
            } else {
                JOptionPane.showMessageDialog(null, sto.getRezultat().toString(), "Poruka",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void zapamti(Film f) throws Exception {
        try {
            Socket s = (Socket) mapa.get(Util.MAP_KEY_SOKET);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.SACUVAJ_FILM);
            kto.setParametar(f);
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            if (sto.getStatus() == Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
                throw new Exception(sto.getGreska());
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void pronadji(Korisnik k) throws Exception {
        try {
            Socket s = (Socket) mapa.get(Util.MAP_KEY_SOKET);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
//            out.flush();
            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.PRONADJI_KORISNIKA);
            kto.setParametar(k);
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            if (sto.getStatus() == Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
                throw new Exception(sto.getGreska());
            } else {
                JOptionPane.showMessageDialog(null, sto.getRezultat().toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Korisnik pronadjiIVrati(Korisnik k) throws Exception {
        try {
            Socket s = (Socket) mapa.get(Util.MAP_KEY_SOKET);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
//            out.flush();
            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.PRONADJI_KORISNIKA);
            kto.setParametar(k);
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            if (sto.getStatus() == Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
                throw new Exception(sto.getGreska());
            } else {
                JOptionPane.showMessageDialog(null, "Uspesno ulogovan!");
                return (Korisnik) sto.getRezultat();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean izmeniPodatkeKorisnika(Korisnik k, String username, JDialog jd) throws Exception {
        try {
            Socket s = (Socket) mapa.get(Util.MAP_KEY_SOKET);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.IZMENI_KORISNIKA);
            kto.setParametar(k);
            kto.setUsername(username);
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();

            if (sto.getStatus() == Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
                jd.dispose();
                throw new Exception(sto.getGreska());
            } else {
                JOptionPane.showMessageDialog(null, sto.getRezultat());
                return true;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Zanr> vratiListuZanrova() throws Exception {

        try {
            Socket s = (Socket) mapa.get(Util.MAP_KEY_SOKET);
            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.VRATI_LISTU_ZANROVA);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            int statusServera = sto.getStatus();
            if (statusServera == Util.SERVER_STATUS_OPERACIJA_OK) {
                List<Zanr> zanrovi = (List<Zanr>) sto.getRezultat();
                return zanrovi;
            } else if (statusServera == Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
                throw new Exception(sto.getGreska());
            }
        } catch (Exception e) {
            throw e;

        }
        return null;

    }

    public void odjavi(Korisnik korisnik) throws Exception {
        try {
            Socket s = (Socket) mapa.get(Util.MAP_KEY_SOKET);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.ODJAVI_KORISNIKA);
            kto.setParametar(korisnik);
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            if (sto.getStatus() == Util.SERVER_STATUS_OPERACIJA_OK) {
                System.out.println(sto.getRezultat());
            } else {
                throw new Exception(sto.getGreska());
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public List<Korisnik> vratiListuKorisnika() throws Exception {
        try {
            Socket s = (Socket) mapa.get(Util.MAP_KEY_SOKET);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.VRATI_LISTU_KORISNIKA);
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            int statusServera = sto.getStatus();
            if (statusServera == Util.SERVER_STATUS_OPERACIJA_OK) {
                List<Korisnik> korisnici = (List<Korisnik>) sto.getRezultat();
                return korisnici;
            } else if (statusServera == Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
                throw new Exception(sto.getGreska());
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public void unaprediKorisnika(Korisnik k) throws Exception {
        try {
            Socket s = (Socket) mapa.get(Util.MAP_KEY_SOKET);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.UNAPREDI_KORISNIKA);
            kto.setParametar(k);
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            if (sto.getStatus() == Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
                throw new Exception(sto.getGreska());
            } else {
                JOptionPane.showMessageDialog(null, sto.getRezultat());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Film> vratiListuFilmova() throws Exception {
        try {
            Socket s = (Socket) mapa.get(Util.MAP_KEY_SOKET);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.VRATI_LISTU_FILMOVA);
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            int statusServera = sto.getStatus();
            if (statusServera == Util.SERVER_STATUS_OPERACIJA_OK) {
                List<Film> filmovi = (List<Film>) sto.getRezultat();
                return filmovi;
            } else if (statusServera == Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
                throw new Exception(sto.getGreska());
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public void zapamtiOcenu(Ocena o) throws Exception {
        try {
            Socket s = (Socket) mapa.get(Util.MAP_KEY_SOKET);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.SACUVAJ_OCENU);
            kto.setParametar(o);
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            if (sto.getStatus() == Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
                throw new Exception(sto.getGreska());
            } else {
                JOptionPane.showMessageDialog(null, sto.getRezultat());
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public List<Ocena> vratiListuOcena() throws Exception {
        try {
            Socket s = (Socket) mapa.get(Util.MAP_KEY_SOKET);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.VRATI_LISTU_OCENA);
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            int statusServera = sto.getStatus();
            if (statusServera == Util.SERVER_STATUS_OPERACIJA_OK) {
                List<Ocena> ocene = (List<Ocena>) sto.getRezultat();
                return ocene;
            } else if (statusServera == Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
                throw new Exception(sto.getGreska());
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    public void obrisiFilm(Film f) throws Exception {
        try {
            Socket s = (Socket) mapa.get(Util.MAP_KEY_SOKET);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            KlijentTransferObjekat kto = new KlijentTransferObjekat();
            kto.setOperacija(Util.OBRISI_FILM);
            kto.setParametar(f);
            out.writeObject(kto);

            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
            int serverStatus = sto.getStatus();
            if (serverStatus == Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
                throw new Exception(sto.getGreska());
            } else {
                JOptionPane.showMessageDialog(null, sto.getRezultat());
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
