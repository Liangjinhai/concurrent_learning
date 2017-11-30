package com.potato.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * Created by potato on 2017/10/13.
 */
public class MinusWorker implements Runnable {


    private NumCalculate calculate;

    public MinusWorker(NumCalculate calculate) {
        this.calculate = calculate;
    }

    public void run() {
        for (;;){
            calculate.mimnus();
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
