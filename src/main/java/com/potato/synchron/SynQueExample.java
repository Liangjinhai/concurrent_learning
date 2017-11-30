package com.potato.synchron;

/**
 * Created by potato on 2017/10/12.
 */
public class SynQueExample {

    public static void main(String[] args)
    {
        SynQueue synque = new SynQueue();
        //启动消费者
        new Thread(new Consumer(synque)).start();
        new Thread(new Consumer(synque)).start();
        new Thread(new Consumer( synque)).start();

        //启动生产者
        new Thread(new Producer( synque)).start();
        new Thread(new Producer(synque)).start();
        new Thread(new Producer(synque)).start();

    }
}
