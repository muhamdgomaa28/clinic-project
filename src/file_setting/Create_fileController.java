/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_setting;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import database.database;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javax.swing.JOptionPane;
import patient.PatientController;

/**
 * FXML Controller class
 *
 * @author MuHamd Gomaa
 */
public class Create_fileController implements Initializable {

    @FXML
    private Label lid;

    @FXML
    private Label ldiagnos;

    @FXML
    private Label lcom;

    @FXML
    private Label lhistory;
    @FXML
    private AnchorPane start;
    @FXML
    private Label lexamin;

    @FXML
    private Label linvest;

    @FXML
    private Label lmanag;

    @FXML
    private Label ldate;

    @FXML
    private JFXTextField fileid_txt;

    @FXML
    private JFXTextField dagnosis_txt;

    @FXML
    private JFXTextField complain_txt;

    @FXML
    private JFXTextField history_txt;

    @FXML
    private JFXTextField exam_txt;

    @FXML
    private JFXTextField invest_txt;

    @FXML
    private JFXTextField manage_txt;

    @FXML
    private JFXDatePicker datepic;

    @FXML
    private JFXButton btn_save;

    @FXML
    private JFXButton btn_delete;

    @FXML
    private JFXButton btn_ubdate;

    @FXML
    private JFXButton clear_btn;

    @FXML
    private JFXButton back;

    @FXML
    private Label namelabl;

    @FXML
    private Label lid1;

    @FXML
    private Label ldiagnos1;

    @FXML
    private Label lcom1;

    @FXML
    private Label lhistory1;

    @FXML
    private Label lexamin1;

    @FXML
    private Label linvest1;

    @FXML
    private Label lmanag1;

    @FXML
    private Label ldate1;

    @FXML
    private Label idl;

    @FXML
    private Label clabel;

    @FXML
    private Label mlabel;

    @FXML
    private Label elabel;

    @FXML
    private Label inlabel;

    @FXML
    private Label hlabel;

    @FXML
    private Label dlabel;

    @FXML
    private Label datelabel;

    @FXML
    private Label plabel;

    @FXML
    private Label patient_id;

    @FXML
    private ScrollPane scrolpane;

    @FXML
    private AnchorPane anchr;

    @FXML
    private Label diagnosis_l;

    @FXML
    private Label fileidlabel;

    @FXML
    private Label ci;

    @FXML
    private Label hi;

    @FXML
    private Label el;

    @FXML
    private Label il;

    @FXML
    private Label ml;

    @FXML
    private Label dl;

    @FXML
    private JFXButton btnrelod;

    @FXML
    private Label details_l;
      @FXML
    private Label i;

    @FXML
    private Label d;

    @FXML
    private Label c;

    @FXML
    private Label h;

    @FXML
    private Label e;

    @FXML
    private Label in;

    @FXML
    private Label m;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scrolpane.setDisable(true);
        ml.setFont(Font.font("Times New Roman"));

    }
          
    @FXML
    public void mouse_event(MouseEvent ee) {
        if (ee.getSource() == btn_save) {
             database dd = null;
            try {
                dd = new database();
            } catch (SQLException ex) {
                Logger.getLogger(PatientController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PatientController.class.getName()).log(Level.SEVERE, null, ex);
            }
            scrolpane.setDisable(false);
            
            String diotxt = dagnosis_txt.getText();
            String comtxt = complain_txt.getText();
            String histxt = history_txt.getText();
            String exantxt = exam_txt.getText();
            String investtxt = invest_txt.getText();
           // String patientidtxt = namelabl.getText();
            String managtxt = manage_txt.getText();
            String datetxt = datepic.getEditor().getText();
            String serch = namelabl.getText();
            
            int idd = Integer.parseInt(patient_id.getText());
            ////// validation on patient id 
                        Vector<Integer> patient_idd=dd.validation_patient_id();

            
            
        String arr[] = {diotxt,comtxt,histxt,exantxt,investtxt,managtxt};
        String arr2[] = {" diagnosis requierd  ,", "complain patient  is ? ,", " enter the history of patient , ", "enter exmination , ", " invest requierd ","enter  managment  "};
        String message = "";

            
            Vector<Integer> fileidd=dd.validation_fileid();
           
            
             int id = 0;
                if (!fileid_txt.getText().equals("")) {
                    id = Integer.parseInt(fileid_txt.getText());
                }
                String idtext = fileid_txt.getText();
                if (idtext.equals("")) {

                    JOptionPane.showMessageDialog(null, "you must enter file id");
                } else if(diotxt.equals("")||comtxt.equals("") || histxt.equals("") || exantxt.equals("") || investtxt.equals("") || managtxt.equals("")||datetxt.equals(" ")) {

                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].equals("")) {
                        message += arr2[i];

                    }

                }
                JOptionPane.showMessageDialog(null, message);
            
            }else if(fileidd.contains(id)||patient_idd.contains(idd))
            
            {
            
          JOptionPane.showMessageDialog(null,"the file id belongs to another patient ");
            
            }   else{
            
            dd.create_file(id, diotxt, comtxt, histxt, exantxt, investtxt, idd, managtxt, datetxt);

            System.out.println("++++++++++++++++++++++++++++");
            }
            
            
            
            
            
            
            

//select all item from database and set it in list
            List<file_table> ll = dd.select_file(idd, serch);

            System.out.println("list" + ll.size());
            for (file_table ui : ll) {
                int r = ui.getFileid();
                String t = ui.getDiagnosis();
                String o = ui.getComplain();
                String s = ui.getExamination();
                String v = ui.getHistory();
                String w = ui.getInvest();
                System.out.println(w);
                fileidlabel.setText(" " + String.valueOf(r));
                diagnosis_l.setText(" " + t);
                ci.setText(" " + o);
                el.setText(" " + s);
                hi.setText(" " + v);
                il.setText(" " + w);

            }

///for manage table//////////////////
            List<manag_table> lm = database.select_managment(fileid_txt.getText());
            for (manag_table uu : lm) {

                String d = uu.getDate();
                String m = uu.getManagment();
                dl.setText(" " + d);
                ml.setText(" " + m);

            }

        }

        if (ee.getSource() == back) {

            try {
                Parent ppp = FXMLLoader.load(getClass().getResource("/patient/patient.fxml"));
                System.out.println("fgfgfgf");
                start.getChildren().clear();
                start.getChildren().add(ppp);
            } catch (IOException ex) {
                ex.printStackTrace();

            }
        }
        if(ee.getSource()==btnrelod){
        
        fileid_txt.setText(fileidlabel.getText());
        dagnosis_txt.setText(diagnosis_l.getText());
        complain_txt.setText(ci.getText());
        history_txt.setText(hi.getText());
        invest_txt.setText(il.getText());
        manage_txt.setText(ml.getText());
        exam_txt.setText(el.getText());
        
        
        
        
        
        
        
        
        
        }
        
        
        
        
        
        
    }
//        

    //////////
    public void setname(String name) {

        namelabl.setText(name);

    }

    public void setid(int id) {

        patient_id.setText(String.valueOf(id));

    }

}
