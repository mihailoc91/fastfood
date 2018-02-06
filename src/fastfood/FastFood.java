
package fastfood;

import controller.ControllerExit;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.UIManager;
import view.Login;
import javax.swing.UIManager.LookAndFeelInfo;
import model.Proizvod;



public class FastFood {

 
  
  
    public static void main(String[] args) throws SQLException {
        
        

        Login l = new Login ();
        
        l.setExtendedState(JFrame.MAXIMIZED_BOTH);
        l.setVisible(true);
       
        
        
        try{
            for (LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
                if("Windows".equals(info.getName())){
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        

        



        

 
    

       






    }
    
}
