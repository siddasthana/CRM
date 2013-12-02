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
 * The Reminder class stores reminders
 * It Inserts, Updates and Loads data from the reminder table in the database
 * 
 *  <pre>
 *  Table Structure
 *      VariableName    Field       Type            NULL    KEY     EXTRA
 *      id              id          int(11)         NO      PRI     auto_increment
 *      AlarTime        AlarmTime   datetime        YES			
 *      Complaint       Complaint   varchar(50)     YES			
 *      Severity        Severity    varchar(20)     YES			
 *      Status          Status      varchar(2)      YES			
 * @author Shikhar Singhal
 */
public class Reminder {

    long id;
    String AlarmTime, Complaint, Severity, Status;
    Sql sql = new Sql();

    /**
     * @return A long Reminder id value
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the Reminder id value
     * @param id A long value
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return A String Reminder AlarmTime value
     */
    public String getAlarmTime() {
        return AlarmTime;
    }

    /**
     * Sets the reminder AlarmTime value
     * @param AlarmTime A String value
     */
    public void setAlarmTime(String AlarmTime) {
        this.AlarmTime = AlarmTime;
    }

    /**
     * @return A String Reminder Complaint value
     */
    public String getComplaint() {
        return Complaint;
    }

    /**
     * Sets the Reminder Complaint value
     * @param Complaint A String value
     */
    public void setComplaint(String Complaint) {
        this.Complaint = Complaint;
    }

    /**
     * @return A String Reminder Severity value
     */
    public String getSeverity() {
        return Severity;
    }

    /**
     * Sets the Reminder Severity value
     * @param Severity A String value
     */
    public void setSeverity(String Severity) {
        this.Severity = Severity;
    }

    /**
     * @return A String Reminder Status value
     */
    public String getStatus() {
        return Status;
    }

    /**
     * Sets the Reminder Status value
     * @param Status A String value
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    /**
     * Saves a reminder record into reminder table of Database
     * @throws SQLException If any SQL related exception occurs
     */
    public void savetodb() {

        String Query =
                "INSERT INTO `" + Sql.dbName +
                "`.`reminder` (`id`, `AlarmTime`, `Complaint`, `Severity`, `Status`)" +
                " values(null,?,?,?,?) ";
        //Query += " VALUES ('"+getCaseID()+"', '"+getName()+"', '"+getPhone()+"', '"+getAddress()+"', '"+getFir()+"')";
        // Sql sql = new Sql();
        PreparedStatement stmt = sql.GetPrepareStmt(Query);
        System.out.println("query for Reminder"+Query);
        
        try {
            stmt.setString(1, getAlarmTime());
            stmt.setString(2, getComplaint());
            stmt.setString(3, getSeverity());
            stmt.setString(4, getStatus());            
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        //sql.ExecuteUpdate(Query);
        // sql.ExecuteUpdate(Query);
        ResultSet rs = sql.ExecuteQuery("Select last_insert_id();");
        
        try {
            if (rs.next()) {
                long insertid = Long.valueOf(rs.getLong(1));
                this.setId(insertid);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql.Destructor();
    }
    
    /**
     * Loads specific entries in Reminder list by Querrying the Querypart on the reminder table
     * @param Querypart A String - Postfix part of the query statement - "Select * From reminder where "
     * @return an ArrayList of Reminder objects
     * @throws SQLException If any SQL related exception occurs
     */
    public ArrayList<Reminder> loadclass(String Querypart) {
        ArrayList<Reminder> rem = new ArrayList<>();
        String Query = "Select * From reminder where " + Querypart;
        // Sql sql = new Sql();
        ResultSet rs = sql.ExecuteQuery(Query);
        
        try {
            while (rs.next()) {
                Reminder obj = new Reminder();
                
                obj.setId(rs.getInt(1));
                obj.setAlarmTime(rs.getString(2));
                obj.setComplaint(rs.getString(3));
                obj.setSeverity(rs.getString(4));
                obj.setStatus(rs.getString(5));
                rem.add(obj);
            }
            sql.Destructor();
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rem;
    }
    
    /**
     * Updates The Reminder Details to the reminder table
     */
    public void updatedb() {
        String Query =
                "Update `" + Sql.dbName + "`.`reminder` Set " +
                "Status='" + 1 + "'" +        
                " where id=" + (int) getId();
        //Sql sql = new Sql();
        System.out.println(Query);
        sql.ExecuteUpdate(Query);
        sql.Destructor();
    }
}
