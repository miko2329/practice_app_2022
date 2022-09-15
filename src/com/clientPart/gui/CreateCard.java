package com.clientPart.gui;

import com.clientPart.ClientRun;
import com.common.*;
import com.common.Action;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateCard extends CustomPanel {
    private JLabel namePanelLabel;

    private CustomButton simpleCard;
    private CustomButton multiCard;
    private CustomButton backButton;

    public CreateCard() {
        setLayout(null);

        setSize(1200,800);

        namePanelLabel = new JLabel("Create new card", SwingConstants.CENTER);
        namePanelLabel.setBounds(100,90,1000, 64);
        namePanelLabel.setFont(MainFrame.SUPERTITLEFONT);
        namePanelLabel.setForeground(Color.BLACK);
        namePanelLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(namePanelLabel);

        simpleCard = new CustomButton("Simple card");
        simpleCard.setBounds(250,338,275,48);
        simpleCard.setFont(MainFrame.SUBTITLEFONT);
        simpleCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientRun.frame.createSimpleCard=new CreateSimpleCard();
                ClientRun.frame.setContentPane(ClientRun.frame.createSimpleCard);
            }
        });
        add(simpleCard);

        multiCard = new CustomButton("Multi currency card");
        multiCard.setBounds(675,338,275,48);
        multiCard.setFont(MainFrame.SUBTITLEFONT);
        multiCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientRun.frame.createMultiCard=new CreateMultiCard();
                ClientRun.frame.setContentPane(ClientRun.frame.createMultiCard);
            }
        });
        add(multiCard);

        backButton = new CustomButton("Back to menu");
        backButton.setBounds(250,600,275,48);
        backButton.setFont(MainFrame.SUBTITLEFONT);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientRun.frame.firstMenu=new FirstMenu();
                ClientRun.frame.setContentPane(ClientRun.frame.firstMenu);
            }
        });
        add(backButton);
    }

    public static class CreateSimpleCard extends CustomPanel {
        private JLabel namePanelLabel;
        private JLabel selectCurrency;
        private JLabel selectSystem;
        private ButtonGroup mainCurrency;
        private ButtonGroup paymentSystem;

        private JRadioButton kzt;
        private JRadioButton usd;
        private JRadioButton eur;
        private JRadioButton rub;
        private JRadioButton visa;
        private JRadioButton mastercard;
        private JRadioButton maestro;

        private CustomButton backButton;
        private CustomButton create;

        public CreateSimpleCard(){
            setLayout(null);

            setSize(1200,800);

            namePanelLabel = new JLabel("Create simple card", SwingConstants.CENTER);
            namePanelLabel.setBounds(100,90,1000, 64);
            namePanelLabel.setFont(MainFrame.SUPERTITLEFONT);
            namePanelLabel.setForeground(Color.BLACK);
            namePanelLabel.setVerticalAlignment(SwingConstants.CENTER);
            add(namePanelLabel);

            selectCurrency = new JLabel("Select currency", SwingConstants.CENTER);
            selectCurrency.setBounds(300,200,200, 64);
            selectCurrency.setFont(MainFrame.TITLEFONT);
            selectCurrency.setForeground(Color.BLACK);
            selectCurrency.setVerticalAlignment(SwingConstants.CENTER);
            add(selectCurrency);

            selectSystem = new JLabel("Select system", SwingConstants.CENTER);
            selectSystem.setBounds(700,200,200, 64);
            selectSystem.setFont(MainFrame.TITLEFONT);
            selectSystem.setForeground(Color.BLACK);
            selectSystem.setVerticalAlignment(SwingConstants.CENTER);
            add(selectSystem);

            mainCurrency = new ButtonGroup();
            paymentSystem = new ButtonGroup();

            kzt = new JRadioButton("KZT", true);
            kzt.setBounds(300,284,200,48);
            kzt.setOpaque(true);
            kzt.setForeground(Color.BLACK);
            kzt.setContentAreaFilled(false);
            kzt.setFont(MainFrame.SUBTITLEFONT);
            kzt.setVerticalAlignment(SwingConstants.CENTER);


            usd = new JRadioButton("USD");
            usd.setBounds(300,352,200,48);
            usd.setOpaque(true);
            usd.setForeground(Color.BLACK);
            usd.setContentAreaFilled(false);
            usd.setFont(MainFrame.SUBTITLEFONT);
            usd.setVerticalAlignment(SwingConstants.CENTER);


            eur = new JRadioButton("EUR");
            eur.setBounds(300,420,200,48);
            eur.setOpaque(true);
            eur.setForeground(Color.BLACK);
            eur.setContentAreaFilled(false);
            eur.setFont(MainFrame.SUBTITLEFONT);
            eur.setVerticalAlignment(SwingConstants.CENTER);


            rub = new JRadioButton("RUB");
            rub.setBounds(300,488,200,48);
            rub.setOpaque(true);
            rub.setForeground(Color.BLACK);
            rub.setContentAreaFilled(false);
            rub.setFont(MainFrame.SUBTITLEFONT);
            rub.setVerticalAlignment(SwingConstants.CENTER);


            visa = new JRadioButton("VISA",true);
            visa.setBounds(700,284,200,48);
            visa.setOpaque(true);
            visa.setForeground(Color.BLACK);
            visa.setContentAreaFilled(false);
            visa.setFont(MainFrame.SUBTITLEFONT);
            visa.setVerticalAlignment(SwingConstants.CENTER);

            mastercard = new JRadioButton("MASTERCARD");
            mastercard.setBounds(700,352,200,48);
            mastercard.setOpaque(true);
            mastercard.setForeground(Color.BLACK);
            mastercard.setContentAreaFilled(false);
            mastercard.setFont(MainFrame.SUBTITLEFONT);
            mastercard.setVerticalAlignment(SwingConstants.CENTER);

            maestro = new JRadioButton("MAESTRO");
            maestro.setBounds(700,420,200,48);
            maestro.setOpaque(true);
            maestro.setForeground(Color.BLACK);
            maestro.setContentAreaFilled(false);
            maestro.setFont(MainFrame.SUBTITLEFONT);
            maestro.setVerticalAlignment(SwingConstants.CENTER);

            mainCurrency.add(kzt);
            mainCurrency.add(usd);
            mainCurrency.add(eur);
            mainCurrency.add(rub);

            paymentSystem.add(visa);
            paymentSystem.add(mastercard);
            paymentSystem.add(maestro);

            add(kzt);
            add(usd);
            add(eur);
            add(rub);

            add(visa);
            add(mastercard);
            add(maestro);

            backButton = new CustomButton("Back");
            backButton.setBounds(250,600,275,48);
            backButton.setFont(MainFrame.SUBTITLEFONT);
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ClientRun.frame.setContentPane(ClientRun.frame.createCard);
                }
            });
            add(backButton);

            create = new CustomButton("Create");
            create.setBounds(675,600,275,48);
            create.setFont(MainFrame.SUBTITLEFONT);
            create.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Currency currency = Currency.KZT;
                    PaymentSystemOfCard systemOfCard = PaymentSystemOfCard.VISA;

                    if(usd.isSelected()) currency = Currency.USD;
                    else if(eur.isSelected()) currency = Currency.EUR;
                    else if(rub.isSelected()) currency = Currency.RUB;


                    if(mastercard.isSelected()) systemOfCard = PaymentSystemOfCard.MASTERCARD;
                    else if(maestro.isSelected()) systemOfCard = PaymentSystemOfCard.MAESTRO;

                    PackageData packageData = new PackageData(Action.CREATESIMPLECARD, MainFrame.clientInApp, currency, systemOfCard);
                    ClientRun.connectToServer(packageData);

                    if(MainFrame.clientInApp!=MainFrame.beforeUpdate) {
                        JOptionPane.showMessageDialog(null,"You created card successfully", "Successfully created", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else JOptionPane.showMessageDialog(null,"Creation is failed, try again late", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
            add(create);
        }
    }

    public static class CreateMultiCard extends CustomPanel {
        private JLabel namePanelLabel;
        private JLabel selectSystem;
        private ButtonGroup paymentSystem;

        private JRadioButton visa;
        private JRadioButton mastercard;
        private JRadioButton maestro;

        private CustomButton backButton;
        private CustomButton create;

        public CreateMultiCard() {
            setLayout(null);

            setSize(1200,800);

            namePanelLabel = new JLabel("Create multi card", SwingConstants.CENTER);
            namePanelLabel.setBounds(100,90,1000, 64);
            namePanelLabel.setFont(MainFrame.SUPERTITLEFONT);
            namePanelLabel.setForeground(Color.BLACK);
            namePanelLabel.setVerticalAlignment(SwingConstants.CENTER);
            add(namePanelLabel);

            selectSystem = new JLabel("Select system", SwingConstants.CENTER);
            selectSystem.setBounds(500,200,200, 64);
            selectSystem.setFont(MainFrame.TITLEFONT);
            selectSystem.setForeground(Color.BLACK);
            selectSystem.setVerticalAlignment(SwingConstants.CENTER);
            add(selectSystem);

            paymentSystem = new ButtonGroup();

            visa = new JRadioButton("VISA",true);
            visa.setBounds(500,284,200,48);
            visa.setOpaque(true);
            visa.setForeground(Color.BLACK);
            visa.setContentAreaFilled(false);
            visa.setFont(MainFrame.SUBTITLEFONT);
            visa.setVerticalAlignment(SwingConstants.CENTER);

            mastercard = new JRadioButton("MASTERCARD");
            mastercard.setBounds(500,352,200,48);
            mastercard.setOpaque(true);
            mastercard.setForeground(Color.BLACK);
            mastercard.setContentAreaFilled(false);
            mastercard.setFont(MainFrame.SUBTITLEFONT);
            mastercard.setVerticalAlignment(SwingConstants.CENTER);

            maestro = new JRadioButton("MAESTRO");
            maestro.setBounds(500,420,200,48);
            maestro.setOpaque(true);
            maestro.setForeground(Color.BLACK);
            maestro.setContentAreaFilled(false);
            maestro.setFont(MainFrame.SUBTITLEFONT);
            maestro.setVerticalAlignment(SwingConstants.CENTER);

            paymentSystem.add(visa);
            paymentSystem.add(mastercard);
            paymentSystem.add(maestro);

            add(visa);
            add(mastercard);
            add(maestro);

            backButton = new CustomButton("Back");
            backButton.setBounds(250,600,275,48);
            backButton.setFont(MainFrame.SUBTITLEFONT);
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ClientRun.frame.setContentPane(ClientRun.frame.createCard);
                }
            });
            add(backButton);

            create = new CustomButton("Create");
            create.setBounds(675,600,275,48);
            create.setFont(MainFrame.SUBTITLEFONT);
            create.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    PaymentSystemOfCard systemOfCard = PaymentSystemOfCard.VISA;

                    if(mastercard.isSelected()) systemOfCard = PaymentSystemOfCard.MASTERCARD;
                    else if(maestro.isSelected()) systemOfCard = PaymentSystemOfCard.MAESTRO;

                    PackageData packageData = new PackageData(Action.CREATEMULTICARD, MainFrame.clientInApp, systemOfCard);
                    ClientRun.connectToServer(packageData);

                    if(MainFrame.clientInApp!=MainFrame.beforeUpdate) {
                        JOptionPane.showMessageDialog(null,"You created card successfully", "Successfully created", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else JOptionPane.showMessageDialog(null,"Creation is failed, try again late", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
            add(create);
        }
    }
}
