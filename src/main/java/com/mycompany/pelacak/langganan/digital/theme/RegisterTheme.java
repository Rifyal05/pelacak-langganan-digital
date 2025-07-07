package com.mycompany.pelacak.langganan.digital.theme;

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
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

public class RegisterTheme {

    public static final Color COLOR_BACKGROUND = new Color(15, 15, 20);
    public static final Color COLOR_TEXT_FIELD_BACKGROUND = new Color(40, 40, 45);
    public static final Color COLOR_FOREGROUND = Color.WHITE;
    public static final Color COLOR_LABEL_FOREGROUND = Color.WHITE;
    public static final Color COLOR_PLACEHOLDER = new Color(140, 140, 140);
    public static final Color COLOR_BUTTON_PRIMARY_BG = new Color(0,51,204);
    public static final Color COLOR_BUTTON_TEXT = Color.WHITE;
    public static final Color COLOR_BORDER_TEXT_FIELD = new Color(70, 70, 75);
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

    public static void styleComboBox(JComboBox sikluscombobox) {
        sikluscombobox.setBackground(COLOR_TEXT_FIELD_BACKGROUND);
    }

    public static void styleDateChooser(JDateChooser dateChooser) {
        JTextField dateEditor = (JTextField) dateChooser.getDateEditor().getUiComponent();
        dateEditor.setBackground(COLOR_TEXT_FIELD_BACKGROUND);
        dateEditor.setForeground(COLOR_FOREGROUND);
        dateEditor.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
        dateEditor.setBorder(new EmptyBorder(5, 10, 5, 10));
        dateEditor.setForeground(Color.WHITE);
        dateEditor.setForeground(Color.WHITE);
        
        dateEditor.setDisabledTextColor(Color.WHITE);
        dateChooser.addPropertyChangeListener("date", (PropertyChangeEvent evt) -> {
            dateChooser.setDateFormatString("MM/dd/yyyy");
            dateEditor.setForeground(Color.WHITE);
            dateEditor.setDisabledTextColor(Color.WHITE);
        });
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
        if (currentPassword.isEmpty() || (passwordField.getEchoChar() == (char) 0 && currentPassword.equals(placeholderText))) {
            setPlaceholder.run();
        } else {
            passwordField.setEchoChar(defaultEchoChar);
            passwordField.setForeground(COLOR_FOREGROUND);
        }
        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passwordField.getForeground().equals(COLOR_PLACEHOLDER) && passwordField.getEchoChar() == (char) 0) {
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
    
    public static void updatePlaceholder(JTextComponent component, String newPlaceholder) {
    for (FocusListener listener : component.getFocusListeners()) {
        component.removeFocusListener(listener);
    }

    component.setText(newPlaceholder);
    component.setForeground(COLOR_PLACEHOLDER);

    if (component instanceof JPasswordField jPasswordField) {
            jPasswordField.setEchoChar((char) 0);
    }

   component.addFocusListener(new FocusAdapter() {
            private final String currentPlaceholder = newPlaceholder;

            @Override
            public void focusGained(FocusEvent e) {
                JTextComponent source = (JTextComponent) e.getSource();
                boolean areTheyEqual = source.getText().equals(currentPlaceholder);

                if (areTheyEqual) {
                    source.setText("");
                    source.setForeground(COLOR_FOREGROUND);
                    if (source instanceof JPasswordField jPasswordField) {
                        jPasswordField.setEchoChar('•');
                    }
                }
                source.getCaret().setVisible(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                JTextComponent source = (JTextComponent) e.getSource();
                if (source.getText().isEmpty()) {
                    source.setForeground(COLOR_PLACEHOLDER);
                    source.setText(currentPlaceholder);
                    if (source instanceof JPasswordField jPasswordField) {
                        jPasswordField.setEchoChar((char) 0);
                    }
                }
                source.getCaret().setVisible(false);
            }
        });
}
}
