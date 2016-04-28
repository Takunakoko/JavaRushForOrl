package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

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
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();

        ArrayList<String> list = new ArrayList<>();
        String param = args[0];
        String id = "" + args[1];

        if ("-u".equals(param)){
            int index = searchInputPositionID(list, id, nameFile);
            String newString = configurateString(args);
            updateString(newString, list, index);
            writeToFile(nameFile, list);
        }else
        if ("-d".equals(param)){
            int index = searchInputPositionID(list, id, nameFile);
            deleteString(list, index);
            writeToFile(nameFile, list);
        }else
        return;


        reader.close();
    }

    public static int searchInputPositionID(ArrayList<String> list, String id, String nameFile) throws FileNotFoundException
    {
        Scanner in = new Scanner(new File(nameFile));

        int count = 0;
        int indexString = 0;
        while (in.hasNext()){
            String stringCurrent = in.nextLine();
            list.add(stringCurrent);
            if (id.equals(stringCurrent.substring(0, 8).trim())){
                indexString = count;
            }
            count++;
        }
        in.close();
        return indexString;
    }
    public static void updateString(String newString, ArrayList<String> list, int index)
    {
        list.remove(index);
        list.add(index, newString);
    }
    public static void deleteString(ArrayList<String> list, int index){
        list.remove(index);
    }
    public static void writeToFile(String nameFile, ArrayList<String> list) throws IOException
    {
        BufferedWriter out = new BufferedWriter(new FileWriter(nameFile));
        for(int i = 0; i < list.size(); i++){
            out.write(list.get(i));
            if (i != list.size()-1)
                out.newLine();
        }
        out.close();
    }
    public static String configurateString(String[] args)
    {
        char[] idChar = (args[1] + "").toCharArray();
        char[] produceName = args[2].toCharArray();
        char[] price = args[3].toCharArray();
        char[] quantity = args[4].toCharArray();
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



    public static void print(String nameFile) throws IOException
    {
        Scanner input = new Scanner(new File(nameFile));
        while(input.hasNext()){
            System.out.println(input.nextLine());
        }
        input.close();
    }

}
