package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
1 - Имя
2 - Имя, рост
3 - Имя, рост, цвет
*/

public class Dog
{
   private String name;
   private int height;
   private String color;

   public Dog(String name)                              //1
   {
       this.name = name;
   }
    public Dog(String name, int height)                 //2
    {
        this.name = name;
        this.height = height;
    }
    public Dog(String name, int height, String color)   //3
    {
        this.name = name;
        this.height = height;
        this.color = color;
    }
   //Напишите тут ваш код

}
