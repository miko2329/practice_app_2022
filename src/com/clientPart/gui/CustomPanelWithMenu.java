package com.clientPart.gui;

import com.clientPart.ClientRun;
import com.common.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomPanelWithMenu extends CustomPanel {
    JLabel clientLabel;
    JButton myCardsButton;
    JButton newCardButton;
    JButton editButton;
    JButton logoutButton;
    JButton transferButton;

    public CustomPanelWithMenu() {
        setLayout(null);

        setSize(1200,800);

        clientLabel = new JLabel(MainFrame.clientInApp.getFullName(), SwingConstants.CENTER);
        clientLabel.setBounds(30,10,255, 32);
        clientLabel.setFont(MainFrame.SUBTITLEFONT);
        clientLabel.setForeground(Color.BLACK);
        clientLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(clientLabel);

        transferButton = new JButton(new ImageIcon("img/transfer.png"));
        transferButton.setText("Transfer");
        transferButton.setBounds(30,250,255,32);
        transferButton.setFont(MainFrame.SUBTITLEFONT);
        transferButton.setForeground(Color.BLACK);
        transferButton.setHorizontalAlignment(SwingConstants.CENTER);
        transferButton.setVerticalAlignment(SwingConstants.CENTER);
        transferButton.setOpaque(false);
        transferButton.setContentAreaFilled(false);
        transferButton.setFocusPainted(false);
        transferButton.setBorder(BorderFactory.createEmptyBorder());
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientRun.frame.selectCardMenu=new TransferMenu.SelectCardMenu();
                ClientRun.frame.setContentPane(ClientRun.frame.selectCardMenu);
            }
        });
        add(transferButton);

        myCardsButton = new JButton(new ImageIcon("img/my-cards.png"));
        myCardsButton.setText("My cards");
        myCardsButton.setBounds(30,312,255,32);
        myCardsButton.setFont(MainFrame.SUBTITLEFONT);
        myCardsButton.setForeground(Color.BLACK);
        myCardsButton.setHorizontalAlignment(SwingConstants.CENTER);
        myCardsButton.setVerticalAlignment(SwingConstants.CENTER);
        myCardsButton.setOpaque(false);
        myCardsButton.setContentAreaFilled(false);
        myCardsButton.setFocusPainted(false);
        myCardsButton.setBorder(BorderFactory.createEmptyBorder());
        myCardsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientRun.frame.cardsPanel=new MyCardsPanel();
                ClientRun.frame.setContentPane(ClientRun.frame.cardsPanel);
            }
        });
        add(myCardsButton);

        newCardButton = new JButton(new ImageIcon("img/new-card.png"));
        newCardButton.setText("New card");
        newCardButton.setBounds(30,374,255,32);
        newCardButton.setFont(MainFrame.SUBTITLEFONT);
        newCardButton.setForeground(Color.BLACK);
        newCardButton.setHorizontalAlignment(SwingConstants.CENTER);
        newCardButton.setVerticalAlignment(SwingConstants.CENTER);
        newCardButton.setOpaque(false);
        newCardButton.setContentAreaFilled(false);
        newCardButton.setFocusPainted(false);
        newCardButton.setBorder(BorderFactory.createEmptyBorder());
        newCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientRun.frame.createCard=new CreateCard();
                ClientRun.frame.setContentPane(ClientRun.frame.createCard);
            }
        });
        add(newCardButton);

        editButton = new JButton(new ImageIcon("img/editing.png"));
        editButton.setText("Edit my profile");
        editButton.setBounds(30,436,255,32);
        editButton.setFont(MainFrame.SUBTITLEFONT);
        editButton.setForeground(Color.BLACK);
        editButton.setHorizontalAlignment(SwingConstants.CENTER);
        editButton.setVerticalAlignment(SwingConstants.CENTER);
        editButton.setOpaque(false);
        editButton.setContentAreaFilled(false);
        editButton.setFocusPainted(false);
        editButton.setBorder(BorderFactory.createEmptyBorder());
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientRun.frame.editPanel=new EditPanel();
                ClientRun.frame.setContentPane(ClientRun.frame.editPanel);
            }
        });
        add(editButton);

        logoutButton = new JButton(new ImageIcon("img/switch.png"));
        logoutButton.setText("Logout");
        logoutButton.setBounds(30,498,255,32);
        logoutButton.setFont(MainFrame.SUBTITLEFONT);
        logoutButton.setForeground(Color.BLACK);
        logoutButton.setHorizontalAlignment(SwingConstants.CENTER);
        logoutButton.setVerticalAlignment(SwingConstants.CENTER);
        logoutButton.setOpaque(false);
        logoutButton.setContentAreaFilled(false);
        logoutButton.setFocusPainted(false);
        logoutButton.setBorder(BorderFactory.createEmptyBorder());
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int select = JOptionPane.showConfirmDialog(null,"Are you sure you want to log out?", "Logout", JOptionPane.YES_NO_CANCEL_OPTION);

                if (select==0){
                    MainFrame.clientInApp=null;
                    ClientRun.frame.setContentPane(ClientRun.frame.loginPanel);
                }
            }
        });
        add(logoutButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);

        g.fillRect(315, 0, 5, 800);
    }
}
