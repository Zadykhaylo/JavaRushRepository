package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Ст1", new Date("JUNE 1 1980"));
        map.put("Ст2", new Date("JULY 1 1980"));
        map.put("Ст3", new Date("AUGUST 1 1980"));
        map.put("Ст4", new Date("SEPTEMBER 1 1980"));
        map.put("Ст5", new Date("OCTOBER 1 1980"));
        map.put("Ст6", new Date("NOVEMBER 1 1980"));
        map.put("Ст7", new Date("DECEMBER 1 1980"));
        map.put("Са8", new Date("JANUARY 1 1980"));
        map.put("Сл9", new Date("FEBRUARY 1 1980"));
        map.put("С10", new Date("JUNE 5 1980"));
        for (Map.Entry<String, Date> pair : map.entrySet())
        {   String key = pair.getKey();
            Date value = pair.getValue();
            String t = key + " - " + value;
            System.out.println(t);
        }
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        HashMap<String, Date> map2 = new HashMap<String, Date>();

        for (Map.Entry<String, Date> pair : map.entrySet())
        {   Date date = pair.getValue();
            int m = date.getMonth();
            if (m > 7 || m < 5) map2.put(pair.getKey(), pair.getValue());
        }
        map.clear();
        for (Map.Entry<String, Date> pair : map2.entrySet())
            map.put(pair.getKey(), pair.getValue());
        //Напишите тут ваш код

    }
}
