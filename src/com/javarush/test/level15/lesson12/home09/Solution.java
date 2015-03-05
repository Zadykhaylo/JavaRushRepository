package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String urlLink = reader.readLine();
        reader.close();

        ArrayList<String> all = new ArrayList <String>();
        ArrayList<String> allBezZnach = new ArrayList <String>();
        urlLink = urlLink.substring(urlLink.indexOf('?')+1);

        char [] par = urlLink.toCharArray();
        String s = "";
        for (int i = 0; i < par.length; i++)
        {
           if (par[i] != '&') s += par[i];
           else {
                  all.add(s);
                  s = "";
                }
        }
        all.add(s);
        for (int i = 0; i <all.size() ; i++)
        { if (all.get(i).indexOf("=") == -1) allBezZnach.add(all.get(i));
          else allBezZnach.add(all.get(i).substring(0, all.get(i).indexOf("=")));
        }
        for (int i = 0; i < allBezZnach.size(); i++)
        {
            System.out.print(allBezZnach.get(i)+" ");
        }
        System.out.println();
        for (int i = 0; i < all.size(); i++)
        {
          if (allBezZnach.get(i).equals("obj") && all.get(i).indexOf("obj=") != -1)
          {
              s = all.get(i).substring(all.get(i).indexOf("=")+1);


//              if (s.indexOf(".") != -1)
              {try{
              alert(Double.parseDouble(s));
              }
              catch (NumberFormatException e){
                  alert(s);
              }}
//              else alert(s);
          }
        }



        //add your code here
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
