package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Администратор on 18.08.2015.
 */
public class Earth implements Planet
{
    private static Earth earth;

    private Earth() {}

    public static synchronized Earth getInstance()
    {
        if(earth == null)
        {
            earth = new Earth();
        }
        return earth;
    }
}
