package com.clientPart.gui;

import com.clientPart.ClientRun;
import com.common.Action;
import com.common.PackageData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferBySimpleCard extends CustomPanel {
    private JLabel namePanelLabel;

    private JLabel balance;
    private JLabel typeAmount;
    private JLabel typeReceiverId;
    private CustomField amount;
    private CustomField receiverId;
    private CustomButton transferButton;
    private CustomButton backButton;

    public TransferBySimpleCard(Long cardId, int cardIndex) {
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

        typeAmount = new CustomLabel("Type amount");
        typeAmount.setBounds(200,226,800,64);
        add(typeAmount);

        amount = new CustomField();
        amount.setBounds(200,310,800,32);
        add(amount);

        typeReceiverId = new CustomLabel("Type receiver card no.");
        typeReceiverId.setBounds(200,372,800,64);
        add(typeReceiverId);

        receiverId = new CustomField();
        receiverId.setBounds(200,456,800,32);
        add(receiverId);

        transferButton = new CustomButton("Transfer money");
        transferButton.setBounds(450,556,300,48);
        transferButton.setFont(MainFrame.SUBTITLEFONT);
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    double sum = Double.parseDouble(amount.getText());
                    Long receiverCardId = Long.valueOf(receiverId.getText());

                    if(sum >= 0 && sum <= MainFrame.clientInApp.getCards().get(cardIndex).getMainBalance() && receiverId.getText().length()==16){
                        PackageData packageData = new PackageData(Action.TRANSFERCARD, MainFrame.clientInApp, MainFrame.clientInApp.getCards().get(cardIndex), sum, receiverCardId);

                        ClientRun.connectToServer(packageData);

                        if(MainFrame.transferAnswer) {
                            JOptionPane.showMessageDialog(null,"You transferred money successfully", "Successful", JOptionPane.INFORMATION_MESSAGE);
                            balance.setText((MainFrame.clientInApp.getCards().get(cardIndex).getMainBalance()-sum)+" "+MainFrame.clientInApp.getCards().get(cardIndex).getMainCurrency().toString());
                        }
                        else JOptionPane.showMessageDialog(null,"Receiver id doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(null,"Amount out of bound", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception exception){
                    JOptionPane.showMessageDialog(null,"Amount must be number\n"+
                            "Receiver id must be 16 digit number", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(transferButton);

        backButton = new CustomButton("Back");
        backButton.setBounds(450,624,300,48);
        backButton.setFont(MainFrame.SUBTITLEFONT);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientRun.frame.setContentPane(ClientRun.frame.selectCardMenu);
            }
        });
        add(backButton);
    }
}
