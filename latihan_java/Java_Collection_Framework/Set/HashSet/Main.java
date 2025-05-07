package latihan_java.Java_Collection_Framework.Set.HashSet;

import java.util.Arrays;
import java.util.HashSet;
public class Main{
    public static void main(String[] args) {

        // // Soal 1
        // HashSet<Integer> numberElementUnique = new HashSet<>();
        // int[] nums = {1, 2, 2, 3, 4, 5, 5, 6, 7, 7};
        // boolean isDuplicate = false;
        // for(int number : nums){
        //     boolean isExist = false;
        //     for(int element : numberElementUnique){
        //         if(element == number){
        //             isExist = true;
        //             isDuplicate = true;
        //             break;
        //         }
        //     }

        //     if (!isExist) {
        //         numberElementUnique.add(number);       
        //     }
        // }

        // System.out.println(numberElementUnique.size());
        // System.out.println(isDuplicate);

        // // Soal 2
        // int[] arr1 = {1, 2, 3};
        // int[] arr2 = {3, 4, 5};
        // List<Integer> arrJoin = new ArrayList<>();
        
        // for(int num : arr1){
        //     arrJoin.add(num);
        // }

        // for(int num : arr2){
        //     arrJoin.add(num);
        // }

        // HashSet<Integer> arrayUnique = new HashSet<>();

        // for(int num : arrJoin){
        //     boolean isExist = false;
        //     for(int el : arrayUnique){
        //         if(num == el){
        //             isExist = true;
        //             break;
        //         }
        //     }

        //     if(!isExist){
        //         arrayUnique.add(num);
        //     }
        // }
        // System.out.println(arrayUnique);
        
        // //Soal 3
        // HashSet<Integer> power = new HashSet<>();
        // for(int a = 2; a <= arrJoin.size(); a++){
        //     for(int b = 2; b <= arrJoin.size(); b++){
        //         int resultPower = (int)Math.pow(a, b);
        //         power.add(resultPower);
        //     }
        // }

        // List<Integer> powerList = new ArrayList<>(power);
        // powerList.sort(Collections.reverseOrder());

        // for(int num : powerList){
        //     System.out.println(num);
        // }

        // Soal 4
        String words = "The quick brown fox jumps over the lazy dog.";
        String[] arrWord = words.replaceAll("[^a-zA-Z0-9 ]","").split("\\s+");

        System.out.println(Arrays.toString(arrWord));

        // Soal 5
        HashSet<String> uniqueWords = new HashSet<>();
        for(String word : arrWord){
            String lowerCaseWord = word.toLowerCase();
            uniqueWords.add(lowerCaseWord);
        }

        for(String word : uniqueWords){
            System.out.println(word);
        }
    }
}
