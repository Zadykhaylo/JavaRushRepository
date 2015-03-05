package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        String myFile = reader1.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(myFile));
        reader1.close();
        ArrayList<String> list = new ArrayList<String>();

        String s;
        while ((s = reader.readLine()) != null)
        {
            String [] ss = s.split(" ");
            for (int i = 0; i < ss.length; i++)
            {
               list.add(ss[i]);
            }
        }
        reader.close();



        while (list.size() != 0)
        {
            int i = 0;
            StringBuilder ss = new StringBuilder(list.get(i));
            String sss = ss.reverse().toString();

            for (int j = 0; j < list.size(); j++)
            {
              if ((list.get(j).toString()).equals(sss) && i != j ) {
                  Pair pair = new Pair();
                  pair.first = list.get(i).toString();
                  pair.second = list.get(j).toString();
                  result.add(pair);
                  String sc = list.get(j);
                  list.remove(sc);
                  break;
              }
            }
            list.remove(i);
        }

        for (int j = 0; j < result.size(); j++)
        {
            System.out.println(result.get(j).first + " " + result.get(j).second);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
