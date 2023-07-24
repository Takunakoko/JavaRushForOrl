package com.javarush.test.level04.lesson06.task05;

/* 18+
Ввести с клавиатуры имя и возраст. Если возраст меньше 18 вывести надпись «Подрасти еще».
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите свое имя");
        String name = console.next();
        System.out.println("Введите свой возраст");
        int age = console.nextInt();

        if (age < 18){
            System.out.println("Подрасти еще");

        }

    }
}
