
package controller;

import static controller.Controller.doubleCheck;
import static controller.Controller.getJTableValueOfColumn;
import static controller.Controller.getTipProizvodaFromList;
import static controller.Controller.getTipTroskaFromJRButton;
import static controller.Controller.getTipZaposlenogFromJRButton;
import static controller.Controller.intCheck;
import static controller.Controller.longTextCheck;
import static controller.Controller.passCheck;
import static controller.Controller.textCheck;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;
import model.DBConnect;
import model.Datum;
import model.DnevniIzvProizvod;
import model.DnevniIzvestaj;
import model.Dobavljac;
import model.Izlaz;
import model.Nabavka;
import model.NabavkaProizvod;
import model.Proizvod;
import model.TipProizvoda;
import model.TipTroska;
import model.Trosak;
import model.Ulaz;

import model.Zaposleni;


public class ControllerExit {
    
    
    
/*Popunavanje podacima --pocetak*/    
    
// Popunjavanje podacima Liste (Nalazi se u formi: NabavkaPForm)
    /*int i = to je odabir izmedju lista a int id - je odabri izmedju formi Nabavka/Dnevni izvestaj...
    idForme=1 je za NabavkaOut
    idForme=2 je za DnevniIzvestajOUT 
    idForme=3 je za ProizvodiOut
    idForme=4 je za DobavljacOut
    idForme=5 je za TipoviProizvodaOut
    idForme=6 je za TroskoviOut
    idForme=8 je za NabavkaUpdate
    idForme=9 je za DnevniIzvestajUpdate
    idForme=10 je za TrenutnoStanje*/
    
    public static DefaultListModel setJListModel (int i,int idForme) throws SQLException{
        DefaultListModel dlm = new DefaultListModel();
        switch (idForme){
            case 1:
                    switch (i){
                        case 1:
                            for(Dobavljac d : Dobavljac.getAllDobavljacFromNabavkeList()){
                                dlm.addElement(d);
                            }
                        return dlm;
                        case 2:
                            for(Datum d : Datum.getAllDatumFromNabavka()){
                                dlm.addElement(d);
                            }
                        return dlm;
                        case 3:
                            for(Zaposleni d : Zaposleni.getAllZaposleniFromNabavka()){
                                dlm.addElement(d);
                            }
                        return dlm;
                        case 4:
                            for(Nabavka d : Nabavka.getAllNabavkaFromNabavkeProizvodi()){
                                dlm.addElement(d);
                            }
                        return dlm;
                        default:
                        return dlm;   
                    }
                   
            case 2:
                    switch (i){
                        
                        case 2:
                            for(Datum d : Datum.getAllDatumFromDnevniIzvestaj()){
                                dlm.addElement(d);
                            }
                        return dlm;
                        case 3:
                            for(Zaposleni d : Zaposleni.getAllZaposleniFromDnevniIzvestaj()){
                                dlm.addElement(d);
                            }
                        return dlm;
                        case 4:
                            for(DnevniIzvestaj d : DnevniIzvestaj.getAllDnevniIzvestaj()){
                                dlm.addElement(d);
                            }
                        return dlm;
                        default:
                        return dlm;  
                    } 
            case 3:
                switch (i){
                        
                        case 1:
                            for(Proizvod d : Proizvod.getAllProizvod()){
                                dlm.addElement(d);
                            }
                        return dlm;
                        case 2:
                            for(TipProizvoda d : TipProizvoda.getAllTipProizvodaFromProizvodi()){
                                dlm.addElement(d);
                            }
                        return dlm;
                        default:
                        return dlm;  
                    }
            case 4:
                    switch (i){
                        case 1:
                            for(Dobavljac d : Dobavljac.getAllDobavljac()){
                                dlm.addElement(d);
                            }
                        return dlm;
                        default:
                        return dlm;  
                    }
            case 5:
                    switch (i){
                        case 1:
                            for(TipProizvoda d : TipProizvoda.getAllTipProizvoda()){
                                dlm.addElement(d);
                            }
                        return dlm;
                        default:
                        return dlm;  
                    } 
            case 6:
                    switch (i){
                        
                        case 1:
                            for(Datum d : Datum.getAllDatumFromTroskovi()){
                                dlm.addElement(d);
                            }
                        return dlm;
                        case 2:
                            for(TipTroska d : TipTroska.getAllTipTroska()){
                                dlm.addElement(d);
                            }
                        return dlm;
                        case 3:
                            for(Datum d : Datum.getAllDatum()){
                                dlm.addElement(d);
                            }
                        return dlm;
                        default:
                        return dlm;  
                    }
            case 8:
                    switch (i){
                        
                        case 1:
                            for(Datum d : Datum.getAllDatum()){
                                dlm.addElement(d);
                            }
                        return dlm;
                        default:
                        return dlm;  
                    }
            case 9:
                    switch (i){
                        
                        case 1:
                            for(Datum d : Datum.getAllDatum()){
                                dlm.addElement(d);
                            }
                        return dlm;
                        default:
                        return dlm;  
                    }
            case 10:
                    switch (i){
                        
                        case 1:
                            Map mapa = Datum.getAllDays();
                            for(int j=0 ; j<mapa.size();j++){
                                dlm.addElement(mapa.get(j));
                            }
                        return dlm;
                        case 2:
                            Map mapa2 = Datum.getAllMonths();
                            for(int j=0 ; j<mapa2.size();j++){
                                dlm.addElement(mapa2.get(j));
                            }
                        return dlm;
                        case 3:
                            Map mapa3 = Datum.getAllYears();
                            for(int j=0 ; j<mapa3.size();j++){
                                dlm.addElement(mapa3.get(j));
                            }
                        return dlm;
                        default:
                        return dlm;  
                    }        
               
            default:
            return dlm;
    }
    }

//Popunjavanje podacima Tabelu o Dobavljacima sortiranim na osnovu ukupne vrednosti nabavke (Nalazi se u formi: DobavljacOut)    
    public static JTable setJTableDobavljaciPoVrednosti (JTable j) throws SQLException{
        List <String> lista = Dobavljac.getAllObjDobavljacSortedByValue();
        DefaultTableModel model = (DefaultTableModel) j.getModel();
        model.setColumnCount(5);
        String [] coulmnNames = new String [] {"Naziv: ","Pib: ","Adresa: ","Telefon: ","Ukupna vrednost nabavki: "};
        
        for(int q = 0; q<5;q++){
            j.getColumnModel().getColumn(q).setHeaderValue(coulmnNames [q]);
        }
        int brojRedova = model.getRowCount();
            if(brojRedova!=0){
                model.setRowCount(0);
            } 
         for (int i=0;i<lista.size();i++) {
              String [] row = lista.get(i).toString().split(",");
              model.addRow(row);  
         }
        return j;
   }
 
    /*Popunjavanje podacima Tabele o Trenutnom stanju start*/    
    public static JTable setJTableTrenutnoStanjeStart (JTable j,JLabel jlUlaz,JLabel jlIzlaz,JLabel jlUkupno) throws SQLException{
        List <String> lista = Ulaz.getLastUlaz();
        String izlaz [] = Izlaz.getLastIzlaz().split(",");
        DefaultTableModel model = (DefaultTableModel) j.getModel();
        model.setColumnCount(6);
        String [] coulmnNames = new String [] {"Ulaz: ","Nabavka: ","Trosak: ","Datum: ","Izlaz: ","Dnevni izvestaj: "};
        
        for(int q = 0; q<6;q++){
            j.getColumnModel().getColumn(q).setHeaderValue(coulmnNames [q]);
        }
        int brojRedova = model.getRowCount();
            if(brojRedova!=0){
                model.setRowCount(0);
            } 
        double a = Ulaz.getLastUlazValue();
        double b = Izlaz.getLastIzlazValue();
         
         for (int i=0;i<lista.size();i++) {
             String row[]=lista.get(i).split(",");
             
                if (i==0){
                String s1[] = row;
                    if(Integer.valueOf(s1[3])==Integer.valueOf(izlaz[2])){
                            
                          row= new String [] {s1[0],s1[1],s1[2],Datum.getDatum(Integer.valueOf(row[3])).toString(),izlaz[0],izlaz[1]}; 
                          model.addRow(row);
                          jlUlaz.setText(String.valueOf(a));
                          jlIzlaz.setText(String.valueOf(b));
                          jlUkupno.setText(String.valueOf(b-a));
                          continue;
                    }
                    if(Integer.valueOf(s1[3])<Integer.valueOf(izlaz[2])){
                        row= new String [] {"","","",Datum.getDatum(Integer.valueOf(izlaz[2])).toString(),izlaz[0],izlaz[1]}; 
                        model.addRow(row);
                        jlUlaz.setText("0");
                        jlIzlaz.setText(String.valueOf(b));
                        jlUkupno.setText(String.valueOf(b));
                        break;
                    }
                    if(Integer.valueOf(s1[3])>Integer.valueOf(izlaz[2])){
                        jlUlaz.setText(String.valueOf(a));
                        jlIzlaz.setText("0");
                        jlUkupno.setText(String.valueOf(a));
                    }
                } 
              row [3]=Datum.getDatum(Integer.valueOf(row[3])).toString();
              
              model.addRow(row);
              
         }
        return j;
   }
    
