package com.javarush.test.level09.lesson02.task05;

/* Метод должен возвращать результат – глубину её стек-трейса
Написать метод, который возвращает результат – глубину его стек трейса –
количество методов в нем (количество элементов в списке). Это же число метод должен выводить на экран.
*/

public class Solution
{
    public static int getStackTraceDeep()
    {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        StackTraceElement element = stackTraceElements[2];
        int s = stackTraceElements.length;
        System.out.println(s);
        return s;
        //Напишите тут ваш код

    }
}
