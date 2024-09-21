/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication;

import javaapplication.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author layalsaadeddine
 */
public class PetModel implements Observer{
    private Database database;

    public PetModel() {
        Database database = new Database();
    }

    public Pet getPetFromId(int id) throws SQLException {
        String sql = "SELECT * FROM pet WHERE id='"+id+"'";
        ResultSet rs = database.executeQuery(sql);
        if(rs.next()){
            String n = rs.getString("name");
            int a = rs.getInt("age");
            String t = rs.getString("type");
            int w = rs.getInt("weight");
            String g = rs.getString("gender");
            int oid = rs.getInt("owner");
            OwnerModel om = new OwnerModel();
            Owner o = om.getOwnerFromId(oid);
            Pet p = new Pet(n,t, a, w, g, o);
            return p;
        }
        else
            return null;
    }

    public Pet getPet(String name, int oid) throws SQLException {
        String sql = "SELECT * FROM pet WHERE name='"+name+"' and owner='"+oid+"'";
        ResultSet rs = database.executeQuery(sql);
        if(rs.next()){
            String n = rs.getString("name");
            int a = rs.getInt("age");
            String t = rs.getString("type");
            int w = rs.getInt("weight");
            String g = rs.getString("gender");
            int ownerid = rs.getInt("owner");
            OwnerModel om = new OwnerModel();
            Owner o = om.getOwnerFromId(oid);
            Pet p = new Pet(n,t, a, w, g, o);
            return p;
        }
        else
            return null;
    }

    public void addPet(Pet pet) {
        String sql = "INSERT INTO pet (name,type,  age, weight, gender, owner) " +
                "VALUES ('" + pet.getName() + "', '" + pet.getType() + "', '"+ pet.getAge() + "', '" +
                pet.getWeight() + "', '" + pet.getGender() + "', '"+ pet.getOwner().getId()+"' )";
        database.executeUpdate(sql);
    }

    public void updatePet(Pet pet) {
        String sql = "UPDATE pet SET name='" + pet.getName() + "', type='" + pet.getType() + "', age='" +
                pet.getAge() + "', weight='" + pet.getWeight() +
                "', gender='" + pet.getGender() + "', owner='" + pet.getOwner().getId() +"' WHERE id=" + pet.getId();
        database.executeUpdate(sql);
    }

    public void deletePet(int id) {
        String sql = "DELETE FROM pet WHERE id=" + id;
        database.executeUpdate(sql);
    }

    public List<Pet> getPets() {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pet";
        ResultSet resultSet = database.executeQuery(sql);
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                int age = resultSet.getInt("age");
                int weight = resultSet.getInt("weight");
                String gender = resultSet.getString("gender");
                int oid = resultSet.getInt("owner");

                OwnerModel om = new OwnerModel();
                Owner o = om.getOwnerFromId(oid);

                Pet pet = new Pet(name, type, age, weight, gender, o);
                pets.add(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }
    @Override
    public void update() {
        System.out.println("Appointment updated!");
    }

    @Override
    public void update(Appointment appointment) {
        System.out.println("Appointment updated");
    }
    public String displayPet( Pet p ){

        String n = p.getName();
        String t = p.getType();
        int a = p.getAge();
        double w = p.getWeight();
        String g = p.getGender();
        Owner o = p.getOwner();
        String s = o + "'s Pet: "+ t + ": " + g + ", " + n +" "+ a +" years old, "
                +w+ " kg ";
        return s;
    }
}
