package com.project;

import javax.swing.*;
import java.awt.*;

public class AddBookPage extends JPanel {

    public AddBookPage(LibrarySystem library) {
        setLayout(null);
        setBounds(0, 0, 820, 540);
        setBackground(new Color(255, 255, 255));

        JLabel heading = new JLabel("Add a New Book");
        heading.setFont(new Font("SansSerif", Font.BOLD, 30));
        heading.setForeground(new Color(27, 94, 32));
        heading.setBounds(290, 11, 300, 40);
        add(heading);

        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(250, 90, 120, 25);
        titleLabel.setForeground(new Color(27, 94, 32));
        add(titleLabel);

        JTextField titleField = new JTextField();
        titleField.setBounds(380, 90, 250, 30);
        add(titleField);

        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(250, 140, 120, 25);
        authorLabel.setForeground(new Color(27, 94, 32));
        add(authorLabel);

        JTextField authorField = new JTextField();
        authorField.setBounds(380, 140, 250, 30);
        add(authorField);

        JLabel genreLabel = new JLabel("Genre:");
        genreLabel.setBounds(250, 190, 120, 25);
        genreLabel.setForeground(new Color(27, 94, 32));
        add(genreLabel);

        JTextField genreField = new JTextField();
        genreField.setBounds(380, 190, 250, 30);
        add(genreField);

        JLabel rentLabel = new JLabel("Rent:");
        rentLabel.setBounds(250, 240, 120, 25);
        rentLabel.setForeground(new Color(27, 94, 32));
        add(rentLabel);

        JTextField rentField = new JTextField();
        rentField.setBounds(380, 240, 250, 30);
        add(rentField);

        JButton addBtn = new JButton("Add Book");
        addBtn.setBounds(380, 300, 160, 35);
        addBtn.setBackground(new Color(76, 175, 80));
        addBtn.setForeground(Color.WHITE);
        add(addBtn);

        addBtn.addActionListener(e -> {
            try {
                String title = titleField.getText().trim();
                String author = authorField.getText().trim();
                String genre = genreField.getText().trim();
                String rentText = rentField.getText().trim();

                if (title.isEmpty()) throw new Exception("Title field is empty.");
                if (author.isEmpty()) throw new Exception("Author field is empty.");
                if (genre.isEmpty()) throw new Exception("Genre field is empty.");
                if (rentText.isEmpty()) throw new Exception("Rent field is empty.");

                double rent = Double.parseDouble(rentText);

                Book newBook = new Book(title, author, genre, rent);
                library.addBook(newBook);
                JOptionPane.showMessageDialog(null, "Book added successfully!");

                titleField.setText("");
                authorField.setText("");
                genreField.setText("");
                rentField.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric rent.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });
    }
}
