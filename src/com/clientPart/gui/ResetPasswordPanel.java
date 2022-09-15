package com.clientPart.gui;

import com.clientPart.ClientRun;
import com.common.Action;
import com.common.Client;
import com.common.PackageData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetPasswordPanel extends CustomPanel {
    private JLabel namePanelLabel;

    private CustomLabel loginLabel;
    private CustomLabel resetQuestionLabel;
    private CustomLabel resetAnswerLabel;
    private CustomLabel passwordLabel;
    private CustomLabel passwordConfirmLabel;

    private CustomField loginField;
    private CustomField resetQuestionField;
    private CustomField resetAnswerField;
    private CustomField passwordField;
    private CustomField passwordConfirmField;

    private CustomButton backToLoginPanelButton;
    private CustomButton changeButton;

    public ResetPasswordPanel(){
        setLayout(null);

        setSize(1200,800);

        namePanelLabel = new JLabel("Reset password", SwingConstants.CENTER);
        namePanelLabel.setBounds(350,90,500, 64);
        namePanelLabel.setFont(MainFrame.SUPERTITLEFONT);
        namePanelLabel.setForeground(Color.BLACK);
        namePanelLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(namePanelLabel);

        loginLabel = new CustomLabel("Username");
        loginLabel.setBounds(250,170,200,64);
        add(loginLabel);

        resetQuestionLabel = new CustomLabel("Reset question");
        resetQuestionLabel.setBounds(250,254,200,64);
        add(resetQuestionLabel);

        resetAnswerLabel = new CustomLabel("Reset answer");
        resetAnswerLabel.setBounds(250,338,200,64);
        add(resetAnswerLabel);

        passwordLabel = new CustomLabel("New password");
        passwordLabel.setBounds(250,422,200,64);
        add(passwordLabel);

        passwordConfirmLabel = new CustomLabel("Retype password");
        passwordConfirmLabel.setBounds(250,506,200,64);
        add(passwordConfirmLabel);

        loginField = new CustomField();
        loginField.setBounds(470,181,480,32);
        add(loginField);

        resetQuestionField = new CustomField();
        resetQuestionField.setBounds(470,265,480,32);
        add(resetQuestionField);

        resetAnswerField = new CustomField();
        resetAnswerField.setBounds(470,349,480,32);
        add(resetAnswerField);

        passwordField = new CustomField();
        passwordField.setBounds(470,433,480,32);
        add(passwordField);

        passwordConfirmField = new CustomField();
        passwordConfirmField.setBounds(470,517,480,32);
        add(passwordConfirmField);

        backToLoginPanelButton = new CustomButton("Back to Login page");
        backToLoginPanelButton.setBounds(250,600,275,48);
        backToLoginPanelButton.setFont(MainFrame.SUBTITLEFONT);
        backToLoginPanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientRun.frame.setContentPane(ClientRun.frame.loginPanel);

                loginField.setText("");
                passwordField.setText("");
                passwordConfirmField.setText("");
                resetQuestionField.setText("");
                resetAnswerField.setText("");
            }
        });
        add(backToLoginPanelButton);

        changeButton = new CustomButton("Change password");
        changeButton.setBounds(675,600,275,48);
        changeButton.setFont(MainFrame.SUBTITLEFONT);
        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = loginField.getText();
                String password = passwordField.getText();
                String confirmPassword = passwordConfirmField.getText();
                String resetQuestion = resetQuestionField.getText();
                String resetAnswer = resetAnswerField.getText();

                if(username.equals("") || password.equals("") || confirmPassword.equals("") ||
                        resetQuestion.equals("") || resetAnswer.equals("")){
                    JOptionPane.showMessageDialog(null,"All fields must be not empty", "Info", JOptionPane.INFORMATION_MESSAGE);
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null,"Password and retype password must be same", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    PackageData packageData = new PackageData(Action.CHANGEPASSWORD, new Client(username,password,resetQuestion,resetAnswer));

                    ClientRun.connectToServer(packageData);

                    if (MainFrame.changePasswordAnswer==true) {
                        JOptionPane.showMessageDialog(null,"You changed password successfully", "Successfully change", JOptionPane.INFORMATION_MESSAGE);
                        ClientRun.frame.setContentPane(ClientRun.frame.loginPanel);

                        loginField.setText("");
                        passwordField.setText("");
                        passwordConfirmField.setText("");
                        resetQuestionField.setText("");
                        resetAnswerField.setText("");
                    }

                    else JOptionPane.showMessageDialog(null,"Password change failed, try again late", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(changeButton);
    }
}
