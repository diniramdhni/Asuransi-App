package com.company;

public enum StatusKK {
    KRT("KRT", "Kepala Rumah Tangga"),
    ISTRI("I", "Istri"),
    ANAK("A", "Anak");

    private String labelLengkap;
    private String labelInisial;

    StatusKK(String labelInisial, String labelLengkap){
        this.labelInisial = labelInisial;
        this.labelLengkap = labelLengkap;
    }

    public String getLabelInisial(){
        return  labelInisial;
    }
    public String getLabelLengkap(){
        return  labelLengkap;
    }
}
