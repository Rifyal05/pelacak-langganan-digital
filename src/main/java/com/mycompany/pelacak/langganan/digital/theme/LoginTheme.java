/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pelacak.langganan.digital.theme;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

/**
 *
 * @author rifial
 */
public class LoginTheme {

    public static final Color COLOR_BACKGROUND = new Color(15, 15, 20);
    public static final Color COLOR_TEXT_FIELD_BACKGROUND = new Color(40, 40, 45);
    public static final Color COLOR_FOREGROUND = Color.WHITE;
    public static final Color COLOR_PLACEHOLDER = new Color(140, 140, 140);
    public static final Color COLOR_BUTTON_TEXT = Color.WHITE;
    public static final Color COLOR_BORDER_TEXT_FIELD = new Color(70, 70, 75);

    public static void styleFrameBackground(JFrame frame) {
        frame.getContentPane().setBackground(COLOR_BACKGROUND);
    }

    public static void styleLabelColor(JLabel label, Color foregroundColor) {
        label.setForeground(foregroundColor);
    }

    public static void styleLinkLabelColor(JLabel labelLink, Color linkColor) {
        labelLink.setForeground(linkColor);
        labelLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public static void styleTextFieldColor(JTextField textField) {
        textField.setBackground(COLOR_TEXT_FIELD_BACKGROUND);
        textField.setForeground(COLOR_PLACEHOLDER);
        textField.setCaretColor(COLOR_FOREGROUND);
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(COLOR_BORDER_TEXT_FIELD),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
    }

    public static void stylePasswordFieldColor(JPasswordField passwordField) {
        passwordField.setBackground(COLOR_TEXT_FIELD_BACKGROUND);
        passwordField.setForeground(COLOR_PLACEHOLDER);
        passwordField.setCaretColor(COLOR_FOREGROUND);
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(COLOR_BORDER_TEXT_FIELD),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
    }

    public static void styleButtonColor(JButton button) {
        button.setForeground(COLOR_BUTTON_TEXT);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
    }

    public static void addPlaceholderLogic(JTextField textField, String placeholderText) {
        if (textField.getText().equals(placeholderText)) {
            textField.setForeground(COLOR_PLACEHOLDER);
        } else if (textField.getText().isEmpty()) {
            textField.setText(placeholderText);
            textField.setForeground(COLOR_PLACEHOLDER);
        } else {
            textField.setForeground(COLOR_FOREGROUND);
        }

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholderText)) {
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

    public static void addPasswordPlaceholderLogic(JPasswordField passwordField, String placeholderText) {
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
        if (currentPassword.isEmpty() || currentPassword.equals(placeholderText)) {
            setPlaceholder.run();
        } else {
            passwordField.setForeground(COLOR_FOREGROUND);
        }
        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (new String(passwordField.getPassword()).equals(placeholderText)) {
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

    public static void updatePlaceholder(JTextField component, String newPlaceholder) {
        for (FocusListener listener : component.getFocusListeners()) {
            component.removeFocusListener(listener);
        }
        component.setText(newPlaceholder);
        component.setForeground(COLOR_PLACEHOLDER);

        component.addFocusListener(new FocusAdapter() {
            private final String currentPlaceholder = newPlaceholder;

            @Override
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField) e.getSource();
                if (source.getText().equals(currentPlaceholder)) {
                    source.setText("");
                    source.setForeground(COLOR_FOREGROUND);
                }
                source.getCaret().setVisible(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                JTextField source = (JTextField) e.getSource();
                if (source.getText().isEmpty()) {
                    source.setForeground(COLOR_PLACEHOLDER);
                    source.setText(currentPlaceholder);
                }
                source.getCaret().setVisible(false);
            }
        });
    }
}
