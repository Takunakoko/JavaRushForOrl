package com.javarush.test.level32.lesson08.home01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by admin on 28.03.2016.
 */
public class CustomInvocationHandler implements InvocationHandler
{
    private SomeInterfaceWithMethods someInterfaceWithMethodsOriginal;

    public CustomInvocationHandler(SomeInterfaceWithMethods someInterfaceWithMethodsOriginal)
    {
        this.someInterfaceWithMethodsOriginal = someInterfaceWithMethodsOriginal;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        System.out.println(String.format("%s in", method.getName()));
        method.invoke(someInterfaceWithMethodsOriginal, args);
        System.out.println(String.format("%s out", method.getName()));
        return null;
    }
}
