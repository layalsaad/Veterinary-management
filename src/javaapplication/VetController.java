/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author layalsaadeddine
 */
public class VetController implements Initializable{
    @FXML
    private ListView list1;

    @FXML
    private ListView list2;
    @Override
    public void initialize(){
        MedicalRecordModel md = new MedicalRecordModel();
        ArrayList<MedicalRecord> records = new ArrayList<>();
        records = (ArrayList<MedicalRecord>) md.getRecords();
        
        list1.setItems((ObservableList) records);
    }

    public void handleMouseClick(MouseEvent event) throws SQLException{
        MultipleSelectionModel m;
        m = list1.getSelectionModel();
        int id = m.getSelectedIndex();
        MedicalRecordModel md = new MedicalRecordModel();
        ArrayList<String> meds = (ArrayList<String>) md.getMeds(id);
        list2.setItems((ObservableList) meds);
    }
}
