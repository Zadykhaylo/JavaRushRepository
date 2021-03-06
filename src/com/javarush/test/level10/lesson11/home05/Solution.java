package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).
 Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for(int i=0;i<32;i++)
        {
            alphabet.add( (char) ('а'+i));
        }
        alphabet.add(6,'ё');

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<10;i++)
        {
            String s = reader.readLine();
            list.add( s.toLowerCase());
        }

        ArrayList<Integer> kolvo = new ArrayList<Integer>();
        for (int i = 0; i < 33; i++)
        {
           kolvo.add(i, 0);
//            System.out.println(kolvo.get(i));
        }

        for (int i = 0; i < list.size(); i++)
        {
           String s = list.get(i);
           char[] ch = s.toCharArray();

            for (int j = 0; j < ch.length; j++)
            {
                for (int k = 0; k < alphabet.size(); k++)
                {
                       if (ch[j] == alphabet.get(k))
                       {
                           int f = kolvo.get(k);
                           f = f + 1;
                           kolvo.set(k, f);
//                           System.out.println(ch[j] + " " + alphabet.get(k) + " " + kolvo.get(k));
                       }



                }

            }

        }

        for (int i = 0; i < alphabet.size(); i++)
        {
            System.out.println(alphabet.get(i) + " " + kolvo.get(i));
        }


        //Напишите тут ваш код
    }

}
