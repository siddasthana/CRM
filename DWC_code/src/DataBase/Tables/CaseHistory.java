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
 * The CaseHistory class stores details of the Case History 
 * It Inserts, Updates and Loads data from the caller table in the database
 * <pre>
 *  Table Structure
 *      VariableName    Field           Type            NULL    KEY     EXTRA
 *      id              idCase_History	bigint(20)	NO	PRI		auto_increment
 *      CaseID          CaseID          bigint(20)	YES	MUL		
 *      DateStamp       DateStamp	datetime	YES			
 *      AgentID         AgentID         int(11)         YES	MUL		
 *      Note            Note            text            YES			
 *      Advice          Advice          text            YES			
 *      Reffered        Reffered	varchar(45)	YES			 
 * 
 * AgentID refereces Agent.id
 * CaseID references cases.id
 * @author Shikhar Singhal
 */
public class CaseHistory {
    long id, CaseID, AgentID;
    String Datestamp,Note,Advice, Reffered;
    Sql sql = new Sql();
    
    /**
     * @return A long CaseHistory id value
     */
    public long getId() {
        return id;
    }

    /**
     * Sets The CaseHistory id value
     * @param id A long value
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return A long CaseHistory CaseID value
     */
    public long getCaseID() {
        return CaseID;
    }

    /**
     * Sets the CaseHistory CaseID value
     * @param CaseID A long value
     */
    public void setCaseID(long CaseID) {
        this.CaseID = CaseID;
    }

    /**
     * @return A long CaseHistory AgentID value
     */
    public long getAgentID() {
        return AgentID;
    }

    /**
     * Sets the CaseHistory AgentID value
     * It is The AgentID of the Aget that handled the Case
     * @param AgentID A long value
     */
    public void setAgentID(long AgentID) {
        this.AgentID = AgentID;
    }

    /**
     * @return A String CaseHistory Datestamp value
     */
    public String getDatestamp() {
        return Datestamp;
    }

    /**
     * Sets the CaseHistory Datestamp value
     * @param Datestamp A String values
     */
    public void setDatestamp(String Datestamp) {
        this.Datestamp = Datestamp;
    }

    /**
     * @return A String CaseHistory Note value
     */
    public String getNote() {
        return Note;
    }

    /**
     * Sets the CaseHistory Note value
     * @param Note A String value
     */
    public void setNote(String Note) {
        this.Note = Note;
    }

    /**
     * @return A String CaseHistory Advice value
     */
    public String getAdvice() {
        return Advice;
    }

    /**
     * Sets the CaseHistory Advice value
     * @param Advice A String value
     */
    public void setAdvice(String Advice) {
        this.Advice = Advice;
    }
    
    /**
     * @return A String CaseHistory Reffered value
     */
    public String getReffered() {
        return Reffered;
    }
    
    /**
     * Sets the CaseHistory Reffered value
     * @param Reffered A String value
     */
    public void setReffered(String Reffered) {
        this.Reffered = Reffered;
    }
      
    /**
     * Saves a record in the case_history table in the Database
     * @throws SQLException If any SQL related exception occurs
     */
    public void savetodb(){
        String Query = 
                "INSERT INTO `"+Sql.dbName +
                "`.`case_history` (`idCase_History`,"+
                " `CaseID`," +
                " `DateStamp`," +
                " `AgentID`," +
                " `Note`," +
                " `Advice`," +
                " `Reffered`)" +
                " values(null,?,NOW(),?,?,?,?) ";
        // Query += " VALUES ('"+getCaseID()+"', NOW(), '"+getAgentID()+"', '"+getNote()+"', '"+getAdvice()+"', '"+getReffered()+"')";
        // Sql sql = new Sql();
        try {
            //sql.ExecuteUpdate(Query);
            System.out.println(Query);
            PreparedStatement stmt = sql.GetPrepareStmt(Query);
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
                System.out.println("Case History ID" + insertid);
            }else {
                System.err.println("Not able to fetch Case History ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql.Destructor();
    }
    
    /**
     * Loads specific entries in CaseHistory list by Querrying the Querypart on the case_history table
     * @param Querypart A String - Postfix part of the query statement - "Select * From case_history where "
     * @return an ArrayList of CaseHistory objects
     * @throws SQLException If any SQL related exception occurs
     */
    public ArrayList<CaseHistory> loadclass(String Querypart){
        ArrayList<CaseHistory> ch = new ArrayList<>();
        String Query = "Select * From case_history where " + Querypart;
        //    Sql sql = new Sql();
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