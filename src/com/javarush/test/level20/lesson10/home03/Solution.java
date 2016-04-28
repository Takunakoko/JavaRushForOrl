package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable{
    public static class A {
        protected String name = "A";
        public A(){}                                        //При десериализации вызывается конструктор
        public A(String name) {                             //без параметров родительского НЕсериализуемого класса
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B(String name)
        {
            super(name);
            this.name += name;
        }
        private void writeObject(ObjectOutputStream out) throws IOException {
            out.writeObject(name);
        }

        private void readObject(ObjectInputStream in) throws Exception, ClassNotFoundException{
            String n = (String) in.readObject();
            name = n;
        }

        //Порядок создания объекта B обычном режиме:
        //1. Вызывается базовый конструктор А с параметром «В». Сначала он инициализирует name значение «A»
        // потом добавляет к ней параметр. Получаем «AB»
        //2. Вызывается конструктор наследника, и добавляет к name значение параметра еще раз. Получаем «ABB»

        //Что происходить во время десериализации объекта B:
        //1. Десириализация сначала создает базовую часть объекта B, вызвая дефолтный конструктор A() котрый
        // инициализирует name значением «A»
        //2. Десириализация пытается создать все что связано непосредственно с наследником B,
        // но так как ни дефолный механизм ни какие либо другие механизмы не реализованы, этого не проиcходит.
        // И мы получаем десериализованый объект B с name = «A».

        //Чтобы это забороть, надо управлять сериализаций\десериализацией класса B (наследника).
        // То есть нужно руками сохранить все нужные данные, а потом руками-же их загрузить
        // и ициализировать класс B правильными данными. Как — было в лекциях.

        //Это лишь часть проблем с данной задачей. Хорошая задача. Кода минимум, а сколько тем затронули.
        // Заставила мозги пошевелиться.
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        String file = "C:\\1\\tt.txt";
        Solution solution = new Solution();
        Solution.B object = solution.new B("Б");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(object);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        B loadObject = (B) objectInputStream.readObject();
        System.out.println(loadObject.name);
    }
}
