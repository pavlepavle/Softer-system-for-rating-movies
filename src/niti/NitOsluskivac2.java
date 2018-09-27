/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pavlepavle
 */
public class NitOsluskivac2 extends Thread {

    private ServerSocket ss;
    public List<Socket> listaSoketa;

    public NitOsluskivac2(ServerSocket ss) {
        this.ss = ss;
        listaSoketa = new ArrayList<>();
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Socket s = ss.accept();
                listaSoketa.add(s);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Osluskivanje je stopirano.");
    }
}
