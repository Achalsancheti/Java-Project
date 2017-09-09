/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.PatientRole;
import Business.Role.MainRole;
import java.util.ArrayList;

/**
 *
 * @author Achal Sancheti
 */
public class PatientOrganization extends Organization {
    
    public PatientOrganization() {
        super(Organization.Type.Patient.getValue());
    }

    @Override
    public ArrayList<MainRole> getSupportedRole() {
        ArrayList<MainRole> roles = new ArrayList<>();
        roles.add(new PatientRole());
        return roles;
    }
    
}
