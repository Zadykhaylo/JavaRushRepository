package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
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
            int id = Integer.parseInt(args[1]);
            if (args[0].equals("-i"))
            {
                String s;
                if (allPeople.get(id).getSex() == Sex.MALE) s = "м";
                else s = "ж";
                System.out.println(allPeople.get(id).getName() + " " + s + " " + f2.format(allPeople.get(id).getBirthDay()) );
            }
            else {
                allPeople.get(id).setName(null);
                allPeople.get(id).setSex(null);
                allPeople.get(id).setBirthDay(null);

            }
        }
        if (args[0].equals("-c")) {
            Person person;
            if (args[2].equals("м")) person = Person.createMale(args[1], f.parse(args[3]));
            else person = Person.createFemale(args[1], f.parse(args[3]));
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        }
        if (args[0].equals("-u")) {
            Person person;
            if (args[3].equals("м")) person = Person.createMale(args[2], f.parse(args[4]));
            else person = Person.createFemale(args[2], f.parse(args[4]));
            allPeople.remove(Integer.parseInt(args[1]));
            allPeople.add(Integer.parseInt(args[1]), person);
        }

        //start here - начни тут
    }
}
