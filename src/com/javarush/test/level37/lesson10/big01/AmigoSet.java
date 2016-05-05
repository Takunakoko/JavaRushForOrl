package com.javarush.test.level37.lesson10.big01;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Created by admin on 05.05.2016.
 */
public class AmigoSet<E> extends AbstractSet<E> implements Set<E>, Serializable, Cloneable
{

    private final static Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet()
    {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection)
    {
        int capacity = (int) Math.max(16, collection.size() / .75f);
        this.map = new HashMap<>(capacity);
        this.addAll(collection);
    }

    @Override
    public boolean add(E e)
    {
        map.put(e, PRESENT);
        return map.containsKey(e);
    }

    @Override
    public Iterator iterator()
    {
        return map.keySet().iterator();
    }

    @Override
    public int size()
    {
        return map.size();
    }

    @Override
    public void clear()
    {
        super.clear();
    }

    @Override
    public boolean contains(Object o)
    {
        return super.contains(o);
    }

    @Override
    public boolean isEmpty()
    {
        return super.isEmpty();
    }

    @Override
    public boolean remove(Object o)
    {
        return super.remove(o);
    }

    @Override
    public Object clone()
    {
        AmigoSet<E> cloneAmigoSet = new AmigoSet();
        try
        {
            cloneAmigoSet.addAll(this);
            cloneAmigoSet.map.putAll(this.map);
        }
        catch (Exception e)
        {
            throw new InternalError();
        }
        return cloneAmigoSet;
    }

    private void writeObject(ObjectOutputStream out) throws IOException
    {

        out.defaultWriteObject();

        out.writeObject(map.size());
        for (E e : map.keySet())
            out.writeObject(e);
        out.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
        out.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        Set<E> set = new HashSet<>();

        in.defaultReadObject();

        int size = (int) in.readObject();
        for (int i = 0; i < size; i++)
            set.add((E) in.readObject());
        int capacity = (int) in.readObject();
        float loadFactor = (float) in.readObject();

        map = new HashMap<>(capacity, loadFactor);
        for(E e : set)
            map.put(e, PRESENT);
    }
}
