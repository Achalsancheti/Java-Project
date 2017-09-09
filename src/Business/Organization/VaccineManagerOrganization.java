/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.MainRole;
import Business.Role.VaccineManagerRole;
import Business.Vaccine.VaccineCatalog;
import java.util.ArrayList;

/**
 *
 * @author Achal Sancheti
 */
public class VaccineManagerOrganization extends Organization {
    
    private VaccineCatalog vaccineCatalog;
    
    
    public VaccineManagerOrganization() {
        super(Organization.Type.VaccineManager.getValue());
        this.vaccineCatalog=new VaccineCatalog();
    }

    @Override
    public ArrayList<MainRole> getSupportedRole() {
        ArrayList<MainRole> roles = new ArrayList<>();
        roles.add(new VaccineManagerRole());
        return roles;
    }

    public VaccineCatalog getVaccineCatalog() {
        return vaccineCatalog;
    }

    public void setVaccineCatalog(VaccineCatalog vaccineCatalog) {
        this.vaccineCatalog = vaccineCatalog;
    }
    
    
    
}
