package com.chr.test;

public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("run "+this.isAlive());
    }
}
