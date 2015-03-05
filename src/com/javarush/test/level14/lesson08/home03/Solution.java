package com.javarush.test.level14.lesson08.home03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* User, Looser, Coder and Proger
1. Ввести [в цикле] с клавиатуры несколько строк (ключей).
Строки(ключи) могут быть такими: "user", "looser", "coder", "proger".
Ввод окончен, когда строка не совпадает ни с одной из выше указанных.

2. Для каждой введенной строки нужно:
2.1. Создать соответствующий объект [см Person.java], например, для строки "user" нужно создать объект класса User.
2.2. Передать этот объект в метод doWork.

3. Написать реализацию метода doWork, который:
3.1. Вызывает метод live() у переданного обекта, если этот объект (person) имеет тип User.
3.2. Вызывает метод doNothing(), если person имеет тип Looser.
3.3. Вызывает метод coding(), если person имеет тип Coder.
3.4. Вызывает метод enjoy(), если person имеет тип Proger.
*/

public class Solution implements Person
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        ArrayList<String> names = new ArrayList<String>();


        while (true)
        {
            key = reader.readLine();
            if (key.equals("user") || key.equals("looser") || key.equals("coder") || key.equals("proger")) names.add(key);
            else break;
        }
        //тут цикл по чтению ключей, пункт 1
        {

            for (int i = 0; i < names.size(); i++)
            {

                doWork(getPerson(names.get(i))); //вызываем doWork
            }

        //создаем объект, пункт 2

        }
    }

    public static void doWork(Person person)
    {
        if (person instanceof User) ((User) person).live();
        else
            if (person instanceof Looser) ((Looser) person).doNothing();
            else
                if (person instanceof Coder) ((Coder) person).coding();
                else ((Proger) person).enjoy();
// пункт 3
    }

    public static Person getPerson(String key)
    {
        Person person = null;
        if ("user".equals(key)) person = new User();
        else
        if ("looser".equals(key)) person = new Looser();
        else
        if ("coder".equals(key)) person = new Coder();
        else person = new Proger();

        return person;
    }


}
