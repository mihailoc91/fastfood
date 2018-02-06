
package view;

import controller.Controller;
import controller.ControllerExit;
import controller.IZaposleni;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.EventObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Zaposleni;
public class DobavljacForm extends javax.swing.JPanel implements IZaposleni {
    String naziv;
    String pib;
    String adresa;
    String telefon;
    Zaposleni zaposleni;
    JOptionPane op = new JOptionPane();
    public DobavljacForm() {
        initComponents();
        
         /*Layout --pocetak*/
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (dimension.height-ControllerExit.Height64p)/2;
        int width = (dimension.width-ControllerExit.Width19p)/2;
        jLabel1.setBounds(width, height, ControllerExit.Width9p, ControllerExit.Height4p);
        jLabel2.setBounds(width, height+ControllerExit.Height9p, ControllerExit.Width8p, ControllerExit.Height4p);
        jTextField1.setBounds(width+ControllerExit.Width9p, height+ControllerExit.Height9p, ControllerExit.Width10p, ControllerExit.Height4p);
        jLabel3.setBounds(width, height+ControllerExit.Height14p, ControllerExit.Width8p, ControllerExit.Height4p);
        jTextField2.setBounds(width+ControllerExit.Width9p, height+ControllerExit.Height14p, ControllerExit.Width10p, ControllerExit.Height4p);
        jLabel4.setBounds(width, height+ControllerExit.Height20p, ControllerExit.Width8p, ControllerExit.Height4p);
        jTextField3.setBounds(width+ControllerExit.Width9p, height+ControllerExit.Height20p, ControllerExit.Width10p, ControllerExit.Height4p);
        jLabel5.setBounds(width, height+ControllerExit.Height26p, ControllerExit.Width8p, ControllerExit.Height4p);
        jTextField4.setBounds(width+ControllerExit.Width9p, height+ControllerExit.Height26p, ControllerExit.Width10p, ControllerExit.Height4p);
        
        jButton1.setBounds(width+ControllerExit.Width06p,height + ControllerExit.Height60p, ControllerExit.Width8p,ControllerExit.Height4p );
        jButton2.setBounds(width+ControllerExit.Width10p,height + ControllerExit.Height60p, ControllerExit.Width8p,ControllerExit.Height4p );
        /*Layout --kraj*/  
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setText("Dobavljac :");
        add(jLabel1);
        jLabel1.setBounds(128, 11, 89, 23);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Naziv:");
        add(jLabel2);
        jLabel2.setBounds(35, 61, 72, 25);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("PIB:");
        add(jLabel3);
        jLabel3.setBounds(35, 97, 72, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("Telefon:");
        add(jLabel4);
        jLabel4.setBounds(35, 164, 72, 25);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("Adresa:");
        add(jLabel5);
        jLabel5.setBounds(35, 128, 72, 25);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(jTextField1);
        jTextField1.setBounds(111, 61, 106, 25);

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(jTextField2);
        jTextField2.setBounds(111, 97, 106, 25);

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(jTextField3);
        jTextField3.setBounds(111, 164, 106, 25);

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(jTextField4);
        jTextField4.setBounds(111, 128, 106, 25);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Sacuvaj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(54, 231, 93, 31);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Nazad");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(164, 231, 81, 31);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            
        try {
            naziv = jTextField1.getText();
            pib = jTextField2.getText();
            adresa = jTextField4.getText();
            telefon = jTextField3.getText();
            
            Controller.saveDobavljac(naziv, pib, adresa, telefon,op);
            switch (zaposleni.getTipZaposlenog()){
                case 1:
                    MenuZaposleni mz = MenuZaposleni.mz;
                    zaposleni.addEventListener(mz);
                    zaposleni.distributeEvent();
                    Login.pocetniFrejm.setContentPane(mz);
                    Login.pocetniFrejm.revalidate();
                break;
                case 2:
                    MenuMenadzeri mm = MenuMenadzeri.mm;
                    zaposleni.addEventListener(mm);
                    zaposleni.distributeEvent();
                    Login.pocetniFrejm.setContentPane(mm);
                    Login.pocetniFrejm.revalidate();
                break;
            }

        }catch (SQLException ex) {
            Logger.getLogger(DobavljacForm.class.getName()).log(Level.SEVERE, null, ex);}

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           switch (zaposleni.getTipZaposlenog()){
                case 1:
                    MenuZaposleni mz = MenuZaposleni.mz;
                    zaposleni.addEventListener(mz);
                    zaposleni.distributeEvent();
                    Login.pocetniFrejm.setContentPane(mz);
                    Login.pocetniFrejm.revalidate();
                break;
                case 2:
                    MenuMenadzeri mm = MenuMenadzeri.mm;
                    zaposleni.addEventListener(mm);
                    zaposleni.distributeEvent();
                    Login.pocetniFrejm.setContentPane(mm);
                    Login.pocetniFrejm.revalidate();
                break;
            }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

    @Override
    public void zaposleniUlogovan(EventObject evt) {
        zaposleni = (Zaposleni) evt.getSource();
    }
}
