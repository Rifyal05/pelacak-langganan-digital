# Aplikasi Pelacak Langganan Digital (Subscription Tracker)

> **STATUS PROYEK:** 🟢 **INISIASI SELESAI** - Struktur proyek telah dibuat

---

## 📜 Ringkasan

**Pelacak Langganan Digital** adalah sebuah aplikasi desktop yang dirancang untuk membantu pengguna mengelola semua langganan digital mereka (seperti Netflix, Spotify, Adobe, dll.) di satu tempat yang aman dan terorganisir.

## 🛠️ Teknologi & Implementasi Komponen Wajib

Proyek ini dibangun menggunakan **Java** dengan **Apache Maven** dan akan mengimplementasikan komponen-komponen wajib sebagai berikut:

*   **Database:** Relasional (**MySQL**) untuk menyimpan data langganan secara terstruktur.
*   **Generics:** Digunakan pada struktur data seperti `ArrayList<Subscription>` untuk memastikan keamanan tipe data.
*   **Threading:** Diimplementasikan untuk **sistem notifikasi** atau **akses ke api kurs** yang berjalan di latar belakang tanpa mengganggu antarmuka utama.
*   **Serialisasi:** Digunakan pada fitur **ekspor/impor (backup)** data langganan ke dalam sebuah file biner.
*   **Internasionalisasi:** Mendukung minimal dua bahasa (Indonesia & Inggris) untuk seluruh teks antarmuka, format tanggal, dan format mata uang.
*   **Kriptografi:** Diterapkan untuk **mengenkripsi** data sensitif di dalam database menggunakan algoritma AES.

### Nilai Tambah (KEMUNGKINAN)
*   **Network:** Koneksi ke API publik untuk konversi kurs mata uang secara real-time.
*   **Multimedia:** Memungkinkan pengguna menambahkan gambar logo untuk setiap layanan langganan.

---
