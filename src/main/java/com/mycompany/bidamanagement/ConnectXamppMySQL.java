/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author duc
 */
public class ConnectXamppMySQL {
    public static Connection conn() {
        Connection conn = null;  // Initialize the connection to null
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bidadatabase?zeroDateTimeBehavior=CONVERT_TO_NULL";
            String username = "admin";
            String password = "123456";
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            // Display a message to the user or log the exception
            JOptionPane.showMessageDialog(null, "Error connecting to the database:\n" + e.getMessage());
            e.printStackTrace();  // Log the exception (you may want to replace this with proper logging)
        }

        return conn;  // Return the connection (might be null if an error occurred)
    }
}