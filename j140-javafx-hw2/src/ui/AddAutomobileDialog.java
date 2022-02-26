/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import datamodel.CarController;
import datamodel.CarException;
import datamodel.UserController;
import datamodel.UserException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author YuriPilshikov
 */
public class AddAutomobileDialog extends Stage{
    Scene scene;
    MainWindow mainWindow;
    
    public void init(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(5);
        root.setVgap(5);
        scene = new Scene(root, 400, 300);

        Label label = new Label("Add new automobile");
        root.add(label, 0, 0);

        GridPane enterText = new GridPane();
        enterText.setAlignment(Pos.BOTTOM_RIGHT);
        enterText.setHgap(5);
        enterText.setVgap(5);
        root.add(enterText, 0, 1);

        Label makeLabel = new Label("Car make");
        TextField makeField = new TextField();
        enterText.add(makeLabel, 0, 0);
        enterText.add(makeField, 1, 0);
        
        Label modelLabel = new Label("Car model");
        TextField modelField = new TextField();
        enterText.add(modelLabel, 0, 1);
        enterText.add(modelField, 1, 1);
        
        Label vinLabel = new Label("VIN");
        TextField vinField = new TextField();
        enterText.add(vinLabel, 0, 2);
        enterText.add(vinField, 1, 2);
        
        Label emailLabel = new Label("Responsible email");
        TextField emailField = new TextField();
        enterText.add(emailLabel, 0, 3);
        enterText.add(emailField, 1, 3);
        
        Label nameLabel = new Label("Responsible name");
        TextField nameField = new TextField();
        enterText.add(nameLabel, 0, 4);
        enterText.add(nameField, 1, 4);
        
        FlowPane flowPane1 = new FlowPane();
        flowPane1.setAlignment(Pos.CENTER);
        Label bottom = new Label("");
        flowPane1.getChildren().add(bottom);
        root.add(flowPane1, 0, 3);

        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER_RIGHT);
        Button addCar = new Button("Add Automobile");
        addCar.setOnAction((e) -> {
            bottom.setText("");
            String make = makeField.getText();
            String model = modelField.getText();
            String vin = vinField.getText();
            String email = emailField.getText();
            String name = nameField.getText();
            try {
                boolean answer = CarController.checkCar(make, model, vin, email, name);                
                if(answer) {
                    mainWindow.read();
                    this.close();
                } else {
                    throw new CarException("Unknown error");
                }
            } catch (CarException ex) {
                bottom.setText(ex.getMessage());
            }
        });
        flowPane.getChildren().add(addCar);
        root.add(flowPane, 0, 2);

        setTitle("Add car");
        setScene(scene);
        show();
    }
}
