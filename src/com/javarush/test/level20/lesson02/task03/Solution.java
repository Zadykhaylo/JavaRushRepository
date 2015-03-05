package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

//    public static void main(String[] args) throws Exception
//    {
//
//        Solution solution = new Solution();
//        solution.fillInPropertiesMap();
//        for (Map.Entry<String, String> pair : properties.entrySet())
//        {
//            String s = pair.getKey() + " ***** " + pair.getValue();
//            System.out.println((s));
//
//        }
//        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
//        String myFile2 = reader2.readLine();
//        reader2.close();
//        OutputStream outputStream = new FileOutputStream(myFile2);
//        solution.save(outputStream);
//        outputStream.close();
//    }
    public void fillInPropertiesMap() throws Exception
    {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        String myFile = reader1.readLine();
        reader1.close();
        FileInputStream inputStream = new FileInputStream(myFile);
        Properties property = new Properties();
        this.load(inputStream);
        inputStream.close();

//implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter printWriter = new PrintWriter(outputStream);
        Properties property = new Properties();
        for (Map.Entry<String, String> pair : properties.entrySet())
            {
                property.put(pair.getKey(), pair.getValue());
            }

        property.store(printWriter, "XA-XA-XA-XA-XA-XA-XA-XA-XA");
        printWriter.close();

    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties property = new Properties();
        property.load(inputStream);
        Enumeration enumeration = property.keys();
        while (enumeration.hasMoreElements()){
            String key = enumeration.nextElement().toString();
            properties.put(key, property.getProperty(key).toString());
            }

    }

}
