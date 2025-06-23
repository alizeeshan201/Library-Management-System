package com.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LibrarySystem {
    private List<Book> books = new ArrayList<>();
    private List<BorrowRecord> records = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getAvailableBooks() {
        List<Book> available = new ArrayList<>();
        for (Book b : books) {
            if (!b.isBorrowed()) {
                available.add(b);
            }
        }
        return available;
    }

    public Book searchBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    public boolean borrowBook(String title, String customerName, String contact) {
        Book b = searchBook(title);
        if (b != null && !b.isBorrowed()) {
            b.setBorrowed(true);
            records.add(new BorrowRecord(customerName, contact, title, new Date()));
            return true;
        }
        return false;
    }

    public boolean returnBook(String title, String customerName) {
        Book b = searchBook(title);
        if (b != null && b.isBorrowed()) {
            b.setBorrowed(false);
            return true;
        }
        return false;
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public List<BorrowRecord> getAllRecords() {
        return records;
    }
}
