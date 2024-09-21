/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author nourr
 */
public class JavaApplication extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        VetDb db= new VetDb();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxmls/start.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Veterinary clinics");
        stage.setMaximized(true);
        stage.show();
    }
    
}
