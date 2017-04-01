/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author MuHamd Gomaa
 */
public class fxml implements Initializable {
    
    @FXML
    private AnchorPane home;
 @FXML
    private StackPane start;
    @FXML
    private Label lhome;
@FXML
    private Label label;
    @FXML
    private AnchorPane view;

    @FXML
    private Label lview;

    @FXML
    private AnchorPane patient;

    @FXML
    private Label lpatient;
 @FXML
    private AnchorPane prescription;

    @FXML
    private Label lprescription;
    @FXML
    private AnchorPane admin;

    @FXML
    private Label ladmin;
    @FXML
    private AnchorPane aboutus;

    @FXML
    private Label laboutus;

//    @FXML
//    private JFXHamburger hamburger;
//
//    @FXML
//    private JFXDrawer drawer;
//    @FXML
//    private AnchorPane exam;

//    @FXML
//    private Label exam_label;
    @FXML
    private ImageView ima1;
    @FXML
    private ImageView ima2;
    @FXML
    private ImageView ima3;
    @FXML
    private ImageView ima4;
    @FXML
    private ImageView ima5;
    @FXML
    private ImageView ima6;
     @FXML
    private ImageView ima7;
     
     @FXML
     public void mouse_Event(MouseEvent ee) throws IOException {

        if (ee.getSource() == patient) {
            System.out.println("patttt");

            Node p = FXMLLoader.load(getClass().getResource("/patient/patient.fxml"));

            
            start.getChildren().clear();

            start.getChildren().add(p);

        }
        if (ee.getSource() == home) {
            System.out.println("homme");

            Node p = FXMLLoader.load(getClass().getResource("start.fxml"));
            start.getChildren().clear();

            start.getChildren().add(p);
        }
//        }}
        if(ee.getSource()== view){
                        System.out.println("viewee");

        Node p = FXMLLoader.load(getClass().getResource("/show_files/show_files.fxml"));
        start.getChildren().clear();
        start.getChildren().add(p);
        
        }
         if(ee.getSource()== prescription){

        Node p = FXMLLoader.load(getClass().getResource("/priscription/prescription.fxml"));
        start.getChildren().clear();
        start.getChildren().add(p);
        
        }
//         if(ee.getSource()== admin){
//        Node p = FXMLLoader.load(getClass().getResource("/admin/admin.fxml"));
//        start.getChildren().clear();
//        start.getChildren().add(p);
//        
//        }
    
    
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         javafx.scene.image.Image im1 = new javafx.scene.image.Image(getClass().getResourceAsStream("home.png"));
        ima1.setImage(im1);
         javafx.scene.image.Image im2 = new javafx.scene.image.Image(getClass().getResourceAsStream("patient2.png"));
        ima2.setImage(im2);
         javafx.scene.image.Image im3 = new javafx.scene.image.Image(getClass().getResourceAsStream("search.png"));
        ima3.setImage(im3);
         javafx.scene.image.Image im5 = new javafx.scene.image.Image(getClass().getResourceAsStream("admin.png"));
        ima5.setImage(im5);
        javafx.scene.image.Image im6 = new javafx.scene.image.Image(getClass().getResourceAsStream("about2.png"));
        ima6.setImage(im6);
         javafx.scene.image.Image im4 = new javafx.scene.image.Image(getClass().getResourceAsStream("pre.png"));
        ima4.setImage(im4);
        
//         javafx.scene.image.Image im7 = new javafx.scene.image.Image(getClass().getResourceAsStream("11.jpg"));
//        ima7.setImage(im7);
        try {
            Parent ppp = FXMLLoader.load(getClass().getResource("start.fxml"));
//            pane.getChildren().clear();
            start.getChildren().add(ppp);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
        
//        
//        
//    }    
    }
    }
