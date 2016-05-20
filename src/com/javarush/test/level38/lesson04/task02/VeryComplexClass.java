package com.javarush.test.level38.lesson04.task02;

/* Непроверяемые исключения (unchecked exception)
Напиши реализацию метода methodThrowsClassCastException(). Он должен
всегда кидать непроверяемое исключение ClassCastException.

Напиши реализацию метода methodThrowsNullPointerException(). Он должен
всегда кидать непроверяемое исключение NullPointerException.

Кинуть исключение (throw) явно нельзя.
*/


public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        //напишите тут ваш код
        Object ch = new Character('*');
        System.out.println((Byte) ch);
    }

    public void methodThrowsNullPointerException() {
        //напишите тут ваш код
        int[] list = new int[4];
        list = null;
        int size = list.length;
    }
}
