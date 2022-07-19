package com.company;

import java.time.LocalDate;

public class Prospect {
    private int noProspect;
    private String namaDepan;
    private String namaBelakang;
    private LocalDate tglLahir;
    private String tempatLahir;
    private JenisKelamin jenisKelamin;
    private String pekerjaan;
    private String status;

    public Prospect(){}
    public Prospect(int noProspect, String namaDepan, String namaBelakang, LocalDate tglLahir,  String tempatLahir, JenisKelamin jenisKelamin,
                    String pekerjaan,  String status){
        this.noProspect = noProspect;
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.tglLahir = tglLahir;
        this.tempatLahir = tempatLahir;
        this.jenisKelamin = jenisKelamin;
        this.pekerjaan = pekerjaan;
        this.status = status;
    }

    public void setNoProspect(int noProspect){
        this.noProspect = noProspect;
    }
    public void setNamaDepan(String namaDepan){
        this.namaDepan = namaDepan;
    }
    public void setNamaBelakang(String namaBelakang){
        this.namaBelakang = namaBelakang;
    }
    public void setTglLahir(LocalDate tglLahir){
        this.tglLahir = tglLahir;
    }
    public void setTempatLahir(String tempatLahir){
        this.tempatLahir = tempatLahir;
    }
    public void setJenisKelamin(JenisKelamin jenisKelamin){
        this.jenisKelamin = jenisKelamin;
    }
    public void setPekerjaan(String pekerjaan){
        this.pekerjaan= pekerjaan;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public int getNoProspect(){
        return this.noProspect;
    }
    public String getNamaDepan(){
        return this.namaDepan;
    }
    public String getNamaBelakang(){
        return this.namaBelakang;
    }
    public LocalDate getTglLahir(){
        return this.tglLahir;
    }
    public String getTempatLahir(){
        return this.tempatLahir;
    }
    public JenisKelamin getJenisKelamin(){
        return this.jenisKelamin;
    }
    public String getPekerjaan(){
        return this.pekerjaan;
    }
    public String getStatus(){
        return this.status;
    }


    public void summaryprospect(){
        System.out.println(String.format("No: %d, %s, %s, %s (%s), %s, %s", this.noProspect,
                this.namaDepan.concat(" ").concat(this.namaBelakang),
                helper.enumtostring(this.jenisKelamin), Main.formatTgl(this.tglLahir), this.tempatLahir, this.pekerjaan, this.status ));
    }
}
