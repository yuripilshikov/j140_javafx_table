/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j140.javafx.fxml;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author YuriPilshikov
 */
public class TableStage extends Stage{

    public TableStage() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/j140/javafx/fxml/views/TableFXML.fxml"));        
        Scene scene = new Scene(root);        
        this.setScene(scene);
        this.show();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }   
}
