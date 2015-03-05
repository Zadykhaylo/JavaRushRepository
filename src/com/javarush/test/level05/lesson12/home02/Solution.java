package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        Man man1 = new Man("Vasja", 20, "Mariupol");
        Man man2 = new Man("Vova", 25, "Donetsk");
        Woman woman1 = new Woman("Masha", 18, "Mariupol");
        Woman woman2 = new Woman("Manja", 19, "Donetsk");

        System.out.println(man1);
        System.out.println(man2);
        System.out.println(woman1);
        System.out.println(woman2);


    }

    public static class Man
    {
        String name,address;
        int age;

        Man (String name, int age, String address){
           this.name = name;
           this.age = age;
           this.address = address;
        }

        public String toString() {
            String fio = this.name + " " + this.age + " " + this.address;
            return fio;
        }
    }

    public static class Woman
    {
        String name,address;
        int age;

        Woman (String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String toString() {
            String fio = this.name + " " + this.age + " " + this.address;
            return fio;
        }
    }
}
