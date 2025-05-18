package latihan_java.MultiThreading;

public class DeadLock {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args){
        Thread t1 = new Thread(
            new Runnable() {
                @Override
                public void run(){
                    synchronized (lock1) {
                        System.out.println("Thread 1: locked lock1");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }

                        synchronized (lock2) {
                            System.out.println("Thread 2: locked lock2");
                            try {
                                Thread.sleep(1000);
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
                    synchronized (lock2) {
                        System.out.println("Thread 2: locked lock2");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }

                        synchronized (lock1) {
                            System.out.println("Thread 2: locked lock1");
                            try {
                                Thread.sleep(1000);
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