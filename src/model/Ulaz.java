
package model;

import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Ulaz {

    
    public double getUlaz() {
        return ulaz;
    }

    
    public void setUlaz(double ulaz) {
        this.ulaz = ulaz;
    }

    
    public Nabavka getNabavka() {
        return nabavka;
    }

    
    public void setNabavka(Nabavka nabavka) {
        this.nabavka = nabavka;
    }

    
    public Trosak getTrosak() {
        return trosak;
    }

    
    public void setTrosak(Trosak trosak) {
        this.trosak = trosak;
    }

    
    public Datum getDatum() {
        return datum;
    }

    
    public void setDatum(Datum datum) {
        this.datum = datum;
    }

    
    public Proizvod getProizvod() {
        return proizvod;
    }

    
    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }
    
private double ulaz;
private Nabavka nabavka;
private Trosak trosak;
private Datum datum;
private Proizvod proizvod;

    

public static List <String> getLastUlaz () throws SQLException{
    DBConnect db = DBConnect.getInstance();
    CallableStatement cs = db.conn.prepareCall("{call ulaz_get_last_ulaz()}");
    ResultSet rs = cs.executeQuery();
    List <String> lista = new ArrayList<>();
    while(rs.next()){
        String s=String.valueOf(rs.getInt(2));
        String s1 = String.valueOf(rs.getInt(3));
        if(Integer.valueOf(s)==0){
             s= " ";
        }  else{
             s1 = " ";
        }
         lista.add(new String (String.valueOf(rs.getDouble(1)+","+s+","+s1+","+String.valueOf(rs.getInt(4)))));
    }
    return lista;
}

public static double getLastUlazValue () throws SQLException{
    DBConnect db = DBConnect.getInstance();
    PreparedStatement st = db.conn.prepareStatement("select ulaz_last_id_vrednost_ulaza()");
    ResultSet rs = st.executeQuery();
    if(rs.next()){
    return rs.getDouble(1);
    }
    return 0;
} 


public static List <String> getUlazByDay (int id) throws SQLException{
    DBConnect db = DBConnect.getInstance();
    CallableStatement cs = db.conn.prepareCall("{call ulaz_get_ulaz_by_day(?)}");
    cs.setInt(1, id);
    ResultSet rs = cs.executeQuery();
    List <String> lista = new ArrayList<>();
    while(rs.next()){
        lista.add(new String (String.valueOf(rs.getDouble(1))+","+String.valueOf(rs.getInt(2))));
    }
    return lista;
}

public static double getUlazByDayValue (int id) throws SQLException{
    DBConnect db = DBConnect.getInstance();
    PreparedStatement st = db.conn.prepareStatement("select ulaz_get_ulaz_by_day_f(?)");
    st.setInt(1, id);
    ResultSet rs = st.executeQuery();
    if(rs.next()){
    return rs.getDouble(1);
    }
    return 0;
} 

public static List <String> getUlazByMonth (int id) throws SQLException{
    DBConnect db = DBConnect.getInstance();
    CallableStatement cs = db.conn.prepareCall("{call ulaz_get_ulaz_by_month(?)}");
    cs.setInt(1, id);
    ResultSet rs = cs.executeQuery();
    List <String> lista = new ArrayList<>();
    while(rs.next()){
        lista.add(new String (String.valueOf(rs.getDouble(1))+","+String.valueOf(rs.getInt(2))));
    }
    return lista;
}

public static double getUlazByMonthValue (int id) throws SQLException{
    DBConnect db = DBConnect.getInstance();
    PreparedStatement st = db.conn.prepareStatement("select ulaz_get_ulaz_by_month_f(?)");
    st.setInt(1, id);
    ResultSet rs = st.executeQuery();
    if(rs.next()){
    return rs.getDouble(1);
    }
    return 0;
} 

public static List <String> getUlazByYear (int id) throws SQLException{
    DBConnect db = DBConnect.getInstance();
    CallableStatement cs = db.conn.prepareCall("{call ulaz_get_ulaz_by_year(?)}");
    cs.setInt(1, id);
    ResultSet rs = cs.executeQuery();
    List <String> lista = new ArrayList<>();
    while(rs.next()){
        lista.add(new String (String.valueOf(rs.getDouble(1))+","+String.valueOf(rs.getInt(2))));
    }
    return lista;
}

