package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
 Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей.
  Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human ded1 = new Human("Ded1", true, 60, null, null);
        Human ded2 = new Human("Ded2", true, 59, null, null);
        Human bab1 = new Human("Bab1", false, 60, null, null);
        Human bab2 = new Human("Bab2", false, 59, null, null);
        Human papa = new Human("Papa", true, 40, ded1, bab1);
        Human mama = new Human("Mama", false, 38, ded2, bab2);
        Human bebi1 = new Human("Babi1", true, 18, papa, mama);
        Human bebi2 = new Human("Babi2", true, 17, papa, mama);
        Human bebi3 = new Human("Babi3", false, 16, papa, mama);

        System.out.println(ded1);
        System.out.println(ded2);
        System.out.println(bab1);
        System.out.println(bab2);
        System.out.println(papa);
        System.out.println(mama);
        System.out.println(bebi1);
        System.out.println(bebi2);
        System.out.println(bebi3);
        //Написать тут ваш код
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
          this.name = name;
          this.sex = sex;
          this.age = age;
          this.father = father;
          this.mother = mother;
        }
        //Написать тут ваш код

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
