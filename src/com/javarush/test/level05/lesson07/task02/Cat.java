package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен,
то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста.
А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String name = null;
    private int weight = 5;
    private int age = 5;
    private String address = null;
    private String color = "black";

    public void initialiaze(String name)
    {
        this.name = name;
    }
    public void initialiaze(String name, int weight, int age)
    {
        this.name = name + weight + age;
    }
    public void initialiaze(String name, int age){
        int weight = this.weight;
    }

    public void initialiaze(int weight, String color){
        String name = this.name;
        String address = this.address;
        int age = this.age;

    }
    //Напишите тут ваш код

}
