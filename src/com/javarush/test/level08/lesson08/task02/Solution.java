package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        HashSet<Integer> n1 = new HashSet<Integer>();
        for (int i = 1; i <=20; i++) n1.add(i);
        return n1;//Напишите тут ваш код

    }

    public static HashSet<Integer> removeAllNumbersMoreThen10(HashSet<Integer> set)
    {
        HashSet<Integer> n1 = new HashSet<Integer>();
        for (int n : set)
        {
            if (n <= 10)  n1.add(n);
        }
        return n1;//Напишите тут ваш код

    }
}
