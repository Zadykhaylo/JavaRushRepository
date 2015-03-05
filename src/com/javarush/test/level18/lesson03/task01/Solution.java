package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String nameF;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        nameF = reader.readLine();
        FileInputStream myFile = new FileInputStream(nameF);
        int max=0;

        while (myFile.available() > 0)
        {
            int d = myFile.read();
            if (d > max) max = d;
        }
        myFile.close();
        System.out.println(max);

    }
}
