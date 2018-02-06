
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

public class ProizvodForm extends javax.swing.JPanel implements IZaposleni {
    String naziv;
    double cena;
    double kolicina;
    double  gramaza;
    Zaposleni zaposleni;
    JOptionPane op = new JOptionPane();
    public ProizvodForm() throws SQLException {
        initComponents();
        jList1.setModel(Controller.setJlistModelOfTipProizvoda());
        
        /*Layout --pocetak*/
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (dimension.height-ControllerExit.Height64p)/2;
        int width = (dimension.width-ControllerExit.Width19p)/2;
        jLabel1.setBounds(width, height, ControllerExit.Width9p, ControllerExit.Height4p);
        jLabel2.setBounds(width, height+ControllerExit.Height9p, ControllerExit.Width8p, ControllerExit.Height4p);
        jTextField1.setBounds(width+ControllerExit.Width9p, height+ControllerExit.Height9p, ControllerExit.Width10p, ControllerExit.Height4p);
        jLabel3.setBounds(width, height+ControllerExit.Height14p, ControllerExit.Width8p, ControllerExit.Height4p);
        jTextField2.setBounds(width+ControllerExit.Width9p, height+ControllerExit.Height14p, ControllerExit.Width10p, ControllerExit.Height4p);
        jLabel4.setBounds(width, height+ControllerExit.Width13p, ControllerExit.Height12p, ControllerExit.Height4p);
        jTextField3.setBounds(width+ControllerExit.Width9p, height+ControllerExit.Height20p, ControllerExit.Width10p, ControllerExit.Height4p);
        jLabel5.setBounds(width, height+ControllerExit.Height26p, ControllerExit.Width8p, ControllerExit.Height4p);
        jTextField4.setBounds(width+ControllerExit.Width9p, height+ControllerExit.Height26p, ControllerExit.Width10p, ControllerExit.Height4p);
        jLabel6.setBounds(width, height+ControllerExit.Height31p, ControllerExit.Width8p, ControllerExit.Height4p);
        jScrollPane1.setBounds(width+ControllerExit.Width9p, height+ControllerExit.Height31p, ControllerExit.Width10p, ControllerExit.Height19p);
        
        jButton1.setBounds(width+ControllerExit.Width06p,height + ControllerExit.Height60p, ControllerExit.Width8p,ControllerExit.Height4p);
        jButton2.setBounds(width+ControllerExit.Width10p,height + ControllerExit.Height60p, ControllerExit.Width8p,ControllerExit.Height4p);
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
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setText("Proizvod:");
        add(jLabel1);
        jLabel1.setBounds(115, 11, 140, 25);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Naziv:");
        add(jLabel2);
        jLabel2.setBounds(52, 54, 57, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Cena:");
        add(jLabel3);
        jLabel3.setBounds(52, 97, 57, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("Kolicina");
        add(jLabel4);
        jLabel4.setBounds(52, 135, 57, 23);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("Gramaza");
        add(jLabel5);
        jLabel5.setBounds(52, 164, 57, 24);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setText("Tip proizvoda:");
        add(jLabel6);
        jLabel6.setBounds(52, 216, 127, 23);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(jTextField1);
        jTextField1.setBounds(115, 54, 97, 28);

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(jTextField2);
        jTextField2.setBounds(115, 97, 97, 28);

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(jTextField3);
        jTextField3.setBounds(113, 136, 99, 28);

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(jTextField4);
        jTextField4.setBounds(113, 164, 99, 22);

        jList1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        add(jScrollPane1);
        jScrollPane1.setBounds(124, 188, 82, 77);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Sacuvaj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(52, 305, 93, 31);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Nazad");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(198, 305, 81, 31);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try {
            naziv = jTextField1.getText();
            cena = Double.valueOf(jTextField2.getText());
            kolicina = Double.valueOf(jTextField3.getText());
            gramaza = Double.valueOf(jTextField4.getText());
            Controller.saveProizvod(naziv, cena, kolicina, gramaza, jList1,op);
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
        }catch (NumberFormatException ex){
            Controller.praznoPolje(op);
            ex.printStackTrace();
        }catch (SQLException ex) {
            Logger.getLogger(ProizvodForm.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception ex){
            ex.printStackTrace();
        }
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
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
