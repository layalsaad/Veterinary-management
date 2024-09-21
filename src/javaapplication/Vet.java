/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication;

/**
 *
 * @author layalsaadeddine
 */
public class Vet {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String username;
    private String password;

    public Vet (String n, String e, String ph, String u, String pass) {
        this.name = n;
        this.email = e;
        this.phone = phone;
        this.username = u;
        this.password = pass;
    }

    public int getId(){ return id; }
    public String getName(){ return name; }
    public String getPhone() { return phone; }
    public String getEmail(){ return email; }
    public String getUsername(){ return username; }
    public String getPassword(){ return password; }

    public void setName(String n){ this.name = n; }
    public void setEmail(String e){ this.email = e; }
    public void setPhone(String ph){ this.phone = ph; }
    public void setUsername(String u){ this.username = u; }
    public void setPassword(String ps){ this.password = ps; }
}
