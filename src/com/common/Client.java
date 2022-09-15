package com.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Date;

public class Client implements Serializable {
    private Long id;
    private String name;
    private String surname;
    private String nameOfFather;
    private String phoneNumber;
    private Date dateOfBirth;
    private String username;
    private String password;
    private String resetQuestion;
    private String resetAnswer;
    private ArrayList<Card> cards = new ArrayList<Card>();
    private ArrayList<MultiCurrencyCard> multiCurrencyCards = new ArrayList<MultiCurrencyCard>();

    public Client() {
    }

    public Client(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Client(String username, String password, String resetQuestion, String resetAnswer) {
        this.username = username;
        this.password = password;
        this.resetQuestion = resetQuestion;
        this.resetAnswer = resetAnswer;
    }

    public Client(Long id, String name, String surname, String nameOfFather, String phoneNumber, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nameOfFather = nameOfFather;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public Client(Long id, String username, String password, String resetQuestion, String resetAnswer) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.resetQuestion = resetQuestion;
        this.resetAnswer = resetAnswer;
    }

    public Client(Long id, String name, String surname, String nameOfFather, String phoneNumber, Date dateOfBirth, String username, String password, String resetQuestion, String resetAnswer, ArrayList<Card> cards, ArrayList<MultiCurrencyCard> multiCurrencyCards) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nameOfFather = nameOfFather;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.password = password;
        this.resetQuestion = resetQuestion;
        this.resetAnswer = resetAnswer;
        this.cards = cards;
        this.multiCurrencyCards = multiCurrencyCards;
    }

    public Client(Long id, String name, String surname, String nameOfFather, String phoneNumber, Date dateOfBirth, String username, String password, String resetQuestion, String resetAnswer) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nameOfFather = nameOfFather;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.password = password;
        this.resetQuestion = resetQuestion;
        this.resetAnswer = resetAnswer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNameOfFather() {
        return nameOfFather;
    }

    public void setNameOfFather(String nameOfFather) {
        this.nameOfFather = nameOfFather;
    }

    public String getFullName() {
        return name+" "+surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResetQuestion() {
        return resetQuestion;
    }

    public void setResetQuestion(String resetQuestion) {
        this.resetQuestion = resetQuestion;
    }

    public String getResetAnswer() {
        return resetAnswer;
    }

    public void setResetAnswer(String resetAnswer) {
        this.resetAnswer = resetAnswer;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<MultiCurrencyCard> getMultiCurrencyCards() {
        return multiCurrencyCards;
    }

    public void setMultiCurrencyCards(ArrayList<MultiCurrencyCard> multiCurrencyCards) {
        this.multiCurrencyCards = multiCurrencyCards;
    }

    public double getTotalKZT(){
        double kzt = 0;

        for(Card card: cards) {
            if(card.getMainCurrency()==Currency.KZT) kzt+=card.getMainBalance();
        }

        for (MultiCurrencyCard multiCurrencyCard: multiCurrencyCards) {
            if(multiCurrencyCard.getMainCurrency()==Currency.KZT) kzt+=multiCurrencyCard.getMainBalance();
            else if (multiCurrencyCard.getSecondCurrency()==Currency.KZT) kzt+=multiCurrencyCard.getSecondBalance();
            else if (multiCurrencyCard.getThirdCurrency()==Currency.KZT) kzt+=multiCurrencyCard.getThirdBalance();
            else if (multiCurrencyCard.getFourthCurrency()==Currency.KZT) kzt+=multiCurrencyCard.getFourthBalance();
        }

        return kzt;
    }

    public double getTotalUSD(){
        double usd = 0;

        for(Card card: cards) {
            if(card.getMainCurrency()==Currency.USD) usd+=card.getMainBalance();
        }

        for (MultiCurrencyCard multiCurrencyCard: multiCurrencyCards) {
            if(multiCurrencyCard.getMainCurrency()==Currency.USD) usd+=multiCurrencyCard.getMainBalance();
            else if (multiCurrencyCard.getSecondCurrency()==Currency.USD) usd+=multiCurrencyCard.getSecondBalance();
            else if (multiCurrencyCard.getThirdCurrency()==Currency.USD) usd+=multiCurrencyCard.getThirdBalance();
            else if (multiCurrencyCard.getFourthCurrency()==Currency.USD) usd+=multiCurrencyCard.getFourthBalance();
        }

        return usd;
    }

    public double getTotalEUR(){
        double eur = 0;

        for(Card card: cards) {
            if(card.getMainCurrency()==Currency.EUR) eur+=card.getMainBalance();
        }

        for (MultiCurrencyCard multiCurrencyCard: multiCurrencyCards) {
            if(multiCurrencyCard.getMainCurrency()==Currency.EUR) eur+=multiCurrencyCard.getMainBalance();
            else if (multiCurrencyCard.getSecondCurrency()==Currency.EUR) eur+=multiCurrencyCard.getSecondBalance();
            else if (multiCurrencyCard.getThirdCurrency()==Currency.EUR) eur+=multiCurrencyCard.getThirdBalance();
            else if (multiCurrencyCard.getFourthCurrency()==Currency.EUR) eur+=multiCurrencyCard.getFourthBalance();
        }

        return eur;
    }

    public double getTotalRUB(){
        double rub = 0;

        for(Card card: cards) {
            if(card.getMainCurrency()==Currency.RUB) rub+=card.getMainBalance();
        }

        for (MultiCurrencyCard multiCurrencyCard: multiCurrencyCards) {
            if(multiCurrencyCard.getMainCurrency()==Currency.RUB) rub+=multiCurrencyCard.getMainBalance();
            else if (multiCurrencyCard.getSecondCurrency()==Currency.RUB) rub+=multiCurrencyCard.getSecondBalance();
            else if (multiCurrencyCard.getThirdCurrency()==Currency.RUB) rub+=multiCurrencyCard.getThirdBalance();
            else if (multiCurrencyCard.getFourthCurrency()==Currency.RUB) rub+=multiCurrencyCard.getFourthBalance();
        }

        return rub;
    }
}

