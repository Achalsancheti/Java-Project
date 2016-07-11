/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.MainUserAccount.MainUserAccount;
import UserInterface.HospitalAdminRole.AdminWorkAreaJPanel;
import UserInterface.FactoryAdminRole.EnterpriseAdminWorkAreaJPanel;
import UserInterface.HomeAdminRole.HomeAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Achal Sancheti
 */
public class AdminRole extends MainRole{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
                                MainUserAccount account, Organization organization,
                                    Enterprise enterprise, EcoSystem business) {
        
        for (Organization.Type type : Organization.Type.values()){
            if (((enterprise.getEnterpriseType()==Enterprise.EnterpriseType.Hospital))){
            return new AdminWorkAreaJPanel(userProcessContainer, enterprise,business);
            }else{
               if(((enterprise.getEnterpriseType()==Enterprise.EnterpriseType.Factory))){
                return new EnterpriseAdminWorkAreaJPanel(userProcessContainer, enterprise,business);
            }else{
               if(((enterprise.getEnterpriseType()==Enterprise.EnterpriseType.Home))){
                return new HomeAdminWorkAreaJPanel(userProcessContainer, enterprise,account,business);
               }
               }  
        }}
        return null;
        
    }

    
    
}
