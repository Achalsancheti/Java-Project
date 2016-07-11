package Business;

import Business.Enterprise.Enterprise;
import Business.MainUserAccount.MainUserAccount;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.MainRole;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Achal Sancheti
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    private ArrayList<Network> networkList;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    private EcoSystem() {
        super(null);
        networkList = new ArrayList<>();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    @Override
    public ArrayList<MainRole> getSupportedRole() {
        ArrayList<MainRole> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public boolean checkIfUsernameIsUnique(String username) {
            MainUserAccount userAccount = this.getMainuserAccountDirectory().authenticate(username);
            
            Enterprise inEnterprise = null;
        Organization inOrganization = null;
        if (userAccount == null) {
            for (Network network : this.getNetworkList()) {
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    userAccount = enterprise.getMainuserAccountDirectory().authenticate(username);
                    if (userAccount == null) {
                        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            userAccount = organization.getMainuserAccountDirectory().authenticate(username);
                            if (userAccount != null) {
                                inEnterprise = enterprise;
                                inOrganization = organization;
                                break;
                            }
                        }
                    } else {
                        inEnterprise = enterprise;
                        break;
                    }
                    if (inOrganization != null) {
                        break;
                    }
                }
                if (inEnterprise != null) {
                    break;
                }
            }
        }
        
        if (userAccount == null) {
            return true;
        } else {
        return false;
        }
            
}
}