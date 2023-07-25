package com.javarush.test.level04.lesson16.home04;

/* Меня зовут 'Вася'...
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.
Вывести на экран текст:
«Меня зовут name
Я родился d.m.y»
Пример:
Меня зовут Вася
Я родился 15.2.1988
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите имя");
        String name = console.next();
        System.out.println("Введите день своего рождения");
        String y = console.next();
        System.out.println("Введите месяц своего рождения");
        String m = console.next();
        System.out.println("Введите год своего рождения");
        String d = console.next();

        System.out.println("Меня зовут " + name + ". Я родился " + y + "." + m + "." + d);

    }
}
