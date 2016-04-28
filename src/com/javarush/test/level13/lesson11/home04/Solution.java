package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String nameOfFile = r.readLine();
        OutputStream outStream = new FileOutputStream(nameOfFile);

        while (true)
        {
            String input = r.readLine();

            input = input + "\r\n";                        //   \r\n - перевод строки!!!!
            //System.out.println("Че ввели " + input);

            char[] data = input.toCharArray();
            {
                //System.out.print("Строка: ");
                for (int i = 0; i < data.length; i++)
                {
                    int dataInt = (int) data[i];
                    outStream.write(dataInt);

                    //System.out.print(dataInt + " ");
                }
                //System.out.println();
            }
            if (input.equals("exit\r\n")) { break; }

        }
        r.close();
        outStream.close();

    }
}
