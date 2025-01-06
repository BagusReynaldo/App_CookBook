package com.projectbp3.appcookbook;

public class recyclerview_list2 {
    private int image;
    private String premis;
    private String title;
    private String timer;
    private int image2;
    private String bahan;
    private String langkah;

    public recyclerview_list2(int image, String premis, String title, String timer, int image2, String bahan, String langkah) {
        this.image = image;
        this.premis = premis;
        this.title = title;
        this.timer = timer;
        this.image2 = image2;
        this.bahan = bahan;
        this.langkah = langkah;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPremis() {
        return premis;
    }

    public void setPremis(String premis) {
        this.premis = premis;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {
        this.timer = timer;
    }

    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public String getBahan() {
        return bahan;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    public String getLangkah() {
        return langkah;
    }

    public void setLangkah(String langkah) {
        this.langkah = langkah;
    }

    public String getUniqueId() {
        return title; // atau kombinasi unik, misalnya title + premis
    }

}
