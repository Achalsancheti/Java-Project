/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.MainUserAccount;

import Business.Employee.Employee;
import Business.Role.MainRole;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author Achal Sancheti
 */
public class MainUserAccount {
    
    private String username;
    private String password;
    private Employee employee;
    private MainRole role;
    private WorkQueue workQueue;
    private String isActive;

    public MainUserAccount() {
        workQueue = new WorkQueue();
    }   

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MainRole getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(MainRole role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }
    
    @Override
    public String toString() {
        return username;
    }
    
    
    
}