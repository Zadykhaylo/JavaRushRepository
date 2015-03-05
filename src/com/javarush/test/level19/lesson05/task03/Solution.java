package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameF1 = reader.readLine();
        String nameF2 = reader.readLine();
        FileReader reader1 = new FileReader (nameF1);
        FileWriter writer1 = new FileWriter(nameF2);
        reader.close();

        String s = "";
        while (reader1.ready())
        {
            int n = reader1.read();
            s += (char) n;

        }
        reader1.close();
        ArrayList<String> list = new ArrayList<String>();

        char [] buf = s.toCharArray();
        s = "";
        for (int i = 0; i < buf.length; i++)
        {

            if (buf[i] != ' ') s += buf[i];
            else { list.add(s);
               s = "";
           }
        }
        list.add(s);

        for (int i = 0; i < list.size(); i++)
        {
            if (isNumber(list.get(i))) writer1.write(list.get(i) + " ");
        }
        writer1.close();
    }
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
