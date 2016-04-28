package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException
    {
        if (string != null) {
            String[] strings = string.split(" ");
            if (strings.length < 5)                                     //Количество элементов на 1 больше, чем пробелов
            {
                throw new TooShortStringException();
            } else{
                int firstChar = string.indexOf(" ") + 1;                //Индекс символа после первого пробела
                int lastChar = firstChar;
                int countSpace = 0;                                     //Счетчик пробелов
                int fourSpace = 0;                                      //Индекс четвертого пробела
                int index = 0;                                          //Индекс текущего пробела
                while (countSpace < 4){
                    index = string.indexOf(" ", index + 1);
                    countSpace++;
                    if (countSpace == 4)
                        fourSpace = index;
                }
                lastChar = string.indexOf(" ", fourSpace + 1);
                String string2 = string.substring(firstChar, lastChar);

                strings = null;
                return string2;
            }
        } else {
            throw new TooShortStringException();
        }


    }

    public static class TooShortStringException extends Exception{

        public TooShortStringException(){
        }

    }

    public static void main(String[] args) throws TooShortStringException
    {
        String example = "JavaRush - лучший сервис обучения Java.";

        System.out.println(getPartOfString(example));
    }
}
