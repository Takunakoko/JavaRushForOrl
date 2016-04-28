package com.javarush.test.level18.lesson03.task02;

import java.io.*;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        System.out.println(minOfByte(fileName));
        reader.close();
    }
    public static int minOfByte(String path) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(path);
        int min = fileInputStream.read();
        while(fileInputStream.available() > 0){
            int temp = fileInputStream.read();
            min = (min < temp) ? min : temp;
        }
        return min;
    }
}
