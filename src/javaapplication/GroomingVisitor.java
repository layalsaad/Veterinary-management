/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication;


/**
 *
 * @author layalsaadeddine
 */
public class GroomingVisitor implements PetVisitor{
    @Override
    public void visit(Dog d) {
        System.out.println("The dog "+d.getName()+" that is owned by "+d.getOwner()+"has been groomed.");
    }

    @Override
    public void visit(Cat c) {
        System.out.println("The cat "+c.getName()+" that is owned by "+c.getOwner()+" has been groomed");
    }
}
