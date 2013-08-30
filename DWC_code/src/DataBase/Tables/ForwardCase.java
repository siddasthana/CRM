/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase.Tables;

import DataBase.Sql;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class ForwardCase {
    Long id, CaseID, Agent, Forwarded;
    String Readstatus;
    String Timestamp;
    String Level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCaseID() {
        return CaseID;
    }

    public void setCaseID(Long CaseID) {
        this.CaseID = CaseID;
    }

    public Long getAgent() {
        return Agent;
    }

    public void setAgent(Long Agent) {
        this.Agent = Agent;
    }

    public Long getForwarded() {
        return Forwarded;
    }

    public void setForwarded(Long Forwarded) {
        this.Forwarded = Forwarded;
    }

    public String getReadstatus() {
        return Readstatus;
    }

    public void setReadstatus(String Readstatus) {
        this.Readstatus = Readstatus;
    }

    public String getTimestamp() {
        if(Timestamp==null){
        return "NOW()";
        }
        return "'"+Timestamp+"'";
    }

    public void setTimestamp(String Timestamp) {
        this.Timestamp = Timestamp;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String Level) {
        this.Level = Level;
    }
            public void savetodb() throws SQLException{
    String Query = "INSERT INTO `"+Sql.dbName+"`.`forwardedcase` (`idForwardedCase`, `CaseID`, `ReadStatus`, `Agent`, `Forwardedby`, `TimeStamp`, `Level`) " + "values(null,?,?,?,?,?,?)";
   // Query += " VALUES ('"+getCaseID()+"', '"+getReadstatus()+"', "+getAgent()+", '"+getForwarded()+"', "+getTimestamp()+", '"+getLevel()+"')";
    Sql sql = new Sql();
    PreparedStatement stmt=sql.GetPrepareStmt(Query);
        ForwardCase f = new ForwardCase();
        stmt.setLong(1,f.getCaseID());
        stmt.setString(2,f.getReadstatus());
        stmt.setLong(3,f.getAgent());
        stmt.setLong(4,f.getForwarded());
        stmt.setString(5,f.getTimestamp());
        stmt.setString(6,f.getLevel());
        stmt.executeUpdate();
        //  sql.ExecuteUpdate(Query);
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
