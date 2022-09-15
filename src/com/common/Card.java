package com.common;

import java.io.Serializable;
import java.sql.Date;


public class Card implements Serializable {
    private Long id;
    private double mainBalance;
    private Currency mainCurrency;
    private boolean activity;
    private Integer cvcCode;
    private PaymentSystemOfCard paymentSystem;
    private Date dateOfCreation;
    private Date dateOfEnd;

    public Card(Long id, double mainBalance, Currency mainCurrency, boolean activity, Integer cvcCode, PaymentSystemOfCard paymentSystem, Date dateOfCreation, Date dateOfEnd) {
        this.id = id;
        this.mainBalance = mainBalance;
        this.mainCurrency = mainCurrency;
        this.activity = activity;
        this.cvcCode = cvcCode;
        this.paymentSystem = paymentSystem;
        this.dateOfCreation = dateOfCreation;
        this.dateOfEnd = dateOfEnd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMainBalance() {
        return mainBalance;
    }

    public void setMainBalance(double mainBalance) {
        this.mainBalance = mainBalance;
    }

    public Currency getMainCurrency() {
        return mainCurrency;
    }

    public void setMainCurrency(Currency mainCurrency) {
        this.mainCurrency = mainCurrency;
    }

    public boolean isActivity() {
        return activity;
    }

    public void setActivity(boolean activity) {
        this.activity = activity;
    }

    public Integer getCvcCode() {
        return cvcCode;
    }

    public void setCvcCode(Integer cvcCode) {
        this.cvcCode = cvcCode;
    }

    public PaymentSystemOfCard getPaymentSystem() {
        return paymentSystem;
    }

    public void setPaymentSystem(PaymentSystemOfCard paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Date getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(Date dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }
}


