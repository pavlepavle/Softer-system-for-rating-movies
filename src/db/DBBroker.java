/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.OpstiDomenskiObjekat;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pavlepavle
 */
public class DBBroker {

    private static DBBroker instanca;
    private Connection connection;

    public DBBroker() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("db_info.properties"));
        Class.forName(prop.getProperty(prop.getProperty("current_db") + "_driver"));
        String url = prop.getProperty(prop.getProperty("current_db") + "_url");
        String username = prop.getProperty(prop.getProperty("current_db") + "_user");
        String password = prop.getProperty(prop.getProperty("current_db") + "_password");
        connection = DriverManager.getConnection(url, username, password);
        connection.setAutoCommit(false);
        System.out.println("Konekcija uspesno uspostavljena");
    }

    public static DBBroker vratiInstancu() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        if (instanca == null) {
            instanca = new DBBroker();
        }
        return instanca;
    }
    
    public void potvrdiTransakciju(){
        try {
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ponistiTransakciju(){
        try {
            connection.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<OpstiDomenskiObjekat> vratiSve(OpstiDomenskiObjekat odo) throws SQLException{
        String upit = "select * from "+odo.vratiNazivTabele()+odo.vratiVrednostZaJoin();
        System.out.println(upit);
        Statement st = connection.createStatement();
        
        ResultSet rs = st.executeQuery(upit);
        List<OpstiDomenskiObjekat> lista =  odo.vratiListu(rs);
        return lista;
    }
    public void sacuvaj(OpstiDomenskiObjekat odo) throws Exception{
        String upit = "insert into "+odo.vratiNazivTabele()+" values "+ odo.vratiVrednostiZaInsert();
        System.out.println(upit);
        Statement st = connection.createStatement();
        st.executeUpdate(upit);
        if(odo.daLiJeSlozen()){
            odo.unesiSlozen(odo,st);
        }
    }
    public void obrisi(OpstiDomenskiObjekat odo) throws Exception{
        String upit = "delete from "+odo.vratiNazivTabele()+odo.vratiVrednostZaDelete();
        Statement st = connection.createStatement();
        st.executeUpdate(upit);
    }
    public OpstiDomenskiObjekat pronadji(OpstiDomenskiObjekat odo)throws Exception{
        String upit = "select * from "+odo.vratiNazivTabele()+odo.vratiVrednostZaSelect();
        System.out.println(upit);
        Statement st=  connection.createStatement();
        ResultSet rs = st.executeQuery(upit);
        return odo.vratiObjekat(rs);
        
    }
    public void izmeni(OpstiDomenskiObjekat odo) throws SQLException {
        String upit = "update "+odo.vratiNazivTabele()+" "+odo.vratiVrednostZaUpdate();
        System.out.println(upit);
        Statement st=  connection.createStatement();
        st.executeUpdate(upit);
    }
}
