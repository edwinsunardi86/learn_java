package latihan_java.MultiThreading;

public class PingPong {
    static int iPing = 0;
    static int iPong = 0;
    public static void main(String[] args) {
        Object lock = new Object();
        
        Thread t1 = new Thread(
            new Runnable() {
                @Override
                public void run(){
                    synchronized (lock){
                        while(iPing < 5){
                            System.out.println("Ping");
                            iPing++;
                            if (iPing > iPong) {
                                lock.notify();
                            }
                            try {
                                Thread.sleep(2000);
                                lock.wait();
                            } catch (InterruptedException e) {
                            }
                        }
                    }
                }
            }
        );

        Thread t2 = new Thread(
            new Runnable() {
                @Override
                public void run(){
                    synchronized (lock){
                        while(iPong < 5){
                            System.out.println("Pong");
                            iPong++;
                            if (iPing == iPong) {
                                lock.notify();
                            }
                            try {
                                Thread.sleep(2000);
                                lock.wait();
                            } catch (InterruptedException e) {
                            }
                        }
                    }
                }
            }
        );

        t1.start();
        t2.start();
    }
}
