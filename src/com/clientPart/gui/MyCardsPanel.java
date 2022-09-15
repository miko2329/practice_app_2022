package com.clientPart.gui;

import com.clientPart.ClientRun;
import com.common.Card;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyCardsPanel extends CustomPanel {

    private JLabel namePanelLabel;

    private CustomButton cardButton;
    private CustomButton multiCardButton;

    private CustomButton backToLoginPanelButton;

    public MyCardsPanel() {
        setLayout(null);

        setSize(1200,800);

        namePanelLabel = new JLabel("My cards and multi cards", SwingConstants.CENTER);
        namePanelLabel.setBounds(100,90,1000, 64);
        namePanelLabel.setFont(MainFrame.SUPERTITLEFONT);
        namePanelLabel.setForeground(Color.BLACK);
        namePanelLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(namePanelLabel);

        cardButton = new CustomButton("Cards");
        cardButton.setBounds(250,338,275,48);
        cardButton.setFont(MainFrame.SUBTITLEFONT);
        cardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientRun.frame.myCards=new MyCards();
                ClientRun.frame.setContentPane(ClientRun.frame.myCards);
            }
        });
        add(cardButton);

        multiCardButton = new CustomButton("Multi Cards");
        multiCardButton.setBounds(675,338,275,48);
        multiCardButton.setFont(MainFrame.SUBTITLEFONT);
        multiCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientRun.frame.myMultiCards=new MyMultiCards();
                ClientRun.frame.setContentPane(ClientRun.frame.myMultiCards);
            }
        });
        add(multiCardButton);

        backToLoginPanelButton = new CustomButton("Back to menu");
        backToLoginPanelButton.setBounds(250,600,275,48);
        backToLoginPanelButton.setFont(MainFrame.SUBTITLEFONT);
        backToLoginPanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientRun.frame.firstMenu=new FirstMenu();
                ClientRun.frame.setContentPane(ClientRun.frame.firstMenu);
            }
        });
        add(backToLoginPanelButton);
    }

    public static class MyCards extends CustomPanel{
        private JLabel namePanelLabel;

        private Box box;

        private CustomButton[] cards;

        private CustomButton backToFirstPageButton;

        public MyCards(){
            setLayout(null);

            setSize(1200,800);

            namePanelLabel = new JLabel("My cards", SwingConstants.CENTER);
            namePanelLabel.setBounds(100,90,1000, 64);
            namePanelLabel.setFont(MainFrame.SUPERTITLEFONT);
            namePanelLabel.setForeground(Color.BLACK);
            namePanelLabel.setVerticalAlignment(SwingConstants.CENTER);
            add(namePanelLabel);

            box = new Box(BoxLayout.Y_AXIS);
            box.setBounds(250,170,700,380);
            box.setOpaque(false);
            add(box);

            cards = new CustomButton[MainFrame.clientInApp.getCards().size()];
            for (int i = 0; i < cards.length; i++) {
                Long id = MainFrame.clientInApp.getCards().get(i).getId();
                int index = i;
                cards[i] = new CustomButton(String.valueOf(id));
                cards[i].setSize(350,850);
                cards[i].setFont(MainFrame.FONT);
                cards[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ClientRun.frame.simpleCardMenu=new SimpleCardMenu(id,index);
                        ClientRun.frame.setContentPane(ClientRun.frame.simpleCardMenu);
                    }
                });
                box.add(Box.createVerticalStrut(20));
                box.add(cards[i]);
            }

            backToFirstPageButton = new CustomButton("Back");
            backToFirstPageButton.setBounds(250,600,275,48);
            backToFirstPageButton.setFont(MainFrame.SUBTITLEFONT);
            backToFirstPageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ClientRun.frame.setContentPane(ClientRun.frame.cardsPanel);
                }
            });
            add(backToFirstPageButton);
        }
    }

    public static class MyMultiCards extends CustomPanel {
        private JLabel namePanelLabel;

        private Box box;

        private CustomButton[] cards;

        private CustomButton backToFirstPageButton;

        public MyMultiCards() {
            setLayout(null);

            setSize(1200,800);

            namePanelLabel = new JLabel("My multi currency cards", SwingConstants.CENTER);
            namePanelLabel.setBounds(100,90,1000, 64);
            namePanelLabel.setFont(MainFrame.SUPERTITLEFONT);
            namePanelLabel.setForeground(Color.BLACK);
            namePanelLabel.setVerticalAlignment(SwingConstants.CENTER);
            add(namePanelLabel);

            box = new Box(BoxLayout.Y_AXIS);
            box.setBounds(250,170,700,380);
            box.setOpaque(false);
            add(box);

            cards = new CustomButton[MainFrame.clientInApp.getMultiCurrencyCards().size()];
            for (int i = 0; i < cards.length; i++) {
                Long id = MainFrame.clientInApp.getMultiCurrencyCards().get(i).getId();
                int index = i;
                cards[i] = new CustomButton(String.valueOf(id));
                cards[i].setSize(350,850);
                cards[i].setFont(MainFrame.FONT);
                cards[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ClientRun.frame.multiCardMenu=new MultiCardMenu(id,index);
                        ClientRun.frame.setContentPane(ClientRun.frame.multiCardMenu);
                    }
                });
                box.add(Box.createVerticalStrut(20));
                box.add(cards[i]);
            }

            backToFirstPageButton = new CustomButton("Back");
            backToFirstPageButton.setBounds(250,600,275,48);
            backToFirstPageButton.setFont(MainFrame.SUBTITLEFONT);
            backToFirstPageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ClientRun.frame.setContentPane(ClientRun.frame.cardsPanel);
                }
            });
            add(backToFirstPageButton);
        }
    }
}
