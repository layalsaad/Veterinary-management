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
public class MedicalRecordModel {
    private int id;
    private String ownername;
    private String petname;
    private String type;
    private int age;
    private int weight;
    private String gender;

    private Database database;

    public int getId(){ return id; }

    public MedicalRecordModel(){}
    public MedicalRecordModel(String pname,String t,int a,int w,String g,String om){
        this.petname = pname;
        this.type = t;
        this.age = a;
        this.weight = w;
        this.gender = g;
        this.ownername = om;

    }
    public List<MedicalRecord> getRecords(){
        List<MedicalRecord> records = new ArrayList<>();
        String sql = "SELECT * FROM medicalRecord";
        ResultSet resultSet = database.executeQuery(sql);
        try {
            while (resultSet.next()) {
                int petid = resultSet.getInt("petid");
                int id = resultSet.getInt("id");
                PetModel pm = new PetModel();
                Pet p = pm.getPetFromId(petid);
                Owner o = p.getOwner();

                MedicalRecord md = new MedicalRecord(p.getName(),p.getType(),p.getAge(),p.getWeight(),p.getGender(),o.getName());
                records.add(md);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }

    public List<String> getMeds(int id) throws SQLException {
        List<String> meds = new ArrayList<>();
        String sql = "SELECT * FROM vaccineRecord where mid='"+id+"'";
        ResultSet resultSet = database.executeQuery(sql);
        try {
            while (resultSet.next()) {
                int vid = resultSet.getInt("vid");
                String sql1 = "SELECT * FROM vaccine where id='"+id+"'";
                ResultSet resultSet1 = database.executeQuery(sql1);
                try {
                    while (resultSet.next()) {
                        String name = resultSet.getString("name");
                        meds.add(name);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql2 = "SELECT * FROM medicationRecord where mrid='"+id+"'";
        ResultSet resultSet2 = database.executeQuery(sql2);
        while (resultSet.next()) {
            int mdid = resultSet.getInt("mdid");
            String sql3 = "SELECT * FROM medication where id='"+id+"'";
            ResultSet resultSet3 = database.executeQuery(sql3);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                meds.add(name);
            }
        }

        return meds;
    }
}
