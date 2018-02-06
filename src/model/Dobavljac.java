
package model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dobavljac {

    private int id;
    private String naziv;
    private String pib;
    private String adresa;
    private String telefon;
    
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

    
    public String getPib() {
        return pib;
    }

    
    public void setPib(String pib) {
        this.pib = pib;
    }

    
    public String getAdresa() {
        return adresa;
    }

    
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    
    public String getTelefon() {
        return telefon;
    }

    
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
    @Override
    public String toString (){
        return this.getNaziv();
    }
    
    public void saveDobavljac () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("insert into dobavljaci values (null,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        st.setString(1, this.getNaziv());
        st.setString(2, this.getPib());
        st.setString(3, this.adresa);
        st.setString(4, this.telefon);
        st.execute();
        ResultSet rs = st.getGeneratedKeys();
        if(rs.next()){
            this.setId(rs.getInt(1));
        }
    }
/*Dobavljanje podataka iz baze --pocetak*/    
    
    
     public static Dobavljac getDobavljac (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_dobavljac(?)}");
        cs.setInt(1, id);
        Dobavljac d = null;
        ResultSet rs = cs.executeQuery();
        if (rs.next()){
            d = new Dobavljac ();
            d.setId(rs.getInt("id"));
            d.setNaziv(rs.getString("naziv"));
            d.setPib(rs.getString("pib"));
            d.setAdresa(rs.getString("adresa"));
            d.setTelefon(rs.getString("telefon"));
        }
        return d;
    }
     
      public static Dobavljac getDobavljacFromTable (String naziv,String Pib) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_dobavljac_from_table(?,?)}");
        cs.setString(1, naziv);
        cs.setString(2, Pib);
        Dobavljac d = null;
        ResultSet rs = cs.executeQuery();
        if (rs.next()){
            d = new Dobavljac ();
            d.setId(rs.getInt("id"));
            d.setNaziv(rs.getString("naziv"));
            d.setPib(rs.getString("pib"));
            d.setAdresa(rs.getString("adresa"));
            d.setTelefon(rs.getString("telefon"));
        }
        return d;
    }
     
     public static List <Dobavljac> getAllDobavljac () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_dobavljaci()}");
        List <Dobavljac> lista = new ArrayList <Dobavljac> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Dobavljac d = new Dobavljac();
            d.setId(rs.getInt("id"));
            d.setNaziv(rs.getString("naziv"));
            d.setPib(rs.getString("pib"));
            d.setAdresa(rs.getString("adresa"));
            d.setTelefon(rs.getString("telefon"));
            lista.add(d);
        }
        return lista;    
    }
     
     
     public static List <Dobavljac> getAllDobavljacFromNabavkeList () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_dobavljaci_from_nabavke_2()}");
        List <Dobavljac> lista = new ArrayList <Dobavljac> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Dobavljac d = new Dobavljac();
            d.setId(rs.getInt("id"));
            d.setNaziv(rs.getString("naziv"));
            d.setPib(rs.getString("pib"));
            d.setAdresa(rs.getString("adresa"));
            d.setTelefon(rs.getString("telefon"));
            lista.add(d);
        }
        return lista;    
    }
     
    /*Dobavlja podatke potrebne za prvu tabelu */
     public static List <String> getAllObjDobavljac () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call dob_get_all_obj_dobavljaci()}");
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Double iznos =rs.getDouble(5);
            lista.add(new String (rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+String.valueOf(iznos)));
        }
        return lista;    
    }
     
         /*Dobavlja podatke sortirane po vrednosti nabavke za tabelu */
     public static List <String> getAllObjDobavljacSortedByValue () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call dob_get_all_obj_dobavljaci_sort_by_value()}");
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Double iznos =rs.getDouble(5);
            lista.add(new String (rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+String.valueOf(iznos)));
        }
        return lista;    
    }
     
     /*Dobavlja podatke za konkretnog dobavljaca za potrebe tabele */
      public static List <String> getAllObjDobavljacByDobavljac (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call dob_get_dobavljaci_by_dobavljac(?)}");
        cs.setInt(1, id);
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Double iznos =rs.getDouble(5);
            lista.add(new String (rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+String.valueOf(iznos)));
        }
        return lista;    
    }
     
     
     
     public static List <String> getAllDobavljac2 () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_dobavljaci()}");
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Dobavljac d = new Dobavljac();
            d.setId(rs.getInt("id"));
            d.setNaziv(rs.getString("naziv"));
            d.setPib(rs.getString("pib"));
            d.setAdresa(rs.getString("adresa"));
            d.setTelefon(rs.getString("telefon"));
            String s = new String (Integer.toString(d.getId())+","+d.getNaziv()+","+d.getPib()+","+d.getAdresa()+","+d.getTelefon());
            lista.add(s);
        }
        return lista;    
    }
     
        public static Map getAllDobavljacFromNabavke () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_dobavljaci_from_nabavke()}");
        Map mapa = new HashMap();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            int id=rs.getInt(1);
            mapa.put(id, id);
        }
        return mapa;    
    }
     
     
/*Dobavljanje podataka iz baze --kraj*/   
        
        
     public int updateDobavljac () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("update dobavljaci set naziv=?, pib=?, adresa=?, telefon=? where id=?");
        st.setString(1, this.naziv);
        st.setString(2, this.pib);
        st.setString(3, this.adresa);
        st.setString(4, this.telefon);
        st.setInt(5, this.id);
         int result = st.executeUpdate();
        
        if(result == 1){
            System.out.println("update done");
        }else{
            System.out.println("update fail");
        }
        return result;
    }
     
    public static boolean deleteDobavljac (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("delete from dobavljaci where id=?");
        st.setInt(1, id);
         int i=st.executeUpdate();
        
        boolean flag = false;
        if (i>0){
            flag = true;
        }
        return flag;
    }
    
    
}
