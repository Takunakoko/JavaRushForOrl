package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.io.IOException;

/**
 * Created by admin on 26.01.2016.
 */
public class Restaurant
{
    public static void main(String[] args) throws IOException
    {
        Waitor waitor = new Waitor();
        Cook cookAmigo = new Cook("Amigo");
        Tablet tablet = new Tablet(5);
        cookAmigo.addObserver(waitor);

        tablet.addObserver(cookAmigo);
        tablet.createOrder();
    }
}
