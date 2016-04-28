package com.javarush.test.level18.lesson03.task01;

import java.io.*;
import java.util.ArrayList;
/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName);

        while (inputStream.available() > 0)
        {
            list.add(inputStream.read());
        }
        System.out.println(maxOfList(list));
        reader.close();
    }

    public static int maxOfList(ArrayList<Integer> list){
        int max = list.get(0);
        for (int x : list){
            max = (max < x) ? x: max;
        }
        return max;
    }
}
