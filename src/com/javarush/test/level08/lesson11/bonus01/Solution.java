package com.javarush.test.level08.lesson11.bonus01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = a + " " + 1 + " " + 2013;
        Date date = new Date(b);
        int n = date.getMonth()+1;
        System.out.println(a + " is " + n + " month");


        //add your code here - напиши код тут
    }

}
