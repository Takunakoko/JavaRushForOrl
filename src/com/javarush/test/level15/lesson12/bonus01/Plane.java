package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by Администратор on 17.08.2015.
 */
public class Plane implements Flyable
{
    int passenger = 0;
    public Plane (int passenger)
    {
        this.passenger = passenger;
    }
    @Override
    public void fly()
    {

    }
}
