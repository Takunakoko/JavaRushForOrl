package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;
import com.javarush.test.level33.lesson15.big01.tests.FunctionalTest;
import com.javarush.test.level33.lesson15.big01.tests.SpeedTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static com.javarush.test.level33.lesson15.big01.Helper.generateRandomString;
import static com.javarush.test.level33.lesson15.big01.Helper.printMessage;

/**
 * Created by admin on 05.04.2016.
 */
public class Solution
{
    public static Set<Long> getIds(Shortener shortener, Set<String> strings)
    {
        Set<Long> ids = new HashSet<>();
        for (String s : strings)
        {
            ids.add(shortener.getId(s));
        }
        return ids;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys)
    {
        Set<String> strings = new HashSet<>();
        for (Long key : keys)
        {
            strings.add(shortener.getString(key));
        }
        return strings;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber)
    {
        Set<String> tempAfterGen = new HashSet<>();
        Set<Long> keys;
        Set<String> value;
        Shortener shortener = new Shortener(strategy);

        printMessage(strategy.getClass().getSimpleName());

        for (long l = 0; l < elementsNumber; l++)
            tempAfterGen.add(generateRandomString());

        long startTimeGetIds = new Date().getTime();
        keys = getIds(shortener, tempAfterGen);
        long resultTimeForGen = new Date().getTime() - startTimeGetIds;
        printMessage("Время выполнения операции getIds: \t\t" + resultTimeForGen);

        long startTimeGetStrings = new Date().getTime();
        value = getStrings(shortener, keys);
        long resultTimeForGetStrings = new Date().getTime() - startTimeGetStrings;
        printMessage("Время выполнения операции getStrings: \t" + resultTimeForGetStrings);

        if (tempAfterGen.equals(value))
            printMessage("Тест пройден.");
        else
            printMessage("Тест не пройден.");
    }

    public static void main(String[] args)
    {
        testStrategy(new HashMapStorageStrategy(), 10_000);
        testStrategy(new OurHashMapStorageStrategy(), 10_000);
        testStrategy(new FileStorageStrategy(), 500);
        testStrategy(new OurHashBiMapStorageStrategy(), 10_000);
        testStrategy(new HashBiMapStorageStrategy(), 10_000);
        testStrategy(new DualHashBidiMapStorageStrategy(), 10_000);
        new SpeedTest().testHashMapStorage();
    }
}
