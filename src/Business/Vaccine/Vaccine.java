/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Vaccine;

/**
 *
 * @author Achal Sancheti
 */
public class Vaccine {
    
    private String vaccineName;
    private int quantity;
    
    public Vaccine(String vaccineName, int quantity) {
    this.vaccineName=vaccineName;
    this.quantity=quantity;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return vaccineName;
    }
    
    
    
}
