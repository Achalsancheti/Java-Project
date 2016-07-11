/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.MainRole;
import Business.Role.ManagerRole;
import java.util.ArrayList;

/**
 *
 * @author Achal Sancheti
 */
public class ManagerOrganization extends Organization {
    
    public ManagerOrganization() {
        super(Organization.Type.Manager.getValue());
    }
    
    
    @Override
    public ArrayList<MainRole> getSupportedRole() {
        ArrayList<MainRole> roles = new ArrayList<>();
        roles.add(new ManagerRole());
        return roles;
    }
    
}
