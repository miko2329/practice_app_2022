package com.common;

import java.io.Serializable;

public class PackageData implements Serializable {
    private Action action;
    private Client client;
    private Currency currency;
    private double amount;
    private Long receiverCardId;
    private PaymentSystemOfCard systemOfCard;
    private Currency firstCurrency;
    private Currency secondCurrency;
    private Currency thirdCurrency;
    private Currency fourthCurrency;
    private Card card;
    private MultiCurrencyCard multiCurrencyCard;

    public PackageData() {
    }

    public PackageData(Action action, Client client) {
        this.action = action;
        this.client = client;
    }

    public PackageData(Action action, Client client, Currency currency, PaymentSystemOfCard systemOfCard) {
        this.action = action;
        this.client = client;
        this.currency = currency;
        this.systemOfCard = systemOfCard;
    }

    public PackageData(Action action, Client client, PaymentSystemOfCard systemOfCard) {
        this.action = action;
        this.client = client;
        this.systemOfCard = systemOfCard;
    }

    public PackageData(Action action, Client client, Card card) {
        this.action = action;
        this.client = client;
        this.card = card;
    }

    public PackageData(Action action, Client client, Card card, double amount, Long receiverCardId) {
        this.action = action;
        this.client = client;
        this.card = card;
        this.amount = amount;
        this.receiverCardId = receiverCardId;
    }

    public PackageData(Action action, Client client, MultiCurrencyCard multiCurrencyCard) {
        this.action = action;
        this.client = client;
        this.multiCurrencyCard = multiCurrencyCard;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public PaymentSystemOfCard getSystemOfCard() {
        return systemOfCard;
    }

    public void setSystemOfCard(PaymentSystemOfCard systemOfCard) {
        this.systemOfCard = systemOfCard;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public MultiCurrencyCard getMultiCurrencyCard() {
        return multiCurrencyCard;
    }

    public void setMultiCurrencyCard(MultiCurrencyCard multiCurrencyCard) {
        this.multiCurrencyCard = multiCurrencyCard;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getReceiverCardId() {
        return receiverCardId;
    }

    public void setReceiverCardId(Long receiverCardId) {
        this.receiverCardId = receiverCardId;
    }
}
