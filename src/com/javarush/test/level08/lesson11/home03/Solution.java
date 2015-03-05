package com.javarush.test.level08.lesson11.home03;

import java.util.HashMap;
import java.util.Map;

/* Люди с одинаковыми именами и/или фамилиями
1. Создать словарь Map (<String, String>) и добавить туда 10 человек в виде «Фамилия»-«Имя».
2. Пусть среди этих 10 человек есть люди с одинаковыми именами.
3. Пусть среди этих 10 человек есть люди с одинаковыми фамилиями.
4. Вывести содержимое Map на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Ст1", "JUNE 1 1980");
        map.put("Ст2", "JULY 1 1980");
        map.put("Ст3", "AUGUST 1 1980");
        map.put("Ст4", "SEPTEMBER 1 1980");
        map.put("Ст5", "1 1980");
        map.put("Ст6", "NOVEMBER 1 1980");
        map.put("Ст7", "1 1980");
        map.put("Ст6", "JANUARY 1 1980");
        map.put("Сл9", "FEBRUARY 1 1980");
        map.put("С10", "JUNE 5 1980");
        //Напишите тут ваш код

        return map;
    }

    public static void printPeopleList(Map<String, String> map)
    {
        for (Map.Entry<String, String> s : map.entrySet())
        {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }

}
