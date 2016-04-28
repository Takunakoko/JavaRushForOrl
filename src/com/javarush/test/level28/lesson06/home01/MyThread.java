package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by admin on 08.02.2016.
 */
public class MyThread extends Thread
{
    static AtomicInteger priority = new AtomicInteger(1);

    private void setPriority(Thread t)
    {
        t.setPriority(priority.getAndIncrement());
        if (priority.get() == 11)
            priority.set(1);
    }

    public MyThread()
    {
        setPriority(this);
    }

    public MyThread(Runnable target)
    {
        super(target);
        setPriority(this);
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        setPriority(this);
    }

    public MyThread(String name)
    {
        super(name);
        setPriority(this);
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        setPriority(this);
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        setPriority(this);
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        setPriority(this);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        setPriority(this);
    }


}
