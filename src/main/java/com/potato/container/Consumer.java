package com.potato.container;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by potato on 2017/10/12.
 */
public class Consumer implements Runnable {

    private BlockingQueue queue=null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        for (int i=0;true;i++){
            try {
                System.out.println("Consumer get "+queue.take());
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
