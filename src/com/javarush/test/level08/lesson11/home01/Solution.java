package com.javarush.test.level08.lesson11.home01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый кот с новой строки.
*/

public class Solution
{   static Cat cat1 = new Cat();
    static Cat cat2 = new Cat();
    static Cat cat3 = new Cat();
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        cats.remove(cat2);
        //Написать тут ваш код. step 3 - пункт 3

        printCats(cats);
    }

    public static Set<Cat> createCats()
    {
        HashSet <Cat> cats = new HashSet <Cat>();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);

        //Написать тут ваш код. step 2 - пункт 2
        return cats;
    }

    public static void printCats(Set<Cat> cats)
    {
        Iterator<Cat> iterator = cats.iterator();
        while (iterator.hasNext())
        {
            Cat t = iterator.next();
            System.out.println(t);
        }
        // step 4 - пункт 4
    }

    public static class Cat
    {

    }
    // step 1 - пункт 1
}
