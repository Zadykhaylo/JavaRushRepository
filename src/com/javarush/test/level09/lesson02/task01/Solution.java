package com.javarush.test.level09.lesson02.task01;

/* Каждый метод должен возвращать свой StackTrace
Написать пять методов, которые вызывают друг друга. Каждый метод должен возвращать свой StackTrace.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        method1();

    }

    public static StackTraceElement[] method1()
    {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        method2();
        return stackTraceElements;
        //Напишите тут ваш код

    }

    public static StackTraceElement[] method2()
    {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        method3();
        return stackTraceElements;//Напишите тут ваш код

    }

    public static StackTraceElement[] method3()
    {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        method4();
        return stackTraceElements;

    }

    public static StackTraceElement[] method4()
    {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        method5();
        return stackTraceElements;
        //Напишите тут ваш код

    }

    public static StackTraceElement[] method5()
    {

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        return stackTraceElements;
        //Напишите тут ваш код

    }
}
