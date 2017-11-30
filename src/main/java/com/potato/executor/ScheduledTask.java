package com.potato.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by potato on 2017/10/13.
 */
public class ScheduledTask {

    public static void main(String [] args){
        ScheduledExecutorService scheduledExecutor= Executors.newScheduledThreadPool(5);
        Runnable printTask=new Runnable() {
            @Override
            public void run() {
                System.out.println( " printTask print hello at " +System.currentTimeMillis());
            }
        };
        scheduledExecutor.scheduleAtFixedRate(printTask,2,3, TimeUnit.SECONDS);
    }
}
