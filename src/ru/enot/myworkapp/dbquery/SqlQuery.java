/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.enot.myworkapp.dbquery;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author EHOT
 */
public class SqlQuery {

    public static void sqlQuery(String af) throws IOException, SQLException {
        Statement stat;
        String i = "";
        int id = 0;
        try (Connection conn = SqlConnector.getConnection()) {
            stat = conn.createStatement();
            stat.execute("DROP TABLE IF EXISTS Greetings");
            stat.execute("CREATE TABLE IF NOT EXISTS Greetings (Message CHAR(20))");
            stat.execute("INSERT INTO Greetings VALUES ('" + af + "')");

        }

    }

    public String quaeryResult() throws SQLException, IOException {
        String i = "";
        Statement stat;
        try (Connection conn = SqlConnector.getConnection()) {
            stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT Message FROM Greetings");
            while (result.next()) {
                i = result.getString("Message");
            }

        }
        return i;

    }
}
