/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.Date;

/**
 *
 * @author Achal Sancheti
 */
public class AppointmentWorkRequest extends WorkRequest {
    
    private String date1;
    private String time1;

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }
    
    

    public String getTime1() {
        return time1;
    }

//    public String getDate1() {
//        return date1;
//    }
//
//    public void setDate1(String date1) {
//        this.date1 = date1;
//    }
    public void setTime1(String time1) {
        this.time1 = time1;
    }

    @Override
    public String toString() {
        return date1;
    }


    
    
}
