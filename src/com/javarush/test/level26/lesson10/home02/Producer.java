package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Администратор on 18.12.2015.
 */
public class Producer implements Runnable
{
    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map)
    {
        this.map = map;
    }

    public void run()
    {
        try
        {
            int i = 0;
            while (true)
            {
                map.put(String.valueOf(i++),"Some text for "+i); //Producer только кладет в очередь элементы карты
                Thread.sleep(500);                               //Consumer перебирает, печатает и удаляет элементы
            }
        }
        catch (InterruptedException e)
        {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
