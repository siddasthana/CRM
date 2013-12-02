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
 * The Audio class stores Details about Audio recorded
 * It Loads data from the audio table in the database
 * 
 * <pre>
 *  Table Structure
 *      VariableName    Field           Type            NULL    KEY     EXTRA
 *      id              idAudio         bigint(20)      NO      PRI     auto_increment
 *      FilePath	FilePath        varchar(200)	YES			
 *      Number          Number          varchar(45)	YES			
 *      Callid          Callid          bigint(20)	YES	MUL
 * Call id references calls.id
 * 
 * @author admin
 */
public class Audio {
    Long id, Callid;
    String Filepath, Number;
    
    /** 
     * @return A long Audio id value
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the Audio id
     * @param id A long value
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return A long Audio callid value
     */
    public Long getCallid() {
        return Callid;
    }

    /**
     * Sets the Audio Callid
     * @param Callid A long value
     */
    public void setCallid(Long Callid) {
        this.Callid = Callid;
    }

    /**
     * @return A String Audio Filepath value
     */
    public String getFilepath() {
        return Filepath;
    }

    /**
     * Sets the Audio Filepath
     * @param Filepath A String value
     */
    public void setFilepath(String Filepath) {
        this.Filepath = Filepath;
    }

    /**
     * @return A String Audio Phone number value
     */
    public String getNumber() {
        return Number;
    }

    /**
     * Sets the Audio Phone number value
     * @param Number A String value
     */
    public void setNumber(String Number) {
        this.Number = Number;
    }
    
    
    /**
     * Loads specific entries in Audio list by Querrying the Querypart on the audio table
     * @param Querypart A String - Postfix part of the query statement - "Select * From audio where "
     * @return an ArrayList of Audio objects
     * @throws SQLException If any SQL related exception occurs
     */
    public ArrayList<Audio> loadclass(String Querypart){
        ArrayList<Audio> au = new ArrayList<>();
        String Query = "Select * From audio where " + Querypart;
        Sql sql = new Sql();
            System.out.println(Query);
        ResultSet rs = sql.ExecuteQuery(Query);
        try {
            while(rs.next()){
                Audio obj = new Audio();
                
                obj.setId(rs.getLong(1));
                obj.setFilepath(rs.getString(2));
                obj.setNumber(rs.getString(3));
                obj.setCallid(rs.getLong(4));
                au.add(obj);
            }
            sql.Destructor();
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
    return au;
    }
}