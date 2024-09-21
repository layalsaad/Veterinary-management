/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication;


import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

/**
 *
 * @author layalsaadeddine
 */
public class LoginController  {
    @FXML
    private TextField user;

    @FXML
    private TextField pass;


    //String username = user.getText();
    //String password = pass.getText();

    public void gotoVet (ActionEvent event)throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxmls/vet.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void gotoStaff (ActionEvent event)throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxmls/staff.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void loginAsVet (ActionEvent event) throws Exception{
        if(!user.getText().isEmpty() && !pass.getText().isEmpty()){
            VetModel vm = new VetModel();
            try {
                if(vm.loginVet(user.getText(),pass.getText())){ gotoVet(event); }
                else {
                    user.clear();
                    pass.clear();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void loginAsStaff (ActionEvent event) throws Exception{
        if(!user.getText().isEmpty() && !pass.getText().isEmpty()){
            StaffModel sm = new StaffModel();
            try {
                if(sm.loginStaff(user.getText(),pass.getText())){ gotoStaff(event); }
                else {
                    user.clear();
                    pass.clear();
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void Cancel(Event e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/fxmls/start.fxml"));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
