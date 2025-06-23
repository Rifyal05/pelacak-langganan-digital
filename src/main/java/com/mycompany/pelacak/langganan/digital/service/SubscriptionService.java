/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pelacak.langganan.digital.service;

import com.mycompany.pelacak.langganan.digital.db.SubscriptionDAO;
import com.mycompany.pelacak.langganan.digital.model.Subscription;
import java.util.List;

/**
 *
 * @author rifial
 */


public class SubscriptionService {
    
    private final SubscriptionDAO subscriptionDAO;

    public SubscriptionService() {
        this.subscriptionDAO = new SubscriptionDAO();
    }

    public List<Subscription> getAllSubscriptions() {
        // meneruskan permintaan ke DAO
        return subscriptionDAO.getAll();
    }

    public void addSubscription(Subscription subscription) {
        if (subscription.getServiceName() == null || subscription.getServiceName().trim().isEmpty()) {
            System.err.println("Nama layanan tidak boleh kosong!");
            return;
        }
        
        subscriptionDAO.addSubscription(subscription);
    }
    
    public void updateSubscription(Subscription subscription) {
        // validasi
        if (subscription.getId() <= 0) {
            throw new IllegalArgumentException("ID langganan tidak valid untuk update.");
        }
        if (subscription.getServiceName() == null || subscription.getServiceName().trim().isEmpty()) {
            throw new IllegalArgumentException("Nama layanan tidak boleh kosong!");
        }
        
        // Panggil metode update dari DAO
        subscriptionDAO.update(subscription);
    }
}
