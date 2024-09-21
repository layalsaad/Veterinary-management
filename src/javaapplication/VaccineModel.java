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
public class VaccineModel {
    private Database database;

    public VaccineModel() {
        Database database = new Database();
    }

    public Vaccine getVaccine (String name) throws SQLException {
        String sql = "SELECT * FROM vaccine WHERE name='"+name+"'";
        ResultSet rs = (ResultSet) database.executeQuery(sql);
        if(rs.next()){
            int p = rs.getInt("price");
            String d = rs.getString("description");
            Vaccine v = new Vaccine (name, d, p);
            return v;
        }
        else
            return null;
    }

    public void addVaccine(Vaccine m) {
        String sql = "INSERT INTO vaccine (name, description, price) " +
        "VALUES ('" + m.getName() + "', '" + m.getDescription() + "', '" +
                m.getPrice() + "' )";
        database.executeUpdate(sql);
    }

    public void updateVaccine(Vaccine m) {
        String sql = "UPDATE vaccine SET name='" + m.getName() + "', price='" +
                m.getPrice() + "', description='" + m.getDescription() +"' WHERE id=" + m.getId();
        database.executeUpdate(sql);
    }

    public void deleteVaccine(int id) {
        String sql = "DELETE FROM vaccine WHERE id=" + id;
        database.executeUpdate(sql);
    }

    public List<Vaccine> getVaccines() {
        List<Vaccine> vacs = new ArrayList<>();
        String sql = "SELECT * FROM vaccine";
        ResultSet resultSet = (ResultSet) database.executeQuery(sql);
        try {
            while (resultSet.next()) {
                String n = resultSet.getString("name");
                Vaccine v= getVaccine(n);

                vacs.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vacs;
    }


    public String displayVaccine( Vaccine m ){

        String n = m.getName();
        int p = m.getPrice();
        String d = m.getDescription();
        String s = n + ": "+ p + ", for: " + d;
        return s;
    }
}
