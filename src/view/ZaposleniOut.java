
package view;

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
import javax.swing.JTable;
import model.Zaposleni;

public class ZaposleniOut extends javax.swing.JPanel implements IZaposleni{
    
    Zaposleni zaposleni;
    JOptionPane op = new JOptionPane();
    public static JTable jt;
    
    public ZaposleniOut() throws SQLException {
        initComponents();


        jRadioButton1.setActionCommand("1");
        jRadioButton1.setText("Radnici: ");
        jRadioButton2.setActionCommand("2");
        jRadioButton2.setText("Menadzeri: ");
        jRadioButton3.setActionCommand("3");
        jRadioButton3.setText("Stalno zaposleni: ");
        jRadioButton4.setActionCommand("4");
        jRadioButton4.setText("Zaposleni na odredjeno: ");
        

        ControllerExit.setJTableStartLD(jTable1,7);
        jt=jTable1;
        
         /*Layout --pocetak*/
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int height = ((dimension.height-ControllerExit.Height49p)/2)-ControllerExit.Height10p;
        int width = (dimension.width-ControllerExit.Width46p)/2;
        jLabel1.setBounds(width+ControllerExit.Width19p, height, ControllerExit.Width9p, ControllerExit.Height4p);
        jRadioButton1.setBounds(width, height+ControllerExit.Height9p, ControllerExit.Width10p, ControllerExit.Height4p);
        jRadioButton2.setBounds(width+ControllerExit.Width12p, height+ControllerExit.Height9p, ControllerExit.Width10p, ControllerExit.Height4p);
        jRadioButton3.setBounds(width+ControllerExit.Width24p, height+ControllerExit.Height9p, ControllerExit.Width10p, ControllerExit.Height4p);
        jRadioButton4.setBounds(width+ControllerExit.Width36p, height+ControllerExit.Height9p, ControllerExit.Width15p, ControllerExit.Height4p);
        
        jScrollPane1.setBounds(width+ControllerExit.Width4p, height+ControllerExit.Height14p, ControllerExit.Width39p, ControllerExit.Height29p);
        
        
        jButtonOdaberi.setBounds(width+ControllerExit.Width4p,height + ControllerExit.Height45p, ControllerExit.Width8p,ControllerExit.Height4p);
        jButtonIzmeni.setBounds(width+ControllerExit.Width15p,height + ControllerExit.Height45p, ControllerExit.Width8p,ControllerExit.Height4p);
        jButtonIzbrisi.setBounds(width+ControllerExit.Width25p,height + ControllerExit.Height45p, ControllerExit.Width8p,ControllerExit.Height4p);
        jButtonNazad.setBounds(width+ControllerExit.Width36p,height + ControllerExit.Height45p, ControllerExit.Width8p,ControllerExit.Height4p);
        /*Layout --kraj*/ 
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonOdaberi = new javax.swing.JButton();
        jButtonNazad = new javax.swing.JButton();
        jButtonIzmeni = new javax.swing.JButton();
        jButtonIzbrisi = new javax.swing.JButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();

        setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(75, 220, 537, 193);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton1.setText("jRadioButton1");
        add(jRadioButton1);
        jRadioButton1.setBounds(75, 140, 137, 31);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton2.setText("jRadioButton2");
        add(jRadioButton2);
        jRadioButton2.setBounds(206, 140, 137, 31);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setText("Zaposleni: ");
        add(jLabel1);
        jLabel1.setBounds(273, 11, 171, 32);

        jButtonOdaberi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonOdaberi.setText("Odaberi");
        jButtonOdaberi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOdaberiActionPerformed(evt);
            }
        });
        add(jButtonOdaberi);
        jButtonOdaberi.setBounds(141, 490, 93, 31);

        jButtonNazad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonNazad.setText("Nazad");
        jButtonNazad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNazadActionPerformed(evt);
            }
        });
        add(jButtonNazad);
        jButtonNazad.setBounds(454, 490, 81, 31);

        jButtonIzmeni.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonIzmeni.setText("Izmeni");
        jButtonIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzmeniActionPerformed(evt);
            }
        });
        add(jButtonIzmeni);
        jButtonIzmeni.setBounds(243, 490, 85, 31);

        jButtonIzbrisi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonIzbrisi.setText("Izbrisi");
        jButtonIzbrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzbrisiActionPerformed(evt);
            }
        });
        add(jButtonIzbrisi);
        jButtonIzbrisi.setBounds(349, 490, 79, 31);

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton3.setText("jRadioButton3");
        add(jRadioButton3);
        jRadioButton3.setBounds(382, 140, 137, 31);

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton4.setText("jRadioButton4");
        add(jRadioButton4);
        jRadioButton4.setBounds(519, 140, 137, 31);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOdaberiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOdaberiActionPerformed
        try {
            jTable1=ControllerExit.setJTableNabavkaMD(jTable1,ControllerExit.getSelectedFromJRButtonGroup(buttonGroup1,op), 0,7);
        }catch (NullPointerException ex){
        op.showMessageDialog(op.getParent(),"Niste odabrali parametre za pretragu, molimo vas odaberiti parametre i pokusajte ponovo!","Info",JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException ex) {
            op.showMessageDialog(op.getParent(),"Doslo je do greske pri povezivanju sa bazom! Molimo vas pokusajte ponovo, ukoliko se problem nastavi kontaktirajte vasu tehnicku podrsku!","Greska",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ZaposleniOut.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_jButtonOdaberiActionPerformed

    private void jButtonNazadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNazadActionPerformed
        MenuMenadzeri mm = MenuMenadzeri.mm;
        Login.pocetniFrejm.setContentPane(mm);
        Login.pocetniFrejm.revalidate();
        zaposleni.addEventListener(mm);
        zaposleni.distributeEvent();
    }//GEN-LAST:event_jButtonNazadActionPerformed

    private void jButtonIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzmeniActionPerformed
        try {
            ZaposleniUpdate zu = new ZaposleniUpdate (ControllerExit.getSelectedFromTable2(jTable1,7));
            JFrame jf = new JFrame ();
            jf.setContentPane(zu);
            jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
            jf.setVisible(true);
            jf.revalidate();
            zaposleni.addEventListener(zu);
            zaposleni.distributeEvent();
        }catch(ArrayIndexOutOfBoundsException ex) {
            op.showMessageDialog(op.getParent(),"Niste odabrali zaposlenog kojeg zelite da izmenite!","Info",JOptionPane.INFORMATION_MESSAGE);
            
        }  catch (SQLException ex) {
            Logger.getLogger(ZaposleniOut.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }//GEN-LAST:event_jButtonIzmeniActionPerformed

    private void jButtonIzbrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzbrisiActionPerformed
          try {
                int i=op.showConfirmDialog(null, "Ako izbrisete zaposlenog, izbrisacete i sve Dnevne izvestje i Nabavke koje je zaposleni uneo. Da li ste sigurni da zelite da izbrisete zaposlenog?", "Upozorenje!", JOptionPane.YES_NO_OPTION);
                if(i==0){
                    boolean flag = ControllerExit.deleteFromTable(jTable1,7);
                    if(flag){
                        op.showMessageDialog(op.getParent(),"Uspesno izbrisan Zaposleni!","Brisanje",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        op.showMessageDialog(op.getParent(),"Neuspesno izbrisan Zaposleni!","Brisanje",JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    op.showMessageDialog(op.getParent(),"Umesto brisanja, preporucujemo da izmenite lozinku zaposlenom kojeg zelite da izbrisete.","Brisanje",JOptionPane.INFORMATION_MESSAGE);
                }
        } catch (SQLException ex) {
            Logger.getLogger(NabavkaOut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonIzbrisiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonIzbrisi;
    private javax.swing.JButton jButtonIzmeni;
    private javax.swing.JButton jButtonNazad;
    private javax.swing.JButton jButtonOdaberi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void zaposleniUlogovan(EventObject evt) {
        zaposleni = (Zaposleni)evt.getSource();
    }
}
