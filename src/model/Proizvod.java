
package model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Proizvod {

    public Proizvod (TipProizvoda tip){
        this.tip = tip;
    }
    
    public Proizvod (int id) throws SQLException{
        this.tip = TipProizvoda.getTipProizvoda(id);
    }
    
    private int id;
    private String naziv;
    private double cena;
    private double kolicina;
    private double gramaza;
    private TipProizvoda tip;
    
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

   
    public double getCena() {
        return cena;
    }

   
    public void setCena(double cena) {
        this.cena = cena;
    }

    
    public double getKolicina() {
        return kolicina;
    }

    
    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    
    public double getGramaza() {
        return gramaza;
    }

    
    public void setGramaza(double gramaza) {
        this.gramaza = gramaza;
    }

    
    public TipProizvoda getTip() {
        return tip;
    }

   
    public void setTip(TipProizvoda tip) {
        this.tip = tip;
    }
    
     @Override
    public String toString (){
        return this.getNaziv();
    }
    
   public void saveProizvod () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("insert into proizvodi values (null,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        st.setString(1, this.getNaziv());
        st.setDouble(2, this.getCena());
        st.setDouble(3, this.getKolicina());
        st.setDouble(4, this.getGramaza());
        st.setInt(5, this.getTip().getId());
        st.execute();
        ResultSet rs = st.getGeneratedKeys();
        if(rs.next()){
            this.setId(rs.getInt(1));
        }
    }
/*Dobavljanje podataka iz baze --pocetak*/   
   
   public static Proizvod getProizvod (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_proizvod(?)}");
        cs.setInt(1, id);
        Proizvod p = null;
        ResultSet rs = cs.executeQuery();
        if (rs.next()){
            p = new Proizvod (rs.getInt("tip"));
            p.setId(rs.getInt("id"));
            p.setNaziv(rs.getString("naziv"));
            p.setCena(rs.getDouble("cena"));
            p.setKolicina(rs.getDouble("kolicina"));
            p.setGramaza(rs.getDouble("gramaza"));
        }
        return p;
    }
   
   public static List <Proizvod> getAllProizvod () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_proizvodi()}");
        List <Proizvod> lista = new ArrayList <Proizvod> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Proizvod p = new Proizvod(rs.getInt("tip"));
            p.setId(rs.getInt("id"));
            p.setNaziv(rs.getString("naziv"));
            p.setCena(rs.getDouble("cena"));
            p.setGramaza(rs.getDouble("gramaza"));
            p.setKolicina(rs.getDouble("kolicina"));
            
            lista.add(p);
        }
        return lista; 
    }
   /*Dobavlja sve podatke za prvu tabelu */
   public static List <String>  getAllObjProizvod () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call proizvodi_get_all_obj_proizvodi()}");
        List <String> lista = new ArrayList<String>();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            lista.add(new String (rs.getString("naziv")+","+String.valueOf(rs.getDouble("cena"))+","+String.valueOf(rs.getDouble("gramaza"))+","+String.valueOf(rs.getDouble("kolicina"))+","+rs.getString(5)));
        }
        return lista; 
    }
   
   public static List  getAllObjPProizvod (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_proizvod(?)}");
        cs.setInt(1, id);
        List  lista = new ArrayList  ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Proizvod p = new Proizvod(rs.getInt("tip"));
            p.setId(rs.getInt("id"));
            p.setNaziv(rs.getString("naziv"));
            p.setCena(rs.getDouble("cena"));
            p.setGramaza(rs.getDouble("gramaza"));
            p.setKolicina(rs.getDouble("kolicina"));
            
            String row = new String (p.getNaziv()+","+String.valueOf(p.getCena())+","+String.valueOf(p.getGramaza())+","+String.valueOf(p.getKolicina())+","+p.getTip().getNaziv());
            lista.add(row);
        }
        return lista; 
    }
   
   public static List  getAllObjTipProizvodaForProizvodi (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_obj_tip_proizvoda_for_proizvodi(?)}");
        cs.setInt(1, id);
        List  lista = new ArrayList  ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Proizvod p = new Proizvod(rs.getInt("tip"));
            p.setId(rs.getInt("id"));
            p.setNaziv(rs.getString("naziv"));
            p.setCena(rs.getDouble("cena"));
            p.setGramaza(rs.getDouble("gramaza"));
            p.setKolicina(rs.getDouble("kolicina"));
            
            String row = new String (p.getNaziv()+","+String.valueOf(p.getCena())+","+String.valueOf(p.getGramaza())+","+String.valueOf(p.getKolicina())+","+p.getTip().getNaziv());
            lista.add(row);
        }
        return lista; 
    }
   
   public static Proizvod getProizvodFromJlist (String naziv,double gramaza) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_proizvod_from_jlist(?,?)}");
        cs.setString(1, naziv);
        cs.setDouble(2, gramaza);
        Proizvod p = null;
        ResultSet rs = cs.executeQuery();
        if (rs.next()){
            p = new Proizvod (rs.getInt("tip"));
            p.setId(rs.getInt("id"));
            p.setNaziv(rs.getString("naziv"));
            p.setCena(rs.getDouble("cena"));
            p.setKolicina(rs.getDouble("kolicina"));
            p.setGramaza(rs.getDouble("gramaza"));
        }
        return p;
    }
   
   
/*Dobavljanje podataka iz baze --kraj*/    
   
   
   public int updateProizvod () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("update proizvodi set naziv=?, cena=?, kolicina=?, gramaza=?, tip=? where id=?");
        st.setString(1, this.getNaziv());
        st.setDouble(2, this.getCena());
        st.setDouble(3, this.getKolicina());
        st.setDouble(4, this.getGramaza());
        st.setInt(5, this.getTip().getId());
        st.setInt(6, this.getId());
        int result = st.executeUpdate();
        
        if(result == 1){
            System.out.println("update done");
        }else{
            System.out.println("update fail");
        }
        return result;
    }
   
   public static boolean deleteProizvod (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("delete from proizvodi where id=?");
        st.setInt(1, id);
        int i=st.executeUpdate();
        
        boolean flag = false;
        if (i>0){
            flag = true;
        }
        return flag;
   }
   
}
