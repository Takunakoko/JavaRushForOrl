package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    public static class IncomeDataAdapter implements Customer, Contact{

        static IncomeData list;
        IncomeDataAdapter(IncomeData list){
            this.list = list;
        }

        @Override
        public String getName() {
            return list.getContactLastName() + ", " + list.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String numParts = "";

            String number = String.format("%010d", list.getPhoneNumber());

            char[] numToChar = number.toCharArray();

            for (int i = 0; i < 3; i++)
                numParts += numToChar[i];
            numParts += ")";

            for(int i = 3; i < numToChar.length; i++)
            {
                if (i == 6 || i == 8)
                    numParts += "-";
                numParts += numToChar[i];
            }

            String numberFull = "+" + list.getCountryPhoneCode() + "(" + numParts;
            return numberFull;
        }

        @Override
        public String getCompanyName()
        {
            return list.getCompany();
        }

        @Override
        public String getCountryName()
        {
            String contries = countries.get(list.getCountryCode());
            return contries;
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }



    ////////////////////////////////////////////////////////////////////////////
    public static void main (String args[])
    {
        IncomeData incomeData = new IncomeData()
        {
            @Override
            public String getCountryCode()
            {
                return "RU";
            }

            @Override
            public String getCompany()
            {
                return "JavaRush Ltd.";
            }

            @Override
            public String getContactFirstName()
            {
                return "Ivan";
            }

            @Override
            public String getContactLastName()
            {
                return "Ivanov";
            }

            @Override
            public int getCountryPhoneCode()
            {
                return 7;
            }

            @Override
            public int getPhoneNumber()
            {
                return 51234567;
            }
        };

            Customer customer = new IncomeDataAdapter(incomeData);
            Contact contact = new IncomeDataAdapter(incomeData);

            System.out.println(customer.getCompanyName());
            System.out.println(customer.getCountryName());
            System.out.println(contact.getName());
            System.out.println(contact.getPhoneNumber());

    }
}