package com.potato.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by potato on 2017/10/12.
 */
public class LockQueue {

    private int idexNum = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private final int MAX_NUM = 10;

    public void consumer(){
        lock.lock();
        try{
            while (idexNum==0){
                System.out.println("que is empty，size = " + idexNum);
                condition.await();
            }
            System.out.println("consumer success idexNum = " + idexNum);
            idexNum--;
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void produce()
    {
        lock.lock();
        try
        {
            while (idexNum == MAX_NUM)
            {
                System.out.println("que is full，size = " + idexNum);
                condition.await();
            }
            idexNum++;
            System.out.println("produce success idexNum = " + idexNum);
            condition.signalAll();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        } finally
        {
            lock.unlock();
        }

    }

}
