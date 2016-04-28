package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя,
ширина и высота). Создать для него как можно больше методов initialize(…)
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

    public void initialize(int left, int top, int width, int height){       //1
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    public void initialize(int left, int top){                              //2
        this.left = left;
        this.top = top;
        this.width = 0;
        this.height = 0;
    }

    public void initialize(int left, int top, int width){                   //3
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = width;
    }


    public void initialize(Rectangle copy){                                 //4
        this.left = copy.left;
        this.top  = copy.top;
        this.width = copy.width;
        this.height = copy.height;
    }

    //Напишите тут ваш код

}
