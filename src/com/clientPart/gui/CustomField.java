package com.clientPart.gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CustomField extends JTextField {
    public CustomField() {
        setFont(MainFrame.FONT);
        setOpaque(false);
        setBorder(new LineBorder(Color.BLACK));
        setForeground(Color.BLACK);
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                setBackground(MainFrame.PINK);
                setOpaque(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                setBackground(Color.WHITE);
                setOpaque(false);
            }
        });
    }
}
