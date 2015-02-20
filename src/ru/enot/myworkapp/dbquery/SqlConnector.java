/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.enot.myworkapp.dbquery;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author EHOT
 */
public class SqlConnector {

    public static final Path PROP_FILE_PATH = Paths.get("C:\\Users\\EHOT\\Documents\\MyWorkApp\\database.properties");
    public static boolean connection = true;

    public static Connection getConnection() throws IOException, SQLException {
        Properties prop = new Properties();
        try (InputStream in = Files.newInputStream(PROP_FILE_PATH)) {
            prop.load(in);
        }
        String url = prop.getProperty("jdbc.url");
        String username = prop.getProperty("jdbc.user");
        String password = prop.getProperty("jdbc.password");
        return DriverManager.getConnection(url, username, password);

    }
}
