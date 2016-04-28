package com.javarush.test.level08.lesson08.task04;

import java.util.*;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Иванов", new Date("JULY 1 1980"));
        map.put("Гена", new Date("APRIL 2 1945"));
        map.put("Васин", new Date("JANUARY 3 1965"));
        map.put("Семенов", new Date("FEBRUARY 4 1990"));
        map.put("Олегрович", new Date("SEPTEMBER 5 1985"));
        map.put("Ашотов", new Date("NOVEMBER 6 1982"));
        map.put("Агенысян", new Date("MARCH 7 1981"));
        map.put("Вальков", new Date("MAY 8 1979"));
        map.put("Якунин", new Date("DECEMBER 9 1970"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while(iterator.hasNext())
        {
            Map.Entry<String, Date> pair = iterator.next();

            if (pair.getValue().getMonth() > 4 && pair.getValue().getMonth() < 8)
            {
                iterator.remove();
            }
        }

    }
    public static void main(String[] args) {
        for (Map.Entry<String, Date> pair: createMap().entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue().getMonth() + "\t");
        }
        System.out.println();
        removeAllSummerPeople(createMap());
    }
}
