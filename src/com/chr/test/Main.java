package com.chr.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Main {
    private static int num=100;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        System.out.println("Hello World!");
//        ExecutorService executorService= Executors.newFixedThreadPool(2);
//        IntStream.range(0,3).forEach(i->executorService.execute(()->{
//            try {
//                TimeUnit.SECONDS.sleep(1);
//                String threadName = Thread.currentThread().getName();
//                IntStream.range(1,4).forEach(value-> System.out.println(value));
//                System.out.println("finished: " + threadName);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }));

//        ExecutorService executorService=Executors.newSingleThreadExecutor();
//        IntStream.range(0,100).forEach(i->executorService.execute(()->{
//            String runnableName="Runnable:"+i+":";
//            System.out.println(runnableName+num--);
//        }));
//
//        try {
//            executorService.shutdown();
//            executorService.awaitTermination(5,TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }finally {
//            if(!executorService.isTerminated()){
//                executorService.shutdownNow();
//            }
//        }
//
//        System.out.println("执行结束！");

//        ScheduledExecutorService scheduledExecutorService=Executors.newScheduledThreadPool(3);
//        IntStream.range(0,2).forEach(i->scheduledExecutorService.scheduleAtFixedRate(()->{
//            String threadName=Thread.currentThread().getName();
//            System.out.println("finished"+threadName);
//        },1000,3000,TimeUnit.MILLISECONDS));

//        ExecutorService executorService=Executors.newCachedThreadPool();
//        IntStream.range(1,10).forEach(i->executorService.execute(()->{
//            String threadName=Thread.currentThread().getName();
//            System.out.println("finished:"+threadName);
//        }));

        System.out.println("程序运行开始...");
        Date startDate = new Date();
        ExecutorService executorService=Executors.newFixedThreadPool(6);
//        ExecutorService executorService=Executors.newSingleThreadExecutor();
        List<Future> fList=new ArrayList<Future>();
        for (int i = 0; i < 6; i++) {
            if(i%2==1){
                Callable callable=new MyCallable(i+"");
                Future future=executorService.submit(callable);
                fList.add(future);
            }else{
                Callable callable=new LongCallable(i+"");
                Future future=executorService.submit(callable);
                fList.add(future);
            }
        }
        executorService.shutdown();

        for (Future future :
                fList) {
            System.out.println(">>>"+future.get().toString());
        }

        Date endDate=new Date();
        long allTime = endDate.getTime() - startDate.getTime();
        System.out.println("<<<程序运行结束，总运行时间：["+allTime+"]ms.");

    }

    static class MyCallable implements Callable<Object>{

        private String taskNum;

        MyCallable(String taskNum){
            this.taskNum=taskNum;
        }

        @Override
        public Object call() throws Exception {
            System.out.println(">>>任务"+taskNum+"开始执行...");
            Date sDate=new Date();
            //Thread.currentThread().sleep(1000);
            Date eDate=new Date();
            long usedTime = eDate.getTime() - sDate.getTime();
            System.out.println("<<<任务"+taskNum+"执行完成OK");
            return taskNum+"任务返回运行结果,当前任务时间：["+usedTime+"]ms";
        }
    }

    static class LongCallable implements Callable<String>{

        private String taskNum;

        LongCallable(String taskNum){
            this.taskNum=taskNum;
        }

        @Override
        public String call() throws Exception {
            Date sDate=new Date();
            int length=0;
            switch (taskNum){
                case "0":length=1000;break;
                case "2":length=3000;break;
                case "4":length=6000;break;
            }
            String sum="";
            for (int i = 1; i <= length; i++) {
                sum+=i;
            }
            Date eDate=new Date();
            long usedTime = eDate.getTime() - sDate.getTime();
            return "["+usedTime+"]ms  "+"1+2+3+...+100000="+sum;
        }
    }

}
