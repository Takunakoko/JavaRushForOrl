package com.javarush.test.level05.lesson09.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя конструкторами:
1 - centerX, centerY, radius
2 - centerX, centerY, radius, width
3 - centerX, centerY, radius, width, color
*/

public class Circle
{
    private int centerX;
    private int centerY;
    private int radius;
    private int width;
    private String color;

    public Circle(int centerX, int centerY, int radius)                             //1
    {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }
    public Circle(int centerX, int centerY, int radius, int width)                  //2
    {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = width;
    }
    public Circle(int centerX, int centerY, int radius, int width, String color)    //3
    {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = width;
        this.color = color;
    }
    //Напишите тут ваш код

}
