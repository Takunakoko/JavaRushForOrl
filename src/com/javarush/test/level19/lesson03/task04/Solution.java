package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner scan;
        PersonScannerAdapter(Scanner list){
            this.scan = list;
        }

        @Override
        public Person read() throws IOException
        {
            String secondName = scan.next();
            String firstName = scan.next();
            String middleName = scan.next();

            int day = scan.nextInt();
            int mon = scan.nextInt() - 1;
            int yea = scan.nextInt();

            Date date = (new GregorianCalendar(yea, mon, day)).getTime();
            Person person = new Person(firstName, middleName, secondName, date);

            return person;
        }

        @Override
        public void close() throws IOException
        {
            scan.close();
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("C:/t1.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext())
        {
            PersonScannerAdapter adapter = new PersonScannerAdapter(scanner);
            System.out.println(adapter.read());
        }
        scanner.close();
    }
}
