/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import dto.ServerTransferObjekat;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import util.Util;

/**
 *
 * @author pavlepavle
 */
public class Osluskivac extends Thread {

    public Osluskivac(Socket s, JFrame jf) {
        this.s = s;
        this.jf = jf;
    }

    Socket s;
    JFrame jf;

    @Override
    public void run() {

        System.out.println("Osluskivac pokrenut");
        while (true) {
            try {
                ObjectInputStream in = new ObjectInputStream(s.getInputStream());
                ServerTransferObjekat sto = (ServerTransferObjekat) in.readObject();
                if (sto.getStatus() == Util.SERVER_STATUS_OPERACIJA_OBAVESTENJE) {
                    //jf.dispose();
                    jf.dispatchEvent(new WindowEvent(jf, WindowEvent.WINDOW_CLOSING));
                } else {
                    System.out.println("grgr");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("error " + ex.getMessage());
                Logger.getLogger(Osluskivac.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
