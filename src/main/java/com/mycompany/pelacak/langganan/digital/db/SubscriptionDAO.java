/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pelacak.langganan.digital.db;

import com.mycompany.pelacak.langganan.digital.model.Subscription;
import com.mycompany.pelacak.langganan.digital.service.SessionManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

        java.sql.Date sqlDate = rs.getDate("next_due_date");
        if (sqlDate != null) {
            sub.setNextDueDate(sqlDate.toLocalDate());
        } else {
            sub.setNextDueDate(null);
        }
        sub.setLogo(rs.getBytes("logo"));
        sub.setUserId(rs.getInt("user_id"));
        return sub;
    }

    public boolean addSubscription(Subscription sub) {
        String sql = "INSERT INTO " + getTableName() + " (service_name, cost, currency, billing_cycle, next_due_date, logo, user_id) VALUES (?, ?, ?, ?, ?, ?, ?)"; // <-- BARU: Tambahkan user_id di query
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, sub.getServiceName());
            pstmt.setDouble(2, sub.getCost());
            pstmt.setString(3, sub.getCurrency());
            pstmt.setString(4, sub.getBillingCycle());
            if (sub.getNextDueDate() != null) {
                pstmt.setDate(5, Date.valueOf(sub.getNextDueDate()));
            } else {
                pstmt.setNull(5, java.sql.Types.DATE);
            }
            pstmt.setBytes(6, sub.getLogo());
            pstmt.setInt(7, sub.getUserId());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public void update(Subscription sub) {
        String sql = "UPDATE " + getTableName() + " SET service_name = ?, cost = ?, currency = ?, "
                + "billing_cycle = ?, next_due_date = ?, logo = ? WHERE id = ? AND user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, sub.getServiceName());
            pstmt.setDouble(2, sub.getCost());
            pstmt.setString(3, sub.getCurrency());
            pstmt.setString(4, sub.getBillingCycle());
            if (sub.getNextDueDate() != null) {
                pstmt.setDate(5, Date.valueOf(sub.getNextDueDate()));
            } else {
                pstmt.setNull(5, java.sql.Types.DATE);
            }
            pstmt.setBytes(6, sub.getLogo());
            pstmt.setInt(7, sub.getId());
            pstmt.setInt(8, SessionManager.getCurrentUserId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public List<Subscription> getAllSubscriptions() {
        List<Subscription> subscriptions = new ArrayList<>();
        String sql = "SELECT * FROM " + getTableName() + " WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, SessionManager.getCurrentUserId());

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    subscriptions.add(mapResultSetToObject(rs));
                }
            }
        } catch (SQLException e) {
        }
        return subscriptions;
    }

    public Subscription getSubscriptionById(int id) {
        String sql = "SELECT * FROM " + getTableName() + " WHERE id = ? AND user_id = ?";
        Subscription sub = null;
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.setInt(2, SessionManager.getCurrentUserId());

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    sub = mapResultSetToObject(rs);
                }
            }
        } catch (SQLException e) {
        }
        return sub;
    }

    public boolean deleteSubscription(int id) {
        String sql = "DELETE FROM " + getTableName() + " WHERE id = ? AND user_id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.setInt(2, SessionManager.getCurrentUserId());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteAllSubscriptions() {
        String sql = "DELETE FROM " + getTableName() + " WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, SessionManager.getCurrentUserId());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            return false;
        }
    }

}
