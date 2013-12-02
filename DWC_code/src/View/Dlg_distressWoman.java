/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DataBase.OutBound;
import DataBase.Sql;
import DataBase.Tables.Accused;
import DataBase.Tables.Caller;
import DataBase.Tables.Calls;
import DataBase.Tables.CaseHistory;
import DataBase.Tables.Cases;
import DataBase.Tables.ForwardCase;
import DataBase.Tables.Telephone;
import DataBase.Tables.Legal;
import Layout.WrapLayout;
import View.Elements.Pnl_CallElement;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import static java.awt.image.ImageObserver.ALLBITS;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXSearchField;

/**
 * This Class provides methods to enter and save data corresponding to any DistressWoman call
 * it invokes directly invokes Dlg_SearchComplain, ForwardCase, 
 * dlg_AddTelephone, Outbound, Pnl_CallElement and Pnl_CaseDirectory
 * @author admin
 */
public class Dlg_distressWoman extends javax.swing.JDialog {

    /**
     * @return a JComboBox CaseStatus value
     */
    public JComboBox getCmbBx_CaseStatus() {
        return CmbBx_CaseStatus;
    }

    /**
     * Sets the CaseStatus
     * @param CmbBx_CaseStatus a JComboBox value
     */
    public void setCmbBx_CaseStatus(JComboBox CmbBx_CaseStatus) {
        this.CmbBx_CaseStatus = CmbBx_CaseStatus;
    }

    /**
     * @return a JComboBox CaseType value
     */
    public JComboBox getCmbBx_CaseType() {
        return CmbBx_CaseType;
    }

    /**
     * Sets the CaseType value
     * @param CmbBx_CaseType A JCoboBox value
     */
    public void setCmbBx_CaseType(JComboBox CmbBx_CaseType) {
        this.CmbBx_CaseType = CmbBx_CaseType;
    }

    /**
     * @return a JComboBox PoliceDistrict value
     */
    public JComboBox getCmbBx_PoliceDistrict() {
        return CmbBx_PoliceDistrict;
    }

    /**
     * sets the PoliceDistrict value
     * @param CmbBx_PoliceDistrict a JComboBox value
     */
    public void setCmbBx_PoliceDistrict(JComboBox CmbBx_PoliceDistrict) {
        this.CmbBx_PoliceDistrict = CmbBx_PoliceDistrict;
    }

    /**
     * @return a JXSearchField Complaint value
     */
    public JXSearchField getSrchFld_Complaint() {
        return SrchFld_Complaint;
    }

    /**
     * sets the Complaint value
     * @param SrchFld_Complaint a JXSearchField value
     */
    public void setSrchFld_Complaint(JXSearchField SrchFld_Complaint) {
        this.SrchFld_Complaint = SrchFld_Complaint;
    }

    /**
     * @return a JXSearchField PoliceStation value
     */
    public JXSearchField getSrchFld_PoliceStne() {
        return SrchFld_PoliceStne;
    }

    /**
     * sets the PoliceStation value
     * @param SrchFld_PoliceStne a JXSearchField value
     */
    public void setSrchFld_PoliceStne(JXSearchField SrchFld_PoliceStne) {
        this.SrchFld_PoliceStne = SrchFld_PoliceStne;
    }

    /**
     * @return a JComboBox Forward value
     */
    public JComboBox getCmbBx_Forward() {
        return CmbBx_Forward;
    }

    /**
     * sets the Forward value
     * @param CmbBx_Forward a JComboBox value
     */
    public void setCmbBx_Forward(JComboBox CmbBx_Forward) {
        this.CmbBx_Forward = CmbBx_Forward;
    }
    
    
    Dlg_SearchComplain dc = new Dlg_SearchComplain((Frame) this.getParent(), rootPaneCheckingEnabled);
    Dlg_Reminder dr = new Dlg_Reminder((Frame) this.getParent(), rootPaneCheckingEnabled);

    /**
     * Parameterized Constructor
     * @param parent Parent name
     * @param modal 
     */
    public Dlg_distressWoman(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }

    /**
     * @return A JTextField CallerAddress value
     */
    public JTextField getTxt_CallerAddress() {
        return Txt_CallerAddress;
    }

    /**
     * Sets the CallerAddress value
     * @param Txt_CallerAddress3 a JTextField value
     */
    public void setTxt_CallerAddress(JTextField Txt_CallerAddress3) {
        this.Txt_CallerAddress = Txt_CallerAddress3;
    }

    /**
     * @return a JTextField CallerAge value
     */
    public JTextField getTxt_CallerAge() {
        return Txt_CallerAge;
    }

