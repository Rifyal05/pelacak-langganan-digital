/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pelacak.langganan.digital.util;

/**
 *
 * @author rifial
 */
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {

    public static String toRupiah(double value) {
        // Membuat Locale untuk Indonesia.
        @SuppressWarnings("deprecation")
        Locale indonesia = new Locale("id", "ID");
        
        // Mendapatkan instance NumberFormat yang dikonfigurasi untuk mata uang
        // berdasarkan Locale yang diberikan.
        NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(indonesia);
        
        // Melakukan format dan mengembalikan hasilnya sebagai String.
        return rupiahFormat.format(value);
    }
    
    public static String toUSD(double value) {
        NumberFormat usdFormat = NumberFormat.getCurrencyInstance(Locale.US);
        return usdFormat.format(value);
    }
}
