package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        //напишите тут ваш код
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < 20; i++)
        {
         set.add("Л"+"-слово номер " + i);
        }
       /*set.add("лена");
        set.add("леша");
        set.add("лагерь");
        set.add("лес");
        set.add("лед");
        set.add("лось");
        set.add("лысина");
        set.add("ледник");
        set.add("лера");
        set.add("лодка");
        set.add("лето");
        set.add("лазер");
        set.add("ладан");
        set.add("лада");
        set.add("ларец");
        set.add("леший");
        set.add("лощадь");
        set.add("лак");
        set.add("лань");
        set.add("лама");*/
        return set;
    }
}
