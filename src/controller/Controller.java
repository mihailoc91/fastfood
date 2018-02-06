package controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.DBConnect;
import model.Datum;
import model.DnevniIzvProizvod;
import model.DnevniIzvestaj;
import model.Dobavljac;
import model.Nabavka;
import model.NabavkaProizvod;
import model.Proizvod;
import model.TipProizvoda;
import model.TipTroska;
import model.Trosak;
import model.Zaposleni;
import view.ZaposleniForm;

public class Controller {
   
    public String userName;
    public String passWord;
    
/* parseri (provera ispravnosti unosa) --pocetak  */
    
        public static int doubleCheck (String s){
            int flag = 0;

            Pattern pattern = Pattern.compile("^[0-9]+ *\\.*[0-9]*$");
            Matcher matcher = pattern.matcher(s);

            if (matcher.find()){
                 flag = 1;
            } else {
            }

            return flag;
        }

        public static int intCheck (String s){
            int flag = 0;

            Pattern pattern = Pattern.compile("^[0-9]+ *[0-9]*$");
            Matcher matcher = pattern.matcher(s);

            if (matcher.find()){
                flag = 1;
            } else {
            }

            return flag;
        }

        public static int textCheck (String s){
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+ *[a-zA-Z0-9]*$");
            Matcher matcher = pattern.matcher(s);
            int flag = 0;
            if (matcher.find()){
                
                flag = 1;
            } else {
            }
            
            return flag;
        }

        public static int longTextCheck (String s){
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+ *[a-zA-Z0-9]* *[a-zA-Z0-9]* *[a-zA-Z0-9]* *[a-zA-Z0-9]*$");
            Matcher matcher = pattern.matcher(s);
            int flag = 0;
            if (matcher.find()){
                
                flag = 1;
            } else {
            }
            
            return flag;
        }

        public static int passCheck (String s){
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
            Matcher matcher = pattern.matcher(s);
            int flag = 0;
            if (matcher.find()){
                flag = 1;
            } else {
            }
            
            return flag;
        }

/* parseri (provera ispravnosti unosa) --kraj  */   
    
        
/* logovanje --pocetak */  
        
        
        public static void firstLogin (JOptionPane j, JFrame f){
            try {
                Zaposleni z = Zaposleni.getFirstLogin();
                j.showMessageDialog(j.getParent(), "Prvi put se logujete u aplikaciju, neophodno je da unesete podatke koje ste dobili u dokumentaciji, "
                        + "i potom da unesete podatke na osnovu kojih cete se u buducnosti logovati.", "Prvo logovanje", JOptionPane.INFORMATION_MESSAGE);
                String response = JOptionPane.showInputDialog("Unesite lozinku: ");

                    if(textCheck(response)==1 && response.equals(z.getLozinka())){
                    j.showMessageDialog(j.getParent(), "Unesite podatke na osnovu kojih cete se u buducnosti logovati.", "Prvo logovanje", JOptionPane.INFORMATION_MESSAGE);
                     Zaposleni.dropTableFirstLogin();
                     ZaposleniForm zf = new ZaposleniForm();
                     z.addEventListenerFirstLogin(zf);
                     z.distributeEventFirstLogin();
                     f.setContentPane(zf);
                     f.revalidate();
                    }else{
                    j.showMessageDialog(j.getParent(), "Neispravna lozinka, pokusajte ponovo!", "Prvo logovanje", JOptionPane.INFORMATION_MESSAGE);  
                        firstLogin(j, f);
                    }
            }   catch (SQLException ex) {
                }
        }
        
