package training.java.threads;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class linkedList{
    List<Integer> list =new LinkedList<>();
    static int count=0;
    public void add(int n) throws InterruptedException {
        list.add(n);
        count++;
        System.out.println(Thread.currentThread().getName()+" -> "+n+" time= "+count+" Size= "+list.size());
        Thread.sleep(500);
    }
}

public class testLinkedList {
    public static void main(String[] args){
        linkedList o=new linkedList();
        Random r=new Random();
        Thread th1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<20;i++) {
                    try {
                        o.add(r.nextInt(10));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread th2=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<20;i++) {
                    try {
                        o.add((r.nextInt(10)+10));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
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
        System.out.println("size"+ o.list.size());
        o.list.forEach((Integer value)->{
            System.out.print(value+" ");
        });
//        Iterator<Integer> i=o.list.iterator();
//        while(i.hasNext()){
//            System.out.print(i.next()+" ");
//        }
    }
}
