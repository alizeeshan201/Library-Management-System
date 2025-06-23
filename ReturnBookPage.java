package com.project;

import javax.swing.*;
import java.awt.*;

public class ReturnBookPage extends JPanel {

    public ReturnBookPage(LibrarySystem library) {
        setLayout(null);
        setBounds(0, 0, 820, 540);
        setBackground(new Color(255, 255, 255));

        JLabel heading = new JLabel("Return a Book");
        heading.setFont(new Font("SansSerif", Font.BOLD, 30));
        heading.setForeground(new Color(27, 94, 32));
        heading.setBounds(290, 11, 300, 40);
        add(heading);

        JLabel nameLabel = new JLabel("Your Name:");
        nameLabel.setBounds(250, 100, 120, 25);
        nameLabel.setForeground(new Color(27, 94, 32));
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(380, 100, 250, 30);
        add(nameField);

        JLabel bookLabel = new JLabel("Book Title:");
        bookLabel.setBounds(250, 150, 120, 25);
        bookLabel.setForeground(new Color(27, 94, 32));
        add(bookLabel);

        JTextField bookField = new JTextField();
        bookField.setBounds(380, 150, 250, 30);
        add(bookField);

        JButton returnBtn = new JButton("Return Book");
        returnBtn.setBounds(380, 210, 150, 35);
        returnBtn.setBackground(new Color(76, 175, 80));
        returnBtn.setForeground(Color.WHITE);
        add(returnBtn);

        returnBtn.addActionListener(e -> {
            String name = nameField.getText();
            String title = bookField.getText();

            if (library.returnBook(title, name)) {
                JOptionPane.showMessageDialog(null, "Book returned successfully.");
                nameField.setText("");
                bookField.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Book not found or not borrowed.");
            }
        });
    }
}
