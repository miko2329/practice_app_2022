package com.clientPart;

import com.clientPart.gui.MainFrame;
import com.common.Client;
import com.common.PackageData;
import com.common.ParserCurrency;
import com.sun.tools.javac.Main;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientRun {
    public static MainFrame frame;

    public static void main(String[] args) {
        System.setProperty("sun.java2d.uiScale", "1.0");
        frame = new MainFrame();
        frame.setVisible(true);
    }

    public static void connectToServer(PackageData packageData){
        try {
            Socket socket = new Socket("127.0.0.1", 8888);

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            switch (packageData.getAction()){
                case SIGNIN:
                    outputStream.writeObject(packageData);
                    Client clientFromServer = (Client) inputStream.readObject();
                    MainFrame.clientInApp = clientFromServer;
                    break;
                case SIGNUP:
                    outputStream.writeObject(packageData);
                    Boolean answerFromServerSignUp = (Boolean) inputStream.readObject();
                    MainFrame.signUpAnswer = answerFromServerSignUp;
                    break;
                case CHANGEPASSWORD:
                    outputStream.writeObject(packageData);
                    Boolean changePassword = (Boolean) inputStream.readObject();
                    MainFrame.changePasswordAnswer = changePassword;
                    break;
                case EDITCLIENTINFO:
                    outputStream.writeObject(packageData);
                    Client updatedClientInfo = (Client) inputStream.readObject();
                    MainFrame.beforeUpdate=MainFrame.clientInApp;
                    MainFrame.clientInApp=updatedClientInfo;
                    break;
                case EDITLOGININFO:
                    outputStream.writeObject(packageData);
                    Client updatedLoginInfo = (Client) inputStream.readObject();
                    MainFrame.beforeUpdate=MainFrame.clientInApp;
                    MainFrame.clientInApp=updatedLoginInfo;
                    break;
                case CREATESIMPLECARD:
                    outputStream.writeObject(packageData);
                    Client simpleCardClient = (Client) inputStream.readObject();
                    MainFrame.beforeUpdate=MainFrame.clientInApp;
                    MainFrame.clientInApp=simpleCardClient;
                    break;
                case CREATEMULTICARD:
                    outputStream.writeObject(packageData);
                    Client multiCardClient = (Client) inputStream.readObject();
                    MainFrame.beforeUpdate=MainFrame.clientInApp;
                    MainFrame.clientInApp=multiCardClient;
                    break;
                case MAKEPRIORITYCARD:
                    outputStream.writeObject(packageData);
                    Boolean priorityAnswerC = (Boolean) inputStream.readObject();
                    MainFrame.makePriorityAnswer = priorityAnswerC;
                    break;
                case DEACTIVATECARD:
                    outputStream.writeObject(packageData);
                    Boolean deactivateAnswerC = (Boolean) inputStream.readObject();
                    MainFrame.deactivateAnswer = deactivateAnswerC;
                    break;
                case DELETECARD:
                    outputStream.writeObject(packageData);
                    Boolean deleteAnswerC = (Boolean) inputStream.readObject();
                    MainFrame.deleteAnswer = deleteAnswerC;
                    break;
                case MAKEPRIORITYMCARD:
                    outputStream.writeObject(packageData);
                    Boolean priorityAnswerMC = (Boolean) inputStream.readObject();
                    MainFrame.makePriorityAnswer = priorityAnswerMC;
                    break;
                case DEACTIVATEMCARD:
                    outputStream.writeObject(packageData);
                    Boolean deactivateAnswerMC = (Boolean) inputStream.readObject();
                    MainFrame.deactivateAnswer = deactivateAnswerMC;
                    break;
                case DELETEMCARD:
                    outputStream.writeObject(packageData);
                    Boolean deleteAnswerMC = (Boolean) inputStream.readObject();
                    MainFrame.deleteAnswer = deleteAnswerMC;
                    break;
                case TRANSFERCARD:
                    outputStream.writeObject(packageData);
                    Boolean transferAnswer = (Boolean) inputStream.readObject();
                    MainFrame.transferAnswer = transferAnswer;
                    break;
            }

            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
