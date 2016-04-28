package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Администратор on 29.07.2015.
 */
public class RussianHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return 3000;
    }
    public String getDescription()
    {

        return (super.getDescription()+ " Моя страна - "+ Country.RUSSIA + ". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.");
    }
}
