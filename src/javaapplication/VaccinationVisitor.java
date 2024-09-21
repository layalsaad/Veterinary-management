/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication;

import java.util.List;

/**
 *
 * @author layalsaadeddine
 */
public class VaccinationVisitor implements PetVisitor{
    @Override
    public void visit(Dog d) {
        MedicalRecord mr = d.getMr();
        List<Vaccine> vaccines = (List<Vaccine>) mr.getVaccines();
        for(Vaccine v: vaccines){
            if(!vaccines.contains(v)){
                mr.vaccinate(v);
                d.setMr(mr);
            }
        }
    }

    @Override
    public void visit(Cat c) {
        MedicalRecord mr = c.getMr();
        List<Vaccine> vaccines = mr.getVaccines();
        for(Vaccine v: vaccines){
            if(!vaccines.contains(v)){
                mr.vaccinate(v);
                c.setMr(mr);
            }
        }
    }
}
