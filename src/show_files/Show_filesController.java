/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package show_files;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author MuHamd Gomaa
 */
public class Show_filesController implements Initializable {

    @FXML
    private JFXTextField search;

    @FXML
    private JFXButton btn_search;

    @FXML
    private Label detail;

    @FXML
    private JFXButton file_btn;

    @FXML
    private JFXButton visit;

    @FXML
    private TableView<?> table_info;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> birthdate;

    @FXML
    private Label patientfile;

    @FXML
    private ScrollPane scrol;

    @FXML
    private AnchorPane ansh;

    @FXML
    private Label file;
    @FXML
    private TableView<?> managment_table;

    @FXML
    private TableColumn<?, ?> managment;

    @FXML
    private TableColumn<?, ?> date;
@FXML
    private VBox nnn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

  //  file.setText("sdfsdfsdfdfsd \n /n fsdfdfsdfsdfsdfsdfdsfsdfsdfsdfsdfsdfsdf/n \n s dfsdfsdfsdfsdfsdfsdfsdfsdfsdfdsfsdfsd \n fsdfsdfsd");
    file.setText("fddfdfvfvdfvd \n fwefef \n fegegegegegege\n          \rg\\grggrgtrgrgrg \n grgrggggfdgdfgdfg");
    scrol.setHmax(6);
    scrol.setHvalue(3);
   // nnn.getChildren().addAll(file,managment_table);
    
    //scrol.setContent(file);
          // scrol.setContent(managment_table);
    scrol.setFitToHeight(true);
        
    
    }    
    
}
