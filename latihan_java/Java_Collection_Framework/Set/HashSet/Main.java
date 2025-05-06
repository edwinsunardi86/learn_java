package latihan_java.Java_Collection_Framework.Set.HashSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public class Main{
    public static void main(String[] args) {

        // Soal 1
        HashSet<Integer> numberElementUnique = new HashSet<>();
        int[] nums = {1, 2, 2, 3, 4, 5, 5, 6, 7, 7};
        boolean isDuplicate = false;
        for(int number : nums){
            boolean isExist = false;
            for(int element : numberElementUnique){
                if(element == number){
                    isExist = true;
                    isDuplicate = true;
                    break;
                }
            }

            if (!isExist) {
                numberElementUnique.add(number);       
            }
        }

        System.out.println(numberElementUnique.size());
        System.out.println(isDuplicate);

        // Soal 2
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {3, 4, 5};
        List<Integer> arrJoin = new ArrayList<>();
        
        for(int num : arr1){
            arrJoin.add(num);
        }

        for(int num : arr2){
            arrJoin.add(num);
        }

        HashSet<Integer> arrayUnique = new HashSet<>();

        for(int num : arrJoin){
            boolean isExist = false;
            for(int el : arrayUnique){
                if(num == el){
                    isExist = true;
                    break;
                }
            }

            if(!isExist){
                arrayUnique.add(num);
            }
        }
        System.out.println(arrayUnique);
    }
}
