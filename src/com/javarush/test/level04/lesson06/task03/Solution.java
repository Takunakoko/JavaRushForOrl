package com.javarush.test.level04.lesson06.task03;
import java.util.Arrays;
/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        Integer var1 = null;
        Integer var2 = null;
        Integer var3 = null;

//        ЧЕРЕЗ МАССИВЫ
        System.out.println("Введите первое число");
        var1 = console.nextInt();
        System.out.println("Введите второе число");
        var2 = console.nextInt();
        System.out.println("Введите третье число");
        var3 = console.nextInt();

        Integer[] array = {var3, var1, var2};
        Arrays.sort(array, Collections.reverseOrder());
        System.out.printf(Arrays.toString(array));


//
//        БЕЗ Массивов
//        Integer max = null;
//        Integer min = null;
//        Integer avg = null;
//
//        System.out.println("ВВедите первое число");
//        var1 = console.nextInt();
//        System.out.println("ВВедите второе число");
//        var2 = console.nextInt();
//        max = Math.max(var1, var2);
//        min = Math.min(var1, var2);
//
//        System.out.println("ВВедите третье число");
//        var3 = console.nextInt();
//        if (var3 < min) {
//            avg = min;
//            min = var3;
//        }
//        if (var3 > max) {
//            avg = max;
//            max = var3;
//        }
//
//        System.out.printf(String.valueOf(max));
//        System.out.printf(String.valueOf(avg));
//        System.out.printf(String.valueOf(min));


    }

}

