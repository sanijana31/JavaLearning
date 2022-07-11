package training.java.threads;

import java.util.Random;

class Account{
    Object consumerLock=new Object();
    Object producerLock=new Object();
    int amount;
    Account(){
        amount=10000;
    }
    Account(int a){
        amount=a;
    }

    public void deposit() throws InterruptedException {
        Random r1=new Random();
        Random r=new Random();
        while(true){
            Thread.sleep(2000);
            if(r1.nextInt(10)==5) {
                int n = r.nextInt(5000);
                synchronized (this) {
                    amount += n;
                    System.out.println("total amount after deposit: " + amount);
                    notifyAll();
                }
            }
        }
    }

    public void withdraw() throws InterruptedException {
        while (true){
            Thread.sleep(2000);
            Random r=new Random();
            int n=r.nextInt(10000);
            synchronized (this){
                if(amount>n) {
                    amount-=n;
                }
                while(amount<1000){
                    System.out.println("no amount to deposit");
                    wait();
                }
                System.out.println(n+"total amount after withdraw: "+amount);
            }
        }
    }

}

public class WaitAndNotify {
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
