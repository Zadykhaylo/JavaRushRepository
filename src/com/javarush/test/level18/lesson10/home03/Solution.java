package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String nameF1, nameF2, nameF3;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        nameF1 = reader.readLine();
        nameF2 = reader.readLine();
        nameF3 = reader.readLine();
        FileOutputStream myFile1 = new FileOutputStream(nameF1);
        FileInputStream myFile2 = new FileInputStream(nameF2);
        FileInputStream myFile3 = new FileInputStream(nameF3);


        while (myFile2.available() > 0)
        {
            int data = myFile2.read();
            myFile1.write(data);
        }
        while (myFile3.available() > 0)
        {
            int data = myFile3.read();
            myFile1.write(data);
        }

        myFile1.close();
        myFile2.close();
        myFile3.close();
        reader.close();

    }
}
