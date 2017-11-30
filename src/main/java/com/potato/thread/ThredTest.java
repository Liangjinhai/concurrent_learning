package com.potato.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by potato on 2017/10/12.
 */
public class ThredTest {

    public static void main(String[] args) throws  InterruptedException{

        Thread thred=new Thread(new Runnable() {
            public void run() {
                System.out.print("thrend is running.....");
            }
        });

        thred.start();
        TimeUnit.SECONDS.sleep(5);

    }
}
