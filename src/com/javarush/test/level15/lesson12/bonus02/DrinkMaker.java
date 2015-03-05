package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created with IntelliJ IDEA.
 * User: Leo
 * Date: 19.02.14
 * Time: 14:36
 * To change this template use File | Settings | File Templates.
 */
public abstract class DrinkMaker
{
    abstract void getRightCup(); //- выбрать подходящую чашку
    abstract void putIngredient(); // - положить ингредиенты
    abstract void pour(); // - залить жидкостью

    void makeDrink(){
        getRightCup();
        putIngredient();
        pour();
    }
}
