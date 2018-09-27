/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli_tabela;

import domen.Ocena;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pavlepavle
 */
public class TblModelOcena extends AbstractTableModel {

    private List<Ocena> listaOcena;
    private List<Ocena> kopijaListe;
    private String[] kolone = new String[]{"Naziv filma", "Godina", "Ocena"};

    public TblModelOcena(List<Ocena> listaOcena) {
        this.listaOcena = listaOcena;
        kopijaListe = listaOcena;

    }

    @Override
    public int getRowCount() {
        return listaOcena.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ocena o = listaOcena.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return o.getFilm().getNaziv();
            case 1:
                return o.getFilm().getGodina();
            case 2:
                return o.getOcena();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public Ocena vratiOcenu(int index) {
        return listaOcena.get(index);
    }

    public void ponistiFilter() {
        listaOcena = kopijaListe;
        fireTableDataChanged();
        System.out.println("Filter ponisten.");
    }

    public List<Ocena> getKopijaListe() {
        return kopijaListe;
    }

    public List<Ocena> getListaOcena() {
        return listaOcena;
    }

    public void pretraziOcene(String unetaRec, int godina, List<Ocena> lista, int i) {
        List<Ocena> lk = new ArrayList<>();
        listaOcena = kopijaListe;
        if (unetaRec.isEmpty() && godina==0) {
            listaOcena = kopijaListe;
        } else {
            for (Ocena o : lista) {
                switch (i) {
                    case -1:
                        if (o.getFilm().getNaziv().toLowerCase().startsWith(unetaRec.toLowerCase()) && o.getFilm().getGodina()==godina) {
                            lk.add(o);
                        }
                        break;
                    case 1:
                        if (o.getFilm().getNaziv().toLowerCase().startsWith(unetaRec.toLowerCase())) {
                        lk.add(o);
                    }
                        break;
                    case 0:
                        if (o.getFilm().getGodina()==godina) {
                        lk.add(o);
                    }
                        break;
                }
            }
            listaOcena = lk;
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
