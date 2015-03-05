package com.javarush.test.level13.lesson06.task01;

/* Dog, Cat и Mouse
1. Создать классы Dog, Cat и Mouse.
2. Реализовать интерфейсы в добавленных классах, учитывая что:
- Кот(Cat) может передвигаться, может кого-то съесть и может быть сам съеден.
- Мышь(Mouse) может передвигаться и может быть съедена.
- Собака(Dog) может передвигаться и съесть кого-то.
*/

public class Solution
{

    public interface Moveable //может двигаться
    {
        void move();
    }

    public interface Eatable  //может быть съеден
    {
        void eaten();
    }

    public interface Eat  //может кого-нибудь съесть
    {
        void eat();
    }

    public class Dog implements Eat, Moveable
    {

        public void eat()
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        public void move()
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    public class Mouse implements Moveable, Eatable
    {

        public void eaten()
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        public void move()
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    public class Cat implements Eat, Eatable, Moveable
    {

        public void eat()
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        public void eaten()
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        public void move()
        {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }
}