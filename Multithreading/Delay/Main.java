package Multithreading.Delay;

public class Main {
    public static void main(String[] args){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run(){
                try {
                for(int i = 1; i <= 5; i++){
                    System.out.println("Thread : " + i);
                    Thread.sleep(2000);
                }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        t1.start();
    }
}
