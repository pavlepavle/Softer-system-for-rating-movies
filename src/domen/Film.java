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
public class Film extends OpstiDomenskiObjekat implements Serializable {

    private int filmID;
    private String naziv;
    private int godina;
    private String opis;
    private int duzinaTrajanja;
    private int brojUloga;
    private List<Zanr> listaZanrova;
    private List<Uloga> listaUloga;

    public Film() {
        listaZanrova = new ArrayList<>();
        listaUloga = new ArrayList<>();
    }

    public Film(int filmID, String naziv, int godina, String opis, int duzinaTrajanja, int brojUloga, List<Zanr> listaZanrova, List<Uloga> listaUloga) {
        this.filmID = filmID;
        this.naziv = naziv;
        this.godina = godina;
        this.opis = opis;
        this.duzinaTrajanja = duzinaTrajanja;
        this.brojUloga = brojUloga;
        this.listaZanrova = listaZanrova;
        this.listaUloga=listaUloga;
    }

    @Override
    public String vratiNazivTabele() {
        return "film";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "("+ filmID +"," + "'" + naziv + "'," + godina + ",'" + opis + "'," + brojUloga + "," + duzinaTrajanja + ")";
    }

    @Override
    public String vratiVrednostZaDelete() {
        return " where FilmID="+filmID;
    }

    @Override
    public String vratiVrednostZaJoin() {
        return " f INNER JOIN filmzanr fz ON f.filmid=fz.filmid INNER JOIN zanr z ON fz.zanrid=z.zanrid INNER JOIN uloga u ON f.filmid=u.filmid order by f.filmid";
    }

    @Override
    public String vratiVrednostZaSelect() {
        return " where Naziv='" + naziv + "' AND Godina=" + godina;
    }

    @Override
    public boolean daLiJeSlozen() {
        return true;
    }

    @Override
    public void unesiSlozen(OpstiDomenskiObjekat odo, Statement st) throws Exception {
        Film f = (Film) odo;
        for (Zanr z : f.getListaZanrova()) {
            String upit = "insert into filmzanr values (" + f.getFilmID() + "," + z.getZanrID() + ")";
            System.out.println(upit);
            st.executeUpdate(upit);
        }
        for (Uloga u: f.getListaUloga()) {
            String upit = "insert into uloga values (" + "0" + ", '" + u.getImeUloge() + "', '" + u.getVrstaUloge() + "', '" + u.getImePrezimeOsobe() +"', "+ f.filmID+")";
            System.out.println(upit);
            st.executeUpdate(upit);
        }
    }

    @Override
    public String vratiVrednostZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getDuzinaTrajanja() {
        return duzinaTrajanja;
    }

    public void setDuzinaTrajanja(int duzinaTrajanja) {
        this.duzinaTrajanja = duzinaTrajanja;
    }

    public int getFilmID() {
        return filmID;
    }

    public List<Zanr> getListaZanrova() {
        return listaZanrova;
    }

    public void setListaZanrova(List<Zanr> listaZanrova) {
        this.listaZanrova = listaZanrova;
    }

    public int getBrojUloga() {
        return brojUloga;
    }

