/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase.Tables;

import DataBase.Sql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Directory class stores details of the Directory
 * It Loads data from the directory table in the database
 * 
 * <pre>
 *  Table Structure
 *      VariableName    Field           Type            NULL    KEY     EXTRA
 *      District        DISTRICT	varchar(50)	YES			
 *      Area            AREA            varchar(61)	YES			
 *      Service         SERVICE     	varchar(54)	YES			
 *      Info            INFO            varchar(133)	YES			
 *      Nubar           NUMBER          varchar(50)	YES
 * </pre>
 * 
 * @author Shikhar Singhal
 */
public class Directory {

    long id;
    String District, Area, Service, Info, Number;

    /**
     * @return A Long Directory id value
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the Directory id
     * @param id A Long value
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return A String Directory District value
     */
    public String getDistrict() {
        return District;
    }

    /**
     * Sets the Directory District value
     * @param District 
     */
    public void setDistrict(String District) {
        this.District = District;
    }

    /**
     * @return A String Directory Area value
     */
    public String getArea() {
        return Area;
    }

    /**
     * Sets the Directory Area value
     * @param Area A String value
     */
    public void setArea(String Area) {
        this.Area = Area;
    }

    /**
     * @return A String Directory Number value
     */
    public String getNumber() {
        return Number;
    }

    /**
     * Sets the Directory Number value
     * @param Number A String value
     */
    public void setNumber(String Number) {
        this.Number = Number;
    }

    /**
     * @return A String Directory Service value
     */
    public String getService() {
        return Service;
    }

    /**
     * Sets the Directory Service value
     * @param Service A String value
     */
    public void setService(String Service) {
        this.Service = Service;
    }

    /**
     * @return A String Directory info value
     */
    public String getInfo() {
        return Info;
    }

    /**
     * Sets the Directory info value
     * @param Info A String value
     */
    public void setInfo(String Info) {
        this.Info = Info;
    }
/**
     * Loads specific entries in Directory list by Querrying the Querypart on the directory table
     * @param Querypart A String - Postfix part of the query statement - "Select * From directory where "
     * @return an ArrayList of Directory objects
     * @throws SQLException If any SQL related exception occurs
     */
    public ArrayList<Directory> loadclass(String Querypart) {
        ArrayList<Directory> dt = new ArrayList<>();
        String Query = "Select * From directory where " + Querypart;
        Sql sql = new Sql();
        System.out.println(Query);
        ResultSet rs = sql.ExecuteQuery(Query);
        
        try {
            while (rs.next()) {
                Directory obj = new Directory();
                
                obj.setId(rs.getInt(1));
                obj.setDistrict(rs.getString(2));
                obj.setArea(rs.getString(3));
                obj.setService(rs.getString(4));
                obj.setInfo(rs.getString(5));
                obj.setNumber(rs.getString("NUMBER"));
                dt.add(obj);            
            }
            sql.Destructor();
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dt;
    }
}
