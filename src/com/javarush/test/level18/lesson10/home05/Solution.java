package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String nameF1, nameF2;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        nameF1 = reader.readLine();
        nameF2 = reader.readLine();

        FileInputStream myFile1 = new FileInputStream(nameF1);
        FileOutputStream myFile2 = new FileOutputStream(nameF2);

        ArrayList<Character> list = new ArrayList<Character>();
        while (myFile1.available() > 0)
        {
            list.add((char) myFile1.read());
        }
        String s = "";
        ArrayList<String> list2 = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i) != ' ' && list.get(i) != '\n') s += list.get(i);
            else { list2.add(s); s = "";}
        }
        list2.add(s);
        s = "";
        for (int i = 0; i < list2.size(); i++)
        {
            double d = Double.parseDouble(list2.get(i));
            double d2 = new BigDecimal(d).setScale(0, RoundingMode.HALF_UP).doubleValue();
            long d4 = Math.round(d);
            int d3 = (int) d2;
            if (i != list2.size()-1) s += d4 + " ";
            else s += d4;
        }






        char [] buffer = s.toCharArray();
        for (int i = 0; i < buffer.length; i++)
        {
            myFile2.write((int) buffer[i]);
        }



        myFile1.close();
        myFile2.close();
        reader.close();
    }
}
