/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplyrugby;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HP
 */
public class DBConnection {

    private static Connection conn = null;

    public static Connection getConnection() {

        if (conn == null) {

            try {
                // Set up a connection to the Access database using a DSN
                String dbURL = "jdbc:ucanaccess://simply_rugby.accdb";
                String user = "";
                String password = "";
                conn = DriverManager.getConnection(dbURL, user, password);

            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
                e.printStackTrace();
            }

        }
        return conn;
    }

}
