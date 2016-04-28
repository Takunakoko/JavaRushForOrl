package com.javarush.test.level18.lesson03.task05;

import java.io.*;
import java.util.*;






/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        ArrayList<Integer> list = readFile(fileName);
        sortList(list);
        print(list);
        reader.close();
    }
    public static ArrayList<Integer> readFile(String path) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(path);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(inputStream.available() > 0){
            int temp = inputStream.read();
            if (!list.contains(temp)) {
                list.add(temp);
            }
        }
        return list;
    }

    public static void sortList(ArrayList<Integer> list){
        Collections.sort(list);
    }

    public static void print(ArrayList<Integer> list){
        for (int x : list){
            System.out.print(x + " ");
        }
    }
}
