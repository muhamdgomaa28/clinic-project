package patient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import database.database;
import file_setting.Create_fileController;
import file_setting.File_settingController;
import java.beans.EventHandler;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MuHamd Gomaa
 */
public class PatientController implements Initializable {

    @FXML
    private AnchorPane start;
    @FXML
    private Label Id;

    @FXML
    private Label pp;

    @FXML
    private TableView<patient_table> patient_table;

    @FXML
    private TableColumn<patient_table, Integer> id;

    @FXML
    private TableColumn<patient_table, String> name;

    @FXML
    private TableColumn<patient_table, String> age;

    @FXML
    private TableColumn<patient_table, String> address;

    @FXML
    private TableColumn<patient_table, String> phone;

    @FXML
    private TableColumn<patient_table, String> birth;

    @FXML
    private TableColumn<patient_table, String> weight;

    @FXML
    private TableColumn<patient_table, String> c_gender;

    @FXML
    private DatePicker date;
    @FXML
    private JFXTextField pid;

    @FXML
    private JFXTextField pname;

    @FXML
    private JFXTextField paddress_txt;

    @FXML
    private JFXTextField phone_txt;

    @FXML
    private JFXTextField page_txt;

    @FXML
    private JFXTextField weight_txt;
    @FXML
    private JFXButton btn_delete;

    @FXML
    private JFXButton btn_ubdate;

    @FXML
    private JFXTextField search;

    @FXML
    private ImageView ima8;

    @FXML
    private Label lsearch;

    @FXML
    private JFXButton btn_register;

    @FXML
    private JFXButton btn_creare;
    @FXML
    private Label glabel;

    @FXML
    private JFXComboBox<String> compo;

    @FXML
    private Label lcreate;
    ObservableList<patient_table> list = FXCollections.observableArrayList();
   // FilteredList<patient_table> filterddata = new FilteredList<>(list, e -> true);
/////////////////////////////////

    FilteredList<patient_table> filterddata = new FilteredList<>(list,e -> true);
    @FXML
    public void search_patients() {
        search.textProperty().addListener((ObservableValue, oldvalue, newvalue) -> {
            filterddata.setPredicate((Predicate<patient_table>) p -> {

                if (newvalue == null || newvalue.isEmpty()) {
                    return true;

                }
                String lowercasefilter = newvalue.toLowerCase();
                if (p.getName().toLowerCase().contains(lowercasefilter)) {
                    return true;
                }
                if (p.getBirth().toLowerCase().contains(lowercasefilter)) {
                    return true;
                }
                if (p.getAddress().toLowerCase().contains(lowercasefilter)) {
                    return true;
                }
                if (p.getPhone().toLowerCase().contains(lowercasefilter)) {
                    return true;
                }

                return false;
            });

        });
        SortedList<patient_table> sorteddata = new SortedList<>(filterddata);

        sorteddata.comparatorProperty().bind(patient_table.comparatorProperty());
        patient_table.setItems(sorteddata);

    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        javafx.scene.image.Image im8 = new javafx.scene.image.Image(getClass().getResourceAsStream("ssss.png"));
        ima8.setImage(im8);

        id.setCellValueFactory(new PropertyValueFactory<patient_table, Integer>("id"));

        name.setCellValueFactory(new PropertyValueFactory<patient_table, String>("name"));

        address.setCellValueFactory(new PropertyValueFactory<patient_table, String>("address"));
        age.setCellValueFactory(new PropertyValueFactory<patient_table, String>("age"));
        phone.setCellValueFactory(new PropertyValueFactory<patient_table, String>("phone"));
        birth.setCellValueFactory(new PropertyValueFactory<patient_table, String>("birth"));
        weight.setCellValueFactory(new PropertyValueFactory<patient_table, String>("weight"));
        c_gender.setCellValueFactory(new PropertyValueFactory<patient_table, String>("gender"));

        compo.getItems().addAll("male", "female");
        patient_table.getItems().addAll(list);
        database dd = null;
        try {
            dd = new database();
        } catch (SQLException ex) {
            Logger.getLogger(PatientController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PatientController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ///////////
        List<patient_table> ll = dd.select_patients();
        for (patient_table ui : ll) {
            int r = ui.getId();
            String t = ui.getName();
            String o = ui.getAge();
            String s = ui.getAddress();
            String v = ui.getPhone();
            String w = ui.getWeight();
            String p = ui.getBirth();
            String a = ui.getGender();

            list.add(new patient_table(r, t, o, s, v, p, w, a));
        }
//                    course_table.getItems().add(list);
        patient_table.setItems(list);
        ////////////

        patient_table.setOnMouseClicked(new javafx.event.EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (!patient_table.getSelectionModel().isEmpty()) {

                    patient_table c = (patient_table) patient_table.getSelectionModel().getSelectedItem();
                    pid.setText(String.valueOf(c.getId()));
                    pname.setText(c.getName());
                    paddress_txt.setText(c.getAddress());
                    page_txt.setText(c.getAge());
                    phone_txt.setText(c.getPhone());
                    // date.setValue(c.);
                    weight_txt.setText(c.getWeight());
                    compo.setValue(c.getGender());

                }

            }
        });

    }

