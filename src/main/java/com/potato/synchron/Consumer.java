package com.potato.synchron;

/**
 * Created by potato on 2017/10/12.
 */
public class Consumer implements Runnable {

    SynQueue queue;

    public Consumer(SynQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try
        {
            queue.consume();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
