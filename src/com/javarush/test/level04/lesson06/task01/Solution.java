package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String n, k;

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
         n = r.readLine();
         k = r.readLine();
         int n1 = Integer.parseInt(n);
         int k1 = Integer.parseInt(k);
         if (n1 < k1)
             System.out.println(n1);
         else
             System.out.println(k1);

        //Напишите тут ваш код

        /* данные для тестирования:
        введите 1 и 2, минимум =  1
        введите 2 и 1, минимум =  1
        введите 1 и 1, минимум =  1
        введите -1 и -2, минимум =  -2
         */
    }
}