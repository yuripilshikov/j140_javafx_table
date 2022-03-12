/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j140.javafx.fxml;

import j140.javafx.fxml.controllers.TableController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author YuriPilshikov
 */
public class AddNewStage extends Stage {
    
    TableController tableController;
    

    public AddNewStage(TableController tableController) {
        this.tableController = tableController;
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/j140/javafx/fxml/views/AddNewFXML.fxml"));
            Scene scene = new Scene(root);
            setScene(scene);
            show();
        } catch (IOException ex) {
            Logger.getLogger(AddNewStage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void close() {
        
        super.close(); //To change body of generated methods, choose Tools | Templates.
        // add some logic
        System.out.println("Some logic after close");
        tableController.refreshTable();
    }
    
    

}
