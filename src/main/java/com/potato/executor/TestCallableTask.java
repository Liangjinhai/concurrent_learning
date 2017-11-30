package com.potato.executor;

import java.util.concurrent.*;

/**
 * Created by potato on 2017/10/13.
 */
public class TestCallableTask {

    public  static void main(String[] args)throws InterruptedException,ExecutionException{

        ExecutorService pool = Executors.newFixedThreadPool(2);
        Callable callTask1=new Callable() {
            @Override
            public Object call() throws Exception {
                return 100;
            }
        };
        Callable callTask2=new Callable() {
            @Override
            public Object call() throws Exception {
                TimeUnit.SECONDS.sleep(3);
                return 1000;
            }
        };
        Future future1= pool.submit(callTask1);
        Future future2= pool.submit(callTask2);

        System.out.println(System.currentTimeMillis()+" callTask1 get>>>" + future1.get().toString());
        System.out.println(System.currentTimeMillis()+" callTask2 get>>>" + future2.get().toString());


    }
}
