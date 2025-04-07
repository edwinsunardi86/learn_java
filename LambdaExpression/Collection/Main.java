package LambdaExpression.Collection;
import java.util.*;

public class Main {
    public static void main(String[] args){
        List<String> nama = Arrays.asList("Budi", "Andi", "Caca");

        // Sorting tanpa lambda
        Collections.sort(nama, new Comparator<String>(){
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        nama.forEach(b -> System.out.println("Nama :" + b));
    }
}
