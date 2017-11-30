package com.potato.executor;

import java.sql.Time;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by potato on 2017/10/13.
 */
public class Calculator implements Callable {

    int i;

    public Calculator(int i) {
        this.i = i;
    }

    @Override
    public Object call() throws Exception {
        int result=0;
        for(int j=0;j<i;j++){
            result+=j;
        }
        TimeUnit.SECONDS.sleep(2);
        return result;
    }
}
