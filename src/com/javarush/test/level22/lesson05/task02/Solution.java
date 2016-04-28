package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException
    {
        try
        {
            int firstChar = string.indexOf("\t") + 1;
            int lastChar = string.indexOf("\t", firstChar);

            string = string.substring(firstChar, lastChar);
            return string;
        }catch (Exception e){
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends Exception {
        public TooShortStringException(){}
    }

    public static void main(String[] args) throws TooShortStringException
    {
        {
            String example = "JavaRush - " + '\t' + "лучший сервис " + '\t' + "обучения Java.";


            System.out.println(getPartOfString(example));
        }
    }
}
