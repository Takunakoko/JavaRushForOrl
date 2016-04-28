package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.*;
import org.junit.Assert;
import org.junit.Test;

import static com.javarush.test.level33.lesson15.big01.Helper.generateRandomString;

/**
 * Created by Администратор on 08.04.2016.
 */
public class FunctionalTest
{
    public void testStorage(Shortener shortener)
    {
        String string1 = generateRandomString();
        String string2 = generateRandomString();
        String string3 = string1;

        long iD1 = shortener.getId(string1);
        long iD2 = shortener.getId(string2);
        long iD3 = shortener.getId(string3);

        Assert.assertNotEquals(iD2, iD1);
        Assert.assertNotEquals(iD2, iD3);
        Assert.assertEquals(iD1, iD3);

        String stringGet1 = shortener.getString(iD1);
        String stringGet2 = shortener.getString(iD2);
        String stringGet3 = shortener.getString(iD3);
        //Проверять, что строки, полученные в предыдущем пункте, эквивалентны оригинальным
        Assert.assertEquals(string1, stringGet1);
        Assert.assertEquals(string2, stringGet2);
        Assert.assertEquals(string3, stringGet3);
    }
    @Test
    public void testHashMapStorageStrategy()
    {
        StorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(hashMapStorageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testOurHashMapStorageStrategy()
    {
        StorageStrategy ourHashMapStorageStrategy = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(ourHashMapStorageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testFileStorageStrategy()
    {
        StorageStrategy fileStorageStrategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(fileStorageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testHashBiMapStorageStrategy()
    {
        StorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(hashBiMapStorageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testDualHashBidiMapStorageStrategy()
    {
        StorageStrategy dualHashBidiMapStorageStrategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(dualHashBidiMapStorageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testOurHashBiMapStorageStrategy()
    {
        StorageStrategy ourHashBiMapStorageStrategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(ourHashBiMapStorageStrategy);
        testStorage(shortener);
    }
}
