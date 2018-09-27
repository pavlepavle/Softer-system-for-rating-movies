/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli_tabela;

import domen.PomocnaOcena;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pavlepavle
 */
public class TblModelNajboljeOcenjeniFilmovi extends AbstractTableModel {

    private List<PomocnaOcena> listaOcena;
    private List<PomocnaOcena> kopijaListe;
    private String[] kolone = new String[]{"RB", "Naziv filma", "Godina", "Ocena"};

    public TblModelNajboljeOcenjeniFilmovi(List<PomocnaOcena> listaOcena) {
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
        PomocnaOcena o = listaOcena.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex+1;
            case 1:
                return o.getNazivOcene();
            case 2:
                return o.getGodina();
            case 3:
                double number = o.getProsecnaOcena();
                number = Math.round(number * 100);
                number = number/100;
                return number;
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public PomocnaOcena vratiOcenu(int index) {
        return listaOcena.get(index);
    }

    public void ponistiFilter() {
        listaOcena = kopijaListe;
        fireTableDataChanged();
        System.out.println("Filter ponisten.");
    }

    public List<PomocnaOcena> getKopijaListe() {
        return kopijaListe;
    }

    public List<PomocnaOcena> getListaOcena() {
        return listaOcena;
    }

    public void pretraziOcene(String unetaRec, int godina, List<PomocnaOcena> lista, int i) {
        List<PomocnaOcena> lk = new ArrayList<>();
        listaOcena = kopijaListe;
        if (unetaRec.isEmpty() && godina==0) {
            listaOcena = kopijaListe;
        } else {
            for (PomocnaOcena o : lista) {
                switch (i) {
                    case -1:
                        if (o.getNazivOcene().toLowerCase().startsWith(unetaRec.toLowerCase()) && o.getGodina()==godina) {
                            lk.add(o);
                        }
                        break;
                    case 1:
                        if (o.getNazivOcene().toLowerCase().startsWith(unetaRec.toLowerCase())) {
                        lk.add(o);
                    }
                        break;
                    case 0:
                        if (o.getGodina()==godina) {
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
