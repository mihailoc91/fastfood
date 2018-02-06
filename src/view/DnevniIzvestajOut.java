
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
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.DnevniIzvestaj;
import model.Zaposleni;

public class DnevniIzvestajOut extends javax.swing.JPanel implements IZaposleni{
    
    Zaposleni zaposleni;
    public static JTable jt;
    JOptionPane op = new JOptionPane();
    public static JLabel jl;
    public static JList jLista1;
    public static JList jLista4;
    public static JList jLista2;
    public DnevniIzvestajOut() throws SQLException {
        initComponents();
        jList1.setModel(ControllerExit.setJListModel(4,2));
        jLista1 = jList1;
        jList4.setModel(ControllerExit.setJListModel(2,2));
        jLista4 = jList4;
        jList2.setModel(ControllerExit.setJListModel(3,2));
        jLista2=jList2;
        
        jRadioButton1.setActionCommand("4");
        jRadioButton1.setText("Dnevni izvestaj: ");
        jRadioButton2.setActionCommand("2");
        jRadioButton2.setText("Datum: ");
        jRadioButton3.setActionCommand("3");
        jRadioButton3.setText("Zaposleni: ");
        jt = jTable1;
        ControllerExit.setJTableStartLD(jTable1,2);
        jLabelTitle.setText("Ukupan iznos: ");
        jLabelValue.setText(DnevniIzvestaj.ukupnaVrednost());
        jl = jLabelValue;
        
         /*Layout --pocetak*/
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int height = ((dimension.height-ControllerExit.Height70p)/2)-ControllerExit.Height10p;
        int width = (dimension.width-ControllerExit.Width46p)/2;
        jLabel1.setBounds(width, height, ControllerExit.Width10p, ControllerExit.Height4p);
        jRadioButton1.setBounds(width, height+ControllerExit.Height9p, ControllerExit.Width10p, ControllerExit.Height4p);
        jRadioButton2.setBounds(width+ControllerExit.Width12p, height+ControllerExit.Height9p, ControllerExit.Width10p, ControllerExit.Height4p);
        jRadioButton3.setBounds(width+ControllerExit.Width24p, height+ControllerExit.Height9p, ControllerExit.Width10p, ControllerExit.Height4p);
        
        jScrollPane2.setBounds(width, height+ControllerExit.Height14p, ControllerExit.Width10p, ControllerExit.Height14p);
        jScrollPane5.setBounds(width+ControllerExit.Width12p, height+ControllerExit.Height14p, ControllerExit.Width10p, ControllerExit.Height14p);
        jScrollPane3.setBounds(width+ControllerExit.Width24p, height+ControllerExit.Height14p, ControllerExit.Width10p, ControllerExit.Height14p);
        
        jScrollPane1.setBounds(width, height+ControllerExit.Height30p, ControllerExit.Width39p, ControllerExit.Height29p);
        jLabelTitle.setBounds(width+ControllerExit.Width40p, height+ControllerExit.Height30p, ControllerExit.Width10p, ControllerExit.Height4p);
        jLabelValue.setBounds(width+ControllerExit.Width40p, height+ControllerExit.Height35p,ControllerExit.Width10p, ControllerExit.Height4p);
        jCheckBoxMD.setBounds(width, height+ControllerExit.Height60p, ControllerExit.Width10p, ControllerExit.Height4p);
        
        jButtonOdaberi.setBounds(width+ControllerExit.Width06p,height + ControllerExit.Height66p, ControllerExit.Width8p,ControllerExit.Height4p );
        jButtonIzmeni.setBounds(width+ControllerExit.Width10p,height + ControllerExit.Height66p, ControllerExit.Width8p,ControllerExit.Height4p);
        jButtonIzbrisi.setBounds(width+ControllerExit.Width20p,height + ControllerExit.Height66p, ControllerExit.Width8p,ControllerExit.Height4p);
        jButtonNazad.setBounds(width+ControllerExit.Width30p,height + ControllerExit.Height66p, ControllerExit.Width8p,ControllerExit.Height4p);
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
        jRadioButton3 = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jButtonOdaberi = new javax.swing.JButton();
        jButtonNazad = new javax.swing.JButton();
        jButtonIzmeni = new javax.swing.JButton();
        jButtonIzbrisi = new javax.swing.JButton();
        jCheckBoxMD = new javax.swing.JCheckBox();
        jLabelTitle = new javax.swing.JLabel();
        jLabelValue = new javax.swing.JLabel();

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
        jScrollPane1.setBounds(35, 250, 537, 193);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton1.setText("jRadioButton1");
        add(jRadioButton1);
        jRadioButton1.setBounds(56, 61, 137, 31);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton2.setText("jRadioButton2");
        add(jRadioButton2);
        jRadioButton2.setBounds(273, 61, 137, 31);

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton3.setText("jRadioButton3");
        add(jRadioButton3);
        jRadioButton3.setBounds(479, 61, 137, 31);

        jList1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        add(jScrollPane2);
        jScrollPane2.setBounds(56, 102, 93, 178);

        jList2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList2);

