package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("C:\\1\\tt.txt");
            InputStream inputStream = new FileInputStream("C:\\1\\tt.txt");

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

                User user1 = new User();                    User user2 = new User();
                user1.setBirthDate(new Date(39,3,29));      user2.setBirthDate(new GregorianCalendar(1970, 2, 3).getTime());
                user1.setCountry(User.Country.RUSSIA);      user2.setCountry(User.Country.OTHER);
                user1.setMale(true);                        user2.setMale(true);
                user1.setFirstName("Алеша");                user2.setFirstName("Василий");
                user1.setLastName("Попович");               user2.setLastName("Вякин");

            javaRush.users.add(user1);
            javaRush.users.add(user2);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println("Сохраненные данные:");
            for(User x : javaRush.users)
                System.out.println(x.getBirthDate()+"\t"+x.getCountry()+"\t"+x.getFirstName()+"\t"+x.getLastName()+"\t"+x.isMale());
            System.out.println();
            System.out.println("Загруженные данные:");
            for(User x : loadedObject.users)
            System.out.println(x.getBirthDate()+"\t"+x.getCountry()+"\t"+x.getFirstName()+"\t"+x.getLastName()+"\t"+x.isMale());

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            for (User x : users){
                printWriter.println(x.getFirstName());
                printWriter.println(x.getLastName());
                printWriter.println(x.getBirthDate().getTime());
                printWriter.println(x.getCountry());
                printWriter.println(x.isMale());
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while(reader.ready()){
                User user = new User();

                user.setFirstName(reader.readLine());
                user.setLastName(reader.readLine());

                Date tmpData = new Date(Long.parseLong(reader.readLine()));
                user.setBirthDate(tmpData);

                user.setCountry(User.Country.valueOf(reader.readLine()));

                Boolean sex = Boolean.parseBoolean(reader.readLine());
                user.setMale(sex);

                users.add(user);
            }
            reader.close();
        }
    }
}