    /**
     * Sets the CallerAge value
     * @param Txt_CallerAge3 A JTextField value
     */
    public void setTxt_CallerAge(JTextField Txt_CallerAge3) {
        this.Txt_CallerAge = Txt_CallerAge3;
    }

    /**
     * @return a JTextField CallerName value
     */
    public JTextField getTxt_CallerName() {
        return Txt_CallerName;
    }

    /**
     * sets the AccusedName value
     * @param Txt_CallerAge3 A JTextField value
     */
    public void setTxt_AccusedName(JTextField Txt_CallerAge3) {
        this.Txt_AccusedName = Txt_CallerAge3;
    }

    /**
     * @return a JTextField AccuseName value
     */
    public JTextField getTxt_AccusedName() {
        return Txt_AccusedName;
    }

    /**
     * ?????????????????
     * @param Txt_CallerAge3 
     */
    public void setTxt_AccusedAddress(JTextField Txt_CallerAge3) {
        this.Txt_AccusedAddress = Txt_CallerAge3;
    }

    public JTextField getTxt_AccusedAddress() {
        return Txt_AccusedAddress;
    }

    public void setTxt_AccusedPhone(JTextField Txt_CallerAge3) {
        this.Txt_AccusedPhone = Txt_CallerAge3;
    }

    public JTextField getTxt_AccusedPhone() {
        return Txt_AccusedPhone;
    }

    public void setTxt_AccusedDD(JTextField Txt_CallerAge3) {
        this.Txt_AccusedDD = Txt_CallerAge3;
    }

    public JTextField getTxt_AccusedDD() {
        return Txt_AccusedDD;
    }

    public void setTxt_AccusedFIR(JTextField Txt_CallerAge3) {
        this.Txt_AccusedFIR = Txt_CallerAge3;
    }

    public JTextField getTxt_AccusedFIR() {
        return Txt_AccusedFIR;
    }

    public void setChk_Challan(int Txt_CallerName3) {
        if (Txt_CallerName3 == 0) {
            this.jChk_Challan.setSelected(false);
        } else {
            this.jChk_Challan.setSelected(true);
        }
    }

    public boolean getChk_Challan() {
        return jChk_Challan.isSelected();
    }

    public void setChk_Judgement(int Txt_CallerName3) {
        if (Txt_CallerName3 == 0) {
            this.jChk_Judgement.setSelected(false);
        } else {
            this.jChk_Judgement.setSelected(true);
        }
    }

    public boolean getChk_Judgement() {
        return jChk_Judgement.isSelected();
    }

    public void setTxt_CallerName(JTextField Txt_CallerName3) {
        this.Txt_CallerName = Txt_CallerName3;
    }

    public JTextField getTxt_CallerPhone() {
        return Txt_CallerPhone;
    }

