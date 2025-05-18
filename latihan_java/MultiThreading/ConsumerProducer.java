package latihan_java.MultiThreading;

import java.util.ArrayList;
import java.util.List;

public class ConsumerProducer{
    private static List<Integer> buffer = new ArrayList<>();
    private static final int MAX_CAPACITY = 5;
    private static Object lock = new Object();

    static class Producer implements Runnable{
        private int value = 1;
        @Override
        public void run(){
            while (true) { 
                synchronized (lock) {
                    while(buffer.size() == MAX_CAPACITY){
                        try {
                            System.out.println("Buffer has full. Producer on waiting");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    buffer.add(value);
                    System.out.println("Product generate " + value);
                    value++;

                    lock.notify(); //beri tahu consumer 
                    try {
                        Thread.sleep(2000);  
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Consumer implements Runnable{
        @Override
        public void run(){
            while (true) { 
                synchronized (lock) {
                    while(buffer.isEmpty()){   
                        try {
                            System.out.println("Buffer is empty, Consumer on waiting");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    int data = buffer.remove(0);
                    System.out.println("Consumer mengambil " + data);

                    lock.notify(); //beri tahu producer
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }
        }
    }
    public static void main(String[] args){
        Thread producer = new Thread(new Producer());
        Thread consumer1 = new Thread(new Consumer());
        Thread consumer2 = new Thread(new Consumer());
        Thread consumer3 = new Thread(new Consumer());
        Thread consumer4 = new Thread(new Consumer());
        Thread consumer5 = new Thread(new Consumer());
        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
        consumer5.start();
        producer.start();
    }
}