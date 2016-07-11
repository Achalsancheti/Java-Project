/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.ReceptionistRole;
import Business.Role.MainRole;
import java.util.ArrayList;

/**
 *
 * @author Achal Sancheti
 */
public class ReceptionistOrganization extends Organization{

    public ReceptionistOrganization() {
        super(Organization.Type.Receptionist.getValue());
    }

    @Override
    public ArrayList<MainRole> getSupportedRole() {
        ArrayList<MainRole> roles = new ArrayList<>();
        roles.add(new ReceptionistRole());
        return roles;
    }
     
   
    
    
}
