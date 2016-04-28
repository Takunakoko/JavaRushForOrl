package com.javarush.test.level18.lesson03.task03;

import java.io.*;
import java.util.*;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        CountListByte(fileName);
    }

    public static Map<Integer, Integer> CountListByte(String path) throws IOException
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        FileInputStream inputStream = new FileInputStream(path);
        int count = 0;

        while (inputStream.available() > 0){
            list.add(inputStream.read());
        }
        Map<Integer, Integer> freqCount = new HashMap<Integer, Integer>();
        for (int x : list)
        {
            freqCount.put(x, Collections.frequency(list, x));
        }

        for (Map.Entry<Integer, Integer> e : freqCount.entrySet()){

            count = (count > e.getValue()) ? count : e.getValue();
        }
        for (Map.Entry<Integer, Integer> e : freqCount.entrySet()){
            if (e.getValue() == count){
                System.out.print(e.getKey() + " ");
            }
        }
        return freqCount;
    }

}
