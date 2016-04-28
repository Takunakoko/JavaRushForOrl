package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал
true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        String date = "JANUARY 1 2000";
        System.out.println(date + " = " + isDateOdd(date));
    }

    public static boolean isDateOdd(String date)

    {
        Date Current = new Date(date);
        Date StartDate = new Date();
        StartDate.setDate(1);
        StartDate.setMonth(0);
        int year = Current.getYear();
        StartDate.setYear(year);

        long msDist = Current.getTime() - StartDate.getTime();
        long msDay = 1000*60*60*24;
        int Days = (int) (msDist / msDay);
        System.out.println(Days);
        return (Days % 2 != 0);
    }
}
