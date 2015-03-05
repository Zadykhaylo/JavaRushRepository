package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Пример ввода:
мама     мыла раму.
Пример вывода:
Мама     Мыла Раму.
*/

public class Solution
{   public static int j = 1;
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        String lows = s.toLowerCase();
        char[] ch = lows.toCharArray();
        ch[0] = Character.toUpperCase(ch[0]);
        int j = 0, k = 0;
        while (k != -1)
        {
            k = lows.indexOf(" ", j);
            j = k+1;
            if (j > ch.length) break;
            ch[j] = Character.toUpperCase(ch[j]);
        }


        lows = new String(ch);
        System.out.println(lows);
        //Напишите тут ваш код

    }

}
