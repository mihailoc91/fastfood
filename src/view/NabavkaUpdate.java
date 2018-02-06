/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import model.Nabavka;
import controller.Controller;
import controller.ControllerExit;
import controller.IZaposleni;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.EventObject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.Dobavljac;
import model.Proizvod;
import model.TipTroska;
import model.Zaposleni;

/**
 *
 * @author I
 */
public class NabavkaUpdate extends javax.swing.JPanel implements IZaposleni {
        String datum = Controller.setDatum();
        Zaposleni zaposleni;
        JOptionPane op = new JOptionPane();
        int id=0;
        
        
    public NabavkaUpdate(int id) throws SQLException {
        
        initComponents();
        this.id=id;
        Nabavka nabavka =Nabavka.getNabavka(this.id);
        jLabel1.setText("Nabavka: " + nabavka.getId() );
        jList2.setModel(ControllerExit.setJListModel(1,8));
        jList2.setSelectedIndex(ControllerExit.pozicijaUJListiDatum(nabavka.getDatum().getId(),8));
        jRadioButton1.setActionCommand("1");
        jRadioButton2.setActionCommand("2");
        jRadioButton1.setText(TipTroska.getTipTroska(1).getNaziv());
        jRadioButton2.setText(TipTroska.getTipTroska(2).getNaziv());
        TipTroska tipTroska = nabavka.getTipTroska();
        ControllerExit.izborIzmedju2RB(jRadioButton1, jRadioButton2, tipTroska.getId());
        jList1.setModel(Controller.setJlistModelOfDobavljac());
        jList1.setSelectedIndex(ControllerExit.pozicijaUJListi(nabavka.getDobavljac().getId()));
        jTable1 = ControllerExit.setJTableProizvodiNabavkaUpdate(jTable1,this.id);
        
        /*Layout --pocetak*/
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (dimension.height-ControllerExit.Height75p)/2;
        int width = (dimension.width-ControllerExit.Width19p)/2;
        jLabel1.setBounds(width, height-ControllerExit.Height10p, ControllerExit.Width9p, ControllerExit.Height4p);
        jLabel2.setBounds(width, height, ControllerExit.Width8p, ControllerExit.Height4p);
        jScrollPane3.setBounds(width+ControllerExit.Width9p, height, ControllerExit.Width10p, ControllerExit.Height14p);
        jLabel3.setBounds(width, height+ControllerExit.Height16p, ControllerExit.Width8p, ControllerExit.Height4p);
        jScrollPane1.setBounds(width+ControllerExit.Width9p, height+ControllerExit.Height16p, ControllerExit.Width10p, ControllerExit.Height14p);
        jLabel4.setBounds(width, height+ControllerExit.Height35p, ControllerExit.Width8p, ControllerExit.Height4p);
        jRadioButton1.setBounds(width+ControllerExit.Width9p, height+ControllerExit.Height32p, ControllerExit.Width10p, ControllerExit.Height4p);
        jRadioButton2.setBounds(width+ControllerExit.Width9p, height+ControllerExit.Height37p, ControllerExit.Width10p, ControllerExit.Height4p);
        jScrollPane2.setBounds(width-ControllerExit.Width10p, height + ControllerExit.Height43p, ControllerExit.Width39p, ControllerExit.Height29p);
        
        jButton1.setBounds(width+ControllerExit.Width06p,height + ControllerExit.Height73p, ControllerExit.Width8p,ControllerExit.Height4p);
        jButton2.setBounds(width+ControllerExit.Width10p,height + ControllerExit.Height73p, ControllerExit.Width8p,ControllerExit.Height4p);
        
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(320, 20, 100, 23);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Datum:");
        add(jLabel2);
        jLabel2.setBounds(230, 65, 51, 23);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Dobavljac:");
        add(jLabel3);
        jLabel3.setBounds(230, 143, 95, 23);

        jList1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        add(jScrollPane1);
        jScrollPane1.setBounds(330, 146, 94, 78);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("Tip troska:");
        add(jLabel4);
        jLabel4.setBounds(230, 235, 96, 24);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Izmeni");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(159, 454, 85, 31);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Nazad");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(284, 454, 81, 31);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton1.setText("jRadioButton1");
        add(jRadioButton1);
        jRadioButton1.setBounds(331, 236, 137, 31);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton2.setText("jRadioButton2");
        jRadioButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(jRadioButton2);
        jRadioButton2.setBounds(331, 266, 137, 31);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);

        add(jScrollPane2);
        jScrollPane2.setBounds(87, 307, 375, 108);

        jList2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList2);

        add(jScrollPane3);
        jScrollPane3.setBounds(321, 65, 124, 60);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            try {
                    ControllerExit.updateNabavke(this.id, zaposleni.getId(), jList2, jList1, buttonGroup1,jTable1,1,2,op);
                    JFrame jf1 = (JFrame)SwingUtilities.getAncestorOfClass(JFrame.class, this);
                    ControllerExit.setJTableStartLD(NabavkaOut.jt,1);
                    NabavkaOut.jl.setText(Nabavka.ukupnaVrednost());
                    NabavkaOut.jLista1.setModel(ControllerExit.setJListModel(4,1));
                    NabavkaOut.jLista4.setModel(ControllerExit.setJListModel(2,1));
                    NabavkaOut.jLista2.setModel(ControllerExit.setJListModel(3,1));
                    NabavkaOut.jLista3.setModel(ControllerExit.setJListModel(1,1));
                    jf1.setVisible(false);
                    jf1.dispose();
            } catch (NullPointerException ex){
                op.showMessageDialog(op.getParent(),"Neispravan odabir podataka. Molimo vas pokusajte ponovo!","Upozorenje",JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(NabavkaUpdate.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex){
                op.showMessageDialog(op.getParent(),"Greska. Molimo vas pokusajte ponovo!","Greska",JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
                
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       JFrame jf1 = (JFrame)SwingUtilities.getAncestorOfClass(JFrame.class, this);
       jf1.setVisible(false);
       jf1.dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void zaposleniUlogovan(EventObject evt) {
        zaposleni = (Zaposleni) evt.getSource();
    }
}
