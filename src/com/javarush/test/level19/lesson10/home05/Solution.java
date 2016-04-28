package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String nameFile1 = args[0];
        String nameFile2 = args[1];

        Scanner scan = new Scanner(new File(nameFile1));
        BufferedWriter out = new BufferedWriter(new FileWriter(nameFile2));

        while(scan.hasNext()){
            String string = scan.next();
            if(!string.matches("^\\D*$"))                                   //Если слово содержит цифру
                out.write(string + " ");
        }

        scan.close();
        out.close();
    }
}
