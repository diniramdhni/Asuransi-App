package com.company;

public class helper {
    //method convert enum to string

//    private StatusKK statusKK;
//    private JenisKelamin jenisKelamin;
//
//    public void setStatusKK (StatusKK statusKK){
//        this.statusKK = statusKK;
//    }
//    public void setJenisKelamin(JenisKelamin jenisKelamin){
//        this.jenisKelamin = jenisKelamin;
//    }
//    public StatusKK getStatusKK(){
//        return this.statusKK;
//    }
//    public JenisKelamin getJenisKelamin(){
//        return this.jenisKelamin;
//    }

    public static String enumtostring(JenisKelamin jenisKelamin){
        String convert;
        convert = JenisKelamin.values().toString();
        return convert;
    }

    public static String enumtostring(StatusKK statusKK){
        String convert;
        convert = StatusKK.values().toString();
        return convert;
    }
}
