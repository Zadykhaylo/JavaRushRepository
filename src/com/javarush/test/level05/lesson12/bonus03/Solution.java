package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {   int maximum = 0;
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String sn = r.readLine();
        int N = Integer.parseInt(sn);


            for (int i = 1; i <= N; i++)
            {
                String ssn = r.readLine();
                int nn = Integer.parseInt(ssn);
                if (nn > maximum) maximum = nn;
            }
            System.out.println(maximum);

    }
}
