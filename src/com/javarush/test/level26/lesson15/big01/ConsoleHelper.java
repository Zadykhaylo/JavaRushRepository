package com.javarush.test.level26.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper
{
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static String askCurrencyCode() throws IOException {
        String cod;
        while (true) {
            writeMessage("Enter currency cod: ");
            cod = readString();
            if (cod.length() == 3) {
                cod = cod.toUpperCase();
                break;
            }
            writeMessage("Incorrect code");
        }
        return cod;
    }
    public static String[] getValidTwoDigits(String currencyCode) throws IOException {
        String denom_numb;
        String [] nk;
        while (true) {
            writeMessage("Enter denomination and the number of notes: ");
            denom_numb = readString();
            nk = denom_numb.split(" ");
            if (Integer.parseInt(nk[0]) > 0 && Integer.parseInt(nk[1]) > 0) break;
            writeMessage("Incorrect data");
        }
        return nk;
    }
    public static Operation askOperation() throws IOException
    {
        Operation op;
        while (true) {
            writeMessage("Enter operation cod: ");
            try {
            op = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
            break;
            }
            catch (IllegalArgumentException e){
            writeMessage("Incorrect code");
            }
        }
        return op;
    }
}

