package Business;

import Business.Employee.Employee;
import Business.Role.SystemAdminRole;
import Business.MainUserAccount.MainUserAccount;

/**
 *
 * @author Achal Sancheti
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        Employee employee = system.getEmployeeDirectory().createEmployee
                                                            ("Achal Sancheti");
        MainUserAccount ua = system.getMainuserAccountDirectory().createUserAccount
                     ("achal", "achal", employee, new SystemAdminRole());
        return system;
    }
    
}
