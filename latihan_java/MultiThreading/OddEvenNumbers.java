package latihan_java.MultiThreading;

class OddThread extends Thread {
    private final int number;
    public OddThread(int number){
        this.number = number;
    }

    

    public boolean checkOddNumber(){
        return number % 2 != 0;
    }

    @Override
    public void run(){
        if(checkOddNumber() == true){
            System.out.println(number);
        }
    }
}

class EvenThread extends Thread {
    private final int number;
    public EvenThread(int number){
        this.number = number;
    }

    

    public boolean checkEvenNumber(){
        return number % 2 == 0;
    }

    @Override
    public void run(){
        if(checkEvenNumber() == true){
            System.out.println(number);
        }
    }
}

public class OddEvenNumbers {
    public static void main(String[] args){
        for(int i = 0; i <= 10; i++){
            OddThread oddThread = new OddThread(i);
            EvenThread evenThread = new EvenThread(i);
            if(oddThread.checkOddNumber()){
                oddThread.start();
                try {
                    oddThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(evenThread.checkEvenNumber()){
                evenThread.start();
                try {
                    evenThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
