package com.common;

import java.io.Serializable;
import java.sql.Date;


public class MultiCurrencyCard extends Card implements Serializable {

    private double secondBalance;
    private Currency secondCurrency;
    private double thirdBalance;
    private Currency thirdCurrency;
    private double fourthBalance;
    private Currency fourthCurrency;

    public MultiCurrencyCard(Long id, double mainBalance, Currency mainCurrency, boolean activity, Integer cvcCode, PaymentSystemOfCard paymentSystem, Date dateOfCreation, Date dateOfEnd, double secondBalance, Currency secondCurrency, double thirdBalance, Currency thirdCurrency, double fourthBalance, Currency fourthCurrency) {
        super(id, mainBalance, mainCurrency, activity, cvcCode, paymentSystem, dateOfCreation, dateOfEnd);
        this.secondBalance = secondBalance;
        this.secondCurrency = secondCurrency;
        this.thirdBalance = thirdBalance;
        this.thirdCurrency = thirdCurrency;
        this.fourthBalance = fourthBalance;
        this.fourthCurrency = fourthCurrency;
    }

    public double getSecondBalance() {
        return secondBalance;
    }

    public void setSecondBalance(double secondBalance) {
        this.secondBalance = secondBalance;
    }

    public Currency getSecondCurrency() {
        return secondCurrency;
    }

    public void setSecondCurrency(Currency secondCurrency) {
        this.secondCurrency = secondCurrency;
    }

    public double getThirdBalance() {
        return thirdBalance;
    }

    public void setThirdBalance(double thirdBalance) {
        this.thirdBalance = thirdBalance;
    }

    public Currency getThirdCurrency() {
        return thirdCurrency;
    }

    public void setThirdCurrency(Currency thirdCurrency) {
        this.thirdCurrency = thirdCurrency;
    }

    public double getFourthBalance() {
        return fourthBalance;
    }

    public void setFourthBalance(double fourthBalance) {
        this.fourthBalance = fourthBalance;
    }

    public Currency getFourthCurrency() {
        return fourthCurrency;
    }

    public void setFourthCurrency(Currency fourthCurrency) {
        this.fourthCurrency = fourthCurrency;
    }
}
