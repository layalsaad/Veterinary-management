/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication;

import javaapplication.Database;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author layalsaadeddine
 */
public class StaffModel {
    private Database database;

    public StaffModel() {
        Database database = new Database();
    }

    public boolean loginStaff(String username, String pass) throws SQLException {
        String sql = "SELECT * FROM staff WHERE username='"+username+"' and password='"+
                pass+"'";
        ResultSet rs = (ResultSet) database.executeQuery(sql);
        return rs.next();
    }
}
