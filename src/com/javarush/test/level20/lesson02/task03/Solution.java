package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.*;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws IOException
    {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();

        Properties prop = new Properties();
        prop.load(new FileInputStream(nameFile));
        Enumeration<?> e = prop.propertyNames();

        while (e.hasMoreElements()){
            String key = (String) e.nextElement();
            String value = prop.getProperty(key);

            properties.put(key, value);
        }

        reader.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        for(Map.Entry<String,String> entry: properties.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            prop.setProperty(key,value);
        }
        prop.store(outputStream,null);
        outputStream.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);
        Enumeration<?> e = prop.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = prop.getProperty(key);
            properties.put(key,value);
        }
        inputStream.close();
    }/*
    public static void main(String[] args) throws Exception
    {
        fillInPropertiesMap();
        System.out.println(properties);
        OutputStream outputStream = new FileOutputStream("C:\\t1.txt");
        InputStream inputStream = new FileInputStream("C:\\t1.txt");
        save(outputStream);
        load(inputStream);
        System.out.println(properties);
        outputStream.close();
        inputStream.close();
    }*/
}
