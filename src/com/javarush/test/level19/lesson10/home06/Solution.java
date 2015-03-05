package com.javarush.test.level19.lesson10.home06;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static{
        map.put(0, "ноль");        map.put(5, "пять");
        map.put(1, "один");        map.put(6, "шесть");
        map.put(2, "два");        map.put(7, "семь");
        map.put(3, "три");        map.put(8, "восемь");
        map.put(4, "четыре");        map.put(9, "девять");
        map.put(10, "десять");       map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        String myFile = reader1.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(myFile));



        String s;

        while ((s = reader.readLine()) != null)
        {
            String [] ss = s.split(" ");

            for (int i = 0; i < ss.length; i++)
            {
                try {
                if (Integer.parseInt(ss[i]) >= 0 && Integer.parseInt(ss[i]) <= 12) ss[i] = map.get(Integer.parseInt(ss[i]));
                }
                catch (NumberFormatException e){}
            }
            String schisl = "";
            for (int i = 0; i < ss.length; i++)
            {
                if ( i == ss.length - 1) schisl += ss[i];
                else schisl += ss[i] + " ";
            }
            System.out.println(schisl);
        }



        reader1.close();
        reader.close();
    }
}
