// File: src/main/java/com/mycompany/pelacak/langganan/digital/util/CurrencyFormatter.java

package com.mycompany.pelacak.langganan.digital.util;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {

    public static String formatRupiah(double amount) {
        Locale indonesia = new Locale("in", "ID");
        NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(indonesia);
        return rupiahFormat.format(amount).replace("Rp", "Rp ");
    }
    
    public static String formatUSD(double amount) {
        Locale us = new Locale("en", "US");
        NumberFormat usdFormat = NumberFormat.getCurrencyInstance(us);
        return usdFormat.format(amount);
    }
}