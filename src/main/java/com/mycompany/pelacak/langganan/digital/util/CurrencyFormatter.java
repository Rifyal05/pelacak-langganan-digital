// CurrencyFormatter.java - VERSI LEBIH CANGGIH

package com.mycompany.pelacak.langganan.digital.util;

import com.mycompany.pelacak.langganan.digital.service.LocalizationService;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class CurrencyFormatter {

    /**
     * Memformat jumlah uang ke dalam format Rupiah (IDR),
     * menyesuaikan format angka (pemisah desimal/ribuan) dan simbol mata uang
     * berdasarkan bahasa aplikasi yang aktif.
     * @param amount Jumlah uang (double)
     * @return String hasil format mata uang
     */
    public static String formatRupiah(double amount) {
        Locale currentAppLocale = LocalizationService.getCurrentLocale();
        
        // Gunakan Locale aplikasi saat ini untuk formatting ANGKA
        NumberFormat numberFormatter = NumberFormat.getNumberInstance(currentAppLocale);
        
        // Dapatkan objek Currency untuk IDR
        Currency idrCurrency = Currency.getInstance("IDR"); 

        // Tentukan simbol yang akan digunakan
        String symbolToUse;
        if ("en".equals(currentAppLocale.getLanguage())) {
            symbolToUse = idrCurrency.getCurrencyCode();
        } else {
            symbolToUse = idrCurrency.getSymbol(new Locale("in", "ID")); 
        }
        
        numberFormatter.setMinimumFractionDigits(idrCurrency.getDefaultFractionDigits()); 
        numberFormatter.setMaximumFractionDigits(idrCurrency.getDefaultFractionDigits());
        return symbolToUse + " " + numberFormatter.format(amount);
    }
    
//    public static String formatUSD(double amount) {
//        Locale currentAppLocale = LocalizationService.getCurrentLocale();
//        NumberFormat usdFormat = NumberFormat.getCurrencyInstance(currentAppLocale);
//        
//        usdFormat.setCurrency(Currency.getInstance("USD"));
//
//        return usdFormat.format(amount);
//    }
}