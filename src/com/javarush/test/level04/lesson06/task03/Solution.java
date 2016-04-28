package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in)); //Напишите тут ваш код
        int n1 = Integer.parseInt(r.readLine());
        int n2 = Integer.parseInt(r.readLine());
        int n3 = Integer.parseInt(r.readLine());

        if (n1 < n2 && n2 < n3)
        {
            System.out.println(n3);         //   1 2 3      1 3 2
            System.out.println(n2);         //   2 1 3      2 3 1
            System.out.println(n1);         //   3 1 2      3 2 1
        }
        if (n1 < n3 && n2 > n3)
        {
            System.out.println(n2);         //  5 5 7       5 5 3
            System.out.println(n3);         //  5 7 5       5 3 5
            System.out.println(n1);         //  7 5 5       3 5 5
        }
        if (n1 > n2 && n2 > n3)
        {
            System.out.println(n1);
            System.out.println(n2);
            System.out.println(n3);
        }
        if (n1 < n2 && n1 > n3){
            System.out.println(n2);
            System.out.println(n1);
            System.out.println(n3);
        }
        if (n1 > n3 && n2 < n3){
            System.out.println(n1);
            System.out.println(n3);
            System.out.println(n2);
        }
        if (n1 < n3 && n2 < n1){
            System.out.println(n3);
            System.out.println(n1);
            System.out.println(n2);
        }
    }

}

