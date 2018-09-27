/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author pavlepavle
 */
public class PomocnaOcena implements Comparable<PomocnaOcena>{
    private String nazivOcene;
    private int godina;
    private double prosecnaOcena;

    public PomocnaOcena(String nazivOcene, int godina, double prosecnaOcena) {
        this.nazivOcene = nazivOcene;
        this.godina = godina;
        this.prosecnaOcena = prosecnaOcena;
    }

    public String getNazivOcene() {
        return nazivOcene;
    }

    public void setNazivOcene(String nazivOcene) {
        this.nazivOcene = nazivOcene;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public double getProsecnaOcena() {
        return prosecnaOcena;
    }

    public void setProsecnaOcena(double prosecnaOcena) {
        this.prosecnaOcena = prosecnaOcena;
    }

    @Override
    public int compareTo(PomocnaOcena o) {
        if (this.prosecnaOcena<o.getProsecnaOcena()){
            return -1;
        }else{
            return 1;
        }
    }

    
    
}
