package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileOutputStream fileOutputStream = new FileOutputStream(fileName1, true);
        FileInputStream fileInputStream2 = new FileInputStream(fileName2);
        FileInputStream fileInputStream3 = new FileInputStream(fileName3);

        while(fileInputStream2.available() > 0){
            byte[] buffer = new byte[fileInputStream2.available()];
            int count = fileInputStream2.read(buffer);
            fileOutputStream.write(buffer, 0, count);
        }

        while(fileInputStream3.available() > 0){
            byte[] buffer = new byte[fileInputStream3.available()];
            int count = fileInputStream3.read(buffer);
            fileOutputStream.write(buffer, 0, count);
        }
        fileOutputStream.close();
        fileInputStream2.close();
        fileInputStream3.close();
        reader.close();
    }

}
