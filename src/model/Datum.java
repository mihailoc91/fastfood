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


public class Datum {

    private int id;
    private int dan;
    private int mesec;
    private int godina;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDan() {
        return dan;
    }

    public void setDan(int dan) {
        this.dan = dan;
    }

    public int getMesec() {
        return mesec;
    }

    public void setMesec(int mesec) {
        this.mesec = mesec;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    @Override
    public String toString (){
        return this.getDan()+"."+this.getMesec()+"."+this.getGodina()+".";
    }

    public void saveDatum () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("insert into datum values (null,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        st.setInt(1, this.getDan());
        st.setInt(2, this.getMesec());
        st.setInt(3, this.getGodina());
        st.execute();
        ResultSet rs = st.getGeneratedKeys();
        if(rs.next()){
            this.setId(rs.getInt(1));
        }
    }
 /*Dobavljanje podataka iz baze --pocetak*/ 
    
    
      public static Datum getDatum (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_datum(?)}");
        cs.setInt(1, id);
        Datum d= null;
        ResultSet rs= cs.executeQuery();
        if (rs.next()){
            d = new Datum ();
            d.setId(rs.getInt("id"));
            d.setDan(rs.getInt("dan"));
            d.setMesec(rs.getInt("mesec"));
            d.setGodina(rs.getInt("godina"));
        }
        return d;
    }
      
 public static List <Datum> getAllDatum () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_datum()}");
        List <Datum> lista = new ArrayList <Datum> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Datum d = new Datum();
            d.setId(rs.getInt("id"));
            d.setDan(rs.getInt("dan"));
            d.setMesec(rs.getInt("mesec"));
            d.setGodina(rs.getInt("godina"));
            lista.add(d);
        }
        return lista;    
    }
    

    public static List <Datum> getAllDatumFromNabavka () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_datum_from_nabavka()}");
        List <Datum> lista = new ArrayList <Datum> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Datum d = new Datum();
            d.setId(rs.getInt("id"));
            d.setDan(rs.getInt("dan"));
            d.setMesec(rs.getInt("mesec"));
            d.setGodina(rs.getInt("godina"));
            lista.add(d);
        }
        return lista;    
    }
    
    public static List <Datum> getAllDatumFromTroskovi () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_datum_from_troskovi()}");
        List <Datum> lista = new ArrayList <Datum> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Datum d = new Datum();
            d.setId(rs.getInt("id"));
            d.setDan(rs.getInt("dan"));
            d.setMesec(rs.getInt("mesec"));
            d.setGodina(rs.getInt("godina"));
            lista.add(d);
        }
        return lista;    
    }
    
    public static List <Datum> getAllDatumFromDnevniIzvestaj () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_datum_from_dnevni_izvestaji()}");
        List <Datum> lista = new ArrayList <Datum> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Datum d = new Datum();
            d.setId(rs.getInt("id"));
            d.setDan(rs.getInt("dan"));
            d.setMesec(rs.getInt("mesec"));
            d.setGodina(rs.getInt("godina"));
            lista.add(d);
        }
        return lista;    
    }
    
    public static Datum getLastId () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call datum_get_last_id()}");
        ResultSet rs = cs.executeQuery();
        Datum d = new Datum();
        if (rs.next()){
            d.setId(rs.getInt("id"));
            d.setDan(rs.getInt("dan"));
            d.setMesec(rs.getInt("mesec"));
            d.setGodina(rs.getInt("godina"));
        }
        return d;
    }
    
    public static Map getAllDays () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call datum_get_all_days()}");
        ResultSet rs = cs.executeQuery();
        Map  mapa = new HashMap ();
        int k=0;
        while(rs.next()){
            mapa.put(k,rs.getInt(1));
            k++;
        }
        return mapa;
    }
    public static Map getAllMonths () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call datum_get_all_months()}");
        ResultSet rs = cs.executeQuery();
        Map mapa = new HashMap ();
        int k=0;
        while (rs.next()){
            mapa.put(k,rs.getInt(1));
            k++;
        }
        return mapa;
    }
    public static Map getAllYears () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call datum_get_all_years()}");
        ResultSet rs = cs.executeQuery();
        Map mapa = new HashMap ();
        int k=0;
        while(rs.next()){
            mapa.put(k,rs.getInt(1));
            k++;
        }
        return mapa;
    }
    
    
/*Dobavljanje podataka iz baze --kraj*/  

    
     public void updateDatum () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("update datum set dan=?, mesec=?, godina=? where id=?");
        st.setInt(1, this.getDan());
        st.setInt(2, this.getMesec());
        st.setInt(3, this.getGodina());
        
        st.setInt(4, this.getId());
        int result = st.executeUpdate();
        if(result == 1){
            System.out.println("update done");
        }else{
            System.out.println("update fail");
        }
    }
     
     public static void deleteDatum (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("delete from datum where id=?");
        st.setInt(1, id);
        st.execute();
    }
}
