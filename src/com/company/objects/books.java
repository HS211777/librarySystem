package com.company.objects;

public class books {
    private String name;
    private int ISBN;
    private String author;
    private String genre;

    public books(String name, int ISBN, String author, String genre) {
        this.name = name;
        this.ISBN = ISBN;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toString(){
        return name + "," + ISBN + "," + author + "," + genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
