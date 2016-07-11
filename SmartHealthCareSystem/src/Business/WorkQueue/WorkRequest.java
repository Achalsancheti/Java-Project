/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.MainUserAccount.MainUserAccount;

/**
 *
 * @author Achal Sancheti
 */
public abstract class WorkRequest {

    private String name;
    private int age;
    private String date;
    private String isActive;
    private int phoneNumber;
    private String time;
    int ID = (int )(Math.random() * 500000 + 1);
    private String status;
    private MainUserAccount Receiver;
    private MainUserAccount Sender;

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public MainUserAccount getReceiver() {
        return Receiver;
    }

    public void setReceiver(MainUserAccount Receiver) {
        this.Receiver = Receiver;
    }

    public MainUserAccount getSender() {
        return Sender;
    }

    public void setSender(MainUserAccount Sender) {
        this.Sender = Sender;
    }    

    @Override
    public String toString() {
        return name;
    }
    
    
    
}