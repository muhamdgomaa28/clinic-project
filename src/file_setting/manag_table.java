/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_setting;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author MuHamd Gomaa
 */
public class manag_table {
    
    
    SimpleStringProperty managment;

    SimpleStringProperty date;
    
    public String getManagment() {
        return managment.get();
    }

    public void setManagment(String managment) {
        this.managment.set(managment);
                }
    
    
    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
                }
    
    
    public manag_table(String managment,String date){
    
     this.managment= new SimpleStringProperty(managment);
        this.date= new SimpleStringProperty(date);
    
    }
    
    
}
