/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pavlepavle
 */
public class KonfiguracijaBaze extends javax.swing.JDialog {

    /**
     * Creates new form KonfiguracijaBaze
     * @param parent
     * @param modal
     */
    public KonfiguracijaBaze(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jpnlMysql.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jpnlMysql = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfPassword = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfUrl = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfDriver = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnMysql = new javax.swing.JRadioButton();
        btnAccess = new javax.swing.JRadioButton();
        jbtnSacuvaj = new javax.swing.JButton();
        jbtnTest = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Konfiguracija baze");

        jpnlMysql.setBorder(javax.swing.BorderFactory.createTitledBorder("MySql"));

        jLabel1.setText("Username:");

        jLabel2.setText("Password:");

        jLabel3.setText("Url:");

        jLabel4.setText("Driver:");

        javax.swing.GroupLayout jpnlMysqlLayout = new javax.swing.GroupLayout(jpnlMysql);
        jpnlMysql.setLayout(jpnlMysqlLayout);
        jpnlMysqlLayout.setHorizontalGroup(
            jpnlMysqlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlMysqlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlMysqlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlMysqlLayout.createSequentialGroup()
                        .addGroup(jpnlMysqlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jpnlMysqlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfUsername)
                            .addComponent(jtfPassword)
                            .addComponent(jtfDriver, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)))
                    .addGroup(jpnlMysqlLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(63, 63, 63)
                        .addComponent(jtfUrl)))
                .addContainerGap())
        );
        jpnlMysqlLayout.setVerticalGroup(
            jpnlMysqlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlMysqlLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jpnlMysqlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfDriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jpnlMysqlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 30, Short.MAX_VALUE)
                .addGroup(jpnlMysqlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jpnlMysqlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        buttonGroup1.add(btnMysql);
        btnMysql.setText("MySQL");
        btnMysql.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMysqlActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnAccess);
        btnAccess.setText("MsAccess");
        btnAccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccessActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAccess)
                    .addComponent(btnMysql))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMysql)
                .addGap(18, 18, 18)
                .addComponent(btnAccess)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtnSacuvaj.setText("Sacuvaj");
        jbtnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSacuvajActionPerformed(evt);
            }
        });

        jbtnTest.setText("Test");
        jbtnTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnSacuvaj, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnTest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addComponent(jpnlMysql, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnlMysql, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnTest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnSacuvaj)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMysqlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMysqlActionPerformed
        jpnlMysql.setVisible(true);
    }//GEN-LAST:event_btnMysqlActionPerformed

    private void btnAccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccessActionPerformed
        jpnlMysql.setVisible(false);
    }//GEN-LAST:event_btnAccessActionPerformed

    private void jbtnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSacuvajActionPerformed
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("db_info.properties"));
            String username = jtfUsername.getText().trim();
            String password = jtfPassword.getText().trim();
            String url = jtfUrl.getText().trim();
            String driver = jtfDriver.getText().trim();
            if (btnMysql.isSelected()) {
                properties.put("current_db", "mysql");
                properties.put("mysql_driver", driver);
                properties.put("mysql_user", username);
                properties.put("mysql_password", password);
                properties.put("mysql_url", url);
            } else if (btnAccess.isSelected()) {
                properties.put("current_db", "access");
            }
            properties.store(new FileOutputStream("db_info.properties"), null);
            JOptionPane.showMessageDialog(this, "Konfiguracija uspesno sacuvana.");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(KonfiguracijaBaze.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(KonfiguracijaBaze.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnSacuvajActionPerformed

    private void jbtnTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTestActionPerformed
        String username = jtfUsername.getText().trim();
        String password = jtfPassword.getText().trim();
        String url = jtfUrl.getText().trim();
        String driver = jtfDriver.getText().trim();
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            conn.close();
            JOptionPane.showMessageDialog(this, "Konekcija uspesna.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Doslo je do greske pri uspostavljanju konekcije", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnTestActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnAccess;
    private javax.swing.JRadioButton btnMysql;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnSacuvaj;
    private javax.swing.JButton jbtnTest;
    private javax.swing.JPanel jpnlMysql;
    private javax.swing.JTextField jtfDriver;
    private javax.swing.JTextField jtfPassword;
    private javax.swing.JTextField jtfUrl;
    private javax.swing.JTextField jtfUsername;
    // End of variables declaration//GEN-END:variables
}