package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileReader fileReader = new FileReader(file1);
        FileWriter writer = new FileWriter(file2);
        int c;
        while ((c=fileReader.read())!=-1){

            if (c == 46){                       //если встречаем симмвол .
                c = 33;                         //меняем его на !
                writer.write((char)c);
            }else
                writer.write((char)c);
        }


        fileReader.close();
        writer.close();
        reader.close();
    }
}
