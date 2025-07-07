package com.mycompany.pelacak.langganan.digital.util;

import com.mycompany.pelacak.langganan.digital.model.Subscription;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class SerializationUtil {

    public static boolean saveSubscriptionsToFile(List<Subscription> subscriptions, File file) {
        try (FileOutputStream fileOut = new FileOutputStream(file); // Menggunakan File objek
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            
            out.writeObject(subscriptions);
            System.out.println("Data langganan berhasil disimpan ke " + file.getAbsolutePath());
            return true;
        } catch (IOException i) {
            System.err.println("Gagal menyimpan data langganan: " + i.getMessage());
            return false;
        }
    }

    @SuppressWarnings({"unchecked", "unchecked"})
    public static List<Subscription> loadSubscriptionsFromFile(File file) { 
        List<Subscription> subscriptions = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream(file);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            
            subscriptions = (List<Subscription>) in.readObject();
            System.out.println("Data langganan berhasil dimuat dari " + file.getAbsolutePath());
            return subscriptions;
        } catch (IOException | ClassNotFoundException i) {
            System.err.println("Gagal memuat data langganan (atau file tidak ditemukan/korup): " + i.getMessage());
            return new ArrayList<>(); 
        }
    }
}