package com.common;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;

public class DBManager {
    public static final String url = "jdbc:postgresql://localhost/Bank";
    public static final String user = "postgres";
    public static final String password = "72740304w";
    public static Connection connection;

    public static Currency StrToCur(String str){
        if(str.equals("KZT")) return Currency.KZT;
        else if (str.equals("USD")) return Currency.USD;
        else if (str.equals("EUR")) return Currency.EUR;
        else if (str.equals("RUB")) return Currency.RUB;
        return null;
    }

    public static String CurToStr(Currency currency){
        if(currency==Currency.KZT) return "KZT";
        else if(currency==Currency.USD) return "USD";
        else if(currency==Currency.EUR) return "EUR";
        else if(currency==Currency.RUB) return "RUB";
        return null;
    }

    public static PaymentSystemOfCard StrToPSoC(String str){
        if(str.equals("VISA")) return PaymentSystemOfCard.VISA;
        else if (str.equals("MASTERCARD")) return PaymentSystemOfCard.MASTERCARD;
        else if (str.equals("MAESTRO")) return PaymentSystemOfCard.MAESTRO;
        return null;
    }

    public static String PSoCToStr(PaymentSystemOfCard systemOfCard){
        if(systemOfCard==PaymentSystemOfCard.VISA) return "VISA";
        else if(systemOfCard==PaymentSystemOfCard.MASTERCARD) return "MASTERCARD";
        else if(systemOfCard==PaymentSystemOfCard.MAESTRO) return "MAESTRO";
        return null;
    }

