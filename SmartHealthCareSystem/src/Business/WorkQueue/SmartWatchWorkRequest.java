/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author Achal Sancheti
 */
public class SmartWatchWorkRequest extends WorkRequest {
    
    private int respiratoryRate = (int )(Math.random() * 200 - 1);
    private int heartRate = (int )(Math.random() * 200 - 1);
    private int bloodPressure = (int )(Math.random() * 200 - 1);
    private float weight = (int )(Math.random() * 200 - 1);
    private String condition;

    public int getRespiratoryRate() {
        return respiratoryRate;
    }

    public void setRespiratoryRate(int respiratoryRate) {
        this.respiratoryRate = respiratoryRate;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    
    
        @Override
    public String toString() {
        return condition;
    }
    
}
