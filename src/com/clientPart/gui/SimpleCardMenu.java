package com.clientPart.gui;

import com.clientPart.ClientRun;
import com.common.Action;
import com.common.PackageData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCardMenu extends CustomPanel{
    private JLabel namePanelLabel;

    private JLabel balance;
    private CustomButton makePriority;
    private CustomButton deactivateCard;
    private CustomButton deleteCard;
    private CustomButton backButton;

    public SimpleCardMenu(Long cardId, int cardIndex) {
        setLayout(null);

        setSize(1200,800);

        namePanelLabel = new JLabel("My simple card: "+cardId, SwingConstants.CENTER);
        namePanelLabel.setBounds(100,90,1000, 64);
        namePanelLabel.setFont(MainFrame.SUPERTITLEFONT);
        namePanelLabel.setForeground(Color.BLACK);
        namePanelLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(namePanelLabel);

        balance = new JLabel(MainFrame.clientInApp.getCards().get(cardIndex).getMainBalance()+" "+MainFrame.clientInApp.getCards().get(cardIndex).getMainCurrency().toString(), SwingConstants.CENTER);
        balance.setBounds(100,174,1000, 32);
        balance.setFont(MainFrame.TITLEFONT);
        balance.setForeground(Color.BLACK);
        balance.setVerticalAlignment(SwingConstants.CENTER);
        add(balance);

        makePriority = new CustomButton("Make priority this card");
        makePriority.setBounds(450,420,300,48);
        makePriority.setFont(MainFrame.SUBTITLEFONT);
        makePriority.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData packageData = new PackageData(com.common.Action.MAKEPRIORITYCARD, MainFrame.clientInApp, MainFrame.clientInApp.getCards().get(cardIndex));

                ClientRun.connectToServer(packageData);

                if(MainFrame.makePriorityAnswer) {
                    JOptionPane.showMessageDialog(null,"You made this card as priority card", "Successful", JOptionPane.INFORMATION_MESSAGE);
                    MainFrame.makePriorityAnswer=false;
                }
                else JOptionPane.showMessageDialog(null,"Make priority is failed, try again late", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(makePriority);

        deactivateCard = new CustomButton("Deactivate this card");
        deactivateCard.setBounds(450,488,300,48);
        deactivateCard.setFont(MainFrame.SUBTITLEFONT);
        deactivateCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData packageData = new PackageData(com.common.Action.DEACTIVATECARD, MainFrame.clientInApp, MainFrame.clientInApp.getCards().get(cardIndex));

                ClientRun.connectToServer(packageData);

                if(MainFrame.deactivateAnswer) {
                    JOptionPane.showMessageDialog(null,"You made this card as deactivated card", "Successful", JOptionPane.INFORMATION_MESSAGE);
                    MainFrame.deactivateAnswer=false;
                }
                else JOptionPane.showMessageDialog(null,"Deactivate is failed, try again late", "Error", JOptionPane.ERROR_MESSAGE);

            }
        });
        add(deactivateCard);

        deleteCard = new CustomButton("Delete this card");
        deleteCard.setBounds(450,556,300,48);
        deleteCard.setFont(MainFrame.SUBTITLEFONT);
        deleteCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData packageData = new PackageData(Action.DELETECARD, MainFrame.clientInApp, MainFrame.clientInApp.getCards().get(cardIndex));

                ClientRun.connectToServer(packageData);

                if(MainFrame.deleteAnswer) {
                    JOptionPane.showMessageDialog(null,"You deleted this card", "Successful", JOptionPane.INFORMATION_MESSAGE);
                    MainFrame.deleteAnswer=false;
                }
                else JOptionPane.showMessageDialog(null,"This card is priority", "Error", JOptionPane.ERROR_MESSAGE);

            }
        });
        add(deleteCard);

        backButton = new CustomButton("Back");
        backButton.setBounds(450,624,300,48);
        backButton.setFont(MainFrame.SUBTITLEFONT);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientRun.frame.setContentPane(ClientRun.frame.myCards);
            }
        });
        add(backButton);
    }
}
