/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j140.javafx.fxml.controllers;

import j140.javafx.fxml.AddNewStage;
import j140.javafx.fxml.datamodel.Automobile;
import j140.javafx.fxml.logic.DatabaseReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author pilshikov.y
 */
public class TableController implements Initializable {
    
    private DatabaseReader dbr;
    
    @FXML
    private TableView table;
    
    @FXML
    TableColumn colId, colCarMake, colCarModel, colVin, colResponsibleEmail, colResponsibleName;
    
    
    @FXML
    private void addNewButton(ActionEvent event) {
        // create addNewEntry stage
        AddNewStage ans = new AddNewStage();
        
        System.out.println("Add new window closed");    
    }
    
    private void updateTable(ObservableList<Automobile> list) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCarMake.setCellValueFactory(new PropertyValueFactory<>("carMake"));
        colCarModel.setCellValueFactory(new PropertyValueFactory<>("carModel"));
        colVin.setCellValueFactory(new PropertyValueFactory<>("vin"));
        colResponsibleEmail.setCellValueFactory(new PropertyValueFactory<>("responsibleEmail"));
        colResponsibleName.setCellValueFactory(new PropertyValueFactory<>("responsibleName"));
        table.setItems(list);        
    }
    
    public void refreshTable(ActionEvent event) {
        updateTable(dbr.getAutomobiles());

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dbr = new DatabaseReader();
        updateTable(dbr.getAutomobiles());
    }    
    
}
