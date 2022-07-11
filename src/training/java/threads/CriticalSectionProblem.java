package training.java.threads;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LocalAccount {
    Lock lock1=new ReentrantLock();
    int amount;
    LocalAccount(){
        amount=10000;
    }
    LocalAccount(int a){
        amount=a;
    }

    public void deposit() throws InterruptedException {
        Random r1=new Random();
        Random r=new Random();
        while(true){
            Thread.sleep(2000);
            if(r1.nextInt(10)==5) {
                lock1.lock();
                try {
                    int n = r.nextInt(5000);
                    amount += n;
                    System.out.println("total amount after deposit: " + amount);
                }finally {
                    lock1.unlock();
                }
            }
        }
    }

    public void withdraw() throws InterruptedException {
        while (true){
            Thread.sleep(2000);
            Random r=new Random();
            lock1.lock();
            int n=r.nextInt(10000);
            if(amount>n) {
                amount-=n;
            }
            if(amount<1000){
                System.out.println("no amount to deposit");
            }
            System.out.println(n+" total amount after withdraw: "+amount);
            lock1.unlock();
        }
    }

}

public class CriticalSectionProblem {
    public static LocalAccount a=new LocalAccount(50000);
    public static void main(String[] args) throws InterruptedException {
        Thread producerThread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    a.deposit();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumerThread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    a.withdraw();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

    }
}
