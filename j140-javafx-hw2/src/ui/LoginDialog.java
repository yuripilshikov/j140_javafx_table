/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import datamodel.UserController;
import datamodel.UserException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author YuriPilshikov
 */
public class LoginDialog extends Stage {
    Scene scene;
    MainWindow mainWindow;

    public void init(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(5);
        root.setVgap(5);
        scene = new Scene(root, 400, 300);

        Label label = new Label("Authorization");
        root.add(label, 0, 0);

        GridPane enterText = new GridPane();
        enterText.setAlignment(Pos.BOTTOM_RIGHT);
        enterText.setHgap(5);
        enterText.setVgap(5);
        root.add(enterText, 0, 1);

        Label nameLabel = new Label("Name");
        TextField nameField = new TextField();
        enterText.add(nameLabel, 0, 0);
        enterText.add(nameField, 1, 0);

        Label passLabel = new Label("Password");
        PasswordField passField = new PasswordField();
        enterText.add(passLabel, 0, 1);
        enterText.add(passField, 1, 1);

        FlowPane flowPane1 = new FlowPane();
        flowPane1.setAlignment(Pos.CENTER);
        Label bottom = new Label("");
        flowPane1.getChildren().add(bottom);
        root.add(flowPane1, 0, 3);

        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER_RIGHT);
        Button signIn = new Button("Sign in");
        signIn.setOnAction((e) -> {
            bottom.setText("");
            String name = nameField.getText();
            String pass = passField.getText();
            try {
                UserController.checkData(name, pass);
                bottom.setText("All fields are valid");
                // show Table window
                mainWindow.show();
                mainWindow.read();
                this.close();
                
            } catch (UserException ex) {
                bottom.setText(ex.getMessage());
            }
        });
        flowPane.getChildren().add(signIn);
        root.add(flowPane, 0, 2);

        setTitle("Login");
        setScene(scene);
        show();
    }

}
