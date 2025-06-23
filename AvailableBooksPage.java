package com.project;

import javax.swing.*;
import java.awt.*;

public class AvailableBooksPage extends JPanel {

    public AvailableBooksPage(LibrarySystem library) {
        setLayout(null);
        setBounds(0, 0, 820, 540);
        setBackground(new Color(255, 255, 255));

        JLabel heading = new JLabel("Available Books");
        heading.setFont(new Font("SansSerif", Font.BOLD, 30));
        heading.setForeground(new Color(27, 94, 32));
        heading.setBounds(290, 11, 300, 40);
        add(heading);

        JTextArea bookArea = new JTextArea();
        bookArea.setBounds(150, 80, 542, 400);
        bookArea.setEditable(false);
        bookArea.setFont(new Font("Times New Roman", Font.BOLD, 14));
        bookArea.setBackground(new Color(255, 255, 255));

        for (Book b : library.getAvailableBooks()) {
            bookArea.append("● "+ b.toString() + "\n");
        }

        add(bookArea);
    }
}
