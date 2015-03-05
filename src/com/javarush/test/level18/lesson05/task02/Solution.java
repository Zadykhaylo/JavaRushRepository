package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки ввода-вывода

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        String nameF;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        nameF = reader.readLine();
        FileInputStream myFile = new FileInputStream(nameF);

        int k = 0;
        while (myFile.available() > 0)
        {
            int bytE = myFile.read();
            if (bytE == 44) k++;

        }


        myFile.close();
        reader.close();
        System.out.print(k);
    }
}
