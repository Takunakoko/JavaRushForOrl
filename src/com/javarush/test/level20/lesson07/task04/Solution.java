package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные на сегодняшний день данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws IOException
    {
        try
        {
            Solution savedObject = new Solution(-3);
            System.out.println(savedObject);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\1\\tt.txt"));

            System.out.println("Serializing:");

            objectOutputStream.writeObject(savedObject);
            objectOutputStream.close();

            Solution loadedObject = new Solution(50);                       //Создаем новый объект с отличным параметром
            System.out.println(loadedObject);

            ObjectInputStream objectInputStream = new ObjectInputStream((new FileInputStream("C:\\1\\tt.txt")));
            System.out.println("Deserializing:");                       //Загружаем сохраненный объект в "новый" объект.
            loadedObject = (Solution) objectInputStream.readObject();

            System.out.println(loadedObject);
            objectInputStream.close();
        }catch (Exception e){System.out.print(e.toString());}
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(){
    }

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
