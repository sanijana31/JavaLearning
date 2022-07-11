package training.java.threads;

import java.util.Random;

class AccountDetails{
    int amount;
    AccountDetails(){
        amount=10000;
    }
    AccountDetails(int a){
        amount=a;
    }
    public synchronized void changeAmount() throws InterruptedException {
        Random r=new Random();
        int a;
        while(true){
            boolean condition=r.nextBoolean();
            if(condition){
                amount+=r.nextInt(1000);
            }
            else{
                if(amount>(a=r.nextInt(1000))){
                    amount-=a;
                }
            }
            System.out.println("ChangeAmount: "+amount);
            notifyAll();
            wait();
            Thread.sleep(2000);
        }
    }

    public synchronized void display() throws InterruptedException {
        while (true){
            System.out.println("Display: "+amount);
            Thread.sleep(2000);
            notifyAll();
            wait();
        }
    }


        }

public class AssignmentOnThread{
    public static void main(String[] args) throws InterruptedException {
        AccountDetails obj=new AccountDetails(50000);
        Thread th1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.changeAmount();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread th2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    obj.display();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        th2.start();
        th1.start();
        th1.join();
        th2.join();
    }
}
