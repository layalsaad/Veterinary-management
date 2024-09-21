/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

/**
 *
 * @author layalsaadeddine
 */
public class tablesController implements Initializable{
    @FXML
    private ListView vetlist;

    @FXML
    private ListView petlist;

    @FXML
    private ListView aptlist;

    @FXML
    private ListView ownerlist;
    ArrayList<Appointment> aptt = new ArrayList<>();

    @Override
    public void initialize(){
        AppointmentModel md = new AppointmentModel();
        
        try {
            aptt = (ArrayList<Appointment>) md.getAppointments();
        } catch (SQLException ex) {
            Logger.getLogger(tablesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        aptlist.setItems((ObservableList) aptt);

        OwnerModel od = new OwnerModel();
        ArrayList<Owner> own = (ArrayList<Owner>) od.getOwners();
        ownerlist.setItems((ObservableList) own);

        PetModel pd = new PetModel();
        ArrayList<Pet> pet = (ArrayList<Pet>) pd.getPets();
        petlist.setItems((ObservableList) pet);

        VetModel vd = new VetModel();
        ArrayList<Vet> vet = (ArrayList<Vet>) vd.getVets();
        vetlist.setItems((ObservableList) vet);
    }

}
