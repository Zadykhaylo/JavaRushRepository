package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.io.IOException;

class InfoCommand implements Command
{
    @Override
    public void execute() throws IOException
    {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        String [] denom_numb = ConsoleHelper.getValidTwoDigits(currencyCode);
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        int n = Integer.parseInt(denom_numb[0]);
        int k = Integer.parseInt(denom_numb[1]);
        currencyManipulator.addAmount(n, k);
    }
}
