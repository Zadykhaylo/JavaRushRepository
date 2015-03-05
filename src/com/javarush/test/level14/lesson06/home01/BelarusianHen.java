package com.javarush.test.level14.lesson06.home01;


public class BelarusianHen extends Hen implements Country
{

    int getCountOfEggsPerMonth()
    {
        return 21;
    }

    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
