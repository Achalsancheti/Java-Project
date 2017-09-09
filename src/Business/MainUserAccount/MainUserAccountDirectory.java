/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.MainUserAccount;

import Business.Employee.Employee;
import Business.Role.MainRole;
import java.util.ArrayList;

/**
 *
 * @author Achal Sancheti
 */
public class MainUserAccountDirectory {
    
    private ArrayList<MainUserAccount> userAccountList;

    public MainUserAccountDirectory() {
        userAccountList = new ArrayList<>();
    }

    public ArrayList<MainUserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public MainUserAccount authenticateUser(String username, String password){
        for (MainUserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) &&
                                            ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public MainUserAccount authenticate(String username){
        for (MainUserAccount ua : userAccountList)
            if (ua.getUsername().equals(username)){
                return ua;
            }
        return null;
    }
    
    public MainUserAccount createUserAccount(String username, String password,
                                                  Employee employee, MainRole role){
        MainUserAccount userAccount = new MainUserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
}
