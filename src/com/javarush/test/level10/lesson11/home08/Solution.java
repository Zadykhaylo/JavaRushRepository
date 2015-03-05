package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести на их экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {

        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<String> list3 = new ArrayList<String>();
        for (int i = 0; i < 3; i++)
        {
            list1.add("dfghdfgh"+(20*(i+1)));
            list2.add("dfghdfgh"+(30*(i+2)));
            list3.add("dfghdfgh"+(40*(i+3)));
        }
        ArrayList<String>[] arrayStringList = new ArrayList [3];
        arrayStringList[0] = list1;
        arrayStringList[1] = list2;
        arrayStringList[2] = list3;
        //Напишите тут ваш код

        return arrayStringList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}