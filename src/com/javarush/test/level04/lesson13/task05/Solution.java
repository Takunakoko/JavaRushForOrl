package com.javarush.test.level04.lesson13.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* Все любят Мамбу
Ввести с клавиатуры имя и используя цикл for 10 раз вывести: [*имя* любит меня.]
Пример текста:
Света любит меня.
Света любит меня.
…
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите имя");
        String name = console.next();

        for (int i = 0; i <= 10; i++) {
            System.out.println(name + " любит меня");
        }
    }
}
