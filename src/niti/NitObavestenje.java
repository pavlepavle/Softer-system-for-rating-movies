///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package niti;
//
//import dto.ServerTransferObjekat;
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.ObjectOutputStream;
//import java.net.Socket;
//import java.util.List;
//import util.*;
//
///**
// *
// * @author pavlepavle
// */
//public class NitObavestenje extends Thread {
//
//    public NitObavestenje(NitOsluskivac2 no) {
//        this.no = no;
//    }
//    private NitOsluskivac2 no;
//    
//
//    public void run() {
//
//        System.out.println("obavestenje nit pokrenuto");
//        
//        List<Socket> lista = no.listaSoketa;
//        int i = lista.size();
//        int brojac = 0;
//        while (brojac<i) {        
//        try {
//            for (Socket socket : lista) {
//                //DataOutputStream out = new DataOutputStream(socket.getOutputStream());
//                //StringOutputStream out = new ObjectOutputStream(socket.getOutputStream());
//                //out.writeObject("halo");
//                //out.writeUTF("hej hej decace");
//                //System.out.println("Obavestio klijenta " + socket);
//                //brojac++;
//                
//                ServerTransferObjekat sto = new ServerTransferObjekat();
//                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
//                sto.setRezultat(new String("bla"));
//                sto.setStatus(Util.SERVER_STATUS_OPERACIJA_OBAVESTENJE);
//                out.writeObject(sto);
//                System.out.println("Obavestio klijenta " + socket);
//                brojac++;
//            }
//        } catch (Exception e) {
//            System.out.println("Nema klijenata. " + e.getMessage());
//        }
//        }
//        
//    }
//}
