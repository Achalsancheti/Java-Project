/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.ReceptionistOrganization;
import Business.MainUserAccount.MainUserAccount;
import UserInterface.ReceptionistRole.ReceptionistJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Achal Sancheti
 */
public class ReceptionistRole extends MainRole {
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, MainUserAccount account,
            Organization organization, Enterprise enterprise, EcoSystem business) {
        
    return new ReceptionistJPanel(userProcessContainer, account,(ReceptionistOrganization)organization,enterprise);
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
    
}
