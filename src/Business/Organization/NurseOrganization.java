/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.NurseRole;
import Business.Role.MainRole;
import java.util.ArrayList;

/**
 *
 * @author Achal Sancheti
 */
public class NurseOrganization extends Organization {
    
    public NurseOrganization() {
        super(Organization.Type.Nurse.getValue());
    }
    
    
    @Override
    public ArrayList<MainRole> getSupportedRole() {
        ArrayList<MainRole> roles = new ArrayList<>();
        roles.add(new NurseRole());
        return roles;
    }
    
}
