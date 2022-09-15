package com.clientPart.gui;

import com.common.ExchangeCurrency;
import com.common.ParserCurrency;

import javax.swing.*;
import java.awt.*;

public class FirstMenu extends CustomPanelWithMenu {

    JLabel nameLabel;
    JLabel totalBalanceKZTLabel;
    JLabel totalBalanceUSDLabel;
    JLabel totalBalanceEURLabel;
    JLabel totalBalanceRUBLabel;

    JLabel rateUSDLabel;
    JLabel rateEURLabel;
    JLabel rateRUBLabel;

    public FirstMenu() {
        super();

        ParserCurrency.getExchangeRate();

        nameLabel = new JLabel("Total balance", SwingConstants.CENTER);
        nameLabel.setBounds(505,90,500, 64);
        nameLabel.setFont(MainFrame.SUPERTITLEFONT);
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(nameLabel);

        totalBalanceKZTLabel = new JLabel(new ImageIcon("img/kazakhstan.png"));
        totalBalanceKZTLabel.setText("Total: " + MainFrame.clientInApp.getTotalKZT() + " KZT");
        totalBalanceKZTLabel.setBounds(460,170,450, 128);
        totalBalanceKZTLabel.setFont(MainFrame.TITLEFONT);
        totalBalanceKZTLabel.setForeground(Color.BLACK);
        totalBalanceKZTLabel.setVerticalAlignment(SwingConstants.CENTER);
        totalBalanceKZTLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(totalBalanceKZTLabel);

        totalBalanceUSDLabel = new JLabel(new ImageIcon("img/united-states.png"));
        totalBalanceUSDLabel.setText("Total: " + MainFrame.clientInApp.getTotalUSD() + " USD");
        totalBalanceUSDLabel.setBounds(460,318,450, 128);
        totalBalanceUSDLabel.setFont(MainFrame.TITLEFONT);
        totalBalanceUSDLabel.setForeground(Color.BLACK);
        totalBalanceUSDLabel.setVerticalAlignment(SwingConstants.CENTER);
        totalBalanceUSDLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(totalBalanceUSDLabel);

        rateUSDLabel = new JLabel("1 USD = "+ ExchangeCurrency.USDtoKZT+" KZT");
        rateUSDLabel.setBounds(930,318,250, 128);
        rateUSDLabel.setFont(MainFrame.TITLEFONT);
        rateUSDLabel.setForeground(Color.BLACK);
        rateUSDLabel.setVerticalAlignment(SwingConstants.CENTER);
        rateUSDLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(rateUSDLabel);

        totalBalanceEURLabel = new JLabel(new ImageIcon("img/european-union.png"));
        totalBalanceEURLabel.setText("Total: " + MainFrame.clientInApp.getTotalEUR() + " EUR");
        totalBalanceEURLabel.setBounds(460,466,450, 128);
        totalBalanceEURLabel.setFont(MainFrame.TITLEFONT);
        totalBalanceEURLabel.setForeground(Color.BLACK);
        totalBalanceEURLabel.setVerticalAlignment(SwingConstants.CENTER);
        totalBalanceEURLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(totalBalanceEURLabel);

        rateEURLabel = new JLabel("1 EUR = "+ ExchangeCurrency.EURtoKZT+" KZT");
        rateEURLabel.setBounds(930,466,250, 128);
        rateEURLabel.setFont(MainFrame.TITLEFONT);
        rateEURLabel.setForeground(Color.BLACK);
        rateEURLabel.setVerticalAlignment(SwingConstants.CENTER);
        rateEURLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(rateEURLabel);

        totalBalanceRUBLabel = new JLabel(new ImageIcon("img/russia.png"));
        totalBalanceRUBLabel.setText("Total: " + MainFrame.clientInApp.getTotalRUB() + " RUB");
        totalBalanceRUBLabel.setBounds(460,614,450, 128);
        totalBalanceRUBLabel.setFont(MainFrame.TITLEFONT);
        totalBalanceRUBLabel.setForeground(Color.BLACK);
        totalBalanceRUBLabel.setVerticalAlignment(SwingConstants.CENTER);
        totalBalanceRUBLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(totalBalanceRUBLabel);

        rateRUBLabel = new JLabel("1 RUB = "+ ExchangeCurrency.RUBtoKZT+" KZT");
        rateRUBLabel.setBounds(930,614,250, 128);
        rateRUBLabel.setFont(MainFrame.TITLEFONT);
        rateRUBLabel.setForeground(Color.BLACK);
        rateRUBLabel.setVerticalAlignment(SwingConstants.CENTER);
        rateRUBLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(rateRUBLabel);
    }
}
