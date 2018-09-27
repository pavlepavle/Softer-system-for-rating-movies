/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author pavlepavle
 */
public abstract class OpstaSO {

    public void izvrsi(OpstiDomenskiObjekat odo) throws Exception {
        try {
            proveriPreduslov(odo);
            izvrsiKonkretnuOperaciju(odo);
            potvrdi();
        } catch (Exception e) {
            ponisti();
            System.out.println(e.getMessage());
            throw e;
        }
    }

    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {

    }

    protected abstract void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception;

    private void potvrdi() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        DBBroker.vratiInstancu().potvrdiTransakciju();
    }

    private void ponisti() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        DBBroker.vratiInstancu().ponistiTransakciju();
    }

    public void izvrsi(OpstiDomenskiObjekat odo, String staroKorisnickoIme) throws Exception {
        try {
            proveriPreduslov(odo,staroKorisnickoIme);
            izvrsiKonkretnuOperaciju(odo);
            potvrdi();
        } catch (Exception e) {
            ponisti();
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    protected void proveriPreduslov(OpstiDomenskiObjekat odo, String staroKorisnickoIme) throws Exception {
        
    }

}
