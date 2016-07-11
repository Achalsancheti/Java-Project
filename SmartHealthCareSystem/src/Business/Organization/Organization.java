/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Role.MainRole;
import Business.MainUserAccount.MainUserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Achal Sancheti
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private MainUserAccountDirectory mainuserAccountDirectory;
    private int organizationID;
    private static int counter;
    
    public enum Type{
        Admin("Admin Organization"), Receptionist("Receptionist Organization"),
        Doctor("Doctor Organization"),VaccineManager("Vaccine Manager Organization"),
        Nurse("Nurse Organization"),Donor("Donor Organization"),Patient("Patient Organization"),
        PatientRelative("Patient Relative Organization"),
        Manager("Manager");
        
        private String value;
        
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    
    

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        mainuserAccountDirectory = new MainUserAccountDirectory();
        organizationID = ++counter;
    }
   
    

    public abstract ArrayList<MainRole> getSupportedRole();
    
    public MainUserAccountDirectory getMainuserAccountDirectory() {
        return mainuserAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
    

    @Override
    public String toString() {
        return name;
    }
    
    
}
