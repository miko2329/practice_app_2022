package com.clientPart.gui;

import com.clientPart.ClientRun;
import com.common.Action;
import com.common.Client;
import com.common.PackageData;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SignUpPanel extends CustomPanel {

    private JLabel namePanelLabel;
    private CustomLabel nameLabel;
    private CustomLabel surnameLabel;
    private CustomLabel nameOfFatherLabel;
    private CustomLabel phoneNumberLabel;
    private CustomLabel dateOfBirthLabel;
    private CustomLabel usernameLabel;
    private CustomLabel passwordLabel;
    private CustomLabel passwordConfirmLabel;
    private CustomLabel resetQuestionLabel;
    private CustomLabel resetAnswerLabel;

    private CustomField nameField;
    private CustomField surnameField;
    private CustomField nameOfFatherField;
    private CustomField phoneNumberField;
    private CustomField dateOfBirthField;
    private CustomField usernameField;
    private CustomField passwordField;
    private CustomField passwordConfirmField;
    private CustomField resetQuestionField;
    private CustomField resetAnswerField;

    private CustomButton backToLoginPanelButton;
    private CustomButton backToFirstPageButton;
    private CustomButton moveToSecondPageButton;
    private CustomButton registerButton;

    public SignUpPanel() {
        setLayout(null);

        setSize(1200,800);

        namePanelLabel = new JLabel("Sign up", SwingConstants.CENTER);
        namePanelLabel.setBounds(350,90,500, 64);
        namePanelLabel.setFont(MainFrame.SUPERTITLEFONT);
        namePanelLabel.setForeground(Color.BLACK);
        namePanelLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(namePanelLabel);

        nameLabel = new CustomLabel("Name");
        nameLabel.setBounds(250,170,200,64);
        add(nameLabel);

        usernameLabel = new CustomLabel("Username");
        usernameLabel.setBounds(250,170,200,64);
        usernameLabel.setVisible(false);
        add(usernameLabel);

        surnameLabel = new CustomLabel("Surname");
        surnameLabel.setBounds(250,254,200,64);
        add(surnameLabel);

        passwordLabel = new CustomLabel("Password");
        passwordLabel.setBounds(250,254,200,64);
        passwordLabel.setVisible(false);
        add(passwordLabel);

        nameOfFatherLabel = new CustomLabel("Name of father");
        nameOfFatherLabel.setBounds(250,338,200,64);
        add(nameOfFatherLabel);

        passwordConfirmLabel = new CustomLabel("Retype password");
        passwordConfirmLabel.setBounds(250,338,200,64);
        passwordConfirmLabel.setVisible(false);
        add(passwordConfirmLabel);

        phoneNumberLabel = new CustomLabel("Phone number");
        phoneNumberLabel.setBounds(250,422,200,64);
        add(phoneNumberLabel);

        resetQuestionLabel = new CustomLabel("Reset question");
        resetQuestionLabel.setBounds(250,422,200,64);
        resetQuestionLabel.setVisible(false);
        add(resetQuestionLabel);

        dateOfBirthLabel = new CustomLabel("Date of birth");
        dateOfBirthLabel.setBounds(250,506,200,64);
        add(dateOfBirthLabel);

        resetAnswerLabel = new CustomLabel("Reset answer");
        resetAnswerLabel.setBounds(250,506,200,64);
        resetAnswerLabel.setVisible(false);
        add(resetAnswerLabel);

        nameField = new CustomField();
        nameField.setBounds(470,181,480,32);
        add(nameField);

        usernameField = new CustomField();
        usernameField.setBounds(470,181,480,32);
        usernameField.setVisible(false);
        add(usernameField);

        surnameField = new CustomField();
        surnameField.setBounds(470,265,480,32);
        add(surnameField);

        passwordField = new CustomField();
        passwordField.setBounds(470,265,480,32);
        passwordField.setVisible(false);
        add(passwordField);

        nameOfFatherField = new CustomField();
        nameOfFatherField.setBounds(470,349,480,32);
        add(nameOfFatherField);

        passwordConfirmField = new CustomField();
        passwordConfirmField.setBounds(470,349,480,32);
        passwordConfirmField.setVisible(false);
        add(passwordConfirmField);

        phoneNumberField = new CustomField();
        phoneNumberField.setBounds(470,433,480,32);
        add(phoneNumberField);

        resetQuestionField = new CustomField();
        resetQuestionField.setBounds(470,433,480,32);
        resetQuestionField.setVisible(false);
        add(resetQuestionField);

        dateOfBirthField = new CustomField();
        dateOfBirthField.setBounds(470,517,480,32);
        add(dateOfBirthField);

        resetAnswerField = new CustomField();
        resetAnswerField.setBounds(470,517,480,32);
        resetAnswerField.setVisible(false);
        add(resetAnswerField);

        backToLoginPanelButton = new CustomButton("Back to Login page");
        backToLoginPanelButton.setBounds(250,600,275,48);
        backToLoginPanelButton.setFont(MainFrame.SUBTITLEFONT);
        backToLoginPanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientRun.frame.setContentPane(ClientRun.frame.loginPanel);

                nameField.setText("");
                surnameField.setText("");
                nameOfFatherField.setText("");
                phoneNumberField.setText("");
                dateOfBirthField.setText("");

                usernameField.setText("");
                passwordField.setText("");
                passwordConfirmField.setText("");
                resetQuestionField.setText("");
                resetAnswerField.setText("");
            }
        });
        add(backToLoginPanelButton);

        backToFirstPageButton = new CustomButton("Back to first page");
        backToFirstPageButton.setBounds(250,600,275,48);
        backToFirstPageButton.setFont(MainFrame.SUBTITLEFONT);
        backToFirstPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameLabel.setVisible(true);
                surnameLabel.setVisible(true);
                nameOfFatherLabel.setVisible(true);
                phoneNumberLabel.setVisible(true);
                dateOfBirthLabel.setVisible(true);

                usernameLabel.setVisible(false);
                passwordLabel.setVisible(false);
                passwordConfirmLabel.setVisible(false);
                resetQuestionLabel.setVisible(false);
                resetAnswerLabel.setVisible(false);

                nameField.setVisible(true);
                surnameField.setVisible(true);
                nameOfFatherField.setVisible(true);
                phoneNumberField.setVisible(true);
                dateOfBirthField.setVisible(true);

                usernameField.setVisible(false);
                passwordField.setVisible(false);
                passwordConfirmField.setVisible(false);
                resetQuestionField.setVisible(false);
                resetAnswerField.setVisible(false);

                backToLoginPanelButton.setVisible(true);
                moveToSecondPageButton.setVisible(true);

                backToFirstPageButton.setVisible(false);
                registerButton.setVisible(false);
            }
        });
        backToFirstPageButton.setVisible(false);
        add(backToFirstPageButton);

        moveToSecondPageButton = new CustomButton("Next page");
        moveToSecondPageButton.setBounds(675,600,275,48);
        moveToSecondPageButton.setFont(MainFrame.SUBTITLEFONT);
        moveToSecondPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String surname = surnameField.getText();
                String nameOfFather = nameOfFatherField.getText();
                String phoneNumber = phoneNumberField.getText();
                String dateOfBirth = dateOfBirthField.getText();

                if(name.equals("") || surname.equals("") || nameOfFather.equals("") || phoneNumber.equals("") || dateOfBirth.equals("")){
                    JOptionPane.showMessageDialog(null,"All fields must be not empty\n"+
                            "Phone number must be in +7 7XX XXX XXXX form\n"+
                            "Date of birth must be in YYYY-MM-DD form", "Info", JOptionPane.INFORMATION_MESSAGE);
                } else if (phoneNumber.length()!=12 || !phoneNumber.startsWith("+77") ||
                        dateOfBirth.length()!=10 || dateOfBirth.charAt(4)!='-' ||
                        dateOfBirth.charAt(7)!='-') {
                    JOptionPane.showMessageDialog(null,"Phone number must be in +7 7XX XXX XXXX form\n"+
                            "Date of birth must be in YYYY-MM-DD form", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    nameLabel.setVisible(false);
                    surnameLabel.setVisible(false);
                    nameOfFatherLabel.setVisible(false);
                    phoneNumberLabel.setVisible(false);
                    dateOfBirthLabel.setVisible(false);

                    usernameLabel.setVisible(true);
                    passwordLabel.setVisible(true);
                    passwordConfirmLabel.setVisible(true);
                    resetQuestionLabel.setVisible(true);
                    resetAnswerLabel.setVisible(true);

                    nameField.setVisible(false);
                    surnameField.setVisible(false);
                    nameOfFatherField.setVisible(false);
                    phoneNumberField.setVisible(false);
                    dateOfBirthField.setVisible(false);

                    usernameField.setVisible(true);
                    passwordField.setVisible(true);
                    passwordConfirmField.setVisible(true);
                    resetQuestionField.setVisible(true);
                    resetAnswerField.setVisible(true);

                    backToLoginPanelButton.setVisible(false);
                    moveToSecondPageButton.setVisible(false);

                    backToFirstPageButton.setVisible(true);
                    registerButton.setVisible(true);
                }
            }
        });
        add(moveToSecondPageButton);

        registerButton = new CustomButton("Register");
        registerButton.setBounds(675,600,275,48);
        registerButton.setFont(MainFrame.SUBTITLEFONT);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                String surname = surnameField.getText();
                String nameOfFather = nameOfFatherField.getText();
                String phoneNumber = phoneNumberField.getText();
                Date dateOfBirth = Date.valueOf(dateOfBirthField.getText());
                String username = usernameField.getText();
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
                    PackageData packageData = new PackageData(Action.SIGNUP, new Client(null,name,surname,nameOfFather,phoneNumber,dateOfBirth,username,password,resetQuestion,resetAnswer));

                    ClientRun.connectToServer(packageData);

                    if (MainFrame.signUpAnswer==true) {
                        JOptionPane.showMessageDialog(null,"You signed up successfully", "Successfully signed up", JOptionPane.INFORMATION_MESSAGE);
                        ClientRun.frame.setContentPane(ClientRun.frame.loginPanel);

                        nameField.setText("");
                        surnameField.setText("");
                        nameOfFatherField.setText("");
                        phoneNumberField.setText("");
                        dateOfBirthField.setText("");

                        usernameField.setText("");
                        passwordField.setText("");
                        passwordConfirmField.setText("");
                        resetQuestionField.setText("");
                        resetAnswerField.setText("");
                    }

                    else JOptionPane.showMessageDialog(null,"Sign up failed, try again late", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        registerButton.setVisible(false);
        add(registerButton);
    }
}
