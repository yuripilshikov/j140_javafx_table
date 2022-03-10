/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j140.javafx.fxml.controllers;

import j140.javafx.fxml.datamodel.CarController;
import j140.javafx.fxml.datamodel.CarException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author YuriPilshikov
 */
public class AddNewController implements Initializable {

    @FXML
    private TextField makeField;

    @FXML
    private TextField modelField;

    @FXML
    private TextField vinField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField nameField;
    
    @FXML
    private Label bottom;

    @FXML
    public void addNewAutomobile(ActionEvent event) {
        String make = makeField.getText();
        String model = modelField.getText();
        String vin = vinField.getText();
        String email = emailField.getText();
        String name = nameField.getText();
        bottom.setText("");
        try {
            boolean answer = CarController.checkCar(make, model, vin, email, name);
            if (answer) {
                System.out.println(answer);
                
                // add to database
                
//                    mainWindow.read();
//                    this.close();

                // close this window
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
            } else {
                throw new CarException("Unknown error");
            }
        } catch (CarException ex) {
            bottom.setText(ex.getMessage());
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
