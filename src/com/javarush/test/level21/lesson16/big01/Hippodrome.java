package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome
{
    private ArrayList<Horse> horses = new ArrayList<Horse>();
    public static Hippodrome game;

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public static void main(String[] args)
    {
        game = new Hippodrome();
        Horse horse1 = new Horse("Speed", 3, 0);
        Horse horse2 = new Horse("Prince", 3, 0);
        Horse horse3 = new Horse("Lord", 3, 0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();
        game.printWinner();
    }

    public void run ()
    {
        for (int i = 0; i < 100; i++)
        {
            move();
            print();
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
    public void move (){
        for (int i = 0; i < horses.size(); i++)
        {
           horses.get(i).move();
        }
    }
    public void print (){
        for (int i = 0; i < horses.size(); i++)
        {
            horses.get(i).print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner(){
        double maxDistance = 0;
        int index = 0;
        for (int i = 0; i < horses.size(); i++)
        {
            if ( maxDistance < horses.get(i).getDistance()) { maxDistance = horses.get(i).getDistance(); index = i;}

        }
        return horses.get(index);
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

}
