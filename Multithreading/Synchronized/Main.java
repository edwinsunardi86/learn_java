package Multithreading.Synchronized;

class BankAccount {
    int balance = 1000;

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

        t1.start();
        t2.start();
    }    
}
