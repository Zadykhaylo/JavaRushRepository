package com.javarush.test.level14.lesson06.home01;

public class MoldovanHen extends Hen implements Country
{

    int getCountOfEggsPerMonth()
    {
        return 22;
    }

    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}

