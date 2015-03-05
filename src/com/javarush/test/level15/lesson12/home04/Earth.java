package com.javarush.test.level15.lesson12.home04;


public class Earth implements Planet
{
    private static Earth B = new Earth();

    private Earth(){
        getInstance();
    }
    public static Earth getInstance()
    {
        return B;
    }
}
