package com.javarush.test.level19.lesson10.home03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.util.Locale.ENGLISH;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws FileNotFoundException
    {
        String fileName = args[0];
        Scanner scan = new Scanner(new File(fileName));

        while(scan.hasNext()){
            String[] temp = scan.nextLine().split(" ");

            int year = Integer.parseInt(temp[temp.length - 1]);
            int month = Integer.parseInt(temp[temp.length - 2]) - 1;
            int day = Integer.parseInt(temp[temp.length - 3]);

            Calendar birthday = new GregorianCalendar(year, month, day);

            String fullName = "";
            for (int i = 0; i < temp.length - 3; i++){
                fullName += temp[i] + " ";
            }
            PEOPLE.add(new Person(fullName.trim(), birthday.getTime()));
        }

        scan.close();
        for (Person x : PEOPLE)
            System.out.println(x.getName() + " " + x.getBirthday());
    }

}
