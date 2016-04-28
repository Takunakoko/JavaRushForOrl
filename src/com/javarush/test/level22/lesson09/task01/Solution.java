package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        Scanner scanner = new Scanner(new FileInputStream(fileName));
        while(scanner.hasNext()){
            list.add(scanner.next());
        }
        scanner.close();
        reader.close();

        for (int i = 0; i < list.size(); i++){
            if (list.get(i) == null)                                //Проверяем удаленные элементы
                continue;
            String temp = list.get(i);
            String reversWord = (new StringBuilder(temp).reverse()).toString();
            for (int j = i + 1; j < list.size(); j++){
                if (list.get(j) == null)                            //Проверяем удаленные элементы
                    continue;
                if(reversWord.equals(list.get(j)))
                {
                    createPair(list.get(j), temp, result);
                    list.set(j, null);                          //Удаляем из массива, во избежание повторов
                    break;
                }
            }
        }
        print(result);
    }
    public static void createPair(String currentWord, String reversWord, List<Pair> result){
        {
            Pair pair = new Pair();
            pair.first = currentWord;
            pair.second = reversWord;
            result.add(pair);
        }
    }

    public static void print(List<Pair> result){
        for (Pair pair : result)
            System.out.println(pair);
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
