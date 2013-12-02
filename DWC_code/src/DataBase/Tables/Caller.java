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
 * The Caller class stores details of the Caller 
 * It Inserts, Updates and Loads data from the caller table in the database
 * 
 * <pre>
 *  Table Structure
 *      VariableName    Field       Type            NULL    KEY     EXTRA
 * 
 *      id              idCaller    bigint(20)      NO      PRI     auto_increment
 *      Name            Name        varchar(45)     YES			
 *      Age             Age         varchar(3)      YES			
 *      Address         Address     text            YES			
 *      callid          CallID      bigint(20)      YES     MUL
 * 
 * Callid references calls.CaseHID
 * @author Shikhar Singhal
 */
public class Caller {

    long id, callid;
    String Name, Age, Address;
    Sql sql = new Sql();

    /**
     * @return  A long Caller id value
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the Caller id value
     * @param id A long value
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return  A long Caller callid value
     */
    public long getCallid() {
        return callid;
    }

    /**
     * Sets the Caller callid value
     * @param callid A long value
     */
    public void setCallid(long callid) {
        this.callid = callid;
    }

    /**
     * @return A String Caller Name value
     */
    public String getName() {
        return Name;
    }

    /**
     * Sets the Caller Name value
     * @param Name A String value
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return  A String Caller Age value
     */
    public String getAge() {
        return Age;
    }

    /**
     * Sets the Caller Age value
     * @param Age  A String value
     */
    public void setAge(String Age) {
        this.Age = Age;
    }

    /**
     * @return  A String Caller Address value
     */
    public String getAddress() {
        return Address;
    }

    /**
     * Sets the Caller Address value
     * @param Address A String value
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * Saves a record in the caller table in the Database
     * @throws SQLException If any SQL related exception occurs
     */
    public void savetodb() {
        String Query =  
                "INSERT INTO `" +
                Sql.dbName +
                "`.`caller` (`idCaller`," +
                " `Name`," +
                " `Age`," +
                " `Address`," +
                " `CallID`)" +
                " values(null, ?, ?, ?, ?) ";
        //Query += " VALUES ('"+getName()+"', '"+getAge()+"', '"+getAddress()+"', '"+getCallid()+"');";
       // Sql sql = new Sql();
        try {
            PreparedStatement stmt = sql.GetPrepareStmt(Query);

            stmt.setString(1, getName());
            stmt.setString(2, getAge());
            stmt.setString(3, getAddress());
            stmt.setLong(4, getCallid());
            //sql.ExecuteUpdate(Query);
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

    /**
     * Loads specific entries in Caller list by Querrying the Querypart on the caller table
     * @param Querypart A String - Postfix part of the query statement - "Select * From caller where "
     * @return an ArrayList of Caller objects
     * @throws SQLException If any SQL related exception occurs
     */
    public ArrayList<Caller> loadclass(String Querypart) {
        ArrayList<Caller> cl = new ArrayList<>();
        String Query = "Select * From caller where " + Querypart;
        System.out.println(Query);
        //Sql sql = new Sql();
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

    /**
     * Updates The Caller Details to the caller table
     * @throws SQLException If any SQL related exception occurs
     */
    public void updatedb() {
            // String Query = "Update `" + Sql.dbName + "`.`caller` Set "
            //       + "Name='" + getName() + "', `Age`='" + getAge() + "', `Address`='" + getAddress() + "', `CallID`='" + getCallid() + "' where idCaller=" + getId();
        String Query = "UPDATE `caller`  SET Name = ?, Age = ?, Address = ?, CallID = ? WHERE idCaller = ?";
            // Sql sql = new Sql();
        PreparedStatement stmt = sql.GetPrepareStmt(Query);
        
        try{
            stmt.setString(1, getName());
            stmt.setString(2, getAge());
            stmt.setString(3, getAddress());
            stmt.setLong(4, getCallid());
            stmt.setLong(5, getId());
            //sql.ExecuteUpdate(Query);
            stmt.executeUpdate();
            // sql.ExecuteUpdate(Query);
        } catch(SQLException e){
            System.out.println(e);
        }
    }
}