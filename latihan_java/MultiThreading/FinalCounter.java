package latihan_java.MultiThreading;
class CounterMaxNumber{
    int counter = 0;

    public void setCounter(){
        int i = 0;
        while(i < 1000){
            synchronized (this) {
                counter++;
            }
            i++;
        }
    }

    public void result(){
        System.out.println("Final Counter: " + counter);
    }
}

public class FinalCounter {
    public static void main(String[] args){
        CounterMaxNumber counterMaxNumber = new CounterMaxNumber();
        Runnable task = new Runnable() {
            @Override
            public void run(){
                counterMaxNumber.setCounter();
            }
        };

        Thread t1 = new Thread(task,"Thread 1 : ");
        Thread t2 = new Thread(task, "Thread 2 : ");
        Thread t3 = new Thread(task, "Thread 3 : ");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        counterMaxNumber.result();
    }
}
