package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        String myFile = reader1.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(myFile));
        reader1.close();

        String s;
        ArrayList<String> list = new ArrayList<String>();
        int id = Integer.parseInt(args[1]);
        while ( ( s = reader.readLine()) != null) list.add(s);

        if (args[0].equals("-d"))
        {

            for (int i = 0; i < list.size(); i++)
            {
                int n = 0;
                char [] bb = list.get(i).toCharArray();
                String buf = "";

                for (int j = 0; j < bb.length; j++)
                {
                    buf += bb[j];
                    if (isNumber(buf)) n = Integer.parseInt(buf);
                }
                if (id == n) list.remove(i);
            }
            reader.close();
            FileWriter writer = new FileWriter(myFile);
            for (int i = 0; i < list.size(); i++)
            {
                writer.write(list.get(i) + "\n");
            }
            writer.close();
        }


        if (args[0].equals("-u"))
        {
            String inProductName, inPrice, inQuantity;
            if (args.length == 5) {inProductName = args[2]; inPrice = args[3]; inQuantity = args[4];}
            else {inProductName = args[2] + " "; inPrice = args[args.length - 2]; inQuantity = args[args.length - 1];
                for (int i = 3; i < args.length - 2; i++)
                {
                    inProductName += args[i] + " ";
                }
            }
            String ids = id + "";

            if (inProductName.length() < 31) { while(inProductName.length() < 30 ) inProductName += " "; }
            else inProductName = inProductName.substring(0, 30);

            if (inPrice.length() < 9) { while(inPrice.length() < 8 ) inPrice += " "; }
            else inPrice = inPrice.substring(0, 8);

            if (inQuantity.length() < 5) { while(inQuantity.length() < 4 ) inQuantity += " "; }
            else inQuantity = inQuantity.substring(0, 4);

            if (ids.length() < 9) { while(ids.length() < 8 ) ids += " "; }
            else ids = ids.substring(0, 8);

            System.out.println(ids + "*" + inProductName + "*" +inPrice +"*" + inQuantity + "*");

            for (int i = 0; i < list.size(); i++)
            {
                int n = 0;
                char [] bb = list.get(i).toCharArray();
                String buf = "";

                for (int j = 0; j < bb.length; j++)
                {
                    buf += bb[j];
                    if (isNumber(buf)) n = Integer.parseInt(buf);
                }
                if (id == n) list.remove(i);
            }

            list.add(ids+inProductName + inPrice + inQuantity);

            reader.close();
            FileWriter writer = new FileWriter(myFile);
            for (int i = 0; i < list.size(); i++)
            {
                writer.write(list.get(i) + "\n");
            }
            writer.close();
        }
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
