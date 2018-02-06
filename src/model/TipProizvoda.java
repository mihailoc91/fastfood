
package model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TipProizvoda {

    private int id;
    private String naziv;
    private String opis;
    
    public List <TipProizvoda> listaTipaProizvoda;
 
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

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    @Override
    public String toString (){
        return this.getNaziv();
    }
    
    
    public void saveTipProizvoda () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement ps = db.conn.prepareStatement("insert into tip_proizvoda values (null,?,?)",Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, this.getNaziv());
        ps.setString(2, this.getOpis());
        ps.execute();
        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()){
            this.setId(rs.getInt(1));
        }
    }
/*Dobavljanje podataka iz baze --pocetak*/      
    
    
    public static TipProizvoda getTipProizvoda (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_tip_proizvoda(?)}");
        cs.setInt(1, id);
        TipProizvoda tip = null;
        ResultSet rs = cs.executeQuery();
        if (rs.next()){
            tip = new TipProizvoda ();
            tip.setId(rs.getInt("id"));
            tip.setNaziv(rs.getString("naziv"));
            tip.setOpis(rs.getString("opis"));
          
        }
        return tip;
    }
     public static int getTipProizvoda (String naziv) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_tip_proizvoda_string(?)}");
        cs.setString(1, naziv);
        TipProizvoda tip = null;
        ResultSet rs = cs.executeQuery();
        if (rs.next()){
            tip = new TipProizvoda ();
            tip.setId(rs.getInt("id"));
            tip.setNaziv(rs.getString("naziv"));
            tip.setOpis(rs.getString("opis"));
          
        }
        return tip.getId();
    }
    
    public static List <TipProizvoda> getAllTipProizvoda () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_tip_proizvoda()}");
        List <TipProizvoda> lista = new ArrayList <TipProizvoda> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            TipProizvoda tip = new TipProizvoda ();
            tip.setId(rs.getInt("id"));
            tip.setNaziv(rs.getString("naziv"));
            tip.setOpis(rs.getString("opis"));
            lista.add(tip);
        }
        return lista;    
    }
    
     public static List <TipProizvoda> getAllTipProizvodaFromProizvodi () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_tip_proizvoda_from_proizvodi()}");
        List <TipProizvoda> lista = new ArrayList <TipProizvoda> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            TipProizvoda tip = new TipProizvoda ();
            tip.setId(rs.getInt("id"));
            tip.setNaziv(rs.getString("naziv"));
            tip.setOpis(rs.getString("opis"));
            lista.add(tip);
        }
        return lista; 
    
    }
     
     public static List <String> getAllObjTipProizvoda () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_tip_proizvoda()}");
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
           lista.add(new String (rs.getString("naziv")+","+rs.getString("opis")));
        }
        return lista;    
    }
     
     public static List <String> getAllObjTipProizvoda (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_tip_proizvoda(?)}");
        cs.setInt(1, id);
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            lista.add(new String (rs.getString("naziv")+","+rs.getString("opis")));
        }
        return lista;    
    }
/*Dobavljanje podataka iz baze --kraj*/  

     
    public int updateTipProizvoda () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("update tip_proizvoda set naziv=?, opis=? where id=?");
        st.setString(1, this.naziv);
        st.setString(2, this.opis);
        st.setInt(3, this.id);
        int result = st.executeUpdate();
        
        if(result == 1){
            System.out.println("update done");
        }else{
            System.out.println("update fail");
        }
        return result;
    }
    
    public static boolean deleteTipProizvoda (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("delete from tip_proizvoda where id=?");
        st.setInt(1, id);
        int i=st.executeUpdate();
        
        boolean flag = false;
        if (i>0){
            flag = true;
        }
        return flag;
    }
    
    
}
