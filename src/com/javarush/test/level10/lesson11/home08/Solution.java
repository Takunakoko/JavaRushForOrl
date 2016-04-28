package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
        int NumberOfelements = (int) (Math.random()*5+1);
        ArrayList<String>[] list = new ArrayList[NumberOfelements];
        for (int i = 0; i < NumberOfelements; i++)
        {
            ArrayList<String> list1 = new ArrayList<String>();
            int m = (int) (Math.random()*10+1);
            for (int j = 0; j < m; j++)
            {
                list1.add("Строка номер №" + j + " Масива №" + (i + 1));
            }
            list[i] = list1;
        }
        return list;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}