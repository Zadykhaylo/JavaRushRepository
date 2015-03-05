package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> son11 = new ArrayList<Human>();
        Human son1 = new Human("son1", true, 6, son11);
        Human son2 = new Human("son2", true, 8, son11);
        Human son3 = new Human("son3", false, 10, son11);

        ArrayList<Human> mama1papa1 = new ArrayList<Human>();
        mama1papa1.add(son1);
        mama1papa1.add(son2);
        mama1papa1.add(son3);
        Human papa = new Human("papa", true, 30, mama1papa1);
        Human mama = new Human("mama", false, 29, mama1papa1);

        ArrayList<Human> ded11 = new ArrayList<Human>();
        ded11.add(papa);
        Human ded1 = new Human("ded1", true, 70, ded11);
        Human bab1 = new Human("bab1", false, 69, ded11);

        ArrayList<Human> ded22 = new ArrayList<Human>();
        ded22.add(mama);
        Human ded2 = new Human("ded2", true, 65, ded22);
        Human bab2 = new Human("bab2", false, 64, ded22);

        System.out.println(ded1);
        System.out.println(ded2);
        System.out.println(bab1);
        System.out.println(bab2);
        System.out.println(papa);
        System.out.println(mama);
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(son3);


        //Написать тут ваш код
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        Human (String name, boolean sex, int age, ArrayList<Human> children)
        {
          this.name = name;
          this.sex = sex;
          this.age = age;
          this.children = children;
        }//Написать тут ваш код

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