    /*Popunjavanje podacima Tabele o Trenutnom stanju na osnovu parametara*/    
   
    public static JTable setJTableTrenutnoStanje (JTable j,JLabel jlUlaz,JLabel jlIzlaz,JLabel jlUkupno,JToggleButton tb1,JToggleButton tb2,JToggleButton tb3,JList jList1,JList jList2,JList jList3,JOptionPane op) throws SQLException{
        int kombinacija = getSelectedFromListTS (tb1,tb2,tb3);
        List <String> lista = new ArrayList<>();
        List <String> lista2 = new ArrayList<>();
        double ulaz=0;
        double izlaz=0;
        int id [] = getSelectedFromJListTrenutnoStanje(jList1,jList2,jList3);
        switch(kombinacija){
            case 0:
              op.showMessageDialog(op.getParent(), "Niste odabrali kriterijume za pretragu. Molimo vas pokusajte ponovo!", "Informacija", JOptionPane.INFORMATION_MESSAGE);
            break;
            case 1:
                lista = Ulaz.getUlazByDay(id[0]);
                lista2 = Izlaz.getIzlazByDay(id[0]);
                ulaz=Ulaz.getUlazByDayValue(id[0]);
                izlaz= Izlaz.getIzlazByDayValue(id[0]);
                jlUlaz.setText(String.valueOf(ulaz ));
                jlIzlaz.setText(String.valueOf(izlaz));
                jlUkupno.setText(String.valueOf(izlaz-ulaz));
            break;
            case 2:
                lista = Ulaz.getUlazByMonth(id[1]);
                lista2 = Izlaz.getIzlazByMonth(id[1]);
                ulaz=Ulaz.getUlazByMonthValue(id[1]);
                izlaz= Izlaz.getIzlazByMonthValue(id[1]);
                jlUlaz.setText(String.valueOf(ulaz ));
                jlIzlaz.setText(String.valueOf(izlaz));
                jlUkupno.setText(String.valueOf(izlaz-ulaz));
            break;
            case 3:
                lista = Ulaz.getUlazByDayAndMonth(id[0], id[1]);
                lista2 = Izlaz.getIzlazByDayAndMonth(id[0], id[1]);
                ulaz=Ulaz.getUlazByDayAndMonthValue(id[0], id[1]);
                izlaz= Izlaz.getIzlazByDayAndMonthValue(id[0], id[1]);
                jlUlaz.setText(String.valueOf(ulaz ));
                jlIzlaz.setText(String.valueOf(izlaz));
                jlUkupno.setText(String.valueOf(izlaz-ulaz));
            break;
            case 4:
                lista = Ulaz.getUlazByYear(id[2]);
                lista2 = Izlaz.getIzlazByYear(id[2]);
                ulaz=Ulaz.getUlazByYearValue(id[2]);
                izlaz= Izlaz.getIzlazByYearValue(id[2]);
                jlUlaz.setText(String.valueOf(ulaz ));
                jlIzlaz.setText(String.valueOf(izlaz));
                jlUkupno.setText(String.valueOf(izlaz-ulaz));
            break;
            case 5:
                lista = Ulaz.getUlazByDayAndYear(id[0], id[2]);
                lista2 = Izlaz.getIzlazByDayAndYear(id[0], id[2]);
                ulaz=Ulaz.getUlazByDayAndYearValue(id[0], id[2]);
                izlaz= Izlaz.getIzlazByDayAndYearValue(id[0], id[2]);
                jlUlaz.setText(String.valueOf(ulaz ));
                jlIzlaz.setText(String.valueOf(izlaz));
                jlUkupno.setText(String.valueOf(izlaz-ulaz));
            break;
            case 6:
                lista = Ulaz.getUlazByMonthAndYear(id[1], id[2]);
                lista2 = Izlaz.getIzlazByMonthAndYear(id[1], id[2]);
                ulaz=Ulaz.getUlazByMonthAndYearValue(id[1], id[2]);
                izlaz= Izlaz.getIzlazByMonthAndYearValue(id[1], id[2]);
                jlUlaz.setText(String.valueOf(ulaz ));
                jlIzlaz.setText(String.valueOf(izlaz));
                jlUkupno.setText(String.valueOf(izlaz-ulaz));
            break;
            case 7:
                lista = Ulaz.getUlazByDayAndMonthAndYear(id[0], id[1], id[2]);
                lista2 = Izlaz.getIzlazByDayAndMonthAndYear(id[0], id[1], id[2]);
                ulaz=Ulaz.getUlazByDayAndMonthAndYearValue(id[0], id[1], id[2]);
                izlaz= Izlaz.getIzlazByDayAndMonthAndYearValue(id[0], id[1], id[2]);
                jlUlaz.setText(String.valueOf(ulaz ));
                jlIzlaz.setText(String.valueOf(izlaz));
                jlUkupno.setText(String.valueOf(izlaz-ulaz));
            break;
        }
        
        DefaultTableModel model = (DefaultTableModel) j.getModel();
        model.setColumnCount(3);
        String [] coulmnNames = new String [] {"Ulaz: ","Datum: ","Izlaz: "};
        
        for(int q = 0; q<3;q++){
            j.getColumnModel().getColumn(q).setHeaderValue(coulmnNames [q]);
        }
        int brojRedova = model.getRowCount();
            if(brojRedova!=0){
                model.setRowCount(0);
            } 
        
         
        if(!lista.isEmpty() && lista.size()>=lista2.size()){
            for (int i=0;i<lista.size();i++) {
               String row[]=lista.get(i).split(",");

                   if (lista.size()>=lista2.size()&& !lista2.isEmpty()){
                       if(i<lista2.size()){
                             String row2 [] = lista2.get(i).split(",");  
                             String [] row3 = new String [] {row [0],Datum.getDatum(Integer.valueOf(row[1])).toString(),row2[0]}; 
                             model.addRow(row3);
                             continue;
                       }
                   } 
               row [1]=Datum.getDatum(Integer.valueOf(row[1])).toString();
               model.addRow(row);
            }
        }else{
        if(!lista2.isEmpty() && lista2.size()>lista.size()){
            for (int i=0;i<lista2.size();i++) {
                String row[]=lista2.get(i).split(",");

                    if (lista2.size()>=lista.size()&& !lista.isEmpty()){
                        if(i<lista.size()){
                              String row2 [] = lista.get(i).split(",");  
                              String [] row3 = new String [] {row2 [0],Datum.getDatum(Integer.valueOf(row2[1])).toString(),row[0]}; 
                              model.addRow(row3);
                              continue;
                        }
                    } 
                String [] row3 = new String [] {"",Datum.getDatum(Integer.valueOf(row[1])).toString(),row[0]};
                
                model.addRow(row3);
            }
        }
        }
        return j;
   }
    
// Popunjavanje Tabele podacima sortiranim na osnovu Dobavljaca/Zaposlenog/Datuma sa vise detalja (Nalazi se u formi: NabavkaPForm)
    /* int id1 je getSelectedFromJRButtonGroup, a id2 je getSelectedFromJRButton, 
        a int idForme je id forme u kojoj pozivam ovaj metod (Za NabavkaOut je 1 a za DnevniIzvestajOUT je 2, za ProizvodiOut je 3,za DobavljacOut je 4
    ,za TipoviProizvodaOut je 5, za ZaposleniOut je 7)*/
   
