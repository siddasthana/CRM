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
public class Directory {

    long id;
    String District, Area, Service, Info, Number;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String District) {
        this.District = District;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }

    public String getService() {
        return Service;
    }

    public void setService(String Service) {
        this.Service = Service;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String Info) {
        this.Info = Info;
    }

    public ArrayList<Directory> loadclass(String Querypart) {
        ArrayList<Directory> dt = new ArrayList<>();
        String Query = "Select * From directory where " + Querypart;
        Sql sql = new Sql();
        System.out.println(Query);
        ResultSet rs = sql.ExecuteQuery(Query);
        try {
            while (rs.next()) {
                Directory obj = new Directory();
                obj.setId(rs.getInt(1));
                obj.setDistrict(rs.getString(2));
                obj.setArea(rs.getString(3));
                obj.setService(rs.getString(4));
                obj.setInfo(rs.getString(5));
                obj.setNumber(rs.getString("NUMBER"));
                dt.add(obj);            
            }
            sql.Destructor();
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dt;
    }
}
