
package model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TipTroska {

    private int id;
    private String naziv;
    
    
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

  
    public String getNaziv() {
        return naziv;
    }

    
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
    @Override
    public String toString (){
        return this.getNaziv();
    }

   public void saveTipTroska () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("insert into tip_troska values (null,?)",Statement.RETURN_GENERATED_KEYS);
        st.setString(1, this.getNaziv());
        
        st.execute();
        ResultSet rs = st.getGeneratedKeys();
        if(rs.next()){
            this.setId(rs.getInt(1));
        }
    }
   /*Dobavljanje podataka iz baze --pocetak*/
   
   
    public static TipTroska getTipTroska (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_tip_troska(?)}");
        cs.setInt(1, id);
        TipTroska tip = null;
        ResultSet rs = cs.executeQuery();
        if (rs.next()){
            tip = new TipTroska ();
            tip.setId(rs.getInt("id"));
            tip.setNaziv(rs.getString("naziv"));
           
        }
        return tip;
    }
    
     public static List <TipTroska> getAllTipTroska () throws SQLException{
        DBConnect db = DBConnect.getInstance();
         CallableStatement cs = db.conn.prepareCall("{call get_all_tip_troska()}");
        List <TipTroska> lista = new ArrayList <TipTroska> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            TipTroska tip = new TipTroska();
            tip.setId(rs.getInt("id"));
            tip.setNaziv(rs.getString("naziv"));
            
            lista.add(tip);
        }
        return lista;    
    }
     
     
     /*Dobavljanje podataka iz baze --kraj*/
     
     
      public void updateTipTroska () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("update tip_troska set naziv=? where id=?");
        st.setString(1, this.getNaziv());
        st.setInt(2, this.getId());
        int result = st.executeUpdate();
        if(result == 1){
            System.out.println("update done");
        }else{
            System.out.println("update fail");
        }
        
        
        }
       public static void deleteTipTroska (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("delete from tip_troska where id=?");
        st.setInt(1, id);
        st.execute();
        }
       
}
