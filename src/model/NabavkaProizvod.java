
package model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NabavkaProizvod {
    
    public NabavkaProizvod (Nabavka nabavka, Proizvod proizvod){
        this.setNabavka(nabavka);
        this.setProizvod(proizvod);
    }
    
    public NabavkaProizvod (int idN, int idP) throws SQLException{
        this.setNabavka(Nabavka.getNabavka(idN));
        this.setProizvod(Proizvod.getProizvod(idP));
    }
    

    private Nabavka nabavka;
    private Proizvod proizvod;
    private double kolicina;
    private double cena;
    
    public Nabavka getNabavka() {
        return nabavka;
    }

    
    public void setNabavka(Nabavka nabavka) {
        this.nabavka = nabavka;
    }

    
    public Proizvod getProizvod() {
        return proizvod;
    }

    
    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    public double getKolicina() {
        return kolicina;
    }

   
    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    
    public double getCena() {
        return cena;
    }

    
    public void setCena(double cena) {
        this.cena = cena;
    }
    
    
    public void saveNabavkaProizvod () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("insert into nabavke_proizvodi values (?,?,?,?)");
        st.setInt(1, this.getNabavka().getId());
        st.setInt(2, this.getProizvod().getId());
        st.setDouble(3, this.getKolicina());
        st.setDouble(4, this.getCena());
        st.execute();
        
        
    }
    
     public int saveNabavkaProizvod2 () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("insert into nabavke_proizvodi (id_nabavke,id_proizvoda,kolicina,cena) values (?,?,?,?)");
        st.setInt(1, this.getNabavka().getId());
        st.setInt(2, this.getProizvod().getId());
        st.setDouble(3, this.getKolicina());
        st.setDouble(4, this.getCena());
        
        int flag = st.executeUpdate();
        return flag;
        
    }
    
     /*Dobavljanje podataka iz baze --pocetak*/
     
    public static NabavkaProizvod getNabavkaProizvod (int idN, int idP) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_nabavka_proizvod(?,?)}");
        cs.setInt(1, idN);
        cs.setInt(2, idP);
        NabavkaProizvod np = null;
        ResultSet rs = cs.executeQuery();
        if (rs.next()){
            np = new NabavkaProizvod (rs.getInt("id_nabavke"),rs.getInt("id_proizvoda"));
            np.setKolicina(rs.getDouble("kolicina"));
            np.setCena(rs.getDouble("cena"));
            
        }
        return np;
    }
    
    public static List <NabavkaProizvod> getAllNabavkaProizvod() throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_nabavka_proizvod()}");
        List <NabavkaProizvod> lista = new ArrayList <NabavkaProizvod> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            NabavkaProizvod np = new NabavkaProizvod(rs.getInt("id_nabavke"),rs.getInt("id_proizvoda"));
            np.setKolicina(rs.getDouble("kolicina"));
            np.setCena(rs.getDouble("cena"));
            lista.add(np);
        }
        return lista; 
    
    }
    
    public static List <NabavkaProizvod> getAllProizvodforNabavka(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_proizvodi_for_nabavka(?)}");
        cs.setInt(1, id);
        List <NabavkaProizvod> lista = new ArrayList <NabavkaProizvod> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            NabavkaProizvod np = new NabavkaProizvod(rs.getInt("id_nabavke"),rs.getInt("id_proizvoda"));
            np.setKolicina(rs.getDouble("kolicina"));
            np.setCena(rs.getDouble("cena"));
            lista.add(np);
        }
        return lista; 
    
    }

    
    /*Dobavljanje podataka iz baze --kraj*/
    
    public void updateNabavkaProizvod() throws SQLException{
        DBConnect db = DBConnect.getInstance();
        
        
        PreparedStatement st = db.conn.prepareStatement("update nabavke_proizvodi set kolicina=?, cena=? where id_nabavke=? and id_proizvoda=?");
        st.setDouble(1, this.getKolicina());
        st.setDouble(2, this.getCena());
        st.setInt(3, this.getNabavka().getId());
        st.setInt(4, this.getProizvod().getId());
       
        
        int result =st.executeUpdate();
         int b=1;
        if(result == 1){
        
        }else{
            int flag= this.saveNabavkaProizvod2();
            if(flag ==1){
            }else{
                System.out.println("update fail");
            }
        }
    }
    
    
     public static boolean deleteNabavkaProizvod(int idN,int idP) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("delete from nabavke_proizvodi where id_nabavke=? and id_proizvoda=?");
        st.setInt(1, idN);
        st.setInt(2, idP);
        int i = st.executeUpdate();
        
        boolean flag = false;
        if (i>0){
            flag=true;
            return flag;
        }
        return flag;
   }
     
    
   
     
}
