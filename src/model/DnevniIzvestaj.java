
package model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DnevniIzvestaj {
    
    public DnevniIzvestaj (Datum datum, Zaposleni zaposleni){
        
        this.setDatum(datum);
        this.setZaposleni(zaposleni);
    }
    
    public DnevniIzvestaj (int idDatum, int idZaposleni) throws SQLException{
        this.setDatum(Datum.getDatum(idDatum));
        this.setZaposleni(Zaposleni.getZaposleni(idZaposleni));
        
    }
  

    private int id;
    private Datum datum;
    private Zaposleni zaposleni;
    
   
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public Datum getDatum() {
        return datum;
    }

    
    public void setDatum(Datum datum) {
        this.datum = datum;
    }

   
    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    
    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }
    
    @Override
    public String toString (){
        String s = Integer.toString(this.getId());
        return s;
    }

    
    
    
    public void saveDnevniIzvestaj () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("insert into dnevni_izvestaji values (null,?,?)",Statement.RETURN_GENERATED_KEYS);
        st.setInt(1, this.getDatum().getId());
        st.setInt(2, this.getZaposleni().getId());
        st.execute();
        ResultSet rs = st.getGeneratedKeys();
        if(rs.next()){
            this.setId(rs.getInt(1));
        }
        
    }
/*Dobavljanje podataka iz baze --pocetak*/    
    public static DnevniIzvestaj getDnevniIzvestaj (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_dnevni_izvestaji(?)}");
        cs.setInt(1, id);
        DnevniIzvestaj di = null;
        ResultSet rs = cs.executeQuery();
        if (rs.next()){
            di = new DnevniIzvestaj (rs.getInt("datum"),rs.getInt("zaposleni"));
            di.setId(rs.getInt("id"));
        }
        return di;
    }
    
    public static List <DnevniIzvestaj> getAllDnevniIzvestaj() throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_dnevni_izvestaji()}");
        List <DnevniIzvestaj> lista = new ArrayList <DnevniIzvestaj> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            DnevniIzvestaj di = new DnevniIzvestaj(rs.getInt("datum"),rs.getInt("zaposleni"));
            di.setId(rs.getInt("id"));
            lista.add(di);
        }
        return lista; 
    
    }
    
    public static int getLastId () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call dnevni_izvestaji_get_last_id()}");
        ResultSet rs = cs.executeQuery();
        int result =0;
        if (rs.next()){
            result = rs.getInt(1);
        }
        return result;
    }
    
    /*Dobavlja podatke za pocetnu tabelu u DnevniIzvestajiOut */
    public static List <String> firstTable () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call dnevni_izvestaji_get_dnevni_izvestaji_first_table()}");
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Datum d = Datum.getDatum(rs.getInt(2));
            lista.add(new String(rs.getString(1)+","+d.toString()+","+rs.getString(3)+","+rs.getString(4)));
        }
        return lista; 
    }
    
    
     /*Dobavlja podatak o ukupnoj vrednosti svih dnevnih izvestaja */
    public static String ukupnaVrednost () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("select dnevni_izvestaji_ukupna_vrednost_svih_dnevnih_izvestaja()");
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            return String.valueOf(rs.getInt(1));
        }
        return null; 
    }
    
/*Dobavljanje podataka o svim dnevnim izvestajima za konkretan Datum za potrebe jTable MD */
    public static List <String> getAllObjDIPbyDatum (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call dnevni_izvestaji_get_all_obj_dnevni_izvestaji_proizvodi_by_datum(?)}");
        List <String> lista = new ArrayList <String> ();
        cs.setInt(1, id);
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Datum d= Datum.getDatum(rs.getInt("datum"));
            String row = new String (String.valueOf(rs.getInt(1))+","+d.toString()+","+rs.getString(3)+","+rs.getString(4)+","+String.valueOf(rs.getDouble(5)));
            lista.add(row);
        }
        return lista; 
    }
    
