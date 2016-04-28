package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by Администратор on 02.03.2016.
 */
public class Consumer implements Runnable
{
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(500);
        }
        catch (Exception e) {}

        while (true)
        {
            try
            {
                String item = queue.take().toString();
                System.out.println(String.format("Processing %s", item));
            }
            catch (InterruptedException e) {}
        }
    }
}
