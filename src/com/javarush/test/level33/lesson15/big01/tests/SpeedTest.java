package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import org.junit.Assert;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static com.javarush.test.level33.lesson15.big01.Helper.generateRandomString;

/**
 * Created by Александр on 09.04.2016.
 */
public class SpeedTest
{
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids)
    {
        long tStartTest = new Date().getTime();
        for (String s : strings)
        {
            ids.add(shortener.getId(s));
        }
        long tFinishTest = new Date().getTime() - tStartTest;
        return tFinishTest;
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings)
    {
        long tStartTest = new Date().getTime();
        for (Long id : ids)
        {
            strings.add(shortener.getString(id));
        }
        long tFinishTest = new Date().getTime() - tStartTest;
        return tFinishTest;
    }

    public void testHashMapStorage()
    {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        Set<Long> getterIds1 = new HashSet<>();
        Set<Long> getterIds2 = new HashSet<>();

        for(int i = 0; i < 10_000; i++)
        {
            origStrings.add(generateRandomString());
        }

        long t1 = getTimeForGettingIds(shortener1, origStrings, getterIds1);
        long t2 = getTimeForGettingIds(shortener2, origStrings, getterIds2);
        Assert.assertTrue(t1 > t2);

        long t3 = getTimeForGettingStrings(shortener1, getterIds1, new HashSet<String>());
        long t4 = getTimeForGettingStrings(shortener2, getterIds2, new HashSet<String>());
        Assert.assertEquals(t3, t4, 5);
    }
}
