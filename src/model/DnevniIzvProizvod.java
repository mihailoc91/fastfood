
package model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DnevniIzvProizvod  {
    
    public DnevniIzvProizvod (DnevniIzvestaj dnevniIzvestaj, Proizvod proizvod) {
    this.setDnevniIzvestaj(dnevniIzvestaj);
    this.setProizvod(proizvod);
    
    }
    
    public DnevniIzvProizvod (int dnevniIzvestaj, int proizvod) throws SQLException{
        this.setDnevniIzvestaj(DnevniIzvestaj.getDnevniIzvestaj(dnevniIzvestaj));
        this.setProizvod(Proizvod.getProizvod(proizvod));
    }
    
   private DnevniIzvestaj dnevniIzvestaj;
   private Proizvod proizvod;
   private double iznos;

   
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

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }
    
  public void saveDnevniIzvProizvod () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("insert into dnevni_izvestaji_proizvodi values (?,?,?)");
        st.setInt(1, this.getDnevniIzvestaj().getId());
        st.setInt(2, this.getProizvod().getId());
        st.setDouble(3, this.getIznos());
        st.execute();
        
    }
  
    public int saveDnevniIzvProizvod2 () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("insert into dnevni_izvestaji_proizvodi (id_dnevni,id_proizvodi,iznos) values (?,?,?)");
        st.setInt(1, this.getDnevniIzvestaj().getId());
        st.setInt(2, this.getProizvod().getId());
        st.setDouble(3, this.getIznos());
        int flag = st.executeUpdate();
        return flag;
        
    }
/*Dobavljanje podataka iz baze --pocetak*/  
  public static DnevniIzvProizvod getDnevniIzvProizvod (int idD, int idP) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_dnevni_izvestaji_proizvodi(?,?)}");
        cs.setInt(1, idD);
        cs.setInt(2, idP);
        DnevniIzvProizvod di = null;
        ResultSet rs = cs.executeQuery();
        if (rs.next()){
            di = new DnevniIzvProizvod (rs.getInt("id_dnevni"),rs.getInt("id_proizvodi"));
            di.setIznos(rs.getDouble("iznos"));
        }
        return di;
    }
  
    public static List <DnevniIzvProizvod> getAllDnevniIzvProizvod() throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_dnevni_izvestaji_proizvodi()}");
        List <DnevniIzvProizvod> lista = new ArrayList <DnevniIzvProizvod> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            DnevniIzvProizvod di = new DnevniIzvProizvod(rs.getInt("id_dnevni"),rs.getInt("id_proizvodi"));
            di.setIznos(rs.getDouble("iznos"));
            lista.add(di);
        }
        return lista; 
    
    }
    
    public static List <DnevniIzvProizvod> getAllProizvodforDnevniIzvestaj(int id) throws SQLException{
            DBConnect db = DBConnect.getInstance();
            CallableStatement cs = db.conn.prepareCall("{call get_all_proizvodi_for_dnevni_izvestaj(?)}");
            cs.setInt(1, id);
            List <DnevniIzvProizvod> lista = new ArrayList <DnevniIzvProizvod> ();
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                DnevniIzvProizvod dip = new DnevniIzvProizvod(rs.getInt("id_dnevni"),rs.getInt("id_proizvodi"));
                dip.setIznos(rs.getDouble("iznos"));
                lista.add(dip);
            }
            return lista; 
    }

/*Dobavljanje podataka iz baze --kraj*/ 

    public void updateDnevniIzvProizvod() throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("update dnevni_izvestaji_proizvodi set iznos=? where id_dnevni=? and id_proizvodi=?");
        st.setDouble(1, this.getIznos());
        st.setInt(2, this.dnevniIzvestaj.getId());
       
        
        st.setInt(3, this.proizvod.getId());
        int result = st.executeUpdate();
        if(result == 1){
            System.out.println("update done");
        }else{
            System.out.println("update fail");
        }
    }
    
    public static void deleteDnevniIzvProizvodi(int idD,int idP) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("delete from dnevni_izvestaji_proizvodi where id_dnevni=? and id_proizvodi=?");
        st.setInt(1, idD);
        st.setInt(2, idP);
        st.execute();
   }
    
    
    
}
