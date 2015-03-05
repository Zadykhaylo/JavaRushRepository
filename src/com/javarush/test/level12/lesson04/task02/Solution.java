package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution
{
    public static void main(String[] args)
    {
        int d = 0;
        Integer c = 0;
        int a = print (d);
        Object b = print(c);
    }

    public static int print(int c)
    {
        return c;
    }
    public static Integer print(Integer c)
    {
        return c;
    }//Напишите тут ваши методы
}
