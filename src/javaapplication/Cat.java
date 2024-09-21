/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication;

/**
 *
 * @author layalsaadeddine
 */
public class Cat extends Pet{
    private boolean isFriendly;

    public Cat(boolean isFriendly, int id, String name, Owner owner, int age, double weight, String gender) {
        super(name, age, weight, gender, owner);
        this.isFriendly = isFriendly;
    }
    public Cat(String name, Owner owner, int age, double weight, String gender) {
        super(name, age, weight, gender, owner);
    }
    public boolean isIsFriendly() {
        return isFriendly;
    }

    public void setIsFriendly(boolean isFriendly) {
        this.isFriendly = isFriendly;
    }

    public void accept(PetVisitor pv){
        pv.visit(this);
    }
}
