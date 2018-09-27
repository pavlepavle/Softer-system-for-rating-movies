/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.film;

import domen.Film;
import domen.Uloga;
import domen.Zanr;
import izuzetak.ValidationException;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import kontroler.Kontroler;
import modeli_tabela.TblModelUloga;
import modeli_tabela.TblModelZanr;

/**
 *
 * @author pavlepavle
 */
public class FrmDodajFilm extends javax.swing.JFrame {

    //List<Object> listaZaValidaciju;
    /**
     * Creates new form FrmDodajFilm
     */
    public FrmDodajFilm() {
        initComponents();
        srediFormu();
        srediTabele();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNazivFilma = new javax.swing.JTextField();
        jsGodina = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaOpis = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtDuzinaTrajanja = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtUkupanBrojUloga = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtblZanr = new javax.swing.JTable();
        btnDodajZanr = new javax.swing.JButton();
        btnObrisiZanr = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtblUloga = new javax.swing.JTable();
        btnDodajUlogu = new javax.swing.JButton();
        btnObrisiUlogu = new javax.swing.JButton();
        btnSacuvajFilm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Forma za dodavanje filmova");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Podaci o filmu"));

        jLabel1.setText("Naziv filma:");

        jsGodina.setModel(new javax.swing.SpinnerNumberModel(1894, 1894, 2017, 1));

        jLabel2.setText("Godina:");

        jLabel3.setText("Opis:");

        jtaOpis.setColumns(20);
        jtaOpis.setRows(5);
        jScrollPane1.setViewportView(jtaOpis);

        jLabel4.setText("Duzina trajanja:");

        jLabel5.setText("Ukupan broj uloga:");

        txtUkupanBrojUloga.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jsGodina, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(txtNazivFilma)
                            .addComponent(txtDuzinaTrajanja)
                            .addComponent(txtUkupanBrojUloga))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNazivFilma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsGodina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDuzinaTrajanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtUkupanBrojUloga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Zanr"));

        jtblZanr.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Rb", "Zanr"
            }
        ));
        jScrollPane2.setViewportView(jtblZanr);

        btnDodajZanr.setText("Dodaj zanr");
        btnDodajZanr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajZanrActionPerformed(evt);
            }
        });

        btnObrisiZanr.setText("Obrisi zanr");
        btnObrisiZanr.setEnabled(false);
        btnObrisiZanr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiZanrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 69, Short.MAX_VALUE)
                        .addComponent(btnObrisiZanr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDodajZanr)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodajZanr)
                    .addComponent(btnObrisiZanr))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Uloge"));

        jtblUloga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Rb", "Ime uloge", "Vrsta uloge", "Ime i prezime"
            }
        ));
        jScrollPane3.setViewportView(jtblUloga);

        btnDodajUlogu.setText("Dodaj ulogu");
        btnDodajUlogu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajUloguActionPerformed(evt);
            }
        });

        btnObrisiUlogu.setText("Obrisi ulogu");
        btnObrisiUlogu.setEnabled(false);
        btnObrisiUlogu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiUloguActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnObrisiUlogu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDodajUlogu)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodajUlogu)
                    .addComponent(btnObrisiUlogu))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSacuvajFilm.setText("Sacuvaj film");
        btnSacuvajFilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajFilmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSacuvajFilm)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSacuvajFilm)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnObrisiZanrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiZanrActionPerformed
        try {
            TblModelZanr tmz = (TblModelZanr) jtblZanr.getModel();
            int i = jtblZanr.getSelectedRow();
            tmz.obrisiZanr(i);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Poruka o gresci", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnObrisiZanrActionPerformed

    private void btnDodajZanrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajZanrActionPerformed
        try {
            TblModelZanr tmz = (TblModelZanr) jtblZanr.getModel();
            new FrmDodajZanr(this, true, tmz).setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Poruka o gresci", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDodajZanrActionPerformed

    private void btnDodajUloguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajUloguActionPerformed
        try {
            TblModelUloga tmu = (TblModelUloga) jtblUloga.getModel();
            new FrmDodajUlogu(this, true, tmu).setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Poruka o gresci", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDodajUloguActionPerformed

    private void btnSacuvajFilmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajFilmActionPerformed
        try {
            validacija();
            String nazivFilma = txtNazivFilma.getText().trim();
            String opis = jtaOpis.getText().trim();
            int godina = (int) jsGodina.getValue();
            int duzinaTrajanja = Integer.parseInt(txtDuzinaTrajanja.getText().trim());
            int brojUloga = Integer.parseInt(txtUkupanBrojUloga.getText().trim());
            List<Zanr> listaZanrova = ((TblModelZanr) jtblZanr.getModel()).getListaZanrova();
            List<Uloga> listaUloga = ((TblModelUloga) jtblUloga.getModel()).getListaUloga();
            List<Film> listaFilmova = Kontroler.vratiInstancu().vratiListuFilmova();
            int id = 0;
            if (listaFilmova.isEmpty()) {
                id = 1;
            } else {
                id = listaFilmova.get(listaFilmova.size() - 1).getFilmID() + 1;
            }
            Film f = new Film(id, nazivFilma, godina, opis, duzinaTrajanja, brojUloga, listaZanrova, listaUloga);
            Kontroler.vratiInstancu().zapamti(f);
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio film");
            ocistiFormu();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Poruka o gresci", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSacuvajFilmActionPerformed

    private void btnObrisiUloguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiUloguActionPerformed
        try {
            TblModelUloga tmu = (TblModelUloga) jtblUloga.getModel();
            int i = jtblUloga.getSelectedRow();
            tmu.obrisiUlogu(i);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Poruka o gresci", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnObrisiUloguActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajUlogu;
    private javax.swing.JButton btnDodajZanr;
    private javax.swing.JButton btnObrisiUlogu;
    private javax.swing.JButton btnObrisiZanr;
    private javax.swing.JButton btnSacuvajFilm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jsGodina;
    private javax.swing.JTextArea jtaOpis;
    private javax.swing.JTable jtblUloga;
    private javax.swing.JTable jtblZanr;
    private javax.swing.JTextField txtDuzinaTrajanja;
    private javax.swing.JTextField txtNazivFilma;
    private javax.swing.JTextField txtUkupanBrojUloga;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(jsGodina, "#");
        jsGodina.setEditor(editor);
    }

    private void srediTabele() {
        try {
            txtUkupanBrojUloga.setText(0 + "");
            TblModelZanr tmz = new TblModelZanr(new ArrayList<>());

            jtblZanr.setModel(tmz);
            jtblZanr.getColumnModel().getColumn(0).setPreferredWidth(4);
            jtblZanr.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    int j = jtblZanr.getSelectedRow();
                    if (j != -1) {
                        btnObrisiZanr.setEnabled(true);
                    } else {
                        btnObrisiZanr.setEnabled(false);
                    }
                }
            });

            TblModelUloga tmu = new TblModelUloga(new ArrayList<>());
            jtblUloga.setModel(tmu);
            jtblUloga.getColumnModel().getColumn(0).setPreferredWidth(4);
            jtblUloga.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    int j = jtblUloga.getSelectedRow();
                    if (j != -1) {
                        btnObrisiUlogu.setEnabled(true);
                    } else {
                        btnObrisiUlogu.setEnabled(false);
                    }
                }
            });
            tmu.addTableModelListener(new TableModelListener() {
                @Override
                public void tableChanged(TableModelEvent e) {
                    System.out.println(e.getType());
                    System.out.println(e.toString());

                    if (e.getType() == 0) {
                        int broj = Integer.parseInt(txtUkupanBrojUloga.getText());
                        broj++;
                        txtUkupanBrojUloga.setText(broj + "");
                    } else {
                        int broj = Integer.parseInt(txtUkupanBrojUloga.getText());
                        broj--;
                        txtUkupanBrojUloga.setText(broj + "");
                    }
                }
            });

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Poruka o gresci", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ocistiFormu() {
        txtDuzinaTrajanja.setText("");
        txtNazivFilma.setText("");
        txtUkupanBrojUloga.setText("0");
        jsGodina.setValue(1894);
        jtaOpis.setText("");
        jtblZanr.setModel(new TblModelZanr(new ArrayList<Zanr>()));
        jtblUloga.setModel(new TblModelUloga(new ArrayList<Uloga>()));
    }

    private void validacija() throws ValidationException {
        List<String> listaGresaka = new ArrayList<>();

        if (txtNazivFilma.getText().trim().isEmpty()) {
            listaGresaka.add("Polje za naziv mora biti popunjeno!");
        }
        if (txtDuzinaTrajanja.getText().trim().isEmpty()) {
            listaGresaka.add("Polje za duzinu trajanja mora biti popunjeno!");
        }else if (!isNumeric(txtDuzinaTrajanja.getText().trim())) {
            listaGresaka.add("Polje za duzinu trajanja mora biti broj!");
        }
//        if (!isNumeric(jsGodina.getValue().toString())) {
//            listaGresaka.add("Polje za godinu mora biti broj!");
//        }
        if (jtaOpis.getText().trim().isEmpty()) {
            listaGresaka.add("Polje za opis mora biti popunjeno!");
        }
        List<Zanr> listaZanrova = ((TblModelZanr) jtblZanr.getModel()).getListaZanrova();
        if (listaZanrova.isEmpty()) {
            listaGresaka.add("Lista zanrova ne sme biti prazna!");
        }
        List<Uloga> listaUloga = ((TblModelUloga) jtblUloga.getModel()).getListaUloga();
        if (listaUloga.isEmpty()) {
            listaGresaka.add("Lista uloga ne sme biti prazna!");
        }

        if (!listaGresaka.isEmpty()) {
            throw new ValidationException(listaGresaka.toString().replace("[", "").replace("]", "").replace(", ", "\n"));
        }
    }

    public boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }

}
