package com.company;

public enum JenisKelamin {
    PRIA("L", "Laki-laki"),
    WANITA("P", "Perempuan");

    private String labelLengkap;
    private String labelInisial;

    JenisKelamin(String labelInisial, String labelLengkap){
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
