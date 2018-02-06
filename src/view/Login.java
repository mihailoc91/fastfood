/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import controller.ControllerExit;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import model.Zaposleni;
public class Login extends javax.swing.JFrame {

public static Login pocetniFrejm;    
    
    public Login() {
        initComponents();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        JOptionPane j = new JOptionPane();
        ControllerExit.dimenzije(dimension);
        Controller.firstLogin(j,this);
        pocetniFrejm = this;
        
        
        
        
        
        
     
    /*Layout --pocetak*/   
    int height = (dimension.height-ControllerExit.Height18p)/2;
    int width = (dimension.width-ControllerExit.Width31p)/2;
    jLabel1.setBounds(width, height, ControllerExit.Width12p, ControllerExit.Height5p);
    jLabel2.setBounds(width, height + ControllerExit.Height7p, ControllerExit.Width12p, ControllerExit.Height5p);
    jTextField1.setBounds(width+ControllerExit.Width13p, height, ControllerExit.Width18p, ControllerExit.Height5p);
    jPasswordField1.setBounds(width+ControllerExit.Width13p, height + ControllerExit.Height7p,  ControllerExit.Width18p, ControllerExit.Height5p);
    jButton1.setBounds(width+ControllerExit.Width06p, height+ControllerExit.Height13p, ControllerExit.Width30p, ControllerExit.Height5p);
    jLabel3.setBounds(width, height+ControllerExit.Height20p, ControllerExit.Width30p, ControllerExit.Height5p);
    /*Layout --kraj*/    
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Ime i prezime:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 190, 200, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Lozinka:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(200, 270, 200, 50);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Uloguj se");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(200, 340, 500, 50);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(400, 200, 300, 50);

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(400, 270, 300, 50);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(835, 133, 191, 28);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            this.jPasswordField1.selectAll();
            Zaposleni zaposleni= Controller.login(this.jTextField1.getText(), this.jPasswordField1.getSelectedText());
            switch (zaposleni.getTipZaposlenog()){
                case 1: this.jLabel3.setText("Radnik se ulogovao.");
                MenuZaposleni m = new MenuZaposleni();
                 this.setContentPane(m);
                 this.revalidate();
                zaposleni.addEventListener(m);
                zaposleni.distributeEvent();
                
                break;
                case 2: this.jLabel3.setText("Menadzer se ulogovao.");
                MenuMenadzeri mm = new MenuMenadzeri();
                this.setContentPane(mm);
                this.revalidate();
                zaposleni.addEventListener(mm);
                zaposleni.distributeEvent();
                break;
                default: this.jLabel3.setText("Neuspesno logovanje, pokusajte ponovo.");
                 
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}