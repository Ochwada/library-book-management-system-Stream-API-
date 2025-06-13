package com.library_book_management_system;


/**
 * *******************************************************
 * Package: com.library_book_management_system
 * File: Book.java
 * Author: Ochwada
 * Date: Friday, 13.Jun.2025, 2:11 PM
 * Description: Represents a Book in a Library Book Management System (domain modelling)
 * Objective:
 * *******************************************************
 */


public class Books {

    // Fields or Variables
    private final String title;
    private final String author;
    private final String genre;
    private final double price;
    private final int copies;
    private final boolean digital;

    public Books(String title, String author, String genre, double price, int copies, boolean digital) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.copies = copies;
        this.digital = digital;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    public int getCopies() {
        return copies;
    }

    public boolean isDigital() {
        return digital;
    }

    // to string
    @Override
    public String toString() {
        return
                "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Genre: " + genre + "\n"+
                "Price: " + price + "\n"+
                "Copies: " + copies + "\n"+
                "Digital: " + digital +"\n" ;
    }
}