/*Dobavljanje podataka o svim dnevnim izvestajima za konkretnog Zaposlenog za potrebe jTable MD */
    public static List <String> getAllObjDIPbyZaposleni (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call dnevni_izvestaji_get_all_obj_dip_by_zaposleni(?)}");
        List <String> lista = new ArrayList <String> ();
        cs.setInt(1, id);
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Datum d= Datum.getDatum(rs.getInt("datum"));
            String row = new String (String.valueOf(rs.getInt(1))+","+d.toString()+","+rs.getString(3)+","+rs.getString(4)+","+String.valueOf(rs.getDouble(5)));
            lista.add(row);
        }
        return lista; 
    }   
    
    /*Dobavljanje podataka o svim dnevnim izvestajima za konkretni Dnevni izvestaj za potrebe jTable MD */
    public static List <String> getAllObjDIPbyDnevniIzvestaj (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call dnevni_izvestaji_get_all_obj_dip_by_dnevni_izvestaj(?)}");
        List <String> lista = new ArrayList <String> ();
        cs.setInt(1, id);
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Datum d= Datum.getDatum(rs.getInt("datum"));
            String row = new String (String.valueOf(rs.getInt(1))+","+d.toString()+","+rs.getString(3)+","+rs.getString(4)+","+String.valueOf(rs.getDouble(5)));
            lista.add(row);
        }
        return lista; 
    }  
    
      /*Dobavlja podatak o ukupnoj vrednosti nabavki za konkretni Dnevni izvestaj */
    public static String ukupnaVrednostZaDnevniIzvestaj (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("select di_ukupna_vrednost_di_za_dnevni_izvestaj(?)");
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            return String.valueOf(rs.getInt(1));
        }
        return null; 
    }
    
      /*Dobavlja podatak o ukupnoj vrednosti nabavki za konkretan Datum */
    public static String ukupnaVrednostZaDatum (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("select di_ukupna_vrednost_di_za_datum(?)");
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            return String.valueOf(rs.getInt(1));
        }
        return null; 
    }
    
       /*Dobavlja podatak o ukupnoj vrednosti nabavki za konkretan Datum */
    public static String ukupnaVrednostZaZaposlenog (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("select di_ukupna_vrednost_di_za_zaposlenog(?)");
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            return String.valueOf(rs.getInt(1));
        }
        return null; 
    }
    
        /*Dobavljanje podataka o svim nabavkama za konkretan Datum za potrebe jTable LD */
    public static List <String> getAllObjDIPbyDatumLD(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call di_get_all_obj_dip_by_datum(?)}");
        List <String> lista = new ArrayList <String> ();
        cs.setInt(1, id);
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Datum d = Datum.getDatum(rs.getInt(2));
            lista.add(new String(rs.getString(1)+","+d.toString()+","+rs.getString(3)+","+rs.getString(4)));
        }
        return lista; 
    }
    
        /*Dobavljanje podataka o svim nabavkama za konkretnog Zaposlenog za potrebe jTable LD */
    public static List <String> getAllObjDIPbyZaposleniLD(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call di_get_all_obj_dip_by_zaposleni(?)}");
        List <String> lista = new ArrayList <String> ();
        cs.setInt(1, id);
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Datum d = Datum.getDatum(rs.getInt(2));
            lista.add(new String(rs.getString(1)+","+d.toString()+","+rs.getString(3)+","+rs.getString(4)));
        }
        return lista; 
    }
    
        /*Dobavljanje podataka o svim nabavkama za konkretan Dnevni izvestaj za potrebe jTable LD */
    public static List <String> getAllObjDIPbyDnevniIzvestajLD(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call di_get_all_obj_dip_by_dnevni_izvestaj(?)}");
        List <String> lista = new ArrayList <String> ();
        cs.setInt(1, id);
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Datum d = Datum.getDatum(rs.getInt(2));
            lista.add(new String(rs.getString(1)+","+d.toString()+","+rs.getString(3)+","+rs.getString(4)));
        }
        return lista; 
    }
    
    
    
    
    
    
    
    
    
// Dobavljanje podataka sa vise detalja 
    public static List getAllObjDnevniIzvestajAndProizvod() throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_obj_dnevni_izvestaji_and_proizvodi()}");
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            DnevniIzvestaj di = new DnevniIzvestaj(rs.getInt("datum"),rs.getInt("zaposleni"));
            di.setId(rs.getInt("id"));
            Proizvod p = Proizvod.getProizvod(rs.getInt("id_proizvodi"));
            double iznos = rs.getDouble("iznos");
            String row = new String (String.valueOf(di.getId()) + "," + di.getDatum().toString() + "," + di.getZaposleni().getIme() + "," + p.getNaziv() + "," + String.valueOf(iznos));
            lista.add(row);
        }
        return lista; 
    }
    
// Dobavljanje podataka sa manje detalja o dnevnim izvestajima
    public static List getDistinctNabavkaLessD() throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_distinct_dnevni_izvestaji_less_d()}");
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Integer broj = rs.getInt("id");
            String row = broj.toString();
            lista.add(row);
        }
        return lista; 
    }
    

    
//Dobavlja podatake sa manje detalja o dnevnim izvestajima na osnovu konkretnog Datuma
    public static List getDistinctByDatumLessD(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_distinct_dnevni_izvestaji_by_datum_less_d(?)}");
        List <String> lista = new ArrayList <String> ();
        cs.setInt(1, id);
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Integer broj = rs.getInt("id");
            String row = broj.toString();
            lista.add(row);
        }
        return lista; 
    
    }

 //Dobavljanje podataka sa manje detalja o dnevnim izvestajima na osnovu konkretnog Zaposlenog
    public static List getDistinctByZaposleniLessD(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_distinct_dnevni_izvestaji_by_zaposleni_less_d(?)}");
        List <String> lista = new ArrayList <String> ();
        cs.setInt(1, id);
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Integer broj = rs.getInt("id");
            String row = broj.toString();
            lista.add(row);
        }
        return lista; 
    }
    
  //Dobavljanje podataka sa manje detalja o dnevnim izvestajima na osnovu konkretnog Dnevnog izvestaja
    public static List getDistinctByDnevniIzvestajLessD(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_distinct_dnevni_izvestaji_by_dnevni_izvestaj_less_d(?)}");
        List <String> lista = new ArrayList <String> ();
        cs.setInt(1, id);
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Integer broj = rs.getInt("id");
            String row = broj.toString();
            lista.add(row);
        }
        return lista; 
    }
    

/*Dobavljanje podataka iz baze --kraj*/
    
    
    public void updateDnevniIzvestaj () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("update dnevni_izvestaji set datum=?, zaposleni=? where id=?");
        st.setInt(1, this.getDatum().getId());
        st.setInt(2, this.getZaposleni().getId());
        
        st.setInt(3, this.getId());
        int result = st.executeUpdate();
        if(result == 1){
            System.out.println("update done");
        }else{
            System.out.println("update fail");
        }
    }
    
    public static boolean deleteDnevniIzvestaj (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("delete from dnevni_izvestaji where id=?");
        st.setInt(1, id);
        int i=st.executeUpdate();
        
        boolean flag = false;
        if (i>0){
            flag = true;
        }
        return flag;
   }
    
   
    
    
    
    
}
