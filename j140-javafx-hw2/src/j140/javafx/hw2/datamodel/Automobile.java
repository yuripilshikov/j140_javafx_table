/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j140.javafx.hw2.datamodel;

/**
 *
 * @author YuriPilshikov
 */
public class Automobile {
    private int id;
    private String carMake;
    private String carModel;
    private String vin;
    private String responsibleEmail;
    private String responsibleName;

    public Automobile(int id, String carMake, String carModel, String vin, String responsibleEmail, String responsibleName) {
        this.id = id;
        this.carMake = carMake;
        this.carModel = carModel;
        this.vin = vin;
        this.responsibleEmail = responsibleEmail;
        this.responsibleName = responsibleName;
    }

    public int getId() {
        return id;
    }

    public String getCarMake() {
        return carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getVin() {
        return vin;
    }

    public String getResponsibleEmail() {
        return responsibleEmail;
    }

    public String getResponsibleName() {
        return responsibleName;
    }
    
    // no setters because we only create new entries, not modify existing
}
