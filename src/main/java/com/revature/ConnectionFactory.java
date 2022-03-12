package com.revature;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.sql.PreparedStatement;

public class ConnectionFactory {
    private static Connection connection = null;

    private ConnectionFactory() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("com/revature/dbConfig");
            String url = resourceBundle.getString("url");
            String username = resourceBundle.getString("username");
            String password = resourceBundle.getString("password");
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;


    }
}
