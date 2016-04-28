package com.javarush.test.level19.lesson03.task05;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("Ukraine", "UA");
        countries.put("Russia", "RU");
        countries.put("Canada", "CA");
    }

    public static class DataAdapter implements RowItem{
        private Contact contact;
        private Customer customer;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String contry = countries.get(customer.getCountryName());
            return contry;
        }

        @Override
        public String getCompany() {
            String company = customer.getCompanyName();
            return company;
        }

        @Override
        public String getContactFirstName() {
            String[] firstName = contact.getName().split(", ");
            return firstName[1];
        }

        @Override
        public String getContactLastName() {
            String[] firstName = contact.getName().split(", ");
            return firstName[0];
        }

        @Override
        public String getDialString() {
            char[] temp = contact.getPhoneNumber().toCharArray();

            String callTo = "callto://";
            for (int i = 0; i < temp.length; i++)
            {
                if (temp[i] >= 48 && temp[i] <= 57 || temp[i] == 43){       //Проверяем код ASCII для 0-9 и "+"
                        callTo += temp[i];
                    }
            }
            return callTo;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }

    //////////////////////////////////////////////////////////////////////
    public static void main (String args[]) {
        Customer customer = new Customer()
        {
            @Override
            public String getCompanyName()
            {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName()
            {
                return "Russia";
            }
        };
        Contact contact = new Contact()
        {
            @Override
            public String getName()
            {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber()
            {
                return "+7(050)123-45-67";
            }
        };

          RowItem rowItem = new DataAdapter(customer, contact);

        System.out.println(rowItem.getCountryCode());
        System.out.println(rowItem.getCompany());
        System.out.println(rowItem.getContactFirstName());
        System.out.println(rowItem.getContactLastName());
        System.out.println(rowItem.getDialString());

    }
}