/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.MainUserAccount.MainUserAccount;
import Business.Organization.Organization;
import Business.Organization.PatientRelativeOrganization;
import UserInterface.PatientRelativeRole.PatientRelativeJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Achal Sancheti
 */
public class PatientRelativeRole extends MainRole {
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
                                MainUserAccount account, Organization organization,
                                    Enterprise enterprise, EcoSystem business) {
        return new PatientRelativeJPanel(userProcessContainer, enterprise,account, (PatientRelativeOrganization)organization);
    }
    
}
