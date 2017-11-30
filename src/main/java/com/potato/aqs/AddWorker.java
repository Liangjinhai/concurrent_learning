package com.potato.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * Created by potato on 2017/10/13.
 */
public class AddWorker implements Runnable {

    private NumCalculate calculate;

    public AddWorker(NumCalculate calculate) {
        this.calculate = calculate;
    }



    public void run() {
        for (;;){
            calculate.add();
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
