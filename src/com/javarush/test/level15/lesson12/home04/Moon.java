package com.javarush.test.level15.lesson12.home04;


public class Moon implements Planet
{
    private static Moon B = new Moon();

    private Moon(){
        getInstance();
    }
    public static Moon getInstance()
    {
        return B;
    }
}
