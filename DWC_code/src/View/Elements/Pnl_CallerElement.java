/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Elements;

import DataBase.Tables.Caller;
import View.Dlg_SelectCaller;
import View.Global;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author admin
 */
public class Pnl_CallerElement extends javax.swing.JPanel {

    /**
     *
     */
    public ArrayList<Long> CaseHID = new ArrayList<>();
    public long id;

    public JButton getBtn_Select() {
        return Btn_Select;
    }

    public void setBtn_Select(JButton Btn_Select) {
        this.Btn_Select = Btn_Select;
    }

    public JTextField getTxt_CallerAddress() {
        return Txt_CallerAddress;
    }

    public void setTxt_CallerAddress(JTextField Txt_CallerAddress) {
        this.Txt_CallerAddress = Txt_CallerAddress;
    }

    public JTextField getTxt_CallerAge() {
        return Txt_CallerAge;
    }

    public void setTxt_CallerAge(JTextField Txt_CallerAge) {
        this.Txt_CallerAge = Txt_CallerAge;
    }

    public JTextField getTxt_CallerName() {
        return Txt_CallerName;
    }

    public void setTxt_CallerName(JTextField Txt_CallerName) {
        this.Txt_CallerName = Txt_CallerName;
    }

    /**
     * Creates new form Pnl_CallerElement
     */
    public Pnl_CallerElement() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Txt_CallerName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Txt_CallerAge = new javax.swing.JTextField();
        Txt_CallerAddress = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Btn_Select = new javax.swing.JButton();
        Btn_Save = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMaximumSize(this.getPreferredSize());

        Txt_CallerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_CallerNameActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Name");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("Age");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Address");

        Btn_Select.setText("Select");
        Btn_Select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SelectActionPerformed(evt);
            }
        });

        Btn_Save.setText("Save");
        Btn_Save.setEnabled(false);
        Btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel13)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Txt_CallerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Txt_CallerName, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Txt_CallerAge, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(Btn_Select, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(Btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Txt_CallerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(Txt_CallerAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Txt_CallerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btn_Select)
                    .addComponent(Btn_Save))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Txt_CallerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_CallerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_CallerNameActionPerformed
    public void LoadElement(Caller e) {
        Pnl_CallerElement obj = this;
        obj.getTxt_CallerName().setText(e.getName());
        obj.getTxt_CallerAge().setText(e.getAge());
        obj.getTxt_CallerAddress().setText(e.getAddress());
        obj.CaseHID.add(e.getCallid());
        obj.id = e.getId();

    }

    public void EnableSave() {
        if (Global.AgentLevel.equals("supervisor")) {
            this.Btn_Save.setEnabled(true);
        }
    }

    private void Btn_SelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SelectActionPerformed
        // TODO add your handling code here:
        Dlg_SelectCaller dc = (Dlg_SelectCaller) this.getRootPane().getParent();
        dc.Address = this.Txt_CallerAddress.getText();
        dc.Age = this.Txt_CallerAge.getText();
        dc.CaseHID = this.CaseHID;
        dc.Name = this.Txt_CallerName.getText();
        System.out.println("Original:" + this.Txt_CallerAddress.getText() + "," + this.Txt_CallerAge.getText() + ",");
        System.out.println(this.CaseHID.toString());
        System.out.println("Copied:" + dc.Address + "," + dc.Age + "," + dc.CaseHID.toString());
        dc.setVisible(false);
    }//GEN-LAST:event_Btn_SelectActionPerformed

    private void Btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SaveActionPerformed
        // TODO add your handling code here:
        Caller cl = new Caller();
        cl.setAddress(Txt_CallerAddress.getText());
        cl.setAge(Txt_CallerAge.getText());
        cl.setCallid(CaseHID.get(0));
        cl.setName(Txt_CallerName.getText());
        cl.setId(id);
        cl.updatedb();
    }//GEN-LAST:event_Btn_SaveActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Save;
    private javax.swing.JButton Btn_Select;
    private javax.swing.JTextField Txt_CallerAddress;
    private javax.swing.JTextField Txt_CallerAge;
    private javax.swing.JTextField Txt_CallerName;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
