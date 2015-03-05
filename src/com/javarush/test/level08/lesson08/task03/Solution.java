package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 1; i <= 10; i++)
        {
            String f = "F" + i;
            String n = "N" + i;
            map.put(f, n);
        }
        return map;
        //Напишите тут ваш код

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int k=0;
        for (Map.Entry<String, String> pair : map.entrySet())
        {   
            if (name.equals(pair.getValue())) k++;
        }
        return k;
        //Напишите тут ваш код

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        int k=0;
        for (Map.Entry<String, String> pair : map.entrySet())
        {   
            if (familiya.equals(pair.getKey())) k++;
        }
        return k;
        //Напишите тут ваш код

    }
}
