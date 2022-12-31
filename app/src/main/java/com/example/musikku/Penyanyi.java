package com.example.musikku;

public class Penyanyi {
    String nama, asal;
    private int id_gambar;
    public Penyanyi(String nama, String asal, int id_gambar){
        this.nama = nama;
        this.asal = asal;
        this.id_gambar = id_gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String nama) {
        this.asal = asal;
    }

    public int getId_gambar() {
        return id_gambar;
    }

    public void setId_gambar(int id_gambar) {
        this.id_gambar = id_gambar;
    }

}
