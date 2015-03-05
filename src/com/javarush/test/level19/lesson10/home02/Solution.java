package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма. Имена разделять пробелом
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
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
        double max = 0;
        for (Map.Entry<String, Double> pair : map.entrySet())
        {
            if (pair.getValue() > max) max = pair.getValue();
        }
        for (Map.Entry<String, Double> pair : map.entrySet())
        {
            if (pair.getValue() == max) System.out.println( pair.getKey());
        }
    }
}
