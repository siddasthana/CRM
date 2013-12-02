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
public class Agency {
    long id;
    String Name, Address, Landline, Mobile;
    Sql sql = new Sql();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getLandline() {
        return Landline;
    }

    public void setLandline(String Landline) {
        this.Landline = Landline;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }
    
    

    public void updatedb() {
        String Query =  
                " Update `" + Sql.dbName + "`.`agency` Set" +
                " Name='" + getName()+ "'," +
                " Address='" + getAddress()+ "'," +
                " Landline='" + getLandline()+ "'," +
                " Mobile='" + getMobile()+ "'" +
                " where id=" + (int) getId();
        //Sql sql = new Sql();
        System.out.println(Query);
        sql.ExecuteUpdate(Query);
        sql.Destructor();
    }

    public void savetodb() {
        String Query =  
                "INSERT INTO `" + Sql.dbName +
                "`.`agency` (`id`, `Name`, `Address`, `Landline`, `Mobile`)" +
                " values(null,?,?,?,?) ";
        //  Query += " VALUES ('" + getPoliceStn() + "', '" + getStatus() + "', '" + getForward() + "', '" + getReadableName() + "', '" + getCaseType() + "')";
        //Sql s = new Sql();
        System.out.println(Query);
        PreparedStatement stmt = sql.GetPrepareStmt(Query);
        try {            
            stmt.setString(1, getName());
            stmt.setString(2, getAddress());
            stmt.setString(3, getLandline());
            stmt.setString(4, getMobile());            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Agency.class.getName()).log(Level.SEVERE, null, ex);
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

    public ArrayList<Agency> loadclass(String Querypart) {
        ArrayList<Agency> ag = new ArrayList<>();
        String Query = "Select * From " + Sql.dbName + ".agency where " + Querypart;
        Sql sql = new Sql();
        System.out.println(Query);
        ResultSet rs = sql.ExecuteQuery(Query);
        
        try {
            while (rs.next()) {
                Agency obj = new Agency();
                
                obj.setId((long) rs.getDouble(1));
                obj.setName(rs.getString(2));
                obj.setAddress(rs.getString(3));
                obj.setLandline(rs.getString(4));
                obj.setMobile(rs.getString(5));                
                ag.add(obj);

            }
            sql.Destructor();
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ag;
    }
    
}
