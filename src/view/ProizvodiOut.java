
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
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Zaposleni;

public class ProizvodiOut extends javax.swing.JPanel implements IZaposleni{
    
    Zaposleni zaposleni;
    JOptionPane op = new JOptionPane();
    public static JTable jt;
    public static JList jLista1;
    public static JList jLista2;
    
    public ProizvodiOut() throws SQLException {
        initComponents();
        jList1.setModel(ControllerExit.setJListModel(1,3));
        jLista1=jList1;
        jList2.setModel(ControllerExit.setJListModel(2,3));
        jLista2=jList2;
        

        jRadioButton1.setActionCommand("1");
        jRadioButton1.setText("Proizvodi: ");
        jRadioButton2.setActionCommand("2");
        jRadioButton2.setText("Tip proizvoda: ");
        

        ControllerExit.setJTableStartLD(jTable1,3);
        jt=jTable1;
        
         /*Layout --pocetak*/
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int height = ((dimension.height-ControllerExit.Height70p)/2)-ControllerExit.Height10p;
        int width = (dimension.width-ControllerExit.Width39p)/2;
        jLabel1.setBounds(width+ControllerExit.Width15p, height, ControllerExit.Width9p, ControllerExit.Height4p);
        jRadioButton1.setBounds(width, height+ControllerExit.Height9p, ControllerExit.Width10p, ControllerExit.Height4p);
        jRadioButton2.setBounds(width+ControllerExit.Width29p, height+ControllerExit.Height9p, ControllerExit.Width10p, ControllerExit.Height4p);
        
        
        jScrollPane2.setBounds(width, height+ControllerExit.Height14p, ControllerExit.Width10p, ControllerExit.Height14p);
        jScrollPane5.setBounds(width+ControllerExit.Width29p, height+ControllerExit.Height14p, ControllerExit.Width10p, ControllerExit.Height14p);
        
        
        jScrollPane1.setBounds(width, height+ControllerExit.Height30p, ControllerExit.Width39p,ControllerExit.Height29p);
       
        
        jButtonOdaberi.setBounds(width+ControllerExit.Width06p,height + ControllerExit.Height61p, ControllerExit.Width8p,ControllerExit.Height4p);
        jButtonIzmeni.setBounds(width+ControllerExit.Width10p,height + ControllerExit.Height61p, ControllerExit.Width8p,ControllerExit.Height4p);
        jButtonIzbrisi.setBounds(width+ControllerExit.Width20p,height + ControllerExit.Height61p, ControllerExit.Width8p,ControllerExit.Height4p);
        jButtonNazad.setBounds(width+ControllerExit.Width30p,height + ControllerExit.Height61p, ControllerExit.Width8p,ControllerExit.Height4p);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jButtonOdaberi = new javax.swing.JButton();
        jButtonNazad = new javax.swing.JButton();
        jButtonIzmeni = new javax.swing.JButton();
        jButtonIzbrisi = new javax.swing.JButton();

        setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(102, 250, 537, 193);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton1.setText("jRadioButton1");
        add(jRadioButton1);
        jRadioButton1.setBounds(102, 61, 137, 31);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton2.setText("jRadioButton2");
        add(jRadioButton2);
        jRadioButton2.setBounds(546, 61, 137, 31);

        jList1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jList1);

        add(jScrollPane2);
        jScrollPane2.setBounds(102, 102, 93, 178);

        jList2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(jList2);

        add(jScrollPane5);
        jScrollPane5.setBounds(546, 102, 93, 178);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setText("Proizvodi:");
        add(jLabel1);
        jLabel1.setBounds(289, 11, 171, 32);

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
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOdaberiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOdaberiActionPerformed
        try {
            jTable1=ControllerExit.setJTableNabavkaMD(jTable1,ControllerExit.getSelectedFromJRButtonGroup(buttonGroup1,op), ControllerExit.getSelectedFromJRButton(buttonGroup1,jList1,null,jList2,null,op,3),3);
        }catch (NullPointerException ex){
            
            op.showMessageDialog(op.getParent(),"Niste odabrali parametre za pretragu, molimo vas odaberiti parametre i pokusajte ponovo!","Info",JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException ex) {
            op.showMessageDialog(op.getParent(),"Doslo je do greske pri povezivanju sa bazom! Molimo vas pokusajte ponovo, ukoliko se problem nastavi kontaktirajte vasu tehnicku podrsku!","Greska",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ProizvodiOut.class.getName()).log(Level.SEVERE, null, ex);
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
            ProizvodUpdate pu = new ProizvodUpdate (ControllerExit.getSelectedFromTable2(jTable1,3));
            JFrame jf = new JFrame ();
            jf.setContentPane(pu);
            jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
            jf.setVisible(true);
            jf.revalidate();
            zaposleni.addEventListener(pu);
            zaposleni.distributeEvent();
        }catch(ArrayIndexOutOfBoundsException ex) {
            op.showMessageDialog(op.getParent(),"Niste odabrali proizvod koju zelite da izmenite!","Info",JOptionPane.INFORMATION_MESSAGE);
            
        }  catch (SQLException ex) {
            Logger.getLogger(ProizvodiOut.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }//GEN-LAST:event_jButtonIzmeniActionPerformed

    private void jButtonIzbrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzbrisiActionPerformed
          try {
            boolean flag = ControllerExit.deleteFromTable(jTable1,3);
            if(flag){
                
            op.showMessageDialog(op.getParent(),"Uspesno izbrisan Proizvod!","Brisanje",JOptionPane.INFORMATION_MESSAGE);
            jList1.setModel(ControllerExit.setJListModel(1,3));
            jList2.setModel(ControllerExit.setJListModel(2,3));
            }else{
                op.showMessageDialog(op.getParent(),"Neuspesno izbrisan Proizvod!","Brisanje",JOptionPane.INFORMATION_MESSAGE);
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
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void zaposleniUlogovan(EventObject evt) {
        zaposleni = (Zaposleni)evt.getSource();
    }
}
