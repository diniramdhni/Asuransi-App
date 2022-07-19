package com.company;

import java.time.LocalDate;

public class Polis {
    private Nasabah nasabah;
    private Produk produk;
    private Kendaraan kendaraan;
    private LocalDate startday;
    private String noTertanggung;

    public Polis(){}
    public Polis(Nasabah nasabah, Produk produk, Kendaraan kendaraan,  LocalDate startday, String noTertanggung){
        this.nasabah =nasabah;
        this.produk = produk;
        this.kendaraan = kendaraan;
        this.startday = startday;
        this.noTertanggung = noTertanggung;
    }

    public void setNasabah(Nasabah nasabah){
        this.nasabah = nasabah;
    }
    public void setProduk(Produk produk){
        this.produk = produk;
    }
    public void setKendaraan(Kendaraan kendaraan){
        this.kendaraan = kendaraan;
    }
    public void setStartday(LocalDate startday){
        this.startday = startday;
    }
    public void setNoTertanggung(String noTertanggung){
        this.noTertanggung = noTertanggung;
    }

    public Nasabah getNasabah(){
        return this.nasabah;
    }
    public Produk getProduk(){
        return this.produk;
    }
    public Kendaraan getKendaraan(){
        return this.kendaraan;
    }
    public LocalDate getStartday(){
        return this.startday;
    }
    public String getNoTertanggung(){
        return this.noTertanggung;
    }

    public void tagihan(){
        if(this.getProduk().getFrekuensiBayar().equalsIgnoreCase("Bulanan")) {
            LocalDate tgl = this.getStartday();
            for (int i = 1; i <= 3; i++) {
                System.out.println(Main.formatTgl(tgl) + ", " + Main.formatduit(this.getProduk().getIuran()));
                tgl = tgl.plusMonths(1);
            }
        }
        else {
            LocalDate tgl = this.getStartday();
            for (int i = 1; i <= 3; i++) {
                System.out.println(Main.formatTgl(tgl) + ", " + Main.formatduit(this.getProduk().getIuran()));
                tgl = tgl.plusYears(1);
            }
        }
    }
}
