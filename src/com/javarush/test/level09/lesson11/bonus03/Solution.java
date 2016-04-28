package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        //напишите тут ваш код
        ArrayList<Integer> IndexNumb = new ArrayList<Integer>();
        ArrayList<Integer> Number = new ArrayList<Integer>();
        ArrayList<Integer> Indstring = new ArrayList<Integer>();
        ArrayList<String> string = new ArrayList<String>();

        //Делим массив на два массива по признаку "НеЦифра"
        for (int x = 0; x < array.length; x++)
        {
            if (isNumber(array[x]))
            {
                IndexNumb.add(x);
                Number.add(Integer.parseInt(array[x]));
            }
            else
            {
                Indstring.add(x);
                string.add(array[x]);
            }

        }

        //Сортируем массив из чисел на убывание
        for (int j = 0; j < Number.size() - 1; j++)
        {
            for (int i = 0; i < Number.size() - 1 - j; i++)
            {
                if (Number.get(i) < Number.get(i+1))
                {
                    int tempNum = Number.get(i);
                    Number.set(i, Number.get(i+1));
                    Number.set(i+1, tempNum);
                }

            }
        }

        //Сортируем массив строк на возрастание
        for (int j = 0; j < string.size() - 1; j++)
        {
            for (int i = 0; i < string.size() - 1 - j; i++)
            {
                if (isGreaterThen(string.get(i), string.get(i+1)))
                {
                    String tempString = string.get(i);
                    string.set(i, string.get(i+1));
                    string.set(i+1, tempString);
                }
            }
        }

        //Собираем в первоначальный массив
        int i = 0;
        int j = 0;
        for (int x = 0; x < array.length; x++)
        {

            if (i < IndexNumb.size() && IndexNumb.get(i) == x)
                {
                    array[x] = Number.get(i).toString();
                    i++;
                }
            if (j < Indstring.size() && Indstring.get(j) == x)
                {
                    array[x] = string.get(j);
                    j++;
                }

        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
