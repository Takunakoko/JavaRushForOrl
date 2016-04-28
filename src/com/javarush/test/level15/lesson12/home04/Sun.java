package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Администратор on 18.08.2015.
 */
public class Sun implements Planet
{
    private static Sun sun;

    private Sun() {}

    public static synchronized Sun getInstance()
    {
        if (sun == null)
        {
            sun = new Sun();
        }
        return sun;
    }
}
