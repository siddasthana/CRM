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
 * The Accused class stores details of the Accused 
 * It Inserts, Updates and Loads data from the Accused table in the database
 * 
 * <pre>
 *  Table Structure
 *      VariableName    Field           Type                NULL    KEY     EXTRA
 * 
 *      id              idAccused       bigint(20)          NO      PRI     auto_increment
 *      CaseID          Caseid          bigint(20)          YES     MUL		
 *      Name            Name            varchar(45)         YES			
 *      Phone           Phone           int(11)             YES			
 *      Address         Address         varchar(45)         YES			
 *      Fir             Fir             varchar(45)         YES			
 * CaseID references Cases.id
 * <pre>
 * @author Shikhar Singhal
 */
public class Accused {
    long id, CaseID, Phone;
    String Name, Address, Fir,DD;
    Boolean challan=false, judgement=false;
    Sql sql = new Sql();
    
    /**
     * @return  A long Accused id value
     */
    public long getId() {
        return id;
    }
    
    /**
     * Sets the Accused id
     * @param id A long value
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return  A long Accused CaseID value
     */
    public long getCaseID() {
        return CaseID;
    }

    /**
     * Sets the Accused CaseID
     * @param CaseID A long Accused CaseID value
     */
    public void setCaseID(long CaseID) {
        this.CaseID = CaseID;
    }

    /**
     * @return  A long Accused Phone number value
     */
    public long getPhone() {
        return Phone;
    }

    /**
     * Sets the Accused Phone number
     * @param Phone a long Accused Phone number value
     */
    public void setPhone(long Phone) {
        this.Phone = Phone;
    }

    /**
     * @return A String Accused Name value
     */
    public String getName() {
        return Name;
    }

    /**
     * Sets the Accused Name
     * @param Name A String Accused Name value
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return A String Accused Address value
     */
    public String getAddress() {
        return Address;
    }

    /**
     * Sets the Accused Address
     * @param Address A String Accused Address value
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return A String Accused FIR value
     */
    public String getFir() {
        return Fir;
    }

    /**
     * Sets the Accused FIR
     * @param Fir A String FIR value
     */
    public void setFir(String Fir) {
        this.Fir = Fir;
    }
    
    /**
     * @return A String DD number value
     */
    public String getDD() {
        return DD;
    }

    /**
     * Sets the DD number
     * @param DD A String DD number value
     */
    public void setDD(String DD) {
        this.DD = DD;
    }
    
    /**
     * <pre><ul><ld>Returns Challan value
     *      <li>true    If Challan has been issued
     *      <li>false   If Challan has NOT been issued
     *      </ul></pre>
     * @return A Boolean challan value
     */
    public Boolean getChallan() {
        return challan;
    }

    /**
     * <pre><ul><ld>Returns Challan value
     *      <li>true    If Challan has been issued
     *      <li>false   If Challan has NOT been issued
     *      </ul></pre>
     * @param challan A Boolean challan value
     */
    public void setChallan(Boolean challan) {
        this.challan = challan;
    }
    
    /**
     * <pre><ul><ld>Returns Judgement value
     *      <li>true    If Judgement has been issued
     *      <li>false   If Judgement has NOT been issued
     *      </ul></pre>
     * @return A Boolean Judgement value
     */
    public Boolean getJudgement() {
        return judgement;
    }

    /**
     * <pre><ul><ld>Returns Judgement value
     *      <li>true    If Judgement has been issued
     *      <li>false   If Judgement has NOT been issued
     *      </ul></pre>
     * @param judgement A Boolean judgement value
     */
    public void setJudgement(Boolean judgement) {
        this.judgement = judgement;
    }
       
    /**
     * Saves a record into accused table of Database
     * @throws SQLException If any SQL related exception occurs
     */
    public void savetodb(){
        
        String Query = 
                "INSERT INTO `" +Sql.dbName +
                "`.`accused` (`idAccused`, `Caseid`, `Name`, `Phone`, `Address`, `Fir`)" +
                " values(null, ?, ?, ?, ?, ?) ";
        //Query += " VALUES ('"+getCaseID()+"', '"+getName()+"', '"+getPhone()+"', '"+getAddress()+"', '"+getFir()+"')";
        // Sql sql = new Sql();
        PreparedStatement stmt=sql.GetPrepareStmt(Query);
        System.out.println("accused query" + Query);
        
        try
        {
            stmt.setLong(1, getCaseID());
            stmt.setString(2, getName());
            stmt.setLong(3, getPhone());
            stmt.setString(4, getAddress());
            stmt.setString(5, getFir());
            stmt.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e);
        }
        //sql.ExecuteUpdate(Query);
        // sql.ExecuteUpdate(Query);
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
 
    /**
     * Loads specific entries in Accused list by Querrying the Querypart on the accused table
     * @param Querypart A String - Postfix part of the query statement - "Select * From accused where "
     * @return an ArrayList of Accused objects
     * @throws SQLException If any SQL related exception occurs
     */
  public ArrayList<Accused> loadclass(String Querypart){
        ArrayList<Accused> ac = new ArrayList<>();
        String Query = "Select * From accused where " + Querypart;
        // Sql sql = new Sql();
        ResultSet rs = sql.ExecuteQuery(Query);
        
        try {
            while(rs.next()){
                Accused obj = new Accused();
                
                obj.setId(rs.getInt(1));
                obj.setCaseID(rs.getInt(2));
                obj.setName(rs.getString(3));
                obj.setPhone((long) rs.getDouble(4));
                obj.setAddress(rs.getString(5));
                ac.add(obj);
            }
            sql.Destructor();
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
    return ac;
    }
  
    /**
     * Updates The Accused Details to the accused table
     * @throws SQLException If any SQL related exception occurs
     */
    public void updatedb() {
        String Query = "UPDATE `accused`  SET Name =?,`Phone`=?, `Address`=? WHERE CaseId = ? ";
        PreparedStatement stmt1 = sql.GetPrepareStmt(Query);
        System.out.println("Querry Accused Update " + Query);
        
        try {
            stmt1.setString(1, getName());
            stmt1.setLong(2, getPhone());
            stmt1.setString(3, getAddress());            
            stmt1.setLong(4, getCaseID());            
            stmt1.executeUpdate();
        
        } catch (SQLException e) {
            System.out.println(e);
        }
        //Query += " VALUES ('"+getCaseHID()+"', '"+getStartTime()+"', '"+getDuration()+"', '"+getQueueTime()+"', '"+getAgentId()+"', '"+getNumber()+"', '"+getBound()+"')";

        System.out.println(Query);
        //sql.ExecuteUpdate(Query);
        sql.Destructor();
    }
}
