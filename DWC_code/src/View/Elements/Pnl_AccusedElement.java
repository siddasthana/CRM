/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Elements;

import DataBase.Tables.Accused;
import DataBase.Tables.Caller;
import DataBase.Tables.Legal;
import View.Global;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

/**
 *
 * @author admin
 */
public class Pnl_AccusedElement extends javax.swing.JPanel {

    /**
     *
     */
    public ArrayList<Long> CaseID = new ArrayList<>();
    public long id;
    

    /**
     * Creates new form Pnl_CallerElement
     */
    public Pnl_AccusedElement() {
        initComponents();
    }

    public ArrayList<Long> getCaseID() {
        return CaseID;
    }

    public void setCaseID(ArrayList<Long> CaseID) {
        this.CaseID = CaseID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public JButton getBtn_Save() {
        return Btn_Save;
    }

    public void setBtn_Save(JButton Btn_Save) {
        this.Btn_Save = Btn_Save;
    }

    public JTextField getTxt_AccusedAddress() {
        return Txt_AccusedAddress;
    }

    public void setTxt_AccusedAddress(JTextField Txt_AccusedAddress) {
        this.Txt_AccusedAddress = Txt_AccusedAddress;
    }

    public JTextField getTxt_AccusedDD() {
        return Txt_AccusedDD;
    }

    public void setTxt_AccusedDD(JTextField Txt_AccusedDD) {
        this.Txt_AccusedDD = Txt_AccusedDD;
    }

    public JTextField getTxt_AccusedFIR() {
        return Txt_AccusedFIR;
    }

    public void setTxt_AccusedFIR(JTextField Txt_AccusedFIR) {
        this.Txt_AccusedFIR = Txt_AccusedFIR;
    }

    public JTextField getTxt_AccusedName() {
        return Txt_AccusedName;
    }

    public void setTxt_AccusedName(JTextField Txt_AccusedName) {
        this.Txt_AccusedName = Txt_AccusedName;
    }

    public JTextField getTxt_AccusedPhone() {
        return Txt_AccusedPhone;
    }

    public void setTxt_AccusedPhone(JTextField Txt_AccusedPhone) {
        this.Txt_AccusedPhone = Txt_AccusedPhone;
    }

    public JCheckBox getjChk_Challan() {
        return jChk_Challan;
    }

    public void setjChk_Challan(JCheckBox jChk_Challan) {
        this.jChk_Challan = jChk_Challan;
    }

    public JCheckBox getjChk_Judgement() {
        return jChk_Judgement;
    }

    public void setjChk_Judgement(JCheckBox jChk_Judgement) {
        this.jChk_Judgement = jChk_Judgement;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Btn_Save = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        Txt_AccusedName = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        Txt_AccusedPhone = new javax.swing.JTextField();
        Txt_AccusedAddress = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        Txt_AccusedDD = new javax.swing.JTextField();
        Txt_AccusedFIR = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jChk_Challan = new javax.swing.JCheckBox();
        jChk_Judgement = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMaximumSize(this.getPreferredSize());

        Btn_Save.setText("Save");
        Btn_Save.setEnabled(false);
        Btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SaveActionPerformed(evt);
            }
        });

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

        Txt_AccusedFIR.setName(""); // NOI18N
        Txt_AccusedFIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_AccusedFIRActionPerformed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel71.setText("FIR No.");

        jChk_Challan.setText("Challan");

        jChk_Judgement.setText("Judgement");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(Btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jChk_Challan)
                        .addGap(40, 40, 40)
                        .addComponent(jChk_Judgement)))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel63, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel71, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Txt_AccusedPhone)
                        .addComponent(Txt_AccusedName)
                        .addComponent(Txt_AccusedAddress)
                        .addComponent(Txt_AccusedDD, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addComponent(Txt_AccusedFIR, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                    .addGap(13, 13, 13)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(199, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChk_Judgement)
                    .addComponent(jChk_Challan))
                .addGap(11, 11, 11)
                .addComponent(Btn_Save)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel62)
                        .addComponent(Txt_AccusedName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Txt_AccusedPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel63))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Txt_AccusedAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel64))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Txt_AccusedDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel65))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel71)
                        .addComponent(Txt_AccusedFIR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(84, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void LoadElement_Accused(Accused e) {
        Pnl_AccusedElement obj = this;
        obj.getTxt_AccusedName().setText(e.getName());
        obj.getTxt_AccusedPhone().setText(String.valueOf(e.getPhone()));
        obj.getTxt_AccusedAddress().setText(e.getAddress());        
        obj.CaseID.add(e.getCaseID());
        obj.id = e.getId();        
    }
    public void LoadElement_Legal(Legal le) {
        Pnl_AccusedElement obj = this;
        obj.getTxt_AccusedDD().setText(le.getDD());
        obj.getTxt_AccusedFIR().setText(le.getFir());
        obj.getjChk_Challan().setSelected(le.getChallan()!=0?true:false);
        obj.getjChk_Judgement().setSelected(le.getJudgement()!=0?true:false);
        obj.CaseID.add(le.getCaseID());
        obj.id = le.getId();        
    }
    public void EnableSave(long id){
        if (Global.AgentLevel.equals("supervisor")) 
        {
            this.CaseID.add(id);
            this.Btn_Save.setEnabled(true);
            
        }
    }
    private void Btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SaveActionPerformed
        // TODO add your handling code here:
        Accused ac = new Accused();
        Legal le = new Legal();
        System.out.println("caseid"+getCaseID().get(0));
        ArrayList<Accused> acl = new Accused().loadclass(" Caseid = "+this.getCaseID().get(0));
        ArrayList<Legal> lel = new Legal().loadclass(" CaseID = "+this.getCaseID().get(0));        
        ac.setName(Txt_AccusedName.getText());
        ac.setAddress(Txt_AccusedAddress.getText());
        if(Txt_AccusedPhone.getText().isEmpty()){ac.setPhone(0);}
        else{ac.setPhone(Long.parseLong(Txt_AccusedPhone.getText()));}
        le.setDD(Txt_AccusedDD.getText());
        le.setFir(Txt_AccusedFIR.getText());
        le.setJudgement(jChk_Judgement.isSelected()?1:0);
        le.setChallan(jChk_Challan.isSelected()?1:0);
        ac.setCaseID(this.getCaseID().get(0));        
        le.setCaseID(this.getCaseID().get(0));
        if(acl.isEmpty())ac.savetodb(); else ac.updatedb();
        if(lel.isEmpty())le.savetodb(); else le.updatedb();
        System.out.println("completed update or save for accused information");
        //ac.();
    }//GEN-LAST:event_Btn_SaveActionPerformed

    private void Txt_AccusedNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_AccusedNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_AccusedNameActionPerformed

    private void Txt_AccusedPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_AccusedPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_AccusedPhoneActionPerformed

    private void Txt_AccusedDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_AccusedDDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_AccusedDDActionPerformed

    private void Txt_AccusedFIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_AccusedFIRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_AccusedFIRActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Save;
    private javax.swing.JTextField Txt_AccusedAddress;
    private javax.swing.JTextField Txt_AccusedDD;
    private javax.swing.JTextField Txt_AccusedFIR;
    private javax.swing.JTextField Txt_AccusedName;
    private javax.swing.JTextField Txt_AccusedPhone;
    private javax.swing.JCheckBox jChk_Challan;
    private javax.swing.JCheckBox jChk_Judgement;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel71;
    // End of variables declaration//GEN-END:variables
}
