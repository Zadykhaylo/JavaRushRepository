package com.javarush.test.level10.lesson11.home04;

/* Большая зарплата
Вывести на экран надпись «Я не хочу изучать Java, я хочу большую зарплату» 40 раз по образцу.
Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        char [] ch = s.toCharArray();
        int j = 0;

        for (int i = 1; i <= 40; i++)
        {
            String ins = "";
            for (int k = j; k < ch.length; k++)
            {
            ins  = ins + ch[k];
            }
            System.out.println(ins);
            j++;
        }

        //Напишите тут ваш код
    }

}
