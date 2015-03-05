package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution {

    public static void main(String[] args) throws TooShortStringException
    {

        String s = "JavaRush - лучший сервис обучения Java.";
        System.out.println(getPartOfString(s));
    }

    public static String getPartOfString(String string) throws TooShortStringException
    {
        String ss;
        int amtSpace = 0;
        int startIndex = 0;
        int endIndex = 0;
        if (string == null) throw new TooShortStringException();
        char [] simvoli = string.toCharArray();
        for (int i = 0; i < simvoli.length; i++)
        {
           if (simvoli[i] == ' ') amtSpace++;
        }
        if (amtSpace < 4) throw new TooShortStringException();


        for (int i = 0; i < simvoli.length; i++)
        {
            int tempEndIndex = 0;
            if (simvoli[i] == ' ' && startIndex == 0) startIndex = i+1;
            if (simvoli[i] == ' ') {tempEndIndex = i; endIndex++;}
            if (endIndex == 4) {endIndex = tempEndIndex; break;}

        }
        if (endIndex + 1 == string.length()) throw new TooShortStringException();
        String sss = string.substring(endIndex + 1);
        if (sss.indexOf(" ") == -1) ss = string.substring(startIndex, endIndex) + string.substring(endIndex);
        else ss = string.substring(startIndex, endIndex) + " " + sss.substring(0, sss.indexOf(" "));

        return ss;
    }

    public static class TooShortStringException extends Exception {
    }
}
