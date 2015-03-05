package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int  k1 = Integer.parseInt(reader.readLine());
        int  k2 = Integer.parseInt(reader.readLine());
        System.out.println(gcd(k1, k2));
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        int x = a % b;
        System.out.println(x);
        return gcd(b, x);
    }
}
