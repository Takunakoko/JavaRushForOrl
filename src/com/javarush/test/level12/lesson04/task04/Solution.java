package com.javarush.test.level12.lesson04.task04;

/* Три метода возвращают минимальное из двух переданных в него чисел
Написать public static методы: int min(int, int), long min(long, long), double min(double, double).
Каждый метод должен возвращать минимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {
        double A = 1;
        double B = 1;
        System.out.println(min((int)A, (int)B));
        System.out.println(min((long)A, (long)B));
        System.out.println(min(A, B));

    }

    //Напишите тут ваши методы
    public static int min(int a, int b)
    {
        int min = (a < b) ? a : b;
        return min;
    }
    public static long min(long a, long b)
    {
        long min = (a < b) ? a : b;
        return min;
    }
    public static  double min (double a, double b)
    {
        double min = (a < b) ? a : b;
        return min;
    }
}
