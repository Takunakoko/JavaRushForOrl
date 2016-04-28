package com.javarush.test.level22.lesson13.task03;

import java.util.ArrayList;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {

    public static boolean checkTelNumber(String telNumber) {
        String forCheckLength = telNumber.replaceAll("[()-]", "");
        if (forCheckLength.matches("\\+[\\d]{12}|[\\d]{10}"))
        {
            if (telNumber.matches("^(\\+?\\d*)(\\(\\d{3}\\))?[\\d]+[-]?([\\d]+[-]?[\\d]+)$"))
                return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<>();
        boolean flag = true;
        String falseEl = "\t\t\t\t\t\t\t\tFALSE:";
        list.add("+380501234567");
        list.add("+38(050)1234567");
        list.add("+38050123-45-67");
        list.add("+38050123-4567");
        list.add("(123)1234567");
        list.add(falseEl);
        list.add("++380501234567");
        list.add("(1231234567");
        list.add("0-1(123)12345");
        list.add("(1234)123456");
        list.add("(123)1234567-");
        list.add("+38)050(1234567");
        list.add("+38(050)1-23-45-6-7");
        list.add("050ххх4567");
        list.add("050123456");
        list.add("(0)501234567");
        list.add("+380501234523");
        list.add("+38(050)1234567");
        list.add("+38050(123)(456)7");
        list.add("++380501234567");
        list.add("(380)5012345");
        list.add("+38050123--4567");
        list.add("050123--4567");
        list.add("0-50123-4567");
        list.add("+38)050(1234567");
        list.add("+38(050)1-23-45-6-7");
        list.add("050ххх4567");
        list.add("050123456");
        list.add("(0)501234567");
        list.add("+38-(050)1234567");
        list.add("+38((050)1234567");
        list.add("+5(0--5)1234567");
        list.add("1-23456789-0");
        list.add("+38051202(345)-7");
        list.add("+38051202(345)7");
        list.add("+38051202(345)7");
        list.add("+-313450531202");
        list.add("+313450--531202");
        list.add("38xx501A34567");
        list.add("3805012345");
        list.add("+38(0501234567");
        list.add("+38(050)1234567");
        list.add("+38(05)1234567");
        list.add("(3)80501234567");
        list.add("380-50123-45");
        list.add("(380)501-234567");
        list.add("(38-0)501234567");
        list.add("380-(501)234567");
        list.add("380(50-1)234567");
        list.add("380(501)(23)4567");
        list.add("+38050123(456)7");
        list.add("+38050123(456)76");
        list.add("+380501234(567)");
        list.add("3-805-0123-45");
        list.add("-3805-012345");
        list.add("3805-012345-");
        list.add("+38(05)01234567");
        list.add("+38(0501)234567");
        list.add("+38050123-45-67");
        list.add("050123-4567");
        list.add("7-4-4123689-5");
        list.add("(380)501-234567");
        list.add("+--313450531212");
        list.add("+313450--531202");
        list.add("+38051202(345)-7");
        list.add("+313450--531202Э");

        for (String s : list){
            if (falseEl.equals(s)){
                System.out.println(s);
                flag = false;
            }else
            {
                if (flag)
                    System.out.println(flag + "  : \t" + checkTelNumber(s) + " : \t" + s);
                if (!flag)
                    System.out.println(flag + " : \t" + checkTelNumber(s) + " : " + s);
            }
        }
    }
}
