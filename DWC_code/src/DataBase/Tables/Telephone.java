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
public class Telephone {

    long id, CaseHid, Number;
    String Note;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCaseHid() {
        return CaseHid;
    }

    public void setCaseHid(long CaseHid) {
        this.CaseHid = CaseHid;
    }

    public long getNumber() {
        return Number;
    }

    public void setNumber(long Number) {
        this.Number = Number;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }
    public void savetodb() throws SQLException{
    String Query = "INSERT INTO `"+Sql.dbName+"`.`telephone` (`CaseHID`, `Number`, `Note`)"+ " values(null,?,?,?) ";
    //Query += " VALUES ('"+getCaseHid()+"', '"+getNumber()+"', '"+getNote()+"')";
    Sql sql = new Sql();
    PreparedStatement stmt=sql.GetPrepareStmt(Query);
       
        stmt.setLong(1,getCaseHid());
        stmt.setLong(2,getNumber());
        stmt.setString(3,getNote());

    //sql.ExecuteUpdate(Query);
        stmt.executeUpdate();
    ResultSet rs = sql.ExecuteQuery("Select last_insert_id();");
        try {
            if(rs.next()){
            long insertid = Long.valueOf(rs.getLong(1));
            this.setId(insertid);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
    sql.Destructor();
    } 

    
    public ArrayList<Telephone> loadclass(String Querypart) {
        ArrayList<Telephone> tp = new ArrayList<>();
        String Query = "Select * From telephone where " + Querypart;
        Sql sql = new Sql();
        System.out.println(Query);
        ResultSet rs = sql.ExecuteQuery(Query);
        try {
            while (rs.next()) {
                Telephone obj = new Telephone();
                obj.setId(rs.getLong(1));
                obj.setCaseHid(rs.getInt(2));
                obj.setNumber((long) rs.getDouble(3));
                obj.setNote(rs.getString(4));
                tp.add(obj);
            }
            sql.Destructor();
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tp;
    }
}
