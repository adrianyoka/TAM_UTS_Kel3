package com.avenger.salamindonesia;

public class Provinsi {
    private int photo;
    private String name;
    private String description;
    private String suku;
    private String bahasa;
    private String kepala;
    private String ibukota;
    private String lat,lng;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getBahasa() {
        return bahasa;
    }

    public void setBahasa(String bahasa) {
        this.bahasa = bahasa;
    }

    public String getIbukota() {
        return ibukota;
    }

    public void setIbukota(String ibukota) {
        this.ibukota = ibukota;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSuku() { return suku; }

    public void setSuku(String suku) { this.suku = suku; }

    public String getKepala() { return kepala; }

    public void setKepala(String kepala) { this.kepala = kepala; }
}
