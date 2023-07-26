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

public class Cat {
    public String name;
    public int age;
    public int weight;
    public String color;
    public String address;

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = 5;
    }

    public Cat(int age, String color) {
        this.age = age;
        this.color = color;
        this.name = null;
        this.address = null;
        this.age =3;
    }

    public Cat(int age, String color, int weight) {
        this.age = age;
        this.color = color;
        this.weight = weight;

    }

}
