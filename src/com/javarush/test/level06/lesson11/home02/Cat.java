package com.javarush.test.level06.lesson11.home02;

import java.util.ArrayList;

/* Статические коты
1. В классе Cat добавь public статическую переменную cats (ArrayList<Cat>).
2. Пусть при каждом создании кота (нового объекта Cat) в переменную cats добавляется этот новый кот. Создать 10 объектов Cat.
3. Метод printCats должен выводить всех котов на экран. Нужно использовать переменную cats.
*/

public class Cat {
    public Cat() {

    }
    public static ArrayList<Cat> cats = new ArrayList<Cat>();
    //add your code here - добавь свой код тут

    public static void main(String[] args) {
        Cat cat01 = new Cat();
        cats.add( cat01);
        Cat cat02 = new Cat();
        cats.add( cat02);
        Cat cat03 = new Cat();
        cats.add( cat03);
        Cat cat04 = new Cat();
        cats.add( cat04);
        Cat cat05 = new Cat();
        cats.add( cat05);
        Cat cat06 = new Cat();
        cats.add( cat06);
        Cat cat07 = new Cat();
        cats.add( cat07);
        Cat cat08 = new Cat();
        cats.add( cat08);
        Cat cat09 = new Cat();
        cats.add( cat09);
        Cat cat10 = new Cat();
        cats.add( cat10);
        //Create 10 Cat-s here - создай 10 котов тут
        printCats();
    }

    public static void printCats() {
        for (int i = 0; i < cats.size(); i++)
        System.out.println(cats.get(i));
        //add your step 3 code here - добавь свой код для пункта 3 тут
    }
}
