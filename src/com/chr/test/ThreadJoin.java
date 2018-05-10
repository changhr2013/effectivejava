package com.chr.test;

/**
 * Created by changhr2013 on 2018/4/1.
 */
public class ThreadJoin extends Thread{

    public ThreadJoin(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName()+"--"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ThreadJoin("new thread").start();
        for (int i = 0; i < 10; i++) {
            if(i==5){
                ThreadJoin joinThread=new ThreadJoin("join Thread");
                joinThread.start();
//                joinThread.join();
            }
            System.out.println(Thread.currentThread().getName()+"=="+i);
        }
    }
}
