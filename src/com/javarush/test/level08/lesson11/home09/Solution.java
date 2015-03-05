package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date)
 так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
*/

public class Solution
{
    public static void main(String[] args)
    {
        String date = "MAY 1 2013";
        isDateOdd(date);

    }

    public static boolean isDateOdd(String date)
    {
        Date yst = new Date();
        yst.setHours(0);
        yst.setMinutes(0);
        yst.setSeconds(0);
        yst.setDate(1);
        yst.setMonth(0);
        Date ct = new Date(date);
        long mst = ct.getTime() - yst.getTime();
        long msd = 24 * 60 * 60 * 1000;
        int iday = (int) (mst/msd);
        return (iday % 2 == 0) ? true : false ;
    }
}
