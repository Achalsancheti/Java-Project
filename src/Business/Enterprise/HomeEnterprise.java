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
public class HomeEnterprise extends Enterprise {
    
    public HomeEnterprise(String name) {
        super(name, EnterpriseType.Home);
    }

    @Override
    public ArrayList<MainRole> getSupportedRole() {
        return null;
    }
    
}
