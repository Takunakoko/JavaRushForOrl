package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String string = r.readLine();
        ArrayList listOfVowel = new ArrayList<String>();
        ArrayList listOfCons = new ArrayList<String>();

        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            if (isVowel(chars[i]))
            {
                listOfVowel.add(chars[i]);
            }

            else
            {
                if (chars[i] != ' ')
                listOfCons.add(chars[i]);
            }
        }
        for (int i = 0; i < listOfVowel.size(); i++)
        {
            System.out.print(listOfVowel.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < listOfCons.size(); i++)
        {
            System.out.print(listOfCons.get(i) + " ");
        }
    }


    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
