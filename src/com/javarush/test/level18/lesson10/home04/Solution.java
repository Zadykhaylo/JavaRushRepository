package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String nameF1, nameF2;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        nameF1 = reader.readLine();
        nameF2 = reader.readLine();
        FileInputStream myFile1 = new FileInputStream(nameF1);
        FileInputStream myFile2 = new FileInputStream(nameF2);


        int[] buffer = new int[myFile1.available()];

        int i = 0;
        while (myFile1.available() > 0)
        {
            buffer[i] = myFile1.read();
            i++;
        }
        myFile1.close();
        FileOutputStream myFile11 = new FileOutputStream(nameF1);
        while (myFile2.available() > 0)
        {
            int data = myFile2.read();
            myFile11.write(data);
        }

        for (int j = 0; j < buffer.length; j++)
        {
            myFile11.write(buffer[j]);
        }


        myFile2.close();
        myFile11.close();
        reader.close();
    }
}
