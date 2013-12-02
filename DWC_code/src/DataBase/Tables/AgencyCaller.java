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
 * @author 181
 */
public class AgencyCaller {
    long id, AgencyID, CaseHID;
    String Name, Number;
    Sql sql = new Sql();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAgencyID() {
        return AgencyID;
    }

    public void setAgencyID(long AgencyID) {
        this.AgencyID = AgencyID;
    }

    public long getCaseHID() {
        return CaseHID;
    }

    public void setCaseHID(long CaseHID) {
        this.CaseHID = CaseHID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }
    

    public void updatedb() {
        String Query = 
                "Update `" + Sql.dbName +
                "`.`agencycaller` Set " +
                "CaseHID='" + getCaseHID()+ "'" +
                ", AgencyID='" + getAgencyID()+ "'" +
                ", Name='" + getName()+ "'" +
                ", Number='" + getNumber()+ "'" +        
                " where id=" + (int) getId();
        //Sql sql = new Sql();
        System.out.println(Query);
        sql.ExecuteUpdate(Query);
        sql.Destructor();
    }

    public void savetodb() {
        String Query =  "INSERT INTO `" + Sql.dbName +
                        "`.`agencycaller` (`id`, `AgencyID`, `CaseHID`, `Name`, `Number`)" +
                        " values(null,?,?,?,?) ";
        //  Query += " VALUES ('" + getPoliceStn() + "', '" + getStatus() + "', '" + getForward() + "', '" + getReadableName() + "', '" + getCaseType() + "')";
        //Sql s = new Sql();
        System.out.println(Query);
        PreparedStatement stmt = sql.GetPrepareStmt(Query);
        
        try {            
            stmt.setLong(1, getAgencyID());
            stmt.setLong(2, getCaseHID());
            stmt.setString(3, getName());
            stmt.setString(4, getNumber());            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AgencyCaller.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            //   sql.ExecuteUpdate(Query);
                   
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

    public ArrayList<AgencyCaller> loadclass(String Querypart) {
        ArrayList<AgencyCaller> ac = new ArrayList<>();
        String Query = "Select * From " + Sql.dbName + ".agencycaller where " + Querypart;
        Sql sql = new Sql();
        System.out.println(Query);
        ResultSet rs = sql.ExecuteQuery(Query);
        
        try {
            while (rs.next()) {
                AgencyCaller obj = new AgencyCaller();
                obj.setId((long) rs.getDouble(1));
                obj.setAgencyID(rs.getLong(2));
                obj.setCaseHID(rs.getLong(3));
                obj.setName(rs.getString(4));                
                obj.setNumber(rs.getString(5));
                ac.add(obj);
            }
            sql.Destructor();
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ac;
    }
    
}
