package com.project;

public class Book {
    private String title, author, genre;
    private boolean isBorrowed;
    private double rent;

    public Book(String title, String author, String genre, double rent) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rent = rent;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public double getRent() {
        return rent;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.isBorrowed = borrowed;
    }

    @Override
    public String toString() {
        return title + " by " + author + " [" + genre + "] - Rent: PKR." + rent + (isBorrowed ? " (Borrowed)" : "");
    }
}
