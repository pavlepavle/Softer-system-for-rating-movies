/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.korisnik;

import domen.Korisnik;
import forme.glavna.FrmLogovanje;
import izuzetak.ValidationException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import kontroler.Kontroler;

/**
 *
 * @author pavlepavle
 */
public class FrmRegistrovanje extends javax.swing.JDialog {

    /**
     * Creates new form FrmRegistrovanje2
     */
    public FrmRegistrovanje(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnRegistruj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Forma za registrovanje");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registrovanje"));

        jLabel1.setText("Korisnicko ime:");

        jLabel2.setText("Sifra:");

        btnRegistruj.setText("Registruj se");
        btnRegistruj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrujActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPassword))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRegistruj)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(btnRegistruj)
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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrujActionPerformed

        String korisnickoIme = txtUsername.getText().trim();
        String sifra = "";
        char[] nizSlova = txtPassword.getPassword();
        for (int i = 0; i < nizSlova.length; i++) {
            sifra += nizSlova[i];
        }
        try {
            validacija(korisnickoIme, sifra);
            Korisnik korisnik = new Korisnik(korisnickoIme, sifra);
            Kontroler.vratiInstancu().zapamti(korisnik);
            new FrmLogovanje(sifra, sifra).setVisible(true);
            dispose();
        } catch (Exception e) {
            System.out.println("Greska: " + e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Poruka o gresci", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrujActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistruj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void validacija(String korisnickoIme, String sifra) throws ValidationException {
        List<String> listaGresaka = new ArrayList<>();

        if (korisnickoIme.isEmpty()) {
            listaGresaka.add("Polje za korisnicko ime mora biti popunjeno!");
        }

        if (sifra.isEmpty()) {
            listaGresaka.add("Polje za sifru mora biti popunjeno!");
        }

        if (!listaGresaka.isEmpty()) {
            throw new ValidationException(listaGresaka.toString().replace("[", "").replace("]", "").replace(", ", "\n"));
        }
    }
}
