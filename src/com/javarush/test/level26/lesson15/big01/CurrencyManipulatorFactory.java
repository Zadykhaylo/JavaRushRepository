package com.javarush.test.level26.lesson15.big01;

import java.util.ArrayList;
import java.util.List;

public class CurrencyManipulatorFactory
{
    private static List <CurrencyManipulator> currencyManipulators = new ArrayList<CurrencyManipulator>();

    private CurrencyManipulatorFactory (){

    }

    public static CurrencyManipulator getManipulatorByCurrencyCode (String currencyCode){

        for (int i = 0; i < currencyManipulators.size(); i++)
        {
           if (currencyManipulators.get(i).getCurrencyCode().equals(currencyCode)) return currencyManipulators.get(i);
        }
        CurrencyManipulator cc = new CurrencyManipulator(currencyCode);
        currencyManipulators.add(cc);
        return cc;
    }
}
