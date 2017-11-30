package com.potato.forkjoin;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by potato on 2017/10/13.
 */
public class SumTask extends RecursiveTask<Long> {

    private static final int SIZEHOLD=100;
    private Long[] array;
    private int start;
    private int end;

    public SumTask(Long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        Long sum=0L;
        if(end-start<=SIZEHOLD){
            for(int i=start;i<end-1;i++){
                sum+=array[i];
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(String.format(" compute %d~%d = %d", start, end, sum));
            return sum;
        }

        int middle=(end+start)/2;
        System.out.println(String.format(" split %d~%d ==> %d~%d, %d~%d",
                start, end, start, middle, middle, end));
        SumTask sumTask1= new SumTask(this.array, start, middle);
        SumTask sumTask2= new SumTask(this.array, middle, end);
        invokeAll(sumTask1,sumTask2);

        Long subres1=sumTask1.join();
        Long subres2=sumTask2.join();
        Long result = subres1 + subres2;
        System.out.println("result = " + subres1 + " + " + subres2 + " ==> " + result);
        return result;
    }
}
