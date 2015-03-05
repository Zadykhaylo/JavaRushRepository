package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String s = args[0];
        FileInputStream myFile = new FileInputStream(s);

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        while (myFile.available() > 0)
        {
            int bytE = myFile.read();
            if (!map.containsKey(bytE)) map.put(bytE, 1);
            else {
                int value = map.get(bytE)+1;
                map.remove(bytE);
                map.put(bytE, value);
            }
        }




        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            int key = pair.getKey();

            System.out.println(((char) key) + " " + pair.getValue());
            System.out.println( key + " + " + pair.getValue());
            System.out.println( "----------------");
        }



//        ArrayList<Integer> list = new ArrayList<Integer>() ;
//
//        for (Map.Entry<Integer, Integer> pair : map.entrySet())
//        {
//            list.add(pair.getKey());
//        }
//        int [] result = new int[list.size()];
//        for (int i = 0; i < result.length; i++)
//        {
//            result[i] = list.get(i);
//        }
//        for (int j = 0; j < result.length; j++)
//        {
//            for (int i = j+1; i < result.length; i++)
//            {
//                if (result[i] < result[j])
//                {
//                    int t = result[i];
//                    result[i] = result[j];
//                    result[j] = t;
//
//                }
//            }
//
//        }
//        for (int i = 0; i < result.length ; i++)
//        {
//            System.out.print(result[i] + " ");
//        }

        myFile.close();


    }
}