public static double getUlazByYearValue (int id) throws SQLException{
    DBConnect db = DBConnect.getInstance();
    PreparedStatement st = db.conn.prepareStatement("select ulaz_get_ulaz_by_year_f(?)");
    st.setInt(1, id);
    ResultSet rs = st.executeQuery();
    if(rs.next()){
    return rs.getDouble(1);
    }
    return 0;
} 

public static List <String> getUlazByDayAndMonth (int id, int id2) throws SQLException{
    DBConnect db = DBConnect.getInstance();
    CallableStatement cs = db.conn.prepareCall("{call ulaz_get_ulaz_by_day_and_month(?,?)}");
    cs.setInt(1, id);
    cs.setInt(2, id2);
    ResultSet rs = cs.executeQuery();
    List <String> lista = new ArrayList<>();
    while(rs.next()){
        lista.add(new String (String.valueOf(rs.getDouble(1))+","+String.valueOf(rs.getInt(2))));
    }
    return lista;
}

public static double getUlazByDayAndMonthValue (int id, int id2) throws SQLException{
    DBConnect db = DBConnect.getInstance();
    PreparedStatement st = db.conn.prepareStatement("select ulaz_get_ulaz_by_day_and_month_f(?,?)");
    st.setInt(1, id);
    st.setInt(2, id2);
    ResultSet rs = st.executeQuery();
    if(rs.next()){
    return rs.getDouble(1);
    }
    return 0;
} 

public static List <String> getUlazByDayAndYear (int id, int id2) throws SQLException{
    DBConnect db = DBConnect.getInstance();
    CallableStatement cs = db.conn.prepareCall("{call ulaz_get_ulaz_by_day_and_year(?,?)}");
    cs.setInt(1, id);
    cs.setInt(2, id2);
    ResultSet rs = cs.executeQuery();
    List <String> lista = new ArrayList<>();
    while(rs.next()){
        lista.add(new String (String.valueOf(rs.getDouble(1))+","+String.valueOf(rs.getInt(2))));
    }
    return lista;
}

public static double getUlazByDayAndYearValue (int id, int id2) throws SQLException{
    DBConnect db = DBConnect.getInstance();
    PreparedStatement st = db.conn.prepareStatement("select ulaz_get_ulaz_by_day_and_year_f(?,?)");
    st.setInt(1, id);
    st.setInt(2, id2);
    ResultSet rs = st.executeQuery();
    if(rs.next()){
    return rs.getDouble(1);
    }
    return 0;
} 

public static List <String> getUlazByMonthAndYear (int id, int id2) throws SQLException{
    DBConnect db = DBConnect.getInstance();
    CallableStatement cs = db.conn.prepareCall("{call ulaz_get_ulaz_by_month_and_year(?,?)}");
    cs.setInt(1, id);
    cs.setInt(2, id2);
    ResultSet rs = cs.executeQuery();
    List <String> lista = new ArrayList<>();
    while(rs.next()){
        lista.add(new String (String.valueOf(rs.getDouble(1))+","+String.valueOf(rs.getInt(2))));
    }
    return lista;
}

public static double getUlazByMonthAndYearValue (int id, int id2) throws SQLException{
    DBConnect db = DBConnect.getInstance();
    PreparedStatement st = db.conn.prepareStatement("select ulaz_get_ulaz_by_month_and_year_f(?,?)");
    st.setInt(1, id);
    st.setInt(2, id2);
    ResultSet rs = st.executeQuery();
    if(rs.next()){
    return rs.getDouble(1);
    }
    return 0;
} 

public static List <String> getUlazByDayAndMonthAndYear (int id, int id2, int id3) throws SQLException{
    DBConnect db = DBConnect.getInstance();
    CallableStatement cs = db.conn.prepareCall("{call ulaz_get_ulaz_by_day_and_month_and_year(?,?,?)}");
    cs.setInt(1, id);
    cs.setInt(2, id2);
     cs.setInt(3, id3);
    ResultSet rs = cs.executeQuery();
    List <String> lista = new ArrayList<>();
    while(rs.next()){
        lista.add(new String (String.valueOf(rs.getDouble(1))+","+String.valueOf(rs.getInt(2))));
    }
    return lista;
}
public static double getUlazByDayAndMonthAndYearValue (int id, int id2, int id3) throws SQLException{
    DBConnect db = DBConnect.getInstance();
    PreparedStatement st = db.conn.prepareStatement("select ulaz_get_ulaz_by_day_and_month_and_year_f(?,?,?)");
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
