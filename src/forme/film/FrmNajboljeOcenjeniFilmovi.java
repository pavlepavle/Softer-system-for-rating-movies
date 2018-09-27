/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.film;

import domen.Korisnik;
import domen.Ocena;
import domen.PomocnaOcena;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import modeli_tabela.TblModelNajboljeOcenjeniFilmovi;

/**
 *
 * @author pavlepavle
 */
public class FrmNajboljeOcenjeniFilmovi extends javax.swing.JDialog {

    Korisnik k;

    /**
     * Creates new form FrmNajboljeOcenjeniFilmovi
     */
    public FrmNajboljeOcenjeniFilmovi(java.awt.Frame parent, boolean modal, Korisnik k) {
        super(parent, modal);
        initComponents();
        this.k = k;
        srediTabelu();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblNajboljeOcenjeniFilmovi = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtNazivFilma = new javax.swing.JTextField();
        jsGodina = new javax.swing.JSpinner();
        checkBoxNazivFilma = new javax.swing.JCheckBox();
        checkBoxGodina = new javax.swing.JCheckBox();
        btnFiltriraj = new javax.swing.JButton();
        btnPonistiFilter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Najbolje ocenjeni filmovi");

        jtblNajboljeOcenjeniFilmovi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Rb", "Naziv filma", "Godina", "Ocena"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtblNajboljeOcenjeniFilmovi);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtNazivFilma.setEnabled(false);

        jsGodina.setModel(new javax.swing.SpinnerNumberModel(1894, 1894, 2017, 1));
        jsGodina.setEnabled(false);

        checkBoxNazivFilma.setText("Naziv filma:");
        checkBoxNazivFilma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxNazivFilmaActionPerformed(evt);
            }
        });

        checkBoxGodina.setText("Godina:");
        checkBoxGodina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxGodinaActionPerformed(evt);
            }
        });

        btnFiltriraj.setText("Filtriraj");
        btnFiltriraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrirajActionPerformed(evt);
            }
        });

        btnPonistiFilter.setText("Ponisti filter");
        btnPonistiFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonistiFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(checkBoxNazivFilma, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(checkBoxGodina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNazivFilma)
                            .addComponent(jsGodina, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnFiltriraj, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPonistiFilter)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxNazivFilma)
                    .addComponent(txtNazivFilma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxGodina)
                    .addComponent(jsGodina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFiltriraj)
                    .addComponent(btnPonistiFilter))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void checkBoxNazivFilmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxNazivFilmaActionPerformed

        if (txtNazivFilma.isEnabled()) {
            txtNazivFilma.setEnabled(false);
        } else {
            txtNazivFilma.setEnabled(true);
        }
    }//GEN-LAST:event_checkBoxNazivFilmaActionPerformed

    private void checkBoxGodinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxGodinaActionPerformed

        if (jsGodina.isEnabled()) {
            jsGodina.setEnabled(false);
        } else {
            jsGodina.setEnabled(true);
        }
    }//GEN-LAST:event_checkBoxGodinaActionPerformed

    private void btnFiltrirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrirajActionPerformed

        String unetaRec = txtNazivFilma.getText().trim();
        int godina = (int)jsGodina.getValue();
        TblModelNajboljeOcenjeniFilmovi tmnof = (TblModelNajboljeOcenjeniFilmovi) jtblNajboljeOcenjeniFilmovi.getModel();

        if (!checkBoxNazivFilma.isSelected() && !checkBoxGodina.isSelected()) {
            JOptionPane.showMessageDialog(this, "Nije izabran nijedan kriterijum pretrage", "Pretraga filmova", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (checkBoxNazivFilma.isSelected() && checkBoxGodina.isSelected()) {
            tmnof.pretraziOcene(unetaRec, godina, tmnof.getKopijaListe(), -1);
        }
        else if (checkBoxNazivFilma.isSelected()) {
            tmnof.pretraziOcene(unetaRec, 0, tmnof.getKopijaListe(), 1);
        }
        else if (checkBoxGodina.isSelected()) {
            tmnof.pretraziOcene(unetaRec, godina, tmnof.getKopijaListe(), 0);
        }
    }//GEN-LAST:event_btnFiltrirajActionPerformed

    private void btnPonistiFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonistiFilterActionPerformed

        TblModelNajboljeOcenjeniFilmovi tmnof = (TblModelNajboljeOcenjeniFilmovi) jtblNajboljeOcenjeniFilmovi.getModel();
        tmnof.ponistiFilter();
        txtNazivFilma.setText("");
        checkBoxGodina.setSelected(false);
        checkBoxNazivFilma.setSelected(false);
        txtNazivFilma.setEnabled(false);
        jsGodina.setEnabled(false);
    }//GEN-LAST:event_btnPonistiFilterActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltriraj;
    private javax.swing.JButton btnPonistiFilter;
    private javax.swing.JCheckBox checkBoxGodina;
    private javax.swing.JCheckBox checkBoxNazivFilma;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jsGodina;
    private javax.swing.JTable jtblNajboljeOcenjeniFilmovi;
    private javax.swing.JTextField txtNazivFilma;
    // End of variables declaration//GEN-END:variables

    private void srediTabelu() {
        try {
            List<PomocnaOcena> listaNajboljih = new ArrayList<>();
            List<Ocena> listaOcena = Kontroler.vratiInstancu().vratiListuOcena();
            if (listaOcena.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Sistem ne moze da nadje nijednu ocenu", "Poruka", JOptionPane.INFORMATION_MESSAGE);
                //dispose();
            } else {
                int filmid = listaOcena.get(0).getFilm().getFilmID();
                int sumaOcena = listaOcena.get(0).getOcena();
                int brojac=1;
                String nazivFilma = listaOcena.get(0).getFilm().getNaziv();
                int godina = listaOcena.get(0).getFilm().getGodina();
                
                if (listaOcena.size()==1) {
                    listaNajboljih.add(new PomocnaOcena(nazivFilma, godina, (double)sumaOcena/brojac));
                }

                for (int i = 1; i < listaOcena.size(); i++) {
                    if (filmid==listaOcena.get(i).getFilm().getFilmID()) {
                        brojac++;
                        sumaOcena+=listaOcena.get(i).getOcena();
                        if(i == listaOcena.size()-1){
                            listaNajboljih.add(new PomocnaOcena(nazivFilma, godina, (double)sumaOcena/brojac));
                        }
                    }
                    else{
                        listaNajboljih.add(new PomocnaOcena(nazivFilma, godina, (double)sumaOcena/brojac));
                        filmid = listaOcena.get(i).getFilm().getFilmID();
                        sumaOcena = listaOcena.get(i).getOcena();
                        brojac = 1;
                        nazivFilma = listaOcena.get(i).getFilm().getNaziv();
                        godina = listaOcena.get(i).getFilm().getGodina();
                        if(i == listaOcena.size()-1){
                            listaNajboljih.add(new PomocnaOcena(nazivFilma, godina, (double)sumaOcena/brojac));
                        }
                    }
                }

                Collections.sort(listaNajboljih, new Comparator<PomocnaOcena>() {
                    @Override
                    public int compare(PomocnaOcena o1, PomocnaOcena o2) {
                       return o1.compareTo(o2);
                    }
                });
                Collections.reverse(listaNajboljih);
                
                TblModelNajboljeOcenjeniFilmovi tmnof = new TblModelNajboljeOcenjeniFilmovi(listaNajboljih);
                jtblNajboljeOcenjeniFilmovi.setModel(tmnof);
                jtblNajboljeOcenjeniFilmovi.getColumnModel().getColumn(0).setPreferredWidth(4);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Poruka o gresci", JOptionPane.ERROR_MESSAGE);
        }
    }
}