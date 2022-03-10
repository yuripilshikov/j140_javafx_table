/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j140.javafx.fxml.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author YuriPilshikov
 */
public class Props {
    // this class reads properties
    static File file;
    static Properties properties;

    static {
        properties = new Properties();
        file = new File("dbconnect.properties");
    }

    public static String getValue(String key) {
        String value = "";
        try (FileReader filereader = new FileReader(file)) {
            properties.load(filereader);
            value = properties.getProperty(key);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return value;
    }
}