    public static JTable setJTableNabavkaMD (JTable j,int id1,int id2,int idForme) throws SQLException{
        
        List <String> lista = null;
        int coulmnCount;
        String [] coulmnNames;
        switch (idForme){
            case 1:
                coulmnCount = 7;
                coulmnNames = new String [] {"Broj nabavke: ","Zaposleni: ","Datum: ","Dobavljac: ","Proizvod: ","Kolicina: ","Cena: "};
                switch (id1){
                    case 1:
                        lista = Nabavka.getAllObjNAPbyDobavljac(id2);
                    break;
                    case 2:
                        lista = Nabavka.getAllObjNAPbyDatum(id2);
                    break;
                    case 3:
                        lista = Nabavka.getAllObjNAPbyZaposleni(id2);
                    break;
                    case 4:
                        lista = Nabavka.getAllObjNAPbyNabavka(id2);
                    break;
                }
            break;
            case 2:
                coulmnCount = 5;
                coulmnNames = new String [] {"Broj dnevnog izvestaja: ","Datum: ","Zaposleni: ","Proizvod: ","Iznos: "};
                switch (id1){
                    case 2:
                        lista = DnevniIzvestaj.getAllObjDIPbyDatum(id2);
                    break;    
                    case 3:
                        lista = DnevniIzvestaj.getAllObjDIPbyZaposleni(id2);
                    break;
                    case 4:
                        lista = DnevniIzvestaj.getAllObjDIPbyDnevniIzvestaj(id2);
                    break;
                }
            break;
            case 3:
                coulmnCount =5;
                coulmnNames = new String [] {"Naziv: ","Cena: ","Gramaza: ","Kolicina: ","Tip proizvoda: "};
                 switch (id1){
                    case 1:
                        lista = Proizvod.getAllObjPProizvod(id2);
                    break;    
                    case 2:
                        lista = Proizvod.getAllObjTipProizvodaForProizvodi(id2);
                    break;
                }
            break;
            case 4:
                coulmnCount =5;
                coulmnNames = new String [] {"Naziv: ","PIB: ","Adresa: ","Telefon: ","Ukupna vrednost nabavki: "};
                 switch (id1){
                    case 1:
                        lista = Dobavljac.getAllObjDobavljacByDobavljac(id2);
                    break;    
                }
            break;
            case 5:
                coulmnCount =2;
                coulmnNames = new String [] {"Naziv: ","Opis: "};
                 switch (id1){
                    case 1:
                        lista = TipProizvoda.getAllObjTipProizvoda(id2);
                    break;    
                }
            break;
            case 6:
                coulmnCount =3;
                coulmnNames = new String [] {"Naziv: ","Datum: ","Iznos: "};
                 switch (id1){
                    case 1:
                        lista = Trosak.getAllObjTroskoviForDatum(id2);
                    break;  
                    case 2:
                        lista = Trosak.getAllObjTroskoviForTipTroska(id2);
                    break; 
                }
            break;
            case 7:
                coulmnCount =4;
                coulmnNames = new String [] {"Ime: ","Adresa: ","Telefon: ","Lozinka: "};
                 switch (id1){
                    case 1:
                        lista = Zaposleni.getAllObjRadniciZaTabelu();
                    break;  
                    case 2:
                        lista = Zaposleni.getAllObjMenadzeriZaTabelu();
                    break; 
                    case 3:
                        lista = Zaposleni.getAllObjStalnoZapZaTabelu();
                    break;  
                    case 4:
                        lista = Zaposleni.getAllObjNaUgovorZaTabelu();
                    break; 
                }
            break;
            
            default:
             coulmnCount = 0;
             coulmnNames = new String [] {""}; 
            break;
        }
        
        DefaultTableModel model = (DefaultTableModel) j.getModel();
        model.setColumnCount(coulmnCount);
        
        
        for(int q = 0; q<coulmnCount;q++){
            j.getColumnModel().getColumn(q).setHeaderValue(coulmnNames [q]);
        }
        int brojRedova = model.getRowCount();
            if(brojRedova!=0){
                model.setRowCount(0);
            } 
            
        for (int i=0;i<lista.size();i++) {
              String [] row = lista.get(i).toString().split(",");
              model.addRow(row);  
        }
        return j;
   }
    
    
    // Popunjavanje Tabele podacima o Nabavci sa manje detalja (Nalazi se u formi: NabavkaPForm)! Aktivira se na startu
    /*int id je =1 kada se koristi za NabavkaOut, =2 za DnevniIzvestaji Out, =3 za ProizvodiOut, =4 za DobavljacOut,=5 za TipoviProizvodaOut
    ,=6 za TroskoviOut, =7 za zaposleniOut*/
    
    public static JTable setJTableStartLD (JTable j,int id) throws SQLException{
        
        List <String> lista =null;
        DefaultTableModel model = (DefaultTableModel) j.getModel();
        String [] coulmnNames;
        int columnCount;
        switch(id){
            case 1:
                columnCount = 5;
                model.setColumnCount(columnCount);
                coulmnNames = new String []{"Broj nabavke: ","Zaposleni: ","Datum: ","Dobavljac: ","Cena: "};
                lista = Nabavka.firstTable();
            break;
            case 2:
                columnCount = 4;
                model.setColumnCount(columnCount);
                coulmnNames = new String []{"Broj dnevnog izvestaja: ","Datum:  ","Zaposleni: ","Iznos: "};
                lista = DnevniIzvestaj.firstTable();
            break;
            case 3:
                columnCount = 5;
                model.setColumnCount(columnCount);
                coulmnNames = new String [] {"Naziv: ","Cena: ","Gramaza: ","Kolicina: ","Tip proizvoda: "};
                lista = Proizvod.getAllObjProizvod();
            break;
            case 4:
                columnCount = 5;
                model.setColumnCount(columnCount);
                coulmnNames = new String [] {"Naziv: ","Pib: ","Adresa: ","Telefon: ","Ukupna vrednost nabavki: "};
                lista = Dobavljac.getAllObjDobavljac();
            break;
            case 5:
                columnCount = 2;
                model.setColumnCount(columnCount);
                coulmnNames = new String [] {"Naziv: ","Opis: "};
                lista = TipProizvoda.getAllObjTipProizvoda();
            break;
             case 6:
                columnCount = 3;
                model.setColumnCount(columnCount);
                coulmnNames = new String [] {"Naziv: ","Datum: ","Iznos: "};
                lista = Trosak.getAllObjTroskovi();
            break;
             case 7:
                columnCount = 4;
                model.setColumnCount(columnCount);
                coulmnNames = new String [] {"Ime: ","Adresa: ","Telefon: ","Lozinka: "};
                lista = Zaposleni.getAllObjZaposlenizaTabelu ();
            break;
            default:
            columnCount = 0;
            coulmnNames = new String []{""};
            break;
        }
        for(int q = 0; q<columnCount;q++){
            j.getColumnModel().getColumn(q).setHeaderValue(coulmnNames [q]);
        }
        
        int brojRedova = model.getRowCount();
        
            if(brojRedova!=0){
                model.setRowCount(0);
            }
            
        for (int i=0;i<lista.size();i++) {
            String [] row = lista.get(i).toString().split(",");
            model.addRow(row);
        }
        return j;
   }
    
   
// Popunjavanje Tabele podacima sortiranim na osnovu Dobavljaca/Zaposlenog/Datuma sa manje detalja (Nalazi se u formi: NabavkaPForm)
    /*id1 je odabir JRBGrupe id2 je odabir konkretne stavke iz liste, int idForme  = 1 za NabavkaOut  a =2 za DnevniIzvestajOUT*/

    public static JTable setJTableLD (JTable j,int id1,int id2, int idForme) throws SQLException{
       
        List <String> lista = null;
        DefaultTableModel model = (DefaultTableModel) j.getModel();
        int columnCount;
        String [] coulmnNames ;
        switch (idForme){
            case 1:
                columnCount = 5;
                model.setColumnCount(columnCount);
                coulmnNames = new String []{"Broj nabavke: ","Zaposleni: ","Datum: ","Dobavljac: ","Cena: "};
                switch (id1){
                    case 1:
                        lista = Nabavka.getAllObjNAPbyDobavljacLD(id2);
                    break;
                    case 2:
                        lista = Nabavka.getAllObjNAPbyDatumLD(id2);
                    break;
                    case 3:
                        lista = Nabavka.getAllObjNAPbyZaposleniLD(id2);
                    break;
                    case 4:
                        lista = Nabavka.getAllObjNAPbyNabavkaLD(id2);
                    break;
                }
            break;
            case 2:
                columnCount = 4;
                model.setColumnCount(columnCount);
                coulmnNames = new String []{"Broj dnevnog izvestaja : ","Datum: ","Zaposleni: ","Iznos: "};
                switch (id1){
                    case 2:
                        lista = DnevniIzvestaj.getAllObjDIPbyDatumLD(id2);
                    break;
                    case 3:
                        lista = DnevniIzvestaj.getAllObjDIPbyZaposleniLD(id2);
                    break;
                    case 4:
                        lista = DnevniIzvestaj.getAllObjDIPbyDnevniIzvestajLD(id2);
                    break;
                }
            break;
            default:
                columnCount = 0;
                coulmnNames = new String []{""};
            break;
        }
        for(int q = 0; q<columnCount;q++){
            j.getColumnModel().getColumn(q).setHeaderValue(coulmnNames [q]);
        }
        
        int brojRedova = model.getRowCount();
        
            if(brojRedova!=0){
                model.setRowCount(0);
            }        
        for (int i=0;i<lista.size();i++) {
            String [] row = lista.get(i).toString().split(",");
            model.addRow(row);  
        }
        return j;
   }
    
