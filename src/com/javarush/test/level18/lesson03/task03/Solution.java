package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String nameF;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        nameF = reader.readLine();
        FileInputStream myFile = new FileInputStream(nameF);

        ArrayList<Integer> mx = new ArrayList<Integer>();
        while (myFile.available() > 0)
        {   mx.add(myFile.read());
        }



        ArrayList<Integer> mxCount = new ArrayList<Integer>();
        for (int i = 0; i < mx.size(); i++)
        {
            mxCount.add(countRaz(mx.get(i),mx));
        }
        int maxRaz = 0;
        for (int i = 0; i < mxCount.size() ; i++)
        {
           if(mxCount.get(i) > maxRaz ) maxRaz = mxCount.get(i);
        }

        ArrayList<Integer> iskomByte = new ArrayList<Integer>();
        for (int i = 0; i < mx.size(); i++)
        {
           if (mxCount.get(i) == maxRaz) iskomByte.add(mx.get(i));
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < iskomByte.size(); i++)
            if (!map.containsValue(iskomByte.get(i)))
                map.put(i, iskomByte.get(i));



        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            System.out.print(pair.getValue() + " ");
        }


        myFile.close();
        reader.close();
//        System.out.println(mx);   d:\\data.txt
//        System.out.println(mxCount);
//        System.out.println(countRaz(mx.get(8), mx));
//        System.out.println(maxRaz);

    }

    public static int countRaz (int n, ArrayList<Integer> list){

        int count = 0;
        for (int i = 0; i < list.size(); i++)
        {
           if (n == list.get(i)) count++;
        }
        return count;
    }

}
