/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bidamanagement;

import java.sql.Connection;

/**
 *
 * @author duc
 */
public class BidaManagement {
    static Connection conn;
    public static void main(String[] args) {
        conn = ConnectXamppMySQL.conn();
        if (conn != null) {
            // Kết nối thành công, chạy Splash screen
            new Splash().setVisible(true);
        } else {
            System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
        }
      
    }
}
