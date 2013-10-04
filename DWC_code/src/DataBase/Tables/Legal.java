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
 * @author Lenovo
 */
public class Legal {

    long id, CaseID;
    String Fir, DD;
    Boolean challan = false, judgement = false;
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

    public void savetodb() {

        String Query = "INSERT INTO `" + Sql.dbName + "`.`legal` (`id`, `Caseid`, `DD`, `Fir`, `Challan`, `Judgement`)" + " values(null,?,?,?,?,?) ";
        //Query += " VALUES ('"+getCaseID()+"', '"+getName()+"', '"+getPhone()+"', '"+getAddress()+"', '"+getFir()+"')";
        // Sql sql = new Sql();
        PreparedStatement stmt = sql.GetPrepareStmt(Query);
        try {
            stmt.setLong(1, getCaseID());
            stmt.setString(2, getDD());
            stmt.setString(3, getFir());
            stmt.setBoolean(4, getChallan());
            stmt.setBoolean(5, getJudgement());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        //sql.ExecuteUpdate(Query);
        // sql.ExecuteUpdate(Query);
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

    public ArrayList<Legal> loadclass(String Querypart) {
        ArrayList<Legal> le = new ArrayList<>();
        String Query = "Select * From legal where " + Querypart;
        // Sql sql = new Sql();
        ResultSet rs = sql.ExecuteQuery(Query);
        try {
            while (rs.next()) {
                Legal obj = new Legal();
                obj.setId(rs.getInt(1));
                obj.setCaseID(rs.getInt(2));
                obj.setDD(rs.getString(3));
                obj.setFir(rs.getString(4));
                obj.setChallan(rs.getBoolean(5));
                obj.setJudgement(rs.getBoolean(6));
                le.add(obj);
            }
            sql.Destructor();
        } catch (SQLException ex) {
            Logger.getLogger(Telephone.class.getName()).log(Level.SEVERE, null, ex);
        }
        return le;
    }

    public void updatedb() {
        String Query = "UPDATE `legal`  SET DD = ? , Fir = ?, Challan= ? , Judgement = ? WHERE CaseId = ? ";
        PreparedStatement stmt1 = sql.GetPrepareStmt(Query);
        System.out.println("Querry Legal Update" + Query);
        try {
            stmt1.setString(1, getDD());
            stmt1.setString(2, getFir());
            stmt1.setBoolean(3, getChallan());
            stmt1.setBoolean(4, getJudgement());
            stmt1.setLong(5, getId());
            stmt1.setLong(6, getCaseID());
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