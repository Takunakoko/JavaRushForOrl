package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        int a = console.nextInt();
        int b = console.nextInt();
        int c = console.nextInt();

        if (a<=b && b<=c) {
            System.out.println(b);
        }
       else  if (c<=b && b<=a) {
            System.out.println(b);
        }
        else if (b<=a && a<=c) {
            System.out.println(a);
        }
        else if (c<=a && a<=b) {
            System.out.println(a);
        }
        else if (a<=c && c<=b){
        System.out.println(c);
        }
        else if (b<=c && c<=a) {
            System.out.println(c);
        }

    }
}
