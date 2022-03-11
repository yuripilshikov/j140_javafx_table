/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j140.javafx.fxml.datamodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import j140.javafx.fxml.logic.Props;

/**
 *
 * @author YuriPilshikov
 */
public class UserController {

    public static boolean checkData(String name, String pass) throws UserException {
        if (name.isEmpty()) {
            throw new UserException("Name cannot be empty.");
        }
        if (pass.isEmpty()) {
            throw new UserException("Password cannot be empty.");
        }        
        String regex = "A-Za-z0-9!";
        if (pass.replaceAll("[" + regex + "]", "").length() > 0) {
            throw new UserException("Password may contain only:  " + regex);
        }        
        
        // create user (no need, to be honest. But let it be, though)
        User user = new User(name, pass);
        
        if(!(user.getName().equals(Props.getValue("login")))) {
            throw new UserException("Login is incorrect!");
        }
        
        if(!(user.getPassword().equals(Props.getValue("password")))) {
            throw new UserException("Password is incorrect!");
        }
        return true;
    }

    

    
}
