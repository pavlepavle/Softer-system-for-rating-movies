/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author pavlepavle
 */
public class Uloga implements Serializable{

    private int ulogaID;
    private String imeUloge;
    private String vrstaUloge;
    private String imePrezimeOsobe;
    private Film film;

    public Uloga() {
    }

    public Uloga(int ulogaID, String imeUloge, String vrstaUloge, String imePrezimeOsobe, Film film) {
        this.ulogaID = ulogaID;
        this.imeUloge = imeUloge;
        this.vrstaUloge = vrstaUloge;
        this.imePrezimeOsobe = imePrezimeOsobe;
        this.film = film;
    }

    public int getUlogaID() {
        return ulogaID;
    }

    public void setUlogaID(int ulogaID) {
        this.ulogaID = ulogaID;
    }

    public String getImeUloge() {
        return imeUloge;
    }

    public void setImeUloge(String imeUloge) {
        this.imeUloge = imeUloge;
    }

    public String getVrstaUloge() {
        return vrstaUloge;
    }

    public void setVrstaUloge(String vrstaUloge) {
        this.vrstaUloge = vrstaUloge;
    }

    public String getImePrezimeOsobe() {
        return imePrezimeOsobe;
    }

    public void setImePrezimeOsobe(String imePrezimeOsobe) {
        this.imePrezimeOsobe = imePrezimeOsobe;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return imeUloge + " - " + vrstaUloge + " - " + imePrezimeOsobe;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Uloga)) {
            return false;
        }
        Uloga u = (Uloga) obj;
        return u.getImeUloge().equals(imeUloge) && u.getImePrezimeOsobe().equals(imePrezimeOsobe) && u.getVrstaUloge().equals(vrstaUloge);
    }
    
    
}
