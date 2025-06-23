package com.mycompany.pelacak.langganan.digital.ui; 

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class RegisterTheme {

    public static final Color COLOR_BACKGROUND = new Color(15, 15, 20);
    public static final Color COLOR_TEXT_FIELD_BACKGROUND = new Color(40, 40, 45);
    public static final Color COLOR_FOREGROUND = Color.WHITE; 
    public static final Color COLOR_LABEL_FOREGROUND = Color.WHITE;
    public static final Color COLOR_PLACEHOLDER = new Color(140, 140, 140);
    public static final Color COLOR_BUTTON_PRIMARY_BG = new Color(0, 123, 255);
    public static final Color COLOR_BUTTON_TEXT = Color.WHITE;
    public static final Color COLOR_BORDER_TEXT_FIELD = new Color(70,70,75);
    public static final Color COLOR_LINK = new Color(100, 150, 255);

    public static void styleDialogBackground(JDialog dialog) {
        dialog.getContentPane().setBackground(COLOR_BACKGROUND);
    }
    
    public static void styleFrameBackground(JFrame frame) {
        frame.getContentPane().setBackground(COLOR_BACKGROUND);
    }

    public static void styleLabelColor(JLabel label) {
        label.setForeground(COLOR_LABEL_FOREGROUND);
    }
    
    public static void styleLabelColor(JLabel label, Color foregroundColor) { 
        label.setForeground(foregroundColor);
    }

    public static void styleLinkLabelColor(JLabel labelLink) {
        labelLink.setForeground(COLOR_LINK);
        labelLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public static void styleTextField(JTextField textField) {
        textField.setBackground(COLOR_TEXT_FIELD_BACKGROUND);
        textField.setForeground(COLOR_FOREGROUND); 
        textField.setCaretColor(COLOR_FOREGROUND);
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDER_TEXT_FIELD),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        
        textField.setOpaque(true); 
    }

    public static void stylePasswordField(JPasswordField passwordField) {
        passwordField.setBackground(COLOR_TEXT_FIELD_BACKGROUND);
        passwordField.setForeground(COLOR_FOREGROUND); 
        passwordField.setCaretColor(COLOR_FOREGROUND);
        passwordField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_BORDER_TEXT_FIELD),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        passwordField.setOpaque(true);
    }

    public static void styleButton(JButton button) {
        button.setBackground(COLOR_BUTTON_PRIMARY_BG);
        button.setForeground(COLOR_BUTTON_TEXT);
        button.setOpaque(true);
        button.setBorderPainted(false); 
        button.setFocusPainted(false);
    }

    public static void addPlaceholder(JTextField textField, String placeholderText) {
        if (textField.getText().isEmpty() || textField.getText().equals(placeholderText)) {
            textField.setText(placeholderText);
            textField.setForeground(COLOR_PLACEHOLDER);
        } else {
            textField.setForeground(COLOR_FOREGROUND);
        }
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getForeground().equals(COLOR_PLACEHOLDER)) { 
                    textField.setText("");
                    textField.setForeground(COLOR_FOREGROUND);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholderText);
                    textField.setForeground(COLOR_PLACEHOLDER);
                }
            }
        });
    }

    public static void addPlaceholder(JPasswordField passwordField, String placeholderText) {
        char defaultEchoChar = passwordField.getEchoChar();
        Runnable setPlaceholder = () -> {
            passwordField.setEchoChar((char) 0);
            passwordField.setText(placeholderText);
            passwordField.setForeground(COLOR_PLACEHOLDER);
        };
        Runnable clearPlaceholder = () -> {
            passwordField.setText("");
            passwordField.setEchoChar(defaultEchoChar);
            passwordField.setForeground(COLOR_FOREGROUND);
        };
        String currentPassword = new String(passwordField.getPassword());
        if (currentPassword.isEmpty() || (passwordField.getEchoChar() == (char)0 && currentPassword.equals(placeholderText))) {
            setPlaceholder.run();
        } else {
            passwordField.setEchoChar(defaultEchoChar);
            passwordField.setForeground(COLOR_FOREGROUND);
        }
        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passwordField.getForeground().equals(COLOR_PLACEHOLDER) && passwordField.getEchoChar() == (char)0) {
                    clearPlaceholder.run();
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getPassword().length == 0) {
                    setPlaceholder.run();
                }
            }
        });
    }
}