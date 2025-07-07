/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pelacak.langganan.digital.service;

import com.mycompany.pelacak.langganan.digital.model.Users;

/**
 *
 * @author rifial
 */
public class SessionManager {

    private static Users currentUser; 

    /**
     * Mengatur pengguna yang sedang login.
     * Dipanggil setelah login berhasil.
     *
     * @param user Objek Users dari pengguna yang login.
     */
    public static void setCurrentUser(Users user) {
        currentUser = user;
    }

    /**
     * Mendapatkan objek Users dari pengguna yang sedang login.
     *
     * @return Objek Users yang sedang login, atau null jika tidak ada yang login.
     */
    public static Users getCurrentUser() {
        return currentUser;
    }

    /**
     * Menghapus sesi pengguna.
     * Dipanggil saat logout.
     */
    public static void clearCurrentUser() {
        currentUser = null;
    }

    /**
     * Memeriksa apakah ada pengguna yang sedang login.
     *
     * @return true jika ada pengguna yang login, false jika tidak.
     */
    public static boolean isLoggedIn() {
        return currentUser != null;
    }

    /**
     * Mendapatkan ID pengguna yang sedang login.
     *
     * @return ID pengguna yang login, atau -1 jika tidak ada yang login.
     */
    public static int getCurrentUserId() {
        return currentUser != null ? currentUser.getId() : -1;
    }
}
