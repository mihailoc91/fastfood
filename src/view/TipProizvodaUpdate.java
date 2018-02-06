
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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.TipProizvoda;
import model.Zaposleni;


public class TipProizvodaUpdate extends javax.swing.JPanel implements IZaposleni{

     String naziv;
     String opis;
     Zaposleni zaposleni;
     JOptionPane op = new JOptionPane();
     int id;
    public TipProizvodaUpdate(int id) throws SQLException {
        initComponents();
        this.id=id;
        TipProizvoda tip = TipProizvoda.getTipProizvoda(this.id);
        jTextField1.setText(tip.getNaziv());
        jTextArea1.setText(tip.getOpis());
        
          /*Layout --pocetak*/
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int height = ((dimension.height-ControllerExit.Height39p)/2)-ControllerExit.Height10p;
        int width = (dimension.width-ControllerExit.Width19p)/2;
        jLabel1.setBounds(width, height, ControllerExit.Width9p, ControllerExit.Height4p);
        jLabel2.setBounds(width, height+ControllerExit.Height9p, ControllerExit.Width8p, ControllerExit.Height4p);
        jTextField1.setBounds(width+ControllerExit.Width9p, height+ControllerExit.Height9p, ControllerExit.Width10p, ControllerExit.Height4p);
        jLabel3.setBounds(width, height+ControllerExit.Height14p, ControllerExit.Width8p, ControllerExit.Height4p);
        jScrollPane1.setBounds(width+ControllerExit.Width9p, height+ControllerExit.Height14p, ControllerExit.Width10p, ControllerExit.Height19p);
        
        jButton1.setBounds(width+ControllerExit.Width06p,height + ControllerExit.Height35p, ControllerExit.Width8p,ControllerExit.Height4p);
        jButton2.setBounds(width+ControllerExit.Width10p,height + ControllerExit.Height35p, ControllerExit.Width8p,ControllerExit.Height4p);
        /*Layout --kraj*/
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setText("Tip Proizvoda:");
        add(jLabel1);
        jLabel1.setBounds(140, 11, 80, 27);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Naziv:");
        add(jLabel2);
        jLabel2.setBounds(64, 64, 68, 31);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(jTextField1);
        jTextField1.setBounds(155, 64, 171, 31);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Izmeni");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(101, 251, 85, 31);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Nazad");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(182, 251, 81, 31);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Opis:");
        add(jLabel3);
        jLabel3.setBounds(64, 129, 68, 22);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        add(jScrollPane1);
        jScrollPane1.setBounds(155, 129, 171, 106);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
                naziv = jTextField1.getText();
                opis = jTextArea1.getText();
                ControllerExit.updateTipProizvoda(this.id,naziv, opis,op);
                JFrame jf = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, this);
                ControllerExit.setJTableStartLD(TipoviProizvodaOut.jt,5);
                TipoviProizvodaOut.jLista1.setModel(ControllerExit.setJListModel(1,5));
                jf.setVisible(false);
                jf.dispose();
    } catch (SQLException ex) {
             Logger.getLogger(TipProizvodaUpdate.class.getName()).log(Level.SEVERE, null, ex);
         }
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       JFrame jf = (JFrame)SwingUtilities.getAncestorOfClass(JFrame.class, this);
       jf.setVisible(false);
       jf.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void zaposleniUlogovan(EventObject evt) {
        zaposleni = (Zaposleni)evt.getSource();
    }
}
