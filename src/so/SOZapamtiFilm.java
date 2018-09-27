/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.Film;
import domen.OpstiDomenskiObjekat;
import java.util.List;

/**
 *
 * @author pavlepavle
 */
public class SOZapamtiFilm extends OpstaSO {

    @Override
    protected void izvrsiKonkretnuOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        DBBroker.vratiInstancu().sacuvaj(odo);
    }

    @Override
    protected void proveriPreduslov(OpstiDomenskiObjekat odo) throws Exception {
        Film film = (Film) odo;
        List<Film> listaFilmova = (List<Film>) (List<?>) DBBroker.vratiInstancu().vratiSve(odo);
            for (Film f : listaFilmova) {
                if (film.equals(f)) {
                    throw new Exception("Film vec postoji u bazi!");
                }
            }
    }
    
}
