package com.potato.lock;

import java.util.concurrent.TimeUnit;

/**
 * Created by potato on 2017/10/12.
 */
public class Producer implements  Runnable {

    private LockQueue lockQueue;

    public Producer(LockQueue lockQueue) {
        this.lockQueue = lockQueue;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                lockQueue.produce();
                TimeUnit.SECONDS.sleep(1);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
