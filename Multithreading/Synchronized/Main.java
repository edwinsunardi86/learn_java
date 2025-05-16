package Multithreading.Synchronized;

class BankAccount {
    int balance = 3000;

    public synchronized void withdraw(int amount){
        if (balance >= amount){
            System.out.println(Thread.currentThread().getName() + " sedang menarik uang...");
            try{
                Thread.sleep(100);
            } catch (InterruptedException e){

            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " selesai. Sisa saldo: " + balance);

        } else {
            System.out.println(Thread.currentThread().getName() + " : saldo tidak cukup");
        }
    }
}

public class Main {
    public static void main(String[] args){
        BankAccount account = new BankAccount();

        Runnable task = new Runnable(){
            @Override
            public void run(){
                account.withdraw(700);
            }
        };

        Thread t1 = new Thread(task, "Nasabah 1");
        Thread t2 = new Thread(task, "Nasabah 2");
        Thread t3 = new Thread(task, "Nasabah 3");
        Thread t4 = new Thread(task, "Nasabah 4");
        Thread t5 = new Thread(task, "Nasabah 5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }    
}
