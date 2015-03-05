package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String name, surname, address;
        int age, hight, id_number;

       Human()
        {
        }

        Human (String name)
        {
            this.name = name;
        }

       Human (String name, String surname)
       {
           this.name = name;
           this.surname = surname;
       }

        Human (String name, String surname, String address)
        {
            this.name = name;
            this.surname = surname;
            this.address = address;
        }

        Human (String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        Human (String name, int age, int hight)
        {
            this.name = name;
            this.age = age;
            this.hight = hight;
        }

        Human (String name, String surname, int id_number)
        {
            this.name = name;
            this.surname = surname;
            this.id_number = id_number;
        }
        Human (String name, String surname, String address, int id_number)
        {
            this.name = name;
            this.surname = surname;
            this.address = address;
            this.id_number = id_number;
        }
        Human (String name, String surname, String address, int age, int id_number)
        {
            this.name = name;
            this.surname = surname;
            this.address = address;
            this.age = age;
            this.id_number = id_number;
        }
        Human (String name, String surname, String address, int age, int hight, int id_number)
        {
            this.name = name;
            this.surname = surname;
            this.address = address;
            this.age = age;
            this.hight = hight;
            this.id_number = id_number;
        }
       //напишите тут ваши переменные и конструкторы
    }
}
