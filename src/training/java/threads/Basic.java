package training.java.threads;

public class Basic extends Thread {
    String s;
    Basic(){
        s=new String();
    }
    public void run(){
        while(true){
            System.out.println("Running");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Main{
    public  static void main(String[] args){
        Basic a=new Basic();
        a.start();
        a.start();
    }
}
