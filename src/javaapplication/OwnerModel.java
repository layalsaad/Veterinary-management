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
public class OwnerModel {
    private Database database;

    public OwnerModel() {
        Database database = new Database();
    }

    public Owner getOwner(String name, String phone, String email) throws SQLException {
        String sql = "SELECT * FROM owner WHERE name='"+name+"' and phone='"+phone
                +"' and email='"+email+"'";
        ResultSet rs = database.executeQuery(sql);
        if(rs.next()){
            Owner o = new Owner(name, email, phone);
            return o;
        }
        else
            return null;
    }

    public Owner getOwnerFromId(int id) throws SQLException {
        String sql = "SELECT * FROM owner WHERE id='"+id+"'";
        ResultSet rs = database.executeQuery(sql);
        if(rs.next()){
            String name = rs.getString("name");
            String email= rs.getString("email");
            String phone = rs.getString("phone");
            Owner o = new Owner(name, email, phone);
            return o;
        }
        else
            return null;
    }

    public void addOwner(Owner o) {
        String sql = "INSERT INTO owner (name, email, phone) " +
                "VALUES ('" + o.getName() + "', '" + o.getEmail() + "', '" +
                o.getPhone() + "' )";
        database.executeUpdate(sql);
    }

    public void updateOwner(Owner o) {
        String sql = "UPDATE owner SET name='" + o.getName() + "', email='" +
                o.getEmail() + "', phone='" + o.getPhone() +"' WHERE id=" + o.getId();
        database.executeUpdate(sql);
    }

    public void deleteOwner(int id) {
        String sql = "DELETE FROM owner WHERE id=" + id;
        database.executeUpdate(sql);
    }

    public List<Owner> getOwners() {
        List<Owner> owners = new ArrayList<>();
        String sql = "SELECT * FROM owner";
        ResultSet resultSet = database.executeQuery(sql);
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Owner o = getOwnerFromId(id);

                owners.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return owners;
    }


    public String displayOwner( Owner o ){

        String n = o.getName();
        String p = o.getPhone();
        String e = o.getEmail();
        String s = n + ": "+ p + ", " + e;
        return s;
    }
}
