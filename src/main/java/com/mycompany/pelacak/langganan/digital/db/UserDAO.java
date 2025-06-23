/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pelacak.langganan.digital.db;

import java.sql.Connection;
import com.mycompany.pelacak.langganan.digital.model.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rifial
 */
public class UserDAO extends GenericDAO<Users> {

    // 1. IMPLEMENTASI METODE ABSTRAK: Beri tahu nama tabelnya
    @Override
    protected String getTableName() {
        return "users";
    }

    // 2. IMPLEMENTASI METODE ABSTRAK: memetakan ResultSet ke objek Users
    @Override
    protected Users mapResultSetToObject(ResultSet rs) throws SQLException {
        Users user = new Users();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setHashed_password(rs.getString("hashed_password"));
        user.setSalt(rs.getString("salt"));
        return user;
    }

    @Override
    public void update(Users entity) {
        throw new UnsupportedOperationException("Update user tidak diimplementasikan.");
    }

    // METODE YANG SPESIFIK UNTUK UserDAO (KARENA QUERY-NYA CUSTOM)
    public void addUser(Users usr) {
        String sql = "INSERT INTO users (username, hashed_password, salt) VALUES (?, ?, ?)";

        // Menggunakan try-with-resources untuk koneksi dan statement
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usr.getUsername());
            stmt.setString(2, usr.getHashed_password());
            stmt.setString(3, usr.getSalt());
            stmt.executeUpdate();

        } catch (SQLException e) {

        }
    }

    public Users getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        Users user = null;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Gunakan metode yang sudah dibuat untuk menghindari duplikasi kode
                    user = mapResultSetToObject(rs);
                }
            }
        } catch (SQLException e) {
        }
        return user;
    }

    public boolean isUsernameExists(String username) {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error saat memeriksa username: " + e.getMessage());
            // Jika ada error, anggap username sudah ada untuk mencegah duplikasi
            return true;
        }
        return false;
    }
}