        add(jScrollPane3);
        jScrollPane3.setBounds(479, 102, 93, 178);

        jList4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jList4.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(jList4);

        add(jScrollPane5);
        jScrollPane5.setBounds(273, 102, 93, 178);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setText("Dnevni Izvestaji:");
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

        jCheckBoxMD.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jCheckBoxMD.setText("Vise detalja");
        add(jCheckBoxMD);
        jCheckBoxMD.setBounds(23, 450, 107, 29);

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTitle.setText("jLabel2");
        add(jLabelTitle);
        jLabelTitle.setBounds(619, 250, 80, 28);

        jLabelValue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelValue.setText("jLabel3");
        add(jLabelValue);
        jLabelValue.setBounds(619, 284, 80, 27);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOdaberiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOdaberiActionPerformed
        try {
            if(jCheckBoxMD.getModel().isSelected()){
            jTable1=ControllerExit.setJTableNabavkaMD(jTable1,ControllerExit.getSelectedFromJRButtonGroup(buttonGroup1,op), ControllerExit.getSelectedFromJRButton(buttonGroup1,null,jList2,jList4,jList1,op,2),2);
            jLabelTitle.setText("Ukupan iznos: ");
            jLabelValue.setText(ControllerExit.ukupnaVrednost(ControllerExit.getSelectedFromJRButtonGroup(buttonGroup1,op),ControllerExit.getSelectedFromJRButton(buttonGroup1, null,jList2,jList4,jList1,op,2),2));
            
            }else{
            jTable1=ControllerExit.setJTableLD(jTable1,ControllerExit.getSelectedFromJRButtonGroup(buttonGroup1,op), ControllerExit.getSelectedFromJRButton(buttonGroup1, null,jList2,jList4,jList1,op,2),2);
            
            
            jLabelValue.setText(ControllerExit.ukupnaVrednost(ControllerExit.getSelectedFromJRButtonGroup(buttonGroup1,op),ControllerExit.getSelectedFromJRButton(buttonGroup1, null,jList2,jList4,jList1,op,2),2));
           
            }
            
        }catch (NullPointerException ex){
            
                op.showMessageDialog(op.getParent(),"Niste odabrali parametre za pretragu, molimo vas odaberiti parametre i pokusajte ponovo!","Info",JOptionPane.INFORMATION_MESSAGE);
                ex.printStackTrace();
        }catch (SQLException ex) {
            op.showMessageDialog(op.getParent(),"Doslo je do greske pri povezivanju sa bazom! Molimo vas pokusajte ponovo, ukoliko se problem nastavi kontaktirajte vasu tehnicku podrsku!","Greska",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DnevniIzvestajOut.class.getName()).log(Level.SEVERE, null, ex);
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
            DnevniIzvestajUpdate diu = new DnevniIzvestajUpdate (ControllerExit.getSelectedFromTable(jTable1));
            JFrame jf = new JFrame ();
            jf.setContentPane(diu);
            jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
            jf.setVisible(true);
            jf.revalidate();
            zaposleni.addEventListener(diu);
            zaposleni.distributeEvent();
            
        }catch(ArrayIndexOutOfBoundsException ex) {
            op.showMessageDialog(op.getParent(),"Niste odabrali dnevni izvestaj koju zelite da izmenite!","Info",JOptionPane.INFORMATION_MESSAGE);
            
        }  catch (SQLException ex) {
            Logger.getLogger(DnevniIzvestajOut.class.getName()).log(Level.SEVERE, null, ex);
        }
       
     
    }//GEN-LAST:event_jButtonIzmeniActionPerformed

    private void jButtonIzbrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzbrisiActionPerformed
          try {
            boolean flag = ControllerExit.deleteFromTable(jTable1,2);
            if(flag){
                
            op.showMessageDialog(op.getParent(),"Uspesno izbrisan Dnevni izvestaj!","Brisanje",JOptionPane.INFORMATION_MESSAGE);
            jList1.setModel(ControllerExit.setJListModel(4,2));
            jList4.setModel(ControllerExit.setJListModel(2,2));
            jList2.setModel(ControllerExit.setJListModel(3,2));
            }else{
                op.showMessageDialog(op.getParent(),"Neuspesno izbrisan Dnevni izvestaj!","Brisanje",JOptionPane.INFORMATION_MESSAGE);
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
    private javax.swing.JCheckBox jCheckBoxMD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelValue;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void zaposleniUlogovan(EventObject evt) {
        zaposleni = (Zaposleni)evt.getSource();
    }


    
}
