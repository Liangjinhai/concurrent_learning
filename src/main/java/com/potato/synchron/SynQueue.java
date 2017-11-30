package com.potato.synchron;

import java.util.concurrent.TimeUnit;

/**
 * Created by potato on 2017/10/12.
 */
public class SynQueue {

    private int idexNum = 0;
    private final int MAX_NUM = 10;
    private Object synObj = new Object();

    public void produce() throws InterruptedException
    {
        synchronized (synObj)
        {
            while (idexNum == this.MAX_NUM)
            {
                System.out.println("queue is full，size = " + idexNum);
                synObj.wait();
            }
            idexNum++;
            System.out.println("produce success foodNum = " + idexNum);
            TimeUnit.SECONDS.sleep(1);
            synObj.notifyAll();
        }

    }

    public void consume() throws InterruptedException
    {
        synchronized (synObj)
        {
            while (idexNum == 0)
            {
                System.out.println("queue is empty,size = " + idexNum);
                synObj.wait();
            }
            System.out.println("consume success foodNum = " + idexNum);
            idexNum--;
            synObj.notifyAll();
            TimeUnit.SECONDS.sleep(2);
        }

    }


}
