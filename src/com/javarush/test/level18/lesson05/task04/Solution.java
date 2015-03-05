package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        String nameF1, nameF2;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        nameF1 = reader.readLine();
        nameF2 = reader.readLine();

        FileInputStream inFile1 = new FileInputStream(nameF1);
        FileOutputStream outFile2 = new FileOutputStream(nameF2);

        int[] buffer1 = new int[inFile1.available()];


        int i = 0;
        while (inFile1.available() > 0)
        {
            buffer1[i] = inFile1.read();
            i++;
        }
        for (int j = buffer1.length-1; j >=0 ; j--)
        {
             outFile2.write(buffer1[j]);
        }



        inFile1.close();
        outFile2.close();
        reader.close();
    }
}
