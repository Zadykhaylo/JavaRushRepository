package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        String s;

        ArrayList<String> list = new ArrayList<String>();
        while (( s = reader.readLine()) != null)
        {
            String [] ss = s.split(" ");
            for (int i = 0; i < ss.length; i++)
            {
                char [] buf = ss[i].toCharArray();
                if (buf.length > 6) list.add(ss[i]);
            }
        }
        for (int i = 0; i < list.size(); i++)
        {
            if (i != list.size()-1) writer.write(list.get(i) + ",");
            else writer.write(list.get(i));
        }
        reader.close();
        writer.close();

    }
}
