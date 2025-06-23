/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pelacak.langganan.digital.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rifial
 * @param <T>
 */
public abstract class GenericDAO<T> {

    /**
     * @return
     */
    protected abstract String getTableName();

    /**
     * Mengubah satu baris dari ResultSet menjadi objek model T.
     *
     * @param rs ResultSet yang sedang di-iterasi.
     * @return Objek model T yang sudah diisi data.
     * @throws SQLException Jika ada error saat mengakses kolom.
     */
    protected abstract T mapResultSetToObject(ResultSet rs) throws SQLException;

    /**
     * Memperbarui satu record di database berdasarkan data dari objek model.
     *
     * @param entity Objek model T yang berisi data baru dan ID dari record yang
     * akan diupdate.
     */
    public abstract void update(T entity);

    /**
     * Mengambil semua data dari tabel.
     *
     * @return List dari objek model T.
     */
    public List<T> getAll() {
        List<T> list = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName();

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(mapResultSetToObject(rs));
            }
        } catch (SQLException e) {
        }
        return list;
    }

    /**
     * Menghapus data berdasarkan ID.
     *
     * @param id ID dari record yang akan dihapus.
     */
    public void delete(int id) {
        String sql = "DELETE FROM " + getTableName() + " WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
