package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки,
которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. выбросить исключение CorruptedDataException
4.2. очистить allLines от данных
Сигнатуру метода main не менять
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    static String firstFileName;
    static String secondFileName;


    public static void main(String[] args)
    {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();

            BufferedReader in1 = new BufferedReader(new FileReader(firstFileName));
            BufferedReader in2 = new BufferedReader(new FileReader(secondFileName));

            String s;
            while ((s = in1.readLine()) != null) {
                allLines.add(s);
            }
            in1.close();
            while ((s = in2.readLine()) != null) {
                forRemoveLines.add(s);
            }
            in2.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        try
        {
            Solution d = new Solution();
            d.joinData();
        }
        catch (CorruptedDataException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public synchronized void joinData () throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines) ) {
            allLines.removeAll(forRemoveLines)  ;
            return;
        }

        for (String s : forRemoveLines) {
            if (!allLines.contains(s)){
                allLines.clear();
                throw  new CorruptedDataException();
            }

        }

    }
}
