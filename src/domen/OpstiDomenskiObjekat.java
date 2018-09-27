/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author pavlepavle
 */
public abstract class OpstiDomenskiObjekat {
    public abstract String vratiNazivTabele();

    public abstract String vratiVrednostiZaInsert();

    public abstract String vratiVrednostZaDelete();
    
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) {
        return null;
    }
    public abstract String vratiVrednostZaJoin();
    
    public abstract String vratiVrednostZaSelect();
    public OpstiDomenskiObjekat vratiObjekat(ResultSet rs){
        return null;
    }
    public abstract boolean daLiJeSlozen();
    public abstract void unesiSlozen(OpstiDomenskiObjekat odo, Statement st)throws Exception;

    public abstract String vratiVrednostZaUpdate();

    
}
