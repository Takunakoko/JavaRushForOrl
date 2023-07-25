package com.javarush.test.level05.lesson05.task05;

/* Провести три боя  попарно между котами
Создать три кота используя класс Cat.
Провести три боя попарно между котами.
Класс Cat создавать не надо. Для боя использовать метод boolean fight(Cat anotherCat).
Результат каждого боя вывести на экран.
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

        boolean result = cat1.fight(cat2);
        System.out.println(result);

        result = cat2.fight(cat3);
        System.out.println(result);

        result = cat1.fight(cat3);
        System.out.println(result);

        result = cat3.fight(cat2);
        System.out.println(result);
    }









//    public static class Cat {
//
//        public static int count = 0;
//        public static int fightCount = 0;
//
//        protected String name;
//        protected int age;
//        protected int weight;
//        protected int strength;
//
//        public Cat(String name, int age, int weight, int strength) {
//            count++;
//
//            this.name = name;
//            this.age = age;
//            this.weight = weight;
//            this.strength = strength;
//        }
//
//        public boolean fight(Cat anotherCat) {
//            fightCount++;
//
//            int agePlus = this.age > anotherCat.age ? 1 : 0;
//            int weightPlus = this.weight > anotherCat.weight ? 1 : 0;
//            int strengthPlus = this.strength > anotherCat.strength ? 1 : 0;
//
//            int score = agePlus + weightPlus + strengthPlus;
//            return score > 2; //эквивалентно return score > 2 ? true : false;
//        }
//    }
}
