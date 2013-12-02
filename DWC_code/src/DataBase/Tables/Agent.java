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
 * The Agent class stores details of the Agent 
 * It Loads data from the Accused table in the database
 * for Authentication
 * 
 * <pre>
 *  Table Structure
 *      VariableName    Field       Type            NULL    KEY     EXTRA
 * 
 *      id              idAgent     int(11)         NO      PRI     auto_increment
 *      AgentID         AgentID     varchar(45)     YES			
 *      NAME            Name        varchar(45)     YES			
 *      User            User        varchar(45)     YES			
 *      PWD             Pwd         varchar(45)     YES			
 *                      Level       varchar(20)     YES			
 * 
 * </pre>
 * @author Shikhar Singhal
 */
public class Agent {
    Long id;
    String AgentID, NAME, User, PWD;


    /** 
     * @return A long Agent id value
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the Agent id
     * @param id A long value
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return A long Agent AgentID value 
     */
    public String getAgentID() {
        return AgentID;
    }

    /**
     * Sets the Agent AgentID
     * @param AgentID A long value
     */
    public void setAgentID(String AgentID) {
        this.AgentID = AgentID;
    }

    /**
     * @return A String Agent NAME value
     */
    public String getNAME() {
        return NAME;
    }

    /**
     * Sets Agent NAME value
     * @param NAME A String value
     */
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    /**
     * @return A String Agent Username value
     */
    public String getUser() {
        return User;
    }

    /**
     * Sets Agent Username value
     * @param User A String value
     */
    public void setUser(String User) {
        this.User = User;
    }

    /**
     * @return A String password value 
     */
    public String getPWD() {
        return PWD;
    }

    /**
     * Sets agent Password value
     * @param PWD A String value
     */
    public void setPWD(String PWD) {
        this.PWD = PWD;
    }
    
    /**
     * Loads specific entries in Agent list by Querrying the Querypart on the agent table
     * @param Querypart A String - Postfix part of the query statement - "Select * From agent where "
     * @return an ArrayList of Agent objects
     * @throws SQLException If any SQL related exception occurs
     */
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