  //popunavanje tabele u formi NabavkaUpdate 
   
    public static JTable setJTableProizvodiNabavkaUpdate (JTable j,int id) throws SQLException{
           j.getColumnModel().getColumn(0).setHeaderValue("Proizvodi");
           j.getColumnModel().getColumn(1).setHeaderValue("Kolicina");
           j.getColumnModel().getColumn(2).setHeaderValue("Cena");
           DefaultTableModel model = (DefaultTableModel) j.getModel();
           List <Proizvod> lista = Proizvod.getAllProizvod();
           List <String> lista2 = Nabavka.getAllObjNAPbyNabavka(id);
           for (int i=0;i<lista.size();i++) {
               String [] row2=null;
                for (int k=0;k<lista2.size();k++){
                    String [] row = lista2.get(k).toString().split(",");  
                    if (lista.get(i).getNaziv().equals(row[4])){
                     row2 = new String []{lista.get(i).getNaziv(),row [5],row[6]};
                     break;
                    }else{
                     row2= new String []{lista.get(i).getNaziv()};   
                    }
                }
                
                
                model.addRow(row2);  
            }
            return j;
       } 
  
    //popunavanje tabele u formi DnevniIzvestajiUpdate 
    public static JTable setJTableProizvodiDnevniIzvestajUpdate (JTable j,int id) throws SQLException{
           j.getColumnModel().getColumn(0).setHeaderValue("Proizvodi: ");
           j.getColumnModel().getColumn(1).setHeaderValue("Iznos: ");
           
           DefaultTableModel model = (DefaultTableModel) j.getModel();
           List <Proizvod> lista = Proizvod.getAllProizvod();
           List <String> lista2 = DnevniIzvestaj.getAllObjDIPbyDnevniIzvestaj(id);
           for (int i=0;i<lista.size();i++) {
               String [] row2=null;
                for (int k=0;k<lista2.size();k++){
                    String [] row = lista2.get(k).toString().split(",");
                    String [] row1 = new String []{row [0],row [1],row [2],row [3],row [4]};  
                    if (lista.get(i).getNaziv().equals(row[3])){
                     row2 = new String []{lista.get(i).getNaziv(),row [4]};
                     break;
                    }else{
                     row2= new String []{lista.get(i).getNaziv()};   
                    }
                }
                
                
                model.addRow(row2);  
            }
            return j;
       } 
/*Popunavanje podacima --kraj*/   
    
    
    
    
/*Uzimanje podataka iz formi (Tabela...) --pocetak*/   
  

//Dobavljanje id-a pri selektovanju odredjenog reda u tabeli (Nalazi se u formi NabavkaOut)    
    public static int getSelectedFromTable (JTable jt){
        int odabraniRed = jt.getSelectedRow();
        int vrednost = Integer.parseInt((String)jt.getModel().getValueAt(odabraniRed, 0));
        return vrednost;
    }
    
    /*Dobavljanje id-a pri selektovanju odredjenog reda u tabeli (Nalazi se u formi ProizvodOut); idForme =3 za ProizvodOut, idForme =4 zaDobavljaciOut  
    ,idForme = 5 za TipProizvodaOut, idForme=7 za ZaposleniOut*/ 
    //koristi se
    public static int getSelectedFromTable2 (JTable jt,int idForme) throws SQLException{
        int odabraniRed = jt.getSelectedRow();
        int id=0;
        switch(idForme){
            case 3:
                String naziv = (String)jt.getModel().getValueAt(odabraniRed, 0);
                double gramaza = Double.parseDouble((String)jt.getModel().getValueAt(odabraniRed, 2));
                Proizvod p = Proizvod.getProizvodFromJlist(naziv, gramaza);
                id=p.getId();
            break;
            case 4:
                String naziv1 = (String)jt.getModel().getValueAt(odabraniRed, 0);
                String pib = (String)jt.getModel().getValueAt(odabraniRed, 1);
                Dobavljac d= Dobavljac.getDobavljacFromTable(naziv1, pib);
                id=d.getId();
            break;
            case 5:
                String naziv2 = (String)jt.getModel().getValueAt(odabraniRed, 0);
                id=TipProizvoda.getTipProizvoda(naziv2);
            break;
            case 6:
                List <String> lista = Trosak.getAllObjTroskovi2();
                String s1 = (String)jt.getValueAt(odabraniRed, 0);
                String s2 = (String)jt.getValueAt(odabraniRed, 1);
                String s3 = (String)jt.getValueAt(odabraniRed, 2);
                for (int i=0;i<lista.size();i++){
                    String [] s=lista.get(i).split(",");
                    if(s1.equals(s[1]) && s2.equals(s[2]) && s3.equals(s[3])){
                        id=Integer.parseInt(s[0]);
                        break;
                    }
                }
            break;
            case 7:
                List <String> lista2 = Zaposleni.getAllObjZaposleni();
                String ime = (String)jt.getValueAt(odabraniRed, 0);
                String adresa = (String)jt.getValueAt(odabraniRed, 1);
                String lozinka = (String)jt.getValueAt(odabraniRed, 3);
                for (int i=0;i<lista2.size();i++){
                    String [] s=lista2.get(i).split(",");
                    if(ime.equals(s[1]) && adresa.equals(s[2]) && lozinka.equals(s[6])){
                        id=Integer.parseInt(s[0]);
                        break;
                    }
                }
            break;
        }
        
        return id;
    }
    
   
    
//Dobavljanje podataka o izabranom konkretnom id-u iz JListe (Nalazi se u formi NabavkaUpdate)
    // id1 =6 za TroskoviUpdate

public static int getSelectedFromJList (int id1,JList j1, JList j2) throws SQLException{
    int id;
    switch (id1){
                case 1:
                    List <Dobavljac> lista = Dobavljac.getAllDobavljac();
                    int index = j1.getSelectedIndex();
                    Dobavljac d = null;
                        if(index != -1){
                            d = lista.get(index);
                        }
                    id=d.getId();
                return id;
                case 2:
                    List <Datum> lista2 = Datum.getAllDatumFromNabavka();
                    int index2 = j2.getSelectedIndex();
                    Datum datum = null;
                        if(index2!=-1){
                            datum = lista2.get(index2);
                        }
                    id = datum.getId();
                return id;
                case 6:
                    List <Datum> lista3 = Datum.getAllDatum();
                    int index3 = j1.getSelectedIndex();
                    Datum datum1 = null;
                        if(index3!=-1){
                            datum1 = lista3.get(index3);
                        }
                    id = datum1.getId();
                return id;
    }  
    return 0;
}    
    
//Dobavljanje podataka o izabranoj JBG i konkretnom id-u iz liste ( Nalazi se u formi NabavkaOut)
// int idForme=1 je za nabavkaOut / int idForme=2 je za DnevniIzvestajiOUT/ idForme=3 za ProizvodOut, idForme=4 za DobavljacOut

