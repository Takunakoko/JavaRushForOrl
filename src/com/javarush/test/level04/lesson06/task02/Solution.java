package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static int max(int a1, int b1){
        int m;
        if (a1 < b1)
            m = b1;
        else
            m = a1;
        return m;
    }
    public static void main(String[] args) throws Exception
    {
        String sA, sB, sC, sD;
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        sA = r.readLine();
        sB = r.readLine();
        sC = r.readLine();
        sD = r.readLine();

        int a = Integer.parseInt(sA);//Напишите тут ваш код
        int b = Integer.parseInt(sB);
        int c = Integer.parseInt(sC);
        int d = Integer.parseInt(sD);

        int max1 = max(a,b);
        int max2 = max(c,d);
        int maximum = max(max1,max2);
            System.out.print(maximum);

    }
}
