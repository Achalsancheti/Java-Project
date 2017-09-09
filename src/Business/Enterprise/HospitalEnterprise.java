/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.MainRole;
import java.util.ArrayList;

/**
 *
 * @author Achal Sancheti
 */
public class HospitalEnterprise extends Enterprise{

    public HospitalEnterprise(String name) {
        super(name, EnterpriseType.Hospital);
    }

    @Override
    public ArrayList<MainRole> getSupportedRole() {
        return null;
    }
    
    
    
}
