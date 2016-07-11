/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author Achal Sancheti
 */
public class WorkQueue {
    
    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList<>();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
    
public WorkRequest searchByName(String NameKey){
    for(WorkRequest workRequest : workRequestList){
        if(workRequest.getName().equals(NameKey)){
        return workRequest;
        }
    }
    return null;
    
    }
    
}