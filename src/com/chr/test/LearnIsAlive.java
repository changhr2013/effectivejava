package com.chr.test;

/**
 * Created by changhr2013 on 2018/4/1.
 */
public class LearnIsAlive {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread=new MyThread();
        System.out.println("begin: "+myThread.isAlive());
        myThread.start();
//        myThread.sleep(1000);
        System.out.println("end: "+myThread.isAlive());
    }
}

