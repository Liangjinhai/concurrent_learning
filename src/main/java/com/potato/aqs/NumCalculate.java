package com.potato.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * Created by potato on 2017/10/13.
 */
public class NumCalculate {

    int num;
    Lock metex=new Mutex();
    public NumCalculate(int num) {
        this.num = num;
    }

    public void  add() {
        metex.lock();
        try{
            num++;
            System.out.println(" after " +Thread.currentThread().getName() +" add, num is "+num);
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            metex.unlock();
        }
    }

    public void  mimnus() {
        metex.lock();
        try{
            num--;
            System.out.println(" after " +Thread.currentThread().getName() +" minus, num is "+num);
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            metex.unlock();
        }
    }


}
