/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication;

/**
 *
 * @author layalsaadeddine
 */
public class Medication {
    private int id;
    private String name;
    private int price;
    private String description;

    public Medication (String n, String d, int p){
        this.name = n;
        this.description = d;
        this.price = p;
    }

    public int getId() { return id; }
    public String getName(){ return name; }
    public int getPrice() { return price; }
    public String getDescription() { return description; }

    public void setName (String n) { this.name = n; }
    public void setPrice (int p) { this.price = p; }
    public void setDescription (String d) { this.description = d; }
}
