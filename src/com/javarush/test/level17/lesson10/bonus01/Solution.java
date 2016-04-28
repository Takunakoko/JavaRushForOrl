package com.javarush.test.level17.lesson10.bonus01;

import java.io.*;
import java.text.*;
import java.util.*;


/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран         сделано!
-u  - обновляет данные человека с данным id                                                             сделано!
-d  - производит логическое удаление человека с id                                                      сделано!
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)               сделано!

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
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

        String name = args[1];
        String sex = args[2];
        String bd = args[3];

        Person person = null;
        if ("м".equals(sex)) {
            person = Person.createMale(name, reFormatDate(bd));
            allPeople.add(person);
        }else
        if ("ж".equals(sex)) {
            person = Person.createFemale(name, reFormatDate(bd));
            allPeople.add(person);
        }
        System.out.println(allPeople.indexOf(person));
    }

    public static void update(String[] args) throws ParseException {

        int id = Integer.parseInt(args[1]);
        String name = args[2];
        String sex = args[3];
        String bd = args[4];

        Person person = allPeople.get(id);
        person.setName(name);
        if ("м".equals(sex))
            person.setSex(Sex.MALE);
        if ("ж".equals(sex))
            person.setSex(Sex.FEMALE);

        person.setBirthDay(reFormatDate(bd));
    }

    public static void delete(String[] args){

        int id = Integer.parseInt(args[1]);
        allPeople.get(id).setBirthDay(null);
        allPeople.get(id).setName(null);
        allPeople.get(id).setSex(null);

    }

    public static void information(String[] args){

        int id = Integer.parseInt(args[1]);
        Person person = allPeople.get(id);
        String birthDay = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDay());
        if (Sex.MALE.equals(person.getSex()))
            System.out.println(person.getName() + " " + "м" + " " + birthDay);
        if (Sex.FEMALE.equals(person.getSex()))
            System.out.println(person.getName() + " " + "ж" + " " + birthDay);
    }
}
