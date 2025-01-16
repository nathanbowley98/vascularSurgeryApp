package com.example.vascularsurgeryproject.rotationsEssentials;

import android.media.Image;

public class Article {
    private final String title;
    private final String link;
//    private final Image img;

//    public Article(String title, String link, Image img) {
    public Article(String title, String link) {
        this.title = title;
        this.link = link;
//        this.img = img;
    }

    public String getTitle() {
        return this.title;
    }

    public String getLink() {
        return this.link;
    }

//    public Image getImg() {
//        return this.img;
//    }
}
