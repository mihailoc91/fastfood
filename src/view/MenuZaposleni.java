
package view;

import controller.ControllerExit;
import controller.IZaposleni;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.EventObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Zaposleni;


public class MenuZaposleni extends javax.swing.JPanel implements IZaposleni {
        
    Zaposleni zaposleni;
    public static MenuZaposleni mz;
    
    public MenuZaposleni()  {
        initComponents();
        mz = this;
        
        /*Layout --pocetak*/
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (dimension.height-ControllerExit.Height14p)/2;
        int width = (dimension.width-ControllerExit.Width27p)/2;
        jButton1.setBounds(width,height-ControllerExit.Height10p, ControllerExit.Width12p,ControllerExit.Height5p );
        jButton2.setBounds(width+ControllerExit.Width18p,height-ControllerExit.Height10p, ControllerExit.Width12p,ControllerExit.Height5p);
        jButton3.setBounds(width,height + ControllerExit.Height10p, ControllerExit.Width12p,ControllerExit.Height5p);
        jButton4.setBounds(width+ControllerExit.Width18p,height + ControllerExit.Height10p, ControllerExit.Width12p,ControllerExit.Height5p);
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Proizvod");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(67, 47, 109, 37);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setText("Dobavljac");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(208, 47, 107, 37);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setText("Nabavka");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(67, 195, 109, 37);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton4.setText("Dnevni Izvestaj");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4);
        jButton4.setBounds(208, 195, 197, 37);
    }// </editor-fold>//GEN-END:initComponents

    //Proizvod
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            ProizvodForm p = new ProizvodForm ();
            Login.pocetniFrejm.setContentPane(p);
            Login.pocetniFrejm.revalidate();
            
            
            zaposleni.addEventListener(p);
            zaposleni.distributeEvent();
        } catch (SQLException ex) {
            Logger.getLogger(MenuZaposleni.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
    }//GEN-LAST:event_jButton1ActionPerformed

    //Dobavljac
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DobavljacForm df = new DobavljacForm ();
        Login.pocetniFrejm.setContentPane(df);
        Login.pocetniFrejm.revalidate();
        
        zaposleni.addEventListener(df);
        zaposleni.distributeEvent();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            NabavkaForm n = new NabavkaForm();
            zaposleni.addEventListener(n);
            zaposleni.distributeEvent();
            Login.pocetniFrejm.setContentPane(n);
            Login.pocetniFrejm.revalidate();
        } catch (SQLException ex) {
            Logger.getLogger(MenuZaposleni.class.getName()).log(Level.SEVERE, null, ex);
        }
       
               
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            DnevniIzvestajForm dif = new DnevniIzvestajForm();
            zaposleni.addEventListener(dif);
            zaposleni.distributeEvent();
            
            Login.pocetniFrejm.setContentPane(dif);
            Login.pocetniFrejm.revalidate();
        } catch (SQLException ex) {
            Logger.getLogger(MenuZaposleni.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    @Override
    public void zaposleniUlogovan(EventObject evt) {
        zaposleni = (Zaposleni) evt.getSource();
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    // End of variables declaration//GEN-END:variables
}
