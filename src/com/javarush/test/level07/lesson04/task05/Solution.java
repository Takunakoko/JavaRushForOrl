package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int[] mass = new int[20];
        int[] mass1 = new int[10];
        int[] mass2 = new int[10];
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < mass.length; i++)
        {
            mass[i] = Integer.parseInt(r.readLine());
            if (i < (mass.length / 2)) { mass1[i] = mass[i]; }
            else { mass2[i-mass.length/2] = mass[i]; }
        }
        for (int i = 0; i < mass2.length; i++)
        {
            System.out.println(mass2[i]);
        }
    }
}
