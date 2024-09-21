/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author layalsaadeddine
 */
public class VetModel implements Observer{
    private final Database database = new Database();

    public VetModel() {}

    public boolean loginVet(String username, String pass) throws SQLException {
        String sql = "SELECT * FROM vet WHERE username='"+username+"' and password='"+
                pass+"'";

        ResultSet rs = (ResultSet) database.executeQuery(sql);
        return rs.next();
    }


    public Vet getVet(String name, String phone, String email) throws SQLException {
        String sql = "SELECT * FROM vet WHERE name='"+name+"' and phone='"+phone
                +"' and email='"+email+"'";
        ResultSet rs = (ResultSet) database.executeQuery(sql);
        if(rs.next()){
            String u = rs.getString("username");
            String ps = rs.getString("password");
            return new Vet(name, email, phone, u, ps);
        }
        else return null;
        
    }

    public Vet getVetFromId(int id) throws SQLException{
        String sql = "SELECT * FROM vet WHERE id='"+id+"'";
        ResultSet rs = (ResultSet) database.executeQuery(sql);
        if(rs.next()){
                String name = rs.getString("name");
                String email= rs.getString("email");
                String phone = rs.getString("phone");
                String u = rs.getString("username");
                String ps = rs.getString("password");
                return new Vet(name, email, phone, u, ps);
            }
            else
                return null;
        
    }

    public void addVet(Vet v) {
        String sql = "INSERT INTO vet (name, email, phone,username, phone) " +
                "VALUES ('" + v.getName() + "', '" + v.getEmail() + "', '" +
                v.getPhone() + "', " + v.getUsername() + "', " + v.getPassword() +"' )";
        database.executeUpdate(sql);
    }

    public void updateVet(Vet v) {
        String sql = "UPDATE vet SET name='" + v.getName() + "', email='" +
                v.getEmail() + "', phone='" + v.getPhone() + "', username='"+
                v.getUsername() + "', password='"+ v.getPassword() +"' WHERE id=" + v.getId();
        database.executeUpdate(sql);
    }

    public void deleteVet(int id) {
        String sql = "DELETE FROM vet WHERE id=" + id;
        database.executeUpdate(sql);
    }

    public List<Vet> getVets() {
        List<Vet> vets = new ArrayList<>();
        String sql = "SELECT * FROM vet";
        ResultSet resultSet = (ResultSet) database.executeQuery(sql);
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Vet v = getVetFromId(id);

                vets.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vets;
    }
    @Override
    public void update() {
        System.out.println("Appointment updated!");
    }

    @Override
    public void update(Appointment appointment) {
        System.out.println("Appointment updated");
    }

    public String displayVet( Vet v ){

        String n = v.getName();
        String p = v.getPhone();
        String e = v.getEmail();
        return n + ": "+ p + ", " + e;
    }
}
