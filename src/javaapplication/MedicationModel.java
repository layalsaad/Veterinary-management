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
public class MedicationModel {
    private Database database;

    public MedicationModel() {
        Database database = new Database();
    }

    public Medication getMedication(String name) throws SQLException {
        String sql = "SELECT * FROM medication WHERE name='"+name+"'";
        ResultSet rs = database.executeQuery(sql);
        if(rs.next()){
            int p = rs.getInt("price");
            String d = rs.getString("description");
            Medication m = new Medication(name, d, p);
            return m;
        }
        else
            return null;
    }

    public void addMedication(Medication m) {
        String sql = "INSERT INTO medication (name, description, price) " +
        "VALUES ('" + m.getName() + "', '" + m.getDescription() + "', '" +
                m.getPrice() + "' )";
        database.executeUpdate(sql);
    }

    public void updateMedication(Medication m) {
        String sql = "UPDATE medication SET name='" + m.getName() + "', price='" +
                m.getPrice() + "', description='" + m.getDescription() +"' WHERE id=" + m.getId();
        database.executeUpdate(sql);
    }

    public void deleteMedication(int id) {
        String sql = "DELETE FROM medication WHERE id=" + id;
        database.executeUpdate(sql);
    }

    public List<Medication> getMedications() {
        List<Medication> meds = new ArrayList<>();
        String sql = "SELECT * FROM medication";
        ResultSet resultSet = database.executeQuery(sql);
        try {
            while (resultSet.next()) {
                String n = resultSet.getString("name");
                Medication m= getMedication(n);

                meds.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return meds;
    }


    public String displayMedication( Medication m ){

        String n = m.getName();
        int p = m.getPrice();
        String d = m.getDescription();
        String s = n + ": "+ p + ", used for: " + d;
        return s;
    }
}
