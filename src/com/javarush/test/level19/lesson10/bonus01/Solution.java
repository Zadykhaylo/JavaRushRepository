package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String myFile1 = reader.readLine();
        String myFile2 = reader.readLine();
        BufferedReader reader1 = new BufferedReader(new FileReader(myFile1));
        BufferedReader reader2 = new BufferedReader(new FileReader(myFile2));
        reader.close();
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        String s;
        while ((s = reader1.readLine()) != null) list1.add(s);
        reader1.close();
        while ((s = reader2.readLine()) != null) list2.add(s);
        reader2.close();

        int i = 0;
        for (int j = 0; j < list2.size(); j++)
        {
            if (list2.get(j).equals(list1.get(i))) lines.add(new LineItem(Type.SAME, list1.get(i)));
            else
                {
                    if (i + 1 < list1.size()) {
                                                  if (list2.get(j).equals(list1.get(i+1))) {lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                                                                                            j--;
                                                                                            }
                                                  else {lines.add(new LineItem(Type.ADDED, list2.get(j))); i--;}
                                              }
                    else lines.add(new LineItem(Type.ADDED, list2.get(j)));
                }
            if (i + 1 < list1.size()) i++;
//            else {
//                while (j < list2.size()){
//                    lines.add(new LineItem(Type.ADDED, list2.get(j)));
//                    j++;
//                }
//            }
//            if ( j + 1 == list2.size() && i + 1 < list1.size())
//            {
//                while (i < list1.size()){
//                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
//                    i++;
//                }
//            }
        }


        for (int k = 0; k < lines.size(); k++)
        {
            System.out.println(lines.get(k).type + " " + lines.get(k).line);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
