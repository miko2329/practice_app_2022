package com.clientPart.gui;

import com.clientPart.ClientRun;
import com.common.Action;
import com.common.PackageData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiCardMenu extends CustomPanel {

    private JLabel namePanelLabel;

    private JLabel kztBalance;
    private JLabel usdBalance;
    private JLabel eurBalance;
    private JLabel rubBalance;

    private CustomButton makePriority;
    private CustomButton deactivateCard;
    private CustomButton deleteCard;
    private CustomButton backButton;

    public MultiCardMenu(Long cardId, int cardIndex) {
        setLayout(null);

        setSize(1200,800);

        namePanelLabel = new JLabel("My multi currency card: "+cardId, SwingConstants.CENTER);
        namePanelLabel.setBounds(100,90,1000, 64);
        namePanelLabel.setFont(MainFrame.SUPERTITLEFONT);
        namePanelLabel.setForeground(Color.BLACK);
        namePanelLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(namePanelLabel);

        kztBalance = new JLabel(MainFrame.clientInApp.getMultiCurrencyCards().get(cardIndex).getMainBalance()+" KZT", SwingConstants.CENTER);
        kztBalance.setBounds(100,174,1000, 32);
        kztBalance.setFont(MainFrame.TITLEFONT);
        kztBalance.setForeground(Color.BLACK);
        kztBalance.setVerticalAlignment(SwingConstants.CENTER);
        add(kztBalance);

        usdBalance = new JLabel(MainFrame.clientInApp.getMultiCurrencyCards().get(cardIndex).getSecondBalance()+" USD", SwingConstants.CENTER);
        usdBalance.setBounds(100,226,1000, 32);
        usdBalance.setFont(MainFrame.TITLEFONT);
        usdBalance.setForeground(Color.BLACK);
        usdBalance.setVerticalAlignment(SwingConstants.CENTER);
        add(usdBalance);

        eurBalance = new JLabel(MainFrame.clientInApp.getMultiCurrencyCards().get(cardIndex).getThirdBalance()+" EUR", SwingConstants.CENTER);
        eurBalance.setBounds(100,278,1000, 32);
        eurBalance.setFont(MainFrame.TITLEFONT);
        eurBalance.setForeground(Color.BLACK);
        eurBalance.setVerticalAlignment(SwingConstants.CENTER);
        add(eurBalance);

        rubBalance = new JLabel(MainFrame.clientInApp.getMultiCurrencyCards().get(cardIndex).getFourthBalance()+" RUB", SwingConstants.CENTER);
        rubBalance.setBounds(100,330,1000, 32);
        rubBalance.setFont(MainFrame.TITLEFONT);
        rubBalance.setForeground(Color.BLACK);
        rubBalance.setVerticalAlignment(SwingConstants.CENTER);
        add(rubBalance);

        makePriority = new CustomButton("Make priority this card");
        makePriority.setBounds(450,420,300,48);
        makePriority.setFont(MainFrame.SUBTITLEFONT);
        makePriority.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData packageData = new PackageData(Action.MAKEPRIORITYMCARD, MainFrame.clientInApp, MainFrame.clientInApp.getMultiCurrencyCards().get(cardIndex));

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
                PackageData packageData = new PackageData(Action.DEACTIVATEMCARD, MainFrame.clientInApp, MainFrame.clientInApp.getMultiCurrencyCards().get(cardIndex));

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
                PackageData packageData = new PackageData(Action.DELETEMCARD, MainFrame.clientInApp, MainFrame.clientInApp.getMultiCurrencyCards().get(cardIndex));

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
                ClientRun.frame.setContentPane(ClientRun.frame.myMultiCards);
            }
        });
        add(backButton);
    }
}
