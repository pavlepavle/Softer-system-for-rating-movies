/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_tabele;

import db.DBBroker;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pavlepavle
 */
public class TblModelKorisnici extends AbstractTableModel {

    private List<OpstiDomenskiObjekat> listaKorisnika;
    private List<String> statusi;
    private String[] kolone = new String[]{"Username", "Administrator", "Status"};
    private static TblModelKorisnici instanca;

    private TblModelKorisnici(List<OpstiDomenskiObjekat> listaKorisnika) {
        this.listaKorisnika = listaKorisnika;
        dodajStatuse();
    }

    public static TblModelKorisnici vratiInstancu() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        if (instanca == null) {
            instanca = new TblModelKorisnici(DBBroker.vratiInstancu().vratiSve(new Korisnik()));

        }
        return instanca;
    }

    @Override
    public int getRowCount() {
        return listaKorisnika.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Korisnik k1 = (Korisnik) listaKorisnika.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k1.getKorisnickoIme();
            case 1:
                return k1.getAdministrator();
            case 2:
                return statusi.get(rowIndex);
            default:
                return "n/a";
        }
    }

    private void dodajStatuse() {
        statusi = new ArrayList<>();
        for (int i = 0; i < listaKorisnika.size(); i++) {
            statusi.add("offline");
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void postaviDaJeOnline(Korisnik korisnik) {
        int pozicija = listaKorisnika.indexOf(korisnik);
        statusi.set(pozicija, "online");
        fireTableDataChanged();
    }

    public void odjaviKorisnika(Korisnik korisnik) {
        //int pozicija = listaKorisnika.indexOf(korisnik);
        //statusi.set(pozicija, "offline");
        //fireTableDataChanged();

        for (int i = 0; i<listaKorisnika.size(); i++) {
            Korisnik kor = (Korisnik)listaKorisnika.get(i);
            if (korisnik.getKorisnikID()==kor.getKorisnikID()) {
                statusi.set(i, "offline");
            }
        }
        fireTableDataChanged();
    }

    public void dodajKorisnika(Korisnik korisnik) {
        statusi.add("offline");
        listaKorisnika.add(korisnik);
        fireTableDataChanged();
    }

    public void postaviStatuse() {
        for (int i = 0; i < listaKorisnika.size(); i++) {
            statusi.set(i, "offline");
        }
        fireTableDataChanged();
    }

    public void editKorisnika(Korisnik k, int id) {
        for (OpstiDomenskiObjekat korisnik : listaKorisnika) {
            Korisnik kor = (Korisnik) korisnik;
            if (kor.getKorisnikID() == id) {
                kor.setKorisnickoIme(k.getKorisnickoIme());
                kor.setAdministrator(k.getAdministrator());
            }
        }
        fireTableDataChanged();
    }
}
