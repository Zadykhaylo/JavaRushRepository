package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String nameF;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        nameF = reader.readLine();
        FileInputStream myFile = new FileInputStream(nameF);
        int max = myFile.read();

        while (myFile.available() > 0)
        {
            int d = myFile.read();
            if (d < max) max = d;
        }
        myFile.close();
        reader.close();
        System.out.println(max);
    }
}
