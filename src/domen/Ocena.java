/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pavlepavle
 */
public class Ocena extends OpstiDomenskiObjekat implements Serializable {

    private int ocena;
    private Korisnik korisnik;
    private Film film;

    public Ocena(int ocena, Korisnik korisnik, Film film) {
        this.ocena = ocena;
        this.korisnik = korisnik;
        this.film = film;
    }

    public Ocena() {
    }

    @Override
    public String vratiNazivTabele() {
        return "ocena";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "(" + korisnik.getKorisnikID() + ", " + film.getFilmID() + ", " + ocena + ")";
    }

    @Override
    public String vratiVrednostZaDelete() {
        throw new UnsupportedOperationException("Not supported yet.del"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostZaJoin() {
        return " o inner join film f on o.filmid=f.filmid order by o.filmid";
    }

    @Override
    public String vratiVrednostZaSelect() {
        return " where FilmID=" + film.getFilmID() + " and KorisnikID=" + korisnik.getKorisnikID();
    }

    @Override
    public boolean daLiJeSlozen() {
        return false;
    }

    @Override
    public void unesiSlozen(OpstiDomenskiObjekat odo, Statement st) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.us"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostZaUpdate() {
        return "set Ocena=" + ocena + " where KorisnikID=" + korisnik.getKorisnikID() + " and FilmID=" + film.getFilmID();
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();

        try {
            while (rs.next()) {
                int korisnikid = rs.getInt("o.korisnikID");
                int filmid = rs.getInt("o.filmid");
                int ocena = rs.getInt("o.ocena");
                Korisnik k = new Korisnik();
                k.setKorisnikID(korisnikid);
                Film f = new Film(filmid, rs.getString("Naziv"), rs.getInt("Godina"), rs.getString("opis"), rs.getInt("DuzinaTrajanja"), rs.getInt("BrojUloga"), new ArrayList<>(), new ArrayList<>());
                Ocena o = new Ocena(ocena, k, f);
                lista.add(o);
            }
        } catch (Exception e) {
            System.out.println("Greska pri vracanju liste ocena " + e.getMessage());
        }
        System.out.println(lista);
        return lista;
    }

}
