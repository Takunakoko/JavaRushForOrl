package com.javarush.test.level04.lesson06.task05;

/* 18+
Ввести с клавиатуры имя и возраст. Если возраст меньше 18 вывести надпись «Подрасти еще».
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
       BufferedReader r = new BufferedReader(new InputStreamReader(System.in));//Напишите тут ваш код
        String name = r.readLine();
        int age = Integer.parseInt(r.readLine());
        if (age<18) System.out.println("Подрасти еще");


    }
}
