package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        String fileName = args[0];
        FileInputStream fileInputStream = new FileInputStream(fileName);
        int count = 0;
        while(fileInputStream.available() > 0){
            int symbol = fileInputStream.read();
            if (symbol >= 65 && symbol <= 90 || symbol >= 97 && symbol <= 122)
            {
                count++;
            }
        }
        System.out.println(count);
        fileInputStream.close();
    }
}
