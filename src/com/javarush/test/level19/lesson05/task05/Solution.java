package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
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
            if (Character.isDigit(n) || Character.isAlphabetic(n)) writer1.write(n);



        }
        reader1.close();
        writer1.close();
    }


}
