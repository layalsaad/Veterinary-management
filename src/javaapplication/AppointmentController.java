/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author layalsaadeddine
 */
public class AppointmentController {
    private final  Database database;

    @FXML
    private TextField name;

    @FXML
    private TextField phone;

    @FXML
    private TextField email;

    @FXML
    private ToggleGroup pettype;

    @FXML
    private ToggleGroup treatment;

    @FXML
    private RadioButton vaccination;

    @FXML
    private RadioButton medication;

    @FXML
    private RadioButton grooming;

    @FXML
    private GridPane gridpane;

    @FXML
    private TextField pname;

    @FXML
    private Button cancel;

    @FXML
    private TextField page;

    @FXML
    private TextField weight;

    @FXML
    private HBox type;

    @FXML
    private ToggleGroup gender;

    @FXML
    private DatePicker date;

    @FXML
    private RadioButton unknown;

    @FXML
    private RadioButton cat;

    @FXML
    private RadioButton dog;

    @FXML
    private Button bookappointment;

    @FXML
    private RadioButton female;

    @FXML
    private RadioButton male;

    @FXML
    private TextField time;

    @FXML
    private Label messagenb;

    @FXML
    private Label messageem;

    @FXML
    private Label result;

    public AppointmentController() {this.database = null;
}




    public void initialize(){ }

    public void Submit(ActionEvent e){
        if(!name.getText().isEmpty() && !phone.getText().isEmpty() && !email.getText().isEmpty() && !pettype.getSelectedToggle().toString().isEmpty()
                && !pname.getText().isEmpty() && Integer.parseInt(page.getText()) != 0 && Double.parseDouble(weight.getText()) != 0
                && !gender.getSelectedToggle().toString().isEmpty() && !treatment.getSelectedToggle().toString().isEmpty()){

            try {
                //check if owner and pet exist in db or not
                OwnerModel om = new OwnerModel();
                Owner o = om.getOwner(name.getText(),phone.getText(),email.getText());
                int oid = o.getId();
                if(oid != 0){
                    PetModel pm = new PetModel();
                    Pet p = pm.getPet(pname.getText(),oid);
                    if(p==null)
                    {
                        if(pettype.getSelectedToggle().toString().equals("Dog")){
                            Dog d = new Dog(pname.getText(), o, Integer.parseInt(page.getText()), Double.parseDouble(weight.getText()), gender.getSelectedToggle().toString());
                            pm.addPet(d);
                            if(treatment.equals("Vaccination")) d.accept(new VaccinationVisitor());
                            else if(treatment.equals("Medication")){
                                d.accept(new MedicationVisitor());
                            }
                            else{
                                d.accept(new GroomingVisitor());
                            }
                        }
                        else{
                            Cat c = new Cat(pname.getText(), o, Integer.parseInt(page.getText()), Double.parseDouble(weight.getText()), gender.getSelectedToggle().toString());
                            pm.addPet(c);
                            if(treatment.equals("Vaccination")) c.accept(new VaccinationVisitor());
                            else if(treatment.equals("Medication")){
                                c.accept(new MedicationVisitor());
                            }
                            else{
                                c.accept(new GroomingVisitor());
                            }
                        }
                        
                    }
                }
                else{
                    Owner o1 = new Owner(name.getText(),email.getText(),phone.getText());
                    om.addOwner(o1);
                    int owner= o.getId();
                    PetModel pm = new PetModel();
                    if(pettype.getSelectedToggle().toString().equals("Dog")){
                        Dog d = new Dog(pname.getText(), o, Integer.parseInt(page.getText()), Double.parseDouble(weight.getText()), gender.getSelectedToggle().toString());
                        pm.addPet(d);
                        if(treatment.equals("Vaccination")) d.accept(new VaccinationVisitor());
                        else if(treatment.equals("Medication")){
                            d.accept(new MedicationVisitor());
                        }
                        else{
                            d.accept(new GroomingVisitor());
                        }
                    }
                    else{
                        Cat c = new Cat(pname.getText(), o, Integer.parseInt(page.getText()), Double.parseDouble(weight.getText()), gender.getSelectedToggle().toString());
                        pm.addPet(c);
                        if(treatment.equals("Vaccination")) c.accept(new VaccinationVisitor());
                        else if(treatment.equals("Medication")){
                            c.accept(new MedicationVisitor());
                        }
                        else{
                            c.accept(new GroomingVisitor());
                        }
                    }
                }
                VetModel vm = new VetModel();
                List<Vet> vets = vm.getVets();
                int s = vets.size();
                int i = (int) (Math.random()*s);
                Vet v = vets.get(i);
                Appointment a = new Appointment ( date.getValue(), time.getText(), o,v,treatment.getSelectedToggle().toString());
                AppointmentModel am = new AppointmentModel();
                am.addAppointment(a);
                result.setText("Appointment booked successfully");
            } catch (SQLException ex) {
                Logger.getLogger(AppointmentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            result.setText("Appointment not booked, try booking another one");
            return;
        }
    }

    public void Cancel(MouseEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxmls/home.fxml"));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public boolean isEmailValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public void validateemail(){
        String emailInput = email.getText();
        if (isEmailValid(emailInput)){
            messageem.setText("Email is valid");
        }
        else{
            messageem.setText("Email is invalid");
        }
    }
    public boolean isPhoneNumberValid(String phoneNumber) {
        String phoneRegex = "\\d{8}";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    public void validatenb(){
        String nbInput = phone.getText();
        if (isPhoneNumberValid(nbInput)){
            messagenb.setText("Phone number is valid");
        }
        else{
            messagenb.setText("Phone number is invalid");
        }
    }
}
