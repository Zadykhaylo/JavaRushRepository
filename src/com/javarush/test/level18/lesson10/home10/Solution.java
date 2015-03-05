package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> list = new ArrayList<String>();
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            String nameF = reader.readLine();
            if (nameF.equals("end")) break;
            list.add(nameF);
        }
        reader.close();
        for (int i = 0; i < list.size(); i++)
        {
            String s = list.get(i).substring(list.get(i).lastIndexOf('.') + 1);
            s = s.substring(s.lastIndexOf('t')+1);
            int n = Integer.parseInt(s);
            map.put(n, list.get(i));
        }

//        for (Map.Entry<Integer, String> pair : map.entrySet())
//        {
//            System.out.println(pair.getKey() + " ++ " + pair.getValue());
//        }

        String fileName = list.get(0).substring(0, list.get(0).lastIndexOf('.'));
        File fileIsh = new File(list.get(0));
        String dir = fileIsh.getAbsolutePath();
        dir = dir.substring(0, dir.lastIndexOf('\\')+1);
//        System.out.println("fileName - " + fileName);
//        System.out.println("DIR - " + dir);
//        System.out.println("-----------------");

        FileOutputStream outputStream = new FileOutputStream(dir + fileName);

         for (Map.Entry<Integer, String> pair : map.entrySet())
        {
            FileInputStream inputStream = new FileInputStream(pair.getValue());
            if (inputStream.available() > 0)
            {
                byte[] buffer = new byte[inputStream.available()];
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, count);
            }
            inputStream.close();
        }




        outputStream.close();




//        File file1 = new File(dir + fileName);
//        System.out.println(file1.getAbsolutePath());
//        System.out.println(file1.exists());
    }
}
