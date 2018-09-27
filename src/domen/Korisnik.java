/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pavlepavle
 */
public class Korisnik extends OpstiDomenskiObjekat implements Serializable {

    private int korisnikID;
    private String korisnickoIme;
    private String lozinka;
    private Boolean administrator;

    public Korisnik() {
    }

    public Korisnik(int korisnikID, String korisnickoIme, String lozinka, Boolean administrator) {
        this.korisnikID = korisnikID;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.administrator = administrator;
    }

    public Korisnik(String korisnickoIme, String lozinka) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        administrator = false;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public Boolean getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Boolean administrator) {
        this.administrator = administrator;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Korisnik)) {
            return false;
        }
        Korisnik a = (Korisnik) obj;
        return a.getKorisnickoIme().equals(korisnickoIme);
    }

    @Override
    public String vratiNazivTabele() {
        return "korisnik";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "(0," + "'" + korisnickoIme + "'," + "'" + lozinka + "'," + "default)";
    }

    @Override
    public String vratiVrednostZaDelete() {
        return "";
    }

    @Override
    public String vratiVrednostZaJoin() {
        return "";
    }

    @Override
    public String vratiVrednostZaSelect() {
        return " where username=" + "'" + korisnickoIme + "'" + " and password=" + "'" + lozinka + "'";
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekat(ResultSet rs) {
        try {
            if (!rs.isBeforeFirst()) {
                return null;
            } else {
                rs.next();
                return new Korisnik(rs.getInt("KorisnikID"), rs.getString("username"), rs.getString("password"), rs.getBoolean("administrator"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Korisnik.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean daLiJeSlozen() {
        return false;
    }

    @Override
    public void unesiSlozen(OpstiDomenskiObjekat odo, Statement st) {
        throw new UnsupportedOperationException("Not supported yet. unesiSlozen"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostZaUpdate() {
        return "set Username=" + "'" + korisnickoIme + "'" + ",Password=" + "'" + lozinka + "'" + ",Administrator=" + vratiAdminVrednost() + " where KorisnikID=" + korisnikID;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
        List<OpstiDomenskiObjekat> listaKorisnika = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("KorisnikID");
                String username = rs.getString("username");
                String password = rs.getString("password");
                Boolean admin = rs.getBoolean("Administrator");
                Korisnik a = new Korisnik(id, username, password, admin);
                listaKorisnika.add(a);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Greska pri vracanju korisnika " + e.getMessage());
        }
        return listaKorisnika;
    }

    public int getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(int korisnikID) {
        this.korisnikID = korisnikID;
    }

    private int vratiAdminVrednost() {
        if (administrator) {
            return 1;
        } else {
            return 0;
        }
    }

}
