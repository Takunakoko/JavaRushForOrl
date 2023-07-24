package com.javarush.test.level04.lesson06.task04;

/* Сравнить имена
Ввести с клавиатуры два имени, и если имена одинаковые вывести сообщение «Имена идентичны».
Если имена разные, но их длины равны – вывести сообщение – «Длины имен равны».
*/


import java.util.Objects;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите первое имя");
        String name1 = console.next();
        System.out.println("Введите второе имя");
        String name2 = console.next();


        if (Objects.equals(name1, name2)) {
            System.out.println("Имена идентичны");
        } else if (name1.length() == name2.length()){
            System.out.println("Длины имен равны");
        }

    }
}