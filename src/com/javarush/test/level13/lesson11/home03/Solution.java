package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть закрыть файл и поток.
*/

import java.io.*;


public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //add your code here
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String nameOfFile = r.readLine();
        InputStream inStream = new FileInputStream(nameOfFile);

        while(inStream.available() > 0)
        {
            int data = inStream.read();
            System.out.print((char) data);
        }
        inStream.close();
        r.close();
    }
}
