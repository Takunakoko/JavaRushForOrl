package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String filename = args[0];
        FileInputStream inputStream = new FileInputStream(filename);
        int countSpace = 0;
        int countAnySym = 0;

        while(inputStream.available() > 0){
            int symbol = inputStream.read();
            if (symbol == 32){
                countSpace++;
                countAnySym++;
            }else{
                countAnySym++;
            }

        }

        float freq = 100f * countSpace/countAnySym;

        System.out.println(String.valueOf(roundUp(freq,2)));
        inputStream.close();
    }
    public static BigDecimal roundUp(double value, int digits){
        return new BigDecimal(""+value).setScale(digits, BigDecimal.ROUND_HALF_UP);
    }
}
