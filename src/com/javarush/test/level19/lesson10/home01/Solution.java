package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException
    {

        TreeMap<String, Double> treeMap = new TreeMap<String, Double>();

        String fileName = args[0];
        Scanner scanner = new Scanner(new File(fileName));

        while (scanner.hasNext()){
            String string = scanner.nextLine();
            String[] temp = string.split(" ");

            if(treeMap.get(temp[0]) == null)
                treeMap.put(temp[0], Double.parseDouble(temp[1]));
            else{
                double summ = treeMap.get(temp[0]) + Double.parseDouble(temp[1]);
                treeMap.put(temp[0], summ);
            }

        }
        for(Map.Entry<String, Double> pair : treeMap.entrySet())
        {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        scanner.close();
    }
}
