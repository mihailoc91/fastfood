package model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Trosak {
    
    public Trosak (TipTroska tip, Datum datum){
        this.setTipTroska(tip);
        this.setDatum(datum);
    }
    
    public Trosak (int idTipTroska, int idDatum) throws SQLException{
        this.setTipTroska(TipTroska.getTipTroska(idTipTroska));
        this.setDatum(Datum.getDatum(idDatum));
        
    }
    
    private int id;
    private TipTroska tipTroska;
    private Datum datum;
    private double iznos;
    private String naziv;

   
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public TipTroska getTipTroska() {
        return tipTroska;
    }

    
    public void setTipTroska(TipTroska tipTroska) {
        this.tipTroska = tipTroska;
    }

    
    public Datum getDatum() {
        return datum;
    }

    
    public void setDatum(Datum datum) {
        this.datum = datum;
    }

   
    public double getIznos() {
        return iznos;
    }

    
    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    
    public String getNaziv() {
        return naziv;
    }

    
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
    public void saveTrosak () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("insert into troskovi (id,tip_troska, datum, iznos, naziv )values (null,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        st.setInt(1, this.getTipTroska().getId());
        st.setInt(2, this.getDatum().getId());
        st.setDouble(3, this.getIznos());
        st.setString(4, this.getNaziv());
        
        st.execute();
        ResultSet rs = st.getGeneratedKeys();
        if(rs.next()){
            this.setId(rs.getInt(1));
        }
    }
/*Dobavljanje podataka iz baze --pocetak*/    
    
    
    public static Trosak getTrosak (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs= db.conn.prepareCall("{call get_trosak(?)}");
        cs.setInt(1, id);
        Trosak t = null;
        ResultSet rs = cs.executeQuery();
        if (rs.next()){
            t = new Trosak (rs.getInt("tip_troska"), rs.getInt("datum"));
            t.setIznos(rs.getDouble("iznos"));
            t.setNaziv(rs.getString("naziv"));
            t.setId(rs.getInt("id"));
        }
        return t;
    }  

    public static List <Trosak> getAllTrosak () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs= db.conn.prepareCall("{call get_all_trosak()}");
        List <Trosak> lista = new ArrayList <Trosak> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Trosak t = new Trosak(rs.getInt("tip_troska"), rs.getInt("datum"));
            t.setIznos(rs.getDouble("iznos"));
            t.setNaziv(rs.getString("naziv"));
            
            lista.add(t);
        }
        return lista; 
    
    }
    
    public static List <String> getAllObjTroskovi () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs= db.conn.prepareCall("{call get_all_trosak()}");
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Trosak t = new Trosak(rs.getInt("tip_troska"), rs.getInt("datum"));
            t.setIznos(rs.getDouble("iznos"));
            t.setNaziv(rs.getString("naziv"));
            t.setId(rs.getInt("id"));
            lista.add(new String(t.getNaziv()+","+t.getDatum().toString()+","+Double.toString(t.getIznos())));
        }
        return lista;    
    }
    
      public static List <String> getAllObjTroskovi2 () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs= db.conn.prepareCall("{call get_all_trosak()}");
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Trosak t = new Trosak(rs.getInt("tip_troska"), rs.getInt("datum"));
            t.setIznos(rs.getDouble("iznos"));
            t.setNaziv(rs.getString("naziv"));
            t.setId(rs.getInt("id"));
            lista.add(new String(Integer.toString(t.getId())+","+t.getNaziv()+","+t.getDatum().toString()+","+Double.toString(t.getIznos())));
        }
        return lista;    
    }
    
    public static List <String> getAllObjTroskoviForDatum (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs= db.conn.prepareCall("{call get_all_obj_troskovi_for_datum(?)}");
        cs.setInt(1, id);
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Trosak t = new Trosak(rs.getInt("tip_troska"), rs.getInt("datum"));
            t.setId(rs.getInt("id"));
            t.setIznos(rs.getDouble("iznos"));
            t.setNaziv(rs.getString("naziv"));
            lista.add(new String(t.getNaziv()+","+t.getDatum().toString()+","+Double.toString(t.getIznos())));
        }
        return lista;    
    }
    
    public static List <String> getAllObjDistinctTroskoviForDatum (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs= db.conn.prepareCall("{call get_all_obj_distinct_troskovi_for_datum(?)}");
        cs.setInt(1, id);
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            int i = rs.getInt(1);
            
            lista.add(new String(Integer.toString(i)));
        }
        return lista;    
    }
    
    public static String ukupnaVrednostTroskova () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("select trosak_ukupna_vrednost_troska()");
        ResultSet rs = st.executeQuery();
        if(rs.next())
            return String.valueOf(rs.getDouble(1));
        return null;
    }
    
     public static String ukupnaVrednostTroskovaForDatum (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("select trosak_ukupna_vrednost_troska_za_datum(?)");
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        if(rs.next())
            return String.valueOf(rs.getDouble(1));
        return null;
    }
     
      public static String ukupnaVrednostTroskovaForTipTroska (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("select trosak_ukupna_vrednost_troska_za_tip_troska(?)");
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        if(rs.next())
            return String.valueOf(rs.getDouble(1));
        return null;
    }
    
    public static List <String> getAllObjTroskoviForTipTroska (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs= db.conn.prepareCall("{call get_all_obj_troskovi_for_tip_troska(?)}");
        cs.setInt(1, id);
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Trosak t = new Trosak(rs.getInt("tip_troska"), rs.getInt("datum"));
            t.setId(rs.getInt("id"));
            t.setIznos(rs.getDouble("iznos"));
            t.setNaziv(rs.getString("naziv"));
            
            lista.add(new String(t.getNaziv()+","+t.getDatum().toString()+","+Double.toString(t.getIznos())));
        }
        return lista;    
    }
    
    public static List <String> getAllObjDistinctTroskoviForTipTroska (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs= db.conn.prepareCall("{call get_all_obj_distinct_troskovi_for_tip_troska(?)}");
        cs.setInt(1, id);
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
             int i = rs.getInt(1);
            
            lista.add(new String(Integer.toString(i)));
        }
        return lista;    
    }
    
     public static List <String> getAllObjTroskoviDistinct () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs= db.conn.prepareCall("{call get_all_obj_troskovi_distinct()}");
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            int row =rs.getInt(1);
            
            lista.add(new String(Integer.toString(row)));
        }
        return lista;    
    }
    
    /*Dobavljanje podataka iz baze --kraj*/    
    
    
    
    public int updateTrosak () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("update troskovi set tip_troska=?, datum=?, iznos=?, naziv=? where id=?");
        st.setInt(1, this.tipTroska.getId());
        st.setInt(2, this.datum.getId());
        st.setDouble(3, this.getIznos());
        st.setString(4, this.getNaziv());
        st.setInt(5, this.getId());
        
         int result = st.executeUpdate();
        
        if(result == 1){
            System.out.println("update done");
        }else{
            System.out.println("update fail");
        }
        return result;
        
       
    }
    
    public static boolean deleteTrosak (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("delete from troskovi where id=?");
        st.setInt(1, id);
        int i=st.executeUpdate();
        
        boolean flag = false;
        if (i>0){
            flag = true;
        }
        return flag;
   }
    
}
