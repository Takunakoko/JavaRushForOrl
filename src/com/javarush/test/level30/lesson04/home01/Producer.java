package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by Администратор on 02.03.2016.
 */
public class Producer implements Runnable
{
    private TransferQueue<ShareItem> queue;
    public Producer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        for (int i = 1; i <= 9; i++)
        {
            String temp = String.format("ShareItem-%d", i);
            System.out.format("Элемент '%s' добавлен\n", temp);
            queue.offer(new ShareItem(temp, i));
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
            }
            if(queue.hasWaitingConsumer())
                System.out.println("Consumer в ожидании!");
        }
    }
}
