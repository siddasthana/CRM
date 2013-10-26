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
public class Accused {
    long id, CaseID, Phone;
    String Name, Address, Fir,DD;
    Boolean challan=false, judgement=false;
    Sql sql = new Sql();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCaseID() {
        return CaseID;
    }

    public void setCaseID(long CaseID) {
        this.CaseID = CaseID;
    }

    public long getPhone() {
        return Phone;
    }

    public void setPhone(long Phone) {
        this.Phone = Phone;
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

    public String getFir() {
        return Fir;
    }

    public void setFir(String Fir) {
        this.Fir = Fir;
    }
    
    public String getDD() {
        return DD;
    }

    public void setDD(String DD) {
        this.DD = DD;
    }
    public Boolean getChallan() {
        return challan;
    }

    public void setChallan(Boolean Challan) {
        this.challan = Challan;
    }
    public Boolean getJudgement() {
        return judgement;
    }

    public void setJudgement(Boolean judgement) {
        this.judgement = judgement;
    }
    
    
    
    
    
    public void savetodb(){
        
    String Query = "INSERT INTO `"+Sql.dbName+"`.`accused` (`idAccused`, `Caseid`, `Name`, `Phone`, `Address`, `Fir`)" + " values(null,?,?,?,?,?) ";
    //Query += " VALUES ('"+getCaseID()+"', '"+getName()+"', '"+getPhone()+"', '"+getAddress()+"', '"+getFir()+"')";
   // Sql sql = new Sql();
    PreparedStatement stmt=sql.GetPrepareStmt(Query); 
    try
    {
        stmt.setLong(1,getCaseID());
        stmt.setString(2,getName());
        stmt.setLong(3,getPhone());
        stmt.setString(4,getAddress());
        stmt.setString(5,getFir());
        stmt.executeUpdate();
    }
     catch(SQLException e)
   {
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
  public void updatedb() {
        String Query = "UPDATE `accused`  SET Name =?,`Phone`=?, `Address`=?, WHERE CaseId = ? ";
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