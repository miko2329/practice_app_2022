package com.clientPart.gui;

import com.common.Action;
import com.common.Client;
import com.common.PackageData;
import com.clientPart.ClientRun;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class LoginPanel extends CustomPanel {
    private JLabel nameLabel;
    private JLabel loginLabel;
    private JLabel passwordLabel;
    private JLabel orLabel;
    private JLabel resetLabel;

    private JTextField loginField;
    private JPasswordField passwordField;

    private JToggleButton hideAndShowButton;
    private CustomButton signInButton;
    private CustomButton signUpButton;
    private CustomButton resetPasswordButton;

    public LoginPanel() {
        setLayout(null);

        setSize(1200,800);

        nameLabel = new JLabel("Welcome", SwingConstants.CENTER);
        nameLabel.setBounds(350,90,500, 64);
        nameLabel.setFont(MainFrame.SUPERTITLEFONT);
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(nameLabel);

        loginLabel = new JLabel("Username");
        loginLabel.setIcon(new ImageIcon("img/user.png"));
        loginLabel.setBounds(350,170,500,64);
        loginLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
        loginLabel.setVerticalTextPosition(SwingConstants.CENTER);
        loginLabel.setFont(MainFrame.TITLEFONT);
        loginLabel.setForeground(Color.BLACK);
        loginLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(loginLabel);

        loginField = new JTextField();
        loginField.setBounds(350,254,500,32);
        loginField.setFont(MainFrame.FONT);
        loginField.setOpaque(false);
        loginField.setBorder(new LineBorder(Color.BLACK));
        loginField.setForeground(Color.BLACK);
        loginField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                loginField.setBackground(MainFrame.PINK);
                loginField.setOpaque(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                loginField.setBackground(Color.WHITE);
                loginField.setOpaque(false);
            }
        });
        add(loginField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setIcon(new ImageIcon("img/padlock.png"));
        passwordLabel.setBounds(350,316,500,64);
        passwordLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
        passwordLabel.setVerticalTextPosition(SwingConstants.CENTER);
        passwordLabel.setFont(MainFrame.TITLEFONT);
        passwordLabel.setForeground(Color.BLACK);
        passwordLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(350,400,500,32);
        passwordField.setFont(MainFrame.FONT);
        passwordField.setOpaque(false);
        passwordField.setBorder(new LineBorder(Color.BLACK));
        passwordField.setForeground(Color.BLACK);
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                passwordField.setBackground(MainFrame.PINK);
                passwordField.setOpaque(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                passwordField.setBackground(Color.WHITE);
                passwordField.setOpaque(false);
            }
        });
        char c = passwordField.getEchoChar();
        add(passwordField);

        hideAndShowButton = new JToggleButton(new ImageIcon("img/show.png"));
        hideAndShowButton.setBounds(860,400,32,32);
        hideAndShowButton.setOpaque(false);
        hideAndShowButton.setContentAreaFilled(false);
        hideAndShowButton.setFocusPainted(false);
        hideAndShowButton.setBorder(BorderFactory.createEmptyBorder());
        hideAndShowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hideAndShowButton.isSelected()) {
                    hideAndShowButton.setIcon(new ImageIcon("img/hide.png"));
                    passwordField.setEchoChar((char) 0);
                }
                else {
                    hideAndShowButton.setIcon(new ImageIcon("img/show.png"));
                    passwordField.setEchoChar(c);
                }
            }
        });
        add(hideAndShowButton);


        signInButton = new CustomButton("Sign in");
        signInButton.setBounds(350,482,175,48);
        signInButton.setFont(MainFrame.SUBTITLEFONT);
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = loginField.getText();
                String password = passwordField.getText();

                if(username.equals("") || password.equals("")){
                    JOptionPane.showMessageDialog(null,"Username and password must be not empty", "Info", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    PackageData packageData = new PackageData(Action.SIGNIN, new Client(username, password));

                    ClientRun.connectToServer(packageData);

                    if (MainFrame.clientInApp != null) {
                        ClientRun.frame.firstMenu = new FirstMenu();
                        ClientRun.frame.setContentPane(ClientRun.frame.firstMenu);
                        loginField.setText("");
                        passwordField.setText("");
                    }

                    else JOptionPane.showMessageDialog(null,"Incorrect username or password, try again", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(signInButton);

        signUpButton = new CustomButton("Sign up");
        signUpButton.setBounds(675,482,175,48);
        signUpButton.setFont(MainFrame.SUBTITLEFONT);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientRun.frame.signUpPanel = new SignUpPanel();
                ClientRun.frame.setContentPane(ClientRun.frame.signUpPanel);
            }
        });
        add(signUpButton);

        orLabel = new JLabel("Or", JLabel.CENTER);
        orLabel.setBounds(525,482,150,48);
        orLabel.setFont(MainFrame.TITLEFONT);
        orLabel.setForeground(Color.BLACK);
        orLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(orLabel);

        resetLabel = new JLabel("Don't remember password?");
        resetLabel.setBounds(350,590,250,48);
        resetLabel.setFont(MainFrame.FONT);
        resetLabel.setForeground(Color.BLACK);
        resetLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(resetLabel);

        resetPasswordButton = new CustomButton("Reset password");
        resetPasswordButton.setBounds(625,590,225,48);
        resetPasswordButton.setFont(MainFrame.SUBTITLEFONT);
        resetPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientRun.frame.resetPasswordPanel = new ResetPasswordPanel();
                ClientRun.frame.setContentPane(ClientRun.frame.resetPasswordPanel);
            }
        });
        add(resetPasswordButton);
    }
}
