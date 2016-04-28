package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException
    {
        String nameFile = args[0];
        Map<String, Double> map = new HashMap<>();

        Scanner scan = new Scanner(new File(nameFile));
        Double maxSolary = 0.0;

        while (scan.hasNext()){
            String string = scan.nextLine();
            String[] temp = string.split(" ");

            if (map.get(temp[0]) == null){
                map.put(temp[0], Double.parseDouble(temp[1]));
            }else{
                Double summ = map.get(temp[0]) + Double.parseDouble(temp[1]);
                map.put(temp[0], summ);
            }

            maxSolary = (map.get(temp[0]) > maxSolary) ? map.get(temp[0]) : maxSolary;
        }

        for(Map.Entry<String, Double> pair : map.entrySet()){
            if (maxSolary.equals(pair.getValue()))
            {
                System.out.println(pair.getKey());
            }else
                continue;
        }

        scan.close();
    }
}
