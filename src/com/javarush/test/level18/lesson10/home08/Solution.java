package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while(!(input = reader.readLine()).equals("exit")){
            ReadThread readThread = new ReadThread(input);
            readThread.start();
        }
        reader.close();
        System.out.println(resultMap);
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        public void run()
        {
            try {
                FileInputStream inputStream = new FileInputStream(fileName);
                ArrayList<Integer> list = new ArrayList<Integer>();

                while (inputStream.available() > 0){
                    list.add(inputStream.read());
                }

                MaxByteCount(list, fileName);
                inputStream.close();

            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    public static void MaxByteCount(ArrayList<Integer> list, String fileName){
        int count = 0;

        for(int y : list){
            int tmp = Collections.frequency(list, y);
            if (count < tmp){
                count = tmp;
            }
        }
        for(int x : list){
            int tmp = Collections.frequency(list, x);
            if (tmp == count){
                resultMap.put(fileName, x);
            }
        }
    }
}
