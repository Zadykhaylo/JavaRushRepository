package com.javarush.test.level08.lesson08.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> map = new HashMap<String, String> ();

        map.put("Ст1", "JUNE");
        map.put("Ст2", "JULY");
        map.put("Ст3", "AUGUST");
        map.put("Ст4", "SEPTEMBER");
        map.put("Ст5", "OCTOBER");
        map.put("Ст6", "SEPTEMBER");
        map.put("Ст7", "JUNE");
        map.put("Са8", "JANUARY");
        map.put("Сл9", "JUNE");
        map.put("С10", "SEPTEMBER");

        return map;
        //Напишите тут ваш код

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        ArrayList<String> list = new ArrayList<String>();
        for (Map.Entry<String, String> pair1: copy.entrySet())
        {
            String s = pair1.getValue();
            int k = 0;
            for (Map.Entry<String, String> pair2: map.entrySet())
            {
               if (s.equals(pair2.getValue())) k++;
            }
            if (k > 1) list.add(s);
        }

        for (int i = 0; i < list.size(); i++) removeItemFromMapByValue(map, list.get(i));

        //Напишите тут ваш код

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
