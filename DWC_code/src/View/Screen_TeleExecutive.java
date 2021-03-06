/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DataBase.LoadData_DistressWoman;
import DataBase.Sql;
import DataBase.Tables.Accused;
import DataBase.Tables.Caller;
import DataBase.Tables.Calls;
import DataBase.Tables.CaseHistory;
import DataBase.Tables.Cases;
import DataBase.Tables.Reminder;
import DataBase.Tables.Telephone;
import View.Elements.Pnl_AudioElement;
import static View.LoginScreen.infoBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.jdesktop.swingx.JXSearchField;
import temp.Design;

/**
 * The Screen_TeleExecutive class contains methods to handle incoming calls
 * It also provides methods to view Case Reports and Forwarded Cases(For supervisors only)
 * @author admin
 */
public class Screen_TeleExecutive extends javax.swing.JInternalFrame {

    Timer timer, ReminderTimer;
    public ParentForm pf;
    public Dlg_distressWoman Dlg_distressWoman;
    Player mp3player = null;

    /**
     * Constructor
     * invoked after Agent login
     * Checks for incoming calls and reminders periodically
     */
    public Screen_TeleExecutive() {
        initComponents();
        ActionListener actionListener, Reminder;
        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                check_newCall();
            }
        };
        timer = new Timer(200, actionListener);
        timer.setCoalesce(true);
        timer.start();
        Reminder = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check_alarm();
            }
        };
        if (Global.AgentLevel.equals("supervisor")) {
            ReminderTimer = new Timer(12000, Reminder);
            ReminderTimer.setCoalesce(true);
            ReminderTimer.start();
        } else {
            System.out.println("Alaram Not enabled" + Global.AgentLevel);
        }
    }

    /**
     * Checks Reminder table in the Database to check for reminders
     * Invokes A new thread to Manage The playfile
     * @throws SQLException
     */
    private void check_alarm() {
        System.out.println("Checking For Alarms ");
        Sql sql = new Sql();
        DataBase.Tables.Reminder r = new Reminder();

        ResultSet rs = sql.ExecuteQuery("Select * From Reminder where Status='0' AND AlarmTime <= DATE_ADD(NOW(), INTERVAL 2 MINUTE) AND AlarmTime >= DATE_SUB(NOW(), INTERVAL 2 MINUTE ) ");
        try {
            if (rs.next()) {
                playfile pfile = new playfile();
                Thread evenThread = new Thread(pfile, "evenThread");
                evenThread.start();
                infoBox("Reminder for Case :" + rs.getString(3), "Delhi Women Cell");
                evenThread.stop();
                r.setId(rs.getInt("id"));
                r.updatedb();
                

            }

        } catch (SQLException ex) {
        }
    }

    /**
     * Checks new calls in the call_scheduling table in the database
     * invokes CheckagentStatus()
     * @throws SQLException
     */
    private void check_newCall() {
        //               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Checking new calls");
        pf = (ParentForm) this.getParent().getParent().getParent().getParent().getParent();
        Sql sql = new Sql();
        ResultSet rs = sql.ExecuteQuery("Select Serving From call_scheduling where AgentID= '" + pf.AgentId + "' and Status='Free'");
        try {
            if (rs.next()) {
                if (!rs.getString(1).equals("")) {
                    Lbl_callstatus.setText("Incoming Call from ");
                    Lbl_number.setText(rs.getString(1).toString());
                    Btn_ProcessCall.setEnabled(true);
                    timer.setDelay(1500);
                } else {
                    Lbl_callstatus.setText("Waiting for incoming call..");
                    timer.setDelay(200);
                    Lbl_number.setText("XXXXXXXXX");
                    Btn_ProcessCall.setEnabled(false);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Screen_TeleExecutive.class.getName()).log(Level.SEVERE, null, ex);
        }
        CheckagentStatus();
        sql.Destructor();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Lbl_callstatus = new javax.swing.JLabel();
        Lbl_number = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Btn_ProcessCall = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        CmbBx_AgentStatus = new javax.swing.JComboBox();
        Btn_CaseReports = new javax.swing.JButton();
        Btn_FrwdedCase = new javax.swing.JButton();
        Btn_AnsConfirm = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        Lbl_callstatus.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Lbl_callstatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Lbl_callstatus.setText("Waiting for Incoming Call...");

        Lbl_number.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Lbl_number.setForeground(new java.awt.Color(255, 51, 51));
        Lbl_number.setText("XXXXXXXXXXXX");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 255, 255), null, null));
        jPanel2.setEnabled(false);

        Btn_ProcessCall.setBackground(new java.awt.Color(0, 255, 255));
        Btn_ProcessCall.setText("Process Current Call");
        Btn_ProcessCall.setEnabled(false);
        Btn_ProcessCall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ProcessCallActionPerformed(evt);
            }
        });

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jRadioButton1.setText("Woman in Distress");

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jRadioButton2.setText("Advice & Information Seeking");

        jRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jRadioButton3.setText("Men in Distress");

        jRadioButton4.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jRadioButton4.setText("Blank & Irrelevant");

        jRadioButton5.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jRadioButton5.setText("Agency or Individual");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(Btn_ProcessCall, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButton1)
                        .addGap(10, 10, 10)
                        .addComponent(jRadioButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5))
                .addGap(18, 18, 18)
                .addComponent(Btn_ProcessCall)
                .addContainerGap())
        );

        CmbBx_AgentStatus.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        CmbBx_AgentStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Available", "On Break", "Logged Out" }));
        CmbBx_AgentStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbBx_AgentStatusActionPerformed(evt);
            }
        });

        Btn_CaseReports.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Btn_CaseReports.setText("Case Reports");
        Btn_CaseReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_CaseReportsActionPerformed(evt);
            }
        });

        Btn_FrwdedCase.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Btn_FrwdedCase.setText("Forwarded Cases");
        Btn_FrwdedCase.setEnabled(false);
        Btn_FrwdedCase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_FrwdedCaseActionPerformed(evt);
            }
        });

        Btn_AnsConfirm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Btn_AnsConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/Dial.png"))); // NOI18N
        Btn_AnsConfirm.setText("Unlock Sheet!!");
        Btn_AnsConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AnsConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(Lbl_callstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(Lbl_number, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(383, 383, 383))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(CmbBx_AgentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129)
                        .addComponent(Btn_AnsConfirm)
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btn_FrwdedCase)
                    .addComponent(Btn_CaseReports, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl_callstatus)
                    .addComponent(Lbl_number, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_CaseReports, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_FrwdedCase, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_AnsConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(346, 346, 346))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(CmbBx_AgentStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Invokes Dlg_distressWoman if Woman in distress is selected
     * @param evt 
     * @throws SQLException
     */
    private void Btn_ProcessCallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ProcessCallActionPerformed
        // TODO add your handling code here:

        Dlg_distressWoman = new Dlg_distressWoman(pf, closable);
        Sql sql = new Sql();
        ResultSet rs = sql.ExecuteQuery("Select Serving, TextualDate, CallUUID From call_scheduling where AgentID='" + pf.AgentId + "' and Status='Ans' or Status='Finished'");
        try {
            if (rs.next()) {
                pf.Serving = rs.getString(1);
                ((Dlg_distressWoman) Dlg_distressWoman).TextualDate = rs.getString(2);
                ((Dlg_distressWoman) Dlg_distressWoman).UUID = rs.getString(3);
                System.out.println("TextualDate "+rs.getString(2));
                System.out.println("UUID "+rs.getString(3));
            } else {
                infoBox("Please answer the call before you can proceed!!", "Delhi Woman Cell");
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Screen_TeleExecutive.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql.Destructor();
        if (jRadioButton1.isSelected()) {

            populatingcaller = true;
            LoadData_DistressWoman LD_DW = new LoadData_DistressWoman(this);
            // Dlg_distressWoman.setSize(pf.getSize());
            ((Dlg_distressWoman) Dlg_distressWoman).jPanel11.setSize(((Dlg_distressWoman) Dlg_distressWoman).jPanel11.getPreferredSize());
            Dlg_distressWoman.setSize(Dlg_distressWoman.getPreferredSize());

            Dlg_distressWoman.show(true);
//            SrchFld_Complaint.getPopupButton().doClick();
            //          SrchFld_PoliceStne.getPopupButton().doClick();

        } else if (jRadioButton2.isSelected()) {
            SaveData("Advice");
        } else if (jRadioButton3.isSelected()) {
            SaveData("Men");
        } else if (jRadioButton4.isSelected()) {
            SaveData("Blank and Irrelevant");
        }
        else if (jRadioButton5.isSelected()) {
            Dlg_Agency d = new Dlg_Agency(pf, closable);
            d.getTxt_CallerPhone().setText(pf.Serving);
            d.getSrchFld_Complaint().disable();
            ((Dlg_Agency) d).jPanel11.setSize(((Dlg_Agency) d).jPanel11.getPreferredSize());
            d.loadelement();
            d.setSize(d.getPreferredSize());

            d.show(true);
        }
    }//GEN-LAST:event_Btn_ProcessCallActionPerformed

    /**
     * Updates Agent Status
     * Starts timer if Status = "Available"
     * else stops timer
     * @param evt 
     */
    private void CmbBx_AgentStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbBx_AgentStatusActionPerformed
        // TODO add your handling code here:
        Sql sql = new Sql();
        String Query = "update agents Set Status='" + CmbBx_AgentStatus.getSelectedItem().toString() + "' where name= '" + pf.AgentId + "'";
        System.out.println(Query);
        sql.ExecuteUpdate(Query);
        sql.Destructor();
        if (CmbBx_AgentStatus.getSelectedItem().toString().equals("Available")) {
            if (!timer.isRunning()) {
                timer.setDelay(200);
                timer.start();
            }
        } else {
            if (timer.isRunning()) {
                timer.stop();
            }
        }
    }//GEN-LAST:event_CmbBx_AgentStatusActionPerformed

    /**
     * Invokes Screen_CaseReports
     * @param evt 
     */
    private void Btn_CaseReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_CaseReportsActionPerformed
        // TODO add your handling code here:
        Screen_CaseReports sc = new Screen_CaseReports();
        //       this.getParent().add(sc);
        sc.show();
    }//GEN-LAST:event_Btn_CaseReportsActionPerformed

    /**
     * @return Returns Btn_FrwdedCase
     */
    public JButton getBtn_FrwdedCase() {
        return Btn_FrwdedCase;
    }

    /**
     * Sets Btn_FrwdedCase value
     * @param Btn_FrwdedCase A JButton value
     */
    public void setBtn_FrwdedCase(JButton Btn_FrwdedCase) {
        this.Btn_FrwdedCase = Btn_FrwdedCase;
    }

    /**
     * Invokes Screen_managers
     * @param evt 
     */
    private void Btn_FrwdedCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_FrwdedCaseActionPerformed
        // TODO add your handling code here:
        Screen_Managers sm = new Screen_Managers();
        sm.show();
    }//GEN-LAST:event_Btn_FrwdedCaseActionPerformed

    /**
     * Updates Agent Status to 'Ans' when call is answered
     * @param evt 
     */
    private void Btn_AnsConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AnsConfirmActionPerformed
        // TODO add your handling code here:
        String Query = "update call_scheduling set Status='Ans' where AgentID='" + Global.AgentID + "'";
        Sql sql = new Sql();
        sql.ExecuteUpdate(Query);
        sql.Destructor();
    }//GEN-LAST:event_Btn_AnsConfirmActionPerformed

    public static void infoBox(String infoMessage, String location) {
        JOptionPane.showMessageDialog(null, infoMessage, location, JOptionPane.INFORMATION_MESSAGE);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_AnsConfirm;
    private javax.swing.JButton Btn_CaseReports;
    private javax.swing.JButton Btn_FrwdedCase;
    private javax.swing.JButton Btn_ProcessCall;
    private javax.swing.JComboBox CmbBx_AgentStatus;
    private javax.swing.JLabel Lbl_callstatus;
    private javax.swing.JLabel Lbl_number;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    // End of variables declaration//GEN-END:variables
    boolean newcaller, newcase, newaccussed;
    public boolean populatingcaller, populatingcase, populatincasehistory;
    public ArrayList<Long> CaseHid = new ArrayList<>();
    public ArrayList<Long> CaseID = new ArrayList<>();
    public Cases cs = new Cases();

    /**
     * Saves Data for Caller, Case, CaseHistory and Accused
     * to the database tables caller, cases, case_history, accused respectively
     * The respective variables are then reset
     */
    private void SaveData() {
        Caller cl = new Caller();
        cl.setName(title);
        cl.setAge(title);
        cl.setCallid(WIDTH);
        cl.setAddress(title);
        cl.savetodb();
        if (newcase) {
            cs.setPoliceStn(title);
            cs.setReadableName(title);
            cs.setStatus(title);
            cs.setForward(title);
        }
        CaseHistory ch = new CaseHistory();
        ch.setAgentID(ALLBITS);
        ch.setAdvice(title);
        ch.setCaseID(cs.getId());
        ch.setNote(title);
        ch.setDatestamp(title);
        ch.setReffered(title);
        ch.savetodb();
        if (newaccussed) {
            Accused acd = new Accused();
            acd.setName(title);
            acd.setPhone(String.valueOf(WIDTH));
            acd.setAddress(title);
            acd.setFir(title);
            acd.setCaseID(cs.getId());
            acd.savetodb();
        }
        //Reset the variable after
        cs = new Cases();
        newcaller = false;
        newcase = false;
        newaccussed = false;
        CaseHid = new ArrayList<>();
        CaseID = new ArrayList<>();
        //  Dlg_distressWoman.
    }

    /**
     * Checks Agent status 
     * @throws SQLException
     */
    private void CheckagentStatus() {
        Sql sql = new Sql();        
        ResultSet rs = sql.ExecuteQuery("Select Status From agents where name= '" + pf.AgentId + "'");
        try {
            if (rs.next()) {
                if (!rs.getString(1).equals("")) {
                    setSelectedValue(CmbBx_AgentStatus, rs.getString(1));

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Screen_TeleExecutive.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql.Destructor();
    }

    /**
     * Sets Agent Status value
     * @param comboBox 
     * @param value Agent status
     */
    public static void setSelectedValue(JComboBox comboBox, String value) {

        String item;
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            item = (String) comboBox.getItemAt(i);
            if (item.equals(value)) {
                if (comboBox.getSelectedIndex() != i) {
                    comboBox.setSelectedIndex(i);
                }
                break;
            }
        }
    }

    /**
     * Saves Data for different categories
     * Saves Data to Caller, Case, CaseHistory and Accused
     * to the database tables caller, cases, case_history, accused respectively
     * @param Category values = 'Advice', 'Men', 'Blank and Irrelevant'
     */
    public void SaveData(String Category) {
        Long CaseID = null;

        cs.setPoliceStn("NA");
        cs.setReadableName(Category + (new Date().getTime()));
        cs.setStatus("NA");
        cs.setForward("NA");
        cs.setCaseType(Category);
        cs.savetodb();
        CaseID = cs.getId();

        CaseHistory ch = new CaseHistory();
        DataBase.Tables.Agent ag = new DataBase.Tables.Agent().loadclass(" AgentID='" + Long.valueOf(pf.AgentId) + "'").get(0);
        ch.setAgentID(ag.getId());
        ch.setAdvice(Category);
        ch.setCaseID(CaseID);
        ch.setNote(Category);
        ch.setDatestamp(new Date().toLocaleString());
        ch.setReffered("NA");
        ch.savetodb();
        Calls call = new Calls().loadclass(" TextualDate='" + ((Dlg_distressWoman) Dlg_distressWoman).TextualDate + "' and CallUUID='" + ((Dlg_distressWoman) Dlg_distressWoman).UUID + "'").get(0);
        call.setCaseHID(ch.getId());
        call.setAgentId(Integer.valueOf(pf.AgentId));
        call.updatedb();
        Caller cl = new Caller();
        cl.setName("NR:" + Category);
        cl.setAge("0");
        cl.setCallid(ch.getId());
        cl.setAddress("NR:" + Category);
        cl.savetodb();
        infoBox("Your call is saved in the category: " + Category, "Delhi Women Cell");
    }

    /**
     * Plays the Audio file
     */
    class playfile implements Runnable {

        public playfile() {
        }

        @Override
        public void run() {
            try {
                System.err.println("Playing alarm");
                play();
            } catch (JavaLayerException ex) {
                Logger.getLogger(Design.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Design.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void play() throws JavaLayerException, IOException {
//        String song = "http://sound17.mp3pk.com/indian/bhaagmilkhabhaag/[Songs.PK]%20Bhaag%20Milkha%20Bhaag%20-%2001%20-%20Gurbani.mp3";
            // String fileurl=ServerUrl+Credential+jLabel1.getText();
            //String fileurl="http://192.168.16.176/download.php?file=1.mp3";
            //String fileurl = ;
            BufferedInputStream in = null;
            try {
                in = new BufferedInputStream(this.getClass().getResource("/media/Alarm.mp3").openStream());
                mp3player = new Player(in);
                mp3player.play();
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            } catch (NullPointerException ex) {
                ex.printStackTrace();
            }

        }
    }
}
