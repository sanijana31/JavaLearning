package training.java.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Processor{
    int str=0;
    public Lock lock1=new ReentrantLock();
    public Lock lock2=new ReentrantLock();
    public static int i=0;
    public void read() {
        while (true) {
            try {
                lock1.lock();
                lock2.lock();
                System.out.println("read String " + str);
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void write(){
        while (true) {
            try {
                lock2.lock();
                lock1.lock();
                str+=i++;
                System.out.println("writing done  " + str);
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }
}



public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        Processor p=new Processor();
        Thread th1=new Thread(new Runnable() {
            @Override
            public void run() {
                p.write();
            }
        });
        Thread th2=new Thread(new Runnable() {
            @Override
            public void run() {
                p.read();
            }
        });

        th1.start();
        th2.start();
        th1.join();
        th2.join();

    }
}
