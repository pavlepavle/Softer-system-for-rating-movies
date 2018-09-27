/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Korisnik;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pavlepavle
 */
public class SORegistrujKorisnika extends OpstaSO {

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        DBBroker.vratiInstancu().sacuvaj(odo);
    }

    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        try {
            Korisnik korisnik = (Korisnik) odo;
            List<Korisnik> listaKorisnika = new ArrayList<>();
            listaKorisnika = (List<Korisnik>) (List<?>) DBBroker.vratiInstancu().vratiSve(odo);
            for (Korisnik k : listaKorisnika) {
                if (korisnik.equals(k)) {
                    throw new Exception("Korisnicko ime je zauzeto!");
                }
            }
        } catch (Exception e) {
            if (e.getMessage().equals("Korisnicko ime je zauzeto!")) {
                System.out.println(e.getMessage());
                throw e;
            } else {
                throw new Exception("Sistem ne moze da zapamti korisnika!");
            }
        }
    }

}
