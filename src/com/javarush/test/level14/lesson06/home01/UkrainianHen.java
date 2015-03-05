package com.javarush.test.level14.lesson06.home01;

public class UkrainianHen extends Hen implements Country
{

    int getCountOfEggsPerMonth()
    {
        return 21;
    }

    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
