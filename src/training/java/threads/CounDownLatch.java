package training.java.threads;

import java.util.concurrent.CountDownLatch;

class A extends Thread{
    static CountDownLatch l1;
    A(CountDownLatch l,String s){
        super(s);
        //this.l1=l;
    }
    public void run(){
        System.out.println("started: "+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished: "+Thread.currentThread().getName());
        l1.countDown();
    }
}
public class CounDownLatch {
    public static void main(String args[]){
        A.l1=new CountDownLatch(4);
        A obj1=new A(A.l1,"thread1");
        A obj2=new A(A.l1,"thread2");
        A obj3=new A(A.l1,"thread3");
        obj1.start();
        obj2.start();
        obj3.start();
        try {
            A.l1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish");

    }


}
