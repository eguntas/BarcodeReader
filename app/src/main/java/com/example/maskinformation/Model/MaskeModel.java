package com.example.maskinformation.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MaskeModel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("kategori")
    @Expose
    private String kategori;
    @SerializedName("renk")
    @Expose
    private String renk;
    @SerializedName("dil")
    @Expose
    private String dil;
    @SerializedName("tip")
    @Expose
    private String tip;
    @SerializedName("boyut")
    @Expose
    private String boyut;
    @SerializedName("ambalaj")
    @Expose
    private String ambalaj;
    @SerializedName("kutu")
    @Expose
    private String kutu;
    @SerializedName("koli")
    @Expose
    private String koli;
    @SerializedName("barkod")
    @Expose
    private String barkod;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public String getDil() {
        return dil;
    }

    public void setDil(String dil) {
        this.dil = dil;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getBoyut() {
        return boyut;
    }

    public void setBoyut(String boyut) {
        this.boyut = boyut;
    }

    public String getAmbalaj() {
        return ambalaj;
    }

    public void setAmbalaj(String ambalaj) {
        this.ambalaj = ambalaj;
    }

    public String getKutu() {
        return kutu;
    }

    public void setKutu(String kutu) {
        this.kutu = kutu;
    }

    public String getKoli() {
        return koli;
    }

    public void setKoli(String koli) {
        this.koli = koli;
    }

    public String getBarkod() {
        return barkod;
    }

    public void setBarkod(String barkod) {
        this.barkod = barkod;
    }
}
