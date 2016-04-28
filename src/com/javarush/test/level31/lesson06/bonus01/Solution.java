package com.javarush.test.level31.lesson06.bonus01;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        String resultFileName = args[0];
        String[] otherArg = args;

        File result = new File(resultFileName);

        byte[] buffer = new byte[1024];

        Set<File> partsList = new TreeSet();

        for (int i = 1; i < otherArg.length; i++)
            partsList.add(new File(otherArg[i]));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //читаем каждый кусок и пишем в byteArray поток
        for (File fileNamePart : partsList)
        {
            FileInputStream fis = new FileInputStream(fileNamePart);
            while (fis.read(buffer) > -1){
                baos.write(buffer);
                baos.flush();
            }
        }

        ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(baos.toByteArray()));
        FileOutputStream fileOutputStream = new FileOutputStream(resultFileName);

        ZipEntry zipEntry = zipInputStream.getNextEntry();
        while (zipEntry != null)
        {
            int count;
            while ((count = zipInputStream.read(buffer)) > -1)
            {
                fileOutputStream.write(buffer, 0, count);
                fileOutputStream.flush();
            }

            zipEntry = zipInputStream.getNextEntry();
        }
        fileOutputStream.close();
    }
}
