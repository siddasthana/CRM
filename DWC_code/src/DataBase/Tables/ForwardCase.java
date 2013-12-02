/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase.Tables;

import DataBase.Sql;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The ForwardCase class stores details of the forwardedcase
 * It Inserts data to the forwardedcase table in the database
 * 
 *  <pre>
 *  Table Structure
 *      VariableName    Field               Type            NULL    KEY     EXTRA
 *      id              idForwardedCase     bigint(20)      NO      PRI     auto_increment
 *      CaseID          CaseID              bigint(20)      YES     MUL		
 *      ReasStatus      ReadStatus          varchar(2)      YES			
 *      Agent           Agent               int(11)         YES     MUL		
 *      Forwarded       Forwardedby         int(11)         YES     MUL		
 *      Timestamp       TimeStamp           datetime        YES			
 *      Level           Level               varchar(2)      YES			
 *
 * CaseID references Cases.id
 * Agent, Forwarded reference Agent.id
 * @author Shikhar Singhal
 */
public class ForwardCase {
    Long id, CaseID, Agent, Forwarded;
    String Readstatus;
    String Timestamp;
    String Level;

    /**
     * @return A long ForwardCase id value
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ForwardCase id value
     * @param id A long value
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return A long ForwardCase CaseID value
     */
    public Long getCaseID() {
        return CaseID;
    }

    /**
     * Sets the ForwardCase CaseID value
     * @param CaseID A long value
     */
    public void setCaseID(Long CaseID) {
        this.CaseID = CaseID;
    }

    /**
     * 
     * @return A long ForwardCase Agent value
     */
    public Long getAgent() {
        return Agent;
    }

    /**
     * Sets the ForwardCase Agent value
     * @param Agent A long value
     */
    public void setAgent(Long Agent) {
        this.Agent = Agent;
    }

    /**
     * @return A long ForwardCase forwarded value
     */
    public Long getForwarded() {
        return Forwarded;
    }

    /**
     * Sets the ForwardCase Forwarded value
     * @param Forwarded A long value
     */
    public void setForwarded(Long Forwarded) {
        this.Forwarded = Forwarded;
    }

    /**
     * @return A String ForwardCase Readstatus value 
     */
    public String getReadstatus() {
        return Readstatus;
    }

    /**
     * Sets the ForwardCase Readstatus value
     * @param Readstatus A String value
     */
    public void setReadstatus(String Readstatus) {
        this.Readstatus = Readstatus;
    }

    /**
     * @return A String ForwardCase Timestamp value
     */
    public String getTimestamp() {
        if(Timestamp==null){
            return "NOW()";
        } else {
            return "'" + Timestamp + "'";
        }
   }
    
    /**
     * Sets the ForwardCase Timestamp value
     * @param Timestamp A String value
     */
    public void setTimestamp(String Timestamp) {
        this.Timestamp = Timestamp;
    }

    /**
     * @return A String ForwardCase level value
     */
    public String getLevel() {
        return Level;
    }

    /**
     * Sets the ForwardCase Level value
     * @param Level A String value
     */
    public void setLevel(String Level) {
        this.Level = Level;
    }
    
    /**
     * Saves a record into forwardedcase table of Database
     * @throws SQLException If any SQL related exception occurs
     */
    public void savetodb(){
        String Query =  
                "INSERT INTO `" + Sql.dbName +
                "`.`forwardedcase` (`CaseID`, `ReadStatus`, `Agent`, `Forwardedby`, `TimeStamp`, `Level`)" +
                " VALUES ('" + getCaseID() +
                "', '" + getReadstatus() +
                "', " + getAgent() +
                ", '" + getForwarded() +
                "', " + getTimestamp() +
                ", '" + getLevel() + "')";
        Sql sql = new Sql();
        sql.ExecuteUpdate(Query);
        //  sql.ExecuteUpdate(Query);
        ResultSet rs = sql.ExecuteQuery("Select last_insert_id();");
        try {
            if(rs.next()){
                long insertid = Long.valueOf(rs.getLong(1));
                this.setId(insertid);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    sql.Destructor();
    }
}
