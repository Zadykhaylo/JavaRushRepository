package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        String myFile = args[0];
        BufferedReader in = new BufferedReader(new FileReader(myFile));
        TreeMap<String, Double> map = new TreeMap<String, Double>();

        String s;
        while ((s = in.readLine()) != null) {
            String [] ss = s.split(" ");
            if (!map.containsKey(ss[0])) map.put(ss[0], Double.parseDouble(ss[1]));
            else {
                double value = map.get(ss[0])+Double.parseDouble(ss[1]);
                map.remove(ss[0]);
                map.put(ss[0], value);
            }
        }
        in.close();

        for (Map.Entry<String, Double> pair : map.entrySet())
        {
            System.out.println( pair.getKey()+ " " + pair.getValue());
        }

    }
}
