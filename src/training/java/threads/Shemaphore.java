package training.java.threads;

import java.util.concurrent.*;

class Connetion{
    public static Connetion c=new Connetion();
    Semaphore sem=new  Semaphore(5,true);
    int count=0;

    public Connetion getInstance(){
        return c;
    }
    public void connect(){
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this){
            System.out.println("connection in "+Thread.currentThread().getName()+"\n****  "+(++count));
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this){
            System.out.println("hi");
            count--;
        }
        sem.release();
    }
}

public class Shemaphore {

    public static void main(String[] args){
        ExecutorService executor= Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    Connetion.c.connect();
                }
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
