/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j140.javafx.fxml.controllers;

import j140.javafx.fxml.MainFrame;
import j140.javafx.fxml.TableStage;
import j140.javafx.fxml.datamodel.UserController;
import j140.javafx.fxml.datamodel.UserException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author YuriPilshikov
 */
public class LoginController implements Initializable {

    private boolean externalCSS;

    @FXML
    private Label bottomLabel;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void signInAction(ActionEvent event) {
        bottomLabel.setText("TEST");
        System.out.println("TEST");

        try {
            String name = nameField.getText(); // fails here
            String pass = passwordField.getText(); // and here
            UserController.checkData(name, pass);
            bottomLabel.setText("All fields are valid");
            TableStage ts = new TableStage();
            // close login window... Is it possible to make it less weird?
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
        } catch (UserException ex) {
            bottomLabel.setText(ex.getMessage());
        }
    }

    public void switchCSS(ActionEvent event) {
        // not working... Could not find out why.
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        Scene scene = stage.getScene();
        externalCSS = !externalCSS;
        if (externalCSS) {
            scene.getStylesheets().clear();            
            scene.getStylesheets().add("/j140/javafx/fxml/resources/login.css");
        } else {
            scene.getStylesheets().clear();
            scene.getStylesheets().add("file:modena.css");
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
