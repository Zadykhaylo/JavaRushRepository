package com.javarush.test.level04.lesson16.home03;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1,
вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/
import java.io.*;
public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        int s = 0, bb;
        String sf = "-1", ss = "-1", sc;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (ss.equals(sf))
        {
            sc = in.readLine();
            bb = Integer.parseInt(sc);
            if (bb == -1) {s = s + bb; sf = "0";}
            else s = s + bb;
        }
        System.out.println(s);
    }
}
