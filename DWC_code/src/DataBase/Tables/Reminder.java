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
 * @author Lenovo
 */
public class Reminder {

    long id;
    String AlarmTime, Complaint, Severity, Status;
    Sql sql = new Sql();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAlarmTime() {
        return AlarmTime;
    }

    public void setAlarmTime(String AlarmTime) {
        this.AlarmTime = AlarmTime;
    }

    public String getComplaint() {
        return Complaint;
    }

    public void setComplaint(String Complaint) {
        this.Complaint = Complaint;
    }

    public String getSeverity() {
        return Severity;
    }

    public void setSeverity(String Severity) {
        this.Severity = Severity;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    public void savetodb() {

        String Query = "INSERT INTO `" + Sql.dbName + "`.`reminder` (`id`, `AlarmTime`, `Complaint`, `Severity`, `Status`)" + " values(null,?,?,?,?) ";
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
    
    public ArrayList<Legal> loadclass(String Querypart) {
        ArrayList<Legal> le = new ArrayList<>();
        String Query = "Select * From legal where " + Querypart;
        // Sql sql = new Sql();
        ResultSet rs = sql.ExecuteQuery(Query);
        try {
            while (rs.next()) {
                Legal obj = new Legal();
                obj.setId(rs.getInt(1));
                obj.setCaseID(rs.getInt(6));
                obj.setDD(rs.getString(2));
                obj.setFir(rs.getString(3));
                obj.setChallan(rs.getInt(4));
                obj.setJudgement(rs.getInt(5));
                le.add(obj);
            }
            sql.Destructor();
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
        return le;
    }
    
    public void updatedb() {
        String Query = "Update `" + Sql.dbName + "`.`reminder` Set ";
        Query += "Status='" + 1 + "'";        
        Query += " where id=" + (int) getId();
        //Sql sql = new Sql();
        System.out.println(Query);
        sql.ExecuteUpdate(Query);
        sql.Destructor();
    }
}
