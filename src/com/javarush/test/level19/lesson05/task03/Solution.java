package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
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
        FileWriter writer = new FileWriter(file2);

        String string = "";
        while (scanner.hasNext()){

            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                string += (input + " ");
            }else
                scanner.next();
        }
        writer.write(string);
        scanner.close();
        writer.close();
        reader.close();
    }
}
