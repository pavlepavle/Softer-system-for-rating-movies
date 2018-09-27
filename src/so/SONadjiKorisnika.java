/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;

/**
 *
 * @author pavlepavle
 */
public class SONadjiKorisnika extends OpstaSO {

    private OpstiDomenskiObjekat opstiDomenskiObjekat;

    public OpstiDomenskiObjekat getOpstiDomenskiObjekat() {
        return opstiDomenskiObjekat;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        opstiDomenskiObjekat = DBBroker.vratiInstancu().pronadji(odo);
    }

}
