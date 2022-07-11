package training.java.threads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ProducerConsumer {

    public static BlockingQueue queue =new ArrayBlockingQueue<Integer>(10);


    public static void producer() throws InterruptedException {
        Random r=new Random();
        int value;
        while(true){
            Thread.sleep(100);
            queue.put(value=r.nextInt(100));
            System.out.println("put: "+value+"  size: "+queue.size());
        }
    }

    public static void consumer() throws InterruptedException {
        Random r=new Random();
        while(true) {
            Thread.sleep(100);
            if (r.nextInt(3) == 0) {
                Integer value= (Integer) queue.take();
                System.out.println("take: "+value+"  size: "+queue.size());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread producerThread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumerThread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
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
