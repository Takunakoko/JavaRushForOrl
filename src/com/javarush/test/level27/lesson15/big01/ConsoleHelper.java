package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 26.01.2016.
 */
public class ConsoleHelper
{
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws IOException
    {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException
    {
        List<Dish> list = new ArrayList<>();
        String temp;

        writeMessage(Dish.allDishesToString());
        writeMessage("Выберите блюдо");

        while (true)
        {
            temp = readString();
            if ("exit".equalsIgnoreCase(temp))
                break;

            try
            {
                list.add(Dish.valueOf(temp));
            }
            catch (IllegalArgumentException e)
            {
                ConsoleHelper.writeMessage(String.format("%s is not detected", temp));
            }
        }
        return list;
    }
}
