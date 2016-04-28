package com.javarush.test.level07.lesson06.task03;

/* 5 строчек в обратном порядке
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в него.
3. Расположи их в обратном порядке.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> string = new ArrayList<String>();
        ArrayList<String> strings = new ArrayList<String>();
        for (int i = 0; i < 5; i++)
        {
            string.add(r.readLine());
            strings.add(0, string.get(i));
        }
        for (int i = 0; i < strings.size(); i++)
        {
            System.out.println(strings.get(i));
        }
    }
}
