/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import file_setting.file_table;
import file_setting.manag_table;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import patient.patient_table;

/**
 *
 * @author MuHamd Gomaa
 */
public class database {
    
    static  Connection con = null;
    static PreparedStatement prm=null;
    static ResultSet rs= null;
        String url="jdbc:mysql://localhost/clinic_project?characterEncoding";

   public database() throws SQLException, ClassNotFoundException {
        Class.forName("org.gjt.mm.mysql.Driver");
        con = (Connection) DriverManager.getConnection(url, "root", "");
       System.out.println("connected");
    }
   
    public static void register_patient(String name,String age,String address,String phone,String birth,String weight,ComboBox<String> gender){
    try{
    
        prm=con.prepareStatement("insert into patient_detail (name,age,address,phone,birth,weight,gender)values(?,?,?,?,?,?,?)");
      //  prm.setInt(1, id);
        prm.setString(1, name);
        prm.setString(2,age);
        prm.setString(3, address);
        prm.setString(4, phone);
      //  prm.setString(5,((TextField) birth.getEditor()).getText());
        prm.setString(5,birth);
        prm.setString(6, weight);
                prm.setString(7, gender.getSelectionModel().getSelectedItem());

        
        
        
        prm.execute();
        
        
        
        
        
        
    }catch(Exception ee){
        JOptionPane.showMessageDialog(null, ee);
    }
    
    
    
    
    
    
    }
     public static List<patient_table> select_patients(){
        
        
          ArrayList<patient_table> list = new ArrayList<>();
      try{
      prm=con.prepareStatement("select id,name ,age,address,phone,birth,weight,gender from patient_detail");
      
      rs = prm.executeQuery();
        while(rs.next()){
            int id =rs.getInt("id");
            String name=rs.getString("name");
            String age= rs.getString("age");
                        String phone= rs.getString("phone");

                        String address= rs.getString("address");
                              String weight= rs.getString("weight");
                        String birth= rs.getString("birth");
                                                String gender= rs.getString("gender");


            patient_table ud = new patient_table(id, name, age, address, phone, birth, weight,gender);
            list.add(ud);
            
        }
        
    return list;
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
        return null;
      }
        
        }
     
       public static void delete(int id) throws SQLException, ClassNotFoundException {
      
    prm=con.prepareStatement("delete from patient_detail where id=?");
    
    prm.setInt(1, id);
    
    
    prm.executeUpdate();
    
    
    }
        public static void update(int id,String name ,String address,String age,String phone,String birth,String weight,ComboBox<String> gender) throws SQLException{
         
         try{
        prm = con.prepareStatement("update `patient_detail` set name=?,address=?,age=?,phone=?,birth=?, weight=? ,gender=? where id=?");
 //  prm.setString(1, name);
        prm.setString(1, name);
        prm.setString(2, address);
        prm.setString(3, age);
        prm.setString(4, phone);
        prm.setString(5,birth);
        prm.setString(6, weight);
                prm.setString(7, gender.getSelectionModel().getSelectedItem());

        prm.setInt(8, id);
         }catch(Exception e){
          JOptionPane.showMessageDialog(null,e);
         }
        
        
        prm.executeUpdate();
        
    }
   
