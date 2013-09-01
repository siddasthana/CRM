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
 *
 * @author admin
 */
public class Calls {
    long id, CaseHID;
int Duration, QueueTime, AgentId;
String StartTime, Number, Bound;
 Sql sql = new Sql();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCaseHID() {
        return CaseHID;
    }

    public void setCaseHID(long CaseHID) {
        this.CaseHID = CaseHID;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int Duration) {
        this.Duration = Duration;
    }

    public int getQueueTime() {
        return QueueTime;
    }

    public void setQueueTime(int QueueTime) {
        this.QueueTime = QueueTime;
    }

    public int getAgentId() {
        return AgentId;
    }

    public void setAgentId(int AgentId) {
        this.AgentId = AgentId;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String StartTime) {
        this.StartTime = StartTime;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }

    public String getBound() {
        return Bound;
    }

    public void setBound(String Bound) {
        this.Bound = Bound;
    }
    public void updatedb(){
   /* String Query = "Update `"+Sql.dbName+"`.`calls` Set "
            + "`CaseHID`="+getCaseHID()
//            + ", `StartTime`='"+getStartTime()
            + ", `Duration`="+getDuration()
            + ", `QueueTime`="+getQueueTime()
            + ", `AgentID`="+getAgentId()
            + ", `Number`="+getNumber()
            + ", `Bound`='"+getBound()
            + "' where idCall="+getId();*/
   
       String Query = "UPDATE calls  SET CaseHID = ?, Duration = ?, QueueTime = ?, AgentID = ?, Number=? ,Bound=? WHERE idCall = ?";
  //Sql sql = new Sql();
       PreparedStatement stmt1=sql.GetPrepareStmt(Query);
       try
       {stmt1.setLong(1,getCaseHID());
        stmt1.setInt(2,getDuration());
        stmt1.setInt(3,getQueueTime());
        stmt1.setInt(4,getAgentId());
        stmt1.setString(5,getNumber());
        stmt1.setString(6,getBound());
        stmt1.setLong(7,getId());
        stmt1.executeUpdate();
       }
         catch(SQLException e)
     {
         System.out.println(e);
     }
    //Query += " VALUES ('"+getCaseHID()+"', '"+getStartTime()+"', '"+getDuration()+"', '"+getQueueTime()+"', '"+getAgentId()+"', '"+getNumber()+"', '"+getBound()+"')";
   
        System.out.println(Query);
      //sql.ExecuteUpdate(Query);
    sql.Destructor();
    }
        public void savetodb() {
    String Query = "INSERT INTO `"+Sql.dbName+"`.`calls` (`idCall`, `CaseHID`, `StartTime`, `Duration`, `QueueTime`, `AgentID`, `Number`, `Bound`)" + "values(null,?,?,?,?,?,?,?)";
  //  Query += " VALUES ('"+getCaseHID()+"', '"+getStartTime()+"', '"+getDuration()+"', '"+getQueueTime()+"', '"+getAgentId()+"', '"+getNumber()+"', '"+getBound()+"')";
    //Sql sql = new Sql();
    PreparedStatement stmt=sql.GetPrepareStmt(Query);
        
   
    //  sql.ExecuteUpdate(Query);
       try {stmt.setLong(1,getCaseHID());
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
