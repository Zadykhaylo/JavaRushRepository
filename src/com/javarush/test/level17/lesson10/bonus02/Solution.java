package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat f2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        if (args[0].equals("-i") || args[0].equals("-d")) {

            if (args[0].equals("-i"))
            {
                for (int i = 1; i < args.length; i++)
                {
                int id1 = Integer.parseInt(args[i]);
                String s;
                if (allPeople.get(id1).getSex() == Sex.MALE) s = "м";
                else s = "ж";
                System.out.println(allPeople.get(id1).getName() + " " + s + " " + f2.format(allPeople.get(id1).getBirthDay()) );
                }
            }
            else {
                for (int i = 1; i < args.length; i++)
                {
                int id = Integer.parseInt(args[i]);
                allPeople.get(id).setName(null);
                allPeople.get(id).setSex(null);
                allPeople.get(id).setBirthDay(null);
                }
            }
        }
        if (args[0].equals("-c")) {
            Person person;
            int i1 = 1, i2 = 2, i3 = 3;
            while (i3 < args.length)
            {
            if (args[i2].equals("м")) person = Person.createMale(args[i1], f.parse(args[i3]));
            else person = Person.createFemale(args[i1], f.parse(args[i3]));
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
            i1 += 3; i2 += 3; i3 += 3;
            }
        }
        if (args[0].equals("-u")) {
            Person person;
            int i1 = 1, i2 = 2, i3 = 3, i4 = 4;
            while (i4 < args.length)
            {
            if (args[i3].equals("м")) person = Person.createMale(args[i2], f.parse(args[i4]));
            else person = Person.createFemale(args[i2], f.parse(args[i4]));
            allPeople.remove(Integer.parseInt(args[i1]));
            allPeople.add(Integer.parseInt(args[i1]), person);
            i1 += 4; i2 += 4; i3 += 4; i4 += 4;
            }
        }

//        for (int i = 0; i < allPeople.size(); i++)
//        {
//            String s;
//            if (allPeople.get(i).getSex() == Sex.MALE) s = "м";
//            else s = "ж";
//            System.out.println(allPeople.get(i).getName() + " " + s + " " + f2.format(allPeople.get(i).getBirthDay()) );
//        }

        //start here - начни тут
    }
}
