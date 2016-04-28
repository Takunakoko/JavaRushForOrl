package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName = args[0];

        ArrayList<Integer> list = new ArrayList<Integer>();
        Map<Integer, Integer> symbol = new TreeMap<Integer, Integer>();

        FileInputStream inputStream = new FileInputStream(fileName);

        while(inputStream.available() > 0){
            int inputInt = inputStream.read();

            list.add(inputInt);
        }

        for (int x : list){
            int count = 0;
            for(int y : list){
                if (x == y){
                    count++;
                }
            }
            symbol.put(x, count);
        }
        for (Map.Entry<Integer, Integer> c : symbol.entrySet()){
            int i = c.getKey();
            System.out.println((char) i + " " + c.getValue());
        }

        inputStream.close();
    }
}