    public void setBrojUloga(int brojUloga) {
        this.brojUloga = brojUloga;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
//        List<OpstiDomenskiObjekat> listaFilmova = new ArrayList<>();
//        try {
//            while (rs.next()) {
//                int id = rs.getInt("FilmID");
//                String naziv = rs.getString("Naziv");
//                int godina = rs.getInt("Godina");
//                String opis = rs.getString("Opis");
//                int brojUloga = rs.getInt("BrojUloga");
//                int duzinaTrajanja = rs.getInt("DuzinaTrajanja");
//                int korId = rs.getInt("KorisnikID");
//                String username = rs.getString("username");
//                String password = rs.getString("password");
//                Boolean admin = rs.getBoolean("Administrator");
//                Korisnik k  = new Korisnik(korId,username,password,admin);
//                Film f = new Film(id, naziv, godina, opis, duzinaTrajanja, brojUloga, k);
//                f.getListaZanrova().add(new Zanr(rs.getInt("ZanrID"), rs.getString("Naziv")));
//                if (!listaFilmova.contains(f)) {
//                    listaFilmova.add(f);
//                }
//            }
//            rs.close();
//        } catch (Exception e) {
//            System.out.println("Greska pri vracanju korisnika " + e.getMessage());
//        }
//        return listaFilmova;

        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        int idPrethodnog = -1;
        try {
            while (rs.next()) {
                if (idPrethodnog == -1) {

                    int id = rs.getInt("f.FilmID");
                    String naziv = rs.getString("f.Naziv");
                    int godina = rs.getInt("f.Godina");
                    String opis = rs.getString("f.Opis");
                    int brojUloga = rs.getInt("f.BrojUloga");
                    int duzinaTrajanja = rs.getInt("f.DuzinaTrajanja");
                    Film f = new Film(id, naziv, godina, opis, duzinaTrajanja, brojUloga, new ArrayList<>(),new ArrayList<>());
                    Zanr z = new Zanr(rs.getInt("z.ZanrID"), rs.getString("z.naziv"));
                    Uloga u = new Uloga(rs.getInt("u.UlogaID"), rs.getString("u.ImeUloge"),rs.getString("u.VrstaUloge"),rs.getString("u.ImePrezime"), f);
                    if (!f.getListaZanrova().contains(z)) {
                        f.getListaZanrova().add(z);
                    }
                    if (!f.getListaUloga().contains(u)) {
                        f.getListaUloga().add(u);
                    }
                    lista.add(f);

                    idPrethodnog = rs.getInt("f.FilmID");
                } else if (idPrethodnog == rs.getInt("f.filmID")) {
                    Film f = (Film) lista.get(lista.size() - 1);
                    Zanr z = new Zanr(rs.getInt("z.ZanrID"), rs.getString("z.naziv"));
                    Uloga u = new Uloga(rs.getInt("u.UlogaID"), rs.getString("u.ImeUloge"),rs.getString("u.VrstaUloge"),rs.getString("u.ImePrezime"), f);
                    if (!f.getListaZanrova().contains(z)) {
                        f.getListaZanrova().add(z);
                    }
                    if (!f.getListaUloga().contains(u)) {
                        f.getListaUloga().add(u);
                    }
                } else {
                    int id = rs.getInt("f.FilmID");
                    String naziv = rs.getString("f.Naziv");
                    int godina = rs.getInt("f.Godina");
                    String opis = rs.getString("f.Opis");
                    int brojUloga = rs.getInt("f.BrojUloga");
                    int duzinaTrajanja = rs.getInt("f.DuzinaTrajanja");
                    Film f = new Film(id, naziv, godina, opis, duzinaTrajanja, brojUloga, new ArrayList<>(), new ArrayList<>());
                    Zanr z = new Zanr(rs.getInt("z.ZanrID"), rs.getString("z.naziv"));
                    Uloga u = new Uloga(rs.getInt("u.UlogaID"), rs.getString("u.ImeUloge"),rs.getString("u.VrstaUloge"),rs.getString("u.ImePrezime"), f);
                    if (!f.getListaZanrova().contains(z)) {
                        f.getListaZanrova().add(z);
                    }
                    if (!f.getListaUloga().contains(u)) {
                        f.getListaUloga().add(u);
                    }
                    lista.add(f);
                    idPrethodnog = rs.getInt("f.filmid");
                }
            }
        } catch (Exception e) {
            System.out.println("Greska pri vracanju liste filmova " + e.getMessage());
        }
        System.out.println(lista);
        return lista;

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Film)) {
            return false;
        }
        Film f = (Film) obj;
        return f.getNaziv().equalsIgnoreCase(naziv) && f.getGodina() == godina;
    }

    public List<Uloga> getListaUloga() {
        return listaUloga;
    }

    public void setListaUloga(List<Uloga> listaUloga) {
        this.listaUloga = listaUloga;
    }
}