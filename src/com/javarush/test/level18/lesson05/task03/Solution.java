package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую половину.
Закрыть потоки ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        String nameF1, nameF2, nameF3;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        nameF1 = reader.readLine();
        nameF2 = reader.readLine();
        nameF3 = reader.readLine();
        FileInputStream myFile1 = new FileInputStream(nameF1);
        FileOutputStream myFile2 = new FileOutputStream(nameF2);
        FileOutputStream myFile3 = new FileOutputStream(nameF3);

        byte[] buffer1 = new byte[myFile1.available()];
        byte[] buffer2;
        byte[] buffer3;
        if ((buffer1.length % 2) == 0) buffer2 = new byte[buffer1.length / 2];
        else buffer2 = new byte[(buffer1.length / 2) + 1 ];
        buffer3 = new byte[buffer1.length - buffer2.length];

        if (myFile1.available() > 0) {

            //читаем весь файл одним куском
//            byte[] buffer = new byte[inputStream.available()];
            int count2 = myFile1.read(buffer2);
            myFile2.write(buffer2, 0, count2);
            int count3 = myFile1.read(buffer3);
            myFile3.write(buffer3, 0, count3);

            }







        myFile1.close();
        myFile2.close();
        myFile3.close();
        reader.close();


    }
}
