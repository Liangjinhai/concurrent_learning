package com.potato.container;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by potato on 2017/10/12.
 */
public class BlockingQueueExample {

    public static void main(String[] args)throws InterruptedException{

        BlockingQueue queue = new ArrayBlockingQueue(1024);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread productThread=new Thread(producer);
        Thread consumerThread=new Thread(consumer);

        consumerThread.start();
        productThread.start();

        TimeUnit.SECONDS.sleep(30);
    }



}
