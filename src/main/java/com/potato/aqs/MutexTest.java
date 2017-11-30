package com.potato.aqs;

import java.util.concurrent.locks.Lock;

/**
 * Created by potato on 2017/10/13.
 */
public class MutexTest {



    public static void main(String[] args){


        NumCalculate calculate=new NumCalculate(100);

        AddWorker add=new AddWorker(calculate);
        MinusWorker minus=new MinusWorker(calculate);

        new Thread(add,"add1").start();

        new Thread(minus,"minus1").start();
        new Thread(minus,"minus2").start();

    }
}
