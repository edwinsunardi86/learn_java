package latihan_java.Java_Collection_Framework.Map.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args){
        
        String[] fruits = {"apel", "jeruk", "apel", "mangga", "jeruk", "apel"};
        int[] numbers = {1,2,3,1,4,2,5,3,2,3,6};
       
        HashMap<String, Integer> countFruit = (HashMap<String, Integer>) Arrays.stream(fruits).distinct().collect(Collectors.toMap(fruit-> fruit, fruit -> (int)Arrays.stream(fruits).filter(n -> n.equalsIgnoreCase(fruit)).count()));
        // countFruit.forEach((name,length)->System.out.println(name + " : " + length));
        
        HashMap<Integer, Integer> countNumber = new HashMap<>();
        boolean isDuplicate = false;
        for(int number : numbers){
            boolean exist = false;
            for(int key : countNumber.keySet()){
                if (key == number){
                    countNumber.put(key, countNumber.get(key) + 1);
                    exist = true;
                    isDuplicate = true;
                    break;
                }
            }
            if(!exist){
                countNumber.put(number,1);
            }
        }
        for(int key: countNumber.keySet()){
            System.out.println(key + " = " + countNumber.get(key));
        }

        System.out.println(countFruit);
        System.out.println(isDuplicate);
    } 
}
