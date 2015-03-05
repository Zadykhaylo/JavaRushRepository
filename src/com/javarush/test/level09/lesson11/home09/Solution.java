package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        HashMap<String, Cat> map = new HashMap<String, Cat>();
        Cat cat1 = new Cat("Vaska1");
        Cat cat2 = new Cat("Vaska2");
        Cat cat3 = new Cat("Vaska3");
        Cat cat4 = new Cat("Vaska4");
        Cat cat5 = new Cat("Vaska5");
        Cat cat6 = new Cat("Vaska6");
        Cat cat7 = new Cat("Vaska7");
        Cat cat8 = new Cat("Vaska8");
        Cat cat9 = new Cat("Vaska9");
        Cat cat10 = new Cat("Vaska10");
        map.put("Vaska1", cat1);
        map.put("Vaska2", cat2);
        map.put("Vaska3", cat3);
        map.put("Vaska4", cat4);
        map.put("Vaska5", cat5);
        map.put("Vaska6", cat6);
        map.put("Vaska7", cat7);
        map.put("Vaska8", cat8);
        map.put("Vaska9", cat9);
        map.put("Vaska10", cat10);
        return map;
        //Напишите тут ваш код
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        HashSet<Cat> set = new HashSet<Cat>();
        for (Map.Entry<String, Cat> pair : map.entrySet())
        {   Cat value = pair.getValue();
            set.add(value);
        }
        return set;
        //Напишите тут ваш код
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
