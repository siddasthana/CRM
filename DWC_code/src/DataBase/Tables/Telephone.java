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
 * The Telephone class stores details telephone numbers for a particular  
 * It Inserts and Loads data from the telephone table in the database
 * 
 *   <pre>
 *  Table Structure
 *      VariableName    Field           Type            NULL    KEY     EXTRA
 *      id              idTelePhone	bigint(20)	NO	PRI     auto_increment
 *      CaseHid         CaseHID         bigint(20)	YES	MUL		
 *      Number          Number          bigint(20)	YES			
 *      Note            Note            text            YES			
 * CaseHiD references CaseHistory.id
 * 
 * @author Shikhar Singhal
 */
public class Telephone {

    long id, CaseHid, Number;
    String Note;

    /**
     * @return A long telephone id value
     */
    public long getId() {
        return id;
    }

    /**
     * Sets thetelephone id value
     * @param id A long value
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return A long telephone CaseHiD value
     */
    public long getCaseHid() {
        return CaseHid;
    }

    /**
     * Sets the telephone CaseHiD value
     * @param CaseHid A long value
     */
    public void setCaseHid(long CaseHid) {
        this.CaseHid = CaseHid;
    }

    /**
     * @return A long telephone Number value
     */
    public long getNumber() {
        return Number;
    }

    /**
     * Sets the telephone Number value
     * @param Number A long value
     */
    public void setNumber(long Number) {
        this.Number = Number;
    }

    /**
     * @return A String telephone note value
     */
    public String getNote() {
        return Note;
    }

    /**
     * Sets the telephone Note value
     * @param Note A String value
     */
    public void setNote(String Note) {
        this.Note = Note;
    }
    
    /**
     * Saves a record into telephone table of Database
     * @throws SQLException If any SQL related exception occurs
     */
    public void savetodb(){
        String Query =
                "INSERT INTO `" + Sql.dbName +
                "`.`telephone` (`CaseHID`, `Number`, `Note`) "+
                "VALUES ('" + getCaseHid() +
                "', '" + getNumber() +
                "', '" + getNote()+ "')";
        Sql sql = new Sql();
        sql.ExecuteUpdate(Query);
        ResultSet rs = sql.ExecuteQuery("Select last_insert_id();");
    
        try {
            if(rs.next()){
            long insertid = Long.valueOf(rs.getLong(1));
            this.setId(insertid);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql.Destructor();
    } 

    /**
     * Loads specific entries in Telephone list by Querrying the Querypart on the telephone table
     * @param Querypart A String - Postfix part of the query statement - "Select * From telephone where "
     * @return an ArrayList of Telephone objects
     * @throws SQLException If any SQL related exception occurs
     */
    public ArrayList<Telephone> loadclass(String Querypart) {
        ArrayList<Telephone> tp = new ArrayList<>();
        String Query = "Select * From telephone where " + Querypart;
        Sql sql = new Sql();
        System.out.println(Query);
        ResultSet rs = sql.ExecuteQuery(Query);
        
        try {
            while (rs.next()) {
                Telephone obj = new Telephone();
                
                obj.setId(rs.getLong(1));
                obj.setCaseHid(rs.getInt(2));
                obj.setNumber((long) rs.getDouble(3));
                obj.setNote(rs.getString(4));
                tp.add(obj);
            }
            sql.Destructor();
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tp;
    }
}