    public static int getSelectedFromJRButton (ButtonGroup b,JList j1,JList j3,JList j2, JList j4, JOptionPane op,int idForme) throws SQLException{
        int id=0;
        
        switch (idForme){
            case 1:
                    switch (getSelectedFromJRButtonGroup(b,op)){
                        case 1:
                            List <Dobavljac> lista = Dobavljac.getAllDobavljacFromNabavkeList();
                            int index = j1.getSelectedIndex();
                            Dobavljac d = null;
                                if(index != -1){
                                    d = lista.get(index);
                                }
                            id=d.getId();
                        return id;
                        case 2:
                            List <Datum> lista2 = Datum.getAllDatumFromNabavka();
                            int index2 = j2.getSelectedIndex();
                            Datum datum = null;
                                if(index2!=-1){
                                    datum = lista2.get(index2);
                                }
                            id = datum.getId();
                        return id;
                        case 3:
                            List <Zaposleni> lista3 = Zaposleni.getAllZaposleniFromNabavka();
                            int index3 = j3.getSelectedIndex();
                            Zaposleni z = null;
                                if(index3!=-1){
                                    z = lista3.get(index3);
                                }
                            id = z.getId();
                        return id;
                        case 4:
                            List <Nabavka> lista4 = Nabavka.getAllNabavkaFromNabavkeProizvodi();
                            int index4 = j4.getSelectedIndex();
                            Nabavka n = null;
                                if(index4!=-1){
                                    n = lista4.get(index4);
                                }
                            id = n.getId();
                        return id;
                    }
            break;
            case 2:
                switch (getSelectedFromJRButtonGroup(b,op)){
                    case 2:
                        List <Datum> lista2 = Datum.getAllDatumFromDnevniIzvestaj();
                        int index2 = j2.getSelectedIndex();
                        Datum datum = null;
                            if(index2!=-1){
                                datum = lista2.get(index2);
                            }
                        id = datum.getId();
                    return id;
                    case 3:
                        List <Zaposleni> lista3 = Zaposleni.getAllZaposleniFromDnevniIzvestaj();
                        int index3 = j3.getSelectedIndex();
                        Zaposleni z = null;
                            if(index3!=-1){
                                z = lista3.get(index3);
                            }
                        id = z.getId();
                    return id;
                    case 4:
                        List <DnevniIzvestaj> lista4 = DnevniIzvestaj.getAllDnevniIzvestaj();
                        int index4 = j4.getSelectedIndex();
                        DnevniIzvestaj di = null;
                            if(index4!=-1){
                                di = lista4.get(index4);
                            }
                        id = di.getId();
                    return id;
                }
            break;
            case 3:
                switch (getSelectedFromJRButtonGroup(b,op)){
                    case 1:
                        List <Proizvod> lista1 = Proizvod.getAllProizvod();
                        int index1 = j1.getSelectedIndex();
                        Proizvod proizvod = null;
                            if(index1!=-1){
                                proizvod = lista1.get(index1);
                            }
                        id = proizvod.getId();
                    return id;
                    case 2:
                        List <TipProizvoda> lista2 = TipProizvoda.getAllTipProizvodaFromProizvodi();
                        int index2 = j2.getSelectedIndex();
                        TipProizvoda tip = null;
                            if(index2!=-1){
                                tip = lista2.get(index2);
                            }
                        id = tip.getId();
                    return id;
                }
            break;
            case 4:
                switch (getSelectedFromJRButtonGroup(b,op)){
                    case 1:
                        List <Dobavljac> lista1 = Dobavljac.getAllDobavljac();
                        int index1 = j1.getSelectedIndex();
                        Dobavljac dobavljac = null;
                            if(index1!=-1){
                                dobavljac = lista1.get(index1);
                            }
                        id = dobavljac.getId();
                    return id;
                }
            break;
            case 5:
                switch (getSelectedFromJRButtonGroup(b,op)){
                    case 1:
                        List <TipProizvoda> lista = TipProizvoda.getAllTipProizvoda();
                        int index1 = j1.getSelectedIndex();
                        TipProizvoda tip = null;
                            if(index1!=-1){
                                tip = lista.get(index1);
                            }
                        id = tip.getId();
                    return id;
                }
            break;
            case 6:
                switch (getSelectedFromJRButtonGroup(b,op)){
                    case 1:
                        List <Datum> lista = Datum.getAllDatumFromTroskovi();
                        int index1 = j1.getSelectedIndex();
                        Datum d= null;
                            if(index1!=-1){
                               d = lista.get(index1);
                            }
                        id = d.getId();
                    return id;
                    case 2:
                        List <TipTroska> lista2= TipTroska.getAllTipTroska();
                        int index2 = j2.getSelectedIndex();
                        TipTroska t= null;
                            if(index2!=-1){
                               t= lista2.get(index2);
                            }
                        id = t.getId();
                    return id;
                }
            break;
    }
        return id;
    }
    
   
    /*Dobavlja selektovanu vrednost iz Lista iz TrenutnoStanje*/
    public static int [] getSelectedFromJListTrenutnoStanje (JList j1, JList j2, JList j3) throws SQLException{
   
        int row [] = new int [3];
        Map mapa = Datum.getAllDays();
            int index = j1.getSelectedIndex();
            if(index != -1){
            int a = (Integer)mapa.get(index);
            row [0] =a;
                
            }else{
            row[0]=0;
            }
         Map mapa2 = Datum.getAllMonths();
            int index2 = j2.getSelectedIndex();
            if(index2 != -1){
            int a = (Integer)mapa2.get(index2);
            row [1] =a;
            }else{
            row[1]=0;
            }
        Map mapa3 = Datum.getAllYears();
            int index3 = j3.getSelectedIndex();
            if(index3 != -1){
            int a = (Integer)mapa3.get(index3);
            row [2] =a;
            }else{
            row[2]=0;
            }
        return row;
}    
   
    //Dobavljanje podatka o izabranom JRButton-u iz ButtonGroup 
    public static int getSelectedFromJRButtonGroup (ButtonGroup b, JOptionPane op){
        int id=0;
            if(b.getSelection().getActionCommand() != null){
               id = Integer.valueOf(b.getSelection().getActionCommand());
            }
        return id;
    }
  
    /*Dobavljanje podataka o selektovanim JToggleButton*/
    public static int getSelectedFromListTS (JToggleButton tb1,JToggleButton tb2,JToggleButton tb3){
        int a=tb1.isSelected()?1:0;
        int b=tb2.isSelected()?2:0;
        int c=tb3.isSelected()?4:0;
        
        int a1= a^b;
        int d = a1^c;
        
        return d;
    }
    
    
/*Uzimanje podataka iz formi (Tabela...) --kraj*/     
  
    
    
    
/*Loginka izracunavanja i sortiranja podataka --pocetak*/
  

    /*id1 je odabir JRBGrupe id2 je odabir konkretne stavke iz liste, int idForme  = 1 za NabavkaOut  a =2 za DnevniIzvestajOUT*/
    public static String ukupnaVrednost (int id1,int id2,int idForme) throws SQLException{
        List <String> lista=null;
        switch (idForme){
                case 1:
                    switch (id1){
                        case 1:
                            return Nabavka.ukupnaVrednostZaDobavljaca(id2);
                        case 2:
                            return Nabavka.ukupnaVrednostZaDatum(id2);
                        case 3:
                            return Nabavka.ukupnaVrednostZaZaposlenog(id2);
                        case 4:
                            return Nabavka.ukupnaVrednostZaNabavku(id2);
                        }
                break; 
                case 2:
                    switch (id1){
                        case 2:
                            return DnevniIzvestaj.ukupnaVrednostZaDatum(id2);
                        case 3:
                            return DnevniIzvestaj.ukupnaVrednostZaZaposlenog(id2);
                        case 4:
                            return DnevniIzvestaj.ukupnaVrednostZaDnevniIzvestaj(id2);
                        }
                break;
                case 6:
                    switch (id1){
                        case 1:
                            return Trosak.ukupnaVrednostTroskovaForDatum(id2);
                        case 2:
                            return Trosak.ukupnaVrednostTroskovaForTipTroska(id2);
                        }
                break;
            }
        return "";
    }        

  
//racuna poziciju u JListi za Dobavljace (nalazi se u NabavkaOut)
    public static int pozicijaUJListi (int id) throws SQLException{
        List <Dobavljac>lista = Dobavljac.getAllDobavljac();
        int b =0;
        for (int i=0;i<lista.size();i++){
            if(lista.get(i).getId() == id){
                b = i;
                return b;
            }
        }
        return b;
    }

    //racuna poziciju u JListi za Datum (nalazi se u NabavkaOut)
    /*int idForme  = 1 za NabavkaOut  a =2 za DnevniIzvestajOUT a idForme = 8 za NabavkaUpdate i DnevniIzvestajUpdate*/
    public static int pozicijaUJListiDatum (int id,int idForme) throws SQLException{
        List <Datum>lista;
        switch (idForme){
            case 1:
                lista = Datum.getAllDatumFromNabavka();
            break;
            case 2:
                lista = Datum.getAllDatumFromDnevniIzvestaj();
            break;
            case 6:
                lista = Datum.getAllDatum();
            break;
            case 8:
                lista = Datum.getAllDatum();
            break;
            default:
                lista = null;
            break;
        }
        int b =0;
        for (int i=0;i<lista.size();i++){
            if(lista.get(i).getId() == id){
                b = i;
                return b;
            }
        }
        return b;
    }
    
