package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        ArrayList<Integer> listNumber = new ArrayList<Integer>();
        ArrayList<Integer> listString = new ArrayList<Integer>();

        for (int i = 0; i < array.length; i++)
        {
           if (isNumber(array[i])) listNumber.add(i);
           else listString.add(i);
        }

        int [] arrayValue = new int[listNumber.size()];
        for (int i = 0; i < arrayValue.length; i++)
        {
            arrayValue [i] = Integer.parseInt(array[listNumber.get(i)]);
        }

        for (int j = 0; j < arrayValue.length; j++)
        {
            for (int i = j+1; i < arrayValue.length; i++)
            {
                if (arrayValue[i] > arrayValue[j])
                {
                    int t = arrayValue[i];
                    arrayValue[i] = arrayValue[j];
                    arrayValue[j] = t;
                }
            }

        }

        for (int i = 0; i < listNumber.size(); i++)
        {
           array[listNumber.get(i)] = ""+arrayValue[i];
        }

//++++++++++++

        String [] arrayStringValue = new String [listString.size()];
        for (int i = 0; i < arrayStringValue.length; i++)
        {
            arrayStringValue [i] = array[listString.get(i)];
        }

        for (int j = 0; j < arrayStringValue.length; j++)
        {
            for (int i = j+1; i < arrayStringValue.length; i++)
            {
                if (isGreaterThen(arrayStringValue[i], arrayStringValue[j]))
                {
                    String t = arrayStringValue[i];
                    arrayStringValue[i] = arrayStringValue[j];
                    arrayStringValue[j] = t;
                }
            }

        }

        for (int i = 0; i < listString.size(); i++)
        {
            array[listString.get(i)] = arrayStringValue[i];
        }











        //Напишите тут ваш код
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b)
    {
        return a.compareTo(b) < 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        for (char c : s.toCharArray())
        {
            if (!Character.isDigit(c) && c != '-') return false;
        }
        return true;
    }
}
