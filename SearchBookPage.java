package com.project;

import javax.swing.*;
import java.awt.*;

public class SearchBookPage extends JPanel {

    public SearchBookPage(LibrarySystem library) {
        setLayout(null);
        setBounds(0, 0, 820, 540);
        setBackground(new Color(255, 255, 255));

        JLabel heading = new JLabel("Search a Book");
        heading.setFont(new Font("SansSerif", Font.BOLD, 30));
        heading.setForeground(new Color(27, 94, 32));
        heading.setBounds(290, 11, 300, 40);
        add(heading);

        JLabel searchLabel = new JLabel("Enter Book Title:");
        searchLabel.setBounds(280, 100, 150, 25);
        searchLabel.setForeground(new Color(27, 94, 32));
        add(searchLabel);

        JTextField searchField = new JTextField();
        searchField.setBounds(430, 100, 200, 30);
        add(searchField);

        JButton searchBtn = new JButton("Search");
        searchBtn.setBounds(430, 150, 100, 30);
        searchBtn.setBackground(new Color(76, 175, 80));
        searchBtn.setForeground(Color.WHITE);
        add(searchBtn);

        searchBtn.addActionListener(e -> {
            String title = searchField.getText();
            if (!title.isEmpty()) {
                Book book = library.searchBook(title);
                if (book != null) {
                    if (!book.isBorrowed()) {
                        JOptionPane.showMessageDialog(null, book.toString(), "Book Found", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Book is currently borrowed.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Book not found.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a book title.");
            }
        });
    }
}
