package com.serverPart;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.common.Client;
import com.common.DBManager;
import com.common.PackageData;

public class ServerThread extends Thread {

    public Socket socket;

    public ServerThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            DBManager.connectToDB();

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            PackageData packageData = null;
            while((packageData=(PackageData)inputStream.readObject())!=null) {
                switch (packageData.getAction()) {
                    case SIGNIN:
                        Client clientToApp = DBManager.signIn(packageData.getClient());
                        outputStream.writeObject(clientToApp);
                        break;
                    case SIGNUP:
                        Boolean answerToSignUp = DBManager.signUp(packageData.getClient());
                        outputStream.writeObject(answerToSignUp);
                        break;
                    case CHANGEPASSWORD:
                        Boolean answerChange = DBManager.changePassword(packageData.getClient());
                        outputStream.writeObject(answerChange);
                        break;
                    case EDITCLIENTINFO:
                        Client updatedClientInfo = DBManager.updateClientInfo(packageData.getClient());
                        outputStream.writeObject(updatedClientInfo);
                        break;
                    case EDITLOGININFO:
                        Client updatedLoginInfo = DBManager.updateLoginInfo(packageData.getClient());
                        outputStream.writeObject(updatedLoginInfo);
                        break;
                    case CREATESIMPLECARD:
                        Client client = DBManager.createSimpleCard(packageData);
                        outputStream.writeObject(client);
                        break;
                    case CREATEMULTICARD:
                        Client client1 = DBManager.createMultiCard(packageData);
                        outputStream.writeObject(client1);
                        break;
                    case MAKEPRIORITYCARD:
                        Boolean priorityAnswerC = DBManager.makePriorityC(packageData);
                        outputStream.writeObject(priorityAnswerC);
                        break;
                    case DEACTIVATECARD:
                        Boolean deactivateAnswerC = DBManager.deactivateC(packageData);
                        outputStream.writeObject(deactivateAnswerC);
                        break;
                    case DELETECARD:
                        Boolean deleteAnswerC = DBManager.deleteC(packageData);
                        outputStream.writeObject(deleteAnswerC);
                        break;
                    case MAKEPRIORITYMCARD:
                        Boolean priorityAnswerMC = DBManager.makePriorityMC(packageData);
                        outputStream.writeObject(priorityAnswerMC);
                        break;
                    case DEACTIVATEMCARD:
                        Boolean deactivateAnswerMC = DBManager.deactivateMC(packageData);
                        outputStream.writeObject(deactivateAnswerMC);
                        break;
                    case DELETEMCARD:
                        Boolean deleteAnswerMC = DBManager.deleteMC(packageData);
                        outputStream.writeObject(deleteAnswerMC);
                        break;
                    case TRANSFERCARD:
                        Boolean transferAnswer = DBManager.transferCard(packageData);
                        outputStream.writeObject(transferAnswer);
                        break;
                }
            }

            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
