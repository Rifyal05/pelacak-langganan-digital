/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.DatabaseConnection to edit this template
 */
package com.mycompany.pelacak.langganan.digital.db;

/**
 *
 * @author rifial
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;
    
    // ALAMAT KONEKSI
    private static final String URL = "jdbc:mysql://localhost:3306/pelacak_langganan_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // MEMBUAT KONEKSI
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Koneksi ke MySQL Berhasil!");
            } catch (ClassNotFoundException | SQLException e) {
            }
        }
        return connection;
    }
}
