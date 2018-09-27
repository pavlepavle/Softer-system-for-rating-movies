/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli_tabela;

import domen.Film;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pavlepavle
 */
public class TblModelFilm extends AbstractTableModel {

    private List<Film> listaFilmova;
    private List<Film> kopijaListe;
    private String[] kolone = new String[]{"Naziv", "Godina"};

    public TblModelFilm(List<Film> listaFilmova) {
        this.listaFilmova = listaFilmova;
        kopijaListe = listaFilmova;

    }

    @Override
    public int getRowCount() {
        return listaFilmova.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Film f = listaFilmova.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return f.getNaziv();
            case 1:
                return f.getGodina();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public Film vratiFilm(int index) {
        return listaFilmova.get(index);
    }

    public void ponistiFilter() {
        listaFilmova = kopijaListe;
        fireTableDataChanged();
        System.out.println("Filter ponisten.");
    }

    public List<Film> getKopijaListe() {
        return kopijaListe;
    }

    public List<Film> getListaFilmova() {
        return listaFilmova;
    }

    public void pretraziFilmove(String unetaRec, int godina, List<Film> lista, int i) {
        List<Film> lk = new ArrayList<>();
        listaFilmova = kopijaListe;
        if (unetaRec.isEmpty() && godina==0) {
            listaFilmova = kopijaListe;
        } else {
            for (Film f : lista) {
                switch (i) {
                    case -1:
                        if (f.getNaziv().toLowerCase().startsWith(unetaRec.toLowerCase()) && f.getGodina()==godina) {
                            lk.add(f);
                        }
                        break;
                    case 1:
                        if (f.getNaziv().toLowerCase().startsWith(unetaRec.toLowerCase())) {
                        lk.add(f);
                    }
                        break;
                    case 0:
                        if (f.getGodina()==godina) {
                        lk.add(f);
                    }
                        break;
                }
            }
            listaFilmova = lk;
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

    public void obrisiFilm(Film f) {
        listaFilmova.remove(f);
        fireTableDataChanged();
    }
}
