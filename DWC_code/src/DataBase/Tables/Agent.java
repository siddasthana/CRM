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
public class Agent {
    Long id;
    String AgentID, NAME, User, PWD;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgentID() {
        return AgentID;
    }

    public void setAgentID(String AgentID) {
        this.AgentID = AgentID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPWD() {
        return PWD;
    }

    public void setPWD(String PWD) {
        this.PWD = PWD;
    }
      public ArrayList<Agent> loadclass(String Querypart){
    ArrayList<Agent> ac = new ArrayList<>();
        String Query = "Select * From agent where " + Querypart;
        Sql sql = new Sql();
          System.out.println(Query);
        ResultSet rs = sql.ExecuteQuery(Query);
        try {
            while(rs.next()){
        Agent obj = new Agent();
                obj.setId(rs.getLong(1));
                obj.setAgentID(rs.getString(2));
                obj.setNAME(rs.getString(3));
                obj.setUser(rs.getString(4));
                obj.setPWD(rs.getString(5));
                ac.add(obj);
            }
            sql.Destructor();
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
    return ac;
    }
}
