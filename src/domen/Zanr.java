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
public class Zanr extends OpstiDomenskiObjekat implements Serializable {

    private int zanrID;
    private String naziv;

    public Zanr() {
    }

    public Zanr(int zanrID, String naziv) {
        this.zanrID = zanrID;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getZanrID() {
        return zanrID;
    }

    public void setZanrID(int zanrID) {
        this.zanrID = zanrID;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "zanr";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "";
    }

    @Override
    public String vratiVrednostZaJoin() {
        return "";
    }

    @Override
    public String vratiVrednostZaSelect() {
        return "";
    }
    

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("zanrID");
                String naziv = rs.getString("naziv");
                Zanr z = new Zanr(id,naziv);
                lista.add(z);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public String vratiVrednostZaDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean daLiJeSlozen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void unesiSlozen(OpstiDomenskiObjekat odo, Statement st) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Zanr)) {
            return false;
        }
        Zanr z = (Zanr) obj;
        return z.getZanrID()==zanrID;
    }
    
    

}
