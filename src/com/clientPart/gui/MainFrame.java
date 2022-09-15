package com.clientPart.gui;

import com.clientPart.ClientRun;
import com.common.Client;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public static Font SUPERTITLEFONT = new Font("Calibri", Font.BOLD, 60);
    public static Font TITLEFONT = new Font("Calibri", Font.BOLD, 30);
    public static Font SUBTITLEFONT = new Font("Calibri", Font.BOLD, 25);
    public static Font FONT = new Font("Calibri", Font.PLAIN, 20);

    public static Color PINK = new Color(0xB940F6);

    public static Client clientInApp = null;
    public static Client beforeUpdate = null;
    public static Boolean signUpAnswer = false;
    public static Boolean changePasswordAnswer = false;
    public static Boolean createSimpleAnswer = false;
    public static Boolean makePriorityAnswer = false;
    public static Boolean deactivateAnswer = false;
    public static Boolean deleteAnswer = false;
    public static Boolean transferAnswer = false;


    public LoginPanel loginPanel;
    public SignUpPanel signUpPanel;
    public ResetPasswordPanel resetPasswordPanel;
    public FirstMenu firstMenu;
    public EditPanel editPanel;
    public EditPanel.EditClientInfo editClientInfo;
    public EditPanel.EditLoginInfo editLoginInfo;
    public MyCardsPanel cardsPanel;
    public MyCardsPanel.MyCards myCards;
    public MyCardsPanel.MyMultiCards myMultiCards;
    public CreateCard createCard;
    public CreateCard.CreateSimpleCard createSimpleCard;
    public CreateCard.CreateMultiCard createMultiCard;
    public MultiCardMenu multiCardMenu;
    public SimpleCardMenu simpleCardMenu;
    public TransferMenu.SelectCardMenu selectCardMenu;
    public TransferBySimpleCard transferBySimpleCard;

    public MainFrame() {
        setTitle("Bank Desktop Application");

        setSize(1200,800);
        setLocationRelativeTo(null);

        setVisible(true);
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        UIManager.put("Button.select", new Color(0x2DC6FC));

        loginPanel = new LoginPanel();
        setContentPane(loginPanel);

        //signUpPanel = new SignUpPanel();
        //setContentPane(signUpPanel);

        //firstMenu = new FirstMenu();
        //setContentPane(firstMenu);

        //resetPasswordPanel = new ResetPasswordPanel();
        //setContentPane(resetPasswordPanel);
    }
}
