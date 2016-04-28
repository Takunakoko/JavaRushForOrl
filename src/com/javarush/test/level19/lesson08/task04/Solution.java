package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        String result = outputStream.toString();

        System.setOut(consoleStream);

        operation(result);
    }

    public static void operation(String input){

        char[] temp = input.toCharArray();
        String digit1 = "";
        String digit2 = "";
        char operation = 0;
        for (int i = 0; i < temp.length; i++)
        {
            if (temp[i] != 42 && temp[i] != 43 && temp[i] != 45 && temp[i] != '=')      //ищем первое число, затем второе число
                digit2 += temp[i];
            else if (temp[i] == 42 || temp[i] == 43 || temp[i] == 45)                   //выбираем знак операции +, -, *
            {
                operation = temp[i];                                                    //знак операции
                digit1 = digit2;                                                        //первое число
                digit2 = "";                                                            //обнуляем второе число
            } else
                break;
        }
        int digitInt1 = Integer.parseInt(digit1.trim());
        int digitInt2 = Integer.parseInt(digit2.trim());
        int resultOfOperation = 0;
        if (operation == '+')
            resultOfOperation = digitInt1 + digitInt2;
        if (operation == '-')
            resultOfOperation = digitInt1 - digitInt2;
        if (operation == '*')
            resultOfOperation = digitInt1 * digitInt2;

        System.out.println(input.trim() + " " + resultOfOperation);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

