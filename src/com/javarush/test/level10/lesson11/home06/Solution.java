package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        String name = null;
        String surname = null;
        int age = 0;
        Boolean sex = false;
        int weight = 0;
        int height = 0;
        public Human (String name)                                      //1
        {
            this.name = name;
        }
        public Human (String name, int age)                             //2
        {
            this.name = name;
            this.age = age;
        }
        public Human (String name, int age, boolean sex)                //3
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        public Human (String name, String surname, int age, boolean sex)//4
        {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.sex = sex;
        }
        public Human (String name, String surname)                      //5
        {
            this.name = name;
            this.surname = surname;
        }
        public Human (String name, String surname, int weight)          //6
        {
            this.name = name;
            this.surname = surname;
            this.weight = weight;
        }
        public Human (String name, boolean sex, int height)             //7
        {
            this.name = name;
            this.sex = sex;
            this.height = height;
        }
        public Human (String name, String surname, boolean sex)         //8
        {
            this.name = name;
            this.surname = surname;
            this.sex = sex;
        }
        public Human (String name, boolean sex)                         //9
        {
            this.name = name;
            this.sex = sex;
        }
        public Human (String name, int age, boolean sex, int weight)    //10
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.weight = weight;
        }
    }
}
