package com.javarush.test.level15.lesson12.home05;


public class SubSolution extends Solution
{


    public SubSolution()
    {
        super();
    }

    public SubSolution(int i, int j)
    {
        super(i, j);
    }

    public SubSolution(int i, int j, int k)
    {
        super(i, j, k);
    }

    protected SubSolution(int i, String s)
    {
        super(i, s);
    }

    protected SubSolution(int i, int j, String s)
    {
        super(i, j, s);
    }

    protected SubSolution(int i, int j, int k, String s)
    {
        super(i, j, k, s);
    }

    SubSolution(int i, String s, String d)
    {
        super(i, s, d);
    }

    SubSolution(int i, int j, String s, String d)
    {
        super(i, j, s, d);
    }

    SubSolution(int i, int j, int k, String s, String d)
    {
        super(i, j, k, s, d);
    }

    private SubSolution(String s){

    }
    private SubSolution(String s, String d){

    }
    private SubSolution(String s, String d, String f){

    }

}