    //racuna poziciju u JListi za TipProizvoda(nalazi se u ProizvodUpdate)

    public static int pozicijaUJListiTipProizvoda (int id) throws SQLException{
        List <TipProizvoda> lista = TipProizvoda.getAllTipProizvodaFromProizvodi();
        int b =0;
        for (int i=0;i<lista.size();i++){
            if(lista.get(i).getId() == id){
                b = i;
                return b;
            }
        }
        return b;
    }

    //svicovanje izmedju dva radioB 
    public static void izborIzmedju2RB(JRadioButton jr1,JRadioButton jr2, int id){
        switch (id){
            case 1:
                jr1.setSelected(true);
                break;
            case 2:
                jr2.setSelected(true);
                break;
        }
    }
    
/*Logika izracunavanja i sortiranja podataka --kraj*/
    
    
/*Update --pocetak*/


// update  nabavke u NabavkaUpdate   
   public static void updateNabavke (int id,int zaposleni,JList j1,JList j2,ButtonGroup b,JTable table,int idKolicina, int idCena,JOptionPane op) throws SQLException{
       Nabavka nabavka = Nabavka.getNabavka(id);
       nabavka.setZaposleni(Zaposleni.getZaposleni(zaposleni));
       nabavka.setDatum(Controller.getDatumFromList(j1,3));
       nabavka.setDobavljac(Controller.getDobavljacFromList (j2)) ;
       nabavka.setTipTroska(Controller.getTipTroskaFromJRButton(b));
       
       nabavka.updateNabavka();
       DBConnect db = DBConnect.getInstance();
       db.conn.setAutoCommit(false);
       
       boolean flag = getJTableProizvodiNabavkaUpdate(table, idKolicina, idCena, nabavka.getId(),op);
       if(flag){
           
           db.conn.commit();
           op.showMessageDialog(op.getParent(),"Uspesno ste izmenili nabavku pod rednim brojem: " + nabavka.getId(),"Update",JOptionPane.INFORMATION_MESSAGE);
       }else{
           op.showMessageDialog(op.getParent(),"Izmena se nije izvrsila. Molimo vas pokusajte ponovo! ","Update",JOptionPane.INFORMATION_MESSAGE);
           db.conn.rollback();
       }
       
       db.conn.setAutoCommit(true);
   } 

   // update  dnevnog izvestaja u DnevniIzvestajUpdate   
   public static void updateDnevniIzvestaj(int id,int zaposleni,JList j1,JTable table, int idIznos,JOptionPane op) throws SQLException{
       DnevniIzvestaj di = DnevniIzvestaj.getDnevniIzvestaj(id);
       di.setZaposleni(Zaposleni.getZaposleni(zaposleni));
       di.setDatum(Controller.getDatumFromList(j1,3));
       
       
       di.updateDnevniIzvestaj();
       DBConnect db = DBConnect.getInstance();
       db.conn.setAutoCommit(false);
       
       boolean flag = getJTableProizvodiDnevniIzvestajUpdate (table, idIznos, di.getId(),op);
       if(flag){
           
           db.conn.commit();
           
           op.showMessageDialog(op.getParent(),"Uspesno ste izmenili nabavku pod rednim brojem: " + di.getId(),"Update",JOptionPane.INFORMATION_MESSAGE);
       }else{
           op.showMessageDialog(op.getParent(),"Izmena se nije izvrsila. Molimo vas pokusajte ponovo! ","Update",JOptionPane.INFORMATION_MESSAGE);
           db.conn.rollback();
       }
       
       db.conn.setAutoCommit(true);
   } 

   
//Uzimanje podataka iz tabele iz forme NabavkaUpdate (ima mogucnost dodavanja novog proizvoda kao i "brisanja")
        public static boolean getJTableProizvodiNabavkaUpdate (JTable j, int idKolicina,int idCena,int idNabavke,JOptionPane op) throws SQLException{
            List <Proizvod> listaProizvoda = Proizvod.getAllProizvod();
            Map kolicina = getJTableValueOfColumn(j, idKolicina);
            Map cena = getJTableValueOfColumn(j, idCena);
            List <NabavkaProizvod> listaProizvodaZaNabavku = NabavkaProizvod.getAllProizvodforNabavka(idNabavke);
            List <NabavkaProizvod> updateLista = new ArrayList <NabavkaProizvod>();
            int k=1;
            int b=0;
            boolean flag = false;
                
                for(int i=0;i<listaProizvoda.size();i++){
                    Proizvod p = listaProizvoda.get(i);
                    if(p!=null){
                    NabavkaProizvod np = new NabavkaProizvod(idNabavke,p.getId());

                    if(kolicina.get(k) != null && cena.get(k) != null){
                    Integer kolicinaInt = Integer.parseInt((String)kolicina.get(k)) ;
                    String kolicinaString = kolicinaInt.toString();
                    Double cenaDouble = Double.parseDouble((String)cena.get(k));
                    String cenaString = cenaDouble.toString();
                      if(intCheck(kolicinaString)==1){
                       np.setKolicina(kolicinaInt);
                       b++;
                          System.out.println("desilo se");
                    }
                      if(doubleCheck(cenaString)==1){
                       np.setCena(cenaDouble);
                    }
                    updateLista.add(np);
                    flag = true;
                    }
                    
                    }
                    k++;
                }
                
                for(int l = 0;l<updateLista.size();l++){
                    int update = updateLista.get(l).getProizvod().getId();
                    int counter =0;
                    for(int l1=0;l1<listaProizvodaZaNabavku.size();l1++){
                        int old = listaProizvodaZaNabavku.get(l1).getProizvod().getId();
                        if(old == update ){
                            counter=1;
                            NabavkaProizvod np = updateLista.get(l);
                            np.updateNabavkaProizvod();
                        }
                    }
                    if(counter == 0){
                           NabavkaProizvod np = new NabavkaProizvod(idNabavke, update);
                            np.setKolicina(updateLista.get(l).getKolicina());
                            np.setCena(updateLista.get(l).getCena());
                            np.saveNabavkaProizvod2();
                        }
                }
                if (b==0){
                 
                op.showMessageDialog (op.getParent(),"Niste uneli podatke u tabelu. Molimo vas unesite podatke i pokusajte ponovo!","Tabela",JOptionPane.INFORMATION_MESSAGE); 
                }    
                 return flag;
        }
        
   
//Uzimanje podataka iz tabele iz forme DnevniIZvestajUpdate (ima mogucnost dodavanja novog proizvoda kao i "brisanja")
        public static boolean getJTableProizvodiDnevniIzvestajUpdate (JTable j,int idIznos,int idDnevnogIzvestaja,JOptionPane op) throws SQLException{
            List <Proizvod> listaProizvoda = Proizvod.getAllProizvod();
            Map iznos = getJTableValueOfColumn(j, idIznos);
            List <DnevniIzvProizvod> listaProizvodaZaDnevniIzvestaj = DnevniIzvProizvod.getAllProizvodforDnevniIzvestaj(idDnevnogIzvestaja);
            List <DnevniIzvProizvod> updateLista = new ArrayList <DnevniIzvProizvod>();
            int k=1;
            int b=0;
            boolean flag = false;
                
                for(int i=0;i<listaProizvoda.size();i++){
                    Proizvod p = listaProizvoda.get(i);
                    if(p!= null){
                    DnevniIzvProizvod dip = new DnevniIzvProizvod(idDnevnogIzvestaja, p.getId());


                    if(iznos.get(k) != null){
                    Double iznosDouble = Double.parseDouble((String)iznos.get(k));
                    String iznosString = iznosDouble.toString();
                      if(doubleCheck(iznosString)==1){
                       dip.setIznos(iznosDouble);
                        b++;
                    }
                    updateLista.add(dip);
                    flag = true;
                    }
                    
                    }
                    k++;
                }
                
                for(int l = 0;l<updateLista.size();l++){
                    int update = updateLista.get(l).getProizvod().getId();
                    int counter =0;
                    for(int l1=0;l1<listaProizvodaZaDnevniIzvestaj.size();l1++){
                        int old = listaProizvodaZaDnevniIzvestaj.get(l1).getProizvod().getId();
                        if(old == update ){
                            counter=1;
                            DnevniIzvProizvod dip = updateLista.get(l);
                            dip.updateDnevniIzvProizvod();

                        }
                    }
                    if(counter == 0){
                           DnevniIzvProizvod dip = new DnevniIzvProizvod(idDnevnogIzvestaja, update);
                           dip.setIznos(updateLista.get(l).getIznos());

                            
                            dip.saveDnevniIzvProizvod2();
                        }
                }
                if (b==0){
                   
                op.showMessageDialog (op.getParent(),"Niste uneli podatke u tabelu. Molimo vas unesite podatke i pokusajte ponovo!","Tabela",JOptionPane.INFORMATION_MESSAGE); 
                }    
                 return flag;
        }
     
//Update Proizvoda        
        public static void updateProizvod (int id,String naziv,double cena,double kolicina, double gramaza,JList j,JOptionPane op) throws SQLException{
           Proizvod p = Proizvod.getProizvod(id);
           p.setTip(getTipProizvodaFromList(j));
           DBConnect db = DBConnect.getInstance();
           db.conn.setAutoCommit(false);
           int b=0;
           if(textCheck(naziv)==1){
               p.setNaziv(naziv);
               b=1;
               if(doubleCheck(Double.toString(cena))==1){
                   p.setCena(cena);
                   b=2;
               }
               if(doubleCheck(Double.toString(kolicina))==1){
                   p.setKolicina(kolicina);
                   b=3;
               }
               if(doubleCheck(Double.toString(gramaza))==1){
                   p.setGramaza(gramaza);
                   b=4;
               }
               int result = p.updateProizvod();
               if(result ==1){
                   db.conn.commit();
                   op.showMessageDialog(op.getParent(),"Uspesno ste izmenili proizvod: " + Proizvod.getProizvod(p.getId()).getNaziv(),"Proizvod",JOptionPane.INFORMATION_MESSAGE );
               }else{
                    db.conn.rollback();
                   op.showMessageDialog(op.getParent(),"Izmena proizvoda nije sacuvana! Molimo vas pokusajte ponovo." ,"Proizvod",JOptionPane.ERROR_MESSAGE );
               }
            }else{
               String polje= null;
               switch (b){
                   case 1:
                       polje= "Naziv";
                   break;
                   case 2:
                       polje= "Cena";
                   break;
                   case 3:
                       polje= "Kolicina";
                   break;
                   case 4:
                       polje= "Gramaza";
                   break;
               }
               op.showMessageDialog(op.getParent(),"Neispravan unos podataka u polju: " + polje ,"Proizvod",JOptionPane.ERROR_MESSAGE );
            }
            db.conn.setAutoCommit(true);
        }
        
    
  //Update dobavljaca      
        public static void updateDobavljac (int id,String naziv, String pib, String adresa, String telefon,JOptionPane op) throws SQLException{
            Dobavljac d = new Dobavljac ();
            DBConnect db = DBConnect.getInstance();
            db.conn.setAutoCommit(false);
            int b =0;
            d.setId(id);
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
               
                int result = d.updateDobavljac();
                if(result == 1){
                    db.conn.commit();
                    op.showMessageDialog(op.getParent(),"Uspesno ste izmenili dobavljaca: " + Dobavljac.getDobavljac(d.getId()).getNaziv(),"Dobavljac",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    db.conn.rollback();
                    op.showMessageDialog(op.getParent(),"Dobavljac" + d.getNaziv() +" nije uspesno izmenjen!Pokusajte ponovo!","Dobavljac",JOptionPane.INFORMATION_MESSAGE);
                }
            }else {
               
                op.showMessageDialog(op.getParent(),"Neispravan unos podataka. Molimo vas pokusajte ponovo!","Neispravan unos",JOptionPane.ERROR_MESSAGE);
            }
            
            db.conn.setAutoCommit(true);
        }    
  
