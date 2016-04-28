package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception{
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String value = reader.readLine();
        char[] valueCh = value.toCharArray();
        ArrayList<String> list = new ArrayList<String>();

        String valueFinish = "";


        for (int i = 0; i < valueCh.length; i++)
        {
            String param = "";
            if (valueCh[i] == '&' || valueCh[i] == '?')
            {
                while ((i+1 < valueCh.length) && (valueCh[i+1] != '=') && (valueCh[i+1] != '&'))
                {
                    param = param + valueCh[i + 1];
                    i++;
                }

                valueFinish = valueFinish + param + " ";

                if ((i+1 < valueCh.length) && (param + valueCh[i+1]).equals("obj="))
                {

                    i++;
                    String paramDbl = "";
                    while ((i+1 < valueCh.length) && (valueCh[i+1] != '&'))
                    {
                        paramDbl = paramDbl + valueCh[i+1];
                        
                        i++;
                    }
                    list.add(paramDbl);
                }
            }
        }
        System.out.println(valueFinish);
        for (String x : list)
        {
            try
            {
                alert(Double.parseDouble(x));
            }
            catch (Exception e)
            {
                alert(x);
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
