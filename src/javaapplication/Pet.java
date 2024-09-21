/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication;

/**
 *
 * @author layalsaadeddine
 */
public class Pet {
    private int id;
    private String name;
    private String type;
    private double weight;
    private int age;
    private String gender;
    private Owner owner;
    private MedicalRecord mr;

    public Pet (String n, String t, int a, int w, String g, Owner o){
        this.name = n;
        this.age = a;
        this.type = t;
        this.weight = w;
        this.gender = g;
        this.owner = o;
    }
    public Pet (String n, int a, double w, String g, Owner o){
        this.name = n;
        this.age = a;
        this.weight = w;
        this.gender = g;
        this.owner = o;
    }

    public int getId() { return id; }
    public String getName(){ return name; }
    public String getType(){ return type; }
    public int getAge() { return age; }
    public double getWeight() { return weight;  }
    public String getGender() { return gender; }
    public Owner getOwner() { return owner; }
    public MedicalRecord getMr() { return mr; }

    public void setName (String n) { this.name = n; }
    public void setType (String t) { this.type = t; }
    public void setAge (int a) { this.age = a; }
    public void setWeight (int w) { this.weight = w; }
    public void setGender (String g) { this.gender = g; }
    public void setOwner (Owner o) { this.owner = o; }
    public void setMr (MedicalRecord mr) { this.mr = mr; }
}
