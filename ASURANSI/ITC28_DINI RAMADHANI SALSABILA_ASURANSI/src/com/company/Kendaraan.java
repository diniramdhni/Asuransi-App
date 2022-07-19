package com.company;

public class Kendaraan {
    private String jenisKendaraan;
    private String nomorPolisi;
    private int nomorStnk;
    private String merkKendaraan;
    private String modelKendaraan;
    private String warnaKendaraan;

    public Kendaraan(){}
    public Kendaraan(String jenisKendaraan, String nomorPolisi, int nomorStnk, String merkKendaraan,
                     String modelKendaraan, String warnaKendaraan){
        this.jenisKendaraan =jenisKendaraan;
        this.nomorPolisi = nomorPolisi;
        this.nomorStnk = nomorStnk;
        this.merkKendaraan = merkKendaraan;
        this.modelKendaraan = modelKendaraan;
        this.warnaKendaraan = warnaKendaraan;
    }

    public void setJenisKendaraan(String jenisKendaraan){
        this.jenisKendaraan = jenisKendaraan;
    }
    public void setNomorPolisi(String nomorPolisi){
        this.nomorPolisi = nomorPolisi;
    }
    public void setNomorStnk(int nomorStnk){
        this.nomorStnk = nomorStnk;
    }
    public void setMerkKendaraan(String merkKendaraan){
        this.merkKendaraan = merkKendaraan;
    }
    public void setModelKendaraan(String modelKendaraan){
        this.modelKendaraan = modelKendaraan;
    }
    public void setWarnaKendaraan(String warnaKendaraan){
        this.warnaKendaraan = warnaKendaraan;
    }

    public String getJenisKendaraan(){
        return this.jenisKendaraan;
    }
    public String getNomorPolisi(){
        return this.nomorPolisi;
    }
    public int getNomorStnk(){
        return this.nomorStnk;
    }
    public String getMerkKendaraan(){
        return this.merkKendaraan;
    }
    public String getModelKendaraan(){
        return  this.modelKendaraan;
    }
    public String getWarnaKendaraan(){
        return  this.warnaKendaraan;
    }

}
