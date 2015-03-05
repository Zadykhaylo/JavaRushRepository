package com.javarush.test.level19.lesson10.home04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        String myFile = reader1.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(myFile));


        String s;
        int count = 0;
        while ((s = reader.readLine()) != null)
        {

            String [] ss = s.split(" ");
            for (int i = 0; i < ss.length; i++)
            {
                for (int j = 0; j < words.size(); j++)
                {
                    if (ss[i].equals(words.get(j))) count++;
                }
            }

            if (count == 2) System.out.println(s);
            count = 0;

        }
        reader1.close();
        reader.close();
    }
}
