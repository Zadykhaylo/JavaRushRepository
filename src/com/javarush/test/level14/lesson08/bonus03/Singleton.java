package com.javarush.test.level14.lesson08.bonus03;


public class Singleton
{
    private static Singleton B = new Singleton();

    private Singleton(){
        getInstance();
    }
    public static Singleton getInstance()
    {
     return B;
    }
}
