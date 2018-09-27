/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author pavlepavle
 */
public class KlijentTransferObjekat implements Serializable{
    
    private int operacija;
    private Object parametar;
    private String username;

    public KlijentTransferObjekat() {
    }

    public KlijentTransferObjekat(int operacija, Object parametar) {
        this.operacija = operacija;
        this.parametar = parametar;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public Object getParametar() {
        return parametar;
    }

    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
