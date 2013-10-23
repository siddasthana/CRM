/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author admin
 */
public class Sql {

    Connection con = null;
    ResultSet rs = null;
    public static String dbName = "womencell";
//  public static String dbName = "womencell";
    //public static String Server_IP = "10.128.83.112";
    public static String Server_IP = "localhost";  
    String url = "jdbc:mysql://" + Server_IP + ":3306/";
    //   String url = "jdbc:mysql://localhost:3306/";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "womencell";
    //    String userName = "root";
    String password = "womencell@123";
    //String password = "womencell";

    public Connection getConnection() {
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url + dbName, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;

    }

    public ResultSet ExecuteQuery(String Query) {
        if (con == null) {
            con = getConnection();
        }
        try {
            rs = con.createStatement().executeQuery(Query);
        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public void ExecuteUpdate(String Query) {
        if (con == null) {
            con = getConnection();
        }
        try {
            con.createStatement().executeUpdate(Query);
        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getStackTrace());
        }
    }

    public PreparedStatement GetPrepareStmt(String Query) {
        PreparedStatement stmt = null;
        if (con == null) {
            con = getConnection();
        } else {
            try {
                if (con.isClosed()) {
                    con = getConnection();
                }
                System.gc();
            } catch (SQLException ex) {
                Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        try {
            stmt = con.prepareStatement(Query);
        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getStackTrace());
        }
        return stmt;
    }

    public void Destructor() {
        try {
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(Sql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
