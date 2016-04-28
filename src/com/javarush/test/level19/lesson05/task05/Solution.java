package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        Scanner scanner = new Scanner(new File(file1));
        FileWriter fileWriter = new FileWriter(file2);

        boolean count = false;
        while (scanner.hasNext()){
            String string = scanner.nextLine();
            String[] input = string.split("\\p{Punct}");        //Вырезает всю пунктуацию (разбивает в массив)

            if (count)                                          //проверка первой строки
                fileWriter.write("\r");
            for (String x : input)
                fileWriter.write(x);
            count = true;
        }
        reader.close();
        scanner.close();
        fileWriter.close();
    }
}
