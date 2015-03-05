package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        int c;  String s ="";
        while ((c = fileInputStream.read()) != -1) s = s + (char) c;
        fileInputStream.close();
        reader.close();
        char[] array = s.toCharArray();

        s = "";
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();

        for (int i = 0; i < array.length; i++)
        {
            if ((int)array[i] == 10 || (int)array[i] == 13)    array[i] = ' ';
            list.add("" + array[i]);
        }

        for (int i = 0; i < list.size(); i++)
        {
            if (isNumber(list.get(i)))
            {
                s = s + list.get(i);
                if (i == list.size()-1) list2.add(Integer.parseInt(s));
            }
            else{
                if (isNumber(s)) list2.add(Integer.parseInt(s));
                s = "";
            }
        }

        for (int i = 0; i < list2.size(); i++)
        {
            if (list2.get(i) % 2 == 0) list3.add(list2.get(i));
        }

        int[] arr = new int[list3.size()];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = list3.get(i);
        }

        for (int j = 0; j < arr.length; j++)
        {
            for (int i = j+1; i < arr.length; i++)
            {
                if (arr[i] < arr[j])
                {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }

        }

        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
        // напишите тут ваш код


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
