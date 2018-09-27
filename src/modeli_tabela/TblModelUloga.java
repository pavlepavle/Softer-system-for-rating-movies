/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli_tabela;

import domen.Uloga;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pavlepavle
 */
public class TblModelUloga extends AbstractTableModel {

    private List<Uloga> listaUloga;
    private String[] kolone = new String[]{"Rb", "Ime uloge", "Vrsta uloge", "Ime i prezime"};

    public TblModelUloga(List<Uloga> listaUloga) {
        this.listaUloga = listaUloga;
    }

    @Override
    public int getRowCount() {
        return listaUloga.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Uloga u = listaUloga.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex+1;
            case 1:
                return u.getImeUloge();
            case 2:
                return u.getVrstaUloge();
            case 3:
                return u.getImePrezimeOsobe();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }


    public void obrisiUlogu(int i) {
        listaUloga.remove(listaUloga.get(i));
        fireTableRowsDeleted(i, i);
    }
    
    public void dodajUlogu(Uloga u) {
        if (!listaUloga.contains(u)) {
                listaUloga.add(u);
            }
        fireTableDataChanged();
    }
    
    public void dodajZanr(List<Uloga> lu) {
        for (Uloga u  : lu) {
            if (!listaUloga.contains(u)) {
                listaUloga.add(u);
            }
        }
        fireTableDataChanged();
    }

    public List<Uloga> getListaUloga() {
        return listaUloga;
    }

    public void setListaUloga(List<Uloga> listaUloga) {
        this.listaUloga = listaUloga;
    }
}
