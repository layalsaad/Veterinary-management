package javaapplication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author layalsaadeddine
 */
public class AppointmentModel implements Observable{
    private static final Database database = null;
    private List<Observer> observers;
    public AppointmentModel() {
        observers = new ArrayList<>();
    }

    public Appointment getAppointment (int id) throws SQLException {
        String sql = "SELECT * FROM appointment WHERE id='"+id+"'";
        ResultSet rs = database.executeQuery(sql);
        if(rs.next()){
            int oid = rs.getInt("owner");
            int vid = rs.getInt("vet");
            LocalDate date = rs.getDate("date").toLocalDate();
            String time = rs.getString("time");
            String treatment = rs.getString("treatment");
            OwnerModel om = new OwnerModel();
            Owner o = om.getOwnerFromId(oid);
            VetModel vm = new VetModel();
            Vet v = vm.getVetFromId(vid);
            Appointment a = new Appointment (date,time,o,v, treatment);
            return a;
        }
        else
            return null;
    }

    public void addAppointment(Appointment appointment) {
        String sql = "INSERT INTO appointment (date, time, pet , vet, service) " +
                "VALUES ('" + appointment.getDate() + "', '" + appointment.getTime() + "', '" +
                appointment.getId() + "', '" + appointment.getVetId() +"', '" + appointment.getService() + "')";
        database.executeUpdate(sql);
        notifyObservers();
    }

    public void updateAppointment(Appointment appointment) {
        String sql = "UPDATE appointment SET date='" + appointment.getDate() + "', time='" +
                appointment.getTime() + "', owner='" + appointment.getOwnerId() +
                "', vet='" + appointment.getVetId() + "' WHERE id=" + appointment.getId();
        database.executeUpdate(sql);
        notifyObservers(appointment);
    }

    public void deleteAppointment(int id) {
        String sql = "DELETE FROM appointment WHERE id=" + id;
        database.executeUpdate(sql);
        notifyObservers();
    }

    public List<Appointment> getAppointments() throws SQLException {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointment";
        ResultSet resultSet = database.executeQuery(sql);
        while (resultSet.next()) {
                int id = resultSet.getInt("id");
                LocalDate date = resultSet.getDate("date").toLocalDate();
                String time = resultSet.getString("time");
                String owner = resultSet.getString("owner");
                String vet = resultSet.getString("vet");
                String t = resultSet.getString("service");
                OwnerModel om = new OwnerModel();
                Owner o = om.getOwnerFromId(id);
                VetModel vm = new VetModel();
                Vet v = vm.getVet(vet, "", "");
                Appointment a = new Appointment (date,time,o,v,t);
                appointments.add(a);
            }
        return appointments;
    }
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void notifyObservers(Appointment appointment) {
        for (Observer observer : observers) {
            observer.update(appointment);
        }
    }
    public String displayAppointment( Appointment a ){

        Owner o = a.getOwner();
        String oname = o.getName();
        Vet v = a.getVet();
        String vname = v.getName();
        LocalDate date = a.getDate();
        String time = a.getTime();
        String s = "Customer "+ oname +" is assigned to vet "+ vname +" on "
                +date+ " at "+time;
        return s;
    }
}
