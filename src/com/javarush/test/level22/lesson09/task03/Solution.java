package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args)
    {
        try {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        String myFile = reader1.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(myFile));
        reader1.close();

        String s, allS = reader.readLine();
        while ((s = reader.readLine()) != null)
        {
            allS += " " + s;
        }
        reader.close();
            if (allS != null && allS.length() != 0)
            {
                String [] ss = allS.split(" ");
                StringBuilder result = getLine(ss);
                System.out.println(result.toString());
            }
            else System.out.println();

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static StringBuilder getLine(String... words) {
        if (words == null) return new StringBuilder();
        if (words.length == 0) return new StringBuilder();
        ArrayList<String> allWords = new ArrayList<String>();
        for(String s : words)
        {
            allWords.add(s);
        }
        StringBuilder result = new StringBuilder(allWords.get(0));
        allWords.remove(0);
        while (allWords.size() != 0)
        {
            int i = 0;
            String resultToLower = result.toString().toLowerCase();

            for (int j = 0; j < allWords.size(); j++)
            {
                if (resultToLower.charAt(resultToLower.length()-1) == allWords.get(j).toLowerCase().charAt(0))
                {
                    String sc = allWords.get(j);
                    result.append(" " + sc);
                    allWords.remove(sc);
                    break;
                }
            }
            for (int j = 0; j < allWords.size(); j++)
            {
                if (resultToLower.charAt(0) == allWords.get(j).toLowerCase().charAt(allWords.get(j).length()-1))
                {
                    String sc = allWords.get(j);
                    result.insert(0, (sc + " "));
                    allWords.remove(sc);
                    break;
                }
            }
        }
        return result;
    }

}
