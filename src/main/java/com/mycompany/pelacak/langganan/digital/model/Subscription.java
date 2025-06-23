/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pelacak.langganan.digital.model;

import java.time.LocalDate;

/**
 *
 * @author rifial
 */
public class Subscription {

    private int id;
    private String serviceName;
    private double cost;
    private String currency;
    private String billingCycle;
    private LocalDate nextDueDate;
    private String category;
    private String notes;
    private byte[] logo;

    public String getCurrency() {
        return currency;
    }

    public String getCategory() {
        return category;
    }

    public String getNotes() {
        return notes;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getCost() {
        return cost;
    }

    public String getBillingCycle() {
        return billingCycle;
    }

    public LocalDate getNextDueDate() {
        return nextDueDate;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setBillingCycle(String billingCycle) {
        this.billingCycle = billingCycle;
    }

    public void setNextDueDate(LocalDate nextDueDate) {
        this.nextDueDate = nextDueDate;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

}
