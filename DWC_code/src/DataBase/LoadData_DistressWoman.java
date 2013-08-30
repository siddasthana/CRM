/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import DataBase.Tables.Accused;
import DataBase.Tables.Agent;
import DataBase.Tables.CaseHistory;
import DataBase.Tables.Calls;
import DataBase.Tables.Caller;
import DataBase.Tables.Cases;
import DataBase.Tables.Directory;
import DataBase.Tables.Telephone;
import View.Dlg_SearchCaller;
import View.Dlg_SearchComplain;
import View.Dlg_SelectCaller;
import View.Dlg_SelectCase;
import View.Dlg_distressWoman;
import View.Elements.Pnl_CallElement;
import View.Elements.Pnl_CallerElement;
import View.Elements.Pnl_CaseElement;
import View.Elements.Pnl_CaseHistoryElement;
import View.Global;
import View.ParentForm;
import View.Screen_TeleExecutive;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 *
 * @author admin
 */
public class LoadData_DistressWoman {

    Screen_TeleExecutive st;
    Dlg_distressWoman dc;
    Dlg_SearchCaller dlg_sc;
    Dlg_SearchComplain dlg_scmpl;
    Calls cl;
    boolean newcaller = false, newcase = false;
    ArrayList<Calls> calls;
    ArrayList<Caller> callers;
    ArrayList<Cases> cases;
    ArrayList<CaseHistory> caseHistory;
    ArrayList<Telephone> telephones;
    ArrayList<Directory> directory;
    ArrayList<Accused> accused;

    public LoadData_DistressWoman(Screen_TeleExecutive str) {
        this.st = str;
        dc = (Dlg_distressWoman) st.Dlg_distressWoman;

        //if (dc.populatingcaller) {
        PreviousCallFromSameNumber(st.pf.getServing());
        PopulateCaller(); // Add casehistory to arraylist of selected caller
        //}
        if (dc.newcaller) {
        } else {
        }
        //if (dc.populatingcase) {
        FindCaseHistory(); //Search for Parent case for children History ID
        PopulateCase(); // Give user to select the case
        PopulateCaseHistory();
        //}
        PopulateDirectories();
        PopulateAccuse();

        ArrayList<Telephone> tp = new Telephone().loadclass(" Number =" + st.pf.getServing());
        //fetch recent Case history -->> call ->> caller
        //  CaseHistory ch = new CaseHistory().loadclass(" idCase_History="+ tp.get(0).getCaseHid()).get(0);

        //    cl = new Calls().loadclass(" CaseHID=" + tp.get(0).getCaseHid()).get(0);
        //  Caller clr = new Caller().loadclass(" CallID=" + cl.getId()).get(0);

        //Populating the GUI fields

//        dc.getTxt_CallerName().setText(clr.getName());
        //       dc.getTxt_CallerAddress().setText(clr.getAddress());
        //      dc.getTxt_CallerAge().setText(clr.getAge());
        //     dc.getTxt_CallerPhone().setText(st.pf.getServing());
        //     System.out.println(tp.size());
        //     System.out.println(tp.get(0).getNote());

//populating Case directory
        Fill_caseDirectory();
        //populating record directory
        Fill_recordDirectory();
        //populating accused
        Fill_accusedPanel();
    }

