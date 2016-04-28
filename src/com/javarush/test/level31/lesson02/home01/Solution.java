package com.javarush.test.level31.lesson02.home01;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.util.*;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1.
Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution
{
    public static File result;

    public static void main(String[] args) throws IOException
    {
        String path = args[0];
        String resultFileAbsolutePath = args[1];

        File folder = new File(path);
        result = new File(resultFileAbsolutePath);

        List<File> list = new ArrayList<>();

        list.addAll(getFiles(folder));

        Collections.sort(list, new Comparator<File>()
        {
            @Override
            public int compare(File o1, File o2)
            {
                return o1.getName().compareTo(o2.getName());
            }
        });

        File newFile = new File(result.getParent() + "/allFilesContent.txt");

        new File(result.getParent()).mkdirs();
        result.createNewFile();

        result.renameTo(newFile);

        int countOfFile = list.size();
        FileWriter writer = new FileWriter(newFile);

        for (File file : list)
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            while (reader.ready())
            {
                writer.write(reader.read());
            }

            if (--countOfFile > 0)
                writer.append('\n');
            reader.close();
        }
        writer.close();

    }

    public static Set<File> getFiles(File folder)
    {
        Set<File> set = new HashSet<>();
        for (File file : folder.listFiles())
        {
            if (!file.equals(result))
                if (!file.isDirectory())
                {
                    if (file.length() > 50)
                        file.delete();
                    else
                    {
                        set.add(file);
                    }
                } else
                {
                    set.addAll(getFiles(file));
                    file.delete();
                }
        }
        return set;
    }
}
