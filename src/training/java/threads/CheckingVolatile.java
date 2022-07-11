package training.java.threads;

import java.util.Scanner;

class Threading extends Thread{
    public boolean r=true;
    public String s;
    public void shutDown(){
        r=false;
    }
    public void run(){
        while(r){
            System.out.println("running"+s);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class CheckingVolatile {
    public static void main(String[] args){
        Threading a=new Threading();
        a.start();
        Scanner sc=new Scanner(System.in);
        a.s=sc.nextLine();
        System.out.println("hellof");
        a.shutDown();
    }

}
