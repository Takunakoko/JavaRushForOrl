package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {

        String param = args[0];
        String fileName = args[1];
        String fileOutput = args[2];

        if ("-e".equals(param)){
            encrypt(fileName,  fileOutput);
        }else
        if ("-d".equals(param)) {
            decrypt(fileName, fileOutput);
        }
    }
    public static void encrypt(String fileName, String fileOutputName) throws IOException
    {
        createOutputFile(fileOutputName);

        FileInputStream inputStream = new FileInputStream(fileName);
        FileOutputStream outputStream = new FileOutputStream(fileOutputName);

        while(inputStream.available() > 0){
            int tmp = inputStream.read();
            tmp = shiftMethod(tmp);
            outputStream.write(tmp);
        }
        inputStream.close();
        outputStream.close();
    }

    public static void decrypt(String fileName, String fileOutputName) throws IOException
    {
        createOutputFile(fileOutputName);

        FileInputStream inputStream = new FileInputStream(fileName);
        FileOutputStream outputStream = new FileOutputStream(fileOutputName);
        
        while(inputStream.available() > 0){
            int tmp = inputStream.read();
            tmp = shiftMethod(tmp);
            outputStream.write(tmp);
        }
        inputStream.close();
        outputStream.close();
    }

    public static int shiftMethod(int tmp){
        tmp = (tmp % 2 == 0) ? tmp+1 : tmp-1;
        return tmp;
    }

    public static void createOutputFile(String nameFile) throws IOException
    {
        File file = new File(nameFile);
        //Если требуемого файла не существует.
        if(!file.exists()) {
            //Создаем его.
            file.createNewFile();
        }
    }
}
