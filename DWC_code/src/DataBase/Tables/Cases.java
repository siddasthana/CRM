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
public class Cases {

    long id;
    String PoliceStn, Status, Forward, ReadableName, CaseType;

    public String getCaseType() {
        return CaseType;
    }

    public void setCaseType(String CaseType) {
        this.CaseType = CaseType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPoliceStn() {
        return PoliceStn;
    }

    public void setPoliceStn(String PoliceStn) {
        this.PoliceStn = PoliceStn;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getForward() {
        return Forward;
    }

    public void setForward(String Forward) {
        this.Forward = Forward;
    }

    public String getReadableName() {
        return ReadableName;
    }

    public void setReadableName(String ReadableName) {
        this.ReadableName = ReadableName;
    }

    public void updatedb() {
        String Query = "Update `" + Sql.dbName + "`.`case` Set ";
        Query += "PoliceStation='" + getPoliceStn() + "'";
        Query += ", Status='" + getStatus() + "'";
        Query += ", Forward='" + getForward() + "'";
        Query += ", ReadableName='" + getReadableName() + "'";
        Query += ", CaseType='" + getCaseType() + "'";
        Query += " where idCase=" + (int) getId();
        Sql sql = new Sql();
        System.out.println(Query);
        sql.ExecuteUpdate(Query);
        sql.Destructor();
    }

    public void savetodb() throws SQLException {
        String Query = "INSERT INTO `" + Sql.dbName + "`.`case` (`idCase`, `PoliceStation`, `Status`, `Forward`, `ReadableName`, `CaseType`)"+ " values(null,?,?,?,?,?) ";
      //  Query += " VALUES ('" + getPoliceStn() + "', '" + getStatus() + "', '" + getForward() + "', '" + getReadableName() + "', '" + getCaseType() + "')";
        Sql sql = new Sql();
        System.out.println(Query);
        PreparedStatement stmt=sql.GetPrepareStmt(Query);
        Cases c = new Cases();
        stmt.setString(1,c.getPoliceStn());
        stmt.setString(2,c.getStatus());
        stmt.setString(3,c.getForward());
        stmt.setString(4,c.getStatus());
        stmt.setString(5,c.getForward());
        //   sql.ExecuteUpdate(Query);
        stmt.executeUpdate();
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
                cs.add(obj);

            }
            sql.Destructor();
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cs;
    }
}
