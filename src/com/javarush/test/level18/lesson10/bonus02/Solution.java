package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-с  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        String myFile = reader1.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(myFile));
        reader1.close();

        String s; int id = 0;

        while ( ( s = reader.readLine()) != null)
        {   int n = 0;
            char [] bb = s.toCharArray();
            String buf = "";
            for (int i = 0; i < bb.length; i++)
            {
               buf += bb[i];
               if (isNumber(buf)) n = Integer.parseInt(buf);
            }
            if (n > id) id = n;
        }
        id++;



        if (args[0].equals("-u")){
        String inProductName, inPrice, inQuantity;
        if (args.length == 4) {inProductName = args[1]; inPrice = args[2]; inQuantity = args[3];}
        else {inProductName = args[1] + " "; inPrice = args[args.length - 2]; inQuantity = args[args.length - 1];
                for (int i = 2; i < args.length - 2; i++)
                {
                    inProductName += args[i] + " ";
                }
             }
        String ids = id + "";

            if (inProductName.length() < 31)
            {
                while(inProductName.length() < 30 ) inProductName += " ";
            }
            else inProductName = inProductName.substring(0, 30);

            if (inPrice.length() < 9)
            {
                while(inPrice.length() < 8 ) inPrice += " ";
            }
            else inPrice = inPrice.substring(0, 8);

            if (inQuantity.length() < 5)
            {
                while(inQuantity.length() < 4 ) inQuantity += " ";
            }
            else inQuantity = inQuantity.substring(0, 4);

            if (ids.length() < 9)
            {
                while(ids.length() < 8 ) ids += " ";
            }
            else ids = ids.substring(0, 8);

        System.out.println(ids + "*" + inProductName + "*" +inPrice +"*" + inQuantity + "*");


            FileWriter writer = new FileWriter(myFile, true);
            writer.write(ids+inProductName + inPrice + inQuantity + "\n");
            writer.close();
            reader.close();
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
