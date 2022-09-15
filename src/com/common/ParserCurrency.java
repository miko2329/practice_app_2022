package com.common;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.URL;

public class ParserCurrency {

    public static String source;

    public static void getExchangeRate() {
        try {
            String url = "https://finance.kapital.kz/";
            Document page = Jsoup.parse(new URL(url),10000);

            Element transferTable = page.selectFirst("table[class=currencies-table]");
            Element tbody = transferTable.selectFirst("tbody");
            Elements trs = tbody.select("tr");

            double currencies[] = new double[3];

            for(int i=0; i<3; i++){
                String s = trs.get(i).select("td").get(3).selectFirst("span").text();

                currencies[i] = Double.parseDouble(s);
            }

            ExchangeCurrency.USDtoKZT = currencies[0];
            ExchangeCurrency.EURtoKZT = currencies[1];
            ExchangeCurrency.RUBtoKZT = currencies[2];

            source = "Currency exchange rates are taken from the https://finance.kapital.kz";
        } catch (IOException e) {
            source = "Currency exchange rates are temporarily unavailable";
        }
    }
}

