package com.javarush.test.level08.lesson08.task03;

import java.util.Iterator;
import java.util.Map;

import java.util.HashMap;



/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Иванов", "Иван");
        map.put("Гришев", "Владимир");
        map.put("Петров", "Гена");
        map.put("Сидоров", "Иван");
        map.put("Рваный", "Гоша");
        map.put("Разный", "Иван");
        map.put("Дмитров", "Иван");
        map.put("Генов", "Иван");
        map.put("Сашквли", "Иван");
        map.put("Гмань", "Иван");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        int Count = 0;
        while (iterator.hasNext())
        {
            Map.Entry<String, String> pair = iterator.next();
            if (pair.getValue().equals(name)) { Count++; }
        }
        return Count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        //напишите тут ваш код
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        int Count = 0;
        while (iterator.hasNext())
        {
            Map.Entry<String, String> pair = iterator.next();
            if (pair.getKey().equals(familiya)) { Count++; }
        }
        return Count;
    }
}
