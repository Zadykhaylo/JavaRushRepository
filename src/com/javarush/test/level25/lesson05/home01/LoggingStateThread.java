package com.javarush.test.level25.lesson05.home01;

public class LoggingStateThread extends Thread
{
    Thread thread;

    public LoggingStateThread(Thread target)
    {
        this.thread = target;
        setDaemon(true);

    }

    public void run() {
        State state = this.thread.getState();
        System.out.println(state);

        while (this.thread.getState() != State.TERMINATED)
        {
           if (thread.getState() != state) {
               state = thread.getState();
               System.out.println(state);
           }
        }
        System.out.println(this.thread.getState());
        this.interrupt();
    }
}
