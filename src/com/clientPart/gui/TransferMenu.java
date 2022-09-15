package com.clientPart.gui;

import com.clientPart.ClientRun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferMenu extends CustomPanel {

    public static class SelectCardMenu extends CustomPanel {
        private JLabel namePanelLabel;

        private Box box;

        private CustomButton[] cards;

        private CustomButton backToFirstPageButton;

        public SelectCardMenu(){
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
                        ClientRun.frame.transferBySimpleCard=new TransferBySimpleCard(id,index);
                        ClientRun.frame.setContentPane(ClientRun.frame.transferBySimpleCard);
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
                    ClientRun.frame.setContentPane(ClientRun.frame.firstMenu);
                }
            });
            add(backToFirstPageButton);
        }
    }
}
