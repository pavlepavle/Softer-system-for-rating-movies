/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli_tabela;

import domen.Korisnik;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pavlepavle
 */
public class TblModelKorisnik extends AbstractTableModel {

    private List<Korisnik> listaKorisnika;
    private List<Korisnik> kopijaListe;
    private String[] kolone = new String[]{"Korisnicko ime", "Administrator"};

    public TblModelKorisnik(List<Korisnik> listaKorisnika) {
        this.listaKorisnika = listaKorisnika;
        kopijaListe = listaKorisnika;

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
        Korisnik k = listaKorisnika.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getKorisnickoIme();
            case 1:
                return k.getAdministrator();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public Korisnik vratiKorisnika(int index) {
        return listaKorisnika.get(index);
    }

    public void unaprediKorisnika(Korisnik korisnik) throws Exception {
        try {
            
            for (Korisnik k : listaKorisnika) {
                if (k.getKorisnikID()==korisnik.getKorisnikID()) {
                    k.setAdministrator(Boolean.TRUE);
                }
            }

            fireTableDataChanged();
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void ponistiFilter() {
        listaKorisnika = kopijaListe;
        fireTableDataChanged();
        System.out.println("Filter ponisten.");
    }

    public List<Korisnik> getKopijaListe() {
        return kopijaListe;
    }

    public List<Korisnik> getListaKorisnika() {
        return listaKorisnika;
    }

    public void pretraziKorisnike(String unetaRec, List<Korisnik> lista, int i) {
        List<Korisnik> lk = new ArrayList<>();
        listaKorisnika = kopijaListe;
        if (unetaRec.isEmpty()) {
            listaKorisnika = kopijaListe;
        } else {
            for (Korisnik k : lista) {
                switch (i) {
                    case 1:
                        if (k.getKorisnickoIme().toLowerCase().startsWith(unetaRec.toLowerCase()) && k.getAdministrator()) {
                            lk.add(k);
                        }
                        break;
                    case 0:
                        if (k.getKorisnickoIme().toLowerCase().startsWith(unetaRec.toLowerCase()) && !k.getAdministrator()) {
                        lk.add(k);
                    }
                        break;
                    case -1:
                        if (k.getKorisnickoIme().toLowerCase().startsWith(unetaRec.toLowerCase())) {
                        lk.add(k);
                    }
                        break;
                }
            }
            listaKorisnika = lk;
        }
        fireTableDataChanged();
//        if (lk.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Sistem ne moze da nadje korisnike po zadatoj vrednosti.",
//                    "Poruka o gresci", JOptionPane.ERROR_MESSAGE);
//        } else {
//            listaKorisnika = lk;
//            fireTableDataChanged();
//            JOptionPane.showMessageDialog(null, "Sistem je pronasao korisnike po zadatoj vrednosti.");
//        }
    }
    
    


}
