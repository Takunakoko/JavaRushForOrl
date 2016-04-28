package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();

        String param = args[0];
        int id = 0;

        if ("-c".equals(param)){
            id = createNewPositionID(nameFile);
            String string = configurateString(id, args);
            addNewPosition(nameFile, string);
            print(nameFile);
        }
    }
    public static String configurateString(int id, String[] args)
    {
        char[] idChar = (id + "").toCharArray();
        char[] produceName = args[1].toCharArray();
        char[] price = args[2].toCharArray();
        char[] quantity = args[3].toCharArray();
        char[] newString = new char[50];
        String stringFull = "";

        for (int i = 0; i < idChar.length; i++)
            newString[i] = idChar[i];
        for (int i = 0; i < produceName.length; i++)
            newString[i+8] = produceName[i];
        for (int i = 0; i < price.length; i++)
            newString[i+38] = price[i];
        for (int i = 0; i < quantity.length; i++)
            newString[i+46] = quantity[i];

        for(char x : newString) {
            if (x == 0) x = ' ';
            stringFull += x;
        }
        return stringFull;
    }
    public static void addNewPosition(String nameFile, String string) throws IOException
    {
        BufferedWriter out = new BufferedWriter(new FileWriter(nameFile, true));
        out.write("\r" + string);
        out.close();
    }

    public static int createNewPositionID(String nameFile) throws IOException
    {
        TreeSet<Integer> list = new TreeSet<>();
        int idCreatePosition = 0;

        Scanner in = new Scanner(new File(nameFile));
        while (in.hasNext()){
            String input = in.nextLine();
            if ("".equals(input))
                continue;
            char[] tmp = new char[8 - 0];               //Массив для первых 8 символов строки
            input.getChars(0, 8, tmp, 0);               //Добавить в массив(начиная с 0) символы с 0 до 7 индексом
            String fromChar = new String(tmp).trim();   //Собрать в строку и отсечь пробелы
            list.add(Integer.parseInt(fromChar));       //Добавляем числа в TreeSet
        }
        in.close();
        if (list.isEmpty()){
            idCreatePosition++;
        }else
            idCreatePosition = list.last() + 1;
        return idCreatePosition;
    }

    public static void print(String nameFile) throws IOException
    {
        Scanner input = new Scanner(new File(nameFile));
        while(input.hasNext()){
            System.out.println(input.nextLine());
        }
        input.close();
    }
}
