package training.java.threads;

public class BasicRunneble implements Runnable{
    String s;
    BasicRunneble(String s){
        this.s=s;
    }
    @Override
    public void run() {
        while(true){
            System.out.println("Running"+s);
            System.out.println(s+"Running");
            System.out.println(s+"Running"+s);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Main1{
    public  static void main(String[] args){
        Thread t1=new Thread(new BasicRunneble("thread1"));
        Thread t2=new Thread(new BasicRunneble("thread2"));
        t1.start();
        t2.start();
    }
}
