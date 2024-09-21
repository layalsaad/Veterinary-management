/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication;

import java.time.LocalDate;

/**
 *
 * @author layalsaadeddine
 */
public class Appointment {
    private int id;
    private LocalDate date;
    private String time;
    private Owner owner;
    private Vet vet;
    private String service;

    public Appointment (LocalDate d, String t, Owner o, Vet v, String s) {
        this.owner = o;
        this.vet = v;
        this.date = d;
        this.time = t;
        this.service = s;
    }

    public int getId(){ return id; }
    public Owner getOwner(){ return owner; }
    public int getOwnerId() { return owner.getId(); }
    public Vet getVet(){ return vet; }
    public int getVetId() { return vet.getId(); }
    public LocalDate getDate(){ return date; }
    public String getTime(){ return time; }
    public String getService(){ return service; }

    public void setId(int id){ this.id = id; }
    public void setOwner(Owner o){ this.owner = o; }
    public void setVet(Vet v){ this.vet = v; }
    public void setDate(LocalDate d){ this.date = d; }
    public void setTime(String t){ this.time = t; }
    public void setService(String s){ this.service = s; }
}
