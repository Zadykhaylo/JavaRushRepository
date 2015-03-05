package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        String nameF;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        nameF = reader.readLine();
        FileInputStream myFile = new FileInputStream(nameF);

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
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
        ArrayList<Integer> list = new ArrayList<Integer>() ;

        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            list.add(pair.getKey());
        }
        int [] result = new int[list.size()];
        for (int i = 0; i < result.length; i++)
        {
           result[i] = list.get(i);
        }
        for (int j = 0; j < result.length; j++)
        {
            for (int i = j+1; i < result.length; i++)
            {
                if (result[i] < result[j])
                {
                    int t = result[i];
                    result[i] = result[j];
                    result[j] = t;

                }
            }

        }
        for (int i = 0; i < result.length ; i++)
        {
            System.out.print(result[i] + " ");
        }

        myFile.close();
        reader.close();
    }
}
