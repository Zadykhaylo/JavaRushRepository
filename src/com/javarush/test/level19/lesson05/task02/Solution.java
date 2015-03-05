package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameF1 = reader.readLine();
        FileReader reader1 = new FileReader (nameF1);
        reader.close();

        int count = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (reader1.ready())
        {
           list.add(reader1.read());
        }

        for (int i = 0; i < list.size(); i++)
        {
           if (list.get(i) == 119 && i + 4 < list.size()) {
               if (list.get(i+1) == 111 && list.get(i+2) == 114 && list.get(i+3) == 108 && list.get(i+4) == 100) count++;
           }
        }
        System.out.println(count);
        reader1.close();


    }
}
