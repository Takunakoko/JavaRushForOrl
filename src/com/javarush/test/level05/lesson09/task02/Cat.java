package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
1 - Имя,
2 - Имя, вес, возраст
3 - Имя, возраст (вес стандартный)
4- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
5 - вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес не известен,
то нужно указать какой-нибудь средний вес. Кот не может ничего не весить.
То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String name = null;
    private int weight;
    private int age;
    private String color = "black";
    private String address = null;

    public Cat(String name)                                     //1
    {
        this.name = name;
    }
    public Cat(String name, int weight, int age)                //2
    {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }
    public Cat(String name, int age)                             //3
    {
        this.name = name;
        this.age = age;
        this.weight = 5;
    }
    public Cat(int weight, String color)                         //4
    {
        this.weight = weight;
        this.color = color;
        this.age = 5;
    }
    public Cat(int weight, String color, String address)        //5
    {
        this.weight = weight;
        this.color = color;
        this.address = address;
        this.age = 5;
    }
    //Напишите тут ваш код

}