    public void setTxt_CallerPhone(JTextField Txt_CallerPhone3) {
        this.Txt_CallerPhone = Txt_CallerPhone3;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupmenu = new javax.swing.JPopupMenu();
        PopMn_Complaint = new javax.swing.JPopupMenu();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel11 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        Txt_Note = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        Txt_Advice = new javax.swing.JTextArea();
        Txt_CallerName = new javax.swing.JTextField();
        Txt_CallerPhone = new javax.swing.JTextField();
        Txt_CallerAddress = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        Txt_CallerAge = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        Txt_AccusedName = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        Txt_AccusedPhone = new javax.swing.JTextField();
        Txt_AccusedAddress = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        Txt_AccusedDD = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        Txt_AccusedFIR = new javax.swing.JTextField();
        jChk_Challan = new javax.swing.JCheckBox();
        jChk_Judgement = new javax.swing.JCheckBox();
        jLabel66 = new javax.swing.JLabel();
        CmbBx_CaseType = new javax.swing.JComboBox();
        jLabel67 = new javax.swing.JLabel();
        CmbBx_Forward = new javax.swing.JComboBox();
        jLabel68 = new javax.swing.JLabel();
        CmbBx_PoliceDistrict = new javax.swing.JComboBox();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        Btn_Reminder = new javax.swing.JButton();
        jLabel69 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel70 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        Pnl_CaseDirctry = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        Pnl_RecrdDirctry = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        TxtDialScreen = new javax.swing.JTextField();
        Btn_Dial = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        SrchFld_PoliceStne = new org.jdesktop.swingx.JXSearchField();
        SrchFld_Complaint = new org.jdesktop.swingx.JXSearchField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Pnl_CaseHistory = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        CmbBx_CaseStatus = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();

        PopMn_Complaint.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        PopMn_Complaint.setForeground(new java.awt.Color(255, 51, 51));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel55.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel55.setText("Name");

        jLabel56.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel56.setText("Phone");

        jLabel57.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel57.setText("Address");

        jLabel58.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel58.setText("Police District");

        jLabel59.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel59.setText("Case Briefing");

        jLabel60.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel60.setText("Advice");

        Txt_Note.setColumns(20);
        Txt_Note.setRows(5);
        jScrollPane9.setViewportView(Txt_Note);

        Txt_Advice.setColumns(20);
        Txt_Advice.setRows(5);
        jScrollPane10.setViewportView(Txt_Advice);

        Txt_CallerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_CallerNameActionPerformed(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel61.setText("Age");

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Accused", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(51, 255, 255))); // NOI18N
        jPanel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel62.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel62.setText("Name");

        Txt_AccusedName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_AccusedNameActionPerformed(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel63.setText("Phone");

        Txt_AccusedPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_AccusedPhoneActionPerformed(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel64.setText("Address");

        jLabel65.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel65.setText("DD No.");

        Txt_AccusedDD.setName(""); // NOI18N
        Txt_AccusedDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_AccusedDDActionPerformed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel71.setText("FIR No.");

        Txt_AccusedFIR.setName(""); // NOI18N
        Txt_AccusedFIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_AccusedFIRActionPerformed(evt);
            }
        });

        jChk_Challan.setText("Challan");

        jChk_Judgement.setText("Judgement");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel71, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jChk_Challan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jChk_Judgement)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Txt_AccusedPhone)
                        .addComponent(Txt_AccusedName)
                        .addComponent(Txt_AccusedAddress)
                        .addComponent(Txt_AccusedDD, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addComponent(Txt_AccusedFIR, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)))
                .addGap(23, 23, 23))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(Txt_AccusedName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_AccusedPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_AccusedAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_AccusedDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(Txt_AccusedFIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChk_Challan)
                    .addComponent(jChk_Judgement)))
        );

        jLabel66.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel66.setText("Case Type");

        CmbBx_CaseType.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        CmbBx_CaseType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Others", "Abduction", "Acid_Attack", "Callback_from_100", "Child_Sexual_Abuse (POSCO)", "Dangerous_Attack", "Domestic_Violence", "Dowry_Death", "Dowry_Violence", "DTC_related", "Education_related", "Health_related", "Illegal_Confinement", "Incoming_obscene", "Kidnaping", "Life_Threatening_attack_by_Family", "Missing", "Murder", "Obscene_Call", "Petty_Quarrel", "Property_cases", "Rape", "Sexual_Abuse", "Sexual_abuse_at_workplace", "Stalking", "Threat_To_Life", "Violence_by_Khap_Biradari_Panchayat" }));
        CmbBx_CaseType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbBx_CaseTypeActionPerformed(evt);
            }
        });

        jLabel67.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel67.setText("Reffered");

        CmbBx_Forward.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        CmbBx_Forward.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Other", "100", "1096", "SHO PS", "DCP/ACP", "DLSA", "DCW", "Mahila Panchayat", "Shelter Home", "Protection Ofiicer", "Child Welfare Comitee", "GRC", "Awaaj Uthao", "IHBAS", "DTC", "NGO", "Hospital", "Ambulance" }));

        jLabel68.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel68.setText("Police Station");

        CmbBx_PoliceDistrict.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        CmbBx_PoliceDistrict.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CENTRAL", "EAST", "NEW DELHI", "NORTH", "NORTH EAST", "NORTH WEST", "SOUTH", "SOUTH EAST ", "SOUTH WEST", "OUTER DISTRICT", "WEST" }));
        CmbBx_PoliceDistrict.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbBx_PoliceDistrictItemStateChanged(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton10.setText("Call End");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton11.setText("Send to Supervisior");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton12.setText("Send to Manager");

        Btn_Reminder.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Btn_Reminder.setText("Create a Reminder");
        Btn_Reminder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ReminderActionPerformed(evt);
            }
        });

        jLabel69.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel69.setText("Complaint");

        jComboBox4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Existing Complain", "New Complain", "Search Complain" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel70.setText("---< Choose an Option >--");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Pnl_CaseDirctry.setBackground(new java.awt.Color(255, 255, 255));
        Pnl_CaseDirctry.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout Pnl_CaseDirctryLayout = new javax.swing.GroupLayout(Pnl_CaseDirctry);
        Pnl_CaseDirctry.setLayout(Pnl_CaseDirctryLayout);
        Pnl_CaseDirctryLayout.setHorizontalGroup(
            Pnl_CaseDirctryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 497, Short.MAX_VALUE)
        );
        Pnl_CaseDirctryLayout.setVerticalGroup(
            Pnl_CaseDirctryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );

        jScrollPane11.setViewportView(Pnl_CaseDirctry);
        Pnl_CaseDirctry.setLayout(new Layout.WrapLayout());

        jPanel1.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 501, 100));

        Pnl_RecrdDirctry.setBackground(new java.awt.Color(255, 255, 255));
        Pnl_RecrdDirctry.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 255)));
        Pnl_RecrdDirctry.setName(""); // NOI18N

        javax.swing.GroupLayout Pnl_RecrdDirctryLayout = new javax.swing.GroupLayout(Pnl_RecrdDirctry);
        Pnl_RecrdDirctry.setLayout(Pnl_RecrdDirctryLayout);
        Pnl_RecrdDirctryLayout.setHorizontalGroup(
            Pnl_RecrdDirctryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 497, Short.MAX_VALUE)
        );
        Pnl_RecrdDirctryLayout.setVerticalGroup(
            Pnl_RecrdDirctryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );

        jScrollPane12.setViewportView(Pnl_RecrdDirctry);
        Pnl_RecrdDirctry.setLayout(new Layout.WrapLayout());

        jPanel1.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 501, 100));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 255, 255), new java.awt.Color(0, 255, 255)));

        TxtDialScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtDialScreenActionPerformed(evt);
            }
        });

        Btn_Dial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/Dial.png"))); // NOI18N
        Btn_Dial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_DialActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton4.setText("1");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setIconTextGap(0);
        jButton4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DialKeyPad(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton5.setText("4");
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setIconTextGap(0);
        jButton5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DialKeyPad(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton6.setText("7");
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setIconTextGap(0);
        jButton6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DialKeyPad(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton7.setText("2");
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setIconTextGap(0);
        jButton7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DialKeyPad(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton8.setText("5");
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setIconTextGap(0);
        jButton8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DialKeyPad(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton9.setText("8");
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setIconTextGap(0);
        jButton9.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DialKeyPad(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton13.setText("3");
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setIconTextGap(0);
        jButton13.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DialKeyPad(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton14.setText("9");
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton14.setIconTextGap(0);
        jButton14.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DialKeyPad(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton15.setText("6");
        jButton15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton15.setIconTextGap(0);
        jButton15.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DialKeyPad(evt);
            }
        });

        jButton16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton16.setText("*");
        jButton16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton16.setIconTextGap(0);
        jButton16.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton16.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton16.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DialKeyPad(evt);
            }
        });

        jButton17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton17.setText("#");
        jButton17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton17.setIconTextGap(0);
        jButton17.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DialKeyPad(evt);
            }
        });

        jButton18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton18.setText("0");
        jButton18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton18.setIconTextGap(0);
        jButton18.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DialKeyPad(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(Btn_Dial, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtDialScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TxtDialScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Dial, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 0, 200, 140));

        SrchFld_PoliceStne.setFindPopupMenu(popupmenu);
        SrchFld_PoliceStne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SrchFld_PoliceStneActionPerformed(evt);
            }
        });
        SrchFld_PoliceStne.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                SrchFld_PoliceStneFocusLost(evt);
            }
        });

        SrchFld_Complaint.setFindPopupMenu(PopMn_Complaint);
        SrchFld_Complaint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SrchFld_ComplaintActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Case Status");

        Pnl_CaseHistory.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Case History");

        javax.swing.GroupLayout Pnl_CaseHistoryLayout = new javax.swing.GroupLayout(Pnl_CaseHistory);
        Pnl_CaseHistory.setLayout(Pnl_CaseHistoryLayout);
        Pnl_CaseHistoryLayout.setHorizontalGroup(
            Pnl_CaseHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        );
        Pnl_CaseHistoryLayout.setVerticalGroup(
            Pnl_CaseHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_CaseHistoryLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 446, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(Pnl_CaseHistory);
        Pnl_CaseHistory.setLayout(new Layout.WrapLayout());

        CmbBx_CaseStatus.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        CmbBx_CaseStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Primary intervention done", "Case in progress", "Case closed" }));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/Add.jpg"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 255, 255), new java.awt.Color(0, 255, 255)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel67)
                                .addGap(55, 55, 55)
                                .addComponent(CmbBx_Forward, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(jButton10)
                                    .addGap(30, 30, 30)
                                    .addComponent(jButton11)
                                    .addGap(30, 30, 30)
                                    .addComponent(jButton12)
                                    .addGap(53, 53, 53)
                                    .addComponent(Btn_Reminder))
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel59)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(38, 38, 38)
                                    .addComponent(jScrollPane10)))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel58)
                                    .addGap(18, 18, 18)
                                    .addComponent(CmbBx_PoliceDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                    .addGap(95, 95, 95)
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Txt_CallerName, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Txt_CallerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Txt_CallerAge, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Txt_CallerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel11Layout.createSequentialGroup()
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel68)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel66))
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(CmbBx_CaseType, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(SrchFld_Complaint, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(CmbBx_CaseStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                            .addGap(21, 21, 21)
                                            .addComponent(SrchFld_PoliceStne, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel57)
                            .addComponent(jLabel55)
                            .addComponent(jLabel56)
                            .addComponent(jLabel61))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel55)
                                    .addComponent(Txt_CallerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel61)
                                    .addComponent(Txt_CallerAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Txt_CallerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel56))
                                    .addComponent(jButton2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel57)
                                    .addComponent(Txt_CallerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel58)
                                    .addComponent(CmbBx_PoliceDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel68)
                                    .addComponent(SrchFld_PoliceStne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel69)
                                    .addComponent(SrchFld_Complaint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(CmbBx_CaseStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel66)
                                    .addComponent(CmbBx_CaseType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel70))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CmbBx_Forward, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel67))
                                .addGap(28, 28, 28)))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel60)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton12)
                        .addComponent(jButton11)
                        .addComponent(jButton10))
                    .addComponent(Btn_Reminder))
                .addGap(35, 35, 35))
        );

        jScrollPane1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        jScrollPane2.setViewportView(jPanel11);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Populates Search Field values in a pop menu, then sets one when clicked
     * @param evt 
     */
    private void SrchFld_PoliceStneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SrchFld_PoliceStneActionPerformed
        // TODO add your handling code here:
        if (popupmenu.getComponentCount() > 0) {
            for (int i = 0; i < popupmenu.getComponentCount(); i++) {
                JMenuItem ji = (JMenuItem) popupmenu.getComponentAtIndex(i);
                if (ji.getText().equals(evt.getActionCommand().toString())) {
                    return;
                }
            }
        }

        System.out.println(evt.getActionCommand());
        popupmenu.setVisible(false);
        boolean b = SrchFld_PoliceStne.isUseNativeSearchFieldIfPossible();
        //Fetch Data
        Sql sql = new Sql();
        ResultSet rs;
        rs = sql.ExecuteQuery("Select * From directory where area like '%" + evt.getActionCommand() + "%' Limit 4");
        try {
            popupmenu.removeAll();
            while (rs.next()) {
                System.out.println();
                JMenuItem ji = new JMenuItem(rs.getString(3));
                ji.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        click(evt);
                    }

                    private void click(ActionEvent evt) {
                        SrchFld_PoliceStne.setText(evt.getActionCommand());
                    }
                });

                popupmenu.add(ji);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Screen_TeleExecutive.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql.Destructor();
        // SrchFld_PoliceStne.getpo;
        //System.out.println(SrchFld_PoliceStne.getFindPopupMenu().getPopupLocation(null));
        //popupmenu.setLocation(200,200);
        popupmenu.setFocusable(false);
        popupmenu.setVisible(true);
    }//GEN-LAST:event_SrchFld_PoliceStneActionPerformed
    
    /**
     * Sets the selected value for the JComboBox 
     * @param comboBox A JCoboBox value
     * @param value The selected String value 
     */
    public static void setSelectedValue(JComboBox comboBox, String value) {

        String item;
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            item = (String) comboBox.getItemAt(i);
            if (item.equals(value)) {
                comboBox.setSelectedIndex(i);
                break;
            }
        }
    }
    
    /**
     * invokes Dlg_SearchComplain
     * Searches Existing Complaints
     * If and existing one is found, Sets Police Station, Complaint, Case Status
     * , Case Type and Forward values According to the corresponding complaint in cases table
     * @param evt 
     */
    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
        if (jComboBox4.getSelectedItem().toString().equals("Search Complain")) {
            //        Existing Complain
            //New Complain

            dc = new Dlg_SearchComplain((Frame) this.getParent(), true);
            dc.Caseid = Long.valueOf("0");
            dc.setSize(dc.getPreferredSize());
            dc.setVisible(true);
            if (dc.Caseid >= 1) {
                newcase = false;
                Cases cs = new Cases().loadclass(" idCase=" + dc.Caseid).get(0);
                CaseID = cs.getId();
                SrchFld_PoliceStne.setText(cs.getPoliceStn());
                SrchFld_Complaint.setText(cs.getReadableName());
                setSelectedValue(CmbBx_CaseStatus, cs.getStatus());
                setSelectedValue(CmbBx_CaseType, cs.getCaseType());
                setSelectedValue(CmbBx_Forward, cs.getForward());
                infoBox("Your Current case is updated to : " + cs.getReadableName(), "Delhi Women Cell");
            } else {
                infoBox("You have not selected any Case", "Delhi Women Cell");
            }
        }
    }//GEN-LAST:event_jComboBox4ActionPerformed

    /**
     * Sets a reminder when the "Create a reminder" button is clicked
     * @param evt 
     */
    private void Btn_ReminderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ReminderActionPerformed
        // TODO add your handling code here:

        if (SrchFld_Complaint.getText().length() > 1) {
            dr.getSrchFld_Complaint().setText(SrchFld_Complaint.getText());
        } else {
            infoBox("Please assign a proper Complaint Number to this case!!", "Delhi Women Cell");
            return;
        }
        dr.setComplaintNo(SrchFld_Complaint.getText());
        dr.setSize(dr.getPreferredSize());
        dr.setVisible(true);
    }//GEN-LAST:event_Btn_ReminderActionPerformed

    /**
     * Ends the telephone call
     * invokes SaveData()
     * @param evt 
     */
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        boolean saved = SaveData();
        if (saved) {
            this.setVisible(false);
            this.dispose();
        } else {
            String Msg = "Unable to save Data \n";
            Msg += "Please Check you have not given Blank Values in Complaint";
            infoBox(Msg, "Delhi Women Cell");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void CmbBx_CaseTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbBx_CaseTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbBx_CaseTypeActionPerformed

    private void Txt_AccusedNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_AccusedNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_AccusedNameActionPerformed

    private void Txt_CallerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_CallerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_CallerNameActionPerformed

    /**
     * Forwards the case, Ends the telephone call
     * invokes SaveData()
     */
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        boolean saved = SaveData();
        if (saved) {
            System.err.println("newcase"+newcase+"newcaller"+newcaller+"newaccused"+newaccussed);
            ForwardCase fc = new ForwardCase();
            fc.setCaseID(CaseID);
            fc.setLevel("S");
            fc.setReadstatus("U");
            DataBase.Tables.Agent ag = new DataBase.Tables.Agent().loadclass(" AgentID='" + Long.valueOf(((ParentForm) this.getParent()).AgentId) + "'").get(0);
            fc.setForwarded(ag.getId());
            fc.savetodb();
            this.setVisible(false);
            this.dispose();


        } else {
            String Msg = "Unable to save Data \n";
            Msg += "Please Check you have not given Blank Values in Complaint";
            infoBox(Msg, "Delhi Women Cell");
        }

    }//GEN-LAST:event_jButton11ActionPerformed

    /**
     * Searches ans sets the Complaint value from case table
     * @param evt 
     * @throws SQLException
     */
    private void SrchFld_ComplaintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SrchFld_ComplaintActionPerformed
        // TODO add your handling code here:
        Sql sql = new Sql();
        ResultSet rs;
        rs = sql.ExecuteQuery("Select ReadableName From `" + Sql.dbName + "`.`case`  where ReadableName like '" + evt.getActionCommand() + "%'");
        try {
            PopMn_Complaint.removeAll();
            int i = 0;
            while (rs.next()) {
                i++;
                System.out.println();
                JMenuItem ji = new JMenuItem(rs.getString(1));
                //ji.addActionListener(new java.awt.event.ActionListener() {
                //  public void actionPerformed(java.awt.event.ActionEvent evt) {
                //    click(evt);
                // }

                // private void click(ActionEvent evt) {
                // SrchFld_PoliceStne.setText(evt.getActionCommand());
                //}
                // });

                PopMn_Complaint.add(ji);
            }
            if (i == 0) {
                SrchFld_Complaint.setForeground(Color.GREEN);
            } else {
                SrchFld_Complaint.setForeground(Color.RED);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Screen_TeleExecutive.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql.Destructor();
        // SrchFld_PoliceStne.getpo;
        //System.out.println(SrchFld_PoliceStne.getFindPopupMenu().getPopupLocation(null));
        //popupmenu.setLocation(200,200);
        PopMn_Complaint.setFocusable(false);
        //PopMn_Complaint.setVisible(true);

    }//GEN-LAST:event_SrchFld_ComplaintActionPerformed
    
    public static void infoBox(String infoMessage, String location) {
        JOptionPane.showMessageDialog(null, infoMessage, location, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Adds the Phone Number to the telephone table
     * @param evt 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Dlg_AddTelephone da = new Dlg_AddTelephone((Frame) this.getParent(), true);
        da.show();
        Telephone ph = new Telephone();
        ph.setNote(da.getTxtName().getText());
        try {
            ph.setNumber(Long.parseLong(da.getTxtPhone().getText()));
            tp.add(ph);
        } catch (Exception e) {
            e.printStackTrace();
            infoBox("You have entered invalid number", "Delhi Women Cell");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void TxtDialScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtDialScreenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtDialScreenActionPerformed

    private void DialKeyPad(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DialKeyPad
        // TODO add your handling code here:
        TxtDialScreen.setText(TxtDialScreen.getText() + evt.getActionCommand());
    }//GEN-LAST:event_DialKeyPad

    /**
     * invokes OutBound.connect to call the Phone Number in the Text field
     * @param evt 
     */
    private void Btn_DialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_DialActionPerformed
        // TODO add your handling code here:
        OutBound ob = new OutBound();
        ob.connect(TxtDialScreen.getText());
        infoBox("Your Call Request is submitted. Please wait for 1 minute for server to connect you.", "Delhi WomenCell");
    }//GEN-LAST:event_Btn_DialActionPerformed

    private void Txt_AccusedDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_AccusedDDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_AccusedDDActionPerformed

    private void Txt_AccusedPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_AccusedPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_AccusedPhoneActionPerformed

    private void Txt_AccusedFIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_AccusedFIRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_AccusedFIRActionPerformed

    private void CmbBx_PoliceDistrictItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbBx_PoliceDistrictItemStateChanged
        // TODO add your handling code here:
        //jCmb_PS.removeAllItems();
        //jCmb_PS.add();
    }//GEN-LAST:event_CmbBx_PoliceDistrictItemStateChanged

    /**
     * Reloads the searchfield pop up options
     * @param evt 
     */
    private void SrchFld_PoliceStneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SrchFld_PoliceStneFocusLost
        // TODO add your handling code here: 
        Pnl_CaseDirctry.removeAll();
        ArrayList<DataBase.Tables.Directory> dir1 = new DataBase.Tables.Directory().loadclass(" AREA like '"+SrchFld_PoliceStne.getText()+"'");
        for (DataBase.Tables.Directory obj : dir1){
        Pnl_CallElement pce = new Pnl_CallElement();
        pce.Lbl_CallElement_number.setText(obj.getNumber());
        pce.Lbl_CallElement_Name.setText(obj.getService());
        
        Pnl_CaseDirctry.add(pce);
            System.out.println("Added a Case directory element");
        }
        Pnl_CaseDirctry.revalidate();
        Pnl_CaseDirctry.repaint();
    }//GEN-LAST:event_SrchFld_PoliceStneFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dlg_distressWoman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dlg_distressWoman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dlg_distressWoman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dlg_distressWoman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dlg_distressWoman dialog = new Dlg_distressWoman(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
                //  dialog.SrchFld_Complaint.getPopupButton().doClick();
                //dialog.SrchFld_PoliceStne.getPopupButton().doClick();

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Dial;
    private javax.swing.JButton Btn_Reminder;
    public javax.swing.JComboBox CmbBx_CaseStatus;
    private javax.swing.JComboBox CmbBx_CaseType;
    private javax.swing.JComboBox CmbBx_Forward;
    private javax.swing.JComboBox CmbBx_PoliceDistrict;
    public javax.swing.JPanel Pnl_CaseDirctry;
    public javax.swing.JPanel Pnl_CaseHistory;
    public javax.swing.JPanel Pnl_RecrdDirctry;
    private javax.swing.JPopupMenu PopMn_Complaint;
    private org.jdesktop.swingx.JXSearchField SrchFld_Complaint;
    private org.jdesktop.swingx.JXSearchField SrchFld_PoliceStne;
    private javax.swing.JTextField TxtDialScreen;
    private javax.swing.JTextField Txt_AccusedAddress;
    private javax.swing.JTextField Txt_AccusedDD;
    private javax.swing.JTextField Txt_AccusedFIR;
    private javax.swing.JTextField Txt_AccusedName;
    private javax.swing.JTextField Txt_AccusedPhone;
    private javax.swing.JTextArea Txt_Advice;
    private javax.swing.JTextField Txt_CallerAddress;
    private javax.swing.JTextField Txt_CallerAge;
    private javax.swing.JTextField Txt_CallerName;
    private javax.swing.JTextField Txt_CallerPhone;
    private javax.swing.JTextArea Txt_Note;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jChk_Challan;
    private javax.swing.JCheckBox jChk_Judgement;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    public javax.swing.JScrollPane jScrollPane12;
    public javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPopupMenu popupmenu;
    // End of variables declaration//GEN-END:variables
    public boolean newcaller = false, newcase = false, newaccussed = false;
    public boolean populatingcaller, populatingcase, populatincasehistory;
    public ArrayList<Long> CaseHid = new ArrayList<>();
    public ArrayList<Telephone> tp = new ArrayList<>();
    public String TextualDate, UUID;
    public long CaseID;//= new ArrayList<>();
    public Cases cs = new Cases();

    /**
     * when invoked, saves all data to respective tables in the database
     * @return 
     */
    private boolean SaveData() {
        try {
            cs.setPoliceStn(this.getSrchFld_PoliceStne().getText());
            cs.setReadableName(this.getSrchFld_Complaint().getText());
            cs.setStatus(this.CmbBx_CaseStatus.getSelectedItem().toString());
            cs.setForward(this.CmbBx_Forward.getSelectedItem().toString());
            cs.setCaseType(this.CmbBx_CaseType.getSelectedItem().toString());
            System.err.println("newcase "+newcase);
            if (newcase) {
                cs.savetodb();
                CaseID = cs.getId();
            }
            if (CaseID < 1) {
                return false;
            }
            if (newcase) {
                Accused acd = new Accused();
                if (Txt_AccusedName.getText().length() > 1 || Txt_AccusedPhone.getText().length()> 1) {
                    acd.setName(Txt_AccusedName.getText());
                    try {
                        acd.setPhone(Long.valueOf(Txt_AccusedPhone.getText()));
                    } catch (NumberFormatException e) {
                        acd.setPhone(0);
                    }
                    acd.setAddress(Txt_AccusedAddress.getText());
                    acd.setFir(Txt_AccusedDD.getText());
                    acd.setCaseID(cs.getId());
                    acd.savetodb();
                }
            }
            else{ }
            if (newcase) {
                Legal le = new Legal();
                le.setDD(Txt_AccusedDD.getText());
                le.setFir(Txt_AccusedFIR.getText());
                le.setChallan(jChk_Challan.isSelected()?1:0);
                le.setJudgement(jChk_Judgement.isSelected()?1:0);
                le.setCaseID(cs.getId());
                le.savetodb();
            } else {
                Legal le = new Legal();
                le.setDD(Txt_AccusedDD.getText());
                le.setFir(Txt_AccusedFIR.getText());
                le.setChallan(jChk_Challan.isSelected() ? 1 : 0);
                le.setJudgement(jChk_Judgement.isSelected() ? 1 : 0);
                le.setCaseID(CaseID);
                System.out.println("distress sheet accused update"+CaseID);
                le.updatedb();
            }

            CaseHistory ch = new CaseHistory();
            DataBase.Tables.Agent ag = new DataBase.Tables.Agent().loadclass(" AgentID='" + Long.valueOf(((ParentForm) this.getParent()).AgentId) + "'").get(0);
            ch.setAgentID(ag.getId());
            ch.setAdvice(this.Txt_Advice.getText());
            ch.setCaseID(CaseID);
            ch.setNote(this.Txt_Note.getText());
            ch.setDatestamp(new Date().toLocaleString());
            ch.setReffered(this.CmbBx_Forward.getSelectedItem().toString());
            ch.savetodb();
            for (Telephone ob : tp) {
                ob.setCaseHid(ch.getId());
                ob.savetodb();
            }
            Calls call = new Calls().loadclass(" TextualDate='" + TextualDate + "' and CallUUID='" + UUID + "' ORDER BY idCall DESC").get(0);
            System.out.println("updating calls" + "\n" + call.getId());
            call.setCaseHID(ch.getId());
            call.setAgentId(Integer.valueOf(((ParentForm) this.getParent()).AgentId));
            call.updatedb();

            //     System.out.println("agent id is...." + call.getAgentId());
            //   System.out.println("casehid id is...." + call.getCaseHID());

            Caller cl = new Caller();
            cl.setName(this.getTxt_CallerName().getText());
            cl.setAge(this.getTxt_CallerAge().getText());
            cl.setCallid(ch.getId());
            cl.setAddress(this.Txt_CallerAddress.getText());
            cl.savetodb();
            
            popupmenu.setVisible(false);
            popupmenu = null;
            return true;
        } catch (Exception e) {
            infoBox("Information is not saved", "Delhi Women Cell");
            e.printStackTrace();
            return false;
        }

        // Reset the variable after
        // cs = new Cases();
        // newcaller=false;
        // newcase=false;
        // newaccussed= false;
        // CaseHid = new ArrayList<>();
        // CaseID = new ArrayList<>();
        // Dlg_distressWoman.
    }
}
