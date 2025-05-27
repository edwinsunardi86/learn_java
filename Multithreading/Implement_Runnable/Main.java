package Multithreading.Implement_Runnable;

class MyRunnable implements Runnable{
    public void run(){
        for(int i = 1; i <= 5; i++){
            System.out.println("Runnable: " + i);
        }
    }
}

public class Main {
    public static void main(String[] args){
        Runnable downloadTask = () -> {
            System.out.println("Mulai download...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Download Selesai");
        };

        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(downloadTask);

        t1.start();
        t2.start();

        System.out.println("Kode utama tetap jalan!");
    }
}
