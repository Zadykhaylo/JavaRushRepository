package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/
import java.io.*;
public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String sn1 = r.readLine();
        String sn2 = r.readLine();
        String sn3 = r.readLine();
        int n1 = Integer.parseInt(sn1);
        int n2 = Integer.parseInt(sn2);
        int n3 = Integer.parseInt(sn3);
        if ((n1 < n2 && n1 > n3) || (n1 < n3 && n1 > n2)) System.out.println(n1);
        if ((n2 < n1 && n2 > n3) || (n2 < n3 && n2 > n1)) System.out.println(n2);
        if ((n3 < n2 && n3 > n1) || (n3 < n1 && n3 > n2)) System.out.println(n3);
    }
}
