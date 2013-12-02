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
 * This class Sets Global Variable
 * Also contains JavaDateToMysql() to convert Java format date to sql format
 * @author Shikhar Singhal
 */
public class Global {

    public static String AgentID;
    public static String AgentPK;
    public static String dbName = "womencell";
    public static String Server_IP = "10.128.83.112";
    public static String AgentLevel = "";

    /**
     * Converts Java Date format to SQL Date format
     * @param dt A Date value
     * @return A String CurrentTime in sql compatible date format
     */
    public static String JavaDateToMysql(Date dt) {
        //java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(dt);
        return currentTime;
    }
}
