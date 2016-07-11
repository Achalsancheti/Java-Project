/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.MainUserAccount.MainUserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Achal Sancheti
 */
public abstract class MainRole {
    
    public enum RoleType{
        Admin("Admin"),
        Doctor("Doctor"),
        Nurse("Nurse"),
        VaccineManager("Vaccine Manager"),
        Patient("Patient"),
        Receptionist("Receptionist"),
        Donor("Donor"),
        PatientRelative("Patient Relative"),
        Manager("Manager");
        
        private String value;
        
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            MainUserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}