package com.javarush.test.level05.lesson05.task01;

/* Создать класс Cat
Создать класс Cat. У кота должно быть имя (name, String),
возраст (age, int), вес (weight, int), сила (strength, int).
*/

public class Cat
{
    public String name;
    public int age;
    public int weight;
    public int strength;
    //Напишите тут ваш код
    public void main (String[] args)
    {
        Cat cat = new Cat();
        cat.name = "Кот";
        cat.age = 34;
        cat.weight = 75;
        cat.strength = 90;
    }

}
