package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байты, которые встречаются в файле меньше всего раз.
Вывести их на экран через пробел
Закрыть поток ввода-вывода
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
        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            if (pair.getValue() == 1) System.out.print(pair.getKey() + " ");
        }


    }
}
