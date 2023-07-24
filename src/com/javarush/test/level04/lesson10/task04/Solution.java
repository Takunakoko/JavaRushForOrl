package com.javarush.test.level04.lesson10.task04;

/* S-квадрат
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в одной строке не разделять.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String symbol = "S";
        int weight = 10;
        int height = 10;
        while (height>0){
            while (weight>0){
                System.out.printf(symbol);
                weight--;
            }
            height--;
            weight = 10;
            System.out.println();
        }
    }
}