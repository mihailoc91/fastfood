
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
import model.TipTroska;
import model.Trosak;
import model.Zaposleni;


public class TroskoviUpdate extends javax.swing.JPanel implements IZaposleni {
    
    String naziv;
    
    double iznos;
    Zaposleni zaposleni;
    JOptionPane op = new JOptionPane();
    int id;
    
    public TroskoviUpdate(int id) throws SQLException {
        initComponents();
        this.id=id;
        Trosak t = Trosak.getTrosak(this.id);
        jTextField2.setText(t.getNaziv());
        jTextField1.setText(Double.toString(t.getIznos()));
        jList1.setModel(ControllerExit.setJListModel(3,6));
        jList1.setSelectedIndex(ControllerExit.pozicijaUJListiDatum(t.getDatum().getId(),6));
        jRadioButton1.setActionCommand("1");
        jRadioButton2.setActionCommand("2");
        jRadioButton1.setText(TipTroska.getTipTroska(1).getNaziv());
        jRadioButton2.setText(TipTroska.getTipTroska(2).getNaziv());
        if (t.getTipTroska().getId()==1){
            jRadioButton1.setSelected(true);
        }else{
            jRadioButton2.setSelected(true);
        }
        
           /*Layout --pocetak*/
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int height = ((dimension.height-ControllerExit.Height51p)/2)-ControllerExit.Height10p;
        int width = (dimension.width-ControllerExit.Width19p)/2;
        jLabel1.setBounds(width, height, ControllerExit.Width9p, ControllerExit.Height4p);
        jLabel2.setBounds(width, height+ControllerExit.Height9p, ControllerExit.Width8p, ControllerExit.Height4p);
        jTextField2.setBounds(width+ControllerExit.Width9p, height+ControllerExit.Height9p, ControllerExit.Width10p, ControllerExit.Height4p);
        jLabel3.setBounds(width, height+ControllerExit.Height14p, ControllerExit.Width8p, ControllerExit.Height4p);
        jScrollPane1.setBounds(width+ControllerExit.Width9p, height+ControllerExit.Height14p, ControllerExit.Width10p, ControllerExit.Height14p);
        jLabel5.setBounds(width, height+ControllerExit.Height30p, ControllerExit.Width8p, ControllerExit.Height4p);
        jTextField1.setBounds(width+ControllerExit.Width9p, height+ControllerExit.Height30p, ControllerExit.Width10p, ControllerExit.Height4p);
        jLabel4.setBounds(width, height+ControllerExit.Height38p, ControllerExit.Width8p, ControllerExit.Height4p);
        jRadioButton1.setBounds(width+ControllerExit.Width9p, height+ControllerExit.Height36p, ControllerExit.Width10p, ControllerExit.Height4p);
        jRadioButton2.setBounds(width+ControllerExit.Width9p, height+ControllerExit.Height41p, ControllerExit.Width10p, ControllerExit.Height4p);
        
        jButton1.setBounds(width+ControllerExit.Width06p,height + ControllerExit.Height47p, ControllerExit.Width8p,ControllerExit.Height4p);
        jButton2.setBounds(width+ControllerExit.Width10p,height + ControllerExit.Height47p, ControllerExit.Width8p,ControllerExit.Height4p);
        /*Layout --kraj*/  
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setText("Trosak:");
        add(jLabel1);
        jLabel1.setBounds(138, 11, 89, 26);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Naziv:");
        add(jLabel2);
        jLabel2.setBounds(53, 48, 70, 23);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Datum:");
        add(jLabel3);
        jLabel3.setBounds(47, 121, 70, 23);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("Tip troska:");
        add(jLabel4);
        jLabel4.setBounds(53, 267, 70, 23);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("Iznos:");
        add(jLabel5);
        jLabel5.setBounds(53, 213, 70, 23);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton1.setText("jRadioButton1");
        add(jRadioButton1);
        jRadioButton1.setBounds(123, 254, 137, 31);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton2.setText("jRadioButton2");
        add(jRadioButton2);
        jRadioButton2.setBounds(123, 280, 137, 31);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(jTextField1);
        jTextField1.setBounds(127, 214, 100, 21);

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(jTextField2);
        jTextField2.setBounds(127, 48, 100, 23);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Izmeni");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(87, 309, 85, 31);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Nazad");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(168, 309, 81, 31);

        jList1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        add(jScrollPane1);
        jScrollPane1.setBounds(127, 77, 100, 194);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        try {
            naziv = jTextField2.getText();
            iznos = Double.valueOf(jTextField1.getText());
            ControllerExit.updateTroskovi(this.id,buttonGroup1, ControllerExit.getSelectedFromJList(6, jList1,null),iznos, naziv,op);
            JFrame jf = (JFrame)SwingUtilities.getAncestorOfClass(JFrame.class, this);
            ControllerExit.setJTableStartLD(TroskoviOut.jt,6);
            TroskoviOut.jl.setText(Trosak.ukupnaVrednostTroskova());
            TroskoviOut.jLista1.setModel(ControllerExit.setJListModel(1,6));
            TroskoviOut.jLista2.setModel(ControllerExit.setJListModel(2,6));
            jf.setVisible(false);
            jf.dispose();
        }catch(NumberFormatException ex){
            op.showMessageDialog(op.getParent(),"Neispravan unos podataka! Molimo vas pokusajte ponovo!","Izmena",JOptionPane.ERROR_MESSAGE);
            
        }
        catch (SQLException ex) {
            Logger.getLogger(TroskoviUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      JFrame jf = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, this);
      jf.setVisible(false);
      jf.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void zaposleniUlogovan(EventObject evt) {
        zaposleni = (Zaposleni)evt.getSource();
    }
}
