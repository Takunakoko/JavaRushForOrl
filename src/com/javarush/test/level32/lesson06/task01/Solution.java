package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution
{
    public static void main(String[] args)
    {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword()
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] tempByte = new byte[8];
        int random;
        boolean flagDigit = false;
        boolean flagUpper = false;
        boolean flagDown = false;
        for (int i = 0; i < 8; i++)
        {
            random = (int) (Math.random() * 3);
            switch (random)
            {
                case 0:
                    tempByte[i] = (byte) (Math.random() * 26 + 65);
                    flagUpper = true;
                    break;
                case 1:
                    tempByte[i] = (byte) (Math.random() * 26 + 97);
                    flagDown = true;
                    break;
                case 2:
                    tempByte[i] = (byte) (Math.random() * 10 + 48);
                    flagDigit = true;
                    break;
            }
        }
        if (!flagDigit || !flagDown || !flagUpper)
            return getPassword();
        try {
            outputStream.write(tempByte);
        }catch (IOException e) { }

        return outputStream;
    }
}
