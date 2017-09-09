/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.MainUserAccount.MainUserAccount;
import UserInterface.DoctorRole.DoctorWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Achal Sancheti
 */
public class DoctorRole extends MainRole{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
                                MainUserAccount account, Organization organization,
                                    Enterprise enterprise, EcoSystem business) {
        return new DoctorWorkAreaJPanel(userProcessContainer, enterprise,account, (DoctorOrganization)organization, business);
    }
    
    
}
