package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
//        FileInputStream inputStream = new FileInputStream(args[1]);
//        FileOutputStream outputStream = new FileOutputStream(args[2]);

         shifr (args[1], args[2]);
//       if (args[0].equals("-e"))
//            {
//                if (inputStream.available() > 0)
//                {
//                    int count = inputStream.read()+1;
//                    outputStream.write(count);
//                }
//            }
//        if (args[0].equals("-d"))
//            {
//                if (inputStream.available() > 0)
//                {
//                    int count = inputStream.read()-1;
//                    outputStream.write(count);
//                }
//            }
//
//
//
//        inputStream.close();
//        outputStream.close();

    }
    public static void shifr (String fileName, String fileOutputName) throws IOException
    {

        FileInputStream inFile1 = new FileInputStream(fileName);
        FileOutputStream outFile2 = new FileOutputStream(fileOutputName);

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

    }

}
