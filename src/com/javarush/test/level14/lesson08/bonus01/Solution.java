package com.javarush.test.level14.lesson08.bonus01;


import java.io.*;
import java.util.*;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e) { exceptions.add(e); }
        //2
        try
        {
            String string = null;
            String string1 = string.toLowerCase();
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        //3
        try
        {
            String[] string = new String[0];
            string[1] = "except";
        }
        catch (Exception e) { exceptions.add(e); }
        //4
        try
        {
            ArrayList<String> arrayList = new ArrayList<String>();
            String s = arrayList.get(18);
        }
        catch (Exception e) { exceptions.add(e); }
        //5
        try
        {
            InputStream is = new FileInputStream("text.txt");
        }
        catch (Exception e) { exceptions.add(e); }
        //6
        try
        {
            Integer.parseInt("null");
        }
        catch (Exception e) { exceptions.add(e); }
        //7
        try
        {
            int[] list = new int[-1];
        }
        catch (Exception e) { exceptions.add(e); }
        //8
        try
        {
            Object object = new Character('o');
            System.out.println((Byte)object);

        }
        catch (Exception e) { exceptions.add(e); }
        //9
        try
        {
            String shortString = "123";
            char chr = shortString.charAt(4);
        }
        catch (Exception e) { exceptions.add(e); }
        //10
        try
        {
            int a = 0;
            int b = a / a;
        }
        catch (Exception e) { exceptions.add(e); }
    }
}
