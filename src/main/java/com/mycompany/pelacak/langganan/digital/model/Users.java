/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pelacak.langganan.digital.model;

/**
 *
 * @author rifial
 */
public class Users {

    private int id;
    private String username;
    private String hashed_password;
    private String salt;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getHashed_password() {
        return hashed_password;
    }

    public String getSalt() {
        return salt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setHashed_password(String hashed_password) {
        this.hashed_password = hashed_password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

}
