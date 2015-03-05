package com.javarush.test.level15.lesson12.home04;


public class Sun implements Planet
{
    private static Sun B = new Sun();

    private Sun(){
        getInstance();
    }
    public static Sun getInstance()
    {
        return B;
    }
}
