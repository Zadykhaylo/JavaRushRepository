package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulator
{
    private String currencyCode;
    Map<Integer, Integer> denominations = new HashMap<Integer,Integer>();

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void addAmount(int denomination, int count){
        denominations.put(denomination, count);
    }

    public int getTotalAmount(){
        int sum = 0;
        for (Map.Entry<Integer, Integer> pair : denominations.entrySet())
        {
            sum += pair.getValue()* pair.getKey();
        }

        return sum;
    }
}
