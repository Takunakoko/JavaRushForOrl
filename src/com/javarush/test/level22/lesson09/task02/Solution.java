package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();

        if (params == null || params.size() == 0)                //Обязательно надо было проверить количество элементов.
        {
            return stringBuilder;
        }else {
            for (Map.Entry<String, String> param : params.entrySet())
            {
                String key = param.getKey();
                String value = param.getValue();

                if (key != null && value != null)
                {
                    stringBuilder.append(key + " = '" + value + "' and ");
                }
            }
            stringBuilder = stringBuilder.delete(stringBuilder.lastIndexOf(" and"), stringBuilder.length());
            return stringBuilder;
        }
    }
    public static void main (String[] args) throws Exception{
        Map<String, String> map = new HashMap<>();
        map.put("country", "Россия");
        map.put("height", "185");
        map.put("Name", "Аркадий");
        map.put(null, null);
        map.put("Город", null);
        System.out.println(getCondition(map).toString());
    }
}

