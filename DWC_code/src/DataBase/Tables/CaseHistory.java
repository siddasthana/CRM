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
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class CaseHistory {
    long id, CaseID, AgentID;
    String Datestamp,Note,Advice, Reffered;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCaseID() {
        return CaseID;
    }

    public void setCaseID(long CaseID) {
        this.CaseID = CaseID;
    }

    public long getAgentID() {
        return AgentID;
    }

    public void setAgentID(long AgentID) {
        this.AgentID = AgentID;
    }

    public String getDatestamp() {
        return Datestamp;
    }

    public void setDatestamp(String Datestamp) {
        this.Datestamp = Datestamp;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public String getAdvice() {
        return Advice;
    }

    public void setAdvice(String Advice) {
        this.Advice = Advice;
    }

    public String getReffered() {
        return Reffered;
    }

    public void setReffered(String Reffered) {
        this.Reffered = Reffered;
    }
       public void savetodb(){
    String Query = "INSERT INTO `"+Sql.dbName+"`.`case_history` (`idCase_History`, `CaseID`, `DateStamp`, `AgentID`, `Note`, `Advice`, `Reffered`)"+ " values(null,?,NOW(),?,?,?,?) ";
   // Query += " VALUES ('"+getCaseID()+"', NOW(), '"+getAgentID()+"', '"+getNote()+"', '"+getAdvice()+"', '"+getReffered()+"')";
   Sql sql = new Sql();
        try {
   
             //sql.ExecuteUpdate(Query);
           System.out.println(Query);
           PreparedStatement stmt=sql.GetPrepareStmt(Query);
      
        stmt.setLong(1,getCaseID());
      //  stmt.setString(2,"NOW()");
        stmt.setLong(2,getAgentID());
        stmt.setString(3,getNote());
        stmt.setString(4,getAdvice());
        stmt.setString(5,getReffered());
    
    //   sql.ExecuteUpdate(Query);
        stmt.executeUpdate();
   
            ResultSet rs = sql.ExecuteQuery("Select last_insert_id();");
            if(rs.next()){
            long insertid = Long.valueOf(rs.getLong(1));
            
            this.setId(insertid);
                    System.out.println("Case History ID"+insertid);
            }else{
        System.err.println("Not able to fetch Case History ID");
        }
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
    sql.Destructor();
    }
    
    public ArrayList<CaseHistory> loadclass(String Querypart){
    ArrayList<CaseHistory> ch = new ArrayList<>();
        String Query = "Select * From case_history where " + Querypart;
        Sql sql = new Sql();
        System.out.println(Query);
        ResultSet rs = sql.ExecuteQuery(Query);
        
        try {
            while(rs.next()){
        CaseHistory obj = new CaseHistory();
                obj.setId((long) rs.getDouble(1));
                obj.setCaseID(rs.getInt(2));
                obj.setDatestamp(rs.getDate(3).toString());
                obj.setAgentID(rs.getInt(4));
                obj.setNote(rs.getString(5));
                obj.setAdvice(rs.getString(6));
                obj.setReffered(rs.getString(7));
                ch.add(obj);           
            }
            sql.Destructor();
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
    return ch;
    }
}
