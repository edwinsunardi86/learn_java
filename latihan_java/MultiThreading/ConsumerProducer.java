package latihan_java.MultiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class DataNumbers{
    List<Integer> sourceDataNumber = new ArrayList<>();
    List<Integer> pickUp = new ArrayList<>();
    List<Integer> historyConsumptionData = new ArrayList<>();
    int number;
    // public DataNumbers(int pickup){
    //     this.pickup = pickup;
    // }

    public synchronized void consumption(int number){
        this.number = number;
        pickUp.add(number);
        boolean filterList = sourceDataNumber.stream().filter(n -> n.equals(this.number)).collect(Collectors.toList()).isEmpty();
        while(!filterList){
            try {
                System.out.println("On waiting data: " + number);
                wait();
            } catch (InterruptedException e) {
            }
        }
        
        boolean isExist = false;
        for(int i = 0; i < sourceDataNumber.size(); i++){
            if(sourceDataNumber.get(i).equals(number)){
                isExist = true;
                sourceDataNumber.remove(i);
            }
        }
        if(isExist){
            historyConsumptionData.add(number);
            System.out.println("Data number "+ number +" has been consumption");
        }

        System.out.println(filterList);
    }

    public synchronized void producerNumber(int number){
        sourceDataNumber.add(number);
        
        System.out.println("production : " + sourceDataNumber);
        
        // if(!filterList){
            notify();
        // }
    }
}
public class ConsumerProducer{
    public static void main(String[] args){
        DataNumbers dataNumbers = new DataNumbers();
        Thread consumption1 = new Thread(new Runnable() {
            @Override
            public void run(){
                dataNumbers.consumption(10);
            }
        });
        Thread producer1 = new Thread(new Runnable() {
           @Override
           public void run(){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            dataNumbers.producerNumber(10);
           } 
        });

        Thread consumption2 = new Thread(()->{
            dataNumbers.consumption(35);
        });

        Thread producer2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            dataNumbers.producerNumber(20);
        });
        consumption1.start();
        producer1.start();
        // producer2.start();
        // consumption2.start();

    }
}