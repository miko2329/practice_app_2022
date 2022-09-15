package com.common;

public class ExchangeCurrency {
    public static double USDtoKZT;
    public static double EURtoKZT;
    public static double RUBtoKZT;

    public static double exchangeToKZT(Currency currency, double amount) {
        double kzt = 0;

        switch (currency) {
            case USD:
                kzt = amount*USDtoKZT;
                break;

            case EUR:
                kzt = amount*EURtoKZT;
                break;

            case RUB:
                kzt = amount*RUBtoKZT;
                break;
        }

        return kzt;
    }

    public static double exchangeToUSD(Currency currency, double amount) {
        double usd = 0;

        switch (currency) {
            case KZT:
                usd = amount/USDtoKZT;
                break;

            case EUR:
                usd = (amount*EURtoKZT)/USDtoKZT;
                break;

            case RUB:
                usd = (amount*RUBtoKZT)/USDtoKZT;
                break;
        }

        return usd;
    }

    public static double exchangeToEUR(Currency currency, double amount) {
        double eur = 0;

        switch (currency) {
            case KZT:
                eur = amount/EURtoKZT;
                break;

            case USD:
                eur = (amount*USDtoKZT)/EURtoKZT;
                break;

            case RUB:
                eur = (amount*RUBtoKZT)/EURtoKZT;
                break;
        }

        return eur;
    }

    public static double exchangeToRUB(Currency currency, double amount) {
        double rub = 0;

        switch (currency) {
            case KZT:
                rub = amount/RUBtoKZT;
                break;

            case USD:
                rub = (amount*USDtoKZT)/RUBtoKZT;
                break;

            case RUB:
                rub = (amount*EURtoKZT)/RUBtoKZT;
                break;
        }

        return rub;
    }
}

