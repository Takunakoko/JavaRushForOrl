package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        ArrayList<Double> list = new ArrayList<Double>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        Scanner scanner = new Scanner(new FileReader(fileName1));
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName2));

        scanner.useDelimiter(" ");
        while (scanner.hasNext()){
            list.add(Double.parseDouble(scanner.next()));
        }

        for (Double x : list){
            long n = Math.round(x);
            out.write(n + " ");
            out.flush();
        }

        out.close();
        scanner.close();
        reader.close();
    }
}
