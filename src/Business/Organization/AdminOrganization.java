/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.MainRole;
import java.util.ArrayList;

/**
 *
 * @author Achal Sancheti
 */
public class AdminOrganization extends Organization{

    public AdminOrganization() {
        super(Type.Admin.getValue());
    }
    
    @Override
    public ArrayList<MainRole> getSupportedRole() {
        ArrayList<MainRole> roles = new ArrayList<>();
        roles.add(new AdminRole());
        return roles;
    }
     
}
