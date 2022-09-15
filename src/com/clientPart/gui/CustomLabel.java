package com.clientPart.gui;

import javax.swing.*;
import java.awt.*;

public class CustomLabel extends JLabel {
    public CustomLabel() {
        setHorizontalTextPosition(SwingConstants.RIGHT);
        setVerticalTextPosition(SwingConstants.CENTER);
        setFont(MainFrame.TITLEFONT);
        setForeground(Color.BLACK);
        setVerticalAlignment(SwingConstants.CENTER);
    }

    public CustomLabel(String text) {
        super(text);
        setHorizontalTextPosition(SwingConstants.RIGHT);
        setVerticalTextPosition(SwingConstants.CENTER);
        setFont(MainFrame.TITLEFONT);
        setForeground(Color.BLACK);
        setVerticalAlignment(SwingConstants.CENTER);
    }

    public CustomLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        setHorizontalTextPosition(SwingConstants.RIGHT);
        setVerticalTextPosition(SwingConstants.CENTER);
        setFont(MainFrame.TITLEFONT);
        setForeground(Color.BLACK);
        setVerticalAlignment(SwingConstants.CENTER);
    }
}
