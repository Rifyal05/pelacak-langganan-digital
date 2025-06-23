/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pelacak.langganan.digital.object;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

/**
 *
 * @author rifial
 */
public class FontSetting {

    private final Font font;

    /**
     *
     * @param fontName Nama Font
     * @param fontStyle Gaya font. Bold-1, Regular-0
     * @param fontSize Ukuran Font
     */
    public FontSetting(String fontName, int fontStyle, int fontSize) {
        this.font = new Font(fontName, fontStyle, fontSize);
    }

    public void SelectFontContainer(Container container) {
        changeFont(container);
    }

    private boolean isContainer(Component comp) {
        return (comp instanceof JDesktopPane
                || comp instanceof JTabbedPane
                || comp instanceof JToolBar
                || comp instanceof JScrollPane
                || comp instanceof JPanel
                || comp instanceof JInternalFrame
                || comp instanceof JLayeredPane);
    }

    public void changeFont(Container comp) {
        comp.setFont(font);
        Component[] components = comp.getComponents();
        for (Component component : components) {
            if (isContainer(component)) {
                changeFont((Container) component);
            } else {
                component.setFont(font);
            }
        }
    }
}
