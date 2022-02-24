/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j140.javafx.hw2;

/**
 *
 * @author YuriPilshikov
 */
public class User {
    private String name;
    private String password;
    private String connectionString;

    public User(String name, String password, String connectionString) {
        this.name = name;
        this.password = password;
        this.connectionString = connectionString;
    }    

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getConnectionString() {
        return connectionString;
    }
    
    
}
