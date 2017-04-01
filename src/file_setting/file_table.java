/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_setting;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author MuHamd Gomaa
 */
public class file_table {
       SimpleIntegerProperty fileid;
        SimpleStringProperty diagnosis;

    SimpleStringProperty complain;
    SimpleStringProperty history;

    
    SimpleStringProperty examination;
        SimpleStringProperty invest;
    SimpleStringProperty patientid;
    
//        SimpleStringProperty managment;
//    SimpleStringProperty date;

    
    
    
    
    
    
    
    

    public String getDiagnosis() {
        return diagnosis.get();
    }

    public void setdiagnosis(String diagnosis) {
        this.diagnosis.set(diagnosis);
                }
     public String getComplain() {
        return complain.get();
    }

    public void setcomplain(String complain) {
        this.complain.set(complain);
                }
    
    
    

    public String getHistory() {
        return history.get();
    }

    public void setExamination(String examination) {
        this.examination.set(examination);
    }

    public String getExamination() {
        return examination.get();
    }
     public String getInvest() {
        return invest.get();
    }
    
   
    public void setInvest(String invest) {
        this.invest.set(invest);
    }
      public void sethistory(String history) {
        this.history.set(history);
    }

    public String getPatientId() {
        return patientid.get();
    }

    public void setpatientid(String patientid) {
        this.patientid.set(patientid);
    }


    public file_table(Integer fileid, String diagnosis, String complain,String history, String examination, String invest, String patientid) {
        this.fileid = new SimpleIntegerProperty(fileid);
        this.complain = new SimpleStringProperty(complain);
        this.diagnosis= new SimpleStringProperty(diagnosis);
        this.examination =new SimpleStringProperty(examination);
        this.invest=new SimpleStringProperty(invest);
        this.patientid = new SimpleStringProperty(patientid);
        this.history= new SimpleStringProperty(history);
               
        
    }
    
    public file_table(Integer fileid, String diagnosis, String complain,String history, String examination, String invest) {
        this.fileid = new SimpleIntegerProperty(fileid);
        this.complain = new SimpleStringProperty(complain);
        this.diagnosis= new SimpleStringProperty(diagnosis);
        this.examination =new SimpleStringProperty(examination);
        this.invest=new SimpleStringProperty(invest);
        this.history= new SimpleStringProperty(history);
        
        

    }


    
    public Integer getFileid() {
        return fileid.get();
    }
    
    public void setFileId(int fileid) {
        this.fileid.set(fileid);
    }
    
    
    
    
    
}
