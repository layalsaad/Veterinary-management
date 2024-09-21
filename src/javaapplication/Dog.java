/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication;

/**
 *
 * @author layalsaadeddine
 */
public class Dog extends Pet{
    private String breed;

    public Dog(String breed, String name, Owner owner, int age, double weight, String gender) {
        super(name, age, weight, gender, owner);
        this.breed = breed;
    }

    public Dog(String name, Owner owner, int age, double weight, String gender) {
        super(name, age, weight, gender, owner);
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void accept(PetVisitor pv){
        pv.visit(this);
    }
}
