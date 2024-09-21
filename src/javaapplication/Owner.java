/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication;

/**
 *
 * @author layalsaadeddine
 */
public class Owner {
    private int id;
    private String name;
    private String phone;
    private String email;

    public Owner (String n, String e, String p){
        this.name = n;
        this.email = e;
        this.phone = p;
    }

    public int getId() { return id; }
    public String getName(){ return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }

    public void setName (String n) { this.name = n; }
    public void setPhone (String p) { this.phone = p; }
    public void setEmail (String e) { this.email = e; }
}
