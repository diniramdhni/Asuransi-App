package com.company;

import java.math.BigDecimal;

public class Produk {
    private String namaProduk;
    private String jenisProduk;
    private String frekuensiBayar;
    private BigDecimal iuran;
    private String manfaat;

    public Produk(){}
    public Produk(String namaProduk, String jenisProduk, String frekuensiBayar,
                  String manfaat){
        this.namaProduk = namaProduk;
        this.jenisProduk = jenisProduk;
        this.frekuensiBayar = frekuensiBayar;
        this.manfaat = manfaat;
    }


    public void setNamaProduk(String namaProduk){
        this.namaProduk = namaProduk;
    }
    public void setJenisProduk(String jenisProduk){
        this.jenisProduk = jenisProduk;
    }
    public void setFrekuensiBayar(String frekuensiBayar){
        this.frekuensiBayar = frekuensiBayar;
    }
    public void setIuran(BigDecimal iuran){
        this.iuran = iuran;
    }
    public void setManfaat(String manfaat){
        this.manfaat = manfaat;
    }

    public String getNamaProduk(){
        return this.namaProduk;
    }
    public String getJenisProduk(){
        return this.jenisProduk;
    }
    public String getFrekuensiBayar(){
        return this.frekuensiBayar;
    }
    public BigDecimal getIuran(){
        return this.iuran;
    }
    public String getManfaat(){
        return this.manfaat;
    }
}
