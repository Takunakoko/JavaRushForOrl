package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        ArrayList<Human> child = new ArrayList<Human>();
        Human child1 = new Human ("Андрей", true, 25, new ArrayList<Human>());
        Human child2 = new Human ("Катя", false, 16, new ArrayList<Human>());
        Human child3 = new Human ("Вера", false, 13, new ArrayList<Human>());
        child.add(child1);
        child.add(child2);
        child.add(child3);
        ArrayList<Human> parent1 = new ArrayList<Human>();
        Human father = new Human ("Макс", true, 40, child);
        parent1.add(father);
        ArrayList<Human> parent2 = new ArrayList<Human>();
        Human mother = new Human ("Лена", false, 39, child);
        parent2.add(mother);


        Human GrandPa1 = new Human ("Коля", true, 90, parent1);
        Human GrandPa2 = new Human ("Вася", true, 91, parent2);
        Human GrandMa1 = new Human ("Рита", false, 89, parent1);
        Human GrandMa2 = new Human ("Валя", false, 89, parent2);


        System.out.println(GrandPa1);
        System.out.println(GrandPa2);
        System.out.println(GrandMa1);
        System.out.println(GrandMa2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);

    }

    public static class Human
    {
        //напишите тут ваш код
        private String name;
        private Boolean sex;
        private int age;
        private ArrayList<Human> children;

        public Human(String name, Boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
