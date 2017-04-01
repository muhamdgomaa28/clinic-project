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
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import patient.PatientController;
import patient.patient_table;

/**
 * FXML Controller class
 *
 * @author MuHamd Gomaa
 */
public class File_settingController implements Initializable {
    
    @FXML
    private TableView<file_table> file_table;
     @FXML
    private AnchorPane start;

    @FXML
    private TableColumn<file_table, Integer> fileid;

    @FXML
    private TableColumn<file_table, String> daignosis;

    @FXML
    private TableColumn<file_table, String> complain;

    @FXML
    private TableColumn<file_table, String> history;

    @FXML
    private TableColumn<file_table, String> examination;

    @FXML
    private TableColumn<file_table, String> invest;

   

    @FXML
    private JFXDatePicker datepic;

    @FXML
    private Label lid;

    @FXML
    private Label ldiagnos;

    @FXML
    private Label lcom;

    @FXML
    private Label lhistory;

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
    private JFXButton btn_save;

    @FXML
    private JFXButton btn_delete;
@FXML
    private JFXButton back;
    @FXML
    private JFXButton btn_ubdate;

    @FXML
    private JFXButton clear_btn;

    @FXML
    private JFXTextField search;

    @FXML
    private Label lsearch;
@FXML
    private ImageView ima9;


    @FXML
    private TableView<manag_table> manag_table;

    @FXML
    private TableColumn<manag_table, String> managment;

    @FXML
    private TableColumn<manag_table, String> date;

    
 ObservableList<file_table> list2 = FXCollections.observableArrayList();
 ObservableList<manag_table> managelist = FXCollections.observableArrayList();



/**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
javafx.scene.image.Image im9 = new javafx.scene.image.Image(getClass().getResourceAsStream("/patient/ssss.png"));
        ima9.setImage(im9);    
    
        
        
        
        fileid.setCellValueFactory(new PropertyValueFactory<file_table, Integer>("fileid"));

        daignosis.setCellValueFactory(new PropertyValueFactory<file_table, String>("diagnosis"));

        history.setCellValueFactory(new PropertyValueFactory<file_table, String>("history"));
       
        invest.setCellValueFactory(new PropertyValueFactory<file_table, String>("invest"));
                examination.setCellValueFactory(new PropertyValueFactory<file_table, String>("examination"));
                complain.setCellValueFactory(new PropertyValueFactory<file_table, String>("complain"));

                 managment.setCellValueFactory(new PropertyValueFactory<manag_table, String>("managment"));
        date.setCellValueFactory(new PropertyValueFactory<manag_table, String>("date"));
                
                

        file_table.getItems().addAll(list2);
              //  manag_table.getItems().addAll(managelist);

        
        
        
        
        
        
        
        
        
    }  
     @FXML
    public void mouse_eventt(MouseEvent ee){
        if(ee.getSource()==btn_save){
        
         database dd = null;
    try {
        dd = new database();
    } catch (SQLException ex) {
        Logger.getLogger(PatientController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(PatientController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    int id=Integer.parseInt(fileid_txt.getText());
    
        String diotxt = dagnosis_txt.getText();
String comtxt = complain_txt.getText();
String histxt = history_txt.getText();
String exantxt = exam_txt.getText();
String investtxt = invest_txt.getText();
    int patientidtxt = Integer.parseInt(search.getText());
    String managtxt = manage_txt.getText();
    String datetxt=datepic.getEditor().getText();
    String serch=search.getText();
//String idd=id

      dd.create_file(id, diotxt, comtxt, histxt, exantxt, investtxt, patientidtxt, managtxt, datetxt);
      
            System.out.println(datetxt);
            System.out.println("++++++++++++++++++++++++++++");
for (int i = list2.size() - 1; i >= 0; i--) {
                list2.remove(i);
            }
//select all item from database and set it in list
        //    List<file_table> ll = dd.select_file(serch);
//            
//            System.out.println("list"+ll.size());
//            for (file_table ui : ll) {
//                int r = ui.getFileid();
//                String t = ui.getDiagnosis();
//                String o = ui.getComplain();
//                String s = ui.getExamination();
//                String v = ui.getHistory();
//                String w = ui.getInvest();
//                         System.out.println(w);
//                list2.add(new file_table(r, t, o, v, s, w));
//            
//            }
            file_table.setItems(list2);
           // System.out.println("search"+serch);
           // System.out.println("+++"+list2.size());
                    ///for manage table//////////////////
                    for (int i = managelist.size() - 1; i >= 0; i--) {
                managelist.remove(i);
            }
                    List<manag_table> lm = database.select_managment(fileid_txt.getText());
            for (manag_table uu : lm) {
             
                String d = uu.getDate();
                String m = uu.getManagment();
                   
                managelist.add(new manag_table(d, m));
            
            }

                    manag_table.setItems(managelist);
                    
                   
        }
    
        
     if(ee.getSource()==back){
    
    
    try {
            Parent ppp = FXMLLoader.load(getClass().getResource("/patient/patient.fxml"));
            System.out.println("fgfgfgf");
         start.getChildren().clear();
            start.getChildren().add(ppp);
        } catch (IOException ex) {
          ex.printStackTrace();       
        
        }
     }
//        
//        
//    }    
    }
    
    
//    public void setname(String name){
//    
//    
//   search.setText(name);
//    
//    
//    
//    
//    }
    
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//}
