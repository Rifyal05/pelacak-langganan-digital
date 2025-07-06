/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pelacak.langganan.digital.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rifial
 */
public class DatabaseConnection {

    // Informasi koneksi database kamu
    private static final String URL = "jdbc:mysql://localhost:3306/pelacak_langganan_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    /**
     * @return
     * @throws java.sql.SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}