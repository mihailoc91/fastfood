
package model;

import controller.IFirstLogin;
import controller.IZaposleni;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;


public class Zaposleni {
    
    public Zaposleni (TipTroska t){
        this.setTipTroska(t);
        listeners = new ArrayList<>();
        listenersFirstLogin = new ArrayList<>();
    }
    
    public Zaposleni (int id) throws SQLException{
        this.setTipTroska(TipTroska.getTipTroska(id));
        listeners = new ArrayList<>();
        listenersFirstLogin = new ArrayList<>();
    }
    
    private int id;
    private String ime;
    private String adresa;
    private String telefon;
    private int tipZaposlenog;
    private TipTroska tipTroska;
    private String lozinka;

  
    public int getId() {
        return id;
    }

   
    public void setId(int id) {
        this.id = id;
    }

    
    public String getIme() {
        return ime;
    }

    
    public void setIme(String ime) {
        this.ime = ime;
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

    
    public int getTipZaposlenog() {
        return tipZaposlenog;
    }

    
    public void setTipZaposlenog(int tipZaposlenog) {
        this.tipZaposlenog = tipZaposlenog;
    }

    
    public TipTroska getTipTroska() {
        return tipTroska;
    }

    
    public void setTipTroska(TipTroska tipTroska) {
        this.tipTroska = tipTroska;
    }

    
    public String getLozinka() {
        return lozinka;
    }

    
    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
    
    @Override
    public String toString (){
        return this.getIme();
    }
    
    
    public void saveZaposleni () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("insert into zaposleni values (null,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        st.setString(1, this.getIme());
        st.setString(2, this.getAdresa());
        st.setString(3, this.getTelefon());
        st.setInt(4, this.getTipZaposlenog());
        st.setInt(5, this.getTipTroska().getId());
        st.setString(6, this.getLozinka());
        st.execute();
        ResultSet rs = st.getGeneratedKeys();
        if(rs.next()){
            this.setId(rs.getInt(1));
        }
    }
/*Dobavljanje podataka iz baze --pocetak*/   
    
    public static Zaposleni getZaposleni (int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs= db.conn.prepareCall("{call get_zaposleni(?)}");
        cs.setInt(1, id);
        Zaposleni z = null;
        ResultSet rs = cs.executeQuery();
        if (rs.next()){
            z = new Zaposleni (rs.getInt("tip_troska"));
            z.setId(rs.getInt("id"));
            z.setIme(rs.getString("ime"));
            z.setAdresa(rs.getString("adresa"));
            z.setTelefon(rs.getString("telefon"));
            z.setTipZaposlenog(rs.getInt("tip_zaposlenog"));
            z.setLozinka(rs.getString("lozinka"));
        }
        return z;
    }
    
    public static List <Zaposleni> getAllZaposleni () throws SQLException{
        DBConnect db = DBConnect.getInstance();
         CallableStatement cs= db.conn.prepareCall("{call get_all_zaposleni()}");
        List <Zaposleni> lista = new ArrayList <Zaposleni> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Zaposleni z = new Zaposleni(rs.getInt("tip_troska"));
            z.setId(rs.getInt("id"));
            z.setIme(rs.getString("ime"));
            z.setAdresa(rs.getString("adresa"));
            z.setTelefon(rs.getString("telefon"));
            z.setTipZaposlenog(rs.getInt("tip_zaposlenog"));
            z.setLozinka(rs.getString("lozinka"));
            
            lista.add(z);
        }
        return lista; 
    }
    
    
    public static List <Zaposleni> getAllZaposleniFromNabavka () throws SQLException{
        DBConnect db = DBConnect.getInstance();
         CallableStatement cs= db.conn.prepareCall("{call zaposleni_get_all_zaposleni_from_nabavka()}");
        List <Zaposleni> lista = new ArrayList <Zaposleni> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Zaposleni z = new Zaposleni(rs.getInt("tip_troska"));
            z.setId(rs.getInt("id"));
            z.setIme(rs.getString("ime"));
            z.setAdresa(rs.getString("adresa"));
            z.setTelefon(rs.getString("telefon"));
            z.setTipZaposlenog(rs.getInt("tip_zaposlenog"));
            z.setLozinka(rs.getString("lozinka"));
            
            lista.add(z);
        }
        return lista; 
    }
    
    public static String getLastZaposleniFirstLogin () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs= db.conn.prepareCall("{call zaposleni_get_last_id()}");
        ResultSet rs = cs.executeQuery();
        String ime = null; 
        if (rs.next()){
            ime = (rs.getString("ime"));
        }
        return ime;
    }
    
    public static List <Zaposleni> getAllZaposleniFromDnevniIzvestaj () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs= db.conn.prepareCall("{call get_all_zaposleni_from_dnevni_izvestaji()}");
        List <Zaposleni> lista = new ArrayList <Zaposleni> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Zaposleni z = new Zaposleni(rs.getInt("tip_troska"));
            z.setId(rs.getInt("id"));
            z.setIme(rs.getString("ime"));
            z.setAdresa(rs.getString("adresa"));
            z.setTelefon(rs.getString("telefon"));
            z.setTipZaposlenog(rs.getInt("tip_zaposlenog"));
            z.setLozinka(rs.getString("lozinka"));
            
            lista.add(z);
        }
        return lista; 
    
    }
    
    public static List <String> getAllObjZaposleni () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs= db.conn.prepareCall("{call get_all_zaposleni()}");
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Zaposleni z = new Zaposleni(rs.getInt("tip_troska"));
            z.setId(rs.getInt("id"));
            z.setIme(rs.getString("ime"));
            z.setAdresa(rs.getString("adresa"));
            z.setTelefon(rs.getString("telefon"));
            z.setTipZaposlenog(rs.getInt("tip_zaposlenog"));
            z.setLozinka(rs.getString("lozinka"));
            
            String s = new String(String.valueOf(z.getId())+","+z.getIme()+","+z.getAdresa()+","+z.getTelefon()+","+String.valueOf(z.getTipZaposlenog())+","+String.valueOf(z.getTipTroska())+","+z.getLozinka());
            lista.add(s);
        }
        return lista; 
    
    }
    
    public static List <String> getAllObjZaposlenizaTabelu () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs= db.conn.prepareCall("{call get_all_zaposleni()}");
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Zaposleni z = new Zaposleni(rs.getInt("tip_troska"));
            z.setId(rs.getInt("id"));
            z.setIme(rs.getString("ime"));
            z.setAdresa(rs.getString("adresa"));
            z.setTelefon(rs.getString("telefon"));
            z.setTipZaposlenog(rs.getInt("tip_zaposlenog"));
            z.setLozinka(rs.getString("lozinka"));
            lista.add( new String(z.getIme()+","+z.getAdresa()+","+z.getTelefon()+","+z.getLozinka()));
        }
        return lista; 
    
    }
    
    public static List <String> getAllObjMenadzeri () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs= db.conn.prepareCall("{call get_all_obj_radnici_or_menadzeri(2)}");
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Zaposleni z = new Zaposleni(rs.getInt("tip_troska"));
            z.setId(rs.getInt("id"));
            z.setIme(rs.getString("ime"));
            z.setAdresa(rs.getString("adresa"));
            z.setTelefon(rs.getString("telefon"));
            z.setTipZaposlenog(rs.getInt("tip_zaposlenog"));
            z.setLozinka(rs.getString("lozinka"));
            
            String s = new String(String.valueOf(z.getId())+","+z.getIme()+","+z.getAdresa()+","+z.getTelefon()+","+String.valueOf(z.getTipZaposlenog())+","+String.valueOf(z.getTipTroska())+","+z.getLozinka());
            lista.add(s);
        }
        return lista; 
    }
    
     public static List <String> getAllObjMenadzeriZaTabelu () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs= db.conn.prepareCall("{call get_all_obj_radnici_or_menadzeri(2)}");
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Zaposleni z = new Zaposleni(rs.getInt("tip_troska"));
            z.setId(rs.getInt("id"));
            z.setIme(rs.getString("ime"));
            z.setAdresa(rs.getString("adresa"));
            z.setTelefon(rs.getString("telefon"));
            z.setTipZaposlenog(rs.getInt("tip_zaposlenog"));
            z.setLozinka(rs.getString("lozinka"));
            lista.add(new String(z.getIme()+","+z.getAdresa()+","+z.getTelefon()+","+z.getLozinka()));
        }
        return lista; 
    }
    
    public static List <String> getAllObjRadnici () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs= db.conn.prepareCall("{call get_all_obj_radnici_or_menadzeri(1)}");
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Zaposleni z = new Zaposleni(rs.getInt("tip_troska"));
            z.setId(rs.getInt("id"));
            z.setIme(rs.getString("ime"));
            z.setAdresa(rs.getString("adresa"));
            z.setTelefon(rs.getString("telefon"));
            z.setTipZaposlenog(rs.getInt("tip_zaposlenog"));
            z.setLozinka(rs.getString("lozinka"));
            
            String s = new String(String.valueOf(z.getId())+","+z.getIme()+","+z.getAdresa()+","+z.getTelefon()+","+String.valueOf(z.getTipZaposlenog())+","+String.valueOf(z.getTipTroska())+","+z.getLozinka());
            lista.add(s);
        }
        return lista; 
    }
    
    public static List <String> getAllObjRadniciZaTabelu () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs= db.conn.prepareCall("{call get_all_obj_radnici_or_menadzeri(1)}");
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Zaposleni z = new Zaposleni(rs.getInt("tip_troska"));
            z.setId(rs.getInt("id"));
            z.setIme(rs.getString("ime"));
            z.setAdresa(rs.getString("adresa"));
            z.setTelefon(rs.getString("telefon"));
            z.setTipZaposlenog(rs.getInt("tip_zaposlenog"));
            z.setLozinka(rs.getString("lozinka"));
            lista.add(new String(z.getIme()+","+z.getAdresa()+","+z.getTelefon()+","+z.getLozinka()));
        }
        return lista; 
    }
    
    public static List <String> getAllObjStalnoZap () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs= db.conn.prepareCall("{call get_all_obj_stalno_zap_or_na_ugovor(1)}");
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Zaposleni z = new Zaposleni(rs.getInt("tip_troska"));
            z.setId(rs.getInt("id"));
            z.setIme(rs.getString("ime"));
            z.setAdresa(rs.getString("adresa"));
            z.setTelefon(rs.getString("telefon"));
            z.setTipZaposlenog(rs.getInt("tip_zaposlenog"));
            z.setLozinka(rs.getString("lozinka"));
            
            String s = new String(String.valueOf(z.getId())+","+z.getIme()+","+z.getAdresa()+","+z.getTelefon()+","+String.valueOf(z.getTipZaposlenog())+","+String.valueOf(z.getTipTroska())+","+z.getLozinka());
            lista.add(s);
        }
        return lista; 
    }
    
    public static List <String> getAllObjStalnoZapZaTabelu () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs= db.conn.prepareCall("{call get_all_obj_stalno_zap_or_na_ugovor(1)}");
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Zaposleni z = new Zaposleni(rs.getInt("tip_troska"));
            z.setId(rs.getInt("id"));
            z.setIme(rs.getString("ime"));
            z.setAdresa(rs.getString("adresa"));
            z.setTelefon(rs.getString("telefon"));
            z.setTipZaposlenog(rs.getInt("tip_zaposlenog"));
            z.setLozinka(rs.getString("lozinka"));
            lista.add(new String(z.getIme()+","+z.getAdresa()+","+z.getTelefon()+","+z.getLozinka()));
        }
        return lista; 
    
    }
    
    public static List <String> getAllObjNaUgovor () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs= db.conn.prepareCall("{call get_all_obj_stalno_zap_or_na_ugovor(2)}");
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Zaposleni z = new Zaposleni(rs.getInt("tip_troska"));
            z.setId(rs.getInt("id"));
            z.setIme(rs.getString("ime"));
            z.setAdresa(rs.getString("adresa"));
            z.setTelefon(rs.getString("telefon"));
            z.setTipZaposlenog(rs.getInt("tip_zaposlenog"));
            z.setLozinka(rs.getString("lozinka"));
            
            String s = new String(String.valueOf(z.getId())+","+z.getIme()+","+z.getAdresa()+","+z.getTelefon()+","+String.valueOf(z.getTipZaposlenog())+","+String.valueOf(z.getTipTroska())+","+z.getLozinka());
            lista.add(s);
        }
        return lista; 
    }
    
    public static List <String> getAllObjNaUgovorZaTabelu () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs= db.conn.prepareCall("{call get_all_obj_stalno_zap_or_na_ugovor(2)}");
        List <String> lista = new ArrayList <String> ();
        ResultSet rs = cs.executeQuery();
        while(rs.next()){
            Zaposleni z = new Zaposleni(rs.getInt("tip_troska"));
            z.setId(rs.getInt("id"));
            z.setIme(rs.getString("ime"));
            z.setAdresa(rs.getString("adresa"));
            z.setTelefon(rs.getString("telefon"));
            z.setTipZaposlenog(rs.getInt("tip_zaposlenog"));
            z.setLozinka(rs.getString("lozinka"));
            lista.add(new String(z.getIme()+","+z.getAdresa()+","+z.getTelefon()+","+z.getLozinka()));
        }
        return lista; 
    
    }
    
