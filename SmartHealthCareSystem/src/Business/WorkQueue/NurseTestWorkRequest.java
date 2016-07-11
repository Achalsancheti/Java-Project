/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author Achal Sancheti
 */
public class NurseTestWorkRequest extends WorkRequest{
    
    private String bloodGroup;
    int barCode = (int )(Math.random() * 500000 + 1);

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
       

    public int getBarCode() {
        return barCode;
    }

    public void setBarCode(int barCode) {
        this.barCode = barCode;
    }
    
    
    
//public NurseTestWorkRequest searchByModelNumber(int ID){
//    
//        for(int i=0;i<InfoList.size();i++){
//        
//            if(InfoList.get(i).getID()==ID){
//            return InfoList.get(i);
//            
//            }
//        }
//        return null;
//    }
    


}
