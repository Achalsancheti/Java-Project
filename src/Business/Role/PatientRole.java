/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.PatientOrganization;
import Business.MainUserAccount.MainUserAccount;
import Business.Organization.Organization;
import UserInterface.PatientRole.PatientWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Achal Sancheti
 */
public class PatientRole extends MainRole {
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, MainUserAccount account,
            Organization organization, Enterprise enterprise, EcoSystem business) {
        
        return new PatientWorkAreaJPanel(userProcessContainer, account,
                            (PatientOrganization)organization, enterprise,business);
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
