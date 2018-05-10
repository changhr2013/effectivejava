package com.chr.test;

/**
 * Created by changhr2013 on 2018/4/2.
 */
public class SyncHalfTest {
    public void unSync(){
        int i=5;
        while(i-- >0){
            System.out.println(Thread.currentThread().getName()+" -> loop:"+i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void Sync(){
        synchronized (this){
            int i=5;
            while (i-- > 0){
                System.out.println(Thread.currentThread().getName()+" -> loop:"+i);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        final SyncHalfTest syncHalfTest = new SyncHalfTest();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                syncHalfTest.unSync();
            }
        },"A");
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                syncHalfTest.unSync();
            }
        },"B");

        t1.start();
        t2.start();
    }
}
