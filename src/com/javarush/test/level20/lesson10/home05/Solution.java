package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution {

    public static class Person implements Serializable{
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Person newPerson = new Person("Алеша", "Богданов", "Русь", Sex.MALE);
        String file = "C:\\1\\tt.txt";

        ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(file));
        oOS.writeObject(newPerson);
        oOS.close();

        System.out.println(newPerson.greetingString + newPerson.fullName + "\t" + newPerson.country + "\t" + newPerson.sex);
        System.out.println("\t" + newPerson.outputStream);
        System.out.println("\t" + newPerson.logger);

        ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(file));
        Person loadPerson = (Person) oIS.readObject();
        oIS.close();

        System.out.println(loadPerson.greetingString + loadPerson.fullName + "\t" + loadPerson.country + "\t" + loadPerson.sex);
        System.out.println("\t" + loadPerson.outputStream);
        System.out.println("\t" + loadPerson.logger);
    }
}
