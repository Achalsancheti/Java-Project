/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.NurseOrganization;
import Business.Organization.Organization;
import Business.MainUserAccount.MainUserAccount;
import UserInterface.NurseRole.NurseWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Achal Sancheti
 */
public class NurseRole extends MainRole {
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
                                MainUserAccount account, Organization organization,
                                    Enterprise enterprise, EcoSystem business) {
        return new NurseWorkAreaJPanel(userProcessContainer, enterprise,account, (NurseOrganization)organization);
    }
    
}