   //////////////////////////////////////////////////file///////
     public static void create_file(int id,String diagnosis,String complain,String history,String examination,String invest,int patient_id,String managment,String date){
    try{
    
        prm=con.prepareStatement("insert into file (id,diagnosis,complain,history,examination,invest,patient_id)values(?,?,?,?,?,?,?)");
       prm.setInt(1, id);
        prm.setString(2, diagnosis);
        prm.setString(3, complain);
        prm.setString(4, history);
      //  prm.setString(5,((TextField) birth.getEditor()).getText());
        prm.setString(5,examination);
        prm.setString(6, invest);
                prm.setInt(7,patient_id);
        prm.execute();
        prm=con.prepareStatement("insert into managment values(?,?,?)");
        
        prm.setString(1, date);
                prm.setString(2, managment);

         prm.setInt(3, id);
                prm.execute();

        
        
        
    }catch(Exception ee){
        JOptionPane.showMessageDialog(null, ee);
    }
    
    }
     public static List<file_table> select_file(int idd ,String serachtxt){
        
        
          ArrayList<file_table> list = new ArrayList<>();
      try{
      prm=con.prepareStatement("select file.id,diagnosis ,complain,history,examination,invest from file join patient_detail on patient_detail.id=file.patient_id and patient_detail.id= ? and patient_detail.name= ?");
      prm.setInt(1, idd);
      prm.setString(2, serachtxt);
      
      rs = prm.executeQuery();
        while(rs.next()){
            int id =rs.getInt("id");
            String dia=rs.getString("diagnosis");
            String com= rs.getString("complain");
                        String his= rs.getString("history");

                        String exam= rs.getString("examination");
                              String invest= rs.getString("invest");

file_table ff =new file_table(id, dia, com, his, exam, invest);
        list.add(ff);
            
        }
        
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
        return null;
      }
            return list;

        }
     //select mang and date 
     public static List<manag_table> select_managment(String fileid){
        
        
          ArrayList<manag_table> list = new ArrayList<>();
      try{
      prm=con.prepareStatement("select managment.managment,managment.date from file JOIN managment on managment.fileid=file.id and  file.id = ? ");
      prm.setString(1, fileid);
      rs = prm.executeQuery();
        while(rs.next()){
            

                        String date= rs.getString("date");
                              String managment= rs.getString("managment");
            list.add(new manag_table(managment, date));
//file_table ff =new file_table(id, dia, com, his, exam, invest);
      //  list.add(ff);
            
        }
        
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
        return null;
      }
            return list;

        }
     ////////select specific name and birth
     public ResultSet select(String name,String phone) throws SQLException{
     prm=con.prepareStatement("select * from patient_detail where name =? and phone=? ");
      prm.setString(1, name);
            prm.setString(2, phone);

      rs = prm.executeQuery();
     
     return rs;
     }
     
     
     /////////////////////////// validation .///////////////////////////
      public ResultSet validation_exist_patient() throws SQLException{
     prm=con.prepareStatement("select * from patient_detail ");
      rs = prm.executeQuery();
     
     return rs;
     }
     
     
     
     
     
     
     
     
     
     
     
      public static Vector<String> validation_name(){
        
         ObservableList lis=FXCollections.observableArrayList();
    try{
        prm=con.prepareStatement("select name from patient_detail ");
        
        Vector v=new Vector();
        rs=prm.executeQuery();
        while(rs.next()){
      
            v.add(rs.getString("name"));
            
        }
        return v;
        
   }catch(Exception ee){
              JOptionPane.showMessageDialog(null, ee);
return null;
    }
        
   }
       public static Vector<String> validation_phone(){
        
         ObservableList lis=FXCollections.observableArrayList();
    try{
        prm=con.prepareStatement("select phone from patient_detail ");
        
        Vector v=new Vector();
        rs=prm.executeQuery();
       while(rs.next()){
      
            v.add(rs.getString("phone"));
            
        }
        return v;
        
    }catch(Exception ee){
              JOptionPane.showMessageDialog(null, ee);
return null;
    }
//        
    }
//     
     public static Vector<String> validation_birth(){
        
         ObservableList lis=FXCollections.observableArrayList();
    try{
        prm=con.prepareStatement("select birth from patient_detail ");
        
        Vector v=new Vector();
        rs=prm.executeQuery();
        while(rs.next()){
//      
            v.add(rs.getString("birth"));
//            
        }
        return v;
        
    }catch(Exception ee){
              JOptionPane.showMessageDialog(null, ee);
return null;
    }
        
    }
     public static Vector<String> validation_addr(){
        
         ObservableList lis=FXCollections.observableArrayList();
    try{
        prm=con.prepareStatement("select address from patient_detail ");
        
        Vector v=new Vector();
        rs=prm.executeQuery();
        while(rs.next()){
      
            v.add(rs.getString("address"));
            
        }
        return v;
        
    }catch(Exception ee){
              JOptionPane.showMessageDialog(null, ee);
return null;
    }
        
    }
      public static Vector<Integer> validation_fileid(){
        
         ObservableList lis=FXCollections.observableArrayList();
    try{
        prm=con.prepareStatement("select id from file ");
        
        Vector v=new Vector();
        rs=prm.executeQuery();
        while(rs.next()){
      
            v.add(rs.getInt("id"));
            
        }
        return v;
        
    }catch(Exception ee){
              JOptionPane.showMessageDialog(null, ee);
return null;
    }
        
    }
      // validation تكرار ال id 
      public static Vector<Integer> validation_patient_id(){
        
         ObservableList lis=FXCollections.observableArrayList();
    try{
        prm=con.prepareStatement("select patient_id from file ");
        
        Vector v=new Vector();
        rs=prm.executeQuery();
        while(rs.next()){
      
            v.add(rs.getInt("patient_id"));
            
        }
        return v;
        
    }catch(Exception ee){
              JOptionPane.showMessageDialog(null, ee);
return null;
    }
        
    }
     
     
     
     
     
     
     public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
         
         database gg = new database();
          
//         
//         List<file_table> ff =gg.select_file("moha");
//         System.out.println(ff.size());
//         
         
    }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
