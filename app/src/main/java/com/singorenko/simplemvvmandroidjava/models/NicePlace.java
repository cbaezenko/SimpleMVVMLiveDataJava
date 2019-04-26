package com.singorenko.simplemvvmandroidjava.models;

public class NicePlace {
    private String title;
    private String imageUrl;

    public NicePlace(String imageUrl, String title) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public NicePlace() {
    }

    public String getTitle() { return title; }

    public String getImageUrl() { return imageUrl; }

    public void setTitle(String title) { this.title = title; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
