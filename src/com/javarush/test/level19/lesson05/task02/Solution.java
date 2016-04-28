package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        Scanner scanner = new Scanner(new FileReader(fileName));
        String input;
        String word = "world";
        int count = 0;
        while (scanner.hasNext()){
            input = scanner.nextLine();
            input = input.replaceAll("\\p{P}", " "); //заменяет все знаки припенания на пробелы

            input = input.toLowerCase();
            word = word.toLowerCase();

            String[] list = input.split(" ");
            for (String x : list){
                if (word.equals(x) )
                    count++;

            }
        }
        System.out.println(count);
        scanner.close();
        reader.close();
    }
}
