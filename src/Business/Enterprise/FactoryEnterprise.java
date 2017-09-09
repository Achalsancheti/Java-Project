/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.MainRole;
import java.util.ArrayList;

/**
 *
 * @author Achal Sancheti
 */
public class FactoryEnterprise extends Enterprise {
    
    public FactoryEnterprise(String name) {
        super(name, EnterpriseType.Factory);
    }

    @Override
    public ArrayList<MainRole> getSupportedRole() {
        return null;
    }
    
}
