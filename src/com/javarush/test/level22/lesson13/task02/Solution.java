package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException
    {
        String nameFileRead = args[0];
        String nameFileWrite = args[1];

        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");

        FileInputStream inputStream = new FileInputStream(nameFileRead);
        FileOutputStream outputStream = new FileOutputStream(nameFileWrite);

        byte[] buffer = new byte[inputStream.available()]; //win1251TestString.getBytes(windows1251);

        inputStream.read(buffer);
                                                    //Исходный файл должен быть в кодировке UTF-8, а текст в нем из тестСтринг!
        String s = new String(buffer, utf8);        //записываем набор байт в строку декодированные заданным параметром
        buffer = s.getBytes(windows1251);            //получаем набор байт в данной кодировке

        outputStream.write(buffer);

        inputStream.close();
        outputStream.close();
    }
}
