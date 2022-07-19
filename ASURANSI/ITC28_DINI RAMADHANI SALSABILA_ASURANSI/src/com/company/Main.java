package com.company;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    static LinkedList<Kendaraan> allkendaraan = new LinkedList<>();
    static LinkedList<Prospect> allprospect = new LinkedList<>();
    static LinkedList<Nasabah> allnasabah = new LinkedList<>();
    static LinkedList<Produk> allproduk = new LinkedList<>();
    static LinkedList<Polis> allpolis = new LinkedList<>();

    static Prospect pros = new Prospect();
    static Nasabah nas = new Nasabah();
    static int noProspect = 1;

    public static void main(String[] args) {
	// write your code here
        inputData();
        Aplikasi.caseMenuUtama(MainMenu());
    }

    public static void inputData(){
        Produk sb = new Produk("Sehat Bersama", "Kesehatan", "Bulanan", "Claim perawatan kelas 1.");
        Produk se = new Produk("Sehat Extra", "Kesehatan", "Bulanan", "Claim perawatan kelas VIP");
        Produk lk = new Produk("Life Keluarga", "Jiwa", "Bulanan", "Mendapatkan 500.000.000 apabila terjadi sesuatu pada tertanggung");
        Produk ls = new Produk("Life Special ", "Jiwa ", "Tahunan", "Mendapatkan 800.000.000 apabila terjadi sesuatu pada tertanggung");
        Produk p = new Produk("Protection ", "Kendaraan", "Tahunan", "Mendapat ganti rugi sampai 100.000.000 bila terjadi sesuatu");
        Produk pp = new Produk("Protection Plus", "Kendaraan", "Tahunan", "Mendapat ganti rugi total lost apa bila terjadi sesuatu");
        p.setIuran(new BigDecimal(2000000));
        pp.setIuran(new BigDecimal(2500000));

        allproduk.add(sb);
        allproduk.add(se);
        allproduk.add(lk);
        allproduk.add(ls);
        allproduk.add(p);
        allproduk.add(pp);

    }

    public static String formatTgl(LocalDate tgl){
        Locale indo = new Locale("id", "ID");
        DateTimeFormatter indoformat = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy", indo);
        return indoformat.format(tgl);

    }
    public static int MainMenu(){
        System.out.println("""
                Pilih lah salah satu menu di bawah ini:
                1. Menu Prospect
                2. Menu Customer
                3. Exit Application
                Masukkan pilihan anda: """);
        int pilihan = 0;
        boolean cek = false;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                pilihan = Integer.parseInt(scanner.nextLine().trim());
                if (pilihan >= 1 && pilihan <= 3) {
                    cek = true;
                }
            } catch (Exception ex) {
                System.out.println("harus angka 1-4");
                cek = false;
            }
        }
        while (cek == false);
        return pilihan;

    }

    public static void printallprospect(){
        if (allprospect.size() > 0) {
            for (Prospect value : allprospect) {
                value.summaryprospect();
            }
        }
    }


    public static int MenuProspect(){
        printallprospect();
        System.out.println("""
                Pilih lah salah satu menu di bawah ini:
                1. Add Prospect
                2. Prospect To Customer
                3. Main Menu
                4. Exit Application
                                   
                Masukkan pilihan anda: """);
        int pilihan = 0;
        boolean cek = false;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                pilihan = Integer.parseInt(scanner.nextLine().trim());
                if (pilihan >= 1 && pilihan <= 4) {
                    cek = true;
                }
            } catch (Exception ex) {
                System.out.println("harus angka 1-4");
                cek = false;
            }
        }
        while (cek == false);
        return pilihan;

    }

    public static void addProspect(){
        String namaDepan, namaBelakang, tempatLahir, pekerjaan, tglLahir, jenisKelamin = " ";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukan data prospect satu-persatu: ");
        System.out.println("Nama Depan: ");
        namaDepan = scanner.nextLine().trim();
        System.out.println("Nama Belakang: ");
        namaBelakang = scanner.nextLine().trim();
        System.out.println("Tanggal Lahir (dd/MM/yyyy): ");
        tglLahir = scanner.nextLine().trim();
        LocalDate tanggalLahir = LocalDate.parse(tglLahir, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Tempat Lahir: ");
        tempatLahir = scanner.nextLine().trim();
        System.out.println("Jenis Kelamin (P/L): ");
        boolean cek = false;
        do {
            jenisKelamin = scanner.nextLine();
            if (jenisKelamin.equalsIgnoreCase("p") || jenisKelamin.equalsIgnoreCase("l")) {
                cek = true;
            } else {
                System.out.println("harus P atau L");
                cek = false;
            }
        }
        while(cek == false);
        System.out.println("Pekerjaan: ");
        pekerjaan = scanner.nextLine().trim();
        System.out.println("""
                … Menambahkan Prospect Baru
                (Kembali ke menu utama)""");

        pros = new Prospect();
        pros.setNoProspect(noProspect);
        pros.setNamaDepan(namaDepan);
        pros.setNamaBelakang(namaBelakang);
        pros.setTglLahir(tanggalLahir);
        pros.setTempatLahir(tempatLahir);
        if(jenisKelamin.equalsIgnoreCase("p")){
            pros.setJenisKelamin(JenisKelamin.WANITA);
        }
        else {
            pros.setJenisKelamin(JenisKelamin.PRIA);
        }
        pros.setPekerjaan(pekerjaan);
        pros.setStatus("Prospect");

        allprospect.add(pros);
        noProspect += 1;
    }

    public static void ProspectToCustomer(){
        printallprospect();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ketik nomor prospect yang ingin dijadikan nasabah : ");
        int inputprospect = Integer.parseInt(scanner.nextLine().trim());
        for (Prospect value : allprospect){
            if(value.getNoProspect() == inputprospect){
                value.setStatus("Nasabah");
                LocalDate tanggalskrg = LocalDate.now();
                DateTimeFormatter formattgl = DateTimeFormatter.ofPattern("MM/yyyy");
                String tglsudahformat = tanggalskrg.format(formattgl);
                System.out.print("Nomor KTP : ");
                long ktp = Long.parseLong(scanner.nextLine().trim());
                System.out.print("Status KK : ");
                String statuskk = scanner.nextLine().trim();
                System.out.print("Payment Method(CC/AC/VP) : ");
                String paymethod = " ";
                boolean cek = false;
                do {
                    paymethod = scanner.nextLine().toLowerCase(Locale.ROOT);
                    if (paymethod.equalsIgnoreCase("cc") || paymethod.equalsIgnoreCase("ac") ||
                            paymethod.equalsIgnoreCase("vp")) {
                        cek = true;
                    }
                    else {
                        System.out.println("harus CC atau AC atau VP!");
                        cek = false;
                    }
                }
                while (cek == false);
                nas = new Nasabah();
                nas.setProspect(value);
                nas.setNoNasabah(tglsudahformat+"/"+value.getNoProspect());
                nas.setNoKtp(ktp);
                nas.setStatusKk(statuskk);
                nas.setPayMethod(paymethod);
                allnasabah.add(nas);
                value.setStatus("Nasabah");
            }
        }
    }

    public static int MenuCustomer(){
        printallnasabah();
        System.out.println("""
                Pilih Menu yang ingin dipilih
                1. Buy Product
                2. Detail Policy
                3. Main Menu
                4. Exit Application
                Masukkan pilihan anda: """);
        int pilihan = 0;
        boolean cek = false;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                pilihan = Integer.parseInt(scanner.nextLine().trim());
                if (pilihan >= 1 && pilihan <= 4) {
                    cek = true;
                }
            } catch (Exception ex) {
                System.out.println("harus angka 1-4");
                cek = false;
            }
        }
        while (cek == false);
        return pilihan;

    }

    public static void printallnasabah(){
        if (allnasabah.size() > 0){
            for (Nasabah value : allnasabah){
                value.summarynasabah();
                System.out.println("============================================================================");
            }
        }
    }

    public static void  BuyProduct(){
        printallnasabah();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pilih Nomor Customer : ");
        String inputnocus = scanner.nextLine().trim();
        for(Nasabah value : allnasabah){
            if(inputnocus.equals(value.getNoNasabah())){
                System.out.print("Pilih Nama Product : ");
                String namaproduk =scanner.nextLine();
                if(namaproduk.equalsIgnoreCase("sehat bersama")){
                    System.out.print("Pilih Nomor Customer Tertanggung: ");
                    String noTertanggung = " ";
                    Polis polis = new Polis();
                    noTertanggung = scanner.nextLine().trim();
                    for(Nasabah nasabah : allnasabah) {
                        if (noTertanggung.equals(nasabah.getNoNasabah())) {
                            polis.setNoTertanggung(noTertanggung);
                        }
                    }
                    polis.setNasabah(value);
                    polis.setProduk(allproduk.get(0));
                    polis.setStartday(LocalDate.now());
                    System.out.println("Tanggal polis mulai dijalankan adalah hari ini");
                    allpolis.add(polis);
                    if(umur(value.getProspect().getTglLahir()) <= 20){
                        polis.getProduk().setIuran(new BigDecimal(200000));
                    }
                    else {
                        polis.getProduk().setIuran(new BigDecimal(400000));
                    }
                }
                else if(namaproduk.equalsIgnoreCase("sehat extra")){
                    Polis polis = new Polis();
                    polis.setNasabah(value);
                    polis.setProduk(allproduk.get(1));
                    polis.setNoTertanggung(value.getNoNasabah());
                    polis.setStartday(LocalDate.now());
                    System.out.println("Tanggal polis mulai dijalankan adalah hari ini");
                    allpolis.add(polis);
                    if(umur(value.getProspect().getTglLahir()) <= 20){
                        polis.getProduk().setIuran(new BigDecimal(300000));
                    }
                    else {
                        polis.getProduk().setIuran(new BigDecimal(500000));
                    }
                }
                else if(namaproduk.equalsIgnoreCase("life keluarga")){
                    System.out.print("Pilih Nomor Customer Tertanggung: ");
                    String noTertanggung = " ";
                    Polis polis = new Polis();
                    noTertanggung = scanner.nextLine().trim();
                    for(Nasabah nasabah : allnasabah) {
                        if (noTertanggung.equals(nasabah.getNoNasabah())) {
                            polis.setNoTertanggung(noTertanggung);
                        }
                    }
                    polis.setNasabah(value);
                    polis.setProduk(allproduk.get(2));
                    polis.setStartday(LocalDate.now());
                    System.out.println("Tanggal polis mulai dijalankan adalah hari ini");
                    allpolis.add(polis);
                    if(umur(value.getProspect().getTglLahir()) <= 20){
                        polis.getProduk().setIuran(new BigDecimal(250000));
                    }
                    else {
                        polis.getProduk().setIuran(new BigDecimal(450000));
                    }
                }
                else if(namaproduk.equalsIgnoreCase("life special")){
                    Polis polis = new Polis();
                    polis.setNasabah(value);
                    polis.setProduk(allproduk.get(3));
                    polis.setNoTertanggung(value.getNoNasabah());
                    polis.setStartday(LocalDate.now());
                    System.out.println("Tanggal polis mulai dijalankan adalah hari ini");
                    allpolis.add(polis);
                    if(umur(value.getProspect().getTglLahir()) <= 20){
                        polis.getProduk().setIuran(new BigDecimal(3600000));
                    }
                    else {
                        polis.getProduk().setIuran(new BigDecimal(4800000));
                    }
                }
                else if(namaproduk.equalsIgnoreCase("protection")){
                    Polis polis = new Polis();
                    polis.setNasabah(value);
                    polis.setKendaraan(kendaraan());
                    polis.setProduk(allproduk.get(4));
                    polis.setStartday(LocalDate.now());
                    System.out.println("Tanggal polis mulai dijalankan adalah hari ini");
                    allpolis.add(polis);
                }
                else if(namaproduk.equalsIgnoreCase("protection plus")){
                    Polis polis = new Polis();
                    polis.setNasabah(value);
                    polis.setKendaraan(kendaraan());
                    polis.setProduk(allproduk.get(5));
                    polis.setStartday(LocalDate.now());
                    System.out.println("Tanggal polis mulai dijalankan adalah hari ini");
                    allpolis.add(polis);
                }
                else {
                    System.out.println("Produk tidak ditemukan! ");
                }
            }
        }

    }

    public static Kendaraan kendaraan(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input data kendaraan");
        System.out.print("Jenis Kendaraan : ");
        String jenis = " ";
        boolean cek = false;
        do {
            jenis = scanner.nextLine().toLowerCase(Locale.ROOT);
            if (jenis.equalsIgnoreCase("mobil") || jenis.equalsIgnoreCase("motor")) {
                cek = true;
            }
            else {
                System.out.println("harus Mobil atau Motor!");
                cek = false;
            }
        }
        while (cek == false);
        System.out.print("Nomor Polisi : ");
        String nompol = scanner.nextLine();
        System.out.print("Nomor STNK : ");
        int noStnk = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Merek Kendaraan : ");
        String merek = scanner.nextLine();
        System.out.print("Model Kendaraan : ");
        String model = scanner.nextLine();
        System.out.print("Warna Kendaraan : ");
        String warna = scanner.nextLine();
        Kendaraan kendaraan = new Kendaraan();
        kendaraan.setJenisKendaraan(jenis);
        kendaraan.setMerkKendaraan(merek);
        kendaraan.setModelKendaraan(model);
        kendaraan.setNomorPolisi(nompol);
        kendaraan.setNomorStnk(noStnk);
        kendaraan.setWarnaKendaraan(warna);
        allkendaraan.add(kendaraan);

        return kendaraan;

    }

    public static void  DetailPolicy(){
        printallnasabah();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pilih Nomor Customer : ");
        String noCus = scanner.nextLine().trim();
        if (allpolis.size() > 0) {
            for(Polis polis : allpolis) {
                if (polis.getNasabah().getNoNasabah().equalsIgnoreCase(noCus)) {
                    System.out.println("===============================Customer Info==============================");
                    polis.getNasabah().summarynasabah();
                    System.out.println("============================================================================");

                    System.out.println("=================================Policy Info================================");
                    if(polis.getProduk().getJenisProduk() == "Kesehatan" || polis.getProduk().getJenisProduk() == "Jiwa") {
                        polisInfo(polis);
                    }
                    else {
                        polisinfokendaraam(polis);
                    }
                    System.out.println("============================================================================");
                    System.out.println("============================= PAYMENT =====================================");
                    polis.tagihan();
                }
            }
        }
    }

    public static void polisInfo(Polis polis){
        for(Nasabah nasabah : allnasabah){
            if(polis.getNoTertanggung().equals(nasabah.getNoNasabah())){
                System.out.println("Tertanggung: " + nasabah.getProspect().getNamaDepan().concat(" ").concat(nasabah.getProspect().getNamaBelakang()));
            }
        }
        System.out.println("Produk: " + polis.getProduk().getNamaProduk());
        System.out.println("Tanggal mulai dijalankan: " + formatTgl(polis.getStartday()));
        System.out.println("Manfaat: " + polis.getProduk().getManfaat());
    }

    public static void polisinfokendaraam(Polis polis){
        System.out.println("Product: " + polis.getProduk().getNamaProduk());
        System.out.println("Tanggal mulai dijalankan: " + formatTgl(polis.getStartday()));
        System.out.println("Jenis Kendaraan: " + polis.getKendaraan().getJenisKendaraan());
        System.out.println("Nomor Polisi: " + polis.getKendaraan().getNomorPolisi());
        System.out.println("Nomor Stnk: " + polis.getKendaraan().getNomorStnk());
        System.out.println("Model Kendaraan: " + polis.getKendaraan().getModelKendaraan());
        System.out.println("Warna Kendaraan: " + polis.getKendaraan().getWarnaKendaraan());

    }

    public static String formatduit(BigDecimal duit){
        Locale indo = new Locale("id", "ID");
        String rupiah = NumberFormat.getCurrencyInstance(indo).format(duit);
        return rupiah;
    }

    public static int umur(LocalDate tgl){
        Period periode = Period.between(tgl, LocalDate.now());
        return periode.getYears();
    }
}
