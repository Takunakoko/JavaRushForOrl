package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws IOException
    {
        TreeMap<Integer, String> map = inputNameFiles();
        System.out.println(map);

        String nameOfFile = createNewFile(map);
        System.out.println(nameOfFile);

        copyToFile(nameOfFile, map);
    }

    public static TreeMap<Integer, String> inputNameFiles() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, String> map = new TreeMap<>();
        String nameFile;

        while ( !("end").equals(nameFile = reader.readLine()) ){
            int index = nameFile.indexOf(".part");
            String numPart = nameFile.substring(index + 5, nameFile.length());

            map.put(Integer.parseInt(numPart), nameFile);
        }
        reader.close();
        return map;
    }

    public static String createNewFile(TreeMap<Integer, String> map) throws IOException
    {
        int firstKey = map.firstKey();
        String nameFileCreate = map.get(firstKey).substring(0, map.get(firstKey).indexOf(".part"));

        File file = new File(nameFileCreate);
        //Если требуемого файла не существует.
        if(!file.exists()) {
            //Создаем его.
            file.createNewFile();
        }
        return nameFileCreate;
    }

    public static void copyToFile(String name, TreeMap<Integer, String> map) throws IOException
    {
        FileOutputStream outputStream = new FileOutputStream(name, true);
        for (Map.Entry<Integer, String> pair : map.entrySet()) {
            String nameOfPart = pair.getValue();

            FileInputStream inputStream = new FileInputStream(nameOfPart);

            while(inputStream.available() > 0) {
                byte[] buffer = new byte[inputStream.available()];
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, count);
            }
            inputStream.close();
        }
        outputStream.close();
    }
}
