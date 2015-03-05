package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
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

        int i = 1;
        while (reader1.ready()){
             int data = reader1.read();
            if (i%2 == 0) writer1.write(data);
            i++;
        }
        reader.close();
        reader1.close();
        writer1.close();
    }
}
