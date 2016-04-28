package com.javarush.test.level36.lesson08.task01;

import java.io.*;
import java.util.*;

/* Использование TreeSet
Первым параметром приходит имя файла: файл1.
файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
Отсортировать буквы по алфавиту и вывести на экран первые 5 различных букв в одну строку без разделителей.
Если файл1 содержит менее 5 различных букв, то вывести их все.
Буквы различного регистра считаются одинаковыми.
Регистр выводимых букв не влияет на результат.
Закрыть потоки.

Пример 1 данных входного файла:
zBk yaz b-kN
Пример 1 вывода:
abkny

Пример 2 данных входного файла:
caAC
A, aB? bB
Пример 2 вывода:
abc

Подсказка: использовать TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String filename = args[0];
        Set<String> set = new TreeSet<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            int symbol = reader.read();
            while (symbol != -1)
            {
                if (symbol > 64 && symbol < 91 || symbol > 96 && symbol < 123)
                {
                    String temp = new String(String.valueOf((char) symbol));
                    set.add(temp.toLowerCase());
                }
                    symbol = reader.read();
            }
        }
        List<String> result = new ArrayList<>(set);
        for (int i = 0; i < result.size(); i++)
        {
            if (i >= 5)
                break;
            System.out.print(result.get(i));
        }
    }
}
