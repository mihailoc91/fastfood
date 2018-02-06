
package model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Nabavka {
    
    public Nabavka (Zaposleni zaposleni, Datum datum, Dobavljac dobavljac, TipTroska tipTroska){
        this.setZaposleni(zaposleni);
        this.setDatum(datum);
        this.setDobavljac(dobavljac);
        this.setTipTroska(tipTroska);
    }
    
    public Nabavka (int idZ,int idD, int idDob, int idT) throws SQLException{
        this.setZaposleni(Zaposleni.getZaposleni(idZ));
        this.setDatum(Datum.getDatum(idD));
        this.setDobavljac(Dobavljac.getDobavljac(idDob));
        this.setTipTroska(TipTroska.getTipTroska(idT));
        
    }

    private int id;
    private Zaposleni zaposleni;
    private Datum datum;
    private Dobavljac dobavljac;
    private TipTroska tipTroska;
    
    
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    
    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    
    public Datum getDatum() {
        return datum;
    }

    
    public void setDatum(Datum datum) {
        this.datum = datum;
    }

    
    public Dobavljac getDobavljac() {
        return dobavljac;
    }

   
    public void setDobavljac(Dobavljac dobavljac) {
        this.dobavljac = dobavljac;
    }

    
    public TipTroska getTipTroska() {
        return tipTroska;
    }

    
    public void setTipTroska(TipTroska tipTroska) {
        this.tipTroska = tipTroska;
    }
    
    @Override
    public String toString (){
        String s = Integer.toString(this.getId());
        return s;
    }
   
    public void saveNabavka () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("insert into nabavke values (null,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        st.setInt(1, this.getZaposleni().getId());
        st.setInt(2, this.getDatum().getId());
        st.setInt(3,this.getDobavljac().getId());
        st.setInt(4, this.getTipTroska().getId());
        st.execute();
        ResultSet rs = st.getGeneratedKeys();
        if(rs.next()){
            this.setId(rs.getInt(1));
        }
        
    }
    
 /*Dobavljanje podataka iz baze --pocetak*/   
    
    
    public static Nabavka getNabavka (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_nabavka(?)}");
        cs.setInt(1, id);
        Nabavka n = null;
        ResultSet rs = cs.executeQuery();
        if (rs.next()){
            n = new Nabavka (rs.getInt("zaposleni"),rs.getInt("datum"), rs.getInt("dobavljac"), rs.getInt("tip_troska"));
            n.setId(rs.getInt("id"));
        }
        return n;
    }
    
    
    public static List <Nabavka> getAllNabavka() throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_nabavka()}");
        List <Nabavka> lista = new ArrayList <Nabavka> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Nabavka n = new Nabavka (rs.getInt("zaposleni"),rs.getInt("datum"), rs.getInt("dobavljac"), rs.getInt("tip_troska"));
            n.setId(rs.getInt("id"));
            lista.add(n);
        }
        return lista; 
    }
    
    /*Dobavlja sve distinct nabavke koje se nalaze u tabeli nabavke_proizvodi */
    public static List <Nabavka> getAllNabavkaFromNabavkeProizvodi() throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call nabavke_get_all_nabavke_from_nabavke_proizvodi()}");
        List <Nabavka> lista = new ArrayList <Nabavka> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Nabavka n = new Nabavka (rs.getInt("zaposleni"),rs.getInt("datum"), rs.getInt("dobavljac"), rs.getInt("tip_troska"));
            n.setId(rs.getInt("id"));
            lista.add(n);
        }
        return lista; 
    }
    
      /*Dobavljanje podataka o svim nabavkama za konkretnog Dobavljaca za potrebe jTable MD */
    public static List <String> getAllObjNAPbyDobavljac(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_obj_nabavke_and_proizvodi_by_dobavljac(?)}");
        List <String> lista = new ArrayList <String> ();
        cs.setInt(1, id);
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Datum d= Datum.getDatum(rs.getInt("datum"));
            String row = new String (String.valueOf(rs.getInt(1))+","+rs.getString(2)+","+d.toString()+","+rs.getString(4)+","+rs.getString(5)+","+String.valueOf(rs.getInt(6))+","+String.valueOf(rs.getInt(7)));
            lista.add(row);
        }
        return lista; 
    }
    
       /*Dobavljanje podataka o svim nabavkama za konkretan Datum za potrebe jTable MD */
    public static List <String> getAllObjNAPbyDatum(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_obj_nabavke_and_proizvodi_by_datum(?)}");
        List <String> lista = new ArrayList <String> ();
        cs.setInt(1, id);
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Datum d= Datum.getDatum(rs.getInt("datum"));
            String row = new String (String.valueOf(rs.getInt(1))+","+rs.getString(2)+","+d.toString()+","+rs.getString(4)+","+rs.getString(5)+","+String.valueOf(rs.getInt(6))+","+String.valueOf(rs.getInt(7)));
            lista.add(row);
        }
        return lista; 
    }
    
    /*Dobavljanje podataka o svim nabavkama za konkretnog Zaposlenog za potrebe jTable MD */
    public static List <String> getAllObjNAPbyZaposleni(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_obj_nabavka_and_proizvodi_by_zaposleni(?)}");
        List <String> lista = new ArrayList <String> ();
        cs.setInt(1, id);
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Datum d= Datum.getDatum(rs.getInt("datum"));
            String row = new String (String.valueOf(rs.getInt(1))+","+rs.getString(2)+","+d.toString()+","+rs.getString(4)+","+rs.getString(5)+","+String.valueOf(rs.getInt(6))+","+String.valueOf(rs.getInt(7)));
            lista.add(row);
        }
        return lista; 
    }
    
     /*Dobavljanje podataka o svim nabavkama za konkretanu Nabavku za potrebe jTable MD */
    public static List getAllObjNAPbyNabavka(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_obj_nabavka_and_proizvodi_by_nabavka(?)}");
        List <String> lista = new ArrayList <String> ();
        cs.setInt(1, id);
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Datum d= Datum.getDatum(rs.getInt("datum"));
            String row = new String (String.valueOf(rs.getInt(1))+","+rs.getString(2)+","+d.toString()+","+rs.getString(4)+","+rs.getString(5)+","+String.valueOf(rs.getInt(6))+","+String.valueOf(rs.getInt(7)));
            lista.add(row);
        }
        return lista; 
    }
    
    /*Dobavlja podatak o ukupnoj vrednosti svih nabavki */
    public static String ukupnaVrednost () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("select ukupna_vrednost_svih_nabavki()");
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            return String.valueOf(rs.getInt(1));
        }
        return null; 
    }
    
    /*Dobavlja podatak o ukupnoj vrednosti nabavki za konkretnog Dobavljaca */
    public static String ukupnaVrednostZaDobavljaca (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("select nabavke_ukupna_vrednost_nabavke_za_dobavljaca(?)");
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            return String.valueOf(rs.getInt(1));
        }
        return null; 
    }
    
    /*Dobavlja podatak o ukupnoj vrednosti nabavki za konkretnu Nabavku */
    public static String ukupnaVrednostZaNabavku (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("select nabavke_ukupna_vrednost_nabavke_za_nabavku(?)");
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
        PreparedStatement st = db.conn.prepareStatement("select nabavke_ukupna_vrednost_nabavke_za_datum(?)");
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            return String.valueOf(rs.getInt(1));
        }
        return null; 
    }
    
       /*Dobavlja podatak o ukupnoj vrednosti nabavki za konkretnog Zaposlenog  */
    public static String ukupnaVrednostZaZaposlenog (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("select nabavke_ukupna_vrednost_nabavke_za_zaposlenog(?)");
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        if(rs.next()){
            return String.valueOf(rs.getInt(1));
        }
        return null; 
    }
    
      /*Dobavljanje podataka o svim nabavkama za konkretnog Dobavljaca za potrebe jTable LD */
    public static List <String> getAllObjNAPbyDobavljacLD(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call nabavke_get_all_obj_nabavke_and_proizvodi_by_dobavljac(?)}");
        List <String> lista = new ArrayList <String> ();
        cs.setInt(1, id);
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Datum d= Datum.getDatum(rs.getInt("datum"));
            String row = new String (String.valueOf(rs.getInt(1))+","+rs.getString(2)+","+d.toString()+","+rs.getString(4)+","+String.valueOf(rs.getInt(5)));
            lista.add(row);
        }
        return lista; 
    }
    
       /*Dobavljanje podataka o svim nabavkama za konkretan Datum za potrebe jTable LD */
    public static List <String> getAllObjNAPbyDatumLD(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call nabavke_get_all_obj_nabavke_and_proizvodi_by_datum(?)}");
        List <String> lista = new ArrayList <String> ();
        cs.setInt(1, id);
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Datum d= Datum.getDatum(rs.getInt("datum"));
            String row = new String (String.valueOf(rs.getInt(1))+","+rs.getString(2)+","+d.toString()+","+rs.getString(4)+","+String.valueOf(rs.getInt(5)));
            lista.add(row);
        }
        return lista; 
    }
    
     /*Dobavljanje podataka o svim nabavkama za konkretnog Zaposlenog za potrebe jTable LD */
    public static List <String> getAllObjNAPbyZaposleniLD(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call nabavke_get_all_obj_nabavke_and_proizvodi_by_zaposleni(?)}");
        List <String> lista = new ArrayList <String> ();
        cs.setInt(1, id);
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Datum d= Datum.getDatum(rs.getInt("datum"));
            String row = new String (String.valueOf(rs.getInt(1))+","+rs.getString(2)+","+d.toString()+","+rs.getString(4)+","+String.valueOf(rs.getInt(5)));
            lista.add(row);
        }
        return lista; 
    }
    
     /*Dobavljanje podataka o svim nabavkama za konkretanu Nabavku za potrebe jTable LD */
    public static List getAllObjNAPbyNabavkaLD(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call nabavke_get_all_obj_nabavke_and_proizvodi_by_nabavka(?)}");
        List <String> lista = new ArrayList <String> ();
        cs.setInt(1, id);
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Datum d= Datum.getDatum(rs.getInt("datum"));
            String row = new String (String.valueOf(rs.getInt(1))+","+rs.getString(2)+","+d.toString()+","+rs.getString(4)+","+String.valueOf(rs.getInt(5)));
            lista.add(row);
        }
        return lista; 
    }
    
    
    
    
    
    // Dobavljanje podataka o svim Nabavkama 
    public static List getAllObjNabavkaAndProizvod() throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_obj_nabavka_and_proizvod()}");
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Nabavka n = Nabavka.getNabavka(rs.getInt("id"));
            Zaposleni z= Zaposleni.getZaposleni(rs.getInt("zaposleni"));
            Datum d= Datum.getDatum(rs.getInt("datum"));
            Dobavljac dob = Dobavljac.getDobavljac(rs.getInt("dobavljac"));
            TipTroska t = TipTroska.getTipTroska(rs.getInt("tip_troska"));
            Proizvod p = Proizvod.getProizvod(rs.getInt("id_proizvoda"));
            double kolicina = rs.getInt("kolicina");
            double cena = rs.getDouble("cena");
            String row = new String (String.valueOf(n.getId())+","+z.getIme()+","+d.toString()+","+dob.getNaziv()+","+t.getNaziv()+","+p.getNaziv()+","+String.valueOf(kolicina)+","+String.valueOf(cena));
            lista.add(row);
        }
        return lista; 
    }
    
     // Dobavljanje podataka o svim Nabavkama *umesto naziva dobavljaca vraca id_dobavljaca 
    public static List getAllObjNabavkaAndProizvod2() throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_obj_nabavka_and_proizvod()}");
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Nabavka n = Nabavka.getNabavka(rs.getInt("id"));
            Zaposleni z= Zaposleni.getZaposleni(rs.getInt("zaposleni"));
            Datum d= Datum.getDatum(rs.getInt("datum"));
            Dobavljac dob = Dobavljac.getDobavljac(rs.getInt("dobavljac"));
            TipTroska t = TipTroska.getTipTroska(rs.getInt("tip_troska"));
            Proizvod p = Proizvod.getProizvod(rs.getInt("id_proizvoda"));
            double kolicina = rs.getInt("kolicina");
            double cena = rs.getDouble("cena");
            String row = new String (String.valueOf(n.getId())+","+z.getIme()+","+d.toString()+","+String.valueOf(dob.getId())+","+t.getNaziv()+","+p.getNaziv()+","+String.valueOf(kolicina)+","+String.valueOf(cena));
            lista.add(row);
        }
        return lista; 
    
    }
    
    //Dobavljanje podataka sa manje detalja o nabavkama 
    public static List getDistinctNabavkaLessD() throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_distinct_nabavka_less_d()}");
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Integer broj = rs.getInt("id");
            String row = broj.toString();
            lista.add(row);
        }
        return lista; 
    
    }
    

    
     //Dobavljanje podataka o svim nabavkama za konkretnog Dobavljaca
    public static List getAllObjNAPbyDobavljac2(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_obj_nabavke_and_proizvodi_by_dobavljac(?)}");
        List <String> lista = new ArrayList <String> ();
        cs.setInt(1, id);
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Nabavka n = Nabavka.getNabavka(rs.getInt("id"));
            Zaposleni z= Zaposleni.getZaposleni(rs.getInt("zaposleni"));
            Datum d= Datum.getDatum(rs.getInt("datum"));
            Dobavljac dob = Dobavljac.getDobavljac(rs.getInt("dobavljac"));
            TipTroska t = TipTroska.getTipTroska(rs.getInt("tip_troska"));
            Proizvod p = Proizvod.getProizvod(rs.getInt("id_proizvoda"));
            double kolicina = rs.getInt("kolicina");
            double cena = rs.getDouble("cena");
            String row = new String (String.valueOf(n.getId())+","+z.getIme()+","+d.toString()+","+dob.getId()+","+t.getNaziv()+","+p.getNaziv()+","+String.valueOf(kolicina)+","+String.valueOf(cena));
            lista.add(row);
        }
        return lista; 
    
    }
    
    //Dobavljanje podataka sa manje detalja o nabavkama na osnovu konkretnog Dobavljaca
    public static List getDistinctByDobavljacLessD(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
         CallableStatement cs = db.conn.prepareCall("{call get_distinct_nabavka_by_dobavljac_less_d(?)}");
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
 
    
    //Dobavljanje podataka sa manje detalja o nabavkama na osnovu konkretnog Zaposlenog
    public static List getDistinctByZaposleniLessD(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_distinct_nabavka_by_zaposleni_less_d(?)}");
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
    

    
    //Dobavljanje podataka sa manje detalja o nabavkama na osnovu konkretnog Datuma
    public static List getDistinctByDatumLessD(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_obj_nabavke_and_proizvodi_by_datum(?)}");
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
    

    
    //Dobavljanje podataka sa manje detalja o nabavkama na osnovu konkretne Nabavke
    public static List getDistinctByNabavkaLessD(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_distinct_nabavka_by_nabavka_less_d(?)}");
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
    
     public static List <Nabavka> getAllNabavkaByOneDobavljac(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_all_nabavka_by_one_dobavljac(?)}");
        List <Nabavka> lista = new ArrayList <Nabavka> ();
        cs.setInt(1, id);
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Nabavka n = new Nabavka (rs.getInt("zaposleni"),rs.getInt("datum"), rs.getInt("dobavljac"), rs.getInt("tip_troska"));
            n.setId(rs.getInt("id"));
            lista.add(n);
        }
        return lista; 
    
    }
     
    public static int getLastId () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call nabavka_get_last_id()}");
        ResultSet rs = cs.executeQuery();
        int result =0;
        if (rs.next()){
            result = rs.getInt(1);
        }
        return result;
    }
    
     public static List <String> firstTable () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs = db.conn.prepareCall("{call get_nabavka_frist_table()}");
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Datum d = Datum.getDatum(rs.getInt(3));
            lista.add(new String(rs.getString(1)+","+rs.getString(2)+","+d.toString()+","+rs.getString(4)+","+rs.getString(5)));
        }
        return lista; 
    }
     
     
     
     
/*Dobavljanje podataka iz baze --kraj*/   
    
    public void updateNabavka () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        db.conn.setAutoCommit(false);
        
        PreparedStatement st = db.conn.prepareStatement("update nabavke set zaposleni=?, datum=?, dobavljac=?, tip_troska=? where id=?");
        st.setInt(1, this.getZaposleni().getId());
        st.setInt(2, this.getDatum().getId());
        st.setInt(3, this.getDobavljac().getId());
        st.setInt(4, this.getTipTroska().getId());
        
        st.setInt(5, this.getId());
        int result = st.executeUpdate();
        if(result == 1){
            System.out.println("update done");
            db.conn.commit();
        }else{
            db.conn.rollback();
            System.out.println("update fail");
        }
        
        db.conn.setAutoCommit(true);
    }
    
    public static boolean deleteNabavka (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("delete from nabavke where id=?");
        st.setInt(1, id);
        int i=st.executeUpdate();
        
        boolean flag = false;
        if (i>0){
            flag = true;
        }
        return flag;
   }
    
   

    
    
   
}
