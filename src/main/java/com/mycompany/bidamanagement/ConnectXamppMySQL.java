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
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/bidadatabase?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String username = "admin";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
        }
        catch (ClassNotFoundException|SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
}
