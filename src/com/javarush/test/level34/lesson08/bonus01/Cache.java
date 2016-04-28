package com.javarush.test.level34.lesson08.bonus01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V>
{
    private Map<K, V> cache = new WeakHashMap<>();

    public V getByKey(K key, Class<V> clazz) throws Exception
    {
        if (!cache.containsKey(key))
        {
            Constructor constructor = clazz.getConstructor(key.getClass());
            cache.put(key, (V) constructor.newInstance(key));
        }
        return cache.get(key);
    }

    public boolean put(V obj)
    {
        try
        {
            Method getKey = obj.getClass().getDeclaredMethod("getKey");
            getKey.setAccessible(true);
            return cache.put((K) getKey.invoke(obj), obj) != null;
        }
        catch (Exception ignore)
        {
        }
        return false;
    }

    public int size()
    {
        return cache.size();
    }
}
