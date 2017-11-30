package com.potato.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * Created by potato on 2017/10/13.
 */
public class SumTaskTest {
    public static  void main(String[] args){

        // 创建需要计算的数组:
        Long[] array = new Long[800];
        for (int i=0;i<array.length-1;i++){
            array[i]=new Long(i+array.length);
        }
        // fork/join task:
        ForkJoinPool fjp = new ForkJoinPool(4); // 最大并发数4
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
        long startTime = System.currentTimeMillis();
        Long result = fjp.invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
    }
}
