/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Vaccine;

import java.util.ArrayList;

/**
 *
 * @author Achal Sancheti
 */
public class VaccineCatalog {
    
    private ArrayList<Vaccine> list=new ArrayList<>();

    public VaccineCatalog() {
    list.add(new Vaccine("Vaccine1",300));
    list.add(new Vaccine("Vaccine2",200));
    list.add(new Vaccine("Vaccine3",150));
    list.add(new Vaccine("Vaccine4",130));
    list.add(new Vaccine("Vaccine5",100));
    list.add(new Vaccine("Vaccine6",300));
    }

    public ArrayList<Vaccine> getList() {
        return list;
    }

    public void setList(ArrayList<Vaccine> list) {
        this.list = list;
    }
 
}
