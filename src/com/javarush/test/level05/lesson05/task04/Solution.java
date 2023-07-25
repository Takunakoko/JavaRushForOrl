package com.javarush.test.level05.lesson05.task04;

/* Создать три объекта типа Cat
В методе main создать три объекта типа Cat и заполнить их данными.
Использовать класс Cat из первой задачи. Класс Cat создавать не надо.
*/


import com.javarush.test.level05.lesson05.task01.Cat;

public class Solution {
    public static void main(String[] args) {

        Cat cat1 = new Cat();
        cat1.name = "Kitty";
        cat1.age = 5;
        cat1.weight = 7;
        cat1.strength = 1;
        Cat cat2 = new Cat();
        cat2.name = "Kaka";
        cat2.age = 3;
        cat2.weight = 5;
        cat2.strength = 2;
        Cat cat3 = new Cat();
        cat3.name = "Gizmo";
        cat3.age = 7;
        cat3.weight = 2;
        cat3.strength = 3;



    }
}
