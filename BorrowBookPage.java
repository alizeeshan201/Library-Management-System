package com.project;

import javax.swing.*;
import java.awt.*;

public class BorrowBookPage extends JPanel {

    public BorrowBookPage(LibrarySystem library) {
        setLayout(null);
        setBounds(0, 0, 820, 540);
        setBackground(new Color(255, 255, 255));

        JLabel heading = new JLabel("Borrow a Book");
        heading.setFont(new Font("SansSerif", Font.BOLD, 30));
        heading.setForeground(new Color(27, 94, 32));
        heading.setBounds(290, 11, 300, 40);
        add(heading);

        JLabel nameLabel = new JLabel("Your Name:");
        nameLabel.setBounds(250, 90, 120, 25);
        nameLabel.setForeground(new Color(27, 94, 32));
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(380, 90, 250, 30);
        add(nameField);

        JLabel contactLabel = new JLabel("Contact Number:");
        contactLabel.setBounds(250, 140, 120, 25);
        contactLabel.setForeground(new Color(27, 94, 32));
        add(contactLabel);

        JTextField contactField = new JTextField();
        contactField.setBounds(380, 140, 250, 30);
        add(contactField);

        JLabel bookLabel = new JLabel("Book Title:");
        bookLabel.setBounds(250, 190, 120, 25);
        bookLabel.setForeground(new Color(27, 94, 32));
        add(bookLabel);

        JTextField bookField = new JTextField();
        bookField.setBounds(380, 190, 250, 30);
        add(bookField);

        JButton borrowBtn = new JButton("Borrow Book");
        borrowBtn.setBounds(380, 250, 160, 35);
        borrowBtn.setBackground(new Color(76, 175, 80));
        borrowBtn.setForeground(Color.WHITE);
        add(borrowBtn);

        borrowBtn.addActionListener(e -> {
            String name = nameField.getText();
            String contact = contactField.getText();
            String title = bookField.getText();
            Book book = library.searchBook(title);

            if (book != null && !book.isBorrowed()) {
                if (!name.isEmpty() && !contact.isEmpty()) {
                    library.borrowBook(title, name, contact);
                    JOptionPane.showMessageDialog(null, "Book borrowed! Rent: PKR." + book.getRent());
                    nameField.setText("");
                    contactField.setText("");
                    bookField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Book not available or already borrowed.");
            }
        });
    }
}
