/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import forme.glavna.FrmLogovanje;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import niti.Osluskivac;
import util.Util;

/**
 *
 * @author pavlepavle
 */
public class Start {
    public static void main(String[] args) throws IOException {
        try {
        Socket s = new Socket("localhost", 9010);
        Socket s2 = new Socket("localhost", 9000);
        Kontroler.vratiInstancu().getMapa().put(Util.MAP_KEY_SOKET, s);
        JFrame jf =  new FrmLogovanje();
        jf.setVisible(true);
        Osluskivac o = new Osluskivac(s2, jf);
        o.start();
        } catch(Exception e){
            System.out.println("Greska - "+e.getMessage());
            JOptionPane.showMessageDialog(null, "Server nije pokrenut!","Poruka o gresci",JOptionPane.ERROR_MESSAGE);
        }
    }
}
