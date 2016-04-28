package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOfFile = reader.readLine();


        Scanner scanner = new Scanner(new FileReader(nameOfFile));
        while(scanner.hasNext()){
            String input = scanner.nextLine();
            try
            {
                int inputNum = Integer.parseInt(input);
                if (inputNum % 2 == 0)
                {
                    list.add(inputNum);
                }
            }
            catch (Exception e){
                System.out.println(input);
            }
        }
        scanner.close();
        Collections.sort(list);
        for (Integer x : list){
            System.out.println(x);
        }
    }
}
