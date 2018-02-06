
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
import model.Proizvod;
import model.Zaposleni;

public class ProizvodUpdate extends javax.swing.JPanel implements IZaposleni {
    String naziv;
    double cena;
    double kolicina;
    double  gramaza;
    Zaposleni zaposleni;
    JOptionPane op = new JOptionPane();
    int id=0;
    public ProizvodUpdate(int id) throws SQLException {
        
        initComponents();
        this.id=id;
        Proizvod proizvod = Proizvod.getProizvod(this.id);
        jTextField1.setText(proizvod.getNaziv());
        jTextField2.setText(String.valueOf(proizvod.getCena()));
        jTextField3.setText(String.valueOf(proizvod.getKolicina()));
        jTextField4.setText(String.valueOf(proizvod.getGramaza()));
        jList1.setModel(Controller.setJlistModelOfTipProizvoda());
        jList1.setSelectedIndex(ControllerExit.pozicijaUJListiTipProizvoda(proizvod.getTip().getId()));
        
         /*Layout --pocetak*/
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int height = ((dimension.height-ControllerExit.Height64p)/2)-ControllerExit.Height10p;
        int width = (dimension.width-ControllerExit.Width19p)/2;
        jLabel1.setBounds(width, height, ControllerExit.Width9p,ControllerExit.Height4p);
        jLabel2.setBounds(width, height+ControllerExit.Height9p, ControllerExit.Width8p, ControllerExit.Height4p);
        jTextField1.setBounds(width+ControllerExit.Width9p, height+ControllerExit.Height9p, ControllerExit.Width10p, ControllerExit.Height4p);
        jLabel3.setBounds(width, height+ControllerExit.Height14p, ControllerExit.Width8p, ControllerExit.Height4p);
        jTextField2.setBounds(width+ControllerExit.Width9p, height+ControllerExit.Height14p, ControllerExit.Width10p, ControllerExit.Height4p);
        jLabel4.setBounds(width, height+ControllerExit.Height20p, ControllerExit.Width8p, ControllerExit.Height4p);
        jTextField3.setBounds(width+ControllerExit.Width9p, height+ControllerExit.Height20p, ControllerExit.Width10p, ControllerExit.Height4p);
        jLabel5.setBounds(width, height+ControllerExit.Height26p, ControllerExit.Width8p, ControllerExit.Height4p);
        jTextField4.setBounds(width+ControllerExit.Width9p, height+ControllerExit.Height26p,ControllerExit.Width10p, ControllerExit.Height4p);
        jLabel6.setBounds(width, height+ControllerExit.Height31p, ControllerExit.Width8p, ControllerExit.Height4p);
        jScrollPane1.setBounds(width+ControllerExit.Width9p, height+ControllerExit.Height31p, ControllerExit.Width10p, ControllerExit.Height19p);
        
        jButtonIzmeni.setBounds(width+ControllerExit.Width06p,height + ControllerExit.Height60p, ControllerExit.Width8p,ControllerExit.Height4p);
        jButtonNazad.setBounds(width+ControllerExit.Width10p,height + ControllerExit.Height60p, ControllerExit.Width8p,ControllerExit.Height4p);
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
        jButtonIzmeni = new javax.swing.JButton();
        jButtonNazad = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(jList1);

        add(jScrollPane1);
        jScrollPane1.setBounds(124, 188, 82, 77);

        jButtonIzmeni.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonIzmeni.setText("Izmeni");
        jButtonIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzmeniActionPerformed(evt);
            }
        });
        add(jButtonIzmeni);
        jButtonIzmeni.setBounds(52, 305, 85, 31);

        jButtonNazad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonNazad.setText("Nazad");
        jButtonNazad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNazadActionPerformed(evt);
            }
        });
        add(jButtonNazad);
        jButtonNazad.setBounds(190, 305, 81, 31);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzmeniActionPerformed
       try {
            naziv = jTextField1.getText();
            cena = Double.valueOf(jTextField2.getText());
            kolicina = Double.valueOf(jTextField3.getText());
            gramaza = Double.valueOf(jTextField4.getText());
            ControllerExit.updateProizvod(this.id,naziv, cena, kolicina, gramaza, jList1, op);
            JFrame jf1 = (JFrame)SwingUtilities.getAncestorOfClass(JFrame.class,this);
            ControllerExit.setJTableStartLD(ProizvodiOut.jt,3);
            ProizvodiOut.jLista1.setModel(ControllerExit.setJListModel(1,3));
            ProizvodiOut.jLista2.setModel(ControllerExit.setJListModel(2,3));
            jf1.setVisible(false);
            jf1.dispose();
        }catch (NumberFormatException ex){
            Controller.praznoPolje(op);
            ex.printStackTrace();
        }catch (SQLException ex) {
            Logger.getLogger(ProizvodUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonIzmeniActionPerformed
            
    private void jButtonNazadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNazadActionPerformed
      JFrame jf1 = (JFrame)SwingUtilities.getAncestorOfClass(JFrame.class,this);
      jf1.setVisible(false);
      jf1.dispose();
    }//GEN-LAST:event_jButtonNazadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIzmeni;
    private javax.swing.JButton jButtonNazad;
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
