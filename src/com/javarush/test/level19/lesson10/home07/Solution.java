package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
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

        boolean firstWord = true;
        while(scan.hasNext()){
            String word = scan.next();
            if (word.length() > 6 && firstWord) {
                out.write(word);
                firstWord = false;
                } else if (word.length() > 6)
                    out.write("," + word);
        }
        scan.close();
        out.close();
    }
}
