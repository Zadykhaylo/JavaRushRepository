package com.javarush.test.level15.lesson12.home07;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Файл в статическом блоке
1. Инициализируй константу Constants.FILE_NAME полным путем к файлу с данными, который содержит несколько строк.
2. В статическом блоке считай из файла с именем Constants.FILE_NAME все строки и добавь их по-отдельности в List lines.
3. Закрой поток ввода методом close().
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {

        try {
            int i = 0;
            Scanner in = new Scanner(new File(Constants.FILE_NAME));
            while(in.hasNext())
            {
                lines.add(in.nextLine());
            }
            in.close();


//        FileInputStream fileInputStream = new FileInputStream(Constants.FILE_NAME);
//            int c;
//            String s = "";
//
//            while ((c = fileInputStream.read()) != -1)
//            {
//                s = s + (char) c;
//            }
//            fileInputStream.close();
//            char[] chars = s.toCharArray();
//            String r = "";
//            String s2 = "";
//            for (int i = 0; i < chars.length; i++)
//            {
//
//                s2 = "" + chars[i];
//                if (s2.equals("\n")) {lines.add(r); r = ""; i++;}
//                r = r + chars [i];
//
//
//            }
        }
        catch (Exception e)
        {

        }

    }
    public static void main(String[] args) {
        System.out.println(lines);

    }
}
