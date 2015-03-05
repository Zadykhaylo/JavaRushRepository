package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String s = args[0];
        FileInputStream myFile = new FileInputStream(s);
        int count = 0, prob = 0;

        while (myFile.available() > 0)
        {
            int d = myFile.read();
            count ++;
            if (d == 32) prob ++;
        }
        float ch = (float)prob/count*100;
        myFile.close();
        System.out.println(String.format("%.2f", ch));
    }
}
