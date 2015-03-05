package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException
    {
        String myFile = args[0];
        BufferedReader in = new BufferedReader(new FileReader(myFile));
        SimpleDateFormat f = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
        String s;
        while ((s = in.readLine()) != null) {
            String [] ss = s.split(" ");
            String sDate = ss[ss.length-3] + " " + ss[ss.length-2] + " " + ss[ss.length-1];

            String name = "";
            if (ss.length == 4) name = ss[0];
            else
            {
                for (int i = 0; i < ss.length-4; i++)
                {
                    name += ss[i] + " ";
                }
                name += ss[ss.length-4];
            }
            byte[] utf8Bytes = name.getBytes("UTF-8");
            String nameInUTF = new String(utf8Bytes, "UTF-8");

            Person person = new Person(nameInUTF, f.parse(sDate));
            PEOPLE.add(person);
        }
        in.close();
        for (int i = 0; i < PEOPLE.size(); i++)
        {
            System.out.println(PEOPLE.get(i).getName() + "+++++++++" + f.format(PEOPLE.get(i).getBirthday()));
        }
    }

}

//if (args[0].equals("-c")) {
//        Person person;
//int i1 = 1, i2 = 2, i3 = 3;
//while (i3 < args.length)
//        {
//        if (args[i2].equals("м")) person = Person.createMale(args[i1], f.parse(args[i3]));
//else person = Person.createFemale(args[i1], f.parse(args[i3]));
//allPeople.add(person);
//System.out.println(allPeople.indexOf(person));
//i1 += 3; i2 += 3; i3 += 3;
//}
//        }