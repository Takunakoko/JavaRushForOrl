package com.javarush.test.level04.lesson13.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
Пример: m=2, n=4
8888
8888
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        String symbol = "8";
        int weight = console.nextInt();
        int height = console.nextInt();
        int weight_loc = weight;
        while (height>0){
            while (weight_loc>0){
                System.out.printf(symbol);
                weight_loc--;
            }
            height--;
            weight_loc = weight;
            System.out.println();
        }
    }
}