/*Dobavljanje podataka iz baze --kraj*/  


    
    public int updateZaposleni () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("update zaposleni set ime=?, adresa=?, telefon=?, tip_zaposlenog=?, tip_troska=?, lozinka=? where id=?");
        st.setString(1, this.getIme());
        st.setString(2, this.getAdresa());
        st.setString(3, this.getTelefon());
        st.setInt(4, this.getTipZaposlenog());
        st.setInt(5, this.getTipTroska().getId());
        st.setString(6, this.getLozinka());
        st.setInt(7, this.getId());
         int result = st.executeUpdate();
        
        if(result == 1){
            System.out.println("update done");
        }else{
            System.out.println("update fail");
        }
        return result;
    }
    
    public static boolean deleteZaposleni(int id) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("delete from zaposleni where id=?");
        st.setInt(1, id);
        int i=st.executeUpdate();
        
        boolean flag = false;
        if (i>0){
            flag = true;
        }
        return flag;
   }
    
    
    
    
    // Obicno logovanje
    public  static Zaposleni getZaposleniByNameAndPass (String ime, String lozinka) throws SQLException{
        DBConnect db = DBConnect.getInstance();
        CallableStatement cs= db.conn.prepareCall("{call get_zaposleni_by_name_and_pass(?,?)}");
        cs.setString(1, ime);
        cs.setString(2, lozinka);
        ResultSet rs = cs.executeQuery();
        Zaposleni z = null;
        if(rs.next()){
             z = Zaposleni.getZaposleni(rs.getInt("id"));
        }else {
            System.out.println("Ne postoji zaposleni sa tim imenom i lozinkom!");
        }
        return z;
    }
    // Prvo logovanje -- pocetak
    public static Zaposleni getFirstLogin () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("select * from first_login");
        ResultSet rs = st.executeQuery();
        Zaposleni z = null;
        if(rs.next()){
            z = new Zaposleni (0);
            z.setLozinka(rs.getString("Lozinka"));
        }
        return z;
    }
    
    public static void dropTableFirstLogin () throws SQLException{
        DBConnect db = DBConnect.getInstance();
        PreparedStatement st = db.conn.prepareStatement("drop table first_login");
        st.execute();
    }
    // Prvo logovanje --kraj
    
    /* Event --pocetak*/
    
    private List <IZaposleni> listeners;
    public void addEventListener (IZaposleni lis){
        listeners.add(lis);
    }
    public void removeEventListener (IZaposleni lis){
        listeners.remove(lis);
    }
    
    public void distributeEvent (){
        for (IZaposleni lis: listeners){
            lis.zaposleniUlogovan(new EventObject(this));
    
        }
    }
    
    //Prvo logovanje - Event -
    private List <IFirstLogin> listenersFirstLogin;
    public void addEventListenerFirstLogin (IFirstLogin lis){
        listenersFirstLogin.add(lis);
    }
    public void removeEventListenerFirstLogin (IFirstLogin lis){
        listenersFirstLogin.remove(lis);
    }
    public void distributeEventFirstLogin (){
        for (IFirstLogin lis: listenersFirstLogin){
         lis.firstLogin(new EventObject(this));
        }
    }

    /* Event --kraj */
            
    
}
