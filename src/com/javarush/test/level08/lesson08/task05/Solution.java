package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Медведев", "Гена");
        map.put("Смирнов", "Паша");
        map.put("Васильев", "Лось");
        map.put("Македонский", "Гена");
        map.put("Валерьев", "Гена");
        map.put("Смальков", "Вера");
        map.put("Жвансикий", "Дыня");
        map.put("Петухов", "Гена");
        map.put("Коровин", "Гена");
        map.put("Дарвин", "Гена");

        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet())
        {
            for (Map.Entry<String, String> pair2 : map.entrySet())
            {
                if (pair.getValue().equals(pair2.getValue()) && !pair.getKey().equals(pair2.getKey()))
                {
                    removeItemFromMapByValue(map, pair2.getValue());
                    break;
                }
            }
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
     private static void toString(HashMap<String, String> map)
     {
          Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
          while(iterator.hasNext())
          {
              Map.Entry<String,String> pair = iterator.next();
              System.out.println(pair.getKey() + " " + pair.getValue());
          }
      }

      public static void main(String[] args)
      {
          HashMap<String,String> map = createMap();
          toString(map);
          System.out.println("/////////////////");
          removeTheFirstNameDuplicates(map);
          toString(map);

      }
}
