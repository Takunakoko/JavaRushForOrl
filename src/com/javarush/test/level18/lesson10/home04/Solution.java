package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        ArrayList<Integer> temp = new ArrayList<Integer>();

        readFile(fileName1, temp);
        copyFile(fileName2, fileName1);
        writeFile(temp, fileName1);
        temp.clear();

        reader.close();
    }
    public static void readFile(String path, ArrayList<Integer> temp) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(path);
        while (inputStream.available() > 0){
            temp.add(inputStream.read());
        }
        inputStream.close();
    }

    public static void writeFile(ArrayList<Integer> temp, String path) throws IOException
    {
        FileOutputStream outputStream = new FileOutputStream(path, true);
        for(int x : temp){
            outputStream.write(x);
        }
        outputStream.close();
    }

    public static void copyFile(String pathRead, String pathWrite) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(pathRead);
        FileOutputStream outputStream = new FileOutputStream(pathWrite);
        while (inputStream.available() > 0){
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            outputStream.write(buffer, 0, count);
        }
        inputStream.close();
        outputStream.close();
    }
}
