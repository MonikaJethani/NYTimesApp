package com.example.nytimesapp.model;

public class Article {

    private String title;

    private String datePublished;

    public Article(String title, String datePublished) {
        this.title = title;
        this.datePublished = datePublished;
    }

    public String getTitle() {
        return title;
    }

    public String getDatePublished() {
        return datePublished;
    }
}
