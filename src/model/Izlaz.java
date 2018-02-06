
package model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Izlaz {

    
    public double getIzlaz() {
        return izlaz;
    }

    
    public void setIzlaz(double izlaz) {
        this.izlaz = izlaz;
    }

    
    public DnevniIzvestaj getDnevniIzvestaj() {
        return dnevniIzvestaj;
    }

    
    public void setDnevniIzvestaj(DnevniIzvestaj dnevniIzvestaj) {
        this.dnevniIzvestaj = dnevniIzvestaj;
    }

    
    public Proizvod getProizvod() {
        return proizvod;
    }

    
    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    
    public Datum getDatum() {
        return datum;
    }

    
    public void setDatum(Datum datum) {
        this.datum = datum;
    }
    
    private double izlaz;
    private DnevniIzvestaj dnevniIzvestaj;
    private Proizvod proizvod;
    private Datum datum;
    
    public static String getLastIzlaz () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call izlaz_get_last_izlaz()}");
        ResultSet rs = cs.executeQuery();
        if(rs.next()){
            return new String (String.valueOf(rs.getDouble(1)+","+String.valueOf(rs.getInt(2))+","+String.valueOf(rs.getInt(3))));
        }
        return "";
    }
    
    public static double getLastIzlazValue () throws SQLException{
    DBConnect db = DBConnect.getInstance();
    PreparedStatement st = db.conn.prepareStatement("select izlaz_last_id_vrednost_izlaz()");
    ResultSet rs = st.executeQuery();
    if(rs.next()){
    return rs.getDouble(1);
    }
    return 0;
} 
    
    public static List <String> getIzlazByDay(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call izlaz_get_izlaz_by_day(?)}");
        cs.setInt(1, id);
        List <String> lista = new ArrayList<String>();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            lista.add(new String (String.valueOf(rs.getDouble(1)+","+String.valueOf(rs.getInt(2)))));
        
        }
        return lista;
    }
    
    public static double getIzlazByDayValue (int id) throws SQLException{
    DBConnect db = DBConnect.getInstance();
    PreparedStatement st = db.conn.prepareStatement("select izlaz_get_izlaz_by_day_f(?)");
    st.setInt(1, id);
    ResultSet rs = st.executeQuery();
    if(rs.next()){
    return rs.getDouble(1);
    }
    return 0;
} 
    
    public static List <String> getIzlazByMonth(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call izlaz_get_izlaz_by_month(?)}");
        cs.setInt(1, id);
        List <String> lista = new ArrayList<String>();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            lista.add(new String (String.valueOf(rs.getDouble(1)+","+String.valueOf(rs.getInt(2)))));
        
        }
        return lista;
    }
    
    public static double getIzlazByMonthValue (int id) throws SQLException{
    DBConnect db = DBConnect.getInstance();
    PreparedStatement st = db.conn.prepareStatement("select izlaz_get_izlaz_by_month_f(?)");
    st.setInt(1, id);
    ResultSet rs = st.executeQuery();
    if(rs.next()){
    return rs.getDouble(1);
    }
    return 0;
} 
    
    public static List <String> getIzlazByYear(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call izlaz_get_izlaz_by_year(?)}");
        cs.setInt(1, id);
        List <String> lista = new ArrayList<String>();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            lista.add(new String (String.valueOf(rs.getDouble(1)+","+String.valueOf(rs.getInt(2)))));
        
        }
        return lista;
    }
    
    public static double getIzlazByYearValue (int id) throws SQLException{
    DBConnect db = DBConnect.getInstance();
    PreparedStatement st = db.conn.prepareStatement("select izlaz_get_izlaz_by_year_f(?)");
    st.setInt(1, id);
    ResultSet rs = st.executeQuery();
    if(rs.next()){
    return rs.getDouble(1);
    }
    return 0;
} 
    
    public static List <String> getIzlazByDayAndMonth(int id, int id2) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call izlaz_get_izlaz_by_day_and_month(?,?)}");
        cs.setInt(1, id);
        cs.setInt(2, id2);
        List <String> lista = new ArrayList<String>();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            lista.add(new String (String.valueOf(rs.getDouble(1)+","+String.valueOf(rs.getInt(2)))));
        
        }
        return lista;
    }
    
    public static double getIzlazByDayAndMonthValue (int id, int id2) throws SQLException{
    DBConnect db = DBConnect.getInstance();
    PreparedStatement st = db.conn.prepareStatement("select izlaz_get_izlaz_by_day_and_month_f(?,?)");
    st.setInt(1, id);
    st.setInt(2, id2);
    ResultSet rs = st.executeQuery();
    if(rs.next()){
    return rs.getDouble(1);
    }
    return 0;
} 
    
       public static List <String> getIzlazByDayAndYear(int id, int id2) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call izlaz_get_izlaz_by_day_and_year(?,?)}");
        cs.setInt(1, id);
        cs.setInt(2, id2);
        List <String> lista = new ArrayList<String>();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            lista.add(new String (String.valueOf(rs.getDouble(1)+","+String.valueOf(rs.getInt(2)))));
        
        }
        return lista;
    }
       
    public static double getIzlazByDayAndYearValue (int id, int id2) throws SQLException{
    DBConnect db = DBConnect.getInstance();
    PreparedStatement st = db.conn.prepareStatement("select izlaz_get_izlaz_by_day_and_year_f(?,?)");
    st.setInt(1, id);
    st.setInt(2, id2);
    ResultSet rs = st.executeQuery();
    if(rs.next()){
    return rs.getDouble(1);
    }
    return 0;
} 
    
       
         public static List <String> getIzlazByMonthAndYear(int id, int id2) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call izlaz_get_izlaz_by_month_and_year(?,?)}");
        cs.setInt(1, id);
        cs.setInt(2, id2);
        List <String> lista = new ArrayList<String>();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            lista.add(new String (String.valueOf(rs.getDouble(1)+","+String.valueOf(rs.getInt(2)))));
        
        }
        return lista;
    }  
    public static double getIzlazByMonthAndYearValue (int id, int id2) throws SQLException{
    DBConnect db = DBConnect.getInstance();
    PreparedStatement st = db.conn.prepareStatement("select izlaz_get_izlaz_by_month_and_year_f(?,?)");
    st.setInt(1, id);
    st.setInt(2, id2);
    ResultSet rs = st.executeQuery();
    if(rs.next()){
    return rs.getDouble(1);
    }
    return 0;
} 
         
             public static List <String> getIzlazByDayAndMonthAndYear(int id, int id2, int id3) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call izlaz_get_izlaz_by_day_and_month_and_year(?,?,?)}");
        cs.setInt(1, id);
        cs.setInt(2, id2);
        cs.setInt(3, id3);
        List <String> lista = new ArrayList<String>();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            lista.add(new String (String.valueOf(rs.getDouble(1)+","+String.valueOf(rs.getInt(2)))));
        
        }
        return lista;
    } 
             
  public static double getIzlazByDayAndMonthAndYearValue (int id, int id2, int id3) throws SQLException{
    DBConnect db = DBConnect.getInstance();
    PreparedStatement st = db.conn.prepareStatement("select izlaz_get_izlaz_by_day_and_month_and_year_f(?,?,?)");
    st.setInt(1, id);
    st.setInt(2, id2);
    st.setInt(3, id3);
    ResultSet rs = st.executeQuery();
    if(rs.next()){
    return rs.getDouble(1);
    }
    return 0;
} 
    
}
