package com.potato.lock;


/**
 * Created by potato on 2017/10/12.
 */
public class LockQueueExample {

    public static void main(String[] args)
    {
        LockQueue lockqueue = new LockQueue();
        //启动消费者
        new Thread(new Consumer(lockqueue)).start();
        new Thread(new Consumer(lockqueue)).start();
        new Thread(new Consumer( lockqueue)).start();

        //启动生产者
        new Thread(new Producer( lockqueue)).start();
        new Thread(new Producer(lockqueue)).start();
        new Thread(new Producer(lockqueue)).start();

    }

}
