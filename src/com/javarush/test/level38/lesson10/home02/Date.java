package com.javarush.test.level38.lesson10.home02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Date {
    int year();

    int month();

    int day();

    int hour();

    int minute();

    int second();
    //напиши свой код
}
