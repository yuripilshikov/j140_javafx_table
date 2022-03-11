/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j140.javafx.fxml.logic;
import j140.javafx.fxml.datamodel.Automobile;
import j140.javafx.fxml.datamodel.UserController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *user.getConnectionString(), user.getName(), user.getPassword())
 * @author YuriPilshikov
 */
public class DatabaseReader {

    public ObservableList<Automobile> getAutomobiles;

    
    private ArrayList<Automobile> getDataFromDB() {
        ArrayList<Automobile> arrayList = new ArrayList<>();
        String query = "SELECT * FROM TEST.AUTOMOBILES";
        try(Connection conn = DriverManager.getConnection(Props.getValue("connectString"), Props.getValue("login"), Props.getValue("password")); 
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                arrayList.add(new Automobile(rs.getInt("ID"), rs.getString("CAR_MAKE"), rs.getString("CAR_MODEL"), rs.getString("VIN"), rs.getString("RESPONSIBLE_EMAIL"), rs.getString("RESPONSIBLE_NALE")));
            }
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return arrayList;
    }
    
    public ObservableList<Automobile> getAutomobiles() {
        ObservableList<Automobile> list = FXCollections.observableArrayList(getDataFromDB());
        return list;
    }
    
    public static int getLastId() {
        int lastId = -1;
        String query = "SELECT MAX(ID) from test.automobiles";
        try(Connection conn = DriverManager.getConnection(Props.getValue("connectString"), Props.getValue("login"), Props.getValue("password"));
                PreparedStatement pstmt = conn.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery()) {
            if(rs.next()) {
                lastId = rs.getInt(1);
            }
            System.out.println(lastId);
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lastId;
    }
    
    public static void addCar(Automobile automobile) {
        String query = "INSERT INTO TEST.AUTOMOBILES (ID, CAR_MAKE, CAR_MODEL, VIN, RESPONSIBLE_EMAIL, RESPONSIBLE_NALE) VALUES (?, ?, ?, ?, ?, ?)";
        try(Connection conn = DriverManager.getConnection(Props.getValue("connectString"), Props.getValue("login"), Props.getValue("password"));
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, automobile.getId());
            pstmt.setString(2, automobile.getCarMake());
            pstmt.setString(3, automobile.getCarModel());
            pstmt.setString(4, automobile.getVin());
            pstmt.setString(5, automobile.getResponsibleEmail());
            pstmt.setString(6, automobile.getResponsibleName());
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
