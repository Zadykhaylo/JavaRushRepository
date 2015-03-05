package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    protected ConcurrentHashMap<String, String> map;

    public Producer (ConcurrentHashMap<String, String> map) {
        this.map = map;
    }
    public void run()
    {
        try {
            int i = 0;
            while (true) {
                System.out.println("Some text for " + String.valueOf(++i));
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }//To change body of implemented methods use File | Settings | File Templates.
    }
}
