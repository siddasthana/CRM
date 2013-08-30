/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import View.Dlg_distressWoman;
import static View.Dlg_distressWoman.infoBox;
import View.Global;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class OutBound {
    public void connect(String Number){
             String Query = "Select state, contact from agents where name='"+Global.AgentID+"'";
        Sql sql = new Sql();
        ResultSet rs;
        rs = sql.ExecuteQuery(Query);
        try {
            if(rs.next()){
            if(rs.getString(1).equalsIgnoreCase("In a queue call"))     
            {
                long confname = new Date().getTime()/100;
                Query = "Select CallUUID from call_scheduling where AgentID='"+Global.AgentID+"'";
                ResultSet rst = sql.ExecuteQuery(Query);
                if(rst.next()){
                String CallUUID = rst.getString(1);
                Query = "Insert into Outbound(OutType, OutName, Number, NumberType, Status, Schedule)";
                Query += " value('conf','"+confname+"','"+Number+"','GSM','0',NOW())";
                sql.ExecuteUpdate(Query);
                Query = "Insert into Outbound(OutType, OutName, Number, NumberType, Status, Schedule)";
                Query += " value('conf','"+confname+"','"+CallUUID+"','UUID','0',NOW())";
                sql.ExecuteUpdate(Query);
                }else{
                infoBox("Something wrong with making the call", "Delhi Women Cell");
                
                }
            }else{
                if(true){
                long confname = new Date().getTime()/100;
                Query = "Insert into Outbound(OutType, OutName, Number, NumberType, Status, Schedule)";
                Query += " value('out','"+confname+"','"+Number+"','GSM','0',NOW())";
                sql.ExecuteUpdate(Query);
                String contact = rs.getString(2);
                Query = "Insert into Outbound(OutType, OutName, Number, NumberType, Status, Schedule)";
                Query += " value('out','"+confname+"','"+contact.substring(contact.length()-4)+"','agent','0',NOW())";
                sql.ExecuteUpdate(Query);
                }else{
                infoBox("Currently can not make call", "Delhi Women Cell");
                }
            }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dlg_distressWoman.class.getName()).log(Level.SEVERE, null, ex);
        }
    sql.Destructor();
    }
}
