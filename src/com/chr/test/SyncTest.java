package com.chr.test;

import java.util.stream.IntStream;

/**
 * Created by changhr2013 on 2018/4/2.
 */
public class SyncTest implements Runnable {
    @Override
    public void run() {
        synchronized (this){
            IntStream.range(0,3).forEach((i)->{
                System.out.println(Thread.currentThread().getName()+"->loop:"+i);
            });
        }
    }

    public static void main(String[] args) {
        SyncTest syncTest=new SyncTest();
        Thread t1=new Thread(syncTest,"A");
        Thread t2=new Thread(syncTest,"B");
        t1.start();
        t2.start();
    }
}
