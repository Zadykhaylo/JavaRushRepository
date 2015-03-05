package com.javarush.test.level21.lesson16.big01;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 21.06.14
 * Time: 19:44
 * To change this template use File | Settings | File Templates.
 */
public class Horse
{
    String name;
    double speed, distance;

    public Horse (String name, double speed, double distance){
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public double getDistance()
    {
        return distance;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }

    public void move (){
        setSpeed(getSpeed()*Math.random());
        setDistance( getDistance() + getSpeed());
    }
    public void print (){
        int n = (int) getDistance();
        for (int i = 0; i < n; i++)
        {
            System.out.print(".");
        }
        System.out.print(getName());
        System.out.println();
    }



}
