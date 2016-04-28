package com.javarush.test.level08.lesson11.home02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* Множество всех животных
1. Внутри класса Solution создать public static классы Cat, Dog.
2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.
4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов, которые есть в множестве cats.
6. Реализовать метод printPets, котороый должен выводить на экран всех животных, которые в нем есть. Каждое животное с новой строки
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);
        System.out.println("*************");
        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats()
    {
        HashSet<Cat> result = new HashSet<Cat>();

        //напишите тут ваш код
        for (int i = 0; i < 4; i++)
        {
            result.add(new Cat());
        }
        return result;
    }

    public static Set<Dog> createDogs()
    {
        //напишите тут ваш код
        HashSet<Dog> result = new HashSet<Dog>();
        for (int i = 0; i < 3; i++)
        {
            result.add(new Dog());
        }
        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs)
    {
        //напишите тут ваш код
        HashSet<Object> pets = new HashSet<Object>();
        Iterator<Cat> itCat = cats.iterator();
        while (itCat.hasNext())
        {
            pets.add(itCat.next());
        }
        Iterator<Dog> itDog = dogs.iterator();
        while (itDog.hasNext())
        {
            pets.add(itDog.next());
        }
        return pets;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats)
    {
        //напишите тут ваш код
/*       Iterator itCat = cats.iterator();
       while (itCat.hasNext())
        {
            Iterator itPet = pets.iterator();

            while (itPet.hasNext())
            {
                if (itPet.next().equals(itCat));
                {
                    itPet.remove();
                    break;
                }
            }
            itCat.next();
        }*/
        pets.removeAll(cats);
    }

    public static void printPets(Set<Object> pets)
    {
        //напишите тут ваш код
        for (Object text : pets)
        {
            System.out.println(text);
        }
    }

    //напишите тут ваш код
    public static class Cat {/*Типа кот*/}
    public static class Dog {/*Типа дог*/}
}
