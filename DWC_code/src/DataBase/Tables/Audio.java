/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase.Tables;

import DataBase.Sql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Audio {
    Long id, Callid;
            String Filepath, Number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCallid() {
        return Callid;
    }

    public void setCallid(Long Callid) {
        this.Callid = Callid;
    }

    public String getFilepath() {
        return Filepath;
    }

    public void setFilepath(String Filepath) {
        this.Filepath = Filepath;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }
                  public ArrayList<Audio> loadclass(String Querypart){
    ArrayList<Audio> au = new ArrayList<>();
        String Query = "Select * From audio where " + Querypart;
        Sql sql = new Sql();
          System.out.println(Query);
        ResultSet rs = sql.ExecuteQuery(Query);
        try {
            while(rs.next()){
        Audio obj = new Audio();
                obj.setId(rs.getLong(1));
                obj.setFilepath(rs.getString(2));
                obj.setNumber(rs.getString(3));
                obj.setCallid(rs.getLong(4));
                au.add(obj);
            }
            sql.Destructor();
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
    return au;
    }
}
