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
public class Caller {

    long id, callid;
    String Name, Age, Address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCallid() {
        return callid;
    }

    public void setCallid(long callid) {
        this.callid = callid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void savetodb() {
        String Query = "INSERT INTO `" + Sql.dbName + "`.`caller` (`idCaller`, `Name`, `Age`, `Address`, `CallID`)" + " values(null,?,?,?,?) ";
        //Query += " VALUES ('"+getName()+"', '"+getAge()+"', '"+getAddress()+"', '"+getCallid()+"');";
        Sql sql = new Sql();
        try {
            PreparedStatement stmt = sql.GetPrepareStmt(Query);

            stmt.setString(1, getName());
            stmt.setString(2, getAge());
            stmt.setString(3, getAddress());
            stmt.setLong(4, getCallid());
            //      sql.ExecuteUpdate(Query);
            stmt.executeUpdate();
            ResultSet rs = sql.ExecuteQuery("Select last_insert_id();");

            if (rs.next()) {
                long insertid = Long.valueOf(rs.getLong(1));
                this.setId(insertid);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql.Destructor();
    }

    public ArrayList<Caller> loadclass(String Querypart) {
        ArrayList<Caller> cl = new ArrayList<>();
        String Query = "Select * From caller where " + Querypart;
        System.out.println(Query);
        Sql sql = new Sql();
        ResultSet rs = sql.ExecuteQuery(Query);
        try {
            while (rs.next()) {
                Caller obj = new Caller();
                obj.setId((long) rs.getDouble(1));
                obj.setName(rs.getString(2));
                obj.setAge(rs.getString(3));
                obj.setAddress(rs.getString(4));
                obj.setCallid((long) rs.getDouble(5));
                cl.add(obj);

            }
            sql.Destructor();
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cl;
    }

    public void updatedb() {
        String Query = "Update `" + Sql.dbName + "`.`caller` Set "
                + "Name='" + getName() + "', `Age`='" + getAge() + "', `Address`='" + getAddress() + "', `CallID`='" + getCallid() + "' where idCaller=" + getId();

        Sql sql = new Sql();
        sql.ExecuteUpdate(Query);
    }
}
