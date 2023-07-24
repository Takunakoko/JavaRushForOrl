package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        Scanner console = new Scanner(System.in);
        Integer Number1 = null;
        Integer Number2 = null;
        Integer Number3 = null;
        Integer Number4 = null;

        Integer MaxNumber = 0;

        System.out.printf("Введите первое число: ");
        Number1 = console.nextInt();
        MaxNumber = Number1;

        System.out.printf("Введите второе число: ");
        Number2 = console.nextInt();
        if (Number2 >= MaxNumber) {
            MaxNumber = Number2;
        }

        System.out.printf("Введите третье число: ");
        Number3 = console.nextInt();
        if (Number3 >= MaxNumber) {
            MaxNumber = Number3;
        }

        System.out.printf("Введите четвертое число: ");
        Number4 = console.nextInt();
        if (Number4 >= MaxNumber) {
            MaxNumber = Number4;
        }

        System.out.println("Наибольшее введенное число: " + MaxNumber);
    }
}
