package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException
    {

        String s = "Ja\tvaRush \t\t  обучения Ja\tva.";
        System.out.println(getPartOfString(s));
    }

    public static String getPartOfString(String string) throws TooShortStringException
    {
        String ss;
        int amtTab = 0;
        int startIndex = 0;
        int endIndex = 0;
        if (string == null) throw new TooShortStringException();

        char [] simvoli = string.toCharArray();
        for (int i = 0; i < simvoli.length; i++)
        {
            if (simvoli[i] == '\t') amtTab++;
        }
        if (amtTab < 2) throw new TooShortStringException();


        for (int i = 0; i < simvoli.length; i++)
        {
            if (simvoli[i] == '\t' && startIndex == 0) startIndex = i+1;
            if (simvoli[i] == '\t') endIndex++;
            if (endIndex == 2) {endIndex = i; break;}
        }

        ss = string.substring(startIndex, endIndex);


        return ss;
    }

    public static class TooShortStringException extends Exception {
    }
}
