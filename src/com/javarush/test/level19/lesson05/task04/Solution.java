package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameF1 = reader.readLine();
        String nameF2 = reader.readLine();
        FileReader reader1 = new FileReader (nameF1);
        FileWriter writer1 = new FileWriter(nameF2);
        reader.close();

        while (reader1.ready())
        {
            int n = reader1.read();
            if (n == 46) writer1.write(33);
            else writer1.write(n);

        }
        reader1.close();
        writer1.close();
    }
}
