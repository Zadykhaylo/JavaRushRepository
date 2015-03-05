package com.javarush.test.level14.lesson06.home01;

public class RussianHen extends Hen implements Country
{

    int getCountOfEggsPerMonth()
    {
        return 20;
    }
    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}