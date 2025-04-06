package LambdaExpression.Collection;
import java.util.*;

public class Main {
    public static void main(String[] args){
        List<String> nama = Arrays.asList("Budi", "Andi", "Caca");

        nama.forEach(b -> System.out.println("Nama :" + b));
    }
}
