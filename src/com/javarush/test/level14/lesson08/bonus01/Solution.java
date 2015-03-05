package com.javarush.test.level14.lesson08.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();
        int k = 1;

        for (Exception exception : exceptions)
        {
            System.out.println(k + ". " + exception);
            k++;
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //2 input
        try
        {
            String B = "dddd";
            int  k1 = Integer.parseInt(B);

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //3
        try
        {

            ArrayList<String> list = new ArrayList<String>();
            String s = list.get(18);

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //4
        try
        {

            String  k1 = "555";
            FileInputStream f = new FileInputStream(k1);

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //5
        try
        {
           int[] k = new int[5];
           k[20] = 5;


        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //6
        try
        {
            int[] k = new int[-5];


        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //7
        try
        {

            Object x[] = new String[3];
            x[0] = new Integer(0);


        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //8
        try
        {


            Object x = new Integer(0);
            System.out.println((String)x);

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //9
        try
        {

            String s = null;
            String ss = s.toLowerCase();




        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //10
        try
        {
            throw new NoSuchFieldException();



        } catch (Exception e)
        {
            exceptions.add(e);
        }
        //Add your code here

    }
}
