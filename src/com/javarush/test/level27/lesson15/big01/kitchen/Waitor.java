package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by admin on 29.01.2016.
 */
public class Waitor implements Observer
{

    @Override
    public void update(Observable o, Object arg)
    {
        Cook cook = (Cook) o;
        Order order = (Order) arg;
        ConsoleHelper.writeMessage(String.format("%s was cooked by %s", order, cook));
    }
}