    public static void connectToDB(){
        try{
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully to DB");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Connected unsuccessfully to DB");
        }
    }

    public static void getAndSetCardsOfClient(Client client) {
        ArrayList<Card> cards = new ArrayList<Card>();

        try{
            PreparedStatement statementCard = connection.prepareStatement("SELECT * FROM public.\"Card\"\n" +
                    "WHERE \"idOfClient\" = ?;");
            statementCard.setLong(1, client.getId());

            ResultSet resultCards = statementCard.executeQuery();

            while(resultCards.next()){
                Long id = resultCards.getLong("id");
                double mainBalance = resultCards.getDouble("mainBalance");
                Currency mainCurrency = StrToCur(resultCards.getString("mainCurrency"));
                boolean activity = resultCards.getBoolean("activity");
                Integer cvcCode = resultCards.getInt("cvc");
                PaymentSystemOfCard paymentSystem = StrToPSoC(resultCards.getString("paymentSystem"));
                Date dateOfCreation = resultCards.getDate("dateOfCreation");
                Date dateOfEnd = resultCards.getDate("dateOfEnd");

                cards.add(new Card(id,mainBalance,mainCurrency,activity,cvcCode,paymentSystem,dateOfCreation,dateOfEnd));
            }

            statementCard.close();

        } catch (Exception e){
            e.printStackTrace();
        }

        client.setCards(cards);
    }

    public static void getAndSetMultiCurrencyCardsOfClient(Client client){
        ArrayList<MultiCurrencyCard> multiCurrencyCards = new ArrayList<MultiCurrencyCard>();

        try{
            PreparedStatement statementMultiCard = connection.prepareStatement("SELECT * FROM public.\"MultiCurrencyCard\"\n" +
                    "WHERE \"idOfClient\" = ?;");
            statementMultiCard.setLong(1, client.getId());

            ResultSet resultCards = statementMultiCard.executeQuery();

            while(resultCards.next()){
                Long id = resultCards.getLong("id");
                double mainBalance = resultCards.getDouble("mainBalance");
                Currency mainCurrency = StrToCur(resultCards.getString("mainCurrency"));
                boolean activity = resultCards.getBoolean("activity");
                Integer cvcCode = resultCards.getInt("cvc");
                PaymentSystemOfCard paymentSystem = StrToPSoC(resultCards.getString("paymentSystem"));
                Date dateOfCreation = resultCards.getDate("dateOfCreation");
                Date dateOfEnd = resultCards.getDate("dateOfEnd");
                double secondBalance = resultCards.getDouble("secondBalance");
                Currency secondCurrency = StrToCur(resultCards.getString("secondCurrency"));
                double thirdBalance = resultCards.getDouble("thirdBalance");
                Currency thirdCurrency = StrToCur(resultCards.getString("thirdCurrency"));
                double fourthBalance = resultCards.getDouble("fourthBalance");
                Currency fourthCurrency = StrToCur(resultCards.getString("fourthCurrency"));

                multiCurrencyCards.add(new MultiCurrencyCard(id,mainBalance,mainCurrency,activity,cvcCode,paymentSystem,dateOfCreation,dateOfEnd,secondBalance,secondCurrency,thirdBalance,thirdCurrency,fourthBalance,fourthCurrency));
            }

            statementMultiCard.close();

        } catch (Exception e){
            e.printStackTrace();
        }

        client.setMultiCurrencyCards(multiCurrencyCards);
    }

    public static Client signIn(Client client) {
        String username = client.getUsername();
        String password = client.getPassword();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.\"Client\" AS client, public.\"Login\" AS login\n" +
                    "WHERE login.\"idOfClient\" = Client.\"id\"\n" +
                    "AND login.\"username\" = ?\n" +
                    "AND login.\"password\" = ?;");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String nameOfFather = resultSet.getString("nameOfFather");
                String phoneNumber = resultSet.getString("phoneNumber");
                Date dateOfBirth = resultSet.getDate("dateOfBirth");
                username = resultSet.getString("username");
                password = resultSet.getString("password");
                String resetQuestion = resultSet.getString("resetQuestion");
                String resetAnswer = resultSet.getString("resetAnswer");

                client = new Client(id,name,surname,nameOfFather,phoneNumber,dateOfBirth,username,password,resetQuestion,resetAnswer);

                getAndSetCardsOfClient(client);
                getAndSetMultiCurrencyCardsOfClient(client);

            } else client = null;
            statement.close();
        } catch (Exception e){
            e.printStackTrace();
            client = null;
        }
        return client;
    }

    public static Boolean signUp(Client client) {
        Boolean flag = null;

        String name = client.getName();
        String surname = client.getSurname();
        String nameOfFather = client.getNameOfFather();
        String phoneNumber = client.getPhoneNumber();
        Date dateOfBirth = client.getDateOfBirth();
        String username = client.getUsername();
        String password = client.getPassword();
        String resetQuestion = client.getResetQuestion();
        String resetAnswer = client.getResetAnswer();

        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO public.\"Client\" (\n" +
                    "name, surname, \"nameOfFather\", \"phoneNumber\", \"dateOfBirth\") VALUES (\n" +
                    "?, ?, ?, ?, ?);");
            statement.setString(1,name);
            statement.setString(2,surname);
            statement.setString(3,nameOfFather);
            statement.setString(4,phoneNumber);
            statement.setDate(5,dateOfBirth);

            statement.executeUpdate();

            statement = connection.prepareStatement("INSERT INTO public.\"Login\" (\n" +
                    "\"username\", password, \"resetQuestion\", \"resetAnswer\", \"idOfClient\") VALUES (\n" +
                    "?, ?, ?, ?, (\n" +
                    "SELECT id FROM public.\"Client\"\n" +
                    "WHERE name = ? AND surname = ?\n" +
                    "AND \"nameOfFather\" = ? AND \"phoneNumber\" = ? AND \"dateOfBirth\" = ?));");
            statement.setString(1,username);
            statement.setString(2,password);
            statement.setString(3,resetQuestion);
            statement.setString(4,resetAnswer);
            statement.setString(5,name);
            statement.setString(6,surname);
            statement.setString(7,nameOfFather);
            statement.setString(8,phoneNumber);
            statement.setDate(9,dateOfBirth);

            statement.executeUpdate();
            statement.close();

            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }

    public static Boolean changePassword(Client client) {
        Boolean flag = null;

        String username = client.getUsername();
        String password = client.getPassword();
        String resetQuestion = client.getResetQuestion();
        String resetAnswer = client.getResetAnswer();

        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE public.\"Login\" SET\n" +
                    "password = ? \n" +
                    "WHERE username = ? AND \"resetQuestion\" = ?\n" +
                    "AND \"resetAnswer\" = ?;");
            statement.setString(1,password);
            statement.setString(2,username);
            statement.setString(3,resetQuestion);
            statement.setString(4,resetAnswer);

            statement.executeUpdate();
            statement.close();

            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    public static Client updateClientInfo(Client client) {
        Long id = client.getId();
        String name = client.getName();
        String surname = client.getSurname();
        String nameOfFather = client.getNameOfFather();
        String phoneNumber = client.getPhoneNumber();
        Date dateOfBirth = client.getDateOfBirth();

        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE public.\"Client\" SET\n" +
                    "name = ?, surname = ?, \"nameOfFather\" = ?, \"phoneNumber\" = ?, \"dateOfBirth\" = ?\n" +
                    "WHERE id = ?;");
            statement.setString(1,name);
            statement.setString(2,surname);
            statement.setString(3,nameOfFather);
            statement.setString(4,phoneNumber);
            statement.setDate(5,dateOfBirth);
            statement.setLong(6,id);

            statement.executeUpdate();

            statement = connection.prepareStatement("SELECT * FROM public.\"Login\"\n" +
                    "WHERE \"idOfClient\" = ?;");
            statement.setLong(1,id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String resetQuestion = resultSet.getString("resetQuestion");
                String resetAnswer = resultSet.getString("resetAnswer");

                client = new Client(id,name,surname,nameOfFather,phoneNumber,dateOfBirth,username,password,resetQuestion,resetAnswer);

            }

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return client;
    }

    public static Client updateLoginInfo(Client client) {
        Long id = client.getId();
        String username = client.getUsername();
        String password = client.getPassword();
        String resetQuestion = client.getResetQuestion();
        String resetAnswer = client.getResetAnswer();

        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE public.\"Login\" SET\n" +
                    "username = ?, password = ?, \"resetQuestion\" = ?, \"resetAnswer\" = ? \n" +
                    "WHERE \"idOfClient\" = ?;");
            statement.setString(1,username);
            statement.setString(2,password);
            statement.setString(3,resetQuestion);
            statement.setString(4,resetAnswer);
            statement.setLong(5,id);

            statement.executeUpdate();

            statement = connection.prepareStatement("SELECT * FROM public.\"Client\"\n" +
                    "WHERE id = ?;");
            statement.setLong(1,id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {

                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String nameOfFather = resultSet.getString("nameOfFather");
                String phoneNumber = resultSet.getString("phoneNumber");
                Date dateOfBirth = resultSet.getDate("dateOfBirth");

                client = new Client(id,name,surname,nameOfFather,phoneNumber,dateOfBirth,username,password,resetQuestion,resetAnswer);

            }

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return client;
    }

    public static Client createSimpleCard(PackageData packageData) {
        Client client = packageData.getClient();

        Long id = client.getId();
        Currency currency = packageData.getCurrency();
        PaymentSystemOfCard systemOfCard = packageData.getSystemOfCard();
        Random random = new Random();

        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO public.\"Card\" (\n" +
                    "\"mainBalance\", \"mainCurrency\", activity, cvc, \"paymentSystem\", \"dateOfCreation\", \"dateOfEnd\", \"idOfClient\") VALUES (\n" +
                    "?, ?, ?, ?, ?, ?, ?, ?);");
            statement.setDouble(1, 0);
            statement.setString(2, CurToStr(currency));
            statement.setBoolean(3, true);
            statement.setShort(4, (short) random.nextInt(999));
            statement.setString(5, PSoCToStr(systemOfCard));
            GregorianCalendar date = new GregorianCalendar();
            statement.setDate(6, new Date(date.getTimeInMillis()));
            date.roll(GregorianCalendar.YEAR, 3);
            statement.setDate(7, new Date(date.getTimeInMillis()));
            statement.setLong(8, id);

            statement.executeUpdate();
            statement.close();

            getAndSetCardsOfClient(client);

        } catch (Exception e){
            e.printStackTrace();
        }

        return client;
    }

    public static Client createMultiCard(PackageData packageData) {
        Client client = packageData.getClient();

        Long id = client.getId();
        PaymentSystemOfCard systemOfCard = packageData.getSystemOfCard();
        Random random = new Random();

        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO public.\"MultiCurrencyCard\" (\n" +
                    "\"mainBalance\", \"mainCurrency\", activity, cvc, \"paymentSystem\", \"dateOfCreation\", \"dateOfEnd\", \"secondBalance\", \"secondCurrency\", \"thirdBalance\", \"thirdCurrency\", \"fourthBalance\", \"fourthCurrency\", \"idOfClient\") VALUES (\n" +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            statement.setDouble(1, 0);
            statement.setString(2, "KZT");
            statement.setBoolean(3, true);
            statement.setShort(4, (short) random.nextInt(999));
            statement.setString(5, PSoCToStr(systemOfCard));
            GregorianCalendar date = new GregorianCalendar();
            statement.setDate(6, new Date(date.getTimeInMillis()));
            date.roll(GregorianCalendar.YEAR, 3);
            statement.setDate(7, new Date(date.getTimeInMillis()));
            statement.setDouble(8,0);
            statement.setString(9, "USD");
            statement.setDouble(10, 0);
            statement.setString(11, "EUR");
            statement.setDouble(12, 0);
            statement.setString(13, "RUB");
            statement.setLong(14, id);

            statement.executeUpdate();
            statement.close();

            getAndSetMultiCurrencyCardsOfClient(client);

        } catch (Exception e){
            e.printStackTrace();
        }

        return client;
    }

    public static Boolean makePriorityC(PackageData packageData){
        Boolean flag = null;

        Long clientId = packageData.getClient().getId();
        Long cardId = packageData.getCard().getId();

        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE public.\"PriorityCard\" SET\n" +
                    "card = ?, multicard = null WHERE\n" +
                    "id = ?;");
            statement.setLong(1, cardId);
            statement.setLong(2, clientId);

            statement.executeUpdate();
            statement.close();

            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static Boolean deactivateC(PackageData packageData) {
        Boolean flag = null;

        Long cardId = packageData.getCard().getId();

        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE public.\"Card\" SET\n" +
                    "activity = false WHERE\n" +
                    "id = ?;");
            statement.setLong(1, cardId);

            statement.executeUpdate();
            statement.close();

            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static Boolean deleteC(PackageData packageData) {
        Boolean flag = false;

        Long cardId = packageData.getCard().getId();

        try{
            PreparedStatement statement = connection.prepareStatement("DELETE FROM public.\"Card\"\n" +
                    "WHERE id IN (?);");
            statement.setLong(1, cardId);

            statement.executeUpdate();
            statement.close();

            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static Boolean makePriorityMC(PackageData packageData){
        Boolean flag = null;

        Long clientId = packageData.getClient().getId();
        Long cardId = packageData.getMultiCurrencyCard().getId();

        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE public.\"PriorityCard\" SET\n" +
                    "card = null, multicard = ? WHERE\n" +
                    "id = ?;");
            statement.setLong(1, cardId);
            statement.setLong(2, clientId);

            statement.executeUpdate();
            statement.close();

            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static Boolean deactivateMC(PackageData packageData) {
        Boolean flag = null;

        Long cardId = packageData.getMultiCurrencyCard().getId();

        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE public.\"MultiCurrencyCard\" SET\n" +
                    "activity = false WHERE\n" +
                    "id = ?;");
            statement.setLong(1, cardId);

            statement.executeUpdate();
            statement.close();

            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static Boolean deleteMC(PackageData packageData) {
        Boolean flag = false;

        Long cardId = packageData.getMultiCurrencyCard().getId();

        try{
            PreparedStatement statement = connection.prepareStatement("DELETE FROM public.\"MultiCurrencyCard\"\n" +
                    "WHERE id IN (?);");
            statement.setLong(1, cardId);

            statement.executeUpdate();
            statement.close();

            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static Boolean transferCard(PackageData packageData) {
        Boolean flag = false;

        Long receiverId = packageData.getReceiverCardId();
        Long cardId = packageData.getCard().getId();
        String cardCurrency = CurToStr(packageData.getCard().getMainCurrency());
        String receiverCurrency = "";

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT \"mainCurrency\" FROM public.\"Card\"\n" +
                    "WHERE id = ?;");
            statement.setLong(1,receiverId);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                receiverCurrency = resultSet.getString("mainCurrency");
            }

            if(receiverCurrency.equals(cardCurrency)){
                statement = connection.prepareStatement("UPDATE public.\"Card\" SET\n" +
                        "\"mainBalance\" = \"mainBalance\" - ? WHERE\n" +
                        "id = ?;");
                statement.setDouble(1,packageData.getAmount());
                statement.setLong(2,cardId);

                statement.executeUpdate();

                statement = connection.prepareStatement("UPDATE public.\"Card\" SET\n" +
                        "\"mainBalance\" = \"mainBalance\" + ? WHERE\n" +
                        "id = ?;");
                statement.setDouble(1,packageData.getAmount());
                statement.setLong(2,receiverId);

                statement.executeUpdate();
            } else {
                double universalAmount;
                if(cardCurrency.equals("KZT")) universalAmount = packageData.getAmount();
                else universalAmount = ExchangeCurrency.exchangeToKZT(Currency.valueOf(cardCurrency),packageData.getAmount());

                if(receiverCurrency.equals("USD")) universalAmount /= ExchangeCurrency.USDtoKZT;
                else if(receiverCurrency.equals("EUR")) universalAmount /= ExchangeCurrency.EURtoKZT;
                else if(receiverCurrency.equals("RUB")) universalAmount /= ExchangeCurrency.RUBtoKZT;

                statement = connection.prepareStatement("UPDATE public.\"Card\" SET\n" +
                        "\"mainBalance\" = \"mainBalance\" - ? WHERE\n" +
                        "id = ?;");
                statement.setDouble(1,packageData.getAmount());
                statement.setLong(2,cardId);

                statement.executeUpdate();

                statement = connection.prepareStatement("UPDATE public.\"Card\" SET\n" +
                        "\"mainBalance\" = \"mainBalance\" + ? WHERE\n" +
                        "id = ?;");
                statement.setDouble(1,universalAmount);
                statement.setLong(2,receiverId);

                statement.executeUpdate();
            }

            statement.close();

            flag = true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return flag;
    }
}
