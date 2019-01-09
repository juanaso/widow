package com.challenge.juan.widow.Models;


public class Book {
    private String author;
    private String title;
    private String fotoUrl;

    public Book() {
    }

    public Book(String author, String title, String fotoUrl) {
        this.author = author;
        this.title = title;
        this.fotoUrl = fotoUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }
}
