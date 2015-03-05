package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            String nameF = reader.readLine();
            if (nameF.equals("exit")) break;
            list.add(nameF);
        }

        for (int i = 0; i < list.size(); i++)
        {
            ReadThread readThread = new ReadThread(list.get(i));
            readThread.start();
        }
//        FileInputStream myFile = new FileInputStream(nameF);
        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) throws FileNotFoundException
        {
            this.fileName = fileName;

//            start();
            //implement constructor body
//            d:\\first1.txt
        }

        public void run (){
            int max=0, keyMax=0;

            try
            {   FileInputStream myFile = new FileInputStream(fileName);
                HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
                while (myFile.available() > 0)
                {
                    int bytE = myFile.read();
                    if (!map.containsKey(bytE)) map.put(bytE, 1);
                    else {
                        int value = map.get(bytE)+1;
                        map.remove(bytE);
                        map.put(bytE, value);
                    }
                }
                myFile.close();
                for (Map.Entry<Integer, Integer> pair : map.entrySet())
                {
                    if (pair.getValue() > max) {max = pair.getValue(); keyMax = pair.getKey();}
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

            resultMap.put(fileName, keyMax);

//           System.out.println(fileName + " +++ "  + keyMax);
        }// implement file reading here - реализуйте чтение из файла тут
    }
}
