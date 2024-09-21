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
public class MedicalRecord {
    private int id;
    private String ownername;
    private String petname;
    private String type;
    private int age;
    private double weight;
    private String gender;
    private List<Vaccine> vaccines;
    private List<Medication> medications;

    public MedicalRecord(int id) {
        this.id = id;
    }

    public MedicalRecord(int id, List<Vaccine> vaccines, List<Medication> medications) {
        this.id = id;
        this.vaccines = vaccines;
        this.medications = medications;
    }

    public MedicalRecord(String pname, String type, int age, double weight, String gender, String om){
        ownername = om;
        petname = pname;
        this.type = type;
        this.age = age;
        this.weight = weight;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vaccine> getVaccines() {
        return vaccines;
    }

    public void setVaccines(List<Vaccine> vaccines) {
        this.vaccines = vaccines;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }


    public void vaccinate(Vaccine v){
        this.vaccines.add(v);
        System.out.println("Vaccinated with vaccine "+v.getName()+": "+v.getDescription());
    }
    public void assignMed(Medication m){
        this.medications.add(m);
        System.out.println("Assigned the medication: "+m.getName()+": "+m.getDescription());
    }
}
