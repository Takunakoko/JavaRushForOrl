package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ConsoleHelper
{
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException
    {

        String string = "";
        try
        {
            string = reader.readLine();
            if ("EXIT".equalsIgnoreCase(string))
                throw new InterruptOperationException();
        }
        catch (IOException ignored)
        {
        }
        return string;
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        String code;
        while(true)
        {
            writeMessage("Введите код валюты");
            code = readString();
            if (code.length() != 3)
            {
                writeMessage("Некорректный ввод");
                continue;
            }
            break;
        }
        return code.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        writeMessage("Введите два целых положительных числа");
        String[] array;

        while (true)
        {
            int denomination;
            int count;
            array = readString().split(" ");
            try
            {
                denomination = Integer.parseInt(array[0]);
                count = Integer.parseInt(array[1]);
            }
            catch (Exception e)
            {
                writeMessage("Некорректный ввод");
                continue;
            }
            if (array.length != 2 || denomination <= 0 || count <= 0)
            {
                writeMessage("Некорректный ввод");
                continue;
            }
            break;
        }
        return array;
    }

    public static Operation askOperation() throws InterruptOperationException
    {

        while(true)
        {
            writeMessage("Введите номер операции");

            String line = readString();
            try
            {
                int numberOperation = Integer.parseInt(line);

                return Operation.getAllowableOperationByOrdinal(numberOperation);
            }catch (IllegalArgumentException e){
                continue;
            }
        }
    }
}
