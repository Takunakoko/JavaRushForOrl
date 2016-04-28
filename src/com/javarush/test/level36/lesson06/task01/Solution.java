package com.javarush.test.level36.lesson06.task01;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/* Найти класс по описанию
1. Реализует интерфейс List
2. Является приватным статическим классом внутри популярного утилитного класса
3. Доступ по индексу запрещен - кидается исключение IndexOutOfBoundsException
4. Используйте рефлекшн, чтобы добраться до искомого класса
*/
public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass()
    {
        Class listClass = List.class;
        Class[] classes = Collections.class.getDeclaredClasses();
        for (Class c : classes)
        {
            int mod = c.getModifiers();
            if (Modifier.isPrivate(mod) && Modifier.isStatic(mod) && listClass.isAssignableFrom(c))
            {
                try
                {
                    /*Class clazz = Class.forName("java.util.Collections$" + c.getSimpleName());
                    Object object = clazz.newInstance();*/
                    Object object = c.newInstance();
                    Method[] methods = c.getDeclaredMethods();
                    System.out.println(c.getSimpleName());
                    for (Method method : methods)
                        System.out.println(method);
                    System.out.println();
                }
                catch (InstantiationException e)
                {
                    System.out.println("Excep2 " + e.getMessage());
                }
                catch (IllegalAccessException e)
                {
                    System.out.println("Excep3 " + e.getMessage());
                }
            }
        }
        return null;
    }
}
