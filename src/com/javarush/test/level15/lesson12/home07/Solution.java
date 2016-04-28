package com.javarush.test.level15.lesson12.home07;

import java.io.*;
import java.util.*;



/* Файл в статическом блоке
1. Инициализируй константу Constants.FILE_NAME полным путем к файлу с данными, который содержит несколько строк.
2. В статическом блоке считай из файла с именем Constants.FILE_NAME все строки и добавь их по-отдельности в List lines.
3. Закрой поток ввода методом close().
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    public static void main(String[] args)
    {
        System.out.println(lines);
    }
    static{

        try
        {
            String string = "";
            InputStream inputStream = new FileInputStream(Constants.FILE_NAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while((string = reader.readLine()) != null)
            {
                lines.add(string);
            }
            inputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
