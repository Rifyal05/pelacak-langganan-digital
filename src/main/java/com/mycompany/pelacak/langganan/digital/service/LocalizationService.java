package com.mycompany.pelacak.langganan.digital.service;


import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author rifial & Ai
 */
@SuppressWarnings("deprecation")
public class LocalizationService {

    private static final String BUNDLE_BASE_NAME = "com/mycompany/pelacak/langganan/digital/localization/Bundle";

    private static Locale currentLocale;
    private static ResourceBundle bundle;

    static {
        setLocale(new Locale("id", "ID")); 
    }


    public static void setLocale(Locale locale) {
        currentLocale = locale;
        bundle = ResourceBundle.getBundle(BUNDLE_BASE_NAME, currentLocale);
    }

    public static Locale getCurrentLocale() {
        return currentLocale;
    }

    public static String getString(String key) {
        try {
            return bundle.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!'; 
        }
    }
    
    public static String getString(String key, Object... params) {
        try {
            String pattern = bundle.getString(key);
            return MessageFormat.format(pattern, params);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}