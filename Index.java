package com.project;

import javax.swing.*;
import java.awt.*;

public class Index extends JFrame {
    private JPanel mainPanel;
    private LibrarySystem library;

    public Index() {
        library = new LibrarySystem();
        setTitle("Library Management System - (0163+0180+0196)");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        Color primaryGreen = new Color(56, 142, 60);
        Color buttonGreen = new Color(76, 175, 80);
        Color topbarMint = new Color(232, 245, 233);
        Color textDarkGreen = new Color(27, 94, 32);

        JPanel sidebar = new JPanel();
        sidebar.setLayout(null);
        sidebar.setBackground(primaryGreen);
        sidebar.setBounds(0, 60, 180, 540);

        String[] buttons = {"Add Book", "Available Books", "Borrow Book", "Return Book", "Search Book"};
        for (int i = 0; i < buttons.length; i++) {
            JButton btn = new JButton(buttons[i]);
            btn.setBounds(10, 20 + i * 50, 160, 40);
            btn.setForeground(Color.WHITE);
            btn.setBackground(buttonGreen);
            btn.setFocusPainted(false);
            btn.addActionListener(e -> navigate(e.getActionCommand()));
            sidebar.add(btn);
        }

        JPanel topbar = new JPanel(null);
        topbar.setBackground(topbarMint);
        topbar.setBounds(0, 0, 1000, 60);

        JLabel logo = new JLabel("LHR LIBRARY SYSTEM");
        logo.setFont(new Font("Serif", Font.BOLD, 24));
        logo.setForeground(textDarkGreen);
        logo.setBounds(20, 10, 400, 40);
        topbar.add(logo);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBounds(180, 60, 806, 540);

        JLabel welcome = new JLabel("Welcome to our LHR Library!");
        welcome.setFont(new Font("SansSerif", Font.BOLD, 40));
        welcome.setForeground(primaryGreen);
        welcome.setBounds(135, 37, 571, 40);
        mainPanel.add(welcome);

        JLabel subheading1 = new JLabel("Fuel your curiosity with books, ideas, and endless possibilities.");
        subheading1.setFont(new Font("SansSerif", Font.PLAIN, 16));
        subheading1.setForeground(textDarkGreen);
        subheading1.setBounds(184, 100, 457, 30);
        mainPanel.add(subheading1);

        JLabel subheading2 = new JLabel("Discover knowledge from fiction to facts, all in one place.");
        subheading2.setFont(new Font("SansSerif", Font.PLAIN, 16));
        subheading2.setForeground(textDarkGreen);
        subheading2.setBounds(200, 135, 405, 30);
        mainPanel.add(subheading2);

        JLabel subheading3 = new JLabel("Unlock your potential!");
        subheading3.setFont(new Font("SansSerif", Font.PLAIN, 16));
        subheading3.setForeground(textDarkGreen);
        subheading3.setBounds(314, 170, 157, 30);
        mainPanel.add(subheading3);

        getContentPane().add(sidebar);
        getContentPane().add(topbar);
        getContentPane().add(mainPanel);
    }

    private void navigate(String page) {
        mainPanel.removeAll();
        switch (page) {
            case "Add Book" -> mainPanel.add(new AddBookPage(library));
            case "Available Books" -> mainPanel.add(new AvailableBooksPage(library));
            case "Borrow Book" -> mainPanel.add(new BorrowBookPage(library));
            case "Return Book" -> mainPanel.add(new ReturnBookPage(library));
            case "Search Book" -> mainPanel.add(new SearchBookPage(library));
        }
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Index frame = new Index();
            frame.setVisible(true);
        });
    }
}
