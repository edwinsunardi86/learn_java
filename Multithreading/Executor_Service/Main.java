package Multithreading.Executor_Service;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args){
        // ExecutorService executor = Executors.newFixedThreadPool(2);

        // Runnable task1 = new Runnable() {
        //     @Override
        //     public void run(){
        //         System.out.println("Task 1 dimulai: ");
        //         try{
        //             Thread.sleep(3000);
        //         } catch (InterruptedException e){}
        //         System.out.println("Task 1 selesai");
        //     }
        // };

        // Runnable task2 = () -> {
        //     System.out.println("Task 2 dimulai: ");
        //     try{
        //         Thread.sleep(3000);
        //     } catch (InterruptedException e) {}
        //     System.out.println("Task 2 selesai");
        // };

        // executor.submit(task1);
        // executor.submit(task2);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        for(int i = 1; i <= 5; i++){
            executor.submit(()->{
                System.out.println("Task jalan: " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();
    }    
}
