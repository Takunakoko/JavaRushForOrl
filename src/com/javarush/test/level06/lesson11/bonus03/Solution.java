package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class    Solution
{
    /*public static int min(int a, int b)
    {
        if (a < b) { return a; }
        else { return b; }
    }
    public static int max(int c, int d)
    {
        if (c > d) { return c; }
        else {return d;}
    }*/
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код

        int n1 = Integer.parseInt(reader.readLine());
        int n2 = Integer.parseInt(reader.readLine());
        int n3 = Integer.parseInt(reader.readLine());
        int n4 = Integer.parseInt(reader.readLine());
        int n5 = Integer.parseInt(reader.readLine());

        for (int i = 0; i < 4; i++)
        {
            if (n1 > n2)
            {
                int temp = n1;
                n1 = n2;
                n2 = temp;
            }
            if (n2 > n3)
            {
                int temp = n2;
                n2 = n3;
                n3 = temp;
            }
            if (n3 > n4)
            {
                int temp = n3;
                n3 = n4;
                n4 = temp;
            }
            if (n4 > n5)
            {
                int temp = n4;
                n4 = n5;
                n5 = temp;
            }
        }
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n4);
        System.out.println(n5);
        /*int mas[] = new int [5];
        for (int i = 0; i < 5; i++)
        {
           mas[i] = Integer.parseInt(reader.readLine());
        }
        for (int j = 1; j < mas.length - 1; j++)
        {
            for (int i = 0; i < mas.length - j; i++)
            {
                if (mas[i] > mas[i + 1])
                {
                    int a = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = a;
                }
                else
                    return;

            }
        }
        for (int i = 0; i < 5; i++)
        {
            System.out.println(mas[i]);
        }
        System.out.println(mas[1]);
        System.out.println(mas[2]);*/
    }
}
