package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException
    {

        String s = args[0];
        FileInputStream myFile = new FileInputStream(s);
        int count = 0;

        while (myFile.available() > 0)
        {
            int d = myFile.read();
            if ((d > 64 && d < 91) || (d > 96 && d < 123)) count ++;
        }
        myFile.close();
        System.out.println(count);

//        final int CODE_START = 0;
//        final int CODE_END = 1000;
//        for ( char c = CODE_START; c < CODE_END; c ++ ){
//                    System.out.println( c + " - " + ( ( int ) c ) );
//        }


    }
}