    /*Update TipaProizvoda*/    
        public static void updateTipProizvoda (int id,String naziv, String opis,JOptionPane op) throws SQLException{
            TipProizvoda t = new TipProizvoda();
            DBConnect db = DBConnect.getInstance();
            db.conn.setAutoCommit(false);
            t.setId(id);
            int b = 0;
            if(textCheck(naziv) == 1 && !naziv.isEmpty()){
                t.setNaziv(naziv);
                
                    if (longTextCheck(opis)==1 && !opis.isEmpty()){
                         t.setOpis(opis);
                         b++;
                        
                    }
            }
            if (b != 0){
                 int result = t.updateTipProizvoda();
                 if(result ==1){
                     db.conn.commit();
                     op.showMessageDialog(op.getParent(),"Uspesno izmenjen tip proizvoda: " + TipProizvoda.getTipProizvoda(t.getId()),"Tip proizvoda",JOptionPane.INFORMATION_MESSAGE);
                 }else{
                     db.conn.rollback();
                     op.showMessageDialog(op.getParent(),"Izmena tipa proizvoda nije uspela! " ,"Tip proizvoda",JOptionPane.INFORMATION_MESSAGE);
                 }
            }else{
                op.showMessageDialog(op.getParent(),"Neispravan unos podataka. Molimo vas pokusajte ponovo! ","Neispravan unos",JOptionPane.ERROR_MESSAGE);
            }
            
            db.conn.setAutoCommit(true);
         }   

        //Update Troskova
        public static void updateTroskovi (int id,ButtonGroup b,int datum,double iznos, String naziv, JOptionPane op) throws SQLException{
            DBConnect db = DBConnect.getInstance();
            db.conn.setAutoCommit(false);
            
            Datum d = Datum.getDatum(datum);
            Trosak t = new Trosak(getTipTroskaFromJRButton(b), d);
            t.setId(id);
            int flag=0;
            if(textCheck(naziv)==1 && !naziv.isEmpty()){
                t.setNaziv(naziv);
                flag++;
                if(doubleCheck(Double.toString(iznos))==1){
                    t.setIznos(iznos);
                 flag++;   
                   
                    
                }
                
            }
            
            if(flag == 2){
                int result = t.updateTrosak();
                if(result ==1){
                    op.showMessageDialog(op.getParent(),"Uspesno izmenjen trosak. ","Trosak",JOptionPane.INFORMATION_MESSAGE);
                    db.conn.commit();
                }else{
                  op.showMessageDialog(op.getParent(),"Neuspesno izmenjen trosak. Molimo vas pokusajte ponovo! ","Trosak",JOptionPane.INFORMATION_MESSAGE);  
                  db.conn.rollback();
                }
            }else{
               op.showMessageDialog(op.getParent(),"Neispravan unos podataka. Molimo vas pokusajte ponovo! ","Neispravan unos",JOptionPane.ERROR_MESSAGE); 
            }
            
            db.conn.setAutoCommit(true);
        }
      
  
        //Update Zaposleni
         public static void updateZaposleni (int id,String ime, String adresa,String telefon,ButtonGroup b1,ButtonGroup b2,String lozinka, JOptionPane op) throws SQLException{
            Zaposleni zaposleni = new Zaposleni (getTipTroskaFromJRButton(b1));
            zaposleni.setId(id);
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
                int result = zaposleni.updateZaposleni();
                if(result ==1){
                    db.conn.commit();
                    op.showMessageDialog(op.getParent(),"Uspesno izmenjen zaposleni. ","Zaposleni",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    db.conn.rollback();
                    op.showMessageDialog(op.getParent(),"Neuspesno izmenjen zaposleni. ","Zaposleni",JOptionPane.INFORMATION_MESSAGE);
                }
                
            }else{
                op.showMessageDialog(op.getParent(),"Neispravan unos podataka. Molimo vas pokusajte ponovo! ","Neispravan unos",JOptionPane.ERROR_MESSAGE);
            }

        }
   
/*Update --kraj*/
        
/*Delete --pocetak*/
     
        /*int idForme  = 1 za NabavkaOut  a =2 za DnevniIzvestajOUT*/
        public static boolean deleteFromTable (JTable jt,int idForme) throws SQLException{
            int id = 0;
            boolean flag=false;
            switch(idForme){
                case 1:
                    id=getSelectedFromTable(jt);
                    flag= Nabavka.deleteNabavka(id);
                break;
                case 2:
                    id=getSelectedFromTable(jt);
                    flag = DnevniIzvestaj.deleteDnevniIzvestaj(id);
                break;
                case 3:
                    id = getSelectedFromTable2(jt,3);
                    flag = Proizvod.deleteProizvod(id);
                break; 
                case 4:
                    id = getSelectedFromTable2(jt,4);
                    flag = Dobavljac.deleteDobavljac(id);
                break;
                case 5:
                    id = getSelectedFromTable2(jt,5);
                    flag = TipProizvoda.deleteTipProizvoda(id);
                break;
                case 6:
                    id = getSelectedFromTable2(jt,6);
                    flag = Trosak.deleteTrosak(id);
                break;
                case 7:
                    id = getSelectedFromTable2(jt,7);
                    flag = Zaposleni.deleteZaposleni(id);
                break;
            }
            if(flag){
                
                DefaultTableModel dtf = (DefaultTableModel) jt.getModel();
                dtf.removeRow(jt.getSelectedRow());
            }
            return flag;
        }
/*Delete --kraj*/
        
        
                
