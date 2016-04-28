package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Администратор on 18.08.2015.
 */
public class Moon implements Planet
{
    private static Moon moon;

    private Moon() {}

    public static synchronized Moon getInstance()
    {
        if (moon == null)
        {
            moon = new Moon();
        }
        return moon;
    }
}
