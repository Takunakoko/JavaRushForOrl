package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> tempList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        Scanner scanner = new Scanner(new FileInputStream(fileName));

        while (scanner.hasNext())
        {
            tempList.add(scanner.next());
        }
        scanner.close();
        reader.close();

        String[] words = new String[tempList.size()];
        words = tempList.toArray(words);

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder stringBuilder = new StringBuilder();
        if (words.length == 0)
            return stringBuilder;

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, words);
        stringBuilder.append(list.get(0));
        list.remove(0);
        while (list.size() > 0){
            int count = list.size();
            for (int i = 0; i < list.size(); i++){
                String temp = list.get(i).toUpperCase().toLowerCase();
                String stringTemp = stringBuilder.toString().toUpperCase().toLowerCase();
                if (temp.charAt(0) == stringTemp.charAt(stringTemp.length() - 1)){          //В конец строки
                    stringBuilder.append(" " + list.get(i));
                    list.remove(i);
                    continue;
                }
                if (temp.charAt(temp.length() - 1) == stringTemp.charAt(0)){                //В начало строки
                    stringBuilder.insert(0, list.get(i) + " ");
                    list.remove(i);
                }
            }
            if (count == list.size()){                                                      //Если комбинация не найдена
                list.clear();                                                               //мешаем лист и по новой ищем
                Collections.addAll(list, words);
                Collections.shuffle(list);
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(list.get(0));
                list.remove(0);
            }
        }
        return stringBuilder;
    }
}
