/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import datamodel.Automobile;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logic.DatabaseReader;

/**
 *
 * @author YuriPilshikov
 */
public class MainWindow extends Application {
    Scene scene;
    LoginDialog loginDialog;
    Stage primaryStage;
    DatabaseReader dbr;
    TableView<Automobile> table;
    
    @Override
    public void start(Stage primaryStage) {
        dbr = new DatabaseReader();
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Automobiles table");
        
        LoginDialog login = new LoginDialog();
        login.initModality(Modality.APPLICATION_MODAL);
        login.init(this);
        
        // create table view
        table = new TableView<>();
        VBox layout = new VBox();
        scene = new Scene(layout, 640, 480); 
        
        TableColumn<Automobile, Integer> tcId = new TableColumn<>("ID");
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        table.getColumns().add(tcId);
        
        TableColumn<Automobile, String> tcCarMake = new TableColumn<>("Car Make");
        tcCarMake.setCellValueFactory(new PropertyValueFactory<>("carMake"));
        table.getColumns().add(tcCarMake);
        
        TableColumn<Automobile, String> tcCarModel = new TableColumn<>("Car Model");
        tcCarModel.setCellValueFactory(new PropertyValueFactory<>("carModel"));
        table.getColumns().add(tcCarModel);
        
        TableColumn<Automobile, String> tcVin = new TableColumn<>("VIN");
        tcVin.setCellValueFactory(new PropertyValueFactory<>("vin"));
        table.getColumns().add(tcVin);
        
        TableColumn<Automobile, String> tcResponsibleEmail = new TableColumn<>("Responsible Person Email");
        tcResponsibleEmail.setCellValueFactory(new PropertyValueFactory<>("responsibleEmail"));
        table.getColumns().add(tcResponsibleEmail);
        
        TableColumn<Automobile, String> tcResponsibleName = new TableColumn<>("Responsible Person");
        tcResponsibleName.setCellValueFactory(new PropertyValueFactory<>("responsibleName"));
        table.getColumns().add(tcResponsibleName);     
        
        layout.getChildren().add(table);   
        
        // Add new entry
        Button addNewEntry = new Button("Add new automobile");
        layout.getChildren().add(addNewEntry);
        addNewEntry.setOnAction((e) -> {
            AddAutomobileDialog addauto = new AddAutomobileDialog();
            addauto.init(this);
        });
        
        primaryStage.setScene(scene);  
    }
    
    public void show() {
        primaryStage.show();
    }
    
    public void read() {
        table.setItems(dbr.getAutomobiles());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }    
}
