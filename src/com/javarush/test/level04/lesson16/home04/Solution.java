package com.javarush.test.level04.lesson16.home04;
import java.util.*;
import java.io.*;
import java.text.*;
import static javax.print.attribute.Size2DSyntax.MM;
import java.util.ArrayList;
/* Меня зовут 'Вася'...
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.
Вывести на экран текст:
«Меня зовут name
Я родился d.m.y»
Пример:
Меня зовут Вася
Я родился 15.2.1988
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String name = in.readLine();
        String sd = in.readLine();
        String sm = in.readLine();
        String sy = in.readLine();

        int d = Integer.parseInt(sd);
        int m = Integer.parseInt(sm);
        int y = Integer.parseInt(sy);
        System.out.println("Меня зовут " + name);
        System.out.println("Я родился " + d +"." + m + "." + y);

    }
}
