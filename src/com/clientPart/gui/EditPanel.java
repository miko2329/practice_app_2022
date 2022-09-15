package com.clientPart.gui;

import com.clientPart.ClientRun;
import com.common.Action;
import com.common.Client;
import com.common.PackageData;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class EditPanel extends CustomPanel {
    private CustomButton editClientButton;
    private CustomButton editLoginButton;

    private JLabel namePanelLabel;

    private CustomButton backToLoginPanelButton;

    public EditPanel(){
        setLayout(null);

        setSize(1200,800);

        namePanelLabel = new JLabel("Edit client info and login", SwingConstants.CENTER);
        namePanelLabel.setBounds(100,90,1000, 64);
        namePanelLabel.setFont(MainFrame.SUPERTITLEFONT);
        namePanelLabel.setForeground(Color.BLACK);
        namePanelLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(namePanelLabel);

        editClientButton = new CustomButton("Edit my info");
        editClientButton.setBounds(250,338,275,48);
        editClientButton.setFont(MainFrame.SUBTITLEFONT);
        editClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientRun.frame.editClientInfo=new EditClientInfo();
                ClientRun.frame.setContentPane(ClientRun.frame.editClientInfo);
            }
        });
        add(editClientButton);

        editLoginButton = new CustomButton("Edit my login");
        editLoginButton.setBounds(675,338,275,48);
        editLoginButton.setFont(MainFrame.SUBTITLEFONT);
        editLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientRun.frame.editLoginInfo=new EditLoginInfo();
                ClientRun.frame.setContentPane(ClientRun.frame.editLoginInfo);
            }
        });
        add(editLoginButton);

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

    public static class EditClientInfo extends CustomPanel {
        private JLabel namePanelLabel;

        private CustomLabel nameLabel;
        private CustomLabel surnameLabel;
        private CustomLabel nameOfFatherLabel;
        private CustomLabel phoneNumberLabel;
        private CustomLabel dateOfBirthLabel;

        private CustomField nameField;
        private CustomField surnameField;
        private CustomField nameOfFatherField;
        private CustomField phoneNumberField;
        private CustomField dateOfBirthField;

        private CustomButton backToFirstPageButton;
        private CustomButton changeButton;

        public EditClientInfo() {
            setLayout(null);

            setSize(1200,800);

            namePanelLabel = new JLabel("Client info", SwingConstants.CENTER);
            namePanelLabel.setBounds(350,90,500, 64);
            namePanelLabel.setFont(MainFrame.SUPERTITLEFONT);
            namePanelLabel.setForeground(Color.BLACK);
            namePanelLabel.setVerticalAlignment(SwingConstants.CENTER);
            add(namePanelLabel);

            nameLabel = new CustomLabel("Name");
            nameLabel.setBounds(250,170,200,64);
            add(nameLabel);

            surnameLabel = new CustomLabel("Surname");
            surnameLabel.setBounds(250,254,200,64);
            add(surnameLabel);

            nameOfFatherLabel = new CustomLabel("Name of father");
            nameOfFatherLabel.setBounds(250,338,200,64);
            add(nameOfFatherLabel);

            phoneNumberLabel = new CustomLabel("Phone number");
            phoneNumberLabel.setBounds(250,422,200,64);
            add(phoneNumberLabel);

            dateOfBirthLabel = new CustomLabel("Date of birth");
            dateOfBirthLabel.setBounds(250,506,200,64);
            add(dateOfBirthLabel);

            nameField = new CustomField();
            nameField.setBounds(470,181,480,32);
            nameField.setText(MainFrame.clientInApp.getName());
            add(nameField);

            surnameField = new CustomField();
            surnameField.setBounds(470,265,480,32);
            surnameField.setText(MainFrame.clientInApp.getSurname());
            add(surnameField);

            nameOfFatherField = new CustomField();
            nameOfFatherField.setBounds(470,349,480,32);
            nameOfFatherField.setText(MainFrame.clientInApp.getNameOfFather());
            add(nameOfFatherField);

            phoneNumberField = new CustomField();
            phoneNumberField.setBounds(470,433,480,32);
            phoneNumberField.setText(MainFrame.clientInApp.getPhoneNumber());
            add(phoneNumberField);

            dateOfBirthField = new CustomField();
            dateOfBirthField.setBounds(470,517,480,32);
            dateOfBirthField.setText(String.valueOf(MainFrame.clientInApp.getDateOfBirth()));
            add(dateOfBirthField);

            backToFirstPageButton = new CustomButton("Back");
            backToFirstPageButton.setBounds(250,600,275,48);
            backToFirstPageButton.setFont(MainFrame.SUBTITLEFONT);
            backToFirstPageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ClientRun.frame.setContentPane(ClientRun.frame.editPanel);
                }
            });
            add(backToFirstPageButton);

            changeButton = new CustomButton("Update");
            changeButton.setBounds(675,600,275,48);
            changeButton.setFont(MainFrame.SUBTITLEFONT);
            changeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Long id = MainFrame.clientInApp.getId();
                    String name = nameField.getText();
                    String surname = surnameField.getText();
                    String nameOfFather = nameOfFatherField.getText();
                    String phoneNumber = phoneNumberField.getText();
                    Date dateOfBirth = Date.valueOf(dateOfBirthField.getText());

                    if(name.equals("") || surname.equals("") || nameOfFather.equals("") || phoneNumber.equals("") || dateOfBirth.equals("")){
                        JOptionPane.showMessageDialog(null,"All fields must be not empty\n"+
                                "Phone number must be in +7 7XX XXX XXXX form\n"+
                                "Date of birth must be in YYYY-MM-DD form", "Info", JOptionPane.INFORMATION_MESSAGE);
                    } else if (phoneNumber.length()!=12 || !phoneNumber.startsWith("+77") ||
                            dateOfBirthField.getText().length()!=10 || dateOfBirthField.getText().charAt(4)!='-' ||
                            dateOfBirthField.getText().charAt(7)!='-') {
                        JOptionPane.showMessageDialog(null,"Phone number must be in +7 7XX XXX XXXX form\n"+
                                "Date of birth must be in YYYY-MM-DD form", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        PackageData packageData = new PackageData(Action.EDITCLIENTINFO, new Client(id,name,surname,nameOfFather,phoneNumber,dateOfBirth));

                        ClientRun.connectToServer(packageData);

                        if (MainFrame.beforeUpdate!=null && MainFrame.beforeUpdate!=MainFrame.clientInApp) {
                            JOptionPane.showMessageDialog(null,"You updated client info successfully", "Successfully updated", JOptionPane.INFORMATION_MESSAGE);

                            nameField.setText(MainFrame.clientInApp.getName());
                            surnameField.setText(MainFrame.clientInApp.getSurname());
                            nameOfFatherField.setText(MainFrame.clientInApp.getNameOfFather());
                            phoneNumberField.setText(MainFrame.clientInApp.getPhoneNumber());
                            dateOfBirthField.setText(String.valueOf(MainFrame.clientInApp.getDateOfBirth()));

                        } else JOptionPane.showMessageDialog(null,"Update client info failed, try again late", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            add(changeButton);
        }
    }

    public static class EditLoginInfo extends CustomPanel {

        private JLabel namePanelLabel;
        private CustomLabel usernameLabel;
        private CustomLabel passwordLabel;
        private CustomLabel passwordConfirmLabel;
        private CustomLabel resetQuestionLabel;
        private CustomLabel resetAnswerLabel;

        private CustomField usernameField;
        private CustomField passwordField;
        private CustomField passwordConfirmField;
        private CustomField resetQuestionField;
        private CustomField resetAnswerField;

        private CustomButton backToFirstPageButton;
        private CustomButton changeButton;

        public EditLoginInfo() {
            setLayout(null);

            setSize(1200,800);

            namePanelLabel = new JLabel("Login info", SwingConstants.CENTER);
            namePanelLabel.setBounds(350,90,500, 64);
            namePanelLabel.setFont(MainFrame.SUPERTITLEFONT);
            namePanelLabel.setForeground(Color.BLACK);
            namePanelLabel.setVerticalAlignment(SwingConstants.CENTER);
            add(namePanelLabel);

            usernameLabel = new CustomLabel("Username");
            usernameLabel.setBounds(250,170,200,64);
            add(usernameLabel);

            passwordLabel = new CustomLabel("Password");
            passwordLabel.setBounds(250,254,200,64);
            add(passwordLabel);

            passwordConfirmLabel = new CustomLabel("Retype password");
            passwordConfirmLabel.setBounds(250,338,200,64);
            add(passwordConfirmLabel);

            resetQuestionLabel = new CustomLabel("Reset question");
            resetQuestionLabel.setBounds(250,422,200,64);
            add(resetQuestionLabel);

            resetAnswerLabel = new CustomLabel("Reset answer");
            resetAnswerLabel.setBounds(250,506,200,64);
            add(resetAnswerLabel);

            usernameField = new CustomField();
            usernameField.setBounds(470,181,480,32);
            usernameField.setText(MainFrame.clientInApp.getUsername());
            add(usernameField);

            passwordField = new CustomField();
            passwordField.setBounds(470,265,480,32);
            passwordField.setText(MainFrame.clientInApp.getPassword());
            add(passwordField);

            passwordConfirmField = new CustomField();
            passwordConfirmField.setBounds(470,349,480,32);
            passwordConfirmField.setText(MainFrame.clientInApp.getPassword());
            add(passwordConfirmField);

            resetQuestionField = new CustomField();
            resetQuestionField.setBounds(470,433,480,32);
            resetQuestionField.setText(MainFrame.clientInApp.getResetQuestion());
            add(resetQuestionField);

            resetAnswerField = new CustomField();
            resetAnswerField.setBounds(470,517,480,32);
            resetAnswerField.setText(MainFrame.clientInApp.getResetAnswer());
            add(resetAnswerField);

            backToFirstPageButton = new CustomButton("Back");
            backToFirstPageButton.setBounds(250,600,275,48);
            backToFirstPageButton.setFont(MainFrame.SUBTITLEFONT);
            backToFirstPageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ClientRun.frame.setContentPane(ClientRun.frame.editPanel);
                }
            });
            add(backToFirstPageButton);

            changeButton = new CustomButton("Update");
            changeButton.setBounds(675,600,275,48);
            changeButton.setFont(MainFrame.SUBTITLEFONT);
            changeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
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
                        PackageData packageData = new PackageData(Action.EDITLOGININFO, new Client(MainFrame.clientInApp.getId(),username,password,resetQuestion,resetAnswer));

                        ClientRun.connectToServer(packageData);

                        if (MainFrame.beforeUpdate!=null && MainFrame.beforeUpdate!=MainFrame.clientInApp) {
                            JOptionPane.showMessageDialog(null,"You updated login info successfully", "Successfully updated", JOptionPane.INFORMATION_MESSAGE);

                            usernameField.setText(MainFrame.clientInApp.getUsername());
                            passwordField.setText(MainFrame.clientInApp.getPassword());
                            passwordConfirmField.setText(MainFrame.clientInApp.getPassword());
                            resetQuestionField.setText(MainFrame.clientInApp.getResetQuestion());
                            resetAnswerField.setText(String.valueOf(MainFrame.clientInApp.getResetAnswer()));

                        } else JOptionPane.showMessageDialog(null,"Update login info failed, try again late\n" +
                                "If there no problems with connection, the must be not unique username", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                }
            });
            add(changeButton);
        }
    }
}