    private void Fill_recordDirectory() {
        for (Calls cl : calls) {
            try {
                ArrayList<Telephone> tl = new Telephone().loadclass(" CaseHID = " + cl.getCaseHID());

                for (Telephone cntacts : tl) {
                    Pnl_CallElement pce_record = new Pnl_CallElement();
                    pce_record.Lbl_CallElement_Name.setText(cntacts.getNote());
                    pce_record.Lbl_CallElement_number.setText(String.valueOf(cntacts.getNumber()));
                    dc.Pnl_RecrdDirctry.add(pce_record);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void Fill_caseDirectory() {
        ArrayList<DataBase.Tables.Directory> Dr = new DataBase.Tables.Directory().loadclass(" Area ='as'");


    }

    private void Fill_accusedPanel() {
    }

    private void PreviousCallFromSameNumber(String Number) {
        calls = new Calls().loadclass("CaseHID IS NOT NULL and Number =" + Number);

    }

    private void PopulateCaller() {
        boolean research = false;
        ArrayList<Pnl_CallerElement> Pce = new ArrayList<>();
        callers = new ArrayList<>();
        final Dlg_SelectCaller dsc = new Dlg_SelectCaller(st.pf, true);
        if (calls.size() > 0) {
            for (Calls cl : calls) {
                Caller e = null;
                try {
                    e = new Caller().loadclass(" CallID=" + cl.getCaseHID()).get(0);
                } catch (Exception err) {
                    continue;
                }
                if (callers.isEmpty()) {
                    callers.add(e);
                    Pnl_CallerElement obj = new Pnl_CallerElement();
                    obj.LoadElement(e);
                    Pce.add(obj);
                } else {
                    // Check for redundancy
                    int size = callers.size();
                    for (Caller ob : callers) {

                        if (ob.getName().equals(e.getName())) {
                            if (ob.getAge().equals(e.getAge())) {
                                if (ob.getAddress().equals(e.getAddress())) {
                                    for (Pnl_CallerElement temp : Pce) {
                                        if (temp.getTxt_CallerName().getText().equals(e.getName())) {
                                            if (temp.getTxt_CallerAge().getText().equals(e.getAge())) {
                                                if (temp.getTxt_CallerAddress().getText().equals(e.getAddress())) {
                                                    temp.CaseHID.add(ob.getCallid());
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    break;
                                }

                            }

                        }
                        size--;
                    }
                    if (size == 0) {
                        callers.add(e);
                        Pnl_CallerElement obj = new Pnl_CallerElement();
                        obj.LoadElement(e);
                        Pce.add(obj);
                    }
                }
            }

        }
        for (Pnl_CallerElement ob : Pce) {
            dsc.jPanel1.add(ob);
            //dsc.jScrollPane1.add(ob);
            System.out.println("Adding caller element");
        }
        JButton btn_searchcaller = new JButton("Search a Caller");
        btn_searchcaller.setSize(btn_searchcaller.getPreferredSize());
        btn_searchcaller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dlg_sc = new Dlg_SearchCaller(st.pf, false);

                //dsc.setVisible(false);
                //dsc.dispose();
            }
        });
        dsc.jPanel1.add(btn_searchcaller);



        JButton btn_newcaller = new JButton("Add a new Caller");
        btn_newcaller.setSize(btn_newcaller.getPreferredSize());
        btn_newcaller.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dc.newcaller = true;
                dsc.setVisible(false);
                //dsc.dispose();
            }
        });
        dsc.jPanel1.add(btn_newcaller);

        //       dsc.jPanel1.updateUI();
        //      dsc.jPanel1.repaint();
        //     dsc.repaint();
        dsc.jPanel1.setSize(dsc.jPanel1.getPreferredSize());
        //dsc.setSize(dsc.getPreferredSize());
        dsc.show(true);
        System.out.println("Updating fields..");
        dc.CaseHid = dsc.CaseHID;

        System.out.println(dsc.CaseHID);

        dc.getTxt_CallerName().setText(dsc.Name);
        dc.getTxt_CallerAddress().setText(dsc.Address);
        dc.getTxt_CallerAge().setText(dsc.Age);
        dc.getTxt_CallerPhone().setText(st.pf.getServing());
    }

    private void PopulateCase() {
        ArrayList<Long> caseid = new ArrayList<>();
        if (caseHistory != null) {
            for (CaseHistory e : caseHistory) {
                System.out.println("Adding case ID");
                caseid.add(e.getCaseID());
            }
        }
        final Dlg_SelectCase dscs = new Dlg_SelectCase(st.pf, true);
        String caselist = caseid.toString();
        caselist = caselist.replace("[", "(");
        caselist = caselist.replace("]", ")");
        if (caselist.length() > 2) {
            cases = new Cases().loadclass(" idCase IN " + caselist);
            for (Cases ob : cases) {
                System.out.println("Adding Cases");
                Pnl_CaseElement obj = new Pnl_CaseElement();
                obj.LoadElement(ob);
                // Global.LoadCaseElement(obj, ob);
                System.out.println("<Case Details>" + ob.getPoliceStn() + "," + ob.getForward() + "," + ob.getStatus());
                dscs.jPanel1.add(obj);
                //dsc.jScrollPane1.add(ob);
                System.out.println("Adding case element");
            }
        }
        JButton btn_searchcase = new JButton("Search a Case");
        btn_searchcase.setSize(btn_searchcase.getPreferredSize());
        btn_searchcase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dscs.setVisible(false);
                dlg_scmpl = new Dlg_SearchComplain(st.pf, true);
                dscs.dispose();
            }
        });
        dscs.jPanel1.add(btn_searchcase);



        JButton btn_newcase = new JButton("Add a new Case");
        btn_newcase.setSize(btn_newcase.getPreferredSize());
        btn_newcase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dc.newcase = true;
                dscs.setVisible(false);
                dscs.dispose();
            }
        });
        dscs.jPanel1.add(btn_newcase);
        dscs.jPanel1.setSize(dscs.jPanel1.getPreferredSize());
        dscs.jPanel1.updateUI();
        dscs.jPanel1.repaint();
        dscs.repaint();
        //dscs.setSize(dscs.getPreferredSize());
        dscs.show(true);
        System.out.println("Updating case fileds..");
        if (!dc.newcase) {
            dc.CaseID = Long.valueOf(dscs.id);

            System.out.println("Got Case ID:" + dc.CaseID);

            dc.getSrchFld_Complaint().setText(dscs.ReadableName);
            dc.getSrchFld_PoliceStne().setText(dscs.PoliceStn);
            //setSelectedValue(dc.getCmbBx_PoliceDistrict(),dscs.ooo)
            //dc.getCmbBx_CaseType()= dscs.castype;
            setSelectedValue(dc.getCmbBx_Forward(), dscs.Forward);
            setSelectedValue(dc.getCmbBx_CaseStatus(), dscs.Status);
            //    dc.getTxt_CaseStatus().setText(dscs.Status);
        }
//        dc.newcaller = dsc.newcaller;
        //      dc.getTxt_CallerName().setText(dsc.Name);
        //    dc.getTxt_CallerAddress().setText(dsc.Address);
        //   dc.getTxt_CallerAge().setText(dsc.Age);
        //  dc.getTxt_CallerPhone().setText(st.pf.getServing());
    }

    private void PopulateDirectories() {
    }

    private void FindCaseHistory() {
        String casehlist = dc.CaseHid.toString();
        casehlist = casehlist.replace("[", "(");
        casehlist = casehlist.replace("]", ")");

        System.out.println("<PopulateCaseHistory>" + casehlist);
        if (casehlist.length() > 2) {
            caseHistory = new CaseHistory().loadclass(" idCase_History IN " + casehlist);
        }
    }

    private void PopulateAccuse() {
    }

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

    private void PopulateCaseHistory() {
        System.out.println("Adding case elements");
        caseHistory = new CaseHistory().loadclass(" CaseID =" + dc.CaseID + " order by DateStamp DESC");
        for (CaseHistory ch : caseHistory) {
            Pnl_CaseHistoryElement obj = new Pnl_CaseHistoryElement();
            obj.LoadElement(ch);
            dc.Pnl_CaseHistory.add(obj);
        }
    }
}
