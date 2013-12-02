/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase.Tables;

import DataBase.Sql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Calls class stores details of the Calls
 * It Inserts, Updates and Loads data from the calls table in the database
 * 
 * <pre>
 *  Table Structure
 *      VariableName    Field           Type            NULL    KEY     EXTRA
 *      id              idCall          bigint(20)      NO      PRI     auto_increment
 *      CaseHID         CaseHID         bigint(20)      YES     MUL		
 *      StartTime       StartTime       datetime        YES			
 *      Duration        Duration	int(11)         YES			
 *      QueueTime       QueueTime	int(11)         YES			
 *      AgentID         AgentID         int(11)         YES	MUL		
 *      Number          Number          bigint(20)	YES			
 *      Bound           Bound           varchar(5)	YES			
 *                      TextualDate	varchar(45)	YES			
 *                      CallUUID	varchar(100)	YES
 * 
 * CaseHID references CaseHistory.id
 * @author Shikhar Singhal
 */
public class Calls {
    long id, CaseHID;
    int Duration, QueueTime, AgentID;
    String StartTime, Number, Bound;
    Sql sql = new Sql();

    /**
     * @return A long Calls id value
     */
    public long getId() {
        return id;
    }

     /**
     * Sets the Calls id value
     * @param id A long value
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return A long Calls CaseHID value
     */
    public long getCaseHID() {
        return CaseHID;
    }

    /**
     * Sets the Calls CaseHID value
     * @param CaseHID A long value
     */
    public void setCaseHID(long CaseHID) {
        this.CaseHID = CaseHID;
    }

    /**
     * @return An int Calls Duration value
     */
    public int getDuration() {
        return Duration;
    }

    /**
     * Sets the Calls Duration value
     * @param Duration An int value
     */
    public void setDuration(int Duration) {
        this.Duration = Duration;
    }

    /**
     * @return An int Calls QueueTime value
     */
    public int getQueueTime() {
        return QueueTime;
    }

    /**
     * Sets the Calls QueueTime value
     * @param QueueTime An int value
     */
    public void setQueueTime(int QueueTime) {
        this.QueueTime = QueueTime;
    }

    /**
     * @return An int Calls AgentID value
     */
    public int getAgentId() {
        return AgentID;
    }

    /**
     * Sets the Calls AgentID value
     * It is same as the AgentID value of the Agent currently logged in
     * @param AgentID An int value
     */
    public void setAgentId(int AgentId) {
        this.AgentID = AgentId;
    }

    /**
     * @return A String Calls StartTime value
     */
    public String getStartTime() {
        return StartTime;
    }

    /**
     * Sets the Calls StartTime value
     * Stores the Starttime of this particular call
     * @param StartTime Date converted to Sting format
     */
    public void setStartTime(String StartTime) {
        this.StartTime = StartTime;
    }

    /**
     * @return A String Calls Number value
     */
    public String getNumber() {
        return Number;
    }

    /**
     * Sets the Calls Number value
     * @param Number A String value
     */
    public void setNumber(String Number) {
        this.Number = Number;
    }

    /**
     * @return A String Calls Bound value
     */
    public String getBound() {
        return Bound;
    }

    /**
     * Sets the Calls Bound value
     * @param Bound A String value
     */
    public void setBound(String Bound) {
        this.Bound = Bound;
    }
    
    /**
     * Updates The Calls Details to the calls table
     * @throws SQLException If any SQL related exception occurs
     */
    public void updatedb(){
            /* String Query = "Update `"+Sql.dbName+"`.`calls` Set "
                + "`CaseHID`="+getCaseHID()
                + ", `StartTime`='"+getStartTime()
                + ", `Duration`="+getDuration()
                + ", `QueueTime`="+getQueueTime()
                + ", `AgentID`="+getAgentId()
                + ", `Number`="+getNumber()
                + ", `Bound`='"+getBound()
                + "' where idCall="+getId();
            */
   
       String Query = 
               "UPDATE `calls`"+
               "SET CaseHID = ?," +
               " Duration = ?," +
               " QueueTime = ?," +
               " AgentID = ?," +
               " Number=?," +
               "Bound=?" +
               " WHERE idCall = ?";
  //Sql sql = new Sql();
       PreparedStatement stmt1 = sql.GetPrepareStmt(Query);
       try {
            stmt1.setLong(1,getCaseHID());
            stmt1.setInt(2,getDuration());
            stmt1.setInt(3,getQueueTime());
            stmt1.setInt(4,getAgentId());
            stmt1.setString(5,getNumber());
            stmt1.setString(6,getBound());
            stmt1.setLong(7,getId());
            int i = stmt1.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e);
        }
    //Query += " VALUES ('"+getCaseHID()+"', '"+getStartTime()+"', '"+getDuration()+"', '"+getQueueTime()+"', '"+getAgentId()+"', '"+getNumber()+"', '"+getBound()+"')";
        System.out.println(Query);
      //sql.ExecuteUpdate(Query);
        sql.Destructor();
        }
    
    /**
     * Saves a record in the calls table in the Database
     * @throws SQLException If any SQL related exception occurs
     */
    public void savetodb() {
        String Query = 
                "INSERT INTO `" + Sql.dbName +
                "`.`calls` (`idCall`," +
                " `CaseHID`," +
                " `StartTime`," +
                " `Duration`," +
                " `QueueTime`," +
                " `AgentID`," +
                " `Number`," +
                " `Bound`)" +
                "values(null,?,?,?,?,?,?,?)";
        //  Query += " VALUES ('"+getCaseHID()+"', '"+getStartTime()+"', '"+getDuration()+"', '"+getQueueTime()+"', '"+getAgentId()+"', '"+getNumber()+"', '"+getBound()+"')";
        //Sql sql = new Sql();
        PreparedStatement stmt = sql.GetPrepareStmt(Query);
        
        //  sql.ExecuteUpdate(Query);
        try {
            stmt.setLong(1,getCaseHID());
            stmt.setString(2,getStartTime());
            stmt.setInt(3,getDuration());
            stmt.setInt(4,getQueueTime());
            stmt.setInt(5,getAgentId());
            stmt.setString(6,getNumber());
            stmt.setString(7,getBound());
            stmt.executeUpdate();
            ResultSet rs = sql.ExecuteQuery("Select last_insert_id();");
        
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
     * Loads specific entries in Calls list by Querrying the Querypart on the caller table
     * @param Querypart A String - Postfix part of the query statement - "Select * From calls where "
     * @return an ArrayList of Calls objects
     * @throws SQLException If any SQL related exception occurs
     */
    public ArrayList<Calls> loadclass(String Querypart){
        ArrayList<Calls> cl = new ArrayList<>();
        String Query = "Select * From calls where " + Querypart;
        System.out.println(Query);
        //   Sql sql = new Sql();
        ResultSet rs = sql.ExecuteQuery(Query);
        try {
            while(rs.next()){
                Calls obj = new Calls();
                
                obj.setId(rs.getLong(1));
                obj.setCaseHID(rs.getLong(2));
                obj.setStartTime(rs.getDate(3).toString());
                obj.setDuration(rs.getInt(4));
                obj.setQueueTime(rs.getInt(5));
                obj.setAgentId(rs.getInt(6));
                obj.setNumber(rs.getString(7));
                obj.setBound(rs.getString(8));
                cl.add(obj);
            }
            sql.Destructor();
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
    return cl;
    }
}