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
 * The Cases class stores details of the Cases
 * It Inserts, Updates and Loads data from the case table in the database
 * 
 * <pre>
 *  Table Structure
 *      VariableName    Field           Type            NULL    KEY     EXTRA
 * 
 * 
 */
public class Cases {

    long id;
    String PoliceStn, Status, Forward, ReadableName, CaseType;
    Sql sql = new Sql();
    
    /**
     * @return A String Cases CaseType value
     */
    public String getCaseType() {
        return CaseType;
    }

    /**
     * Sets the Cases CaseType value
     * @param CaseType A String value
     */
    public void setCaseType(String CaseType) {
        this.CaseType = CaseType;
    }

    /**
     * @return A long Cases id value
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the Cases id value
     * @param id A long value
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return A String Cases PliceStn name value
     */
    public String getPoliceStn() {
        return PoliceStn;
    }

    /**
     * Sets the Cases PoliceStn name value
     * @param PoliceStn A String value
     */
    public void setPoliceStn(String PoliceStn) {
        this.PoliceStn = PoliceStn;
    }

    /**
     * @return A String Cases Status value
     */
    public String getStatus() {
        return Status;
    }

    /**
     * Sets the Cases Status value
     * @param Status A String value
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }

    /**
     * @return A String Cases Forward value
     */
    public String getForward() {
        return Forward;
    }

    /**
     * Sets the Cases Forward value
     * @param Forward A String value
     */
    public void setForward(String Forward) {
        this.Forward = Forward;
    }

    /**
     * @return A String Cases ReadableName value
     */
    public String getReadableName() {
        return ReadableName;
    }

    /**
     * Sets the Cases ReadableName value
     * @param ReadableName A String Value
     */
    public void setReadableName(String ReadableName) {
        this.ReadableName = ReadableName;
    }

    /**
     * Updates The Cases Details to the case table
     */
    public void updatedb() {
        String Query =  "Update `" + Sql.dbName + "`.`case` Set " +
                        "PoliceStation='" + getPoliceStn() + "'" +
                        ", Status='" + getStatus() + "'" +
                        ", Forward='" + getForward() + "'" +
                        ", ReadableName='" + getReadableName() + "'" +
                        ", CaseType='" + getCaseType() + "'" +
                        " where idCase=" + (int) getId();
        //Sql sql = new Sql();
        System.out.println(Query);
        sql.ExecuteUpdate(Query);
        sql.Destructor();
    }

    /**
     * Saves a record into case table of Database
     * @throws SQLException If any SQL related exception occurs
     */
    public void savetodb() {
        String Query =  
                "INSERT INTO `" + Sql.dbName +
                "`.`case` (`idCase`, `PoliceStation`, `Status`, `Forward`, `ReadableName`, `CaseType`)" +
                " values(null,?,?,?,?,?) ";
        //  Query += " VALUES ('" + getPoliceStn() + "', '" + getStatus() + "', '" + getForward() + "', '" + getReadableName() + "', '" + getCaseType() + "')";
        //Sql s = new Sql();
        System.out.println(Query);
        PreparedStatement stmt = sql.GetPrepareStmt(Query);
        try {            
            stmt.setString(1, getPoliceStn());
            stmt.setString(2, getStatus());
            stmt.setString(3, getForward());
            stmt.setString(4, getReadableName());
            stmt.setString(5, getCaseType());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Cases.class.getName()).log(Level.SEVERE, null, ex);
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

    /**
     * Loads specific entries in Cases list by Querrying the Querypart on the case table
     * @param Querypart A String - Postfix part of the query statement - "Select * From case where "
     * @return an ArrayList of Cases objects
     * @throws SQLException If any SQL related exception occurs
     */
    public ArrayList<Cases> loadclass(String Querypart) {
        ArrayList<Cases> cs = new ArrayList<>();
        String Query = "Select * From " + Sql.dbName + ".case where " + Querypart;
        Sql sql = new Sql();
        System.out.println(Query);
        ResultSet rs = sql.ExecuteQuery(Query);
        
        try {
            while (rs.next()) {
                Cases obj = new Cases();
                
                obj.setId((long) rs.getDouble(1));
                obj.setPoliceStn(rs.getString(2));
                obj.setStatus(rs.getString(3));
                obj.setForward(rs.getString(4));
                obj.ReadableName = rs.getString(5);
                obj.setCaseType(rs.getString(6));
                cs.add(obj);

            }
            sql.Destructor();
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cs;
    }
}
