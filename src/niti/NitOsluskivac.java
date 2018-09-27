/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author pavlepavle
 */
public class NitOsluskivac extends Thread {

    private ServerSocket ss;

    public NitOsluskivac(ServerSocket ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Socket s = ss.accept();
                System.out.println("Klijent se povezao.");
                NitKlijent nk = new NitKlijent(s);
                nk.start();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Osluskivanje je stopirano.");
    }
}
