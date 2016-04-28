package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by admin on 26.01.2016.
 */
public enum Dish
{
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private int duration;

    Dish(int duration)
    {
        this.duration = duration;
    }

    public int getDuration()
    {
        return duration;
    }


    public static String allDishesToString()
    {
        Dish[] arrayDish = Dish.values();
        StringBuilder sb = new StringBuilder();

        if (arrayDish.length == 0)
            return "";
        else
        {
            sb.append(arrayDish[0]);
            for (int i = 1; i < arrayDish.length; i++)
                sb.append(", ").append(arrayDish[i]);
            return sb.toString();
        }
    }
}
