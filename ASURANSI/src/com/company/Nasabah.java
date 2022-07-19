package com.company;

import java.time.LocalDate;

public class Nasabah {
    private String noNasabah;
    private Long noKtp;
    private StatusKK statusKk;
    private String payMethod;
    private Prospect prospect;

    public Nasabah(){}

    public Nasabah(String noNasabah, Long noKtp, StatusKK statusKk, String payMethod, Prospect prospect){
        this.noNasabah = noNasabah;
        this.noKtp = noKtp;
        this.statusKk = statusKk;
        this.payMethod = payMethod;
        this.prospect = prospect;
    }


    public void setNoNasabah(String noNasabah){
        this.noNasabah = noNasabah;
    }
    public void setNoKtp(Long noKtp){
        this.noKtp = noKtp;
    }
    public void setStatusKk(StatusKK statusKk){
        this.statusKk = statusKk;
    }
    public void setPayMethod(String payMethod){
        this.payMethod = payMethod;
    }
    public void setProspect(Prospect prospect){
        this.prospect = prospect;
    }

    public String getNoNasabah(){
        return this.noNasabah;
    }
    public Long getNoKtp(){
        return  this.noKtp;
    }
    public StatusKK getStatusKk(){
        return this.statusKk;
    }
    public String getPayMethod(){
        return this.payMethod;
    }
    public Prospect getProspect(){
        return this.prospect;
    }

    public void summarynasabah(){
        System.out.println(String.format("No: %s, %s, %s, %s (%s), %s\n KTP: %d, Status di KK: %s, Payment Method: %s",
                this.noNasabah, this.prospect.getNamaDepan().concat(" ").concat(this.prospect.getNamaBelakang()),
                this.prospect.getJenisKelamin().getLabelLengkap(), Main.formatTgl(this.prospect.getTglLahir()),
                this.prospect.getTempatLahir(), this.prospect.getPekerjaan(), this.noKtp, helper.enumtostring(this.statusKk),
                this.payMethod));
    }
}
