/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pelacak.langganan.digital.db;

import com.mycompany.pelacak.langganan.digital.model.Subscription;
import java.sql.*;

/**
 *
 * @author rifial
 */
public class SubscriptionDAO extends GenericDAO<Subscription> {

    // 1. IMPLEMENTASI METODE ABSTRAK: Beri tahu nama tabelnya
    @Override
    protected String getTableName() {
        return "subscriptions";
    }

    // 2. IMPLEMENTASI METODE ABSTRAK: memetakan ResultSet ke objek Subscription
    @Override
    protected Subscription mapResultSetToObject(ResultSet rs) throws SQLException {
        Subscription sub = new Subscription();
        sub.setId(rs.getInt("id"));
        sub.setServiceName(rs.getString("service_name"));
        sub.setCost(rs.getDouble("cost"));
        sub.setCurrency(rs.getString("currency"));
        sub.setBillingCycle(rs.getString("billing_cycle"));
        sub.setNextDueDate(rs.getDate("next_due_date").toLocalDate());
        sub.setLogo(rs.getBytes("logo"));
        return sub;
    }

    // METODE SPESIFIK ADD DI SUBSCDAO
    public void addSubscription(Subscription sub) {
        String sql = "INSERT INTO subscriptions (service_name, cost, currency, billing_cycle, next_due_date, logo) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, sub.getServiceName());
            stmt.setDouble(2, sub.getCost());
            stmt.setString(3, sub.getCurrency());
            stmt.setString(4, sub.getBillingCycle());
            stmt.setDate(5, Date.valueOf(sub.getNextDueDate()));
            stmt.setBytes(6, sub.getLogo());

            stmt.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void update(Subscription sub) {
        String sql = "UPDATE subscriptions SET service_name = ?, cost = ?, currency = ?, "
                + "billing_cycle = ?, next_due_date = ?, logo = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set parameter untuk kolom-kolom yang di-update
            stmt.setString(1, sub.getServiceName());
            stmt.setDouble(2, sub.getCost());
            stmt.setString(3, sub.getCurrency());
            stmt.setString(4, sub.getBillingCycle());
            stmt.setDate(5, Date.valueOf(sub.getNextDueDate()));
            stmt.setBytes(6, sub.getLogo());

            // Set parameter untuk klausa WHERE
            stmt.setInt(7, sub.getId());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Langganan dengan ID " + sub.getId() + " berhasil diupdate.");
            } else {
                System.out.println("Tidak ada langganan dengan ID " + sub.getId() + " yang ditemukan untuk diupdate.");
            }

        } catch (SQLException e) {

        }
    }

}
