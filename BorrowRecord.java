package com.project;

import java.util.Date;

public class BorrowRecord {
    private String customerName;
    private String contact;
    private String bookTitle;
    private Date borrowTime;

    public BorrowRecord(String customerName, String contact, String bookTitle, Date borrowTime) {
        this.customerName = customerName;
        this.contact = contact;
        this.bookTitle = bookTitle;
        this.borrowTime = borrowTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getContact() {
        return contact;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }
}
