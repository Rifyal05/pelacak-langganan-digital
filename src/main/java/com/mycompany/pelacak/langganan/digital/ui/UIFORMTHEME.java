/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pelacak.langganan.digital.ui;

import static com.mycompany.pelacak.langganan.digital.ui.LoginTheme.COLOR_BORDER_TEXT_FIELD;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;

/**
 *
 * @author rifial
 */
public class UIFORMTHEME {

    public static final Color COLOR_BACKGROUND = new Color(15, 15, 20);
    public static final Color COLOR_CARD = new Color(23, 23, 27);
    public static final Color COLOR_BUTTON_PRIMARY_BG = new Color(0, 123, 255);
    public static final Color COLOR_BUTTON_TEXT = Color.WHITE;
    public static final Color COLOR_PLACEHOLDER = new Color(160, 160, 160);
    public static final Color COLOR_TEXT_FIELD_BACKGROUND = new Color(40, 40, 45);
    public static final Color COLOR_TABLE_BACKGROUND = new Color(35, 35, 40);
    public static final Color COLOR_TABLE_FOREGROUND = new Color(210, 210, 210);
    public static final Color COLOR_TABLE_GRID = new Color(70, 70, 75);
    public static final Color COLOR_TABLE_SELECTION_BG = new Color(0, 123, 255);
    public static final Color COLOR_TABLE_SELECTION_FG = Color.WHITE;
    public static final Color COLOR_TABLE_HEADER_BG = new Color(60, 60, 65);
    public static final Color COLOR_TABLE_HEADER_FG = new Color(220, 220, 220);
    public static final Color COLOR_SCROLLPANE_BORDER = new Color(50, 50, 55);
    public static final Font FONT_TABLE_CELL = new Font("Malgun Gothic", Font.PLAIN, 14);
    public static final Font FONT_TABLE_HEADER = new Font("Malgun Gothic", Font.BOLD, 15);
    public static final Color COLOR_PANEL_BACKGROUND = new Color(25, 25, 30);

    public static void styleFrameBackground(JFrame frame) {
        frame.getContentPane().setBackground(COLOR_BACKGROUND);
    }

    public static void stylePanelCard(JPanel jpanel) {
        jpanel.setBackground(COLOR_CARD);
        jpanel.setOpaque(true);
    }

    public static void styleButton(JButton button) {
        button.setBackground(COLOR_BUTTON_PRIMARY_BG);
        button.setForeground(COLOR_BUTTON_TEXT);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
    }

    public static void styleSearchField(JTextField jTextField) {
        jTextField.setBackground(COLOR_TEXT_FIELD_BACKGROUND);
        jTextField.setForeground(COLOR_PLACEHOLDER);
        jTextField.setCaretColor(COLOR_BUTTON_TEXT);
        jTextField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(COLOR_BORDER_TEXT_FIELD),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));

    }

    public static void styleTable(JTable table, JScrollPane scrollPane) {
        table.setBackground(COLOR_TABLE_BACKGROUND);
        table.setForeground(COLOR_TABLE_FOREGROUND);
        table.setGridColor(COLOR_TABLE_GRID);
        table.setSelectionBackground(COLOR_TABLE_SELECTION_BG);
        table.setSelectionForeground(COLOR_TABLE_SELECTION_FG);

        table.setFont(FONT_TABLE_CELL);
        table.setRowHeight(30);

        table.setShowGrid(true);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);

        JTableHeader header = table.getTableHeader();
        header.setBackground(COLOR_TABLE_HEADER_BG);
        header.setForeground(COLOR_TABLE_HEADER_FG);
        header.setFont(FONT_TABLE_HEADER);
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, COLOR_SCROLLPANE_BORDER));
        header.setPreferredSize(new Dimension(0, 38));

        if (scrollPane != null) {
            if (scrollPane.getViewport() != null) {
                scrollPane.getViewport().setBackground(COLOR_TABLE_BACKGROUND);
                scrollPane.getViewport().setOpaque(true);
            }
            scrollPane.setBorder(BorderFactory.createLineBorder(COLOR_SCROLLPANE_BORDER));
            scrollPane.setBackground(COLOR_TABLE_BACKGROUND);
            scrollPane.setOpaque(true);
            UIManager.put("ScrollBar.thumb", new Color(70, 70, 75));
            UIManager.put("ScrollBar.track", COLOR_PANEL_BACKGROUND);
            SwingUtilities.updateComponentTreeUI(scrollPane);
        }
    }
}
