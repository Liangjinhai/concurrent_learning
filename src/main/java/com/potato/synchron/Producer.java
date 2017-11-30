package com.potato.synchron;

/**
 * Created by potato on 2017/10/12.
 */
public class Producer implements Runnable {

    SynQueue queue;

    public Producer(SynQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try
        {
            queue.produce();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
