package com.javarush.test.level19.lesson10.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile1 = reader.readLine();
        String nameFile2 = reader.readLine();

        List<String> listOfFile1 = readFile(nameFile1);
        List<String> listOfFile2 = readFile(nameFile2);

        compareTwoList(listOfFile1, listOfFile2);

        printResult(lines);

        reader.close();
    }

    public static void printResult(List<LineItem> lines){
        for (LineItem x : lines)
            System.out.println(x.type + " " + x.line);
    }

    public static List<String> readFile(String nameFile) throws FileNotFoundException {
        List<String> list = new ArrayList<>();
        Scanner scan = new Scanner(new File(nameFile));

        while(scan.hasNext()){
            list.add(scan.nextLine());
        }
        scan.close();
        return list;
    }

    public static void compareTwoList (List<String> list1, List<String> list2){
        while(list1.size() > 0){
            boolean include = false;

            for(int i = 0; i < list2.size(); i++) {

                if (list2.get(i).equals(list1.get(0))){
                    lines.add(new LineItem(Type.SAME, list1.get(0)));
                    include = true;
                    list2.set(i, "INCLUDED!");
                    break;
                }

            }
            if(!include){
                lines.add(new LineItem(Type.REMOVED, list1.get(0)));
            }
            list1.remove(0);
        }
        int count = 0;                              //считаем сдвиг по индексу в lines. Определяем место где строка ADDED
        for (int i = 0; i < list2.size(); i++){     //должна быть по порядку

            if (i + count >= lines.size() && !"INCLUDED!".equals(list2.get(i))){    //Условие, при котором больше нет
                lines.add(new LineItem(Type.ADDED, list2.get(i)));                  //необходимости делать сдвиг.
            }else
            if (!"INCLUDED!".equals(list2.get(i)))                                  //Условие при котором необходим сдвиг
            {
                lines.add(i+count, new LineItem(Type.ADDED, list2.get(i)));
                count++;
            }
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
