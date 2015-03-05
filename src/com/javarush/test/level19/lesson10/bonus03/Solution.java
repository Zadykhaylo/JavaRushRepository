package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader (reader.readLine()));
        reader.close();
//        BufferedReader reader1 = new BufferedReader(new FileReader ("d:\\first1.txt"));
        String s = "";
        while (reader1.ready()) {
            int ch = reader1.read();
            s += (char) ch;
        }
        reader1.close();

        s = s.replaceAll("\r\n ", " ");
        s = s.replaceAll("\r\n>", ">");
        s = s.replaceAll("\r\n", " ");
        s = s.replaceAll(" \r\n", " ");

        String tega = args[0];
        String tegaOtkr = "<" + tega + " ";
        String tegaOtkr2 = "<" + tega + ">";
        String tegaZakr = "</" + tega + ">";

        TreeMap<Integer, String> map = new TreeMap<Integer, String>();

//        try {
        ArrayList<Integer> otkr = new ArrayList<Integer>();
        ArrayList<Integer> zakr = new ArrayList<Integer>();

        int otkrRaz = -1;
        while (true){
            if (s.indexOf(tegaOtkr, otkrRaz) == -1) break;
            otkr.add(s.indexOf(tegaOtkr,otkrRaz));
            if (otkrRaz < s.length())  otkrRaz = s.indexOf(tegaOtkr,otkrRaz) + 1;
        }
            int otkrRaz2 = -1;
            while (true){
                if (s.indexOf(tegaOtkr2, otkrRaz2) == -1) break;
                otkr.add(s.indexOf(tegaOtkr2,otkrRaz2));
                if (otkrRaz2 < s.length())  otkrRaz2 = s.indexOf(tegaOtkr2,otkrRaz2) + 1;
            }

            Collections.sort(otkr);


        int zakrRaz = s.length()-1;
        while (true){
            if (s.lastIndexOf(tegaZakr, zakrRaz) == -1) break;
            zakr.add(s.lastIndexOf(tegaZakr, zakrRaz));
            if (zakrRaz > 0) zakrRaz = s.lastIndexOf(tegaZakr, zakrRaz) - 1;
        }
//        for (int i = 0; i < otkr.size(); i++)
//        {
//            System.out.println(otkr.get(i) + " (");
//        }
//        for (int i = 0; i < zakr.size(); i++)
//        {
//            System.out.println(zakr.get(i) + " )");
//        }
        for (int i = zakr.size() - 1; i >= 0; i--)
            {
                for (int j = otkr.size() - 1; j >= 0; j--)
                {
                   if (zakr.get(i) > otkr.get(j)) {
                       map.put(otkr.get(j), s.substring(otkr.get(j), zakr.get(i) + tegaZakr.length()));
                       otkr.remove(j); j=0;}
                }
            }

//        }
//        catch (StringIndexOutOfBoundsException e) {
//        }

        for (Map.Entry<Integer, String> pair : map.entrySet())
        {
            System.out.println(pair.getValue());
        }
    }
}
