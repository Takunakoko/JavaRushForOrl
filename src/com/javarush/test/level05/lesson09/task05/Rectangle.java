package com.javarush.test.level05.lesson09.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height
(левая координата, верхняя, ширина и высота). Создать для него как можно больше конструкторов:
Примеры:
1 -	заданы 4 параметра: left, top, width, height
2 -	ширина/высота не задана (оба равны 0)
3 -	высота не задана (равно ширине) создаём квадрат
4 -	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    private int top;
    private int left;
    private int width;
    private int height;

    public Rectangle(int top, int left, int width, int height)                  //1
    {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }
    public Rectangle(int top, int left)                                         //2
    {
        this.top = top;
        this.left = left;
        this.width = this.height = 0;
    }
    public Rectangle(int top, int left, int width)                              //3
    {
        this.top = top;
        this.left = left;
        this.width = this.height = width;
    }
    public Rectangle(Rectangle copy)                                            //4
    {
        this.top = copy.top;
        this.left = copy.left;
        this.width = copy.width;
        this.height = copy.height;
    }
    //Напишите тут ваш код

}