    @FXML
    public void mouse_eventt(MouseEvent ee) throws SQLException, ClassNotFoundException {
        database dd = new database();

        String nametxt = pname.getText();
        String agetxt = page_txt.getText();
        String addresstxt = paddress_txt.getText();
        String phonetxt = phone_txt.getText();
        String birthtxt = date.getEditor().getText();
        String weighttxt = weight_txt.getText();

        String arr[] = {nametxt, agetxt, addresstxt, phonetxt, birthtxt, weighttxt};
        String arr2[] = {"please enter patient name ,", " enter age  ,", "enter patient address ,", " enter patient phone , ", "enter birth date , ", " weight requierd "};
        String message = "";

        //// on number valid
        String arrtext[] = {agetxt, phonetxt, weighttxt};
        String arrmess[] = {"  age cant be letter character   ,", " phone  cant be letter character  ,", " weight cant be letter character  , "};
        String message2 = "";

        ResultSet patientvalid = dd.validation_exist_patient();
        Vector<String> namevalid = dd.validation_name();
        Vector<String> addrvalid = dd.validation_addr();
        Vector<String> phonevalid = dd.validation_phone();
        Vector<String> birthvalid = dd.validation_birth();

        if (ee.getSource() == btn_register) {
            // validation 

            if (nametxt.equals("") || agetxt.equals("") || addresstxt.equals("") || phonetxt.equals("") || birthtxt.equals("") || weighttxt.equals("")) {

                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].equals("")) {
                        message += arr2[i];

                    }

                }
                JOptionPane.showMessageDialog(null, message);

            } else if (!nametxt.matches("[a-zA-Z_]+")) {
                JOptionPane.showMessageDialog(null, " name must be letter only");

                //valid nmuber
            } else if (!agetxt.matches("[0-9]+") || !phonetxt.matches("[0-9]+") || !weighttxt.matches("[0-9]+")) {

                for (int i = 0; i < arrtext.length; i++) {
                    if (!arrtext[i].matches("[0-9]+")) {
                        message2 += arrmess[i];

                    }

                }
                JOptionPane.showMessageDialog(null, message2);

            }else if(namevalid.contains(nametxt)){
                String name = "";
                String phone = "";
                String adress = "";
                String birth = "";
                int ff = 0;
                System.out.println(" in if ");
                while (patientvalid.next()) {
                    name = patientvalid.getString("name");
                    phone = patientvalid.getString("phone");
                    adress = patientvalid.getString("address");
                    birth = patientvalid.getString("birth");

                    System.out.println("n   " + name + "ph  " + phone + "a " + adress + "b   " + birth);
                    System.out.println("nam        " + nametxt + "pho     " + phonetxt + "aa   " + addresstxt + "bb   " + birthtxt);
                 if (nametxt.equals(name) && addresstxt.equals(adress) && birthtxt.equals(birth) && phonetxt.equals(phone)) {
                        System.out.println("موجووووود");
                        ff=1;
                        JOptionPane.showMessageDialog(null, "the patient exist before go to view to show his file");
                      break;
                    }
                }
                if(ff==0){
    dd.register_patient(nametxt, agetxt, addresstxt, phonetxt, birthtxt, weighttxt, compo);
                for (int i = list.size() - 1; i >= 0; i--) {
                    list.remove(i);
                }
//select all item from database and set it in list
                List<patient_table> ll = dd.select_patients();
                for (patient_table ui : ll) {
                    int r = ui.getId();
                    String t = ui.getName();
                    String o = ui.getAge();
                    String s = ui.getAddress();
                    String v = ui.getPhone();
                    String w = ui.getWeight();
                    String p = ui.getBirth();
                    String a = ui.getGender();

                    list.add(new patient_table(r, t, o, s, v, p, w, a));
                }
                patient_table.setItems(list);                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           

                }
        
                

            } else {

                dd.register_patient(nametxt, agetxt, addresstxt, phonetxt, birthtxt, weighttxt, compo);
                System.out.println("sdfdfgdffedgdfvdfbvfbdb");
                System.out.println(new Date());
                for (int i = list.size() - 1; i >= 0; i--) {
                    list.remove(i);
                }
                System.out.println("++++++++++++++");
//select all item from database and set it in list
                List<patient_table> ll = dd.select_patients();
                for (patient_table ui : ll) {
                    int r = ui.getId();
                    String t = ui.getName();
                    String o = ui.getAge();
                    String s = ui.getAddress();
                    String v = ui.getPhone();
                    String w = ui.getWeight();
                    String p = ui.getBirth();
                    String a = ui.getGender();

                    list.add(new patient_table(r, t, o, s, v, p, w, a));
                }
//                    course_table.getItems().add(list);
                patient_table.setItems(list);

            }
        }

        if (ee.getSource() == btn_creare) {
            // select id of  specific patient 

            int id = 0;
            ResultSet ss = dd.select(pname.getText(), phone_txt.getText());

            while (ss.next()) {

                id = ss.getInt("id");

            }

            try {
                //// load name to next stage 
                FXMLLoader loder = new FXMLLoader();

                //    Parent ppp = loder.load(getClass().getResource("/file_setting/file_setting.fxml"));
                Parent tppp = loder.load(getClass().getResource("/file_setting/create_file.fxml").openStream());
                start.getChildren().clear();
                start.getChildren().add(tppp);
                Create_fileController filesetting = (Create_fileController) loder.getController();

                //  start.getStylesheets().add(getClass().getResource("/file_setting/file_setting.css").toExternalForm());
                filesetting.setname(pname.getText());
                filesetting.setid(id);

                // System.out.println("+++++++");
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
        if (ee.getSource() == btn_delete) {
            try {
                int id = 0;
                if (!pid.getText().equals("")) {
                    id = Integer.parseInt(pid.getText());
                }
                String idtext = pid.getText();
                if (idtext.equals("")) {

                    JOptionPane.showMessageDialog(null, "please select the patient u want to deleted in the table");
                } else {
              //      System.out.println("deleted " + id);

                    dd.delete(id);
//refresh table
                    for (int i = list.size() - 1; i >= 0; i--) {
                        list.remove(i);
                    }
//select all item from database and set it in list
                    List<patient_table> ll = dd.select_patients();
                    for (patient_table ui : ll) {
                        int r = ui.getId();
                        String t = ui.getName();
                        String o = ui.getAge();
                        String s = ui.getAddress();
                        String v = ui.getPhone();
                        String w = ui.getWeight();
                        String p = ui.getBirth();
                        String a = ui.getGender();

                        list.add(new patient_table(r, t, o, s, v, p, w, a));
                    }
//                    course_table.getItems().add(list);
                    patient_table.setItems(list);

                }
            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);
            }

        }
        if (ee.getSource() == btn_ubdate) {
            try {
                int id = 0;
                if (!pid.getText().equals("")) {
                    id = Integer.parseInt(pid.getText());
                }
                String idtext = pid.getText();
                if (idtext.equals("")) {

                    JOptionPane.showMessageDialog(null, "please select the patient u want to updated in the table");
                } else if (nametxt.equals("") || agetxt.equals("") || addresstxt.equals("") || phonetxt.equals("") || birthtxt.equals("") || weighttxt.equals("")) {

                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i].equals("")) {
                            message += arr2[i];

                        }

                    }
                    JOptionPane.showMessageDialog(null, message);

                } else if (!nametxt.matches("[a-zA-Z_]+")) {
                    JOptionPane.showMessageDialog(null, " name must be letter only");

                    //valid nmuber
                } else if (!agetxt.matches("[0-9]+") || !phonetxt.matches("[0-9]+") || !weighttxt.matches("[0-9]+")) {

                    for (int i = 0; i < arrtext.length; i++) {
                        if (!arrtext[i].matches("[0-9]+")) {
                            message2 += arrmess[i];

                        }

                    }
                    JOptionPane.showMessageDialog(null, message2);

                } else if (namevalid.contains(nametxt) && addrvalid.contains(addresstxt) && phonevalid.contains(phonetxt) && birthvalid.contains(birthtxt)) {

                    JOptionPane.showMessageDialog(null, "patient exist before go  to view manue to search his/her file ");

                } else {
              //      System.out.println("deleted " + id);

                    dd.update(id, nametxt, addresstxt, agetxt, phonetxt, birthtxt, weighttxt, compo);
//refresh table
                    for (int i = list.size() - 1; i >= 0; i--) {
                        list.remove(i);
                    }
//select all item from database and set it in list
                    List<patient_table> ll = dd.select_patients();
                    for (patient_table ui : ll) {
                        int r = ui.getId();
                        String t = ui.getName();
                        String o = ui.getAge();
                        String s = ui.getAddress();
                        String v = ui.getPhone();
                        String w = ui.getWeight();
                        String p = ui.getBirth();
                        String a = ui.getGender();

                        list.add(new patient_table(r, t, o, s, v, p, w, a));
                    }
//                    course_table.getItems().add(list);
                    patient_table.setItems(list);

                }
            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);
            }

        }

//     if(ee.getSource()==back){
//    
//    
//    try {
//            Parent ppp = FXMLLoader.load(getClass().getResource("/patient/patient.fxml"));
//            System.out.println("fgfgfgf");
//         start.getChildren().clear();
//            start.getChildren().add(ppp);
//        } catch (IOException ex) {
//          ex.printStackTrace();        }
//        
//        
//        
//    }    
    }

}
