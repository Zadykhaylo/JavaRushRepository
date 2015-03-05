package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть поток

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        String myFile = reader1.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(myFile));
        reader1.close();

        String s;
        while ((s = reader.readLine()) != null)
        {
            String result = "";
            char [] ss = s.toCharArray();
            for (int i = ss.length - 1; i >= 0; i--)
            {
                result += ss [i];
            }

            System.out.println(result);
        }

        reader.close();
    }
}
