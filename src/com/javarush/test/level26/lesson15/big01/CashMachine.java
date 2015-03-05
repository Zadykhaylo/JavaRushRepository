package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;

import java.io.IOException;
import java.util.Locale;

public class CashMachine
{
    public static void main(String[] args) throws IOException
    {
        Locale.setDefault(Locale.ENGLISH);
        while (true){
            Operation op = ConsoleHelper.askOperation();
            CommandExecutor.execute(op);
            if (op == Operation.EXIT) break;
        }
    }

}
