package com.javarush.test.level17.lesson10.bonus02;

import com.javarush.test.level17.lesson10.bonus01.*;

import java.text.*;
import java.util.*;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {
        //start here - начни тут
        if ("-c".equals(args[0])){
            create(args);
        }else
        if ("-u".equals(args[0])){
            update(args);
        }else
        if ("-d".equals(args[0])){
            delete(args);
        }else
        if ("-i".equals(args[0])){
            information(args);
        }

    }

    public static Date reFormatDate(String bd) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date docDate = format.parse(bd);
        return docDate;
    }

    public static void create(String[] args) throws ParseException {

        for (int i = 0; i < args.length-3; i=i+3)
        {
            String name = args[i + 1];
            String sex = args[i + 2];
            String bd = args[i + 3];

            Person person = null;
            if ("м".equals(sex))
            {
                person = Person.createMale(name, reFormatDate(bd));
                allPeople.add(person);
            } else if ("ж".equals(sex))
            {
                person = Person.createFemale(name, reFormatDate(bd));
                allPeople.add(person);
            }
            System.out.println(allPeople.indexOf(person));
        }
    }

    public static void update(String[] args) throws ParseException {

        for (int i = 0; i < args.length-4; i=i+4)
        {
            int id = Integer.parseInt(args[i+1]);
            String name = args[i+2];
            String sex = args[i+3];
            String bd = args[i+4];

            Person person = allPeople.get(id);
            person.setName(name);
            if ("м".equals(sex))
                person.setSex(Sex.MALE);
            if ("ж".equals(sex))
                person.setSex(Sex.FEMALE);

            person.setBirthDay(reFormatDate(bd));
        }
    }

    public static void delete(String[] args) {

        for (int i = 0; i < args.length-1; i++)
        {
            int id = Integer.parseInt(args[i+1]);
            allPeople.get(id).setBirthDay(null);
            allPeople.get(id).setName(null);
            allPeople.get(id).setSex(null);
        }
    }

    public static void information(String[] args){

        for (int i = 0; i < args.length-1; i++)
        {
            int id = Integer.parseInt(args[i + 1]);
            Person person = allPeople.get(id);
            String birthDay = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDay());
            if (Sex.MALE.equals(person.getSex()))
                System.out.println(person.getName() + " " + "м" + " " + birthDay);
            if (Sex.FEMALE.equals(person.getSex()))
                System.out.println(person.getName() + " " + "ж" + " " + birthDay);
        }
    }
}