        //Logovanje (Nalazi se u formi: ZaposleniForma)
        public static void firstLoginInput (JOptionPane optionPane, ZaposleniForm zf) throws SQLException{
            if (zf.zapFirstLogin){
                optionPane.showMessageDialog(optionPane.getParent(), "Uspesno ste dodali zaposlenog: " + Zaposleni.getLastZaposleniFirstLogin() + ".", "Zaposleni", JOptionPane.INFORMATION_MESSAGE);
                optionPane.showMessageDialog(optionPane.getParent(),"Aplikacija ce se sad zatvoriti, molimo vas pokrenite ponovo aplikaciju i ulogujte se sa podacima koje ste uneli!","Zaposleni",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0); 
            }else {
                optionPane.showMessageDialog(optionPane.getParent(), "Neuspesan pokusaj unosenja podataka neophodnih za logovanje!", "Zaposleni", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        public static Zaposleni login (String s1, String s2) throws SQLException{
            Zaposleni zaposleni = null;
            if(textCheck(s1)==1 && passCheck(s2)==1){
                 zaposleni = Zaposleni.getZaposleniByNameAndPass(s1, s2);
                if(zaposleni != null){
                return zaposleni;
                }
            }else {
                
            }
            return zaposleni ;
        }
        
        
/* logovanje --kraj */  
    
    
/*Dobavljanje podataka --pocetak */
    
        
        public static Map getJTableValueOfColumn (JTable j,int id) throws SQLException{
            int k=1;
            Map map = new HashMap ();
            for (int i=0;i<Proizvod.getAllProizvod().size();i++) {
                map.put(k,j.getModel().getValueAt(i, id));
               
              k++;
               
             }
            return map;
        }

        
        
        public static boolean getJTableProizvodi (JTable j, int idKolicina,int idCena,int idNabavke,JOptionPane op) throws SQLException{
            List <Proizvod> listaProizvoda = Proizvod.getAllProizvod();
            Map kolicina = getJTableValueOfColumn(j, idKolicina);
            Map cena = getJTableValueOfColumn(j, idCena);
            int k=1;
            int b=0;
            boolean flag = false;
                
                for(int i=0;i<listaProizvoda.size();i++){
                    Proizvod p = listaProizvoda.get(i);
                    
                    if(p!=null){
                    NabavkaProizvod np = new NabavkaProizvod(idNabavke,p.getId());
                        
                    if(kolicina.get(k) != null && cena.get(k) != null){
                        
                    Double kolicinaDouble = (Double) kolicina.get(k);
                    String kolicinaString = kolicinaDouble.toString();
                    Double cenaDouble = (Double)cena.get(k);
                    String cenaString = cenaDouble.toString();
                      if(doubleCheck(kolicinaString)==1){
                          
                       np.setKolicina(kolicinaDouble);
                       b++;
                    }
                      if(doubleCheck(cenaString)==1){
                       np.setCena(cenaDouble);
                          
                    }
                        
                    np.saveNabavkaProizvod();
                    flag = true;
                    }
                    
                    }
                    k++;
                } 
                if (b==0){
                op.showMessageDialog (op.getParent(),"Niste uneli podatke u tabelu. Molimo vas unesite podatke i pokusajte ponovo!","Tabela",JOptionPane.INFORMATION_MESSAGE); 
                }    
                 return flag;
        }

       
        public static Dobavljac getDobavljacFromList (JList j) throws SQLException{
            List <Dobavljac> lista = Dobavljac.getAllDobavljac();
            int index = j.getSelectedIndex();
            Dobavljac d = null;
            if(index != -1){
               d = lista.get(index);  
            }
            return d;
        }
        
       
      //Dobavlja datum iz Jliste  int idForme : 1 za NabavkaUpdate, 2 za DnevniIzvestajUpdate -koristi se u controller.exit
        public static Datum getDatumFromList (JList j, int idForme) throws SQLException{
            List <Datum> lista;
            switch(idForme){
                case 1:
                lista = Datum.getAllDatumFromNabavka();
                break;
                case 2:
                    lista = Datum.getAllDatumFromDnevniIzvestaj();
                break;
                case 3:
                lista = Datum.getAllDatum();
                break;
                default:
                    lista =null;
                break;
            }
            int index = j.getSelectedIndex();
            Datum d = null;
            if(index != -1){
               d = lista.get(index);  
            }
            return d;
        }

        public static TipTroska getTipTroskaFromJRButton (ButtonGroup b) throws SQLException{
            TipTroska t=null;
             if(b.getSelection().getActionCommand() != null){
             t=TipTroska.getTipTroska(Integer.valueOf(b.getSelection().getActionCommand()));
        }
            return t;
        }

        public static Datum getDatum (String s){
            Pattern pattern = Pattern.compile("^[0-9]+\\.[0-9]+\\.[0-9]+\\.$");
            Matcher matcher = pattern.matcher(s);
            Datum d = new Datum();
            if (matcher.find()){

            String []arr = s.split("\\.");
            d.setDan(Integer.valueOf(arr[0]));
            d.setMesec(Integer.valueOf(arr[1]));
            d.setGodina(Integer.valueOf(arr[2]));
            }
           return d;
        }
      
        public static boolean getJTableDnevniIzvestaj (JTable j, int idIznos,int idDnevnogIzvestaja,JOptionPane op) throws SQLException{
            List <Proizvod> listaProizvoda = Proizvod.getAllProizvod();
            Map iznos = getJTableValueOfColumn(j, idIznos);
            int k=1;
            boolean flag=false;
            int b = 0;
            for(int i=0;i<listaProizvoda.size();i++){
                Proizvod p = listaProizvoda.get(i);
                if(p!=null){
                DnevniIzvProizvod dip = new DnevniIzvProizvod(idDnevnogIzvestaja,p.getId());
                if(iznos.get(k) != null){
                 Double iznosDouble = (Double)iznos.get(k);
                 String iznosString = iznosDouble.toString();
                    
                  if(doubleCheck(iznosString)==1){
                   dip.setIznos(iznosDouble);
                   dip.saveDnevniIzvProizvod();
                   flag = true;
                  }else {
                  op.showMessageDialog(op.getParent(),"Neispravan unos vrednosti u polju: " + p.getNaziv(), "Neispravan unos", JOptionPane.ERROR_MESSAGE );    
                  }
                
                 b++;
                }

                
                }
                 k++;
            } if (b==0){
                    System.out.println(b);
                op.showMessageDialog (op.getParent(),"Niste uneli podatke u tabelu. Molimo vas unesite podatke i pokusajte ponovo!","Tabela",JOptionPane.INFORMATION_MESSAGE); 
                }    
            return flag;
        }
        
    
        public static int getTipZaposlenogFromJRButton (ButtonGroup b) throws SQLException{
            int t=0;
            if(b.getSelection().getActionCommand() != null){
             t = Integer.valueOf(b.getSelection().getActionCommand());

        }
            return t;
        }

      
        public static TipProizvoda getTipProizvodaFromList (JList j) throws SQLException{
            List <TipProizvoda> lista = TipProizvoda.getAllTipProizvoda();
            int index = j.getSelectedIndex();
            TipProizvoda t = null;
            if(index != -1){
               t = lista.get(index);  
            }
            return t;
        }

/*Dobavljanje podataka --kraj */

        
/* popunjavanje podacima --pocetak */
    
       
        // postavljanje datuma (Nalazi se u fromi: TroskoviForm, NabavkaForm, DnevniIzvestajForm) 
        public static String setDatum () throws SQLException{

                LocalDate now = LocalDate.now();
                
                int dan = now.getDayOfMonth();
                int mesec =now.getMonthValue();
                int godina = now.getYear();
               
                String vreme = (""+dan+"."+mesec+"."+godina+".");

            return vreme;
        }
        
         
     
        // popunjavanje Liste podacima o Dobavljacima  (Nalazi se u formi: NabavkaForm)  
        public static DefaultListModel setJlistModelOfDobavljac () throws SQLException{
            DefaultListModel dlm = new DefaultListModel ();
            for(Dobavljac d : Dobavljac.getAllDobavljac()){
                dlm.addElement(d);
            }
            return dlm;
       }  
        
       
        // popunjavanje Tabele sa podacima o proizvodima   (Nalazi se u formi: NabavkaForm)
        public static JTable setJTableProizvodi (JTable j) throws SQLException{
           j.getColumnModel().getColumn(0).setHeaderValue("Proizvodi");
           j.getColumnModel().getColumn(1).setHeaderValue("Kolicina");
           j.getColumnModel().getColumn(2).setHeaderValue("Cena");
           for (int i=0;i<Proizvod.getAllProizvod().size();i++) {
                List <Proizvod> lista = Proizvod.getAllProizvod();
                j.getModel().setValueAt(lista.get(i).getNaziv(), i, 0);
            }
            return j;
       } 
        
        
        //popunjavanje Tabele sa podacima o proizvodima   (Nalazi se u formi: NabavkaForm) !!drugi pokusaj
        public static JTable setJTableProizvodi2 (JTable j) throws SQLException{
           j.getColumnModel().getColumn(0).setHeaderValue("Proizvodi");
           j.getColumnModel().getColumn(1).setHeaderValue("Kolicina");
           j.getColumnModel().getColumn(2).setHeaderValue("Cena");
           DefaultTableModel model = (DefaultTableModel) j.getModel();
           for (int i=0;i<Proizvod.getAllProizvod().size();i++) {
                List <Proizvod> lista = Proizvod.getAllProizvod();
                String [] row = new String []{lista.get(i).getNaziv()};
                
                model.addRow(row);  
            }
            return j;
       } 
     
        // Postavljanje novog ID-a Nabavke (Nalazi se u formi: NabavkaForm)
        public static int setNabavkaId () throws SQLException {
         int id = Integer.valueOf(Nabavka.getLastId());
           return id +1;

        }
     
        // Popunjavanje podacima o novom ID-u prilikom unosenja novog Dnevnog Izvestaja (Nalazi se u formi: DnevniIzvestajForm)   
        public static int setDnevniIzvestajId () throws SQLException {
         int id = Integer.valueOf(DnevniIzvestaj.getLastId());
           return id +1;

        }
     
        //Popunjavanje podacima Tabele o Proizvodima (Nalazi se u fromi: DnevniIzvestajForm)   
        public static JTable setJTableDnevniIzvestaj (JTable j) throws SQLException{
           j.getColumnModel().getColumn(0).setHeaderValue("Proizvodi");
           j.getColumnModel().getColumn(1).setHeaderValue("Iznos");
           for (int i=0;i<Proizvod.getAllProizvod().size();i++) {
                List <Proizvod> lista = Proizvod.getAllProizvod();
                j.getModel().setValueAt(lista.get(i).getNaziv(), i, 0);
            }
            return j;
       }
        
    
        //Popunjavanje podacima Tabele o Proizvodima (Nalazi se u fromi: DnevniIzvestajForm) !!drugi pokusaj ovog gore
        public static JTable setJTableDnevniIzvestaj2 (JTable j) throws SQLException{
           j.getColumnModel().getColumn(0).setHeaderValue("Proizvodi");
           j.getColumnModel().getColumn(1).setHeaderValue("Iznos");
           DefaultTableModel model = (DefaultTableModel)j.getModel();
           for (int i=0;i<Proizvod.getAllProizvod().size();i++) {
                List <Proizvod> lista = Proizvod.getAllProizvod();
                String [] row = new String []{lista.get(i).getNaziv()};
                
                model.addRow(row); 
            }
            return j;
       }
        
       
        //Popunjavanje podacima Tip Proizvoda za Listu (Nalazi se u formi: ProizvodForm)    
        public static DefaultListModel setJlistModelOfTipProizvoda() throws SQLException{
            DefaultListModel dlm = new DefaultListModel ();
            for(TipProizvoda t : TipProizvoda.getAllTipProizvoda()){
                dlm.addElement(t);
            }
            return dlm;
       }
  
/* popunjavanje podacima --kraj */
    
    
/*cuvanje podataka --pocetak */
    
    
        // Cuvanje podataka o Nabavci (Nalazi se u formi: NabavkaForm)
        public static void saveNabavka (String datum,JList j, int zaposleniId,ButtonGroup b, JTable table,int idKolicina,int idCena, JOptionPane op) throws SQLException{
           Datum d = getDatum(datum);
           Datum d1= Datum.getLastId();
           
           
           
            DBConnect db = DBConnect.getInstance();
            db.conn.setAutoCommit(false);
            Dobavljac dob = getDobavljacFromList(j);
            Zaposleni z = Zaposleni.getZaposleni(zaposleniId);
            TipTroska t = getTipTroskaFromJRButton(b);
            
            if(d.getDan()==d1.getDan() && d.getMesec()==d1.getMesec() && d.getGodina()== d1.getGodina()){
               d=d1;
           }else{
               d.saveDatum();
           }
            Nabavka n = new Nabavka(z,d,dob,t);
            n.saveNabavka();
           boolean flag = getJTableProizvodi(table, idKolicina, idCena, n.getId(),op);
           if (flag){
               db.conn.commit();
               op.showMessageDialog(op.getParent(),"Uspesno sacuvana nabavka pod rednim brojem: " + Nabavka.getNabavka(n.getId()).getId(),"Nabavka", JOptionPane.INFORMATION_MESSAGE);
           }else{
               db.conn.rollback();
               
           }
           db.conn.setAutoCommit(true);
           

       }
      
        //Cuvanje Dnevnog Izvestaja (Nalazi se u formi: DnevniIzvestajForm)   
        public static void saveDnevniIzvestaj (String datum, int zaposleniId, JTable table,int idIznos, JOptionPane op) throws SQLException{
           Datum d = getDatum(datum);
           Datum d1= Datum.getLastId();
           
           
           Zaposleni z = Zaposleni.getZaposleni(zaposleniId);
           
           DBConnect db = DBConnect.getInstance();
           db.conn.setAutoCommit(false);
           if(d.getDan()==d1.getDan() && d.getMesec()==d1.getMesec() && d.getGodina()== d1.getGodina()){
               d=d1;
           }else{
               d.saveDatum();
           }
           DnevniIzvestaj di = new DnevniIzvestaj(d, z);
           di.saveDnevniIzvestaj();
           boolean flag =getJTableDnevniIzvestaj(table,idIznos,di.getId(),op);
           if(flag){
               db.conn.commit();
               op.showMessageDialog(op.getParent(),"Uspesno ste sacuvali dnevni izvestaj pod rednim brojem: " + DnevniIzvestaj.getDnevniIzvestaj(di.getId()).getId(),"Dnevni izvestaj",JOptionPane.INFORMATION_MESSAGE);
           }else {
               db.conn.rollback();
               
           }
           db.conn.setAutoCommit(true);
       }
        
       
        // Cuvanje Zaposlenog (nalazi se u formi ZaposleniForm)
        public static void saveZaposleni (String ime, String adresa,String telefon,ButtonGroup b1,ButtonGroup b2,String lozinka, JOptionPane op) throws SQLException{
            Zaposleni zaposleni = new Zaposleni (getTipTroskaFromJRButton(b1));
            int b = 1;
            DBConnect db = DBConnect.getInstance();
            db.conn.setAutoCommit(false);
            if(textCheck(ime)==1 && !ime.isEmpty()){
                    zaposleni.setIme(ime);
                    b++;
            if(textCheck(adresa)==1 && !adresa.isEmpty()){
                zaposleni.setAdresa(adresa);
                b++;
                }
                if(textCheck(telefon)==1 && !telefon.isEmpty()){
                    zaposleni.setTelefon(telefon);
                    b++;
                    }
                    if(passCheck(lozinka)==1 && !lozinka.isEmpty()){
                        zaposleni.setLozinka(lozinka);
                        b++;
                        }
                        zaposleni.setTipZaposlenog(getTipZaposlenogFromJRButton(b2));
                }
            if(b==5){
                zaposleni.saveZaposleni();
                if(zaposleni.getId()!= 0){
                    db.conn.commit();
                    op.showMessageDialog(op.getParent(),"Uspesno sacuvan zaposleni: "+ Zaposleni.getZaposleni(zaposleni.getId()).getIme(),"Zaposleni",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    db.conn.rollback();
                    op.showMessageDialog(op.getParent(),"Neuspesno sacuvan zaposleni. Molimo vas pokusajte ponovo! ","Zaposleni",JOptionPane.INFORMATION_MESSAGE);
                }
                
            }else{
                op.showMessageDialog(op.getParent(),"Neispravan unos podataka. Molimo vas pokusajte ponovo! ","Neispravan unos",JOptionPane.ERROR_MESSAGE);
            }
            db.conn.setAutoCommit(true);
        }
      
        //Cuvanje tipa proizvoda (Nalazi se u formi: TipProizvodaForm)    
        public static void saveTipProizvoda (String naziv, String opis,JOptionPane op) throws SQLException{
            TipProizvoda t = new TipProizvoda();
            int b = 0;
            DBConnect db = DBConnect.getInstance();
            db.conn.setAutoCommit(false);
            if(textCheck(naziv) == 1 && !naziv.isEmpty()){
                t.setNaziv(naziv);
                
                    if (longTextCheck(opis)==1 && !opis.isEmpty()){
                         t.setOpis(opis);
                         b++;
                         t.saveTipProizvoda();
                         if(t.getId() !=0){
                             db.conn.commit();
                             op.showMessageDialog(op.getParent(),"Uspesno sacuvan tip proizvoda: " + TipProizvoda.getTipProizvoda(t.getId()),"Tip proizvoda",JOptionPane.INFORMATION_MESSAGE);
                         }else{
                             op.showMessageDialog(op.getParent(),"Neuspesno sacuvan tip proizvoda. Molimo vas pokusajte ponovo! ","Tip proizvoda",JOptionPane.INFORMATION_MESSAGE);
                         }
                    }
            }
            if (b == 0){
            op.showMessageDialog(op.getParent(),"Neispravan unos podataka. Molimo vas pokusajte ponovo! ","Neispravan unos",JOptionPane.ERROR_MESSAGE);
            }
            
            db.conn.setAutoCommit(true);
         }   
  
        // Cuvanje tipa Proizvod  (Nalazi se u formi: ProizvodForm)   
        public static void saveProizvod (String naziv,double cena,double kolicina, double gramaza,JList j,JOptionPane op) throws SQLException{
           Proizvod p = new Proizvod(getTipProizvodaFromList(j));
           DBConnect db = DBConnect.getInstance();
           db.conn.setAutoCommit(false);
           int b=0;
           if(textCheck(naziv)==1){
               p.setNaziv(naziv);
               b++;
               if(doubleCheck(Double.toString(cena))==1){
                   p.setCena(cena);
                   b++;
               }
               if(doubleCheck(Double.toString(kolicina))==1){
                   p.setKolicina(kolicina);
                   b++;
               }
               if(doubleCheck(Double.toString(gramaza))==1){
                   p.setGramaza(gramaza);
                   b++;
               }
           }
           
           if(b==4){
               p.saveProizvod();
               if(p.getId()!=0){
                   db.conn.commit();
                   op.showMessageDialog(op.getParent(),"Uspesno ste sacuvali proizvod: " + Proizvod.getProizvod(p.getId()).getNaziv(),"Proizvod",JOptionPane.INFORMATION_MESSAGE );
               }else{
                   db.conn.rollback();
                   op.showMessageDialog(op.getParent(),"Neuspesno ste sacuvali proizvod. Molimo vas pokusajte ponovo! ","Proizvod",JOptionPane.INFORMATION_MESSAGE );
               }
           }
           db.conn.setAutoCommit(true);
           
       }
   
        //Cuvanje troska (Nalazi se u formi: TroskoviForm)    
        public static void saveTroskovi (ButtonGroup b,String datum,double iznos, String naziv, JOptionPane op) throws SQLException{
            Datum d = getDatum(datum);
            Datum d1= Datum.getLastId();
            DBConnect db = DBConnect.getInstance();
            db.conn.setAutoCommit(false);
            int dat=0;
            if(d.getDan()==d1.getDan() && d.getMesec()==d1.getMesec() && d.getGodina()== d1.getGodina()){
                            d=d1;
                            dat=1;
            }
            Trosak t = new Trosak(getTipTroskaFromJRButton(b), d);
            if(textCheck(naziv)==1 && !naziv.isEmpty()){
                t.setNaziv(naziv);
                
                if(doubleCheck(Double.toString(iznos))==1){
                    t.setIznos(iznos);
                    if(dat==0){
                         d.saveDatum();
                       }
                    t.saveTrosak();
                   
                }
                
            }else{
               op.showMessageDialog(op.getParent(),"Neispravan unos podataka. Molimo vas pokusajte ponovo! ","Neispravan unos",JOptionPane.ERROR_MESSAGE); 
            }
            
            if(t.getId() != 0){
                db.conn.commit();
                 op.showMessageDialog(op.getParent(),"Uspesno sacuvan trosak: " + Trosak.getTrosak(t.getId()).getNaziv(),"Trosak",JOptionPane.INFORMATION_MESSAGE);
            }else{
                db.conn.rollback();
                 op.showMessageDialog(op.getParent(),"Neuspesno sacuvan trosak. Molimo vas pokusajte ponovo! ","Trosak",JOptionPane.INFORMATION_MESSAGE);
            }
            db.conn.setAutoCommit(true);
        }
        
      
        // Cuvanje podataka o Dobavljacu (Nalazi se u formi: DobavljacForm)    
        public static void saveDobavljac (String naziv, String pib, String adresa, String telefon,JOptionPane op) throws SQLException{
            Dobavljac d = new Dobavljac ();
            int b =0;
            DBConnect db = DBConnect.getInstance();
            db.conn.setAutoCommit(false);
            if(textCheck(naziv)==1 && !naziv.isEmpty() ){
                d.setNaziv(naziv);
              
            }else{
                b++;
             
            } 
            if(textCheck(pib)==1 && !pib.isEmpty()){
                d.setPib(pib);
            }else{
                b++;
              
            }
            if(textCheck(adresa)==1 && !adresa.isEmpty()){
                d.setAdresa(adresa);
             }else{
                b++;
               
            }
            if(textCheck(telefon)==1 && !telefon.isEmpty()){
                d.setTelefon(telefon);
            }else{
               
                b++;
            }
            
            if(b==0){
                d.saveDobavljac();
                if(d.getId() != 0){
                    db.conn.commit();
                    op.showMessageDialog(op.getParent(),"Uspesno ste sacuvali dobavljaca: " + Dobavljac.getDobavljac(d.getId()).getNaziv(),"Dobavljac",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    db.conn.rollback();
                op.showMessageDialog(op.getParent(),"Neuspesno ste sacuvali dobavljaca. Molimo vas pokusajte ponovo! " ,"Dobavljac",JOptionPane.INFORMATION_MESSAGE);
                }
            }else {
               
                op.showMessageDialog(op.getParent(),"Neispravan unos podataka. Molimo vas pokusajte ponovo!","Neispravan unos",JOptionPane.ERROR_MESSAGE);
            }
            db.conn.setAutoCommit(true);
        }    

/*cuvanje podataka --kraj */

/* Obavestenja --pocetak*/
     
        public static void praznoPolje (JOptionPane op){
            op.showMessageDialog(op.getParent(),"Neispravan unos podataka! Molimo vas proverite podatke koje ste pokusali da unesete i pokusajte ponovo.","Informacija",JOptionPane.INFORMATION_MESSAGE);
            
        }
/* Obavestenja --kraj*/
        
        
}
