/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DataBase.Tables.Cases;
import View.Elements.Pnl_CaseElement;
import java.util.Date;
import javax.swing.JComboBox;

/**
 *
 * @author admin
 */
public class Global {

    public static String AgentID;
    public static String AgentPK;
    public static String dbName = "womencell";
    public static String Server_IP = "10.128.83.112";
    public static String AgentLevel = "";

    public static String JavaDateToMysql(Date dt) {
        //java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(dt);
        return currentTime;
    }
}
