package com.javarush.test.level26.lesson02.task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {

    public static void main(String[] args)
    {
        Integer [] array = {20, 16, 2, 8, 9, 17};
        sort(array);
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
    }

    public static Integer[] sort(Integer[] array) {

        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
        Collections.sort(list);

        final double mediana;
        if (list.size() % 2 == 0) mediana = (double)(list.get(list.size()/2-1) + list.get(list.size()/2))/2;
        else mediana = (double)list.get(list.size()/2);

        Comparator<Integer> comparatorMediana = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                if (Math.abs(mediana - o1) == Math.abs(mediana - o2)) return o1 - o2;
                else return (int) (Math.abs(mediana - o1) - Math.abs(mediana - o2));
            }
        };
        Collections.sort(list, comparatorMediana);
        for (int i = 0; i < array.length; i++)
        {
           array[i] = list.get(i);
        }


        //implement logic here
        return array;
    }
}
