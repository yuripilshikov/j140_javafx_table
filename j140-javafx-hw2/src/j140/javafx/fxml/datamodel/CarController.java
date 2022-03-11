/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j140.javafx.fxml.datamodel;

import j140.javafx.fxml.logic.DatabaseReader;

/**
 *
 * @author YuriPilshikov
 */
public class CarController {
    public static boolean checkCar(String make, String model, String vin, String email, String name) throws CarException {
        if(make.isEmpty()) {
            throw new CarException("Make cannot be empty!");
        }
        if(model.isEmpty()) {
            throw new CarException("Model cannot be empty!");            
        }
        if(vin.isEmpty()) {
            throw new CarException("VIN cannot be empty!");            
        }
        if(email.isEmpty()) {
            throw new CarException("Email cannot be empty!");
        }
        if(name.isEmpty()) {
            throw new CarException("Name cannot be empty!");
        }
        
        int i = DatabaseReader.getLastId() + 1;
        
        Automobile automobile = new Automobile(i, make, model, vin, email, name);
        DatabaseReader.addCar(automobile);        
        return true;
    }
}
