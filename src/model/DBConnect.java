
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnect {
    
    public Connection conn;
    private static DBConnect instance;
    
    private DBConnect () throws SQLException{
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost/fast_food","brza_hrana","123");
    }
    
    public static DBConnect getInstance () throws SQLException{
        if (instance == null || instance.conn.isClosed()){
            instance = new DBConnect ();
        }
        return instance;
    }
}
