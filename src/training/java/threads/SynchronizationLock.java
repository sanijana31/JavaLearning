package training.java.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;

public class SynchronizationLock extends Thread{
    Object lock1=new Object();
    Object lock2=new Object();

    List<Integer> l1=new ArrayList<>();
    List<Integer> l2=new ArrayList<>();
    Random r=new Random();
    public void addList1(){
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            l1.add(r.nextInt(1000));
        }
    }
    public void addList2(){
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            l2.add(r.nextInt(1000));
        }
    }
    public void callAdd(){
        for(int i=0;i<1000;i++){
            addList1();
            addList2();
        }
    }
//    public void run(){
//        callAdd();
//    }
    public static void main(String[] args){
        SynchronizationLock o=new SynchronizationLock();
        long t1=System.currentTimeMillis();
        Thread th1=new Thread(new Runnable() {
            @Override
            public void run() {
                o.callAdd();
            }
        });
        Thread th2=new Thread(new Runnable() {
            @Override
            public void run() {
                o.callAdd();
            }
        });
        th1.start();
        th2.start();
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        try {
//            o.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        long t2=System.currentTimeMillis();
        System.out.println("time= " +(t2-t1)+ "\n l1->" +o.l1.size()+ " l2->" +o.l1.size());
    }
}
