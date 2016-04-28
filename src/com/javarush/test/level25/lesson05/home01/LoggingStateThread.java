package com.javarush.test.level25.lesson05.home01;

class LoggingStateThread extends Thread
{
    Thread target;

    @Override
    public void run()
    {
        State state = target.getState();

        System.out.println(target.getState());
        while (target.getState() != State.TERMINATED)
        {
            if (state != target.getState())
            {
                state = target.getState();
                System.out.println(state);
            }
        }
        System.out.println(target.getState());
    }

    public LoggingStateThread(Thread target)
    {
        this.setDaemon(true);
        this.target = target;
    }
}