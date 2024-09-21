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
public class MedicationVisitor implements PetVisitor{
    @Override
    public void visit(Dog d) {
        MedicalRecord mr = d.getMr();
        List<Medication> meds = mr.getMedications();
        for(Medication m: meds){
            if(!meds.contains(m)){
                mr.assignMed(m);
                d.setMr(mr);
            }
        }
    }

    @Override
    public void visit(Cat c) {
        MedicalRecord mr = c.getMr();
        List<Medication> meds = mr.getMedications();
        for(Medication m: meds){
            if(!meds.contains(m)){
                mr.assignMed(m);
                c.setMr(mr);
            }
        }
    }
}
