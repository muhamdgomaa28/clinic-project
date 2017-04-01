/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author MuHamd Gomaa
 */
public class patient_table {
    
       
    SimpleIntegerProperty id;
        SimpleStringProperty address;
        SimpleStringProperty gender;

    SimpleStringProperty name;
    SimpleStringProperty age;

    
    SimpleStringProperty phone;
        SimpleStringProperty birth;
    SimpleStringProperty weight;

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
                }
    
      public String getGender() {
        return gender.get();
    }

    public void setGender(String gender) {
        this.gender.set(gender);
                }
    
    
    
    
    
    
    
    
    
    
    
    
    
     public String getAge() {
        return age.get();
    }

    public void setAge(String age) {
        this.age.set(age);
                }
    
    
    

    public String getAddress() {
        return address.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getPhone() {
        return phone.get();
    }
     public String getWeight() {
        return weight.get();
    }
    
   
    public void setWeight(String weight) {
        this.weight.set(weight);
    }
      public void setAddress(String address) {
        this.address.set(address);
    }

    public String getBirth() {
        return birth.get();
    }

    public void setBirth(String birth) {
        this.birth.set(birth);
    }


    public patient_table(Integer id, String name, String age,String address, String phone, String birth, String weight,String gender) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.address = new SimpleStringProperty(address);
        this.age =new SimpleStringProperty(age);
        this.phone =new SimpleStringProperty(phone);
        this.birth = new SimpleStringProperty(birth);
        this.weight = new SimpleStringProperty(weight);
                this.gender = new SimpleStringProperty(gender);

    }


    
    public Integer getId() {
        return id.get();
    }
    
    public void setId(int id) {
        this.id.set(id);
    }
    
    
}