         public static int jButtonChooseWidth = 135;
         public static int jButtonChooseHeigth = 40;
         
         
         public static int Width06p;
         public static int Width4p ;
         public static int Width8p ;
         public static int Width9p ;
         public static int Width10p ;
         public static int Width12p ;
         public static int Width13p ;
         public static int Width15p ;
         public static int Width18p ;
         public static int Width19p ;
         public static int Width20p ;
         public static int Width24p ;
         public static int Width25p ;
         public static int Width27p ;
         public static int Width29p ;
         public static int Width30p ;
         public static int Width31p ;
         public static int Width36p ;
         public static int Width39p ;
         public static int Width40p ;
         public static int Width46p ;
         
         
         public static int Height4p;
         public static int Height5p;
         public static int Height6p;
         public static int Height7p;
         public static int Height9p;
         public static int Height10p;
         public static int Height12p;
         public static int Height13p;
         public static int Height14p;
         public static int Height16p;
         public static int Height18p;
         public static int Height19p;
         public static int Height20p;
         public static int Height23p;
         public static int Height26p;
         public static int Height27p;
         public static int Height29p;
         public static int Height30p;
         public static int Height31p;
         public static int Height32p;
         public static int Height33p;
         public static int Height35p;
         public static int Height36p;
         public static int Height37p;
         public static int Height38p;
         public static int Height39p;
         public static int Height40p;
         public static int Height41p;
         public static int Height43p;
         public static int Height44p;
         public static int Height45p;
         public static int Height47p;
         public static int Height49p;
         public static int Height51p;
         public static int Height52p;
         public static int Height53p;
         public static int Height56p;
         public static int Height57p;
         public static int Height59p;
         public static int Height60p;
         public static int Height61p;
         public static int Height62p;
         public static int Height64p;
         public static int Height65p;
         public static int Height66p;
         public static int Height67p;
         public static int Height70p;
         public static int Height73p;
         public static int Height75p;
         public static int Height80p;
         public static int Height84p;
         
         public static int procenat (double s, double p){
             double b = s*p/100;
             int a=(int) Math.round(b);
             return a;
         }
         
         public static void dimenzije (Dimension d){
           
           double visina = (double)d.height;
           double sirina = (double)d.width;

           ControllerExit.Width06p=ControllerExit.procenat(sirina, 0.6D);
           ControllerExit.Width4p=ControllerExit.procenat(sirina, 4D);
           ControllerExit.Width8p=ControllerExit.procenat(sirina, 8D);
           ControllerExit.Width9p=ControllerExit.procenat(sirina, 9D);
           ControllerExit.Width10p = ControllerExit.procenat(sirina, 10D);
           ControllerExit.Width12p=ControllerExit.procenat(sirina, 12D);
           ControllerExit.Width13p=ControllerExit.procenat(sirina, 13D);
           ControllerExit.Width15p=ControllerExit.procenat(sirina, 15D);
           ControllerExit.Width18p = ControllerExit.procenat(sirina, 18D);
           ControllerExit.Width19p = ControllerExit.procenat(sirina, 19D);
           ControllerExit.Width20p = ControllerExit.procenat(sirina, 20D);
           ControllerExit.Width24p = ControllerExit.procenat(sirina, 24D);
           ControllerExit.Width25p = ControllerExit.procenat(sirina, 25D);
           ControllerExit.Width27p = ControllerExit.procenat(sirina, 27D);
           ControllerExit.Width29p = ControllerExit.procenat(sirina, 29D);
           ControllerExit.Width30p = ControllerExit.procenat(sirina, 30D);
           ControllerExit.Width31p = ControllerExit.procenat(sirina, 31D);
           ControllerExit.Width36p = ControllerExit.procenat(sirina, 36D);
           ControllerExit.Width39p = ControllerExit.procenat(sirina, 39D);
           ControllerExit.Width40p = ControllerExit.procenat(sirina, 40D);
           ControllerExit.Width46p = ControllerExit.procenat(sirina, 46D);

           ControllerExit.Height4p=ControllerExit.procenat(visina, 4D);
           ControllerExit.Height5p=ControllerExit.procenat(visina, 5D);
           ControllerExit.Height6p=ControllerExit.procenat(visina, 6D);
           ControllerExit.Height7p=ControllerExit.procenat(visina, 7D);
           ControllerExit.Height9p=ControllerExit.procenat(visina, 9D);
           ControllerExit.Height10p=ControllerExit.procenat(visina, 10D);
           ControllerExit.Height12p=ControllerExit.procenat(visina, 12D);
           ControllerExit.Height13p=ControllerExit.procenat(visina, 13D);
           ControllerExit.Height14p=ControllerExit.procenat(visina, 14D);
           ControllerExit.Height16p=ControllerExit.procenat(visina, 16D);
           ControllerExit.Height18p=ControllerExit.procenat(visina, 18D);
           ControllerExit.Height19p=ControllerExit.procenat(visina, 19D);
           ControllerExit.Height20p=ControllerExit.procenat(visina, 20D);
           ControllerExit.Height23p=ControllerExit.procenat(visina, 23D);
           ControllerExit.Height26p=ControllerExit.procenat(visina, 26D);
           ControllerExit.Height27p=ControllerExit.procenat(visina, 27D);
           ControllerExit.Height29p=ControllerExit.procenat(visina, 29D);
           ControllerExit.Height30p=ControllerExit.procenat(visina, 30D);
           ControllerExit.Height31p=ControllerExit.procenat(visina, 31D);
           ControllerExit.Height32p=ControllerExit.procenat(visina, 32D);
           ControllerExit.Height33p=ControllerExit.procenat(visina, 33D);
           ControllerExit.Height35p=ControllerExit.procenat(visina, 35D);
           ControllerExit.Height36p=ControllerExit.procenat(visina, 36D);
           ControllerExit.Height37p=ControllerExit.procenat(visina, 37D);
           ControllerExit.Height38p=ControllerExit.procenat(visina, 38D);
           ControllerExit.Height39p=ControllerExit.procenat(visina, 39D);
           ControllerExit.Height40p=ControllerExit.procenat(visina, 40D);
           ControllerExit.Height41p=ControllerExit.procenat(visina, 41D);
           ControllerExit.Height43p=ControllerExit.procenat(visina, 43D);
           ControllerExit.Height44p=ControllerExit.procenat(visina, 44D);
           ControllerExit.Height45p=ControllerExit.procenat(visina, 45D);
           ControllerExit.Height47p=ControllerExit.procenat(visina, 47D);
           ControllerExit.Height49p=ControllerExit.procenat(visina, 49D);
           ControllerExit.Height51p=ControllerExit.procenat(visina, 51D);
           ControllerExit.Height52p=ControllerExit.procenat(visina, 52D);
           ControllerExit.Height53p=ControllerExit.procenat(visina, 53D);
           ControllerExit.Height56p=ControllerExit.procenat(visina, 56D);
           ControllerExit.Height57p=ControllerExit.procenat(visina, 57D);
           ControllerExit.Height59p=ControllerExit.procenat(visina, 59D);
           ControllerExit.Height60p=ControllerExit.procenat(visina, 60D);
           ControllerExit.Height61p=ControllerExit.procenat(visina, 61D);
           ControllerExit.Height62p=ControllerExit.procenat(visina, 62D);
           ControllerExit.Height64p=ControllerExit.procenat(visina, 64D);
           ControllerExit.Height65p=ControllerExit.procenat(visina, 65D);
           ControllerExit.Height66p=ControllerExit.procenat(visina, 66D);
           ControllerExit.Height67p=ControllerExit.procenat(visina, 67D);
           ControllerExit.Height70p=ControllerExit.procenat(visina, 70D);
           ControllerExit.Height73p=ControllerExit.procenat(visina, 73D);
           ControllerExit.Height75p=ControllerExit.procenat(visina, 75D);
           ControllerExit.Height80p=ControllerExit.procenat(visina, 80D);
           ControllerExit.Height84p=ControllerExit.procenat(visina, 84D);
         }
 
}
