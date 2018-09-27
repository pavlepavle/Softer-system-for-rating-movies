/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli_tabela;

import domen.Zanr;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pavlepavle
 */
public class TblModelZanr extends AbstractTableModel{

    private List<Zanr> listaZanrova;
    private String[] kolone = new String[]{"Rb", "Zanr"};

    
    public TblModelZanr(List<Zanr> listaZanrova) {
        this.listaZanrova = listaZanrova;
    }

    @Override
    public int getRowCount() {
        return listaZanrova.size();
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zanr z = listaZanrova.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex+1;
            case 1:
                return z.getNaziv();
            default:
                return "n/a";
        }
    }

    public List<Zanr> getListaZanrova() {
        return listaZanrova;
    }

    public void setListaZanrova(List<Zanr> listaZanrova) {
        this.listaZanrova = listaZanrova;
        fireTableDataChanged();
    }
    
    public void obrisiZanr(int i) {
        listaZanrova.remove(listaZanrova.get(i));
        fireTableDataChanged();
    }
    
    public void dodajZanr(Zanr z) {
        if (!listaZanrova.contains(z)) {
                listaZanrova.add(z);
            }
        fireTableDataChanged();
    }
    
    public void dodajZanr(List<Zanr> lz) {
        for (Zanr zanr : lz) {
            if (!listaZanrova.contains(zanr)) {
                listaZanrova.add(zanr);
            }
        }
        fireTableDataChanged();
    }
    
}
