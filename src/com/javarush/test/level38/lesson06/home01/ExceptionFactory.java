package com.javarush.test.level38.lesson06.home01;

/**
 * Created by admin on 06.05.2016.
 */
public class ExceptionFactory
{
    public static Throwable getExceptionFactory(Enum message)
    {
        if (message != null)
            if (message instanceof ExceptionApplicationMessage)
            {
                String msg = message.name().toUpperCase().charAt(0) + message.name().substring(1).toLowerCase().replaceAll("_", " ");
                return new Exception(msg);
            } else if (message instanceof ExceptionDBMessage)
            {
                String msg = message.name().toUpperCase().charAt(0) + message.name().substring(1).toLowerCase().replaceAll("_", " ");
                return new RuntimeException(msg);
            } else if (message instanceof ExceptionUserMessage)
            {
                String msg = message.name().toUpperCase().charAt(0) + message.name().substring(1).toLowerCase().replaceAll("_", " ");
                return new Error(msg);
            }
        return new IllegalArgumentException();
    }
}
