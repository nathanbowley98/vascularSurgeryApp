package com.example.vascularsurgeryproject.rotationsEssentials;

import android.media.Image;

public class Article {
    private final String title;
    private final String url;
//    private final Image img;

//    public Article(String title, String link, Image img) {
    public Article(String title, String url) {
        this.title = title;
        this.url = url;
//        this.img = img;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

//    public Image getImg() {
//        return this.img;
//    }